from ast import Constant
from lib2to3.pytree import Node
from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from pyparsing import null_debug_action

from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraintsRequires(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Requires'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [f for f in model.get_constraints() if f.get_features()]  # METODO PARA COMPROBAR SI ES REQUIRES

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{instance.name}".')
        if not instance:  # METODO PARA COMPROBAR SI ES REQUIRES
            raise Exception(f'Feature {instance.name} is not a mutex group.')
    
        
        return model

def add_node_to_tree(model: FeatureModel, node: Feature) -> FeatureModel:
    if node not in model:
        return None
    elif model.root==node:
        return node
    else:
        parent = node.parent
        if (parent.is_mandatory() or parent.is_optional()) and node.is_optional():
            r_opt = Relation(parent, [node], 0, 1)  # optional
            parent.add_relation(r_opt)
        elif parent.is_alternative_group():
            parent.get_relations().remove(parent.get_relations())
            r_mand = Relation(parent, [node], 1, 1)  # mandatory
            parent.add_relation(r_mand)
        elif parent.is_or_group():
            relations = [r for r in parent.get_relations()]
            r_mand = Relation(parent, [node], 1, 1)  # mandatory
            parent.add_relation(r_mand)
            for child in parent.get_children():
                r_opt = Relation(parent, [child], 0, 1)  # optional
                parent.add_relation(r_opt)
            parent.get_relations().remove(relations)
    model = add_node_to_tree(model, parent)
    return model

def eliminate_node_from_tree(model: FeatureModel, node: Feature) -> FeatureModel:
    if node not in model:
        return node
    elif model.root==node:
        return None
    else:
        parent = node.parent
        if (parent.is_mandatory() or parent.is_optional()) and node.is_mandatory():
            model = eliminate_node_from_tree(model, parent)
        elif (parent.is_mandatory() or parent.is_optional()) and node.is_optional():
            r_opt = next((r for r in parent.get_relations() if r.is_optional() and node in r.children), None)
            parent.get_relations().remove(r_opt)
        elif parent.is_or_group() or parent.is_alternative_group():
            r_opt = next((r for r in parent.get_relations() if r.is_optional() and node in r.children), None)
            parent.get_relations().remove(r_opt)
            if len(parent.get_children())==1:
                child = parent.get_children()
                parent.get_relations().remove(parent.get_relations())
                r_mand = Relation(parent, [child], 1, 1)  # mandatory
                parent.add_relation(r_mand)
    return model

