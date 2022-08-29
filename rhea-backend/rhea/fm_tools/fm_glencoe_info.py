from rhea.fm_tools import FMToolInfo
from rhea.fm_concepts import (
    FMConcept,
    FMCMandatoryFeature,
    FMCOptionalFeature,
    FMCMutexGroup
)


class FMGlencoeInfo(FMToolInfo):

    @staticmethod
    def get_name() -> str:
        return 'Glencoe'

    @staticmethod
    def get_support() -> list[FMConcept]:
        return [FMCOptionalFeature, FMCMandatoryFeature, FMCMutexGroup]
