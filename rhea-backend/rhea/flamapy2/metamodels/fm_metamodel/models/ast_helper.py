from famapy.core.models.ast import AST, ASTOperation, Node


def convert_into_nnf(ast: AST) -> AST:
    ast = simplify_formula(ast)
    return propagate_negation(ast.root)


def convert_into_cnf(ast: AST) -> AST:
    ast = simplify_formula(ast)
    return to_cnf(ast)

    
def simplify_formula(ast: AST) -> AST:
    """Convert a propositional formula to an equivalent formula without '=>', '<=>', 'XOR',
    'REQUIRES', 'EXCLUDES'.
    
    Adapted from [Büning, Hans Kleine, and Theodor Lettmann. 
    Propositional logic: deduction and algorithms. Vol. 48. Cambridge University Press, 1999.]
    """
    logic_op = ast.root.data
    left = ast.root.left
    right = ast.root.right
    if logic_op in (ASTOperation.REQUIRES, ASTOperation.IMPLIES):
        # Replace P => Q with !P v Q.
        left = simplify_formula(AST(left)).root
        right = simplify_formula(AST(right)).root
        result = AST.create_binary_operation(ASTOperation.OR, Node(ASTOperation.NOT, left), right)
    elif logic_op == ASTOperation.EXCLUDES:
        # Replace P EXCLUDES Q with P => !Q.
        left = simplify_formula(AST(left)).root
        right = simplify_formula(AST(right)).root
        result = AST.create_binary_operation(ASTOperation.IMPLIES, 
                                             left, Node(ASTOperation.NOT, right))
    elif logic_op == ASTOperation.EQUIVALENCE:
        # Replace P <=> Q with P => Q ∧ Q => P.
        left = simplify_formula(AST.create_binary_operation(ASTOperation.IMPLIES, 
                                                            left, right)).root
        right = simplify_formula(AST.create_binary_operation(ASTOperation.IMPLIES, 
                                                             right, left)).root
        result = AST.create_binary_operation(ASTOperation.AND, left, right)
    elif logic_op == ASTOperation.XOR:
        # Replace P XOR Q with (P ∧ !Q) v (!P ∧ Q).
        left = simplify_formula(AST.create_binary_operation(ASTOperation.AND, 
                                                            left, 
                                                            Node(ASTOperation.NOT, right))).root
        left = simplify_formula(AST.create_binary_operation(ASTOperation.AND, 
                                                            Node(ASTOperation.NOT, left), 
                                                            right)).root
        result = AST.create_binary_operation(ASTOperation.OR, left, right)
    elif logic_op == ASTOperation.AND:
        left = simplify_formula(AST(left)).root
        right = simplify_formula(AST(right)).root
        result = AST.create_binary_operation(ASTOperation.AND, left, right)
    elif logic_op == ASTOperation.OR:
        left = simplify_formula(AST(left)).root
        right = simplify_formula(AST(right)).root
        result = AST.create_binary_operation(ASTOperation.OR, left, right)
    elif logic_op == ASTOperation.NOT:
        left = simplify_formula(AST(left)).root
        result = AST.create_unary_operation(ASTOperation.NOT, left)
    else:
        result = ast
    return result


def to_cnf(formula: AST) -> AST:
    """Convert a propositional formula in NNF to an equivalent formula in conjunctive normal form.
    
    Adapted and fixed from [Alexander Knüppel. The Role of Complex Constraints in Feature Modeling. 
    Master's Thesis. 2016].
    """
    node = formula.root
    result = AST(node)
    if node.data == ASTOperation.AND:
        result = AST.create_binary_operation(ASTOperation.AND,
                                             to_cnf(AST(node.left)).root,
                                             to_cnf(AST(node.right)).root)
    elif node.data == ASTOperation.OR:
        node.left = to_cnf(AST(node.left)).root
        node.right = to_cnf(AST(node.right)).root
        if node.left.data == ASTOperation.AND:
            result = AST.create_binary_operation(ASTOperation.AND,
                                                 AST.create_binary_operation(ASTOperation.OR,
                                                                             node.left.left,
                                                                             node.right).root,
                                                 AST.create_binary_operation(ASTOperation.OR,
                                                                             node.left.right,
                                                                             node.right).root)
        elif node.right.data == ASTOperation.AND:
            result = AST.create_binary_operation(ASTOperation.AND,
                                                 AST.create_binary_operation(ASTOperation.OR,
                                                                             node.left,
                                                                             node.right.left).root,
                                                 AST.create_binary_operation(ASTOperation.OR,
                                                                             node.left,
                                                                             node.right.right).root)
        else:
            result = AST.create_binary_operation(ASTOperation.OR, node.left, node.right)
    return result


def to_nnf(ast: AST) -> AST:
    """Convert a simplified propositional formula to an equivalent formula in negation normal form.
    
    A simplified formula only contains '∧', 'v', and 'not'.
    
    Adapted from [Alexander Knüppel. The Role of Complex Constraints in Feature Modeling. 
    Master's Thesis. 2016].
    """
    return propagate_negation(ast.root)
    

def propagate_negation(node: Node, negated: bool = False) -> AST:
    result = None
    if node.data == ASTOperation.NOT:
        negated = not negated
        result = propagate_negation(node.left, negated)
    elif node.data == ASTOperation.AND:
        if negated:
            result = AST.create_binary_operation(ASTOperation.OR, 
                                                 propagate_negation(node.left, negated).root,
                                                 propagate_negation(node.right, negated).root)
        else:
            result = AST.create_binary_operation(ASTOperation.AND, 
                                                 propagate_negation(node.left, negated).root,
                                                 propagate_negation(node.right, negated).root)
    elif node.data == ASTOperation.OR:
        if negated:
            result = AST.create_binary_operation(ASTOperation.AND, 
                                                 propagate_negation(node.left, negated).root,
                                                 propagate_negation(node.right, negated).root)
        else:
            result = AST.create_binary_operation(ASTOperation.OR, 
                                                 propagate_negation(node.left, negated).root,
                                                 propagate_negation(node.right, negated).root)
    else:
        if negated:
            result = AST.create_unary_operation(ASTOperation.NOT, node)
        else:
            result = AST(node)
    return result