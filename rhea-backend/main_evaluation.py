from email.base64mime import body_decode
import os, time
from typing import Any
from weakref import ref 

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



def main():
    fm = UVLReader(MODEL_PATH).transform()

    execution_time(fm, REFACTORING_MUTEX)
    # execution_time(fm, REFACTORING_CARDINALITY)
    # execution_time(fm, REFACTORING_MULT_GROUP_DECOMP)
    # execution_time(fm, REFACTORING_XOR_MAND)
    # execution_time(fm, REFACTORING_OR_MAND)
    # execution_time(fm, REFACTORING_ANY_CTCS)
    # execution_time(fm, REFACTORING_SPLIT)
    # execution_time(fm, REFACTORING_COMPLEX)
    # execution_time(fm, REFACTORING_REQUIRES)
    # execution_time(fm, REFACTORING_EXCLUDES)



if __name__ == '__main__':
    main()