import copy
from typing import Any

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from flamapy.metamodels.fm_metamodel.transformations import UVLWriter

from flamapy.core.models.ast import AST, ASTOperation, Node

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper, fm_utils
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraintsExcludes(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Excludes'
    
    @staticmethod
    def get_description() -> str:
        return ("It eliminates de simple constraint with Excludes")

    @staticmethod
    def get_language_construct_name() -> str:
        return 'Constraint'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_excludes_constraint()]

    @staticmethod
    def is_applicable(model: FeatureModel) -> bool:
        return True

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        return fm_utils.eliminate_excludes(model, instance)