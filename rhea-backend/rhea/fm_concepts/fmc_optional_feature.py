from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.fm_concepts import FMConcept
from rhea.refactorings import Refactoring


class FMCOptionalFeature(FMConcept):

    @staticmethod
    def name() -> str:
        return 'Optional Feature'

    @staticmethod
    def get_instances(fm: FeatureModel) -> list[Any]:
        return fm.get_optional_features()

    @staticmethod
    def get_refactorings() -> list[Refactoring]:
        return []
