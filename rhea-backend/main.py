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

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings.mutex_group_refactoring import MutexGroupRefactoring
from rhea.refactorings.cardinality_group_refactoring import CardinalityGroupRefactoring
from rhea.refactorings.multiple_group_decomposition_refactoring import MultipleGroupDecompositionRefactoring
from rhea.refactorings.xor_mandatory_refactoring import XorMandatoryRefactoring
from rhea.refactorings.or_mandatory_refactoring import OrMandatoryRefactoring
from rhea.refactorings.elimination_all_constraints import EliminationAllConstraints
from rhea.refactorings.elimination_complex_constraints import EliminationComplexConstraints
from rhea.refactorings.elimination_simple_ctcs_requires import EliminationSimpleConstraintsRequires
from rhea.refactorings.elimination_simple_ctcs_excludes import EliminationSimpleConstraintsExcludes


##################################################################################################
REFACTORING_ALL = EliminationAllConstraints
REFACTORING_COMPLEX = EliminationComplexConstraints
REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes
MODEL_PATH = 'tests/models/elimination_all_constraints/input_models/JHipster.uvl'
OUTPUT_PATH = 'output.uvl'
OUTPUT_CONSOLE = 'output.txt'
##################################################################################################



def apply_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    # print(f'Constraints: {[str(c) for c in fm.get_constraints()]}')
    # print(f'Instances: {[str(i) for i in instances]}')
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm


def print_fm_numbers(fm: FeatureModel, expected_results: dict[str, Any] = None) -> dict[str, Any]:
    bdd_model = FmToBDD(fm).transform()
    n_exact_configurations = BDDProductsNumber().execute(bdd_model).get_result()
    print(f'#Exact configurations: {n_exact_configurations}')

    #fm_without_references = remove_references(fm)
    n_configurations = FMEstimatedProductsNumber().execute(fm).get_result()
    print(f'#Estimated configurations: {n_configurations}')

    assert n_exact_configurations == n_configurations


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
    products = fm_utils.filter_products(fm, configurations)
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
        assert n_products == expected_results['n_products']
        for p in products:
            assert p in expected_results['products']
        for p in expected_results['products']:
            assert p in products
        # assert products == expected_results['products']
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
        fm = FeatureIDEReader(MODEL_PATH).transform()
    else:
        raise Exception(f'Error, invalid model {MODEL_PATH}.')

    expected_results = print_fm(fm)

    # Apply the refactoring
    print('==================================================')
    print(f'Applying the refactoring {REFACTORING_ALL.get_name()}...')
    fm = apply_refactoring(fm, REFACTORING_ALL)
    print(f'Applying the refactoring {REFACTORING_COMPLEX.get_name()}...')
    fm = apply_refactoring(fm, REFACTORING_COMPLEX)
    print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()}...')
    fm = apply_refactoring(fm, REFACTORING_REQUIRES)
    print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()}...')
    fm = apply_refactoring(fm, REFACTORING_EXCLUDES)
    print('==================================================')
    #UVLWriter(fm, OUTPUT_PATH).transform()
    print_fm(fm, expected_results)
    UVLWriter(fm, OUTPUT_PATH).transform()


if __name__ == '__main__':
    main()