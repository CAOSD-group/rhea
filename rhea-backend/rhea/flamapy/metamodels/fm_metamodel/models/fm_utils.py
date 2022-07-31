from typing import Any
import datetime

from famapy.core.models import AST, ASTOperation
from famapy.core.models import ast
from famapy.metamodels.fm_metamodel.models import Constraint

from rhea.flamapy.metamodels.fm_metamodel.models import Type


def parse_type_value(value: str) -> tuple[Type, Any]:
    """Given a value represented in a string, returns the associated type and its parsed value."""
    try:
        return (Type('Integer'), int(value))
    except:
        pass
    try:
        return (Type('Float'), float(value))
    except:
        pass
    try:
        return (Type('Date'), datetime.datetime.strptime(value, '%b %d %Y'))
    except:
        pass
    return (Type('String'), value)


def split_constraint(constraint: Constraint) -> list[Constraint]:
    """Given a constraint, split it in multiple constraints separated by the AND operator."""
    asts = split_formula(constraint.ast)
    asts_nnf = [ast.convert_into_nnf(ctc) for ctc in asts]
    asts = []
    for ctc in asts_nnf:
        asts.extend(split_formula(ctc))
    asts_cnf = [ast.convert_into_cnf(ctc) for ctc in asts]
    asts = []
    for ctc in asts_cnf:
        asts.extend(split_formula(ctc))
    return [Constraint(f'{constraint.name}{i}', ast) for i, ast in enumerate(asts)]


def split_formula(formula: AST) -> list[AST]:
    """Given a formula, returns a list of formulas separated by the AND operator."""
    res = []
    node = formula.root
    if node.data == ASTOperation.AND:
        res.extend(split_formula(AST(node.left)))
        res.extend(split_formula(AST(node.right)))
    else:
        res.append(formula)
    return res


def is_simple_constraint(constraint: Constraint) -> bool:
    return is_requires_constraint(constraint) or is_excludes_constraint(constraint)


def is_complex_constraint(constraint: Constraint) -> bool:
    return not is_simple_constraint(constraint)


def is_requires_constraint(constraint: Constraint) -> bool:
    root_op = constraint.ast.root
    if root_op.is_binary_op():
        if root_op.data in [ASTOperation.REQUIRES, ASTOperation.IMPLIES]:
            return root_op.left.is_term() and root_op.right.is_term()
        elif root_op.data == ASTOperation.OR:
            neg_left = root_op.left.data == ASTOperation.NOT and root_op.left.left.is_term()
            neg_right = root_op.right.data == ASTOperation.NOT and root_op.right.left.is_term()
            return neg_left and root_op.right.is_term() or neg_right and root_op.left.is_term()
    return False


def is_excludes_constraint(constraint: Constraint) -> bool:
    root_op = constraint.ast.root
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
