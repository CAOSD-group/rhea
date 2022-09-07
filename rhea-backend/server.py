from typing import Optional
from xml.etree.ElementTree import tostring

from flask import Flask, render_template, request, send_from_directory
from flask_cors import CORS

from flamapy.metamodels.fm_metamodel.models import FeatureModel
from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader
from requests import JSONDecodeError

from rhea.flamapy.metamodels.fm_metamodel.transformations.json_writer import JSONWriter
from rhea.flamapy.metamodels.fm_metamodel.transformations.json_reader import JSONReader


static_url = ''
static_dir = 'template'
static_folder = 'web'
#static_dir = 'web'


app = Flask(__name__,
            static_url_path=static_url,
            static_folder=static_folder,
            template_folder=static_dir)
CORS(app)


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


@app.route('/uploadFM', methods=['POST'])
def upload_feature_model():
    if request.method == 'POST':
        fm_file = request.files['inputFM']  # 'inputFM' is the name of the parameter in the POST request from the frontend
        if fm_file:
            filename = fm_file.filename
            fm_file.save(filename)
            fm = read_fm_file(filename)
            if fm is None:
                json_fm = JSONWriter(path=None, source_model=fm).transform()
                return json_fm


@app.route('/downloadFM2', methods=['POST'])
def download2_feature_model():
    if request.method == 'POST':
        json_model = request.data.decode() 
        if json_model:
            fm = JSONReader.parse_json(json_model)
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
        return texto


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