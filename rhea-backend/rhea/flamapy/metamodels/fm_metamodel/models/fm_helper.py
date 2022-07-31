from typing import Any

from famapy.core.models import ASTOperation
from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Constraint

from rhea.flamapy.metamodels.fm_metamodel.models import Attribute
from rhea.flamapy.metamodels.fm_metamodel.models import fm_utils


class FM(FeatureModel):

    def __init__(self, feature_model: FeatureModel) -> None:
        self._fm: FeatureModel = feature_model
        self._attributes: dict[Feature, list[Attribute]] = {}

    @property
    def attributes(self) -> dict[Feature, list[Attribute]]:
        return self._attributes

    @attributes.setter
    def attributes(self, features_attributes: dict[str, dict[str, Any]]):
        """features_attributes is a dictionary of 'feature name' -> 'attributes',
        where attributes is another dictionary of 'attribute name' -> 'value'."""
        self._attributes = {}
        for feature_name in features_attributes.keys():
            feature = self._fm.get_feature_by_name(feature_name)
            if feature is None:
                raise Exception(f'Feature {feature_name} does not exist in feature model.')
            attributes = []
            for attr in features_attributes[feature_name]:
                type, value = fm_utils.parse_type_value(features_attributes[attr])
                attribute = Attribute(attr, type, value)
                attributes.append(attribute)
            self._attributes[feature] = attributes

    def get_constraints(self) -> list[Constraint]:
        return self._fm.get_constraints()

    def get_simple_constraints(self) -> list[Constraint]:
        return [ctc for ctc in self.get_constraints() if ctc.is_simple_constraint()]

    def get_complex_constraints(self) -> list[Constraint]:
        return [ctc for ctc in self.get_constraints() if ctc.is_complex_constraint()]

    def get_requires_constraints(self) -> list[Constraint]:
        return [ctc for ctc in self.get_constraints() if ctc.is_requires_constraint()]

    def get_excludes_constraints(self) -> list[Constraint]:
        return [ctc for ctc in self.get_constraints() if ctc.is_excludes_constraint()]

    def get_pseudocomplex_constraints(self) -> list[Constraint]:
        return [ctc for ctc in self.get_constraints() if ctc.is_pseudocomplex_constraint()]

    def get_strictcomplex_constraints(self) -> list[Constraint]:
        return [ctc for ctc in self.get_constraints() if ctc.is_strictcomplex_constraint()]



class ConstraintHelper():

    def __init__(self, constraint: Constraint) -> None:
        self._ctc = constraint

    def is_simple_constraint(self) -> bool:
        return self.is_requires_constraint() or self.is_excludes_constraint()

    def is_complex_constraint(self) -> bool:
        return self.is_pseudocomplex_constraint() or self.is_strictcomplex_constraint()

    def is_requires_constraint(self) -> bool:
        root_op = self._ctc.ast.root
        if root_op.is_binary_op():
            if root_op.data in [ASTOperation.REQUIRES, ASTOperation.IMPLIES]:
                return root_op.left.is_term() and root_op.right.is_term()
            elif root_op.data == ASTOperation.OR:
                neg_left = root_op.left.data == ASTOperation.NOT and root_op.left.left.is_term()
                neg_right = root_op.right.data == ASTOperation.NOT and root_op.right.left.is_term()
                return neg_left and root_op.right.is_term() or neg_right and root_op.left.is_term()
        return False

    def is_excludes_constraint(self) -> bool:
        root_op = self._ctc.ast.root
        if root_op.is_binary_op():
            if root_op.data in [ASTOperation.EXCLUDES, ASTOperation.XOR]:
                return root_op.left.is_term() and root_op.right.is_term()
            elif root_op.data in [ASTOperation.REQUIRES, ASTOperation.IMPLIES]:
                neg_right = root_op.right.data == ASTOperation.NOT and root_op.right.left.is_term()
                return root_op.left.is_term() and neg_right
            elif root_op.data == ASTOperation.OR:
                neg_left = root_op.left.data == ASTOperation.NOT and root_op.left.left.is_term()
                neg_right = root_op.right.data == ASTOperation.NOT and root_op.right.left.is_term()
                return neg_left and neg_right
        return False

    def is_strictcomplex_constraint(self) -> bool:
        if len(self._clauses) == 1 and len(self._clauses[0]) == 2:
            nof_negative_clauses = sum(var.startswith('-') for var in self._clauses[0])
            return nof_negative_clauses == 0
        strictcomplex = False
        i = iter(self._clauses)
        while not strictcomplex and (cls := next(i, None)) is not None:
            if len(cls) != 2:
                strictcomplex = True
            else:
                nof_negative_clauses = sum(var.startswith('-') for var in cls)
                if nof_negative_clauses not in [1, 2]:
                    strictcomplex = True
        return strictcomplex

    def is_pseudocomplex_constraint(self) -> bool:
        if len(self._clauses) == 1:
            return False
        strictcomplex = False
        i = iter(self._clauses)
        while not strictcomplex and (cls := next(i, None)) is not None:
            if len(cls) != 2:
                strictcomplex = True
            else:
                nof_negative_clauses = sum(var.startswith('-') for var in cls)
                if nof_negative_clauses not in [1, 2]:
                    strictcomplex = True
        return not strictcomplex
