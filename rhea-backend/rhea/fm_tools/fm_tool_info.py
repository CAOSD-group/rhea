from rhea import language_constructs as lc


class FMToolInfo():

    def __init__(self, name: str, support: set[lc.LanguageConstruct]) -> None:
        self._name = name 
        self._support = support

    @property
    def name(self) -> str:
        return self._name

    @property
    def support(self) -> set[lc.LanguageConstruct]:
        return self._support


def get_tools_info() -> list[FMToolInfo]:
    tools = []
    tools.append(FMToolInfo('UVL', [lc.LCFeature,
                                    lc.LCAbstractFeature,
                                    lc.LCOptionalFeature,
                                    lc.LCMandatoryFeature,
                                    lc.LCOrGroupFeature,
                                    lc.LCXorGroupFeature]))
    tools.append(FMToolInfo('Glencoe', [lc.LCFeature,
                                        lc.LCOptionalFeature,
                                        lc.LCMandatoryFeature,
                                        lc.LCOrGroupFeature,
                                        lc.LCXorGroupFeature,
                                        lc.LCCardinalityGroupFeature,
                                        lc.LCOrGroupMandatoryFeature]))
    tools.append(FMToolInfo('SPLOT', [lc.LCFeature,
                                        lc.LCOptionalFeature,
                                        lc.LCMandatoryFeature,
                                        lc.LCOrGroupFeature,
                                        lc.LCXorGroupFeature,
                                        lc.LCMultipleGroupDecomposition]))
    return tools