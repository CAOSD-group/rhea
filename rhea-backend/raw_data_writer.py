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
    RUN_STR = 
    FEATURES_STR = 
    FEATURES_REFACTORED_STR = 
    

    
    for c in configurations:
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
        result += f'\n{row}'
    return result