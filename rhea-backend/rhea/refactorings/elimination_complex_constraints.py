from asyncio import constants
from turtle import left
from typing import Any, Dict

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from flamapy.core.models.ast import AST, ASTOperation, Node

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils
from rhea.metamodels.fm_metamodel.models import fm_utils


class EliminationComplexConstraints(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Complex Constraints from Feature Trees'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints() if fm_utils.is_complex_constraint(ctc)]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'Constraint {instance} is None.')
        if not fm_utils.is_complex_constraint(instance):
            raise Exception(f'Constraint {instance} is not complex.')

        new_or = Feature(utils.get_new_feature_name(model, 'OR'), is_abstract=True)
        features = []
        dict_constraint = get_features_clauses(instance)  # NOT before negatives (dict)
        # print(dict_constraint)
        for i, f in enumerate(dict_constraint.keys()):
            new_feature = Feature(utils.get_new_feature_name(model, f), parent=new_or, is_abstract=True)
            features.append(new_feature)
            ast_operation = ASTOperation.REQUIRES if dict_constraint[f] else ASTOperation.EXCLUDES
            ctc = Constraint(f'CTC{i}', AST.create_binary_operation(ast_operation,
                             Node(new_feature.name), Node(f)))
            model.ctcs.append(ctc)

        model.ctcs.remove(instance)

        # New branch with OR as root
        rel_or = Relation(new_or, features, 1, len(features))  # OR
        new_or.add_relation(rel_or)
        
        # New root
        new_root = Feature(utils.get_new_feature_name(model, 'root'), is_abstract=True)
        rel_1 = Relation(new_root, [model.root], 1, 1)  # mandatory
        new_root.add_relation(rel_1)
        model.root.parent = new_root
        rel_2 = Relation(new_root, [new_or], 1, 1)  # mandatory
        new_root.add_relation(rel_2)
        new_or.parent = new_root
        model.root = new_root
        
        return model


def get_features_clauses(instance: Constraint) -> dict:
    """Returns a dictionary of 'Features -> bool',
    that sets 'bool' to FALSE if the feature has a negation"""
    features = {}
    stack = [instance.ast.root]
    while stack:
        node = stack.pop()
        if node.is_unique_term():
            features[node.data] = True
        elif node.is_unary_op():
            features[node.left.data] = False
        elif node.is_binary_op():
            stack.append(node.right)
            stack.append(node.left)
    return features