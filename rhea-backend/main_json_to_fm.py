from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter
from flamapy.metamodels.fm_metamodel.models import Feature, Relation, FeatureModel
from flamapy.metamodels.pysat_metamodel.operations import Glucose3Products, Glucose3ProductsNumber
from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat

from rhea.metamodels.fm_metamodel.transformations import JSONWriter, JSONReader
from rhea.refactorings import CardinalityGroupRefactoring
from flamapy.core.models import AST

FM_NAME = 'Pizzas_completo'

if __name__ == '__main__':
    fm = JSONReader(FM_NAME+'.json').transform()
    print(fm)
    UVLWriter(fm, 'mi-pizzas.uvl').transform()

    sat_model = FmToPysat(fm).transform()
    print(f'#Products: {Glucose3ProductsNumber().execute(sat_model).get_result()}')
    #print(f'#Products: {Glucose3ProductsNumber().execute(sat_model).get_result()}')
    JSONWriter(path=FM_NAME+'.json', source_model=fm).transform()

    group_cardinality = next((f for f in fm.get_features() if f.is_cardinality_group()), None)
    fm = CardinalityGroupRefactoring().transform(fm, group_cardinality)

    print(fm)

    UVLWriter(fm, 'mi-pizzas2.uvl').transform()