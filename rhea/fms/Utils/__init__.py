
from .Utils import getEClassifier, eClassifiers
from .Utils import name, nsURI, nsPrefix, eClass
from .Utils import IntResult, DoubleResult, NamedElement, StringResult, ListFeatures

from rhea.fms.BasicFMs import Feature

from . import Utils

__all__ = ['IntResult', 'DoubleResult', 'NamedElement', 'StringResult', 'ListFeatures']

eSubpackages = []
eSuperPackage = None
Utils.eSubpackages = eSubpackages
Utils.eSuperPackage = eSuperPackage

ListFeatures.features.eType = Feature

otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
