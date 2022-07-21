import os
from typing import Any 

from famapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader
from famapy.metamodels.pysat_metamodel.transformations import FmToPysat
from famapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

from famapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.refactorings import Refactoring
from rhea.refactorings.mutex_group_refactoring import MutexGroupRefactoring
from rhea.refactorings.cardinality_group_refactoring import CardinalityGroupRefactoring
from rhea.refactorings.multiple_group_decomposition_refactoring import MultipleGroupDecompositionRefactoring
from rhea.refactorings.xor_mandatory_refactoring import XorMandatoryRefactoring
from rhea.refactorings.or_mandatory_refactoring import OrMandatoryRefactoring

from rhea.flamapy.metamodels.fm_metamodel.transformations import GlencoeReader


##################################################################################################
REFACTORING = XorMandatoryRefactoring
MODEL_PATH = 'tests/models/xor_mandatory/input_models/xor_mandatory_BC4.gfm.json'
OUTPUT_PATH = 'output.uvl'
OUTPUT_CONSOLE = 'output.txt'
##################################################################################################


def apply_refactoring(fm: FeatureModel, refactoring: Refactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm


def filter_products(fm: FeatureModel, configurations: list[list[Any]]) -> set[set[Any]]:
    filtered_configs = set()
    for config in configurations:
        c = {f for f in config if not fm.get_feature_by_name(f).is_abstract}
        filtered_configs.add(frozenset(c))
    return filtered_configs


def print_fm(fm: FeatureModel, expected_results: dict[str, Any] = None) -> dict[str, Any]:
    print(f'FM:\n{fm}----------')
    
    sat_model = FmToPysat(fm).transform()
    configurations = Glucose3Products().execute(sat_model).get_result()
    print(f'Configurations:')
    for i, p in enumerate(configurations):
        print(f'P{i}: {[str(f) for f in p]}')
    print('----------')
    n_configurations = Glucose3ProductsNumber().execute(sat_model).get_result()
    print(f'#Configurations: {n_configurations}')
    print('----------')
    products = filter_products(fm, configurations)
    print(f'Products:')
    for i, p in enumerate(products):
        print(f'P{i}: {[str(f) for f in p]}')
    print('----------')
    n_products = len(products)
    print(f'#Products: {n_products}')

    if expected_results is None:
        expected_results = {}
        expected_results['products'] = products
        expected_results['n_products'] = n_products
        return expected_results
    else:
        assert products == expected_results['products']
        assert n_products == expected_results['n_products']
        return None
    

def main():
    # if os.path.exists(OUTPUT_PATH):
    #     os.remove(OUTPUT_PATH)
    # if os.path.exists(OUTPUT_CONSOLE):
    #     os.remove(OUTPUT_CONSOLE)

    if MODEL_PATH.endswith('.gfm.json'):
        fm = GlencoeReader(MODEL_PATH).transform()
    elif MODEL_PATH.endswith('.uvl'):
        fm = UVLReader(MODEL_PATH).transform()
    elif MODEL_PATH.endswith('.xml'):
        fm = FeatureIDEReader(MODEL_PATH)
    else:
        raise Exception(f'Error, invalid model {MODEL_PATH}.')

    expected_results = print_fm(fm)

    # Apply the refactoring
    print('==================================================')
    print(f'Applying the refactoring {REFACTORING.get_name()}...')
    fm = apply_refactoring(fm, REFACTORING)
    print('==================================================')
    #UVLWriter(fm, OUTPUT_PATH).transform()
    print_fm(fm, expected_results)
    UVLWriter(fm, OUTPUT_PATH).transform()


if __name__ == '__main__':
    main()