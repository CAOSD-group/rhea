
from .BasicCTCs import getEClassifier, eClassifiers
from .BasicCTCs import name, nsURI, nsPrefix, eClass
from .BasicCTCs import Requires, Excludes, BasicConstraint

from rhea.fms.BasicFMs import Feature

from . import BasicCTCs

__all__ = ['Requires', 'Excludes', 'BasicConstraint']

eSubpackages = []
eSuperPackage = None
BasicCTCs.eSubpackages = eSubpackages
BasicCTCs.eSuperPackage = eSuperPackage

BasicConstraint.leftFeature.eType = Feature
BasicConstraint.rightFeature.eType = Feature

otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
