from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from rhea.refactorings import Refactoring

from rhea.refactorings import utils

class XorMandatoryRefactoring(Refactoring):

    @staticmethod
    def get_name() -> str:
        return 'Xor and Mandatory refactoring'

    @staticmethod
    def transform(model: FeatureModel, instance: Any,) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not instance.is_alternative_group:
            raise Exception(f'Feature {instance.name} is not a cardinality group.')
        if not utils.is_there_mandatory(instance.get_relations()):
            raise Exception(f'Feature {instance.name} has no mandatory child.')
        
        r_alt = next((r for r in instance.get_relations() if r.is_alternative()), None)
        r_alt.card_min = 0
        r_alt.card_max = 0
        

        children_list = []
        for child in r_alt.children:
            if child.is_mandatory():
                r_mand = next((r for r in instance.get_relations() if r.is_mandatory()), None)
                instance.get_relations().remove(r_mand)
                r_new_mand = Relation(instance, [child], 1, 1)  # mandatory
                instance.add_relation(r_new_mand)
            else:
                children_list.append(child)

        instance.get_relations().remove(r_alt)

        r_opt = Relation(instance, children_list, 0, 0)  # dead

        # Add relations to features
        instance.add_relation(r_opt)
        
        return model


    @staticmethod
    def get_instances(model: FeatureModel) -> list[Any]:
        return [f for f in model.get_features() if f.is_alternative_group()]
