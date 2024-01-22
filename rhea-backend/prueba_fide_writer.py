from email.base64mime import body_decode
import os
from typing import Any 

from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader
from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

from flamapy.metamodels.fm_metamodel.operations import FMEstimatedProductsNumber
from flamapy.metamodels.bdd_metamodel.transformations import FmToBDD
from flamapy.metamodels.bdd_metamodel.operations import BDDProductsNumber

from flamapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.metamodels.fm_metamodel.models import fm_utils
from rhea.metamodels.fm_metamodel.transformations.featureide_writer import FeatureIDEWriter

MODEL_PATH = 'fm_models/Pizzas.uvl'

def main():
    fm = UVLReader(MODEL_PATH).transform()

    FeatureIDEWriter('Pizzas.xml', fm).transform()

if __name__ == '__main__':
    main()