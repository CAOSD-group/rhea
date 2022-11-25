import os
import inspect
import importlib
import json
import tempfile
from typing import Optional

from flask import Flask, request, redirect, make_response
from flask_cors import CORS
from werkzeug.utils import secure_filename
from flask_caching import Cache

from flamapy.metamodels.fm_metamodel.models import FeatureModel
from flamapy.metamodels.fm_metamodel.transformations import (
    UVLReader, 
    UVLWriter, 
    FeatureIDEReader, 
    GlencoeReader,
    GlencoeWriter,
    SPLOTWriter
)

from rhea.metamodels.fm_metamodel.transformations import JSONWriter, JSONReader
from rhea.refactorings import utils
from rhea import refactorings


FEATURE_MODEL_SESSION = 'FeatureModel'
UPLOAD_FOLDER = '/tmp'
ALLOWED_EXTENSIONS = {'uvl', 'xml', 'json', 'gfm.json', 'sxfm.xml'}
EXAMPLE_MODELS_DIR = 'fm_models'

static_url = ''
static_dir = 'template'
static_folder = 'web'


config = {
    "DEBUG": True,          # some Flask specific configs
    "CACHE_TYPE": "SimpleCache",  # Flask-Caching related configs
    "CACHE_DEFAULT_TIMEOUT": 300
}
app = Flask(__name__)
app.config.from_mapping(config)
cache = Cache(app)

#app = Flask(__name__,static_url_path=static_url,static_folder=static_folder,template_folder=static_dir)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
CORS(app, supports_credentials=True)


def get_example_models() -> list[str]:
    models = []
    for root, dirs, files in os.walk(os.path.join(EXAMPLE_MODELS_DIR)):
        for file in files:
            #filepath = os.path.join(root, file)
            models.append(file)
    # Put a specific model first:
    pizza_model = next((m for m in models if m == 'Pizzas with refactorings.json'), None)
    if pizza_model is not None:
        models.remove(pizza_model)
        models.insert(0, pizza_model)
    return models


def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS


def read_fm_file(filename: str) -> Optional[FeatureModel]:
    """Read a feature model object from a file in the sopported formats."""
    if filename.endswith('.uvl'):
        return UVLReader(filename).transform()
    elif filename.endswith('.sxfm.xml'):
        return None
    elif filename.endswith('.xml') or filename.endswith('.fide'):
        return FeatureIDEReader(filename).transform()
    elif filename.endswith('.gfm.json'):
        return GlencoeReader(filename).transform()
    elif filename.endswith('.json'):
        return JSONReader(filename).transform()
    else:
        return None


def write_fm_file(fm: FeatureModel, format: str) -> str:
    """Write a feature model object to a temporal file and returns its content.
    
    This is required because the current Writter always writes to file, and the front-end needs
    the content directly.
    """
    result = None
    #temporal_filepath = f'FM_{fm.root.name}_temp.{format}'
    if format == 'uvl':
        uvl_writer = UVLWriter(source_model=fm, path=None)
        result = uvl_writer.read_features(fm.root, "features", 0) + "\n" + uvl_writer.read_constraints()
    elif format == 'gfm.json':
        temporal_filepath = tempfile.NamedTemporaryFile(mode='w', encoding='utf8').name
        result = GlencoeWriter(source_model=fm, path=temporal_filepath).transform()
        print(result)
    elif format == 'sxfm.xml':
        temporal_filepath = tempfile.NamedTemporaryFile(mode='w', encoding='utf8').name
        result = SPLOTWriter(source_model=fm, path=temporal_filepath).transform()
    elif format == 'json':
        result = JSONWriter(source_model=fm, path=None).transform()
    return result

@app.route('/getExampleFMs', methods=['GET'])
def get_example_feature_models():
    if request.method != 'GET':
        return None
    else:
        models = get_example_models()
        response = make_response(json.dumps(models))
        return response


@app.route('/uploadExampleFM', methods=['POST'])
def upload_example_feature_model():
    if request.method != 'POST':
        return None
    else:
        # Get parameters
        filename = request.form['filename']
        filepath = os.path.join(EXAMPLE_MODELS_DIR, filename)
        fm = read_fm_file(filepath)
        json_fm = JSONWriter(path=None, source_model=fm).transform()
        response = make_response(json_fm)
        hash_fm = hash(fm)
        cache.set(str(hash_fm), fm)
        return response


@app.route('/uploadFM', methods=['POST'])
def upload_feature_model():
    if request.method == 'POST':
        # check if the post request has the file part
        if 'file' not in request.files:
            print('No file part')
            return redirect(request.url)
        file = request.files['file']
        # If the user does not select a file, the browser submits an empty file without a filename.
        if file.filename == '':
            print('No selected file')
            return redirect(request.url)
        if file and allowed_file(file.filename):
            filename = secure_filename(file.filename)
            filepath = os.path.join(app.config['UPLOAD_FOLDER'], filename) 
            file.save(filepath)
            fm = read_fm_file(filepath)
            os.remove(filepath)
            # record the feature model for the session
            #session[FEATURE_MODEL_SESSION] = 'hola'
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            response = make_response(json_fm)
            #response.headers.add('Access-Control-Allow-Headers', "Origin, X-Requested-With, Content-Type, Accept, x-auth")
            #session_id = request.cookies.get(COOKIE_SESSION)
            hash_fm = hash(fm)
            cache.set(str(hash_fm), fm)
            #response.set_cookie(key='FM', value=str(hash_fm))
            return response
            #return redirect(url_for('uploadFM', name=filename))
    return None


@app.route('/updateFM', methods=['POST'])
def updateFeature():
    if request.method == 'POST':
        # Get parameters
        # check if the post request has the file part
        if 'file' not in request.files:
            return redirect(request.url)
        file = request.files['file']
        if file.filename.endswith('.json'):
            filename = secure_filename(file.filename)
            filepath = os.path.join(app.config['UPLOAD_FOLDER'], filename) 
            file.save(filepath)
            fm = read_fm_file(filepath)
            os.remove(filepath)
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            response = make_response(json_fm)
            hash_fm = hash(fm)
            cache.set(str(hash_fm), fm)
            return response
    return None


@app.route('/refactor', methods=['POST'])
def refactor():
    if request.method == 'POST':
        # Get parameters
        fm_hash = request.form['fm_hash']
        class_name = request.form['refactoring_id']
        instance_name = None
        if 'instance_name' in request.form:
            instance_name = request.form['instance_name']
        fm = cache.get(fm_hash)
        if fm is None:
            print('FM expired.')
            return None

        modules = inspect.getmembers(refactorings)
        modules = filter(lambda x: inspect.ismodule(x[1]), modules)
        modules = [importlib.import_module(m[1].__name__) for m in modules]
        class_ = next((getattr(m, class_name) for m in modules if hasattr(m, class_name)), None)
        if class_ is None:
            print('Invalid identifier for refactoring.')
            return None
        if instance_name is not None:  # Refactor a specific instance (feature or constraint)
            instance = fm.get_feature_by_name(instance_name)
            if instance is None:
                instance = next((ctc for ctc in fm.get_constraints() if ctc.name == instance_name), None)
            if instance is None:
                print('Invalid feature/constraint identifier.')
                return None
            fm = class_.transform(fm, instance)
        else:  # Refactor all
            fm = utils.apply_refactoring(fm, class_)
        json_fm = JSONWriter(path=None, source_model=fm).transform()
        response = make_response(json_fm)
        fm_hash = hash(fm)
        cache.set(str(fm_hash), fm)
        return response
    return None

    
@app.route('/downloadFM', methods=['POST'])
def download_feature_model():
    if request.method != 'POST':
        return None
    else:
        # Get parameters
        fm_hash = request.form['fm_hash']
        fm_format = request.form['fm_format']  # 'uvl', 'xml', 'json', 'gfm.json', 'sxfm.xml'
        fm = cache.get(fm_hash)
        if fm is None:
            print('FM expired.')
            return None
        fm_str = write_fm_file(fm, fm_format)
        if fm_str is None:
            return None
        response = make_response(fm_str)
        return response


if __name__ == '__main__':
    # app.debug = True
    # app.run(host='0.0.0.0', port=5555)
    app.run(host='0.0.0.0',debug=True)
