from rhea.flamapy.metamodels.fm_metamodel.transformations.json_writer import JSONWriter
from flamapy.metamodels.fm_metamodel.transformations import UVLReader

FM_NAME = 'Pizzas'

if __name__ == '__main__':
    fm = UVLReader(FM_NAME+'.uvl').transform()
    JSONWriter(path=FM_NAME+'.json', source_model=fm).transform()
    

