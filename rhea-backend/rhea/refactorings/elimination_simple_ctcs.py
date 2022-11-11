import copy
from typing import Any

from flamapy.core.models.ast import AST, ASTOperation, Node
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from flamapy.metamodels.fm_metamodel.transformations import UVLWriter

from rhea.metamodels.fm_metamodel.models import FM, fm_utils, fm_constraints
from rhea.metamodels.fm_metamodel.models.fm_constraints import SimpleCTCTransformation
from rhea.refactorings import FMRefactoring
from rhea.refactorings import utils


class EliminationSimpleConstraints(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Elimination of all simple constraints'
    
    @staticmethod
    def get_description() -> str:
        return ("It eliminates all simple constraint from the model mantaining its semantic")

    @staticmethod
    def get_language_construct_name() -> str:
        return 'Constraint'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Constraint]:
        return [ctc for ctc in model.get_constraints() if fm_utils.is_simple_constraint(ctc)]

    @staticmethod
    def is_applicable(model: FeatureModel) -> bool:
        return True

    @staticmethod
    def transform(model: FeatureModel, instance: list[Constraint] = None) -> FeatureModel:
        return eliminate_simple_constraints(model)


def eliminate_simple_constraints(fm: FeatureModel) -> FeatureModel:
    constraints_order = fm_constraints.analysis_constraints_order(fm)
    print(f'new_constraints_ordered: {[ctc.ast.pretty_str() for ctc in constraints_order[0]]}')
    print(f'constraints_ordered_transformations: {constraints_order[1]}')
    assert len(constraints_order[0]) == len(fm.get_constraints())
    #print(f'constraints_order: {constraints_order}')
    transformations_vector = fm_constraints.get_transformations_vector(constraints_order)

    n_bits = len(transformations_vector)
    #binary_vector = format(0, f'0{n_bits}b')
    num = 0
    i_bit = n_bits
    max = 2**n_bits
    valid_transformed_numbers_trees = {}  # dict of number -> tree
    percentage = 0.0
    while num < max:
        #binary_vector = list(format(num, f'0{n_bits}b')[::-1])
        binary_vector = list(format(num, f'0{n_bits}b'))
        tree, null_bit = execute_transformations_vector(fm, transformations_vector, binary_vector)
        if tree is not None:
            #print(f'{num}: {"".join(binary_vector)} -> OK')
            valid_transformed_numbers_trees[num] = tree
            num += 1
        else:  # tree is None
            print(f'Transformation resulted in NULL. Bit: {null_bit}')
            num = get_next_number_prunning_binary_vector(binary_vector, null_bit)
            #print(f'  |- next number: {num}')
        percentage = (num / max) * 100
        print(f'#Valid subtrees: {len(valid_transformed_numbers_trees)}. Num: {num} / {max} Ratio: ({percentage}%)')
    result_fm = get_model_from_subtrees(fm, valid_transformed_numbers_trees.values())
    return result_fm


def get_model_from_subtrees(fm: FeatureModel, subtrees: set[FeatureModel]) -> FeatureModel:
    # The result consists of a new root, which is an Xor feature,
    # with subfeatures each subtree
    new_root = Feature(fm_utils.get_new_feature_name(fm, 'root'), is_abstract=True)
    children = []
    for tree in subtrees:
        tree.root.parent = new_root
        children.append(tree.root)
    if not children:
        return None
    xor_rel = Relation(new_root, children, 1, 1)
    new_root.add_relation(xor_rel)
    return FeatureModel(new_root)


def get_next_number_prunning_binary_vector(binary_vector: list[str], bit: int) -> int:
    """Given a binary vector and the bit that returns NULL,
    this calculates the next decimal number to be check."""
    stop = False
    while bit >= 0 and not stop:
        if binary_vector[bit] == '0':
            binary_vector[bit] = '1'
            stop = True
        else:
            bit -= 1
    binary_vector[bit+1:] = ['0' for d in binary_vector[bit+1:]] 
    num = int(''.join(binary_vector), 2)
    if bit < 0:
        num = 2**len(binary_vector)
    return num

def execute_transformations_vector(fm: FeatureModel, 
                                   transformations_vector: list[tuple[SimpleCTCTransformation, SimpleCTCTransformation]], 
                                   binary_vector: list[str]) -> tuple[FeatureModel, int]:
    assert len(transformations_vector) == len(binary_vector)

    tree = FeatureModel(copy.deepcopy(fm.root))
    i = 0
    while i < len(transformations_vector) and tree is not None:
        tree = transformations_vector[i][int(binary_vector[i])].transforms(tree)
        i += 1
    return (tree, i-1)


# def analysis_constraints_order(fm: FeatureModel) -> tuple[list[Constraint], dict[int, tuple[int, int]]]:
#     """Return a new order for the constraints based on a previous analysis that takes into account
#     the number of features to be removed by the transformations required to refactor the
#     constraint.
    
#     The result is a tuple with the list of constraints in order, and a dictionary with the indexs
#     of the constraints and a tuple of (0,1) or (1,0) indicating the transformation that corresponds
#     with the first transformation or the second transformation.
#     0 is the first transformation; 1 is the second one.
#     """
#     print(f'#Constraints: {len(fm.get_constraints())}')
#     print(f'  |-#Requires: {len([ctc for ctc in fm.get_constraints() if fm_utils.is_requires_constraint(ctc)])}')
#     print(f'  |-#Excludes: {len([ctc for ctc in fm.get_constraints() if fm_utils.is_excludes_constraint(ctc)])}')

#     # Order of the constraints:
#     constraints = fm.get_constraints()
#     constraints_analysis = {}
#     for i, ctc in enumerate(constraints):
#         constraints_analysis[i] = fm_constraints.numbers_of_features_to_be_removed(fm, ctc)
#     print(f'constraints_analysis: {constraints_analysis}')
#     constraints_ordered = dict(sorted(constraints_analysis.items(), key=lambda item: max(item[1][0], item[1][1]), reverse=True))  # order by best transformation
#     print(f'constraints_ordered: {constraints_ordered}')
#     constraints_ordered_transformations = {}
#     for i, (key, value) in enumerate(constraints_ordered.items()):
#         print(f'i: {i}, key: {key}, value: {value}')
#         constraints_ordered_transformations[i] = (0, 1) if value[0] >= value[1] else (1, 0)
#     new_constraints_ordered = list(constraints_ordered.keys())
#     print(f'new_constraints_ordered: {new_constraints_ordered}')
#     print(f'constraints_ordered_transformations: {constraints_ordered_transformations}')
#     # for i in range(new_constraints_ordered):
#     #     print(f'CTC {i}: {new_constraints_ordered[i].ast.to_pretty_str()}, {(constraints_ordered[i][0], constraints_ordered[i][1]), ({(constraints_ordered_transformations[i][0], constraints_ordered_transformations[i][1])})}')
#     return (new_constraints_ordered, constraints_ordered_transformations)


    # constraints = []
    # constraints = [ctc for ctc in fm.get_constraints() if fm_utils.is_requires_constraint(ctc)] + [ctc for ctc in fm.get_constraints() if fm_utils.is_excludes_constraint(ctc)]

    # transformations_vector = fm_constraints.get_transformations_vector(constraints)

    # new_constraints_order = {}
    # for i, transformation in enumerate(transformations_vector):
    #     print(f'#Features to be removed: {fm_constraints.numbers_of_features_to_be_removed(fm, constraints[i])}')
    #     total_features = 0
    #     tree = transformation[0].transforms(fm, copy_model=True)
    #     if tree is not None:
    #         total_features += len(tree.get_features())
    #         print(f'CTC {i}: {transformation[0]} -> #Features: {len(tree.get_features())}, #xors: {len(tree.get_alternative_group_features())}')
    #     else:
    #         print(f'CTC {i}: {transformation[0]} -> NULL')
    #     tree = transformation[1].transforms(fm, copy_model=True)
    #     if tree is not None:
    #         total_features += len(tree.get_features())
    #         print(f'CTC {i}: {transformation[1]} -> #Features: {len(tree.get_features())}, #xors: {len(tree.get_alternative_group_features())}')
    #     else:
    #         print(f'CTC {i}: {transformation[1]} -> NULL')
    #     new_constraints_order[i] = int(total_features / 2)
    
    # new_constraints_order = dict(sorted(new_constraints_order.items(), key=lambda item: item[1]))
    # new_constraints = []
    # for i in new_constraints_order.keys():
    #     print(f'CTC {i}: {new_constraints_order[i]} features -> {constraints[i]}')
    #     new_constraints.append(constraints[i])
    
    # return new_constraints