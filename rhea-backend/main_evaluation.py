import copy
from email.base64mime import body_decode
from email.contentmanager import raw_data_manager
import os, time
import statistics
from typing import Any
from weakref import ref

from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter, FeatureIDEReader, GlencoeReader
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from rhea.refactorings import FMRefactoring

from flamapy.metamodels.bdd_metamodel.transformations import FmToBDD
from flamapy.metamodels.bdd_metamodel.operations import BDDProductsNumber

from raw_data_writer import RawDataCSVWriter
from statis_data_writer import StatisticsDataCSVWriter

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
ROUND_DIGITS = 8
NANO_TO_SECONDS = 1e-9

# def execution_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
#     instances = refactoring.get_instances(fm)
#     for i in instances:
#         fm = refactoring.transform(fm, i)
#     return fm
    
MAIN_INDEX = 1
TIME = 'Time (s)'

def main(raw_path: str, statis_list: list[dict]):
    # Create path to the output file RAW DATA
    fm_basename = os.path.basename(raw_path)
    fm_name = fm_basename[:fm_basename.find('.')]  # Remove extension
    output_raw_path = os.path.join('tests/raw_output', fm_name + RawDataCSVWriter.get_destination_extension())
    
    # Load the feature model
    if MODEL_PATH.endswith('.gfm.json'):
        fm = GlencoeReader(MODEL_PATH).transform()
    elif MODEL_PATH.endswith('.uvl'):
        fm = UVLReader(MODEL_PATH).transform()
    elif MODEL_PATH.endswith('.xml'):
        fm = FeatureIDEReader(MODEL_PATH).transform()
    else:
        raise Exception(f'Error, invalid model {MODEL_PATH}.')

    dict_refactorings = {'mutex': REFACTORING_MUTEX, 'cardinality':REFACTORING_CARDINALITY,
                         'decomposition': REFACTORING_MULT_GROUP_DECOMP, 
                         'xor_mand': REFACTORING_XOR_MAND, 'or_mand': REFACTORING_OR_MAND, 
                         'any_ctcs': REFACTORING_ANY_CTCS, 'split': REFACTORING_SPLIT, 
                         'complex': REFACTORING_COMPLEX, 'requires': REFACTORING_REQUIRES, 
                         'exludes': REFACTORING_EXCLUDES}

    raw_data_dict = {}
    refact_input = input(f'Refactoring ({[k for k in dict_refactorings.keys()]}): ')
    refactoring = dict_refactorings[refact_input]

    # Create path to the output file STATIS DATA
    fm_basename = os.path.basename(raw_path)
    fm_name = fm_basename[:fm_basename.find('.')]  # Remove extension
    output_statis_path = os.path.join('tests/statis_output', f'statis_output_{refact_input}' 
                                      + StatisticsDataCSVWriter.get_destination_extension())

    n_run = int(input("Number of run: "))
    for run in range(1, n_run+1):
        fm_copy = copy.deepcopy(fm)
        raw_data = set_raw_data(run, fm_copy, fm, fm_name, refactoring)
        raw_data_dict[run] = raw_data
    statis_data = set_statis_data(raw_data_dict)
    statis_list.append(statis_data)

    raw_str = RawDataCSVWriter(path=output_raw_path, raw_data_dict=raw_data_dict).transform()
    statis_str = StatisticsDataCSVWriter(path=output_statis_path, data_list=statis_list).transform()
    
    # Print the result (optional)
    # print(ct_str)

def set_raw_data(run: int, fm_copy: FeatureModel, fm: FeatureModel, fm_name: str, refactoring: FMRefactoring) -> dict:
    raw_data = {}
    bdd_model = FmToBDD(fm).transform()
    raw_data['FM'] = fm_name
    raw_data['Run'] = run
    raw_data['Features'] = len(fm.get_features())
    raw_data['Abstract Features'] = len([f for f in fm.get_features() if f.is_abstract])

    start = time.perf_counter_ns()
    fm_copy = execution_refactoring(fm_copy, refactoring)
    end = time.perf_counter_ns()
    total_time = (end - start)*1e-9

    bdd_model_copy = FmToBDD(fm_copy).transform()

    raw_data['Features Refactored'] = len(fm_copy.get_features())
    raw_data['Abstract Features Refactored'] = len([f for f in fm_copy.get_features()
                                                    if f.is_abstract])
    raw_data['Constraints'] = len(fm.get_constraints())
    raw_data['Constraints Refactored'] = len(fm_copy.get_constraints())
    raw_data['Configurations'] = BDDProductsNumber().execute(bdd_model).get_result()
    raw_data['Configurations Refactored'] = BDDProductsNumber().execute(bdd_model_copy).get_result()
    raw_data['Execution time'] = total_time

    return raw_data

def set_statis_data(raw_data: dict[dict]) -> dict:
    statis_data = {}
    statis_data['FM'] = raw_data[MAIN_INDEX]['FM']
    statis_data['Run'] = len(raw_data)
    statis_data['Features'] = raw_data[MAIN_INDEX]['Features']
    statis_data['Abstract Features'] = raw_data[MAIN_INDEX]['Abstract Features']
    statis_data['Features Refactored'] = raw_data[MAIN_INDEX]['Features Refactored']
    statis_data['Abstract Features Refactored'] = raw_data[MAIN_INDEX]['Abstract Features Refactored']
                                            
    statis_data['Constraints'] = raw_data[MAIN_INDEX]['Constraints']
    statis_data['Constraints Refactored'] = raw_data[MAIN_INDEX]['Constraints Refactored']
    statis_data['Configurations'] = raw_data[MAIN_INDEX]['Configurations']
    statis_data['Configurations Refactored'] = raw_data[MAIN_INDEX]['Configurations Refactored']
    statis_data[f'Mean {TIME}'] = round(statistics.mean([raw_data[run]['Execution time']
                                                         for run in raw_data]), ROUND_DIGITS)
    statis_data[f'Std {TIME}'] = round(statistics.stdev([raw_data[run]['Execution time']
                                                         for run in raw_data]), ROUND_DIGITS)
    statis_data[f'Median {TIME}'] = round(statistics.median([raw_data[run]['Execution time']
                                                         for run in raw_data]), ROUND_DIGITS)
    return statis_data


def execution_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm


if __name__ == '__main__':
    fm_name = input("Feature Model Name: ")
    if not fm_name == '':
        MODEL_PATH = 'tests/models_input_statistics/' + fm_name
        statis_data = {}
        statis_list = []
        main(MODEL_PATH, statis_list)