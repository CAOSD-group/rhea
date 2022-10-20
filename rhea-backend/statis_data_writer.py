from flamapy.core.transformations import ModelToText
from typing import Any
import os, time
import csv

from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
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

from rhea.refactorings import utils

TIME = 'Time (s)'



class StatisticsDataCSVWriter(ModelToText):
    """Transform raw data about Refactorings from a CSV format to statistics data.
    
    Statistics data is specified in a .csv file that is the input of the refactoring graphics.
    """

    @staticmethod
    def get_destination_extension() -> str:
        return '.csv'

    def __init__(self, path: str, data_list: list[dict]) -> None:
        self.path = path
        self.data_dict = data_list

    def set_attributes(self, attributes: Any) -> None:
        self.attributes = attributes

    def transform(self) -> str:
        data_str = data_to_csv(self.data_dict, self.path)
        if os.path.exists(self.path):    
            with open(self.path, 'a', encoding='utf-8') as file:
                file.write(data_str)
        else:
            with open(self.path, 'w', encoding='utf-8') as file:
                file.write(data_str)
        return data_str


def data_to_csv(data_list: list[dict], path: str) -> str:
    FM_STR = 'FM'
    TOTAL_RUN_STR = 'Run'
    FEATURES_STR = 'Features'
    FEATURES_REFACTORED_STR = 'Features Refactored'
    ABS_FEATURES_STR = 'Abstract Features'
    ABS_FEATURES_REFACTORED_STR = 'Abstract Features Refactored'
    CONSTRAINTS_STR = 'Constraints'
    CONSTRAINTS_REFACTORED_STR = 'Constraints Refactored'
    CONFIGURATIONS_STR = 'Configurations'
    CONFIGURATIONS_REFACTORED_STR = 'Configurations Refactored'
    EXECUTION_TIME_STR = f'Mean {TIME}'
    STD_TIME = f'Std {TIME}'
    MEDIAN_TIME = f'Median {TIME}'
    PERFORMANCE_AVG_STR = 'Performance Average'
    SCALABILITY_AVG_STR = 'Scalability Average'
    NATURALNESS_AVG_STR = 'Naturalness Average'
    CORRECTNESS_AVG_STR = 'Correctness Average'
    COMPLETENESS_AVG_STR = 'Completeness Average'

    if not os.path.exists(path):
        header = [FM_STR, TOTAL_RUN_STR, FEATURES_STR, FEATURES_REFACTORED_STR, ABS_FEATURES_STR, 
                  ABS_FEATURES_REFACTORED_STR, CONSTRAINTS_STR, CONSTRAINTS_REFACTORED_STR, 
                  CONFIGURATIONS_STR, CONFIGURATIONS_REFACTORED_STR, EXECUTION_TIME_STR, STD_TIME,
                  MEDIAN_TIME]  
        result = ','.join(st for st in header)
    else:
        result = ''

    # REFACTORING_MUTEX = MutexGroupRefactoring
    # REFACTORING_CARDINALITY = CardinalityGroupRefactoring
    # REFACTORING_MULT_GROUP_DECOMP = MultipleGroupDecompositionRefactoring
    # REFACTORING_XOR_MAND = XorMandatoryRefactoring
    # REFACTORING_OR_MAND = OrMandatoryRefactoring
    # REFACTORING_ANY_CTCS = EliminationAnyConstraints
    # REFACTORING_SPLIT = SplitConstraint
    # REFACTORING_COMPLEX = EliminationComplexConstraints
    # REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
    # REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes

    # list_refactorings = [REFACTORING_MUTEX, REFACTORING_CARDINALITY, REFACTORING_MULT_GROUP_DECOMP, 
    #                REFACTORING_XOR_MAND, REFACTORING_OR_MAND, REFACTORING_ANY_CTCS,
    #                REFACTORING_SPLIT, REFACTORING_COMPLEX, REFACTORING_REQUIRES, 
    #                REFACTORING_EXCLUDES]
    
    # refactoring = list_refactorings[random.randint(0,9)]

    for data in data_list:
        list_row = get_content(data)
        result += '\n' + ','.join(dat for dat in list_row)
    
    return result

def get_content(data_dict: dict):
    list_row = []
    list_row.append(str(data_dict['FM']))
    list_row.append(str(data_dict['Run']))
    list_row.append(str(data_dict['Features']))
    list_row.append(str(data_dict['Features Refactored']))
    list_row.append(str(data_dict['Abstract Features']))
    list_row.append(str(data_dict['Abstract Features Refactored']))
    list_row.append(str(data_dict['Constraints']))
    list_row.append(str(data_dict['Constraints Refactored']))
    list_row.append(str(data_dict['Configurations']))
    list_row.append(str(data_dict['Configurations Refactored']))
    list_row.append(str(data_dict[f'Mean {TIME}']))
    list_row.append(str(data_dict[f'Std {TIME}']))
    list_row.append(str(data_dict[f'Median {TIME}']))
    return list_row