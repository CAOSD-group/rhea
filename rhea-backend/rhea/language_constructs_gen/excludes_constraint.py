import itertools
from rhea.language_constructs_gen import LanguageConstruct 

from flamapy.core.models import AST, ASTOperation
from flamapy.metamodels.fm_metamodel.models import FeatureModel, Constraint
from rhea.metamodels.fm_metamodel.models import fm_utils


class ExcludesConstraint(LanguageConstruct):

    def __init__(self, feature_left: str, feature_right: str) -> None:
        self.feature_left = feature_left
        self.feature_right = feature_right
        self.constraint = None

    @staticmethod
    def name() -> str:
        return 'Excludes Constraint'

    @staticmethod
    def count(fm: FeatureModel) -> int:
        return sum(fm_utils.is_excludes_constraint(c) for c in fm.get_constraints())

    def get(self) -> Constraint:
        return self.constraint

    def apply(self, fm: FeatureModel) -> FeatureModel:
        self.constraint = Constraint(f'EXC[{self.feature_left}][{self.feature_right}]', AST.create_simple_binary_operation(ASTOperation.EXCLUDES, self.feature_left, self.feature_right))
        fm.ctcs.append(self.constraint)
        return fm

    def is_applicable(self, fm: FeatureModel) -> bool:
        if fm is None:
            return False
        left = fm.get_feature_by_name(self.feature_left) 
        right = fm.get_feature_by_name(self.feature_right)
        if left is None or right is None:
            return False
        ctc = Constraint(f'EXC[{self.feature_left}][{self.feature_right}]', AST.create_simple_binary_operation(ASTOperation.EXCLUDES, self.feature_left, self.feature_right))
        return ctc not in fm.get_constraints()
        #return not any(fm_utils.is_excludes_constraint(c) and c.ast.root.left == self.feature_left and c.ast.root.right.data == self.feature_right for c in fm.get_constraints())
        

    @staticmethod
    def get_applicable_instances(fm: FeatureModel, features_names: list[str] = []) -> list['LanguageConstruct']:
        if fm is None:
            return []
        lcs = []
        names = [f.name for f in fm.get_features()]
        for combi in itertools.combinations(names, 2):
            left = combi[0]
            right = combi[1]
            lc = ExcludesConstraint(left, right)
            if lc.is_applicable(fm):
                lcs.append(lc)
        return lcs