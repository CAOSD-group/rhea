from email.base64mime import body_decode
import os
from typing import Any 

from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader
from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products,
    Glucose3Valid
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
from rhea.refactorings.elimination_any_constraint import EliminationAnyConstraints
from rhea.refactorings.split_constraint import SplitConstraint
from rhea.refactorings.elimination_complex_constraints import EliminationComplexConstraints
from rhea.refactorings.elimination_simple_ctcs_requires import EliminationSimpleConstraintsRequires
from rhea.refactorings.elimination_simple_ctcs_excludes import EliminationSimpleConstraintsExcludes


##################################################################################################
REFACTORING_ANY_CTCS = EliminationAnyConstraints
REFACTORING_SPLIT = SplitConstraint
REFACTORING_COMPLEX = EliminationComplexConstraints
REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes
MODEL_PATH = 'tests/models/requires/input_models/test1.uvl'
OUTPUT_PATH = os.path.basename(MODEL_PATH)
##################################################################################################


def apply_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm

def apply_specific_refactoring(fm: FeatureModel, refactoring: FMRefactoring, ctc: int) -> FeatureModel:
    instance = refactoring.get_instances(fm)[ctc]
    fm = refactoring.transform(fm, instance)
    return fm


def print_statistics(fm: FeatureModel) -> None:
    fm_helper = FM(fm)
    sat_model = FmToPysat(fm).transform()

    print(f'Valid: {Glucose3Valid().execute(sat_model).get_result()}')
    print(f'#Features: {len(fm_helper.fm.get_features())}')
    print(f'#Relations: {len(fm_helper.fm.get_relations())}')
    print(f'#Constraints: {len(fm_helper.get_constraints())}')
    print(f'|-#Simple: {len(fm_helper.get_simple_constraints())}')
    print(f'  |-#Requires: {len(fm_helper.get_requires_constraints())}')
    print(f'  |-#Excludes: {len(fm_helper.get_excludes_constraints())}')
    print(f'|-#Complex: {len(fm_helper.get_complex_constraints())}')
    print(f'  |-#Pseudo-Complex: {len(fm_helper.get_pseudocomplex_constraints())}')
    print(f'  |-#Strict-Complex: {len(fm_helper.get_strictcomplex_constraints())}')
    
    bdd_model = FmToBDD(fm).transform()
    n_exact_configurations = BDDProductsNumber().execute(bdd_model).get_result()
    print(f'#BDD Exact configurations: {n_exact_configurations}')
    
    n_configurations = FMEstimatedProductsNumber().execute(fm).get_result()
    print(f'#FM Estimated configurations: {n_configurations}')

    # if n_exact_configurations <= 50:
    #     configurations = Glucose3Products().execute(sat_model).get_result()
    #     print(f'SAT Configurations:')
    #     for i, p in enumerate(configurations, 1):
    #         print(f'C{i}: {[str(f) for f in p]}')
    #     print('----------')
    #     products = fm_utils.filter_products_from_dict(fm, configurations)
    #     products = fm_utils.filter_products_from_dict(fm, configurations)
    #     print(f'SAT Products:')
    #     for i, p in enumerate(products, 1):
    #         features_list = [str(f) for f in p]
    #         features_list.sort()
    #         print(f'P{i}: {features_list}')
    #     print('----------')


def main():
    fm = UVLReader(MODEL_PATH).transform()
    
    # print(fm)
    print_statistics(fm)
    
    print('==================================================')
    print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()}...')
    fm = apply_refactoring(fm, REFACTORING_REQUIRES)
    print('==================================================')

    # print('==================================================')
    # print(f'Applying the refactoring {REFACTORING_ANY_CTCS.get_name()}...')
    # fm = apply_specific_refactoring(fm, REFACTORING_ANY_CTCS, 0)
    # print('==================================================')

    # print('==================================================')
    # ctc = fm.get_constraints()[0]
    # print(f'Applying the refactoring {REFACTORING_COMPLEX.get_name()} for {ctc.ast.pretty_str()}...')
    # fm = REFACTORING_COMPLEX.transform(fm, ctc)
    # # print('==================================================')
    # print(f'FM_JOSEMI: {fm}')
    # UVLWriter(fm, "salida1.uvl").transform()

    # # print('==================================================')
    # ctc = next((c for c in fm.get_constraints() if fm_utils.is_requires_constraint(c)), None)
    # print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()} for {ctc.ast.pretty_str()}...')
    # fm = REFACTORING_REQUIRES.transform(fm, ctc)
    # # print('==================================================')

    # UVLWriter(fm, "salida2.uvl").transform()

    # # print('==================================================')
    # ctc = next((c for c in fm.get_constraints() if fm_utils.is_excludes_constraint(c)), None)
    # print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()} for {ctc.ast.pretty_str()}...')
    # fm = REFACTORING_EXCLUDES.transform(fm, ctc)
    # # print('==================================================')

    # UVLWriter(fm, "salida3.uvl").transform()

    # # print('==================================================')
    # ctc = next((c for c in fm.get_constraints() if fm_utils.is_excludes_constraint(c)), None)
    # print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()} for {ctc.ast.pretty_str()}...')
    # fm = REFACTORING_EXCLUDES.transform(fm, ctc)
    # # print('==================================================')

    print_statistics(fm)

    # print(fm)
    UVLWriter(fm, OUTPUT_PATH).transform()


if __name__ == '__main__':
    main()