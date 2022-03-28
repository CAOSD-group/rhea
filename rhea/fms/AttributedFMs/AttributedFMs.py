"""Definition of meta model 'AttributedFMs'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
from rhea.fms.BasicFMs import FeatureModel


name = 'AttributedFMs'
nsURI = 'rhea.metamodels.AttributedFMs'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


class Attribute(EObject, metaclass=MetaEClass):

    def __init__(self):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()


class AttributedFM(FeatureModel):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)
