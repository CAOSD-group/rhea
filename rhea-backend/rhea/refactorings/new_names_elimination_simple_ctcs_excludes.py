import copy
from typing import Any

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from rhea.metamodels.fm_metamodel.models import FM, ConstraintHelper
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class NewNamesEliminationSimpleConstraintsExcludes(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of Constraints from Feature Trees - Excludes (changing names)'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [ctc for ctc in model.get_constraints() if ConstraintHelper(ctc).is_excludes_constraint()]

    @staticmethod
    def transform(model: FeatureModel, instance: Constraint) -> FeatureModel:
        if instance is None:
            raise Exception(f'There is not constraint with name "{str(instance)}".')
        if not ConstraintHelper(instance).is_excludes_constraint():
            raise Exception(f'Operator {str(instance)} is not requires.')

        print(f'MODELO: {model}')
        model_less = copy.deepcopy(model)
        model_less_plus = copy.deepcopy(model)

        not_operation = instance.ast.root.right
        right_feature_name_ctc = not_operation.left.data
        right_feature_ctc_less = model_less.get_feature_by_name(right_feature_name_ctc)  # right feature for less tree
        
        
        right_feature_ctc_less_plus = model_less_plus.get_feature_by_name(right_feature_name_ctc)  # right feature for less-plus
        left_feature_name_ctc = instance.ast.root.left.data
        left_feature_ctc_less = model_less_plus.get_feature_by_name(left_feature_name_ctc)  # left feature for plus tree
        
        model_less = utils.eliminate_node_from_tree(model_less, right_feature_ctc_less)
        print(f'T(-{right_feature_ctc_less}): {model_less}')
        model_less_plus = utils.eliminate_node_from_tree(model_less_plus, left_feature_ctc_less)
        print(f'T(-{left_feature_ctc_less}): {model_less_plus}')
        model_less_plus = utils.add_node_to_tree(model_less_plus, right_feature_ctc_less_plus)
        print(f'T(+{right_feature_ctc_less}): {model_less_plus}')



        # Construct T(-B) and T(-A+B).
        if model_less is not None and model_less_plus is not None:
            # If both trees are not equal to NIL, then the result consists of a new root, which
            # is an Xor feature with subtrees T(-B) and T(-A+B). 
            new_root = Feature('root', None, None, True)
            rel = Relation(new_root, [model_less.root, model_less_plus.root], 1, 1)  #XOR
            new_root.add_relation(rel)
            model.root = new_root
        elif model_less is None:
            # If T(-B) is equal to NIL, then the result is T(-A+B). 
            model = model_less_plus
        elif model_less_plus is None:
            # If T(-A+B) is equal to NIL, then the result is T(-B). 
            model = model_less
        
        model.ctcs.remove(instance)

        # Changing names to avoid duplicates
        for feature in model_less_plus.get_features():
            if feature in model_less.get_features():
                feature_reference = model.get_feature_by_name(feature.name)
                feature.name = utils.get_new_feature_name(model, feature.name)
                feature.reference = feature_reference
        return model