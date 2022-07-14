from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from rhea.refactorings import Refactoring
from rhea.refactorings import utils


class MutexGroupRefactoring(Refactoring):

    @staticmethod
    def get_name() -> str:
        return 'Mutex group refactoring'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [f for f in model.get_features() if f.is_mutex_group()]

    @staticmethod
    def transform(model: FeatureModel, instance: Feature) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not instance.is_mutex_group():
            raise Exception(f'Feature {instance.name} is not a mutex group.')
    
        new_name = utils.get_new_feature_name(model, instance.name)
        f_p = Feature(name=new_name, parent=instance, is_abstract=True)
        r_opt = Relation(instance, [f_p], 0, 1)  # optional
        r_mutex = next((r for r in instance.get_relations() if r.is_mutex()), None)
        r_mutex.parent = f_p
        r_mutex.card_min = 1  # xor
    
        for child in r_mutex.children:
            child.parent = f_p

        instance.get_relations().remove(r_mutex)

        # Add relations to features
        instance.add_relation(r_opt)
        f_p.add_relation(r_mutex)
        return model

