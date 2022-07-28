from asyncio.windows_events import NULL
import json
from pickle import TRUE
import re
import string
from subprocess import CREATE_NEW_CONSOLE
from types import NoneType
from typing import Optional
from urllib import response
from xml.etree.ElementTree import tostring

from flask import Flask, flash, jsonify, render_template, request
from flask_cors import CORS

from famapy.metamodels.fm_metamodel.models import FeatureModel
from famapy.metamodels.fm_metamodel.transformations import UVLReader, FeatureIDEReader, GlencoeReader
from requests import JSONDecodeError

from rhea.flamapy.metamodels.fm_metamodel.transformations.json_writer import JSONWriter


static_url=''
static_dir = 'template'
static_folder='web'
#static_dir = 'web'


app = Flask(__name__,static_url_path=static_url,static_folder=static_folder,template_folder=static_dir)
CORS(app)

def read_fm_file(filename: str) -> Optional[FeatureModel]:
    try:
        if filename.endswith(".uvl"):
            print("archivo tipo .uvl")
            return UVLReader(filename).transform()
        elif filename.endswith(".xml") or filename.endswith(".fide"):
            print("archivo tipo .xml o .fide")
            return FeatureIDEReader(filename).transform()
        elif filename.endswith('.gfm.json'):
            print("archivo tipo .gfm.json")
            return GlencoeReader(filename).transform()
    except:
        print("no se ha hecho el try")
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


@app.route('/saveFM', methods=['GET', 'POST'])
def save_feature_model():
    if request.method == 'GET':
        texto=request.data.decode() 
        return texto

    if request.method == 'POST':
        texto=request.data.decode() 
        #print(request)                      <Request 'http://172.16.51.94:5000/saveFM' [POST]>
        #print(texto)                         arbol con formato texto
        fm_file = request.from_values(texto)
        #print(fm_file)                   # <Request 'http://localhost/namespace%20Pizza%0A%0Afeatures%0A%09Pizza%20%7Babstract%7D%09%0A%09%09mandatory%0A%09%09%09Topping%09%0A%09%09%09%09or%0A%09%09%09%09%09Salami%0A%09%09%09%09%09Ham%0A%09%09%09%09%09Mozzarella%0A%09%09%09Size%09%0A%09%09%09%09alternative%0A%09%09%09%09%09Normal%0A%09%09%09%09%09Big%0A%09%09%09Dough%09%0A%09%09%09%09alternative%0A%09%09%09%09%09Neapolitan%0A%09%09%09%09%09Sicilian%0A%0A%09%09optional%0A%09%09%09CheesyCrust%0A%0Aconstraints%0A%09CheesyCrust%20%3D%3E%20Big' [GET]>
        print("hola mundo")
        #fm = read_fm_file(fm_file)
        fm = read_fm_file(texto)
        print(fm)                          # None si hago fm_file o texto
        if fm is not None:
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            print("entrego json")
            return json_fm
        print("texto")
        return texto


@app.route('/upload', methods=['GET', 'POST'])
def index():
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


if __name__ == '__main__':
    # app.debug = True
    # app.run(host='0.0.0.0', port=5555)
    app.run(host='0.0.0.0',debug=True)