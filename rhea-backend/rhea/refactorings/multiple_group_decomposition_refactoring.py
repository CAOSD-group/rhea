from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from rhea.refactorings import Refactoring

from rhea.refactorings import utils

class MultipleGroupDecompositionRefactoring(Refactoring):

    @staticmethod
    def get_name() -> str:
        return 'Multiple group decomposition refactoring'

    @staticmethod
    def transform(model: FeatureModel, instance: Any,) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not is_mult_group_decomposition(instance):
            raise Exception(f'Feature {instance.name} is not a multiple group decomposition.')

        relations = [r for r in instance.get_relations()]
        for r in relations:
            if r.is_group():
                model = new_decomposition(model, instance, r)
        
        return model


    @staticmethod
    def get_instances(model: FeatureModel) -> list[Any]:
        return [f for f in model.get_features() if is_mult_group_decomposition(f)]

def is_mult_group_decomposition(feature: Feature) -> bool:
    is_mgd = False
    suma = [r for r in feature.get_children() if feature.is_group()]
    if len(suma)>1:
        is_mgd = True
    return is_mgd



def new_decomposition(fm: FeatureModel, feature: Feature, r_group: Relation) -> FeatureModel:
    new_name = utils.get_new_feature_name(fm, feature.name)
    f_p = Feature(name=new_name, parent=feature, is_abstract=True)
    r_mand = Relation(feature, [f_p], 1, 1)  # mandatory
    feature.add_relation(r_mand)
    
    r_group.parent = f_p

    for child in r_group.children:
        child.parent = f_p

    # Add relations to features
    f_p.add_relation(r_group)

    feature.get_relations().remove(r_group)

    return fm