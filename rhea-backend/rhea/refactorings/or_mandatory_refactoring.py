from typing import Any

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class OrMandatoryRefactoring(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Or and Mandatory refactoring'

    @staticmethod
    def transform(model: FeatureModel, instance: Any,) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not instance.is_or_group:
            raise Exception(f'Feature {instance.name} is not an or group.')

        relations = instance.get_relations()

        r_or = next((r for r in relations if r.is_or() and (utils.is_there_mandatory(relations))), None)

        if r_or!=None:

            for child in r_or.children:
                r_opt = Relation(instance, [child], 0, 1)  # optional
                instance.add_relation(r_opt)
                if child.is_mandatory():
                    r_mand = next((r for r in instance.get_relations() if r.is_mandatory()), None)
                    instance.get_relations().remove(r_opt)
                    instance.get_relations().remove(r_mand)
                    r_new_mand = Relation(instance, [child], 1, 1)  # mandatory
                    instance.add_relation(r_new_mand)

            instance.get_relations().remove(r_or)
        
        return model


    @staticmethod
    def get_instances(model: FeatureModel) -> list[Any]:
        return [f for f in model.get_features() if f.is_or_group() and utils.is_there_mandatory(f.get_relations())]
