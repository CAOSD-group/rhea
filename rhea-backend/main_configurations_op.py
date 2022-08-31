from flamapy.metamodels.fm_metamodel.transformations import UVLReader

from rhea.metamodels.fm_metamodel.operations import fm_solver
from rhea.metamodels.fm_metamodel.models import fm_utils

MODEL_PATH = 'tests/models/general_models/Pizzas.uvl'
MODEL_PATH = 'output.uvl'


if __name__ == '__main__':
    fm = UVLReader(MODEL_PATH).transform()
    configurations = fm_solver.get_configurations(fm)
    configurations = fm_utils.filter_products2(fm, configurations)
    for i, p in enumerate(configurations):
        print(f'P{i}: {[str(f) for f in p]}')
