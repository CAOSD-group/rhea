
from .DataTypes import getEClassifier, eClassifiers
from .DataTypes import name, nsURI, nsPrefix, eClass
from .DataTypes import DataType, PrimitiveTypeEnum, PrimitiveType, TypedFeature, ObjectType, Object, NonTraditionalFM


from . import DataTypes

__all__ = ['DataType', 'PrimitiveTypeEnum', 'PrimitiveType',
           'TypedFeature', 'ObjectType', 'Object', 'NonTraditionalFM']

eSubpackages = []
eSuperPackage = None
DataTypes.eSubpackages = eSubpackages
DataTypes.eSuperPackage = eSuperPackage

TypedFeature.type.eType = DataType
NonTraditionalFM.typedfeatures.eType = TypedFeature

otherClassifiers = [PrimitiveTypeEnum, Object]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
