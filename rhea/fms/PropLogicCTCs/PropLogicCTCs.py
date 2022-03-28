"""Definition of meta model 'PropLogicCTCs'."""
from functools import partial
import pyecore.ecore as Ecore
from pyecore.ecore import *
from rhea.fms.BasicFMs import CrossTreeConstraint


name = 'PropLogicCTCs'
nsURI = 'rhea.metamodels.PropLogicCTCs'
nsPrefix = 'rhea'

eClass = EPackage(name=name, nsURI=nsURI, nsPrefix=nsPrefix)

eClassifiers = {}
getEClassifier = partial(Ecore.getEClassifier, searchspace=eClassifiers)


@abstract
class Term(EObject, metaclass=MetaEClass):

    def __init__(self):
        # if kwargs:
        #    raise AttributeError('unexpected arguments: {}'.format(kwargs))

        super().__init__()


class AdvancedConstraint(CrossTreeConstraint):

    expr = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, expr=None, **kwargs):

        super().__init__(**kwargs)

        if expr is not None:
            self.expr = expr


class FeatureTerm(Term):

    feature = EReference(ordered=True, unique=True, containment=False, derived=False)

    def __init__(self, *, feature=None, **kwargs):

        super().__init__(**kwargs)

        if feature is not None:
            self.feature = feature


class Not(Term):

    term = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, term=None, **kwargs):

        super().__init__(**kwargs)

        if term is not None:
            self.term = term


class And(Term):

    terms = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, terms=None, **kwargs):

        super().__init__(**kwargs)

        if terms:
            self.terms.extend(terms)


class Or(Term):

    terms = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, terms=None, **kwargs):

        super().__init__(**kwargs)

        if terms:
            self.terms.extend(terms)


class Xor(Term):

    terms = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, terms=None, **kwargs):

        super().__init__(**kwargs)

        if terms:
            self.terms.extend(terms)


class Equiv(Term):

    terms = EReference(ordered=True, unique=True, containment=True, derived=False, upper=-1)

    def __init__(self, *, terms=None, **kwargs):

        super().__init__(**kwargs)

        if terms:
            self.terms.extend(terms)


class Implies(Term):

    left = EReference(ordered=True, unique=True, containment=True, derived=False)
    right = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, left=None, right=None, **kwargs):

        super().__init__(**kwargs)

        if left is not None:
            self.left = left

        if right is not None:
            self.right = right


class Excludes(Term):

    left = EReference(ordered=True, unique=True, containment=True, derived=False)
    right = EReference(ordered=True, unique=True, containment=True, derived=False)

    def __init__(self, *, left=None, right=None, **kwargs):

        super().__init__(**kwargs)

        if left is not None:
            self.left = left

        if right is not None:
            self.right = right
