from famapy.metamodels.fm_metamodel.models import FeatureModel


def get_new_feature_name(fm: FeatureModel, name: str) -> str:
    count = 1
    new_name = f'{name}_p'
    while fm.get_feature_by_name(new_name) is not None:
        new_name = f'{name}_p{count}'
        count += 1
    return new_name