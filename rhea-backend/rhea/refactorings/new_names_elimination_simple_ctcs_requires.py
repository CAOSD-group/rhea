import copy
from ctypes import util
from logging import root
from pyexpat import model
from typing import Any

from flamapy.core.models.ast import AST, ASTOperation, Node
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from rhea.flamapy2.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class NewNamesEliminationSimpleConstraintsRequires(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Requires (changing names)'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_requires_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_requires_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        print(f'MODELO: {model}')
        model_plus = copy.deepcopy(model)
        model_less = copy.deepcopy(model)

        right_feature_name_ctc = instance.ast.root.right.data
        right_feature_ctc_plus = model_plus.get_feature_by_name(right_feature_name_ctc)
        #list_right_feature_ctc_plus = get_features_reference(model_plus, right_feature_name_ctc)
        #print(f'features de la derecha PLUS: {list_right_feature_ctc_plus}')
        right_feature_ctc_less = model_less.get_feature_by_name(right_feature_name_ctc)
        #list_right_feature_ctc_less = get_features_reference(model_less, right_feature_name_ctc)
        #print(f'features de la derecha LESS: {list_right_feature_ctc_less}')

        left_feature_name_ctc = instance.ast.root.left.data
        left_feature_ctc_less = model_less.get_feature_by_name(left_feature_name_ctc)
        #list_left_feature_ctc_less = get_features_reference(model_less, left_feature_name_ctc)
        #print(f'features de la izquierda LESS: {list_left_feature_ctc_less}')


        if model_plus is not None:
            for feature_plus in model_plus.get_features():
                if hasattr(feature_plus, 'reference'):
                    print(f'ATRIBUTO DE {feature_plus} en model plus: {getattr(feature_plus, "reference")}')
                    feature_plus.name = feature_plus.reference.name
        if model_plus is not None:
            model_plus = utils.add_node_to_tree(model_plus, right_feature_ctc_plus)
        print('----my relations PLUSS-----')
        for r in model_plus.get_relations():
            print(f'Relation (pluss): ({r.parent}, {[f.name for f in r.children]}, {r.card_min}, {r.card_max})')
        print(f'T(+{right_feature_ctc_plus}): {model_plus}')
        

        # print(f'FEATURES DE MODEL LESS 1: {[str(f) for f in model_less.get_features()]}')
        if model_less is not None:
            for feature_less in model_less.get_features():
                if hasattr(feature_less, 'reference'):
                    print(f'ATRIBUTO DE {feature_less} en model less 1: {getattr(feature_less, "reference")}')
                    feature_less.name = feature_less.reference.name
        if model_less is not None:
            model_less = utils.eliminate_node_from_tree(model_less, left_feature_ctc_less)
        print('----my relations LESS 1-----')
        for r in model_less.get_relations():
            print(f'Relation (less): ({r.parent}, {[f.name for f in r.children]}, {r.card_min}, {r.card_max})')
        print(f'T(-{left_feature_ctc_less}): {model_less}')
        

        # print(f'FEATURES DE MODEL LESS 2: {[str(f) for f in model_less.get_features()]}')
        if model_less is not None:
            for feature_less in model_less.get_features():
                if hasattr(feature_less, 'reference'):
                    print(f'ATRIBUTO DE {feature_less} en model less 2: {getattr(feature_less, "reference")}')
                    feature_less.name = feature_less.reference.name
        if model_less is not None:
            model_less = utils.eliminate_node_from_tree(model_less, right_feature_ctc_less)
        print('----my relations LESS 2-----')
        for r in model_less.get_relations():
            print(f'Relation (less): ({r.parent}, {[f.name for f in r.children]}, {r.card_min}, {r.card_max})')
        print(f'T(-{right_feature_ctc_less}): {model_less}')
        
        # for feature in list_right_feature_ctc_plus:
        #     if model_plus is not None:
        #         model_plus = utils.add_node_to_tree(model_plus, feature)
        # for feature in list

        # if model_plus is not None:
        #     model_plus = utils.add_node_to_tree(model_plus, right_feature_ctc_plus)
        # print(f'T(+{right_feature_ctc_plus}): {model_plus}')
        # if model_less is not None:
        #     model_less = utils.eliminate_node_from_tree(model_less, left_feature_ctc_less)
        # print(f'T(-{left_feature_ctc_less}): {model_less}')
        # if model_less is not None:
        #     model_less = utils.eliminate_node_from_tree(model_less, right_feature_ctc_less)
        # print(f'T(-{right_feature_ctc_less}): {model_less}')


        # Construct T(+B) and T(-A-B).
        if model_plus is not None and model_less is not None:
            # If both trees are not equal to NIL, then the result consists of a new root, which
            # is an Xor feature, with subfeatures T(+B) and T(-A-B).
            new_root = Feature(utils.get_new_feature_name(model, 'root'), is_abstract=True)
            rel = Relation(new_root, [model_plus.root, model_less.root], 1, 1)  #XOR
            new_root.add_relation(rel)
            model.root = new_root
        elif model_less is None:
            # If T(-A-B) is equal to NIL, then the result is T(+B).
            model = model_plus
        elif model_plus is None:
            # If T(+B) is equal to NIL, then the result is T(-A-B). 
            model = model_less

        print('----my relations MODEL FINAL-----')
        for r in model.get_relations():
            print(f'Relation (less): ({r.parent}, {[f.name for f in r.children]}, {r.card_min}, {r.card_max})')

        model.ctcs.remove(instance)

        # Changing names to avoid duplicates
        # CUIDADO!!! (puede que haya que modificarlo)
        if model_less is not None and model_plus is not None:
            for feature in model_less.get_features():
                if feature in model_plus.get_features():
                    feature_reference = model.get_feature_by_name(feature.name)
                    feature.name = utils.get_new_feature_name(model, feature.name)
                    feature.reference = feature_reference

        print('----my relations MODEL FINAL (new names-----')
        for r in model.get_relations():
            print(f'Relation (less): ({r.parent}, {[f.name for f in r.children]}, {r.card_min}, {r.card_max})')

        return model