from typing import Any
import datetime

from famapy.core.models import AST, ASTOperation
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


def split_ast(formula: AST) -> list[AST]:
    """Given a formula, returns a list of formulas separated by the AND operator."""
    print(f'AST: {formula.pretty_str()}')
    res = []
    node = formula.root
    if node.data == ASTOperation.AND:
        res.extend(split_ast(AST(node.left)))
        res.extend(split_ast(AST(node.right)))
    else:
        res.append(formula)
    return res