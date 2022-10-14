from audioop import avg
from email import header
from readline import append_history_file
from flamapy.core.transformations import ModelToText
from typing import Any
import random
import os, time
import csv
import statistics

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


class RawDataCSVWriter(ModelToText):
    """Transform raw data about Refactorings from a CSV format to statistics data.
    
    Statistics data is specified in a .csv file that is the input of the refactoring graphics.
    """

    @staticmethod
    def get_destination_extension() -> str:
        return '.csv'

    def __init__(self, path: str, data_csv: csv) -> None:
        self.path = path
        self.data_csv = data_csv

    def set_attributes(self, attributes: Any) -> None:
        self.attributes = attributes

    def transform(self) -> str:
        
        raw_data_basename = os.path.basename(self.path)
        raw_data_name = raw_data_basename[:raw_data_basename.find('.')] 
        data_str = data_to_csv(self.source_model, raw_data_name)
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(data_str)
        return data_str


def data_to_csv(data_csv: csv, raw_data_name: str) -> str:
    FM_STR = 'FM'
    TOTAL_RUN_STR = 'Run'
    FEATURES_AVG_STR = 'Features'
    FEATURES_REFACTORED_AVG_STR = 'Features Refactored Average'
    CONSTRAINTS_AVG_STR = 'Constraints Average'
    CONSTRAINTS_REFACTORED_AVG_STR = 'Constraints refactored Average'
    EXECUTION_TIME_AVG_STR = 'Execution time Average'
    PERFORMANCE_AVG_STR = 'Performance Average'
    SCALABILITY_AVG_STR = 'Scalability Average'
    NATURALNESS_AVG_STR = 'Naturalness Average'
    CORRECTNESS_AVG_STR = 'Correctness Average'
    COMPLETENESS_AVG_STR = 'Completeness Average'

    header = [FM_STR, TOTAL_RUN_STR, FEATURES_AVG_STR, FEATURES_REFACTORED_AVG_STR,
              CONSTRAINTS_AVG_STR, CONSTRAINTS_REFACTORED_AVG_STR, EXECUTION_TIME_AVG_STR]
            
    result = ','.join(st for st in header)

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

    list_refactorings = [REFACTORING_MUTEX, REFACTORING_CARDINALITY, REFACTORING_MULT_GROUP_DECOMP, 
                   REFACTORING_XOR_MAND, REFACTORING_OR_MAND, REFACTORING_ANY_CTCS,
                   REFACTORING_SPLIT, REFACTORING_COMPLEX, REFACTORING_REQUIRES, 
                   REFACTORING_EXCLUDES]
    
    refactoring = list_refactorings[random.randint(0,9)]

    fm_name = []
    list_num = []
    features = []
    features_refactored = []
    constraints = []
    constraints_refactored = []
    execution_time = []

 
    with open(raw_data_name, newline='') as File:  
        reader = csv.reader(File)
        for row in reader:
            row_data = row.split(",")
            for data in row_data:
                fm_name.append(data[0])
                list_num.append(data[1])
                features.append(data[2])
                features_refactored.append(data[3])
                constraints.append(data[4])
                constraints_refactored.append(data[5])
                execution_time.append(data[6])
        run = max(list_row)

    list_row = []
    for r_list in range(run):
        list_row.append(statistics.mean(fm_name))
        list_row.append(statistics.mean(run))
        list_row.append(statistics.mean(features))
        list_row.append(statistics.mean(features_refactored))
        list_row.append(statistics.mean(constraints))
        list_row.append(statistics.mean(constraints_refactored))
        list_row.append(statistics.mean(execution_time))

    result = ','.join(dat for dat in list_row)
    result += f'\n{row}'
    
    return result