from famapy.metamodels.fm_metamodel.transformations import UVLReader
from rhea.flamapy.metamodels.fm_metamodel.models import ast_helper
from famapy.core.models.ast import AST, ASTOperation, Node

def main() -> None:
    fm = UVLReader('JHipster.uvl').transform()
    
    ctc = fm.get_constraints()[1]
    print(f'Constraint: {ctc.ast.pretty_str()}')

    ast = ctc.ast
    print(f'Original AST: {ast}')
    #ast = ast_helper.eliminate_complex_operators(ast)
    #print(f'Simple AST: {ast}')
    print('------')
    ast = ast_helper.convert_into_nnf(ast)
    print(f'AST in NNF: {ast}')
    print(f'Constraint in NNF: {ast.pretty_str()}')
    print('------')
    ast = ast_helper.convert_into_cnf(ast)
    print(f'AST in CNF: {ast}')
    print(f'Constraint in CNF: {ast.pretty_str()}')

    # ast = AST.create_binary_operation(ASTOperation.AND,
    #                                   AST.create_binary_operation(ASTOperation.OR,
    #                                                               Node('A'),
    #                                                               AST.create_binary_operation(ASTOperation.AND,
    #                                                                                           Node('B'),
    #                                                                                           Node('C')).root
    #                                                              ).root,
    #                                   AST.create_unary_operation(ASTOperation.NOT, Node('D')).root)

    ast = AST.create_binary_operation(ASTOperation.REQUIRES,
                                      AST.create_unary_operation(ASTOperation.NOT, Node('A')).root,
                                      Node('B'))
    print('------')
    print(f'Original AST: {ast}')
    print(f'Original AST: {ast.pretty_str()}')
    print('------')
    #ast = ast_helper.simplify_formula(ast)
    print(f'AST simplified: {ast}')
    print(f'AST simplified: {ast.pretty_str()}')
    print('------')
    ast = ast_helper.convert_into_nnf(ast)
    print(f'AST in NNF: {ast}')
    print(f'Constraint in NNF: {ast.pretty_str()}')
    print('------')
    ast = ast_helper.convert_into_cnf(ast)
    print(f'AST in CNF: {ast}')
    print(f'Constraint in CNF: {ast.pretty_str()}')
    



if __name__ == '__main__':
    main()