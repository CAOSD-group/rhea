import os
import pytest 

from famapy.core.transformations import TextToModel
from famapy.metamodels.fm_metamodel.models import FeatureModel
from famapy.metamodels.fm_metamodel.transformations import UVLReader
from famapy.metamodels.pysat_metamodel.operations import Glucose3ProductsNumber
from famapy.metamodels.pysat_metamodel.transformations import FmToPysat

from rhea.refactorings import Refactoring
from rhea.refactorings.mutex_group_refactoring import MutexGroupRefactoring
from rhea.refactorings.cardinality_group_refactoring import CardinalityGroupRefactoring


MUTEX_GROUP_MODELS_PATH = 'tests/input_models/mutex_groups/'
CARDINALITY_GROUP_MODELS_PATH = 'tests/input_models/cardinality_groups/'


def get_tests() -> list[list[str, Refactoring]]:
    """Return the list of tests to be executed.
    
    Each test receives a list of parameters containing:
      - the filepath of the FM.
      - the refactoring to test.
    """
    tests = []
    mutex_group_tests = [[m, MutexGroupRefactoring] for m in get_models(MUTEX_GROUP_MODELS_PATH)]
    tests.extend(mutex_group_tests)
    cardinality_group_tests = [[m, CardinalityGroupRefactoring] for m in get_models(CARDINALITY_GROUP_MODELS_PATH)]
    tests.extend(cardinality_group_tests)
    return tests


def get_models(dirpath: str) -> list[str]:
    fms = []
    for root, dirs, files in os.walk(dirpath):
        for f in files:
            filepath = os.path.join(root, f)
            fms.append(filepath)
    return fms


def load_model(filepath: str, reader: TextToModel) -> FeatureModel:
    return reader(filepath).transform()


def apply_refactoring(fm: FeatureModel, refactoring: Refactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm


@pytest.mark.parametrize('fm_path, refactoring', get_tests())
def test_nof_configurations(fm_path: str, refactoring: Refactoring):
    fm = load_model(fm_path, UVLReader)
    sat_model = FmToPysat(fm).transform()
    expected_configs = Glucose3ProductsNumber().execute(sat_model).get_result()
    resulting_model = apply_refactoring(fm, refactoring)
    sat_model = FmToPysat(resulting_model).transform()
    n_configs = Glucose3ProductsNumber().execute(sat_model).get_result()
    assert n_configs == expected_configs


@pytest.mark.parametrize('fm_path, refactoring', get_tests())
def test_nof_instances(fm_path: str, refactoring: Refactoring):
    fm = load_model(fm_path, UVLReader)
    resulting_model = apply_refactoring(fm, refactoring)
    instances = refactoring.get_instances(resulting_model)
    assert len(instances) == 0
