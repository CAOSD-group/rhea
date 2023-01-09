import copy
from typing import Any
import datetime

from flamapy.core.models import AST, ASTOperation, ast
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Constraint, Relation

from rhea.metamodels.fm_metamodel.models import fm_utils
from rhea.refactorings import utils

from rhea.metamodels.fm_metamodel.models import Type


def spl(fm: FeatureModel, f: Feature) -> list[list[Feature]]:  # feature or f.name?????
    c_f = None # constraints that affects feature f
    for child in f.get_children():
        spl(child)
        # c_f = constraints_with_node(fm, f) | constraints_with_node(fm, child)
    
    

def constraints_with_node(fm: FeatureModel, f_name: str) -> list[Constraint]:
    f = fm.get_feature_by_name(f_name)
    c_list = []
    for ctc in fm.get_constraints():
        for f in ctc.get_features():
            if f_name == f:
                c_list.append(ctc)
    return c_list


def affirmated_literals():
    pass

def negated_literals():
    pass




def configurations_feature(fm: FeatureModel, f_name: str) -> FeatureModel:
    fm = fm_utils.commitment_feature(fm, f_name)
    return fm