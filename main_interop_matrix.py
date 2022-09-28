from flamapy.metamodels.fm_metamodel.transformations import UVLReader

from rhea.fm_tools import FMToolInfo
from rhea.fm_concepts import (
    FMConcept,
    FMCMandatoryFeature,
    FMCOptionalFeature,
    FMCMutexGroup,
    FMCAbstractFeature
)


FM_MODEL = 'JHipster_mux.uvl'

def main() -> None:
    FM_CONCEPTS: list[FMConcept] = [FMCOptionalFeature, FMCMandatoryFeature, FMCAbstractFeature, FMCMutexGroup]

    fm = UVLReader(FM_MODEL).transform()
    glencoe_tool = FMToolInfo(name='Glencoe', support={FMCOptionalFeature, FMCMandatoryFeature})

    for concept in FM_CONCEPTS:
        support = 'NONE'
        if concept in glencoe_tool.support:
            support = 'OK'
        elif concept.get_refactorings():
            support = 'REF'
        print(f'{concept.name()}: {len(concept.get_instances(fm))} -> Glencoe: {support}')
            
        # for inst in concept.get_instances(fm):
        #     for refactoring in concept.get_refactorings():
        #         fm = refactoring.transform(model=fm, instance=inst)


if __name__ == '__main__':
    main()