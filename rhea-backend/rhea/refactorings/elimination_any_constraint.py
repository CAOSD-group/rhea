from asyncio import constants
from statistics import mode
from turtle import left
from typing import Any, Dict

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from flamapy.core.models.ast import AST, ASTOperation, Node
from rhea.refactorings.split_constraints import SplitConstraints
from rhea.refactorings.elimination_complex_constraints import EliminationComplexConstraints
from rhea.refactorings.elimination_simple_ctcs_requires import EliminationSimpleConstraintsRequires
from rhea.refactorings.elimination_simple_ctcs_excludes import EliminationSimpleConstraintsExcludes

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils
from rhea.metamodels.fm_metamodel.models import fm_utils


class EliminationAnyConstraints(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Any Constraint from Feature Trees'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'Constraint {instance} is None.')

        
        REFACTORING_SPLIT = SplitConstraints
        REFACTORING_COMPLEX = EliminationComplexConstraints
        REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
        REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes

        print(f'INSTANCE: {instance}')
        ctc_list = model.get_constraints()
        print(f'ctc list: {[str(ctc) for ctc in ctc_list]}')
        

        print(f'Applying the refactoring {REFACTORING_SPLIT.get_name()}...')
        model = REFACTORING_SPLIT.transform(model, instance)

        ctc_list_after_split = model.get_constraints()
        print(f'ctc list after split: {[str(ctc) for ctc in ctc_list_after_split]}')

        for i in ctc_list - ctc_list_after_split:
            print(f'Applying the refactoring {REFACTORING_COMPLEX.get_name()}...')
            model = REFACTORING_COMPLEX.transform(model, i)

        ctc_list_after_complex = model.get_constraints()
        print(f'ctc list after split: {[str(ctc) for ctc in ctc_list_after_complex]}')

        
        for i in ctc_list - ctc_list_after_split:
            if i.is_requires_constraint():
                print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()}...')
                model = REFACTORING_REQUIRES.transform(model, i)
            if i.is_excludes_constraint():
                print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()}...')
                model = REFACTORING_EXCLUDES.transform(model, i)
        return model

