
from .PropLogicCTCs import getEClassifier, eClassifiers
from .PropLogicCTCs import name, nsURI, nsPrefix, eClass
from .PropLogicCTCs import AdvancedConstraint, Term, FeatureTerm, Not, And, Or, Xor, Equiv, Implies, Excludes

from rhea.fms.BasicFMs import Feature

from . import PropLogicCTCs

__all__ = ['AdvancedConstraint', 'Term', 'FeatureTerm',
           'Not', 'And', 'Or', 'Xor', 'Equiv', 'Implies', 'Excludes']

eSubpackages = []
eSuperPackage = None
PropLogicCTCs.eSubpackages = eSubpackages
PropLogicCTCs.eSuperPackage = eSuperPackage

AdvancedConstraint.expr.eType = Term
FeatureTerm.feature.eType = Feature
Not.term.eType = Term
And.terms.eType = Term
Or.terms.eType = Term
Xor.terms.eType = Term
Equiv.terms.eType = Term
Implies.left.eType = Term
Implies.right.eType = Term
Excludes.left.eType = Term
Excludes.right.eType = Term

otherClassifiers = []

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
