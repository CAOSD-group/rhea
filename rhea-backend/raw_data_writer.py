from email import header
from flamapy.core.transformations import ModelToText
from typing import Any
import random
import os, time

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


class RawDataCSVWriter(ModelToText):
    """Transform raw data about Refactorings to a CSV format.
    
    Raw data is specified in a .csv file that is the input of the refactoring graphics.
    """

    @staticmethod
    def get_destination_extension() -> str:
        return '.csv'

    def __init__(self, path: str, source_model: FeatureModel) -> None:
        self.path = path
        self.source_model = source_model

    def set_attributes(self, attributes: Any) -> None:
        self.attributes = attributes

    def transform(self) -> str:
        fm_basename = os.path.basename(self.path)
        fm_name = fm_basename[:fm_basename.find('.')] 
        data_str = data_to_csv(self.source_model, fm_name)
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(data_str)
        return data_str


def data_to_csv(feature_model: FeatureModel, fm_name: str) -> str:
    FM_STR = 'FM'
    RUN_STR = 'Run'
    FEATURES_STR = 'Features'
    FEATURES_REFACTORED_STR = 'Features Refactored'
    CONSTRAINTS_STR = 'Constraints'
    CONSTRAINTS_REFACTORED_STR = 'Constraints refactored'
    EXECUTION_TIME_STR = 'Execution time'
    PERFORMANCE_STR = 'Performance'
    SCALABILITY_STR = 'Scalability'
    NATURALNESS_STR = 'Naturalness'
    CORRECTNESS_STR = 'Correctness'
    COMPLETENESS_STR = 'Completeness'

    header = [FM_STR, RUN_STR, FEATURES_STR, FEATURES_REFACTORED_STR, 
              CONSTRAINTS_STR, CONSTRAINTS_REFACTORED_STR, EXECUTION_TIME_STR]
            
    result = ','.join(st for st in header)

    run = random.randint(20, 50)

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

    for n_run in range(run):
        # row = get_content(feature_model, fm_name, n_run, refactoring)
        row = get_content(feature_model, fm_name, n_run, REFACTORING_MUTEX)
        result += f'\n{row}'
    
    return result

def get_content(fm: FeatureModel, fm_name: str, n_run: int, refactoring: FMRefactoring) -> str:

    list_row = [fm_name, str(n_run), str(len(fm.get_features()))]

    fm_refact = execution_refactoring(fm, refactoring)

    list_row.append(str(len(fm_refact.get_features())))
    list_row.append(str(len(fm.get_constraints())))
    list_row.append(str(len(fm_refact.get_constraints())))
    list_row.append(str(execution_time(fm, refactoring)))

    # execution_time(fm, REFACTORING_MUTEX)
    # execution_time(fm, REFACTORING_CARDINALITY)
    # execution_time(fm, REFACTORING_MULT_GROUP_DECOMP)
    # execution_time(fm, REFACTORING_XOR_MAND)
    # execution_time(fm, REFACTORING_OR_MAND)
    # execution_time(fm, REFACTORING_ANY_CTCS)
    # execution_time(fm, REFACTORING_SPLIT)
    # execution_time(fm, REFACTORING_COMPLEX)
    # execution_time(fm, REFACTORING_REQUIRES)
    # execution_time(fm, REFACTORING_EXCLUDES)

    row = ','.join(st for st in list_row)
    return row

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