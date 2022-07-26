import copy
from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from rhea.flamapy.metamodels.fm_metamodel.models.fm_helper import FMHelper, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class NewNamesEliminationSimpleConstraintsExcludes(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Excludes (changing names)'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_excludes_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_excludes_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        original_model = copy.deepcopy(model)
        print(f'MODELO: {model}')

        right_feature_name = instance.ast.root.right.data
        right_feature = model.get_feature_by_name(right_feature_name)

        left_feature_name = instance.ast.root.left.data

        right_original_feature = original_model.get_feature_by_name(right_feature_name)
        left_original_feature = original_model.get_feature_by_name(left_feature_name)

        
        tree_eliminate = eliminate_node_from_tree(model, right_feature)
        print(f'T(-{right_feature}): {tree_eliminate}')
        tree_eliminate_new = eliminate_node_from_tree(original_model, left_original_feature)
        print(f'T(-{left_original_feature}): {tree_eliminate_new}')
        tree_eliminate_add = add_node_to_tree(tree_eliminate_new, right_original_feature)
        print(f'T(+{right_original_feature}): {tree_eliminate_add}')

        if tree_eliminate!=None and tree_eliminate_add!=None:
            new_root = Feature('root', None, None, True)
            rel = Relation(new_root, [tree_eliminate.root, tree_eliminate_add.root], 1, 1)  #XOR
            new_root.add_relation(rel)
            model.root = new_root
        elif tree_eliminate==None:
            model = tree_eliminate_add
        elif tree_eliminate_add==None:
            model = tree_eliminate
        
        model.ctcs.remove(instance)

        # Changing names
        for feature in model.get_features():
            original_feature = original_model.get_feature_by_name(feature.name)
            feature.name = utils.get_new_feature_name(model, feature.name)
            feature.reference = original_feature

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

            rel = next((r for r in parent.get_relations()), None)

            r_group = []
            for child in rel.children:
                if child != node:
                    r_group.append(child)
            r_group_new = Relation(parent, r_group, rel.card_min, 1)
            parent.add_relation(r_group_new)

            parent.get_relations().remove(rel)

            if r_group_new.is_optional():
                r_group_new.card_min = 1
    return model

