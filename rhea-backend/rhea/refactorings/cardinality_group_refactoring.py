from typing import Any

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation, Constraint

import itertools
import functools

from famapy.core.models.ast import AST, ASTOperation, Node

from rhea.refactorings import Refactoring


class CardinalityGroupRefactoring(Refactoring):

    @staticmethod
    def get_name() -> str:
        return 'Cardinality group refactoring'

    @staticmethod
    def get_instances(model: FeatureModel) -> list[Feature]:
        return [f for f in model.get_features() if f.is_cardinality_group()]

    @staticmethod
    def transform(model: FeatureModel, instance: Feature) -> FeatureModel:

        if instance is None:
            raise Exception(f'There is not feature with name "{instance.name}".')
        if not instance.is_cardinality_group:
            raise Exception(f'Feature {instance.name} is not a cardinality group.')
    
        r_card = next((r for r in instance.get_relations() if r.is_cardinal()), None)

        for child in r_card.children:
            r_opt = Relation(instance, [child], 0, 1)  # optional
            instance.add_relation(r_opt)

            instance.get_relations().remove(r_card)
            constraint = get_constraint_for_cardinality_group(instance, r_card)
            model.ctcs.append(constraint)

        return model


def create_and_constraint_for_cardinality_group(positives: list[Feature], negatives: list[Feature]) -> Node:
    elements = [Node(f.name) for f in positives]
    elements += [AST.create_unary_operation(ASTOperation.NOT, Node(f.name)).root for f in negatives]
    return functools.reduce(lambda left, right: Node(ASTOperation.AND, left, right), elements)


def get_or_constraints_for_cardinality_group(feature: Feature, relation: Relation) -> Node:
    card_min = relation.card_min
    card_max = relation.card_max
    children = set(relation.children)
    and_nodes = []
    for k in range(card_min, card_max + 1):
        print(f'K: {k}')
        combi_k = list(itertools.combinations(relation.children, k))
        print(f'combi_k: {[str(f) for f in combi_k]}')
        for positives in combi_k:
            print(f'Posities: {[str(f) for f in positives]}')
            negatives = children - set(positives)
            print(f'Negatives: {[str(f) for f in negatives]}')
            and_ctc = create_and_constraint_for_cardinality_group(positives, negatives)
            print(f'Node: {and_ctc}')
            and_nodes.append(and_ctc)
            print('---')
        print(f'Fin K {k}')
    return functools.reduce(lambda left, right: Node(ASTOperation.OR, left, right), and_nodes)

def get_constraint_for_cardinality_group(feature: Feature, relation: Relation) -> Constraint:
    ast = AST.create_binary_operation(ASTOperation.IMPLIES,
                                      Node(feature.name),
                                      get_or_constraints_for_cardinality_group(feature, relation))
    print(f'AST: {ast.pretty_str()}')
    return Constraint('CG', ast)