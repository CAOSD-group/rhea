from email.base64mime import body_decode
from email.contentmanager import raw_data_manager
import os, time
import statistics
from typing import Any
from weakref import ref 

from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from rhea.refactorings import FMRefactoring

from raw_data_writer import RawDataCSVWriter

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
REFACTORING_MUTEX = MutexGroupRefactoring
REFACTORING_CARDINALITY = CardinalityGroupRefactoring
REFACTORING_MULT_GROUP_DECOMP = MultipleGroupDecompositionRefactoring
REFACTORING_XOR_MAND = XorMandatoryRefactoring
REFACTORING_OR_MAND = OrMandatoryRefactoring
REFACTORING_ANY_CTCS = EliminationAnyConstraints
REFACTORING_SPLIT = SplitConstraint
REFACTORING_COMPLEX = EliminationComplexConstraints
REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes
MODEL_PATH = 'tests/models/requires/input_models/Pizzas3.uvl'
OUTPUT_PATH = os.path.basename(MODEL_PATH)
##################################################################################################


# def execution_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
#     instances = refactoring.get_instances(fm)
#     for i in instances:
#         fm = refactoring.transform(fm, i)
#     return fm
    

MODEL_PATH = 'tests/models/mutex_groups/input_models/mg02.uvl' # ESTO LUEGO TENGO QUE PREGUNTARLO POR TECLADO
statis_data = {}
statis_list = []

def main(fm_path: str, statis_data_dict: dict, statis_list: list[dict]):
    # Create path to the output file
    fm_basename = os.path.basename(fm_path)
    fm_name = fm_basename[:fm_basename.find('.')]  # Remove extension
    output_path = os.path.join('tests/raw_output', fm_name + RawDataCSVWriter.get_destination_extension())
    
    # Load the feature model
    if MODEL_PATH.endswith('.gfm.json'):
        fm = GlencoeReader(MODEL_PATH).transform()
    elif MODEL_PATH.endswith('.uvl'):
        fm = UVLReader(MODEL_PATH).transform()
    elif MODEL_PATH.endswith('.xml'):
        fm = FeatureIDEReader(MODEL_PATH).transform()
    else:
        raise Exception(f'Error, invalid model {MODEL_PATH}.')

    REFACTORING_MUTEX = MutexGroupRefactoring
    REFACTORING_CARDINALITY = CardinalityGroupRefactoring
    REFACTORING_MULT_GROUP_DECOMP = MultipleGroupDecompositionRefactoring
    REFACTORING_XOR_MAND = XorMandatoryRefactoring
    REFACTORING_OR_MAND = OrMandatoryRefactoring
    REFACTORING_ANY_CTCS = EliminationAnyConstraints
    REFACTORING_SPLIT = SplitConstraint
    REFACTORING_COMPLEX = EliminationComplexConstraints
    REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
    REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes

    # list_refactorings = [REFACTORING_MUTEX, REFACTORING_CARDINALITY, REFACTORING_MULT_GROUP_DECOMP, 
    #                     REFACTORING_XOR_MAND, REFACTORING_OR_MAND, REFACTORING_ANY_CTCS,
    #                     REFACTORING_SPLIT, REFACTORING_COMPLEX, REFACTORING_REQUIRES, 
    #                     REFACTORING_EXCLUDES]

    raw_data = {}
    raw_data_dict = {}
    for run in range(30):
        raw_data = set_raw_data(run, fm, fm_name, REFACTORING_MUTEX, raw_data)
        raw_data_dict[run] = raw_data
    statis_data = set_statis_data(raw_data_dict)
    statis_list.append(statis_data)

    ct_str = RawDataCSVWriter(path=output_path, raw_data_dict=raw_data_dict).transform()
    
    # Print the result (optional)
    # print(ct_str)

def set_raw_data(run: int, fm: FeatureModel, fm_name: str, refactoring: FMRefactoring, raw_data: dict) -> dict:
    raw_data['FM'] = fm_name
    raw_data['Run'] = run
    raw_data['Features'] = len(fm.get_features())

    fm_refact = execution_refactoring(fm, refactoring)

    raw_data['Features Refactored'] = len(fm_refact.get_features())
    raw_data['Constraints'] = len(fm.get_constraints())
    raw_data['Constraints Refactored'] = len(fm_refact.get_constraints())
    raw_data['Execution time'] = execution_time(fm, refactoring)

    print(raw_data)

    return raw_data

def set_statis_data(raw_data: dict[dict]) -> dict:
    statis_data = {}
    statis_data['FM'] = raw_data[0]['FM']
    statis_data['Run'] = len(raw_data)
    statis_data['Features'] = raw_data[0]['Features']
    statis_data['Average Features Refactored'] = statistics.mean([raw_data[run]['Features Refactored']
                                                    for run in raw_data])
    statis_data['Constraints'] = raw_data[0]['Constraints']
    statis_data['Average Constraints Refactored'] = statistics.mean([raw_data[run]['Constraints Refactored']
                                                    for run in raw_data])
    statis_data['Average Execution Time'] = statistics.mean([raw_data[run]['Execution time']
                                                    for run in raw_data])

    print(statis_data)

    return statis_data


def execution_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm

def execution_time(fm: FeatureModel, refactoring: FMRefactoring):
    # calculate statistics
    start = time.perf_counter_ns()
    fm = execution_refactoring(fm, refactoring)
    end = time.perf_counter_ns()
    total_time = (end - start)*1e-9
    return total_time


if __name__ == '__main__':
    main(MODEL_PATH, statis_data, statis_list)