
from .NumericalFMs import getEClassifier, eClassifiers
from .NumericalFMs import name, nsURI, nsPrefix, eClass
from .NumericalFMs import NumericalFeature


from . import NumericalFMs

__all__ = ['NumericalFeature']

eSubpackages = []
eSuperPackage = None
NumericalFMs.eSubpackages = eSubpackages
NumericalFMs.eSuperPackage = eSuperPackage


otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
