from flamapy.metamodels.fm_metamodel.transformations import UVLReader
from flamapy.metamodels.fm_metamodel.models import Feature, Relation

from rhea.metamodels.fm_metamodel.transformations import JSONWriter
from rhea.refactorings import CardinalityGroupRefactoring


FM_NAME = 'Pizzas_completo'

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

    JSONWriter(path=FM_NAME+'.json', source_model=fm).transform()

    fm = CardinalityGroupRefactoring().transform(fm, feature_topping)

    JSONWriter(path=FM_NAME+'_refactored.json', source_model=fm).transform()

