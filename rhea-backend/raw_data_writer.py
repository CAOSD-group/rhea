from email import header
from unittest import result
from flamapy.core.transformations import ModelToText
from typing import Any
import random
import os, time, statistics

from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

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


class RawDataCSVWriter(dict):
    """Transform raw data about Refactorings to a CSV format.
    
    Raw data is specified in a .csv file that is the input of the refactoring graphics.
    """

    @staticmethod
    def get_destination_extension() -> str:
        return '.csv'

    def __init__(self, path: str, raw_data_dict: dict) -> None:
        self.path = path
        self.raw_data_dict = raw_data_dict

    def set_attributes(self, attributes: Any) -> None:
        self.attributes = attributes

    def transform(self) -> str:
        data_str = data_to_csv(self.raw_data_dict)
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(data_str)
        return data_str


def data_to_csv(raw_data_dict: dict) -> str:
    FM_STR = 'FM'
    RUN_STR = 'Run'
    FEATURES_STR = 'Features'
    FEATURES_REFACTORED_STR = 'Features Refactored'
    CONSTRAINTS_STR = 'Constraints'
    CONSTRAINTS_REFACTORED_STR = 'Constraints Refactored'
    EXECUTION_TIME_STR = 'Execution time'
    PERFORMANCE_STR = 'Performance'
    SCALABILITY_STR = 'Scalability'
    NATURALNESS_STR = 'Naturalness'
    CORRECTNESS_STR = 'Correctness'
    COMPLETENESS_STR = 'Completeness'

    header = [FM_STR, RUN_STR, FEATURES_STR, FEATURES_REFACTORED_STR, 
              CONSTRAINTS_STR, CONSTRAINTS_REFACTORED_STR, EXECUTION_TIME_STR]
            
    result = ','.join(st for st in header)

    # run = 30 # later a parameter asked


    # row = get_content(feature_model, fm_name, n_run, refactoring)
    row = get_content(raw_data_dict)
    result += f'{row}'
    
    return result

def get_content(raw_data_dict: dict[dict]) -> str:
    result = ''
    for raw_data in raw_data_dict.values():
        list_row = []
        for value in raw_data.values():
            list_row.append(str(value))
            row = ','.join(st for st in list_row)
        result += f'\n{row}'
    return result

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