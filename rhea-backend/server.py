import os
import inspect
import importlib
import json
import tempfile
import subprocess
import sys
from typing import Optional

from flask import Flask, request, redirect, make_response, jsonify
from flask_cors import CORS
from werkzeug.utils import secure_filename
from flask_caching import Cache

from afmparser import main as aux_parser

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Constraint
from flamapy.core.models.ast import AST, Node
from flamapy.metamodels.fm_metamodel.transformations import (
    UVLReader, 
    UVLWriter, 
    FeatureIDEReader, 
    GlencoeReader,
    GlencoeWriter,
    SPLOTWriter
)

from rhea.metamodels.fm_metamodel.transformations import JSONWriter, JSONReader, FeatureIDEWriter
from rhea.refactorings import utils
from rhea import refactorings


FEATURE_MODEL_SESSION = 'FeatureModel'
UPLOAD_FOLDER = 'tmp'
ALLOWED_EXTENSIONS = {'uvl', 'xml', 'json', 'gfm.json', 'sxfm.xml'}
EXAMPLE_MODELS_DIR = 'fm_models'

static_url = ''
static_dir = 'template'
static_folder = 'web'


config = {
         # some Flask specific configs
    "CACHE_TYPE": "filesystem",  # Flask-Caching related configs
    "CACHE_DIR": '/tmp', 
    "CACHE_DEFAULT_TIMEOUT": 3000  # 50 minutes
}
app = Flask(__name__)
app.config.from_mapping(config)
cache = Cache(app)

#app = Flask(__name__,static_url_path=static_url,static_folder=static_folder,template_folder=static_dir)
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
CORS(app, supports_credentials=True)    

@app.route('/api/checktextcons', methods=['POST']) #Check cons button method
def check_text_cons():
    if request.method != 'POST':
        return None
    else:
        text=request.form['text']
        result=str(True)
        #result=str(checkGoodConstraints())  #Replace checkGoodConstraints() by method that checks constraints and delete line avobe
        return result           #the receiving method needs a string
    
@app.route('/api/createcons', methods=['POST'])
def create_new_cons():
    if request.method != 'POST':
        return None
    else:

        ctc_string=request.form['text'] #string to parse
        fm_hash=request.form['fm_hash']
        name=request.form['name']
        fm:FeatureModel = cache.get(fm_hash)

        #auxCreateConsMain(fm, ctc_string)
        
        #ctc: Constraint = parse_text_cons(ctc_string)
        #fm.ctcs.append(ctc)
   
        return "true" #fm #returns arraybufer, blob, document or json - also text, etc (no boolean values accepted)

#AUX createcons    
def auxCreateConsMain(fm, ctc_string):

    #JUST FOR TESTING
    #checkFMConstraints(fm)
    
    #OPTION 1: NODE->AST->CONSTRAINT - Problem: Needs UVL reader
    fromNodeToConstraint(ctc_string)

    #OPTION 2: Write file, then parse
    #fm_string = write_fm_file(fm, "uvl")            

    #OPTION 3: AFM PARSER (Still receives path and not FM Tree)
    #aux_tree = aux_parser.get_tree(ctc_string)
    
#AUX createcons 
def checkFMConstraints(fm):
    constr_list:list[Constraint] = fm.get_constraints() 
    #for ct in constr_list: print(ct.ast, type(ct.ast)) #Each constraint has a name/identifier and an AST - Class 'flamapy.core.models.ast.AST' 

#1-AUX createcons 
def fromNodeToConstraint(ctc_string):
    uvl_reader=UVLReader("")
    expression = uvl_reader._parse_expression(ctc_string)
    print(expression)
    #node_aux = Node(ctc_string)                 # n has the attribute n.data
    #ast_aux = AST(node_aux)                     # EXAMPLE AST: IMPLIES[AND[CheesyCrust][Sicilian]][Big] # Retuns string equals to prettyfied string; needs fixing


#AUX createcons - NOTES
def parse_text_cons(ctc_string):
    #uvl_reader = UVLReader(None)               # uvl_fm = UVLReader(filename).transform() # This does not seem to work for this case - unless a new method is based in the methods of the existing readers
    #print(uvl_reader)  
    fm = UVLReader(None).transform()
    print(ctc_string)
    return True
    

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
    elif format == 'xml':
        temporal_filepath = tempfile.NamedTemporaryFile(mode='w', encoding='utf8').name
        result = FeatureIDEWriter(source_model=fm, path=temporal_filepath).transform()
    return result

@app.route('/api/getExampleFMs', methods=['GET'])
def get_example_feature_models():
    if request.method != 'GET':
        return None
    else:
        models = get_example_models()
        response = make_response(json.dumps(models))
        return response

@app.route('/api/updateServer', methods=['POST'])
def update_server():
    if request.method != 'POST':
        return None
    else:
        subprocess.call("./example.bash")
        return "hello world"


@app.route('/api/uploadExampleFM', methods=['POST'])
def upload_example_feature_model():
    if request.method != 'POST':
        jsonify({'error': 'Not a POST methos'}), 404
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


@app.route('/api/uploadFM', methods=['POST'])
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
            filepath = secure_filename(filepath)
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


@app.route('/api/updateFM', methods=['POST'])
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
            filepath = secure_filename(filepath)
            file.save(filepath)
            fm = read_fm_file(filepath)
            os.remove(filepath)
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            response = make_response(json_fm)
            hash_fm = hash(fm)
            cache.set(str(hash_fm), fm)
            return response
    return None


@app.route('/api/refactor', methods=['POST'])
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

        #ctcs_list = fm.get_constraints()
        #ctcs_list[0].ast.pretty_str()

        cache.set(str(fm_hash), fm)
        return response
    return None

    
@app.route('/api/downloadFM', methods=['POST'])
def download_feature_model():
    if request.method != 'POST':
        return jsonify({'error': 'Not a POST method'}), 404
    else:
        # Get parameters
        fm_hash = request.form['fm_hash']
        fm_format = request.form['fm_format']  # 'uvl', 'xml', 'json', 'gfm.json', 'sxfm.xml'
        fm = cache.get(fm_hash)
        if fm is None:
            print('FM expired.')
            return jsonify({'error': f'FM expired for hash "{fm_hash}"'}), 404
        fm_str = write_fm_file(fm, fm_format)
        # print(fm_str)
        if fm_str is None:
            return jsonify({'error': 'Object not found'}), 404
        response = make_response(fm_str)
        print(response.data)
        return response


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000) #5555

