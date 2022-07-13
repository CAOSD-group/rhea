from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature

from rhea.refactorings import Refactoring


class CardinalityGroupRefactoring(Refactoring):

    @staticmethod
    def get_name() -> str:
        return 'Cardinality group refactoring'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [f for f in model.get_features() if f.is_cardinality_group()]

    @staticmethod
    def transform(model: FeatureModel, instance: Feature) -> FeatureModel:
        return model
