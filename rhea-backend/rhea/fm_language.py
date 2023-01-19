import copy
import queue

from flamapy.metamodels.fm_metamodel.models import FeatureModel

from rhea.language_constructs_gen import LanguageConstruct, RequiresConstraint, ExcludesConstraint



class FMLanguage():

    def __init__(self, lcs: list[LanguageConstruct]) -> None:
        self.lcs = lcs

    def generate_feature_models(self, features_names: set[str]) -> list[FeatureModel]:
        incomplete_feature_models = queue.Queue()
        incomplete_feature_models.put(None)
        completed_fms = []
        while not incomplete_feature_models.empty():
            fm = incomplete_feature_models.get()
            applicable_lcs = []
            for lc in self.lcs:
                applicable_lcs.extend(lc.get_applicable_instances(fm, features_names))
            if not applicable_lcs:
                completed_fms.append(fm)
                print(f'FMs: {len(completed_fms)}')
            else:
                for alc in applicable_lcs:
                    new_fm = copy.deepcopy(fm)
                    incomplete_feature_models.put(alc.apply(new_fm))
        return completed_fms

    def add_constraints(self, fms: list[FeatureModel]) -> list[FeatureModel]:
        incomplete_feature_models = queue.Queue()
        for fm in fms:
            incomplete_feature_models.put(fm)
        completed_fms = []
        while not incomplete_feature_models.empty():
            fm = incomplete_feature_models.get()
            applicable_lcs = []
            for lc in [RequiresConstraint, ExcludesConstraint]:
                applicable_lcs.extend(lc.get_applicable_instances(fm))
            if not applicable_lcs:
                completed_fms.append(fm)
                print(f'FMs with CTCs: {len(completed_fms)}')
            else:
                for alc in applicable_lcs:
                    new_fm = copy.deepcopy(fm)
                    new_fm = alc.apply(new_fm)
                    completed_fms.append(new_fm)
                    print(f'FMs with CTCs: {len(completed_fms)}')
                    incomplete_feature_models.put(new_fm)
        return completed_fms