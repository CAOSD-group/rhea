import functools
import json
from typing import Any 

from flamapy.core.models.ast import Node, AST, ASTOperation
from flamapy.core.transformations import TextToModel

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Relation, Feature, Constraint

from rhea.flamapy.metamodels.fm_metamodel.transformations.json_writer import JSONFeatureType


class JSONReader(TextToModel):

    CTC_TYPES = {ASTOperation.NOT: 'NotTerm',
                 ASTOperation.AND: 'AndTerm',
                 ASTOperation.OR: 'OrTerm',
                 ASTOperation.XOR: 'XorTerm',
                 ASTOperation.IMPLIES: 'ImpliesTerm',
                 ASTOperation.REQUIRES: 'ImpliesTerm',
                 ASTOperation.EXCLUDES: 'ExcludesTerm',
                 ASTOperation.EQUIVALENCE: 'EquivalentTerm'}

    @staticmethod
    def get_destination_extension() -> str:
        return '.fm'

    def __init__(self, path: str) -> None:
        self.path = path

    def transform(self) -> str:
        with open(self.path, 'r', encoding='utf-8') as file:
            data = json.load(file)
            features_info = data['features']
            constraints_info = data['constraints']
            root_feature = parse_tree(None, features_info)
            constraints = parse_constraints(constraints_info, features_info)
            return FeatureModel(root_feature, constraints)

    @staticmethod
    def parse_json(json_content: str) -> FeatureModel:
        features_info = json_content['features']
        constraints_info = json_content['constraints']
        root_feature = parse_tree(None, features_info)
        constraints = parse_constraints(constraints_info, features_info)
        return FeatureModel(root_feature, constraints)


def parse_tree(parent: Feature, feature_node: dict[str, Any]) -> Feature:
    """Parse the tree structure and returns the root feature."""
    feature_name = feature_node['name']
    feature_type = feature_node['type']
    is_abstract = feature_node['abstract']
    feature = Feature(name=feature_name, parent=parent, is_abstract=is_abstract)

    if 'children' in feature_node:
        children = []
        for child in feature_node['children']:
            child_feature = parse_tree(feature, child)
            optional = child['optional']
            if feature_type == JSONFeatureType.FEATURE.value:  # simple feature (not group)
                card_min = 0 if optional else 1
                relation = Relation(feature, [child_feature], card_min, 1)
                feature.add_relation(relation)
            elif not optional:
                # Additional relation because Glencoe supports mandatory features in groups
                relation = Relation(feature, [child_feature], 1, 1)
                feature.add_relation(relation)
                children.append(child_feature)
            else:
                children.append(child_feature)
        if feature_type != JSONFeatureType.FEATURE.value:  # group
            if feature_type == JSONFeatureType.XOR.value:
                relation = Relation(feature, children, 1, 1)
            elif feature_type == JSONFeatureType.OR.value:
                relation = Relation(feature, children, 1, len(children))
            elif feature_type == JSONFeatureType.CARDINALITY.value:  # Group Cardinality
                card_min = feature_node['card_min']
                card_max = feature_node['card_max']
                relation = Relation(feature, children, card_min, card_max)
            feature.add_relation(relation)
    return feature


def parse_constraints(ctcs_info: dict[str, Any], 
                        features_info: dict[str, Any]) -> list[Constraint]:
    constraints = []
    print(ctcs_info)
    for i, ctc_info in enumerate(ctcs_info.values(), 1):
        ctc_node = parse_ast_constraint(ctc_info, features_info)
        ctc = Constraint(f'CTC{i}', AST(ctc_node))
        constraints.append(ctc)
    return constraints


def parse_ast_constraint(ctc_info: dict[str, Any], 
                            features_info: dict[str, Any]) -> Node:
    ctc_type = ctc_info['type']
    ctc_operands = ctc_info['operands']
    node = None
    if ctc_type == 'FeatureTerm':
        feature_id = ctc_info['operands'][0]
        feature_name = features_info[feature_id]['name']
        node = Node(feature_name)
    elif ctc_type == 'NotTerm':
        left = parse_ast_constraint(ctc_operands[0], features_info)
        node = Node(ASTOperation.NOT, left)
    elif ctc_type == 'ImpliesTerm':
        left = parse_ast_constraint(ctc_operands[0], features_info)
        right = parse_ast_constraint(ctc_operands[1], features_info)
        node = Node(ASTOperation.IMPLIES, left, right)
    elif ctc_type == 'ExcludesTerm':
        left = parse_ast_constraint(ctc_operands[0], features_info)
        right = parse_ast_constraint(ctc_operands[1], features_info)
        node = Node(ASTOperation.EXCLUDES, left, right)
    elif ctc_type == 'EquivalentTerm':
        left = parse_ast_constraint(ctc_operands[0], features_info)
        right = parse_ast_constraint(ctc_operands[1], features_info)
        node = Node(ASTOperation.EQUIVALENCE, left, right)
    elif ctc_type == 'AndTerm':
        op_list = [parse_ast_constraint(op, features_info) for op in ctc_operands]
        node = functools.reduce(lambda l, r: Node(ASTOperation.AND, l, r), op_list)
    elif ctc_type == 'OrTerm':
        op_list = [parse_ast_constraint(op, features_info) for op in ctc_operands]
        node = functools.reduce(lambda l, r: Node(ASTOperation.OR, l, r), op_list)
    elif ctc_type == 'XorTerm':
        op_list = [parse_ast_constraint(op, features_info) for op in ctc_operands]
        node = functools.reduce(lambda l, r: Node(ASTOperation.XOR, l, r), op_list)
    else:
        raise Exception(f'Invalid constraint: {ctc_info}')
    return node