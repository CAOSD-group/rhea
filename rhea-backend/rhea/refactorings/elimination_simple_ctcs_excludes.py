import copy
from typing import Any

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from flamapy.core.models.ast import AST, ASTOperation, Node

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraintsExcludes(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Excludes'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_excludes_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_excludes_constraint():
            raise Exception(f'Operator {str(instance)} is not excludes.')

        print(f'Instance: {str(instance)}')

        if not hasattr(model, 'dict_references'):
            model.dict_references = {}
        model_less = copy.deepcopy(model)
        model_less_plus = copy.deepcopy(model)

        # print(f'MODEL DICT EXCLUDES - before: {[(name, value.name) for name, value in model.dict_references.items()]}')

        dict_keys = []
        for key, value in model.dict_references.items():
            if value not in model.get_features():
                dict_keys.append(key)
        for k in dict_keys:
            del model.dict_references[k]

        # print(f'MODEL EXCLUDES before: {model}')

        if instance.ast.root.data in [ASTOperation.REQUIRES, ASTOperation.IMPLIES, ASTOperation.OR]:
            not_operation = instance.ast.root.right
            right_feature_name_ctc = not_operation.left.data
        elif instance.ast.root.data is ASTOperation.EXCLUDES:
            right_feature_name_ctc = instance.ast.root.right.data

        list_right_feature_ctc_less = [right_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_right_feature_ctc_less += [key for key, value in model.dict_references.items() 
                                            if value.name == right_feature_name_ctc]
        # print(f'LIST RIGHT FEATURE CTC LESS: {[f for f in list_right_feature_ctc_less]}')

        list_right_feature_ctc_less_plus = [right_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_right_feature_ctc_less_plus += [key for key, value in model.dict_references.items() 
                                                 if value.name == right_feature_name_ctc]
        # print(f'LIST RIGHT FEATURE CTC LESS PLUS: {[f for f in list_right_feature_ctc_less_plus]}')


        if instance.ast.root.data in [ASTOperation.REQUIRES, ASTOperation.IMPLIES, ASTOperation.EXCLUDES]:
            left_feature_name_ctc = instance.ast.root.left.data
        elif instance.ast.root.data is ASTOperation.OR:
            not_operation = instance.ast.root.left
            left_feature_name_ctc = not_operation.left.data

        xor_plus = Feature(utils.get_new_feature_name(model_less, 'XOR'), is_abstract=True)
        list_left_feature_ctc_less_plus = [left_feature_name_ctc]
        if hasattr(model, 'dict_references'):
            list_left_feature_ctc_less_plus += [key for key, value in model.dict_references.items() 
                                                if value.name == left_feature_name_ctc]
        # print(f'LIST LEFT FEATURE CTC LESS PLUS: {[f for f in list_left_feature_ctc_less_plus]}')


        for f_right_less in list_right_feature_ctc_less:
            if model_less is not None:
                feature_right_less = model_less.get_feature_by_name(f_right_less)
                model_less = utils.eliminate_node_from_tree(model_less, feature_right_less)


        for f_left_less_plus in list_left_feature_ctc_less_plus:
            if model_less_plus is not None:
                feature_left_less_plus = model_less_plus.get_feature_by_name(f_left_less_plus)
                model_less_plus = utils.eliminate_node_from_tree(model_less_plus, feature_left_less_plus)

        new_model_less = copy.deepcopy(model_less_plus)

        plus_roots = []
        for f_less_plus in list_right_feature_ctc_less_plus:
            new_model_less_plus = copy.deepcopy(new_model_less)
            if f_less_plus in model.dict_references.keys() and new_model_less_plus is not None:
                new_f_less_plus = new_model_less_plus.get_feature_by_name(f_less_plus)
                model_less_plus = utils.add_node_to_tree(new_model_less_plus, new_f_less_plus)
            elif model_less_plus is not None:
                feature_less_plus = model_less_plus.get_feature_by_name(f_less_plus)
                model_less_plus = utils.add_node_to_tree(model_less_plus, feature_less_plus)
            if model_less_plus is not None:
                old_root = model_less_plus.root
                model_less_plus = utils.remove_abstract_child(model_less_plus, old_root)
                if old_root != model_less_plus.root:
                    new_rel = Relation(old_root, [model_less_plus.root], 1, 1)  # mandatory
                    old_root.add_relation(new_rel)
                    model_less_plus.root.parent = old_root
                if model_less_plus.root not in plus_roots:
                    plus_roots.append(model_less_plus.root)
        # Joining all trees with XOR
        if len(plus_roots)>1:
            r_xor_plus = Relation(xor_plus, plus_roots, 1, 1)  # XOR
            xor_plus.add_relation(r_xor_plus)
            for child in plus_roots:
                child.parent = xor_plus
            if model_less_plus is not None:
                model_less_plus.root = xor_plus
            else:
                model_less_plus = FeatureModel(xor_plus, new_model_less_plus.ctcs)
            count = 1
            for r in xor_plus.get_children():
                r.name = f'{utils.get_new_feature_name(model, r.name)}{count}'
                count += 1


        # Removing all abbstract LEAF nodes without contraint (before joining subtrees)
        if model_less is not None:
            for feat in model.get_features():
                ctc = next((ctc for ctc in model.get_constraints() if ctc.ast.root.left.data == feat 
                                                                    or (ctc.ast.root.left.data == ASTOperation.NOT 
                                                                    and ctc.ast.root.left.left == feat)), None)
                if ctc is not None:
                    if feat.is_leaf() and feat.is_abstract and ctc.ast.root.right.left.data not in model_less:
                        model_less = utils.eliminate_node_from_tree(model_less, feat)

        # Construct T(-B) and T(-A+B).
        if model_less is not None and model_less_plus is not None:
            # If both trees are not equal to NIL, then the result consists of a new root, which
            # is an Xor feature with subtrees T(-B) and T(-A+B). 
            new_root = Feature(utils.get_new_feature_name(model, 'root'), is_abstract=True)
            rel = Relation(new_root, [model_less.root, model_less_plus.root], 1, 1)  #XOR
            new_root.add_relation(rel)
            model_less.root.parent = new_root
            model_less_plus.root.parent = new_root
            model.root = new_root
        elif model_less is None:
            # If T(-B) is equal to NIL, then the result is T(-A+B). 
            model = model_less_plus
        elif model_less_plus is None:
            # If T(-A+B) is equal to NIL, then the result is T(-B). 
            model = model_less
        
        model.ctcs.remove(instance)

        # Changing names to avoid duplicates
        if model_less is not None and model_less_plus is not None:
            for feature in model_less_plus.get_features():
                if feature in model_less.get_features() and not feature.name in model.dict_references.keys():
                    feature_reference = model.get_feature_by_name(feature.name)
                    # print(f'feature reference: {feature_reference}')
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    if feature != feature_reference:
                        model.dict_references[feature.name] = feature_reference
                        # print(f'feature reference: {feature_reference}')
                elif feature.name in model.dict_references.keys():
                    feature_dict_value = model.dict_references[feature.name]
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    if feature != feature_dict_value:
                        model.dict_references[feature.name] = feature_dict_value
                
        # print(f'Dict references excludes: {[value.name for value in model.dict_references.values()]}')
        # print(f'Dict keys excludes: {[key for key in model.dict_references.keys()]}')

        # print(f'MODEL DICT EXCLUDES - after: {[(name, value.name) for name, value in model.dict_references.items()]}')
        # print(f'MODEL EXCLUDES after: {model}')

        return model