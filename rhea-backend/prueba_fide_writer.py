from email.base64mime import body_decode
import os
from typing import Any 

from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader, XMLReader
from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.bdd_metamodel.operations import (
    BDDProductsNumber
)

from flamapy.metamodels.fm_metamodel.operations import FMEstimatedProductsNumber
from flamapy.metamodels.bdd_metamodel.transformations import FmToBDD
from flamapy.metamodels.bdd_metamodel.operations import BDDProductsNumber

from flamapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.metamodels.fm_metamodel.models import fm_utils
from rhea.metamodels.fm_metamodel.transformations.featureide_writer import FeatureIDEWriter



MODEL_PATH = 'fm_models/Pizzas.uvl'
MODEL_PATH2 = 'fm_models/JHipster.uvl'

def main():
    model_path = MODEL_PATH2
 
    fm = UVLReader(model_path).transform()
    bdd_model = FmToBDD(fm).transform()
    n_products = BDDProductsNumber().execute(bdd_model).get_result()
    print(f'#Products (UVL): {n_products}')

    FeatureIDEWriter('pruebaFeatureIDE.xml', fm).transform()
    fm_fide = FeatureIDEReader('pruebaFeatureIDE.xml').transform()
    if fm == fm_fide:
        print(f'Equals.')
    else:
        print(f'Differents.')

    bdd_model_fide = FmToBDD(fm_fide).transform()
    n_products = BDDProductsNumber().execute(bdd_model_fide).get_result()
    print(f'#Products (FIDE): {n_products}')


if __name__ == '__main__':
    main()