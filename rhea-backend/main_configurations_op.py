import time
from flamapy.metamodels.fm_metamodel.transformations import UVLReader
from flamapy.metamodels.bdd_metamodel.operations import BDDProductsNumber
from flamapy.metamodels.bdd_metamodel.transformations import FmToBDD
from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import Glucose3Products


from rhea.metamodels.fm_metamodel.operations import fm_solver
from rhea.metamodels.fm_metamodel.models import fm_utils



MODEL_PATH = 'tests/models/general_models/Pizzas-2.uvl'
MODEL_PATH = 'output.uvl'
MODEL_PATH = 'tests/models/general_models/JHipster-noCTC.uvl'


if __name__ == '__main__':
    fm = UVLReader(MODEL_PATH).transform()
    bdd = FmToBDD(fm).transform()
    n_products = BDDProductsNumber().execute(bdd).get_result()
    print(f'#Products: {n_products}')

    # sat = FmToPysat(fm).transform()
    # print('Generating configs with SAT...')
    # start = time.perf_counter_ns()
    # configurations = Glucose3Products().execute(sat).get_result()
    # end = time.perf_counter_ns()
    # print(f'Time (s): {(end-start)/10**9}')

    #for i, p in enumerate(configurations):
    #    print(f'P{i}: {[str(f) for f in p]}')

    print('Generating configs with FM...')
    start = time.perf_counter_ns()
    configurations = fm_solver.get_configurations(fm)
    end = time.perf_counter_ns()
    print(f'Time (s): {(end-start)/10**9}')

    # configurations = fm_utils.filter_products2(fm, configurations)
    # for i, p in enumerate(configurations):
    #     print(f'P{i}: {[str(f) for f in p]}')




