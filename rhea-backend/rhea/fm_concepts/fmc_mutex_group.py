from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.fm_concepts import FMConcept
from rhea.refactorings import Refactoring
from rhea.refactorings.mutex_group_refactoring import MutexGroupRefactoring


class FMCMutexGroup(FMConcept):

    @staticmethod
    def name() -> str:
        return 'Mutex Group'

    @staticmethod
    def get_instances(fm: FeatureModel) -> list[Any]:
        return [f for f in fm.get_features() if f.is_mutex_group()]

    @staticmethod
    def get_refactorings() -> list[Refactoring]:
        return [MutexGroupRefactoring]
