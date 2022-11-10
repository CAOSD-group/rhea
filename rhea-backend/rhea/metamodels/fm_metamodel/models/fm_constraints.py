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


def get_transformations_vector(constraints: list[Constraint]) -> list[tuple[SimpleCTCTransformation, SimpleCTCTransformation]]:
    transformations_vector = []
    for ctc in constraints:
        left_feature, right_feature = fm_utils.left_right_features_names_from_simple_constraint(ctc)
        if fm_utils.is_requires_constraint(ctc):
            requires0 = SimpleCTCTransformation(SimpleCTCTransformation.REQUIRES, 0, [fm_utils.deletion_feature, fm_utils.deletion_feature], [left_feature, right_feature])
            requires1 = SimpleCTCTransformation(SimpleCTCTransformation.REQUIRES, 1, [fm_utils.commitment_feature], [right_feature])
            transformations_vector.append((requires0, requires1))
        elif fm_utils.is_excludes_constraint(ctc):
            excludes0 = SimpleCTCTransformation(SimpleCTCTransformation.EXCLUDES, 0, [fm_utils.deletion_feature, fm_utils.commitment_feature], [left_feature, right_feature])
            excludes1 = SimpleCTCTransformation(SimpleCTCTransformation.EXCLUDES, 1, [fm_utils.deletion_feature], [right_feature])
            transformations_vector.append((excludes0, excludes1))
    return transformations_vector
