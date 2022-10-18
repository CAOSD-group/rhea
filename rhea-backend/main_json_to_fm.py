from flamapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter
from flamapy.metamodels.fm_metamodel.models import Feature, Relation

from rhea.metamodels.fm_metamodel.transformations import JSONWriter, JSONReader


FM_NAME = 'Pizzas_completo'

if __name__ == '__main__':
    fm = JSONReader(FM_NAME+'.json').transform()
    print(fm)
    UVLWriter(fm, 'mi-pizzas.uvl').transform()