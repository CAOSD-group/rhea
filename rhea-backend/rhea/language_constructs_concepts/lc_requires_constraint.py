from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from rhea.language_constructs import LanguageConstruct 
from rhea.refactorings import FMRefactoring
from rhea.metamodels.fm_metamodel.models import fm_utils

class LCRequiresConstraint(LanguageConstruct):

    @staticmethod
    def name() -> str:
        return 'Requires Constraint'

    @staticmethod
    def get_instances(fm: FeatureModel) -> list[Constraint]:
        return [c for c in fm.get_constraints() if fm_utils.is_requires_constraint(c)]

    @staticmethod
    def get_refactorings() -> list[FMRefactoring]:
        return []