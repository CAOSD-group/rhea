from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature

from refactorings.refactoring import Refactoring


class MutexGroupRefactoring(Refactoring):

    @staticmethod
    def get_name() -> str:
        return 'Mutex group refactoring'

    def __init__(self, source_model: FeatureModel, feature: Feature = None) -> None:
        self.source_model = source_model
        self.feature = feature

    @staticmethod
    def get_language_construct_instances(model: FeatureModel) -> int:
        return sum(f.is_mutex_group() for f in model.get_features())

    def transform(self) -> FeatureModel:
        pass

