"""Definition of meta model 'BasicFMs'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *


name = 'BasicFMs'
nsURI = 'rhea.metamodels.BasicFMs'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


class FeatureModel(EObject, metaclass=MetaEClass):

    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    root = EReference(ordered=True, unique=True, containment=True, derived=False)
    features = EReference(ordered=True, unique=True, containment=False, derived=False, upper=-1)
    crosstreeconstraints = EReference(ordered=True, unique=True,
                                      containment=True, derived=False, upper=-1)

    def __init__(self, *, name=None, root=None, features=None, crosstreeconstraints=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if name is not None:
            self.name = name

        if root is not None:
            self.root = root

        if features:
            self.features.extend(features)

        if crosstreeconstraints:
            self.crosstreeconstraints.extend(crosstreeconstraints)

    def getFeature(self, id=None):

        raise NotImplementedError('operation getFeature(...) not yet implemented')


class Feature(EObject, metaclass=MetaEClass):

    id = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    name = EAttribute(eType=EString, unique=True, derived=False, changeable=True)
    mandatory = EAttribute(eType=EBoolean, unique=True, derived=False,
                           changeable=True, default_value=False)
    abstract = EAttribute(eType=EBoolean, unique=True, derived=False,
                          changeable=True, default_value=False)
    children = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)
    parent = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, id=None, name=None, mandatory=None, children=None, parent=None, abstract=None):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()

        if id is not None:
            self.id = id

        if name is not None:
            self.name = name

        if mandatory is not None:
            self.mandatory = mandatory

        if abstract is not None:
            self.abstract = abstract

        if children:
            self.children.extend(children)

        if parent is not None:
            self.parent = parent

    def isLeaf(self):

        raise NotImplementedError('operation isLeaf(...) not yet implemented')

    def isRoot(self):

        raise NotImplementedError('operation isRoot(...) not yet implemented')


@abstract
class CrossTreeConstraint(EObject, metaclass=MetaEClass):

    def __init__(self):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()


@abstract
class FeatureGroup(Feature):

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class AlternativeGroup(FeatureGroup):
    """It represents alternative features (i.e., a 'xor' group)."""

    def __init__(self, **kwargs):

        super().__init__(**kwargs)


class SelectionGroup(FeatureGroup):
    """It represents a selection of features (i.e., an 'or' group).
"""

    def __init__(self, **kwargs):

        super().__init__(**kwargs)
