from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.fm_concepts import FMConcept
from rhea.refactorings import Refactoring


class FMCAbstractFeature(FMConcept):

    @staticmethod
    def name() -> str:
        return 'Abstract Feature'

    @staticmethod
    def get_instances(fm: FeatureModel) -> list[Any]:
        return [f for f in fm.get_features() if f.is_abstract]

    @staticmethod
    def get_refactorings() -> list[Refactoring]:
        return []
