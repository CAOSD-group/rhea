
from .AttributedFMs import getEClassifier, eClassifiers
from .AttributedFMs import name, nsURI, nsPrefix, eClass
from .AttributedFMs import AttributedFM, Attribute


from . import AttributedFMs

__all__ = ['AttributedFM', 'Attribute']

eSubpackages = []
eSuperPackage = None
AttributedFMs.eSubpackages = eSubpackages
AttributedFMs.eSuperPackage = eSuperPackage


otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
