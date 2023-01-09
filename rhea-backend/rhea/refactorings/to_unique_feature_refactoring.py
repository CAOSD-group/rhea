from typing import Any
import utils

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

import itertools
import functools

from flamapy.core.models.ast import AST, ASTOperation, Node

from rhea.refactorings import FMRefactoring


class ToUniqueFeatureRefactoring(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'To Unique Feature Refactoring'

    @staticmethod
    def get_description() -> str:
        return ("It takes reapeated features and make them unique by adding a new attribute "
                "with the original feature. ")

    @staticmethod
    def get_language_construct_name() -> str:
        return 'To Unique Feature'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [f for f in model.get_features() if f.is_cardinality_group()]

    @staticmethod
    def is_applicable(model: FeatureModel) -> bool:
        return True

    @staticmethod
    def transform(fm: FeatureModel) -> FeatureModel:
        """Replace duplicated features names."""
        if not hasattr(fm, 'dict_references'):
                fm.dict_references = {}
        unique_features_names = []
        for f in fm.get_features():
            if f.name not in unique_features_names:
                unique_features_names.append(f.name)
            else:
                new_name = utils.get_new_feature_name(fm, f.name)
                fm.dict_references[new_name] = f.name
                f.name = new_name
                unique_features_names.append(f.name)
        return fm