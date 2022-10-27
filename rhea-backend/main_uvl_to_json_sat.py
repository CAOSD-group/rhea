from flamapy.metamodels.fm_metamodel.transformations import UVLReader
from flamapy.metamodels.fm_metamodel.models import Feature, Relation
from flamapy.metamodels.pysat_metamodel.operations import Glucose3Products, Glucose3ProductsNumber
from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat

from rhea.metamodels.fm_metamodel.transformations import JSONWriter
from rhea.refactorings import CardinalityGroupRefactoring
from rhea.metamodels.fm_metamodel.models import fm_utils

from flamapy.core.models import ast


FM_NAME = 'Pizzas_completo_new'
#FM_NAME = 'rhea/rhea-backend/Pizzas_completo'

if __name__ == '__main__':
    fm = UVLReader(FM_NAME+'.uvl').transform()
    print(fm)
    JSONWriter(path=FM_NAME+'.json', source_model=fm).transform()

    # Add a mutex to the pizza model.
    feature_spicy = Feature(name='Spicy', relations=[], parent=fm.root, is_abstract=False)
    feature_cayenne = Feature(name='Cayenne', relations=[], parent=feature_spicy, is_abstract=False)
    feature_jalapino = Feature(name='Jalapino', relations=[], parent=feature_spicy, is_abstract=False)
    feature_spicy.add_relation(Relation(parent=feature_spicy, children=[feature_cayenne, feature_jalapino], card_min=0, card_max=1))
    fm.root.add_relation(Relation(parent=fm.root, children=[feature_spicy], card_min=0, card_max=1))

    # Convert or to group cardinality in pizza model
    feature_topping = fm.get_feature_by_name('Topping')
    or_relation = next((r for r in feature_topping.get_relations() if r.is_or()), None)
    or_relation.card_min = 2
    #or_relation.children = or_relation.children[:3]

    # Add a mandatory feature in an or-group feature
    vegan_feature = fm.get_feature_by_name('Vegan')
    tomato_feature = fm.get_feature_by_name('Tomato')
    mandatory_rel = Relation(vegan_feature, [tomato_feature], 1, 1)
    vegan_feature.add_relation(mandatory_rel)
    
    print(fm)
    JSONWriter(path=FM_NAME+'.json', source_model=fm).transform()

    sat_model = FmToPysat(fm).transform()
    print(f'#Products: {Glucose3ProductsNumber().execute(sat_model).get_result()}')
    #print(f'#Products: {Glucose3ProductsNumber().execute(sat_model).get_result()}')

    
    fm = CardinalityGroupRefactoring().transform(fm, feature_topping)
    print("finish refactoring")


    ctc = fm.get_constraints()[2]
    print(f'Original CTC: {ctc}')
    ctc_ast = ast.simplify_formula(ctc.ast)
    print(f'Simplify CTC: {ctc_ast}')
    ctc_asts = fm_utils.split_formula(ctc_ast)
    for i, c in enumerate(ctc_asts, 1):
        print(f'CTC {i}: {c}')

    ctc_ast = ast.propagate_negation(ctc_asts[0].root)
    ctc_asts = fm_utils.split_formula(ctc_ast)
    for i, c in enumerate(ctc_asts, 1):
        print(f'CTC {i}: {c}')

    ctc_ast = ast.convert_into_nnf(ctc_asts[0])
    print(f'NNF: {ctc_ast}')
    ctc_asts = fm_utils.split_formula(ctc_ast)
    for i, c in enumerate(ctc_asts, 1):
        print(f'CTC {i}: {c}')

    ctc_ast = ast.convert_into_cnf(ctc_asts[0])
    print(f'CNF: {ctc_ast}')
    ctc_asts = fm_utils.split_formula(ctc_ast)
    for i, c in enumerate(ctc_asts, 1):
        print(f'CTC {i}: {c}')


    #JSONWriter(path=FM_NAME+'_refactored.json', source_model=fm).transform()


