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

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraintsRequires(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Requires'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_requires_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_requires_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        model_less = copy.deepcopy(model)

        right_feature_name_ctc = instance.ast.root.right.data
        list_right_feature_ctc_plus = [right_feature_name_ctc] + [key for key, value in model.dict_references.items() 
                                        if value.name == right_feature_name_ctc]
        xor_plus = Feature(utils.get_new_feature_name(model, 'XOR'), is_abstract=True)

        list_right_feature_ctc_less = [right_feature_name_ctc] + [key for key, value in model.dict_references.items() 
                                        if value.name == right_feature_name_ctc]

        if instance.ast.root.data in [ASTOperation.REQUIRES, ASTOperation.IMPLIES]:
            left_feature_name_ctc = instance.ast.root.left.data
        elif instance.ast.root.data is ASTOperation.OR:
            not_operation = instance.ast.root.left
            left_feature_name_ctc = not_operation.left.data
        list_left_feature_ctc_plus = [left_feature_name_ctc] + [key for key, value in model.dict_references.items() 
                                        if value.name == left_feature_name_ctc]
        list_left_feature_ctc_less = [left_feature_name_ctc] + [key for key, value in model.dict_references.items() 
                                        if value.name == left_feature_name_ctc]


        right_feature_ctc_plus = model.get_feature_by_name(right_feature_name_ctc)
        right_feature_ctc_less = model_less.get_feature_by_name(right_feature_name_ctc)
        left_feature_ctc_plus = model.get_feature_by_name(left_feature_name_ctc)
        left_feature_ctc_less = model_less.get_feature_by_name(left_feature_name_ctc)

        list_model_plus = [utils.get_top_feature(right_feature_ctc_plus), utils.get_top_feature(left_feature_ctc_plus)]
        list_model_less = [utils.get_top_feature(right_feature_ctc_less), utils.get_top_feature(left_feature_ctc_less)]

        plus_root = Feature('plus', is_abstract=True)
        for f in list_model_plus:
            get_rel = next((rel for rel in model.get_relations() if f in rel.children), None)
            if get_rel is not None:
                get_rel.parent.get_relations().remove(get_rel)
            new_rel = Relation(plus_root, [f], 1, 1)  #mandatory
            plus_root.add_relation(new_rel)
            f.parent = plus_root
        
        model_plus = FeatureModel(plus_root)
        model_plus.root.name = utils.get_new_feature_name(model, plus_root.name)


        less_root = Feature('less', is_abstract=True)
        for f in list_model_less:
            new_rel = Relation(less_root, [f], 1, 1)  #mandatory
            less_root.add_relation(new_rel)
            f.parent = less_root
        
        model_less = FeatureModel(less_root)
        model_less.root.name = utils.get_new_feature_name(model, less_root.name)


        model_plus = utils.add_node_to_tree(model_plus, right_feature_ctc_plus)


        model_less = utils.eliminate_node_from_tree(model_less, left_feature_ctc_less)
        model_less = utils.eliminate_node_from_tree(model_less, right_feature_ctc_less)


        # plus_roots = []
        # for f_plus in list_right_feature_ctc_plus:
        #     feature_left_plus = model.get_feature_by_name(next(f for f in list_left_feature_ctc_plus))
        #     feature_right_plus = model.get_feature_by_name(f_plus)
        #     top_left = utils.get_top_feature(feature_left_plus)
        #     top_right = utils.get_top_feature(feature_right_plus)
        #     model_plus = utils.add_node_to_tree([top_left, top_right], f_plus)
        #     if model_plus is not None:
        #         old_root = model_plus.root
        #         model_plus = remove_abstract_child(model_plus, old_root)
        #         if old_root != model_plus.root:
        #             new_rel = Relation(old_root, [model_plus.root], 1, 1)  # mandatory
        #             old_root.add_relation(new_rel)
        #             model_plus.root.parent = old_root
        #         plus_roots.append(model_plus.root)
        # # Joining all trees with XOR
        # if len(plus_roots)>1:
        #     r_xor_plus = Relation(xor_plus, plus_roots, 1, 1)  # XOR
        #     xor_plus.add_relation(r_xor_plus)
        #     model_plus.root = xor_plus
        #     for child in plus_roots:
        #         child.parent = xor_plus
        #     count = 1
        #     for r in xor_plus.get_children():
        #         r.name = f'{utils.get_new_feature_name(model, r.name)}{count}'
        #         count += 1
        
        # print(f'T(+{list_right_feature_ctc_plus}: {model_plus}')


        # for f_left_less in list_left_feature_ctc_less:
        #     feature_left_less = model.get_feature_by_name(f_left_less)
        #     feature_right_less = model.get_feature_by_name(next(f for f in list_right_feature_ctc_less))
        #     top_left_less = utils.get_top_feature(feature_left_less)
        #     top_right_less = utils.get_top_feature(feature_right_less)
        #     model_less = utils.eliminate_node_from_tree([top_left_less, top_right_less], f_left_less)

        # for f_right_less in list_right_feature_ctc_less:
        #     model_less = utils.eliminate_node_from_tree(model_less.root.get_children(), f_right_less)

        # Construct T(+B) and T(-A-B).
        m_root = model.root
        print(f'm_root: {m_root.name}')
        if model_plus is not None and model_less is not None:
            # If both trees are not equal to NIL, then the result consists of a new root, which
            # is an Xor feature, with subfeatures T(+B) and T(-A-B).
            new_xor = Feature(utils.get_new_feature_name(model, 'new_xor'), is_abstract=True)
            rel = Relation(new_xor, [model_plus.root, model_less.root], 1, 1)  #XOR
            new_xor.add_relation(rel)
            m_root.get_children().append(new_xor)
            if m_root.is_or_group():
                root_rel = next((r for r in m_root.get_relations()), None)
                root_rel.card_max+=1
            elif not m_root.is_group():
                new_root_rel = Relation(m_root, [new_xor], 1, 1)  # mandatory
                m_root.get_relations().append(new_root_rel)
            new_xor.parent = m_root
        elif model_less is None:
            # If T(-A-B) is equal to NIL, then the result is T(+B).
            new_rel_plus = Relation(m_root, [model_plus.root], 1, 1)  #mandatory
            m_root.add_relation(new_rel_plus)
            model_plus.root.parent = m_root
        elif model_plus is None:
            # If T(+B) is equal to NIL, then the result is T(-A-B). 
            new_rel_less = Relation(m_root, [model_less.root], 1, 1)  #mandatory
            m_root.add_relation(new_rel_less)
            model_less.root.parent = m_root

        model.ctcs.remove(instance)

        # Changing names to avoid duplicates
        # CUIDADO!!! (puede que haya que modificarlo)
        if model_less is not None and model_plus is not None:
            for feature in model_less.get_features():
                if feature in model_plus.get_features() and not feature.name in model.dict_references.keys():
                    # print(f'feature NOT in model dict reference: {feature.name}')
                    feature_reference = model.get_feature_by_name(feature.name)  # aquí se va a poner el nombre que se encuentre en el feature model
                    # hay que ponerle el nombre de la feature que haya en dict_references.values()
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    if feature != feature_reference:
                        model.dict_references[feature.name] = feature_reference
                elif feature.name in model.dict_references.keys():
                    feature_dict_value = model.dict_references[feature.name]
                    # print(f'feature in model dict reference: {feature.name}')
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    if feature != feature_dict_value:
                        model.dict_references[feature.name] = feature_dict_value
        
        # print(f'Dict references requires: {[value.name for value in model.dict_references.values()]}')

        print(f'MODEL REQUIRES after: {model}')
        
        return model



def remove_abstract_child(fm: FeatureModel, feature: Feature) -> FeatureModel:
    feature_relations = feature.get_relations()
    feature_next_rel = next(r for r in feature_relations)
    feature_next_abstract = next(c for c in feature.get_children())
    if len(feature_relations)==1 and feature_next_rel.is_mandatory() and feature_next_abstract.is_abstract:
            feature.get_relations().remove(feature_next_rel)
            fm.root = feature_next_abstract
            fm = remove_abstract_child(fm, feature_next_abstract)
    return fm