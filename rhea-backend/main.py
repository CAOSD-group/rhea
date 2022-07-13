from famapy.metamodels.fm_metamodel.transformations import UVLReader, UVLWriter
from famapy.metamodels.pysat_metamodel.transformations import FmToPysat
from famapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

fm = UVLReader('tests/models/input_models/mutex_groups/mg01.uvl').transform()
print(fm)
sat_model = FmToPysat(fm).transform()
products = Glucose3Products().execute(sat_model).get_result()
print(products)