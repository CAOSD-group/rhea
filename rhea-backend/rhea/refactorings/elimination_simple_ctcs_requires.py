import copy
from ctypes import util
from hashlib import new
from logging import root
from msilib.schema import FeatureComponents
from numbers import Real
from pyexpat import model
from statistics import mode
from typing import Any, List

from flamapy.core.models.ast import AST, ASTOperation, Node
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from flamapy.metamodels.fm_metamodel.transformations import UVLWriter

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraintsRequires(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Requires'
    
    @staticmethod
    def get_description() -> str:
        return ("It eliminates de simple constraint with Requires")

    @staticmethod
    def get_language_construct_name() -> str:
        return 'Constraint'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_requires_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_requires_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        model_plus = copy.deepcopy(model)
        model_less = copy.deepcopy(model)

        right_feature_name_ctc = utils.get_right_feature_name(instance)
        list_right_features_plus_ctc = [f for f in model_plus.get_features()
                                        if f.name == right_feature_name_ctc]
        # print(f'Features pluss: {[(f.name, [str(r) for r in f.parent.parent.relations]) for f in list_right_features_plus_ctc]}')
        list_right_features_less_ctc = [f for f in model_less.get_features()
                                        if f.name == right_feature_name_ctc]
        # print(f'Features less: {[(f.name, [str(r) for r in f.parent.parent.relations]) for f in list_right_features_less_ctc]}')
        left_feature_name_ctc = utils.get_left_feature_name(instance)
        list_left_features_less_ctc = [f for f in model_less.get_features() 
                                       if f.name == left_feature_name_ctc]

        
        
        model_plus = get_model_plus(model_plus, list_right_features_plus_ctc)
        model_less = get_model_less(model_less, list_left_features_less_ctc)
        model_less = get_model_less(model_less, list_right_features_less_ctc)


        # Construct T(+B) and T(-A-B).
        if model_plus is not None and model_less is not None:
            # If both trees are not equal to NIL, then the result consists of a new root, which
            # is an Xor feature, with subfeatures T(+B) and T(-A-B).
            new_root = Feature(utils.get_new_feature_name(model, 'root'), is_abstract=True)
            rel = Relation(new_root, [model_plus.root, model_less.root], 1, 1)  #XOR
            new_root.add_relation(rel)
            model.root = new_root
            model_plus.root.parent = new_root
            model_less.root.parent = new_root
        elif model_less is None:
            # If T(-A-B) is equal to NIL, then the result is T(+B).
            model = model_plus
        elif model_plus is None:
            # If T(+B) is equal to NIL, then the result is T(-A-B). 
            model = model_less

        model.ctcs.remove(instance)

        UVLWriter(model, f"tests/requires_output/requires{instance}.uvl").transform()
        
        return model

def get_model_plus(model: FeatureModel, f_list: list[Feature]) -> FeatureModel:
    for f in f_list:
        if model is not None:
            model = utils.add_node_to_tree(model, f)
    # plus_roots = []
    # for f in f_list:
    #     model = utils.add_node_to_tree(model, f)
    #     #model = utils.remove_abstract_child(model, model.root)
    #     plus_roots.append(model.root)
    # if len(f_list)>1:
    #     xor_plus = Feature(utils.get_new_feature_name(model, 'XOR'), is_abstract=True)
    #     r_xor_plus = Relation(xor_plus, plus_roots, 1, 1)  # XOR
    #     xor_plus.add_relation(r_xor_plus)
    #     model.root = xor_plus
    #     for root in plus_roots:
    #         root.parent = xor_plus
    return model

def get_model_less(model: FeatureModel, f_list: list[Feature]) -> FeatureModel:
    for f_left_less in f_list:
        if model is not None:
            model = utils.eliminate_node_from_tree(model, f_left_less)
    return model