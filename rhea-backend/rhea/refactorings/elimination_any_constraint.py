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


REFACTORING_COMPLEX = EliminationComplexConstraints
REFACTORING_REQUIRES = EliminationSimpleConstraintsRequires
REFACTORING_EXCLUDES = EliminationSimpleConstraintsExcludes


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
        
        if fm_utils.is_complex_constraint(instance):
            # split
            ctc_list = fm_utils.split_constraint(instance)
            model.get_constraints().remove(instance)
            original_ctcs = set(model.get_constraints())
            model.get_constraints().extend(ctc_list)
            
            for ctc in ctc_list:
                if fm_utils.is_complex_constraint(ctc):
                    # aplicas el refactoring del complex
                    model = REFACTORING_COMPLEX.transform(model, ctc)

            new_ctcs = set(model.get_constraints()) - original_ctcs

            for ctc in new_ctcs:
                if fm_utils.is_requires_constraint(ctc):
                    #print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()}...')
                    model = REFACTORING_REQUIRES.transform(model, ctc)
                elif fm_utils.is_excludes_constraint(ctc):
                    #print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()}...')
                    model = REFACTORING_EXCLUDES.transform(model, ctc)
                else:
                    raise Exception(f'Invalid simple constraint: {ctc}')
        else:
            if fm_utils.is_requires_constraint(instance):
                #print(f'Applying the refactoring {REFACTORING_REQUIRES.get_name()}...')
                model = REFACTORING_REQUIRES.transform(model, instance)
            elif fm_utils.is_excludes_constraint(instance):
                #print(f'Applying the refactoring {REFACTORING_EXCLUDES.get_name()}...')
                model = REFACTORING_EXCLUDES.transform(model, instance)
            else:
                raise Exception(f'Invalid simple constraint: {instance}')

        return model