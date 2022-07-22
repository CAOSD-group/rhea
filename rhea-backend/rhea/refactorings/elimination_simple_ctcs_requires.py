from logging import root
from typing import Any

from famapy.core.models.ast import AST, ASTOperation, Node
from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from rhea.flamapy.metamodels.fm_metamodel.models.fm_helper import FMHelper, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraintsRequires(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Requires'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_requires_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_requires_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        right_feature_name = instance.ast.root.right.data
        right_feature = model.get_feature_by_name(right_feature_name)

        left_feature_name = instance.ast.root.left.data
        left_feature = model.get_feature_by_name(left_feature_name)

        tree_plus = add_node_to_tree(model, right_feature)
        print(f'T(+{right_feature}): {tree_plus}')
        eliminate1 = eliminate_node_from_tree(model, left_feature)
        print(f'T(-{left_feature}): {eliminate1}')
        tree_eliminate = eliminate_node_from_tree(eliminate1, right_feature)
        print(f'T(-{right_feature}): {tree_eliminate}')

        if tree_plus!=None and tree_eliminate!=None:
            new_root = Feature(utils.get_new_feature_name(model, 'root'), None, None, False)
            rel = Relation(new_root, [tree_plus.root, tree_eliminate.root], 1, 1)  #XOR
            new_root.add_relation(rel)
            model.root = new_root
        elif tree_eliminate()==None:
            model = tree_plus()
        elif tree_plus==None:
            model = tree_eliminate()
        
        model.ctcs.remove(instance)

        return model

def add_node_to_tree(model: FeatureModel, node: Feature) -> FeatureModel:
    if node not in model.get_features():
        return None
    elif model.root==node:
        return model
    else:
        parent = node.parent
        if (parent.is_mandatory() or parent.is_optional()) and node.is_optional():
            r_opt = Relation(parent, [node], 1, 1)  # mandatory
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
                if child!=node:
                    r_opt = Relation(parent, [child], 0, 1)  # optional
                    parent.add_relation(r_opt)
            for rel in relations:
                parent.get_relations().remove(rel)
    model = add_node_to_tree(model, parent)
    return model

def eliminate_node_from_tree(model: FeatureModel, node: Feature) -> FeatureModel:
    if node not in model.get_features():
        return model
    elif model.root==node:
        return None
    else:
        parent = node.parent
        if (parent.is_mandatory() or parent.is_optional()) and node.is_mandatory():
            model = eliminate_node_from_tree(model, parent)
        elif (parent.is_mandatory() or parent.is_optional()) and node.is_optional():
            r_opt = next((r for r in parent.get_relations() if r.is_optional() and node in parent.get_children()), None)
            parent.get_relations().remove(r_opt)
        elif parent.is_or_group() or parent.is_alternative_group():
            
            if len(parent.get_children())==1:
                parent.get_relations().remove(parent.get_relations())
                r_mand = Relation(parent, parent.get_children(), 1, 1)  # mandatory
                parent.add_relation(r_mand)
    return model