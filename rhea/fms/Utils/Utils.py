"""Definition of meta model 'Utils'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *


name = 'Utils'
nsURI = 'rhea.metamodels.Utils'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


class NamedElement(EObject, metaclass=MetaEClass):

    id = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, id=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if id is not None:
            self.id = id


class IntResult(NamedElement):

    result = EAttribute(eType=EInt, unique=True, derived=False, changeable=True, default_value=0)

    def __init__(self, *, result=None, **kwargs):

        super().__init__(**kwargs)

        if result is not None:
            self.result = result


class DoubleResult(NamedElement):

    result = EAttribute(eType=EDouble, unique=True, derived=False,
                        changeable=True, default_value=0.0)

    def __init__(self, *, result=None, **kwargs):

        super().__init__(**kwargs)

        if result is not None:
            self.result = result


class StringResult(NamedElement):

    result = EAttribute(eType=EString, unique=True, derived=False, changeable=True)

    def __init__(self, *, result=None, **kwargs):

        super().__init__(**kwargs)

        if result is not None:
            self.result = result


class ListFeatures(NamedElement):

    features = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)

    def __init__(self, *, features=None, **kwargs):

        super().__init__(**kwargs)

        if features:
            self.features.extend(features)
