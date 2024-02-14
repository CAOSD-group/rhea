import random

from flamapy.core.transformations import ModelToText
from flamapy.metamodels.configuration_metamodel.models import Configuration
from flamapy.metamodels.fm_metamodel.models import FeatureModel


CSV_SEPARATOR = ','
LINE_SEPARATOR = '\n'
DOUBLE_PRECISION = 4
MIN_INT = 1
MAX_INT = 100


class ConfigurationsAttributesWriter(ModelToText):
    """Transform attributes configurations to a CSV format.
    
    Attribute Configurations is specified in a .csv file that is the input of the CT transformation.
    """

    @staticmethod
    def get_destination_extension() -> str:
        return '.csv'

    def __init__(self, path: str, source_model: FeatureModel) -> None:
        self.path = path
        self.source_model = source_model
        self.configurations = []
        self.attributes_info = []

    def set_attributes_types(self, attributes_info: list[dict[str,str]]) -> None:
        self.attributes_info = attributes_info

    def set_configurations(self, configurations: list[Configuration]):
        self.configurations = configurations

    def transform(self) -> str:
        ca_str = configurations_to_csv(self.source_model, self.configurations, self.attributes_info)
        with open(self.path, 'w', encoding='utf-8') as file:
            file.write(ca_str)
        return ca_str


def configurations_to_csv(fm: FeatureModel, configurations: list[Configuration], attributes_info: list[dict[str, str]]) -> str:
    features_names = [f.name for f in fm.get_features()]
    attributes_names = [attr['name'] for attr in attributes_info]
    header = CSV_SEPARATOR.join(features_names + attributes_names)

    configs_str = []
    for config in configurations:
        configs_features = [f for f in config.get_selected_elements()]
        row = CSV_SEPARATOR.join((str(f in configs_features) for f in features_names))
        # Generate attributes
        if attributes_info:
            attributes_row = generate_attributes(attributes_info)
            row = f'{row}{CSV_SEPARATOR}{attributes_row}'

        configs_str.append(row)
    return f'{header}{LINE_SEPARATOR}{LINE_SEPARATOR.join(configs_str)}'


def generate_attributes(attributes_info: list[dict[str, str]]) -> str:
    result = []
    for attribute in attributes_info:
        if attribute['type'] == 'int':
            int_value = random.randint(attribute['minRandomize'], attribute['maxRandomize'])
            result.append(str(int_value))
        elif attribute['type'] == 'bool':
            bool_value = 'false' if random.randint(0, 1) == 0 else 'true'
            result.append(bool_value)
        elif attribute['type'] == 'double':
            digits = max(attribute['minRandomize'], attribute['maxRandomize'])
            double_value = round(random.uniform(attribute['minRandomize'], attribute['maxRandomize']), digits)
            result.append(str(double_value))
    return CSV_SEPARATOR.join(result)
