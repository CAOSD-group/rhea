from asyncio import constants
from turtle import left
from typing import Any

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
            raise Exception(f'Operator {str(instance)} is not requires.')

        # print(f'MODELO: {model}')

        print(f'Constraint: {str(instance)}')
        # print(f'Constraint AST: {str(instance.ast)}')
        # print(f'Constraint AST.root: {str(instance.ast.root)}')
        print(f'datos del nodo izquierdo: {instance.ast.root.left.data}')
        print(f'datos del nodo derecho: {instance.ast.root.right}')
        
        new_or = Feature(utils.get_new_feature_name(model, 'Or'), is_abstract=True)
        features = [utils.get_new_feature_name(model, f.name) for f in instance.get_features()]
        for feature in features:
            new_constraint = read_complex_constraint(model, instance, feature)  # para negar las que tengan un not en la constraint
            model.ctcs.append(new_constraint)


        model.ctcs.remove(instance)

        # New branch with OR as root
        rel_or = Relation(new_or, features, 1, len(features))  # OR
        new_or.add_relation(rel_or)
        
        # New root
        new_root = Feature(utils.get_new_feature_name(model, 'root'), is_abstract=True)
        rel_1 = Relation(new_root, [model.root], 1, 1)  # mandatory
        new_root.add_relation(rel_1)
        rel_2 = Relation(new_root, [new_or], 1, 1)  # mandatory
        new_root.add_relation(rel_2)
        model.root = new_root
        
        return model

def read_complex_constraint(model: FeatureModel, instance: Constraint, feature: Feature) -> Constraint:
    
    left_data = instance.ast.root.left.data
    right_data = instance.ast.root.right.data
    if left_data is ASTOperation.OR:
        data = read_complex_constraint(model, instance.ast.root.left)
    if right_data is ASTOperation.OR:
        data = read_complex_constraint(model, instance.ast.root.right)
    # if left_data is ASTOperation.NOT:
    #     left_data = instance.ast.root.left.data
    # if right_data is ASTOperation.NOT:
    #     right_data = instance.ast.root.left.data
    feature_data = model.get_feature_by_name(data)
    new_feature = Feature(utils.get_new_feature_name(model, data.name), is_abstract=True)
    new_instance = AST.create_binary_operation(ASTOperation.IMPLIES, new_feature, feature_data)
    model.ctcs.append(new_instance)
    return new_instance