from asyncio.windows_events import NULL
import json
from pickle import TRUE
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


@app.route('/', methods=['GET', 'POST'])
def index():
    texto = None
    #fm = read_fm_file(filepath)
    #print(fm)
    #texto = str(fm)
    data = {}
    if request.method == 'GET':
        if texto is None:
            texto = "ser o no ser"
        if request.data is not None:
            texto = "ser o no ser"
        return texto

    if request.method == 'POST':
        texto=request.data.decode()   #transforma el bytes a string
        #fm_file = request.files[texto].name
        fm_file = request.from_values(texto)
        fm = read_fm_file(texto)
        if fm is not None:
            json_fm = JSONWriter(path=None, source_model=fm).transform()
            #print (json_fm)
            print(json_fm.__class__)
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