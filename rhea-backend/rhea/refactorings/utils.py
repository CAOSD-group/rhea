from famapy.metamodels.fm_metamodel.models import FeatureModel

from typing import List


def get_new_feature_name(fm: FeatureModel, name: str) -> str:
    count = 1
    new_name = f'{name}_p'
    while fm.get_feature_by_name(new_name) is not None:
        new_name = f'{name}_p{count}'
        count += 1
    return new_name

def is_there_mandatory(relations: List) -> bool:
    mandatory = False
    for rel in relations:
        if rel.is_mandatory:
            mandatory = True
    return mandatory