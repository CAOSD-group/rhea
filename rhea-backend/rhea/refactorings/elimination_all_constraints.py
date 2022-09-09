from asyncio import constants
from turtle import left
from typing import Any, Dict

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from flamapy.core.models.ast import AST, ASTOperation, Node

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils
from rhea.metamodels.fm_metamodel.models import fm_utils


class EliminationAllConstraints(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of All Constraints from Feature Trees'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'Constraint {instance} is None.')

        for ctc in fm_utils.split_constraint(instance):
            model.ctcs.append(ctc)

        model.ctcs.remove(instance)

        print(f'MODEL (elimination all constraints): {model}')
        
        return model