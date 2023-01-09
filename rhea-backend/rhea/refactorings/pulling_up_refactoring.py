from typing import Any

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class PullingUpRefactoring(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Remove dead features refactoring'
    
    @staticmethod
    def get_description() -> str:
        return ("It eliminates every dead feature in a Feature Model.")

    @staticmethod
    def get_language_construct_name() -> str:
        return 'Dead features in m odel'
    
    @staticmethod
    def get_instances(model: FeatureModel) -> list[Any]:
        return [f for f in model.get_features() if f.name]

    @staticmethod
    def transform(model: FeatureModel, instance: Feature) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not is_multiple_group_decomposition(instance):
            raise Exception(f'Feature {instance.name} is not a multiple group decomposition.')

        for relation in instance.get_relations():
            if relation.is_group():
                model = new_decomposition(model, instance, relation)
        return model