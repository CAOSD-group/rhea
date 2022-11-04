import time

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
from rhea.refactorings import utils

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

MODEL_TO_TEST = "JHipster"

INPUT_PATH = 'fm_models/' + MODEL_TO_TEST + '.uvl'
OUTPUT_PATH = 'fm_models/tmp/'  + MODEL_TO_TEST + '_output.uvl'
UNIQUE_PATH = 'fm_models/tmp/'  + MODEL_TO_TEST + '_unique.uvl'
##################################################################################################


def apply_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i, instance in enumerate(instances, 1):
        print(f'   |->Instance {i}: {str(instance)}')
        fm = refactoring.transform(fm, instance)
    return fm

def apply_specific_refactoring(fm: FeatureModel, refactoring: FMRefactoring, ctc: int) -> FeatureModel:
    instance = refactoring.get_instances(fm)[ctc]
    fm = refactoring.transform(fm, instance)
    return fm


def print_statistics(fm: FeatureModel, model_name: str) -> None:
    fm_helper = FM(fm)
    sat_model = FmToPysat(fm).transform()

    print(f'******************** {model_name} ********************')
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
    try:
        bdd_model = FmToBDD(fm).transform()
        n_exact_configurations = BDDProductsNumber().execute(bdd_model).get_result()
        print(f'#BDD Exact configurations: {n_exact_configurations}')
    except:
        print(f'BDD fails.')
    
    n_configurations = FMEstimatedProductsNumber().execute(fm).get_result()
    print(f'#FM Estimated configurations: {n_configurations}')

    if n_exact_configurations <= 50:
        configurations = Glucose3Products().execute(sat_model).get_result()
        print(f'SAT Configurations:')
        for i, p in enumerate(configurations, 1):
            print(f'C{i}: {[str(f) for f in p]}')
        print('----------')
        products = fm_utils.filter_products(fm, configurations)
        print(f'SAT Products:')
        for i, p in enumerate(products, 1):
            features_list = [str(f) for f in p]
            features_list.sort()
            print(f'P{i}: {features_list}')
        print('----------')
    print(f'****************************************')


def main():
    fm = UVLReader(INPUT_PATH).transform()
    print_statistics(fm, 'INPUT MODEL')
    
    start_time = time.perf_counter_ns()
    print('==================================================')
    print(f'Applying the refactoring {REFACTORING_SPLIT.get_name()}...')
    print(f'  |-> refactorings: {len(REFACTORING_SPLIT.get_instances(fm))}')
    fm = apply_refactoring(fm, REFACTORING_SPLIT)
    print(f'Applying the refactoring {REFACTORING_COMPLEX.get_name()}...')
    print(f'  |-> refactorings: {len(REFACTORING_COMPLEX.get_instances(fm))}')
    fm = apply_refactoring(fm, REFACTORING_COMPLEX)
    UVLWriter(fm, "Pizzas_complex1.uvl").transform()
    print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()}...')
    print(f'  |-> refactorings: {len(REFACTORING_REQUIRES.get_instances(fm))}')
    fm = apply_refactoring(fm, REFACTORING_REQUIRES)
    print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()}...')
    print(f'  |-> refactorings: {len(REFACTORING_EXCLUDES.get_instances(fm))}')
    fm = apply_refactoring(fm, REFACTORING_EXCLUDES)
    print('==================================================')
    end_time = time.perf_counter_ns()

    # Remove leaf abstract features
    fm = fm_utils.remove_leaf_abstract_features(fm)

    # Print output model
    print_statistics(fm, 'OUTPUT MODEL')
    UVLWriter(fm, OUTPUT_PATH).transform()

    # Print output model with unique features
    fm = utils.to_unique_features(fm)
    print_statistics(fm, 'UNIQUE NAMES MODEL')
    UVLWriter(fm, UNIQUE_PATH).transform()

    print(f'Execution time of all refactorings: {(end_time-start_time)/1e9} s.')
if __name__ == '__main__':
    main()