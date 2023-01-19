from typing import Any
from abc import ABC, abstractmethod

from flamapy.metamodels.fm_metamodel.models import FeatureModel


class LanguageConstruct(ABC):

    @staticmethod
    def name() -> str:
        pass

    @staticmethod
    def count(fm: FeatureModel) -> int:
        pass

    @abstractmethod
    def get(self) -> Any:
        pass

    @abstractmethod
    def apply(self, fm: FeatureModel) -> FeatureModel:
        pass

    @abstractmethod
    def is_applicable(self, fm: FeatureModel) -> bool:
        pass
    
    @staticmethod
    def get_applicable_instances(fm: FeatureModel, features_names: list[str] = []) -> list['LanguageConstruct']:
        pass