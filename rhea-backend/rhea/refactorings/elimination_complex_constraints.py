from asyncio import constants
from turtle import left
from typing import Any, Dict

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from flamapy.core.models.ast import AST, ASTOperation, Node

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationComplexConstraints(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Complex Constraints from Feature Trees'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_complex_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_complex_constraint():
            raise Exception(f'Operator {str(instance)} is not complex constraint.')

        # print(f'MODELO: {model}')

        print(f'Constraint: {str(instance)}')
        # print(f'Constraint AST: {str(instance.ast)}')
        # print(f'Constraint AST.root: {str(instance.ast.root)}')
        print(f'datos del nodo izquierdo: {instance.ast.root.left.data}')
        print(f'datos del nodo derecho: {instance.ast.root.right}')
        
        new_or = Feature(utils.get_new_feature_name(model, 'Or'), is_abstract=True)

        features_names = instance.get_features()  # string
        features_new_names = []
        dict_constraint = read_complex_constraint(instance)  # para negar las que tengan un not en la constraint
        print(f'NEW CONSTRAINT: {dict_constraint}')
        for i, f in enumerate(features_names):
            new_feature = Feature(utils.get_new_feature_name(model, f), parent=new_or, is_abstract=True)
            features_new_names.append(new_feature)
            for d in dict_constraint:
                if d == f:
                    if dict_constraint[d] is True:
                        ctc = Constraint(f'CTC({i})', AST.create_binary_operation(ASTOperation.IMPLIES, new_feature, AST.create_unary_operation(ASTOperation.NOT, d)))
                    else:
                        ctc = Constraint(f'CTC({i})', AST.create_binary_operation(ASTOperation.IMPLIES, new_feature, d))
            print(f'CONSTRAINT: {ctc}')
            model.ctcs.append(ctc)

        



            

        model.ctcs.remove(instance)

        # New branch with OR as root
        rel_or = Relation(new_or, features_new_names, 1, len(features_new_names))  # OR
        print(f'FEATURES: {[f.name for f in features_new_names]}')
        print(f'REL OR: {str(rel_or)}')
        new_or.add_relation(rel_or)
        
        # New root
        new_root = Feature(utils.get_new_feature_name(model, 'root'), is_abstract=True)
        rel_1 = Relation(new_root, [model.root], 1, 1)  # mandatory
        new_root.add_relation(rel_1)
        rel_2 = Relation(new_root, [new_or], 1, 1)  # mandatory
        new_root.add_relation(rel_2)
        model.root = new_root
        
        return model

def read_complex_constraint(instance: Constraint) -> dict:
    features = {}
    stack = [instance.ast.root]
    while stack:
        node = stack.pop()
        print(f'NODE: {node}')
        if node.is_unique_term():
            features[node.data] = False
        elif node.is_unary_op():
            features[node.left.data] = True
        elif node.is_binary_op():
            stack.append(node.right)
            stack.append(node.left)

    return features