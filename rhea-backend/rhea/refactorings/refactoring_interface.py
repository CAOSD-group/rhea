from abc import abstractmethod, ABC
from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel


class FMRefactoring(ABC):

    @staticmethod
    @abstractmethod
    def get_name() -> str:
        """Name of the refactoring."""
        pass

    @staticmethod
    @abstractmethod
    def transform(model: FeatureModel, instance: Any) -> FeatureModel:
        """Apply the refactoring to the given instance."""
        pass

    @staticmethod
    @abstractmethod
    def get_instances(model: FeatureModel) -> list[Any]:
        """Return the instances of the refactoring that can be applied to the source model."""
        pass