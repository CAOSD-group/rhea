
from .BasicFMs import getEClassifier, eClassifiers
from .BasicFMs import name, nsURI, nsPrefix, eClass
from .BasicFMs import FeatureModel, Feature, CrossTreeConstraint, FeatureGroup, AlternativeGroup, SelectionGroup


from . import BasicFMs

__all__ = ['FeatureModel', 'Feature', 'CrossTreeConstraint',
           'FeatureGroup', 'AlternativeGroup', 'SelectionGroup']

eSubpackages = []
eSuperPackage = None
BasicFMs.eSubpackages = eSubpackages
BasicFMs.eSuperPackage = eSuperPackage

FeatureModel.root.eType = Feature
FeatureModel.features.eType = Feature
FeatureModel.crosstreeconstraints.eType = CrossTreeConstraint
Feature.children.eType = Feature
Feature.parent.eType = Feature
Feature.parent.eOpposite = Feature.children

otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
