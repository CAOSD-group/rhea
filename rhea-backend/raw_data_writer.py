from flamapy.core.transformations import ModelToText
from typing import Any
import random
import os

from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint
from rhea.refactorings import FMRefactoring

from rhea.refactorings import utils


class RawDataCSVWriter(ModelToText):
    """Transform raw data about Refactorings to a CSV format.
    
    Raw data is specified in a .csv file that is the input of the refactoring graphics.
    """

    @staticmethod
    def get_destination_extension() -> str:
        return '.csv'

    def __init__(self, path: str, source_model: FeatureModel) -> None:
        self.path = path
        self.source_model = source_model

    def set_attributes(self, attributes: Any) -> None:
        self.attributes = attributes

    def transform(self) -> str:
        fm_basename = os.path.basename(self.path)
        fm_name = fm_basename[:fm_basename.find('.')] 
        data_str = data_to_csv(self.source_model, fm_name)
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(data_str)
        return data_str


def data_to_csv(feature_model: FeatureModel, fm_name: str) -> str:
    FM_STR = 'FM'
    RUN_STR = 'Run'
    FEATURES_STR = 'Features'
    FEATURES_REFACTORED_STR = 'Features Refactored'
    CONSTRAINTS_STR = 'Constraints'
    CONSTRAINTS_REFACTORED_STR = 'Constraints refactored'
    PERFORMANCE_STR = 'Performance'
    SCALABILITY_STR = 'Scalability'
    NATURALNESS_STR = 'Naturalness'
    CORRECTNESS_STR = 'Correctness'
    COMPLETENESS_STR = 'Completeness'

    HEADER = [FM_STR, RUN_STR, FEATURES_STR, FEATURES_REFACTORED_STR, CONSTRAINTS_STR, CONSTRAINTS_REFACTORED_STR]

   
    

    result += f'\n{row}'
    return result

def get_content(fm : FeatureModel, fm_refact: FeatureModel, fm_name: str, run: int) -> str:

    list_row = [fm_name, str(run), len(fm.get_features()), len(fm_refact.get_features()), 
                len(fm.get_constraints()), len(fm_refact.get_constraints())]




    row = ','.join((str(f.name in c) for f in features_list))
    if len(header_attr)>=1:
        if fm_name == 'Pizzas_config_attr':
            row = row + ',' + ','.join([str(random.randint(1, 1000)) for i in range(n_attr)])
        elif fm_name == 'VNS_config_attr':
            attributes = []
            for i in range(n_attr):
                attributes.append(str(random.randint(1, 1000)))
            row = row + ',' + ','.join(attributes)
        else:
            row = row + ',' + ','.join([str(random.randint(1, 1000)) for i in range(n_attr)])
    return row

def execution_refactoring(fm: FeatureModel, refactoring: FMRefactoring) -> FeatureModel:
    instances = refactoring.get_instances(fm)
    for i in instances:
        fm = refactoring.transform(fm, i)
    return fm