from flamapy.core.transformations import ModelToText
from typing import Any
import random

from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

from rhea.refactorings import utils


class ConfigurationAttributeWriter(ModelToText):
    """Transform attributes configurations to a CSV format.
    
    Attribute Configurations is specified in a .csv file that is the input of the CT transformation.
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
        ca_str = configurations_to_csv(self.source_model, random.randint(1, 5))
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(ca_str)
        return ca_str


def configurations_to_csv(feature_model: FeatureModel, n_attr: int) -> str:
    # Transform the configurations to csv
    sat_model = FmToPysat(feature_model).transform()
    configurations = Glucose3Products().execute(sat_model).get_result()
    print(f'number of configurations: {len(configurations)}')

    features_list = []
    features_list = feature_model.get_features()
    header = ','.join((f.name for f in features_list))

    header_attr = []
    for i in range(n_attr):
        header_attr.append(utils.get_new_attr_name(header_attr, 'Attribute'))
    header_attr = ','.join(header_attr)
    print(f'header attribute: {header_attr}, header attribute type: {type(header_attr)}')
    if len(header_attr)>=1:
        header = header + ',' + header_attr

    result = f'{header}'
    for c in configurations:
        row = ','.join((str(f.name in c) for f in features_list))
        if len(header_attr)>=1:
            row = row + ',' + ','.join([str(random.randint(0, 10)) for i in range(n_attr)])
        result += f'\n{row}'
    return result