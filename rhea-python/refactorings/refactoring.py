from abc import abstractmethod
from typing import Any

from famapy.core.transformations import ModelToModel
from famapy.metamodels.fm_metamodel.models import FeatureModel


class Refactoring():

    @abstractmethod
    def transform(self, model: FeatureModel) -> FeatureModel:
        pass

    @staticmethod
    @abstractmethod
    def get_name() -> str:
        pass

    @staticmethod
    @abstractmethod
    def get_language_construct_instances(model: FeatureModel) -> int:
        """Return the number of instances of the language construct 
        this refactoring transform that are present in the source model."""
        pass