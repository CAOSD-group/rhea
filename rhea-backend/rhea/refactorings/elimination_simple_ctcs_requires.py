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
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_requires_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        if not hasattr(model, 'dict_references'):
            model.dict_references = {}
        model_plus = copy.deepcopy(model)  # copy.deepcopy(model)
        model_less = copy.deepcopy(model)

        print(f'MODEL DICT REQUIRES - before: {[(name, value.name) for name, value in model.dict_references.items()]}')

        # dict_keys = []
        # for key, value in model.dict_references.items():
        #     if value not in model.get_features():
        #         dict_keys.append(key)
        # for k in dict_keys:
        #     del model.dict_references[k]

        print(f'Instance: {str(instance)}')

        # print(f'Dict FIRST requires: {[key for key in model.dict_references.keys()]}')
        # print(f'MODEL REQUIRES before: {model}')

        right_feature_name_ctc = instance.ast.root.right.data
        list_right_feature_ctc_plus = [right_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_right_feature_ctc_plus += [key for key, value in model.dict_references.items() 
                                            if value.name == right_feature_name_ctc]
        xor_plus = Feature(utils.get_new_feature_name(model_plus, 'XOR'), is_abstract=True)
        print(f'LIST RIGHT FEATURE CTC PLUS: {[f for f in list_right_feature_ctc_plus]}')

        list_right_feature_ctc_less = [right_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_right_feature_ctc_less += [key for key, value in model.dict_references.items() 
                                            if value.name == right_feature_name_ctc]
        print(f'LIST RIGHT FEATURE CTC LESS: {[f for f in list_right_feature_ctc_less]}')

        left_feature_name_ctc = utils.get_left_feature_name(instance)
        
        list_left_feature_ctc_less = [left_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_left_feature_ctc_less += [key for key, value in model.dict_references.items() 
                                           if value.name == left_feature_name_ctc]
        xor_less = Feature(utils.get_new_feature_name(model_less, 'XOR'), is_abstract=True)
        print(f'LIST LEFT FEATURE CTC LESS: {[f for f in list_left_feature_ctc_less]}')

        plus_roots = []
        for f_plus in list_right_feature_ctc_plus:
            new_model_plus = copy.deepcopy(model)
            if f_plus in model.dict_references.keys() and new_model_plus is not None:
                new_f_plus = new_model_plus.get_feature_by_name(f_plus)
                new_model_plus = utils.add_node_to_tree(new_model_plus, new_f_plus)
                if new_model_plus is not None:
                    model_plus = new_model_plus
            elif model_plus is not None:
                feature_plus = model_plus.get_feature_by_name(f_plus)
                model_plus = utils.add_node_to_tree(model_plus, feature_plus)
            if model_plus is not None:
                old_root = model_plus.root
                model_plus = utils.remove_abstract_child(model_plus, old_root)
                if old_root != model_plus.root:
                    new_rel = Relation(old_root, [model_plus.root], 1, 1)  # mandatory
                    old_root.add_relation(new_rel)
                    model_plus.root.parent = old_root
                if model_plus.root not in plus_roots:
                    plus_roots.append(model_plus.root)
        # Joining all trees with XOR

        if len(plus_roots)>1:
            r_xor_plus = Relation(xor_plus, plus_roots, 1, 1)  # XOR
            xor_plus.add_relation(r_xor_plus)
            model_plus.root = xor_plus
            for child in plus_roots:
                child.parent = xor_plus
            count = 1
            for r in xor_plus.get_children():
                r.name = f'{utils.get_new_feature_name(model, r.name)}{count}'
                count += 1

        # print(f'T(+{list_right_feature_ctc_plus}): {model_plus}')

        # for f_left_less in list_left_feature_ctc_less:
        #     if model_less is not None:
        #         feature_left_less = model_less.get_feature_by_name(f_left_less)
        #         model_less = utils.eliminate_node_from_tree(model_less, feature_left_less)
        #     # print(f'T(-{f_left_less}): {model_less}')



        new_model_less = copy.deepcopy(model_less)

        left_less_roots = []
        for f_left_less in list_left_feature_ctc_less:
            left_new_model_less = copy.deepcopy(new_model_less)
            if f_left_less in model.dict_references.keys() and left_new_model_less is not None:
                new_f_less = left_new_model_less.get_feature_by_name(f_left_less)
                model_less = utils.eliminate_node_from_tree(left_new_model_less, new_f_less)
            elif model_less is not None:
                feature_less = model_less.get_feature_by_name(f_left_less)
                model_less = utils.eliminate_node_from_tree(model_less, feature_less)
            if model_less is not None:
                old_root = model_less.root
                model_less = utils.remove_abstract_child(model_less, old_root)
                if old_root != model_less.root:
                    new_rel = Relation(old_root, [model_less.root], 1, 1)  # mandatory
                    old_root.add_relation(new_rel)
                    model_less.root.parent = old_root
                if model_less.root not in left_less_roots:
                    left_less_roots.append(model_less.root)
        # Joining all trees with XOR
        if len(left_less_roots)>1:
            r_xor_less = Relation(xor_less, left_less_roots, 1, 1)  # XOR
            xor_less.add_relation(r_xor_less)
            for child in left_less_roots:
                child.parent = xor_less
            if model_less is not None:
                model_less.root = xor_less
            else:
                model_less = FeatureModel(xor_less, new_model_less.ctcs)
            count = 1
            for r in xor_less.get_children():
                r.name = f'{utils.get_new_feature_name(model, r.name)}{count}'
                count += 1





        for f_right_less in list_right_feature_ctc_less:
            if model_less is not None:
                feature_right_less = model_less.get_feature_by_name(f_right_less)
                model_less = utils.eliminate_node_from_tree(model_less, feature_right_less)
            # print(f'T(-{f_right_less}): {model_less}')







        model_plus = utils.remove_abstract_leaf_without_reference(model_plus)
        model_less = utils.remove_abstract_leaf_without_reference(model_less)

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