"""Definition of meta model 'BasicCTCs'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *


name = 'BasicCTCs'
nsURI = 'rhea.metamodels.BasicCTCs'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


@abstract
class BasicConstraint(EObject, metaclass=MetaEClass):

    leftFeature = EReference(ordered=True, unique=True, containment=False, derived=False)
    rightFeature = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, leftFeature=None, rightFeature=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if leftFeature is not None:
            self.leftFeature = leftFeature

        if rightFeature is not None:
            self.rightFeature = rightFeature


class Requires(BasicConstraint):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class Excludes(BasicConstraint):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)
