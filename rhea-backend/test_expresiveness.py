from flamapy.metamodels.fm_metamodel.transformations import UVLWriter

from rhea.fm_language import FMLanguage
from rhea.language_constructs_gen import (
    FeatureModelConstruct, 
    RootFeature, 
    OptionalFeature, 
    MandatoryFeature, 
    XorGroup,
    OrGroup,
    XorChildFeature,
    OrChildFeature,
    RequiresConstraint,
    ExcludesConstraint
)

CSV_FILE = 'label.csv'
MAX_FEATURES_WITH_CONSTRAINTS = 3
MAX_FEATURES_WITHOUT_CONSTRAINTS = 3


# def generate_feature_models(n_features: int, generate_constraints: bool):
#     fms = fm_generator.generate_all_feature_models(n_features=n_features, generate_constraints=generate_constraints)
#     print(f'#Features: {n_features}')
#     print(f'#FMs: {len(fms)}')

#     header = []
#     labels = set()
#     for fm in fms:
#         characterization = FMCharacterization(fm)
#         metrics_vector = [str(measure.size) if measure.size is not None else str(measure.value) for measure in characterization.metrics.get_metrics()]
#         analysis_vector = [str(measure.size) if measure.size is not None else str(measure.value) for measure in characterization.analysis.get_analysis()]
#         vector = ', '.join(metrics_vector + analysis_vector)
#         labels.add(vector)

#         if not header:
#             header = [measure.property.name for measure in characterization.metrics.get_metrics()]
#             header += [measure.property.name for measure in characterization.analysis.get_analysis()]
#             header = ', '.join(header)
#             if not os.path.exists(CSV_FILE):
#                 with open(CSV_FILE, 'a+') as file:    
#                     file.write(f'{header}\n')

#     print(f'#Labels: {len(labels)}')
#     with open(CSV_FILE, 'a+') as file:    
#         for l in labels:
#             file.write(f'{l}\n')
#     print('----------')

if __name__ == "__main__":
    N = 2
    features_names = [f'F{i}' for i in range(N)]
    language_constructs = [FeatureModelConstruct, 
                           RootFeature, 
                           OptionalFeature, 
                           MandatoryFeature, 
                           XorGroup, 
                           OrGroup, 
                           XorChildFeature, 
                           OrChildFeature]

    language = FMLanguage(language_constructs)
    fms = language.generate_feature_models(features_names)
    fms = language.add_constraints(fms)
    for i, fm in enumerate(fms, 1):
        path = f'models_gen/m_{i}.uvl'
        UVLWriter(path=path, source_model=fm).transform()
    
    # from rhea.expressiveness import powerset
    # ps = powerset(features_names)
    # print(f'#Configurations: {len(ps)}')
    # # for i, p in enumerate(ps, 1):
    # #     print(f'Config {i}: {p}')
    # pps = powerset(ps)
    # # for i, p in enumerate(pps, 1):
    # #     print(f'SPL {i}: {p}')
    # print(f'#SPLs: {len(pps)}')