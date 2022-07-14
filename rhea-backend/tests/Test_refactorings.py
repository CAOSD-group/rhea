import os
import pytest 
from typing import Any 

from famapy.core.transformations import TextToModel, ModelToText
from famapy.metamodels.fm_metamodel.models import FeatureModel
from famapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter
from famapy.metamodels.pysat_metamodel.transformations import FmToPysat
from famapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

from rhea.refactorings import Refactoring
from rhea.refactorings.mutex_group_refactoring import MutexGroupRefactoring
from rhea.refactorings.cardinality_group_refactoring import CardinalityGroupRefactoring
from rhea.refactorings.multiple_group_decomposition_refactoring import MultipleGroupDecompositionRefactoring


MODELS_BASE_PATH = os.path.join('tests', 'models')
INPUT_MODELS = 'input_models'
OUTPUT_MODELS = 'output_models'
EXPECTED_MODELS = 'expected_models'
MUTEX_GROUP_MODELS_PATH = 'mutex_groups'
CARDINALITY_GROUP_MODELS_PATH = 'cardinality_groups'
MULTIPLE_GROUP_DECOMPOSITION = 'multiple_group_decomposition'


def get_models(dirpath: str) -> list[str]:
    fms = []
    for root, dirs, files in os.walk(dirpath):
        for f in files:
            filepath = os.path.join(root, f)
            fms.append(filepath)
    return fms


def get_tests_info(ref_path: str, refactoring: Refactoring) -> list[list[str, str, str, Refactoring]]:
    input_path = os.path.join(MODELS_BASE_PATH, ref_path, INPUT_MODELS)
    output_path = os.path.join(MODELS_BASE_PATH, ref_path, OUTPUT_MODELS)
    expected_path = os.path.join(MODELS_BASE_PATH, ref_path, EXPECTED_MODELS)
    input_models = get_models(input_path)
    output_models = [os.path.join(output_path, os.path.basename(m)) for m in input_models]
    expected_models = get_models(expected_path)
    return [[a, b, c, refactoring] for a, b, c in zip(input_models, output_models, expected_models)]


def get_tests() -> list[list[str, str, str, Refactoring]]:
    """Return the list of tests to be executed.
    
    Each test receives a list of parameters containing:
      - the filepath of the FM.
      - the refactoring to test.
    """
    tests = []
    mutex_group_tests = get_tests_info(MUTEX_GROUP_MODELS_PATH, MutexGroupRefactoring)
    tests.extend(mutex_group_tests)
    cardinality_group_tests = get_tests_info(CARDINALITY_GROUP_MODELS_PATH, CardinalityGroupRefactoring)
    tests.extend(cardinality_group_tests)
    multiple_group_decomposition_tests = get_tests_info(MULTIPLE_GROUP_DECOMPOSITION, MultipleGroupDecompositionRefactoring)
    tests.extend(multiple_group_decomposition_tests)
    return tests


def load_model(filepath: str, reader: TextToModel) -> FeatureModel:
    return reader(filepath).transform()


def save_model(filepath: str, fm: FeatureModel, writer: ModelToText) -> None:
    writer(path=filepath, source_model=fm).transform()


def apply_refactoring(fm: FeatureModel, refactoring: Refactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm


@pytest.mark.parametrize('fm_path, refactoring', [[m, r] for m, _, _, r in get_tests()])
def test_nof_configurations(fm_path: str, refactoring: Refactoring):
    """Test that the number of configurations of the source feature model and the 
    number of configurations of the refactored feature model are the same."""
    fm = load_model(fm_path, UVLReader)
    sat_model = FmToPysat(fm).transform()
    expected_n_configs = Glucose3ProductsNumber().execute(sat_model).get_result()
    resulting_model = apply_refactoring(fm, refactoring)
    sat_model = FmToPysat(resulting_model).transform()
    n_configs = Glucose3ProductsNumber().execute(sat_model).get_result()
    assert n_configs == expected_n_configs


@pytest.mark.parametrize('fm_path, refactoring', [[m, r] for m, _, _, r in get_tests()])
def test_products(fm_path: str, refactoring: Refactoring):
    """Test that the products of the source feature model and the 
    products of the refactored feature model are the same."""
    fm = load_model(fm_path, UVLReader)
    sat_model = FmToPysat(fm).transform()
    expected_configs = Glucose3Products().execute(sat_model).get_result()
    expected_products = filter_products(fm, expected_configs)
    resulting_model = apply_refactoring(fm, refactoring)
    sat_model = FmToPysat(resulting_model).transform()
    configs = Glucose3Products().execute(sat_model).get_result()
    products = filter_products(resulting_model, configs)
    assert expected_products == products


@pytest.mark.parametrize('fm_path, refactoring', [[m, r] for m, _, _, r in get_tests()])
def test_nof_instances(fm_path: str, refactoring: Refactoring):
    """Test that the number of instances to be refactored of the feature model after
    refactorings is equals 0 (i.e., there is no remaining instances of the given refactoring)."""
    fm = load_model(fm_path, UVLReader)
    resulting_model = apply_refactoring(fm, refactoring)
    instances = refactoring.get_instances(resulting_model)
    assert len(instances) == 0


@pytest.mark.parametrize('input_fm_path, output_fm_path, expected_fm_path, refactoring', get_tests())
def test_feature_model_output(input_fm_path: str, output_fm_path: str, expected_fm_path: str, refactoring: Refactoring):
    """Test that the refactored feature model is the same as the expected feature model."""
    fm = load_model(input_fm_path, UVLReader)
    expected_fm = load_model(expected_fm_path, UVLReader)
    resulting_model = apply_refactoring(fm, refactoring)
    save_model(output_fm_path, resulting_model, UVLWriter)
    assert expected_fm == resulting_model


def filter_products(fm: FeatureModel, configurations: list[list[Any]]) -> set[set[Any]]:
    filtered_configs = set()
    for config in configurations:
        c = {f for f in config if not fm.get_feature_by_name(f).is_abstract}
        filtered_configs.add(frozenset(c))
    return filtered_configs
