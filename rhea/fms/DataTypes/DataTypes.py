"""Definition of meta model 'DataTypes'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
from rhea.fms.BasicFMs import FeatureModel, Feature


name = 'DataTypes'
nsURI = 'rhea.metamodels.DataTypes'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)
PrimitiveTypeEnum = EEnum('PrimitiveTypeEnum', literals=[
                          'Boolean', 'Natural', 'Integer', 'Real', 'String'])


Object = EDataType('Object', instanceClassName='None')


@abstract
class DataType(EObject, metaclass=MetaEClass):

    def __init__(self):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()


class PrimitiveType(DataType):

    type = EAttribute(eType=PrimitiveTypeEnum, unique=True, derived=False, changeable=True)

    def __init__(self, *, type=None, **kwargs):

        super().__init__(**kwargs)

        if type is not None:
            self.type = type


class TypedFeature(Feature):

    type = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, type=None, **kwargs):

        super().__init__(**kwargs)

        if type is not None:
            self.type = type


class ObjectType(DataType):

    type = EAttribute(eType=Object, unique=True, derived=False, changeable=True)

    def __init__(self, *, type=None, **kwargs):

        super().__init__(**kwargs)

        if type is not None:
            self.type = type


class NonTraditionalFM(FeatureModel):

    typedfeatures = EReference(ordered=True, unique=True,
                               containment=False, derived=False, upper=-1)

    def __init__(self, *, typedfeatures=None, **kwargs):

        super().__init__(**kwargs)

        if typedfeatures:
            self.typedfeatures.extend(typedfeatures)
