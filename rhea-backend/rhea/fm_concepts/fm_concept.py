from typing import Any
from abc import ABC, abstractmethod

from famapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.refactorings import Refactoring


class FMConcept(ABC):

    @staticmethod
    @abstractmethod
    def name() -> str:
        """Name of the feature modeling concept."""
        pass

    @staticmethod
    @abstractmethod
    def get_instances(fm: FeatureModel) -> list[Any]:
        """Return the instances of this FM concept in the given feature model."""
        pass

    @staticmethod
    @abstractmethod
    def get_refactorings() -> list[Refactoring]:
        """Return the available refactorings to this FM concept."""
        pass
