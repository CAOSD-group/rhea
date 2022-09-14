from flamapy.core.transformations import ModelToText
from typing import Any 

from flamapy.metamodels.pysat_metamodel.transformations import FmToPysat
from flamapy.metamodels.pysat_metamodel.operations import (
    Glucose3ProductsNumber,
    Glucose3Products
)

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint


CATEGORY_THEORY_TEMPLATE = 'category_theory_template.cql'


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
        ca_str = configurations_to_csv(self.source_model)
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(ca_str)
        return ca_str


def configurations_to_csv(feature_model: FeatureModel) -> str:
    sat_model = FmToPysat(feature_model).transform()
    configurations = Glucose3Products().execute(sat_model).get_result()
    print(f'number of configurations: {len(configurations)}')

    features_list = []
    features_list = feature_model.get_features()
    header = ','.join((f.name for f in features_list))
    result = f'{header}'
    for c in configurations:
        row = ','.join((str(f.name in c) for f in features_list))
        result += f'\n{row}'
    #feature_model.root.get_attributes()
    return result