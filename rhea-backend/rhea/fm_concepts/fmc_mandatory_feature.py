from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.fm_concepts import FMConcept
from rhea.refactorings import FMRefactoring


class FMCMandatoryFeature(FMConcept):

    @staticmethod
    def name() -> str:
        return 'Mandatory Feature'

    @staticmethod
    def get_instances(fm: FeatureModel) -> list[Any]:
        return fm.get_mandatory_features()

    @staticmethod
    def get_refactorings() -> list[FMRefactoring]:
        return []
