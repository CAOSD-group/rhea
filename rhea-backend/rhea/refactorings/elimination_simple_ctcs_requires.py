import copy
from ctypes import util
from hashlib import new
from logging import root
from msilib.schema import FeatureComponents
from numbers import Real
from pyexpat import model
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
    def is_applicable(model: FeatureModel) -> bool:
        return True

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_requires_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        if not hasattr(model, 'dict_references'):
            model.dict_references = {}
        model_plus = copy.deepcopy(model)
        model_less = copy.deepcopy(model)

        right_feature_name_ctc = utils.get_right_feature_name(instance)

        list_right_feature_ctc_plus = [right_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_right_feature_ctc_plus += [key for key, value in model.dict_references.items() 
                                            if value.name == right_feature_name_ctc]
        xor_plus = Feature(utils.get_new_feature_name(model_plus, 'XOR'), is_abstract=True)

        list_right_feature_ctc_less = [right_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_right_feature_ctc_less += [key for key, value in model.dict_references.items() 
                                                 if value.name == right_feature_name_ctc]


        left_feature_name_ctc = utils.get_left_feature_name(instance)

        list_left_feature_ctc_less_plus = [left_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_left_feature_ctc_less_plus += [key for key, value in model.dict_references.items() 
                                                if value.name == left_feature_name_ctc]


        plus_roots = []
        for f in list_right_feature_ctc_plus:
            model_plus = utils.add_node_to_tree(model, f)
            plus_roots.append(model_plus.root)
            model_plus = utils.remove_abstract_child(model_plus, model_plus.root)
        new_root = Feature(utils.get_new_feature_name(model_plus, 'root'), plus_roots, is_abstract=True)

        model_less = get_less(model, feature)
        new_xor = new_xor(plus, less)



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

        # Changing names to avoid duplicates
        # CUIDADO!!! (puede que haya que modificarlo)
        if model_less is not None and model_plus is not None:
            for feature in model_less.get_features():
                if feature in model_plus.get_features() and not feature.name in model.dict_references.keys():
                    feature_reference = model.get_feature_by_name(feature.name)
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    if feature != feature_reference:
                        model.dict_references[feature.name] = feature_reference
                elif feature.name in model.dict_references.keys():
                    feature_dict_value = model.dict_references[feature.name]
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    if feature != feature_dict_value:
                        model.dict_references[feature.name] = feature_dict_value
        
        # print(f'Dict references requires: {[value.name for value in model.dict_references.values()]}')

        print(f'MODEL DICT REQUIRES - after: {[(name, value.name) for name, value in model.dict_references.items()]}')
        # print(f'MODEL REQUIRES after: {model}')

        UVLWriter(model, f"requires{instance}.uvl").transform()
        
        return model