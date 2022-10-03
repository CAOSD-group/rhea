import os
import inspect
import importlib
from typing import Optional
from xml.etree.ElementTree import tostring

from flask import Flask, flash, render_template, request, redirect, send_from_directory, url_for, session, make_response
from flask_cors import CORS, cross_origin
from flask_sqlalchemy import SQLAlchemy
#from flask_session import Session
from werkzeug.utils import secure_filename
from flask_caching import Cache

from flamapy.metamodels.fm_metamodel.models import FeatureModel
from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader
from requests import JSONDecodeError

from rhea.metamodels.fm_metamodel.transformations import JSONWriter, JSONReader
from rhea import refactorings


#COOKIE_SESSION = 'UserID'
FEATURE_MODEL_SESSION = 'FeatureModel'
UPLOAD_FOLDER = '/tmp'
ALLOWED_EXTENSIONS = {'uvl', 'xml'}


static_url = ''
static_dir = 'template'
static_folder = 'web'
#static_dir = 'web'



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
# Session
app.config['SECRET_KEY'] = b'_5#y2L"F4Q8z\n\xec]/'
#app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///db.sqlite3'
#app.config['SESSION_TYPE'] = 'sqlalchemy'
#db = SQLAlchemy(app)
#app.config['SESSION_SQLALCHEMY'] = db
#sess = Session(app)
#db.create_all()



cache.set("my_value", 1_000_000)
my_value = cache.get("my_value")

<<<<<<< HEAD
=======
#db.create_all()
>>>>>>> 0b1417a263b45357ae3339df9c7f6e1e1ad72e36


def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS


def read_fm_file(filename: str) -> Optional[FeatureModel]:
    try:
        if filename.endswith(".uvl"):
            print("UVL file type (.uvl)")
            return UVLReader(filename).transform()
        elif filename.endswith(".xml") or filename.endswith(".fide"):
            print("FeatureIDE file type (.xml, .fide).")
            return FeatureIDEReader(filename).transform()
        elif filename.endswith('.gfm.json'):
            print("Glencoe file type (.gfm.json).")
            return GlencoeReader(filename).transform()
    except:
        print("Invalid FM format.")
        pass
    try:
        return UVLReader(filename).transform()
    except:
        pass
    try:
        return FeatureIDEReader(filename).transform()
    except:
        pass
    try:
        return GlencoeReader(filename).transform()
    except:
        pass
    return None

#order : saveFM;downloadFM;deleteFM;createFM;

@cross_origin
@app.route('/refactor', methods=['POST'])
def refactor():
    # codigo = request.form['session']
    # if codigo is None:
    #     return None
    # my_value = cache.get(codigo)
    # if my_value==None:
    #     # if not there in the session then redirect to the login page
    #     print('There is no session.')
    #     return None
    # fm = my_value
    if request.method == 'POST':
        # Get parameters
        fm_hash = request.form['fm_hash']
        class_name = request.form['refactoring_id']
        instance_name = request.form['instance_name']
        print(fm_hash)
        fm = cache.get(fm_hash)
        print(fm)
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
        instance = fm.get_feature_by_name(instance_name)
        if instance is None:
            instance = next((ctc for ctc in fm.get_constraints() if ctc.name == instance_name), None)
        if instance is None:
            print('Invalid feature/constraint identifier.')
            return None
        fm = class_.transform(fm, instance)
        #session[FEATURE_MODEL_SESSION] = fm
        fm_hash = hash(fm)
        cache.set(fm_hash, fm)
        json_fm = JSONWriter(path=None, source_model=fm).transform()
        response = make_response(json_fm)
        #response.headers.add('Access-Control-Allow-Headers', "Origin, X-Requested-With, Content-Type, Accept, x-auth")
        #response.set_cookie(key='FM', value=str(fm_hash))
        return response
    return None


@cross_origin
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


@app.route('/downloadFM2', methods=['POST'])
def download2_feature_model():
    if request.method == 'POST':
        json_model = request.data.decode() 
        if json_model:
            print('Error en JSONReader ')
            print('Error en JSONReader ')
            print('Error en JSONReader ')
            print('Error en JSONReader ')
            print('Error en JSONReader ')
            print('Error en JSONReader ')
            print('Error en JSONReader ')
            fm = JSONReader.parse_json(json_model)
            print(fm)
            UVLWriter(fm, path=fm.root.name).transform()
            return send_from_directory('.', fm.root.name, as_attachment=True)


@app.route('/saveFM', methods=['GET', 'POST'])
def save_feature_model():
    if request.method == 'GET':
        texto=request.data.decode() 
        return texto
    if request.method == 'POST':
        texto=request.data.decode() 
        print(request.files.values())                    
        fm_file = request.from_values(texto)
        print("hola mundo")
        fm = read_fm_file(texto)
        print(fm)                          
        if fm is not None:
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            print("entrego json")
            return json_fm
        print(texto)
        return "true"


@app.route('/downloadFM', methods=['GET', 'POST'])
def download_feature_model():
    texto = None
    #fm = read_fm_file(filepath)
    #print(fm)
    #texto = str(fm)
    data = {}
    if request.method == 'GET':
        return texto
    if request.method == 'POST': # enviar como texto
        texto=request.data.decode()   #transforma el bytes a string
        #print(texto)                          devuelve Pizzas.uvl         
        #print(request)                        devuelve <Request 'http://172.16.51.94:5000/upload' [POST]>
        fm_file = request.from_values(texto)  #devuelve <Request 'http://localhost/Pizzas.uvl' [GET]>
        fm = read_fm_file(texto)              #devuelve el arbol en tipo relation R0: .. R1: ... CTC0:... CTC1: ...
        if fm is not None:
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            #print(json_fm)                    devuelve el arbol con formato "name": algo , "type": otro
            print("devuelvo el json_fm")
            return json_fm
        print("devuelvo el texto")
        return texto
        if not fm_file:
            # The file is required and this is controlled in the front-end.
            data['file_error'] = 'Please upload a feature model or select one from the examples.'
            return render_template('index.html', data=data)

        if fm_file:
            filename = fm_file.filename
            fm_file.save(filename)
       
        try:
            # Read the feature model
            fm = read_fm_file(filename)
            if fm is None:
                data['file_error'] = 'Feature model format not supported.'
                return render_template('index.html', data=data)

        except Exception as e:
            data = None
            print(e)
            raise e
        
        return render_template('index.html', data=data)

@app.route('/deleteFM', methods=['GET', 'POST'])
def delete_feature_model():
    if request.method == 'GET':
        return "texto"
    if request.method == 'POST':
        return "post delete"

@app.route('/createFM', methods=['GET', 'POST'])
def create_feature_model():
    if request.method == 'GET':
        return "texto"
    if request.method == 'POST':
        return "post create"


if __name__ == '__main__':
    # app.debug = True
    # app.run(host='0.0.0.0', port=5555)
    app.run(host='0.0.0.0',debug=True)