from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from famapy.core.models.ast import AST, ASTOperation, Node

from rhea.refactorings import FMRefactoring

from rhea.refactorings import utils

class XorMandatoryRefactoring(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Xor and Mandatory refactoring'

    @staticmethod
    def transform(model: FeatureModel, instance: Any,) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not instance.is_alternative_group:
            raise Exception(f'Feature {instance.name} is not a cardinality group.')
        
        relations = instance.get_relations()
        r_alt = next((r for r in instance.get_relations() if r.is_alternative() and (utils.is_there_mandatory(relations))), None)

        if r_alt != None:
            r_alt.card_min = 0
            r_alt.card_max = 0
        
            children_list = []
            count = 0
            for child in r_alt.children:
                if child.is_mandatory():
                    count += 1
                    r_mand = next((r for r in relations if r.is_mandatory()), None)
                    relations.remove(r_mand)
                    r_new_mand = Relation(instance, [child], 1, 1)  # mandatory
                    instance.add_relation(r_new_mand)
                else:
                    children_list.append(child)

            if count>1:
                raise Exception(f'More mandatory children than expected.')

            instance.get_relations().remove(r_alt)

            if len(children_list)<=1:
                r_opt = Relation(instance, children_list, 0, 1)  # optional
                constraint = AST.create_unary_operation(ASTOperation.NOT, children_list[0]).root
                model.ctcs.append(constraint)
            else:
                r_opt = Relation(instance, children_list, 0, 0)  # dead

            # Add relations to features
            instance.add_relation(r_opt)
            
        return model


    @staticmethod
    def get_instances(model: FeatureModel) -> list[Any]:
        return [f for f in model.get_features() if f.is_alternative_group() and (utils.is_there_mandatory(f.get_relations()))]