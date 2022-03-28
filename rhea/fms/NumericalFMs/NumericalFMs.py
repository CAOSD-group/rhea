"""Definition of meta model 'NumericalFMs'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
from rhea.fms.DataTypes import TypedFeature


name = 'NumericalFMs'
nsURI = 'rhea.metamodels.NumericalFMs'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


class NumericalFeature(TypedFeature):

    value = EAttribute(eType=EDouble, unique=True, derived=False, changeable=True)

    def __init__(self, *, value=None, **kwargs):

        super().__init__(**kwargs)

        if value is not None:
            self.value = value
