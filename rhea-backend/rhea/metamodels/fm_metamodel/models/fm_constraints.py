from typing import Callable

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Constraint

from rhea.metamodels.fm_metamodel.models import fm_utils


class SimpleCTCTransformation:

    REQUIRES = 'R'
    EXCLUDES = 'E'

    def __init__(self, name: str, value: int, transformations: list[Callable], features: list[str]):
        self.name = name
        self.value = value
        self.transformations = transformations
        self.features = features

    def transforms(self, fm: FeatureModel, copy_model: bool = False) -> FeatureModel:
        return fm_utils.transform_tree(self.transformations, fm, self.features, copy_model)

    def __str__(self) -> str:
        return f'{self.name}{self.value}{[f for f in self.features]}'


# REQUIRES_0 = SimpleCTCTransformation('Req', 0, [fm_utils.commitment_feature])
# REQUIRES_1 = SimpleCTCTransformation('Req', 1, [fm_utils.deletion_feature, fm_utils.deletion_feature])

# EXCLUDES_0 = SimpleCTCTransformation('Exc', 0, [fm_utils.deletion_feature])
# EXCLUDES_1 = SimpleCTCTransformation('Exc', 1, [fm_utils.deletion_feature, fm_utils.commitment_feature])


def get_transformations_vector(constraints: tuple[list[Constraint], dict[int, tuple[int, int]]]) -> list[tuple[SimpleCTCTransformation, SimpleCTCTransformation]]:
    transformations_vector = []
    for i, ctc in enumerate(constraints[0]):
        print(f'i: {i}, ctc: {ctc}')
        left_feature, right_feature = fm_utils.left_right_features_names_from_simple_constraint(ctc)
        if fm_utils.is_requires_constraint(ctc):
            t0 = SimpleCTCTransformation(SimpleCTCTransformation.REQUIRES, 0, [fm_utils.commitment_feature], [right_feature])
            t1 = SimpleCTCTransformation(SimpleCTCTransformation.REQUIRES, 1, [fm_utils.deletion_feature, fm_utils.deletion_feature], [left_feature, right_feature])
        else:  # it is an excludes
            t0 = SimpleCTCTransformation(SimpleCTCTransformation.EXCLUDES, 0, [fm_utils.deletion_feature], [right_feature])
            t1 = SimpleCTCTransformation(SimpleCTCTransformation.EXCLUDES, 1, [fm_utils.deletion_feature, fm_utils.commitment_feature], [left_feature, right_feature])
        if constraints[1][i] == (0, 1):
            transformations_vector.append((t0, t1))
        else:
            transformations_vector.append((t1, t0))
    return transformations_vector


def numbers_of_features_to_be_removed(fm: FeatureModel, ctc: Constraint) -> tuple[int, int]:
    """Return the number of features that will be deleted from the feature model when
    the given constraint is refactored into the tree diagram.
    
    It returns a tuple where the first value corresponds with the first transformation required
    to eliminate the CTC (i.e., the commitment or deletion of a feature), while the second value
    corresponds with the second transformation required to eliminate the CTC (i.e., the 
    deletion of both features or the deletion of the first feature and the commitment of the other.
    """
    assert fm_utils.is_simple_constraint(ctc)
    left_feature, right_feature = fm_utils.left_right_features_names_from_simple_constraint(ctc)
    if fm_utils.is_requires_constraint(ctc):
        t_0 = numbers_of_features_to_be_removed_commitment(fm, right_feature)
        t_1 = numbers_of_features_to_be_removed_deletion(fm, left_feature) + numbers_of_features_to_be_removed_deletion(fm, right_feature)
    else:  # it is an excludes
        t_0 = numbers_of_features_to_be_removed_deletion(fm, right_feature)
        t_1 = numbers_of_features_to_be_removed_deletion(fm, left_feature) + numbers_of_features_to_be_removed_commitment(fm, right_feature)
    return (t_0, t_1)


def numbers_of_features_to_be_removed_commitment(fm: FeatureModel, feature_name: str) -> int:
    """Return the number of features that will be removed from the feature model when
    the given feature is commitment into the diagram."""
    feature = fm.get_feature_by_name(feature_name)
    if feature not in fm.get_features():
        return len(fm.get_features())
    feature_to_commit = feature
    n_features = 0
    while feature_to_commit != fm.root:
        parent = feature_to_commit.get_parent()
        if parent.is_alternative_group():  
            n_features += len(parent.get_relations()[0].children) - 1
            for child in parent.get_relations()[0].children:
                if child != feature_to_commit:
                    n_features += fm_utils.children_number(child)
        feature_to_commit = parent
    return n_features


def numbers_of_features_to_be_removed_deletion(fm: FeatureModel, feature_name: str) -> int:
    """Return the number of features that will be removed from the feature model when
    the given feature is deleted from the diagram."""
    feature = fm.get_feature_by_name(feature_name)
    if feature not in fm.get_features():
        return 0
    n_features = 0
    feature_to_delete = feature
    parent = feature_to_delete.get_parent()  
    while feature_to_delete != fm.root and not parent.is_group() and feature_to_delete.is_mandatory():
        feature_to_delete = parent
        parent = feature_to_delete.get_parent()
    if feature_to_delete == fm.root:
        n_features = len(fm.get_features())
    elif not parent.is_group() and feature_to_delete.is_optional():
        n_features = 1 + fm_utils.children_number(feature_to_delete)
    elif parent.is_alternative_group() or parent.is_or_group():
        n_features = 1 + fm_utils.children_number(feature_to_delete)
    return n_features


def analysis_constraints_order(fm: FeatureModel) -> tuple[list[Constraint], dict[int, tuple[int, int]]]:
    """Return a new order for the constraints based on a previous analysis that takes into account
    the number of features to be removed by the transformations required to refactor the
    constraint.
    
    The result is a tuple with the list of constraints in order, and a dictionary with the indexs
    of the constraints and a tuple of (0,1) or (1,0) indicating the transformation that corresponds
    with the first transformation or the second transformation.
    0 is the first transformation; 1 is the second one.
    """
    print(f'#Constraints: {len(fm.get_constraints())}')
    print(f'  |-#Requires: {len([ctc for ctc in fm.get_constraints() if fm_utils.is_requires_constraint(ctc)])}')
    print(f'  |-#Excludes: {len([ctc for ctc in fm.get_constraints() if fm_utils.is_excludes_constraint(ctc)])}')

    # Order of the constraints:
    constraints = fm.get_constraints()
    constraints_analysis = {}
    for i, ctc in enumerate(constraints):
        constraints_analysis[i] = numbers_of_features_to_be_removed(fm, ctc)
    #print(f'constraints_analysis: {constraints_analysis}')
    constraints_ordered = dict(sorted(constraints_analysis.items(), key=lambda item: max(item[1][0], item[1][1]), reverse=True))  # order by best transformation
    print(f'constraints_ordered: {constraints_ordered}')
    constraints_ordered_transformations = {}
    for i, (key, value) in enumerate(constraints_ordered.items()):
        #print(f'i: {i}, key: {key}, value: {value}')
        constraints_ordered_transformations[i] = (0, 1) if value[0] >= value[1] else (1, 0)
    new_constraints_ordered = [constraints[i] for i in constraints_ordered.keys()]
    print(f'new_constraints_ordered: {[ctc.ast.pretty_str() for ctc in new_constraints_ordered]}')
    print(f'constraints_ordered_transformations: {constraints_ordered_transformations}')
    # for i in range(new_constraints_ordered):
    #     print(f'CTC {i}: {new_constraints_ordered[i].ast.to_pretty_str()}, {(constraints_ordered[i][0], constraints_ordered[i][1]), ({(constraints_ordered_transformations[i][0], constraints_ordered_transformations[i][1])})}')
    return (new_constraints_ordered, constraints_ordered_transformations)