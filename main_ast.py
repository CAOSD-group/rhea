from flamapy.metamodels.fm_metamodel.transformations import UVLReader
from rhea.metamodels.fm_metamodel.models import fm_utils
from rhea.metamodels.fm_metamodel.models.fm_helper import FM
from flamapy.core.models import ast


def main() -> None:
    fm = UVLReader('JHipster.uvl').transform()
    for i, ctc in enumerate(fm.get_constraints()):
        print(f'CTC {i}: {ctc.ast.pretty_str()}')
        ctc_formulas = fm_utils.split_constraint(ctc)
        print(f'|-formulas: {[cf.ast.pretty_str() for cf in ctc_formulas]}')

    ctc = fm.get_constraints()[11]
    print(f'AST: {ctc.ast.pretty_str()}')
    print(f'NNF: {ast.convert_into_nnf(ctc.ast).pretty_str()}')
    print(f'CNF: {ctc.ast.to_cnf().pretty_str()}')

    fm = FM(fm)

    for ctc in fm.get_requires_constraints():
        print(f'REQUIRES: {ctc.ast.pretty_str()}')
    for ctc in fm.get_excludes_constraints():
        print(f'EXCLUDES: {ctc.ast.pretty_str()}')
    for ctc in fm.get_pseudocomplex_constraints():
        print(f'PSEUDO COMPLEX: {ctc.ast.pretty_str()}')
    for ctc in fm.get_strictcomplex_constraints():
        print(f'STRICT COMPLEX: {ctc.ast.pretty_str()}')
    
    # ctc = fm.get_constraints()[1]
    # print(f'Constraint: {ctc.ast.pretty_str()}')

    # ast = ctc.ast
    # print(f'Original AST: {ast}')
    # #ast = ast_helper.eliminate_complex_operators(ast)
    # #print(f'Simple AST: {ast}')
    # print('------')
    # ast = ast_helper.convert_into_nnf(ast)
    # print(f'AST in NNF: {ast}')
    # print(f'Constraint in NNF: {ast.pretty_str()}')
    # print('------')
    # ast = ast_helper.convert_into_cnf(ast)
    # print(f'AST in CNF: {ast}')
    # print(f'Constraint in CNF: {ast.pretty_str()}')

    # # ast = AST.create_binary_operation(ASTOperation.AND,
    # #                                   AST.create_binary_operation(ASTOperation.OR,
    # #                                                               Node('A'),
    # #                                                               AST.create_binary_operation(ASTOperation.AND,
    # #                                                                                           Node('B'),
    # #                                                                                           Node('C')).root
    # #                                                              ).root,
    # #                                   AST.create_unary_operation(ASTOperation.NOT, Node('D')).root)

    # ast = AST.create_binary_operation(ASTOperation.REQUIRES,
    #                                   AST.create_unary_operation(ASTOperation.NOT, Node('A')).root,
    #                                   Node('B'))
    # print('------')
    # print(f'Original AST: {ast}')
    # print(f'Original AST: {ast.pretty_str()}')
    # print('------')
    # #ast = ast_helper.simplify_formula(ast)
    # print(f'AST simplified: {ast}')
    # print(f'AST simplified: {ast.pretty_str()}')
    # print('------')
    # ast = ast_helper.convert_into_nnf(ast)
    # print(f'AST in NNF: {ast}')
    # print(f'Constraint in NNF: {ast.pretty_str()}')
    # print('------')
    # ast = ast_helper.convert_into_cnf(ast)
    # print(f'AST in CNF: {ast}')
    # print(f'Constraint in CNF: {ast.pretty_str()}')
    



if __name__ == '__main__':
    main()