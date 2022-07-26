import json
from typing import Any 

from famapy.core.models.ast import Node, ASTOperation
from famapy.core.transformations import ModelToText

from famapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Constraint


class JSONWriter(ModelToText):

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
        return '.json'

    def __init__(self, path: str, source_model: FeatureModel) -> None:
        self.path = path
        self.source_model = source_model

    def transform(self) -> str:
        json_object = _to_json(self.source_model)
        if self.path is not None:
            with open(self.path, 'w', encoding='utf8') as file:
                json.dump(json_object, file, indent=4)
        return json.dumps(json_object, indent=4)


def _to_json(feature_model: FeatureModel) -> dict[str, Any]:
    result: dict[str, Any] = {}
    result['name'] = f'FM_{feature_model.root.name}'
    result['features'] = _get_tree_info(feature_model.root)
    result['constraints'] = _get_constraints_info(feature_model.get_constraints())
    return result


def _get_tree_info(feature: Feature) -> dict[str, Any]:
    feature_info = {}
    feature_info['name'] = feature.name
    feature_type = 'FEATURE'
    if feature.is_alternative_group():
        feature_type = 'XOR'
    elif feature.is_or_group():
        feature_type = 'OR'
    elif feature.is_mutex_group():
        feature_type = 'MUTEX'
    elif feature.is_cardinality_group():
        feature_type = 'CARDINALITY'
    if feature_type != 'FEATURE':
        relation = next((r for r in feature.get_relations()), None)
        feature_info['card_min'] = relation.card_min
        feature_info['card_max'] = relation.card_max

    feature_info['type'] = feature_type
    feature_info['optional'] = not feature.is_mandatory()
    feature_info['abstract'] = feature.is_abstract

    children = [_get_tree_info(child) for child in feature.get_children()]
    if children:
        feature_info['children'] = children
    return feature_info


def _get_constraints_info(constraints: list[Constraint]) -> dict[str, Any]:
    constraints_info = {}
    for ctc in constraints:
        constraints_info[ctc.name] = _get_ctc_info(ctc.ast.root)
    return constraints_info


def _get_ctc_info(ast_node: Node) -> dict[str, Any]:
    ctc_info: dict[str, Any] = {}
    if ast_node.is_term():
        ctc_info['type'] = 'FeatureTerm'
        ctc_info['operands'] = [ast_node.data]
    else:
        ctc_info['type'] = JSONWriter.CTC_TYPES[ast_node.data]
        operands = []
        left = _get_ctc_info(ast_node.left)
        operands.append(left)
        if ast_node.right is not None:
            right = _get_ctc_info(ast_node.right)
            operands.append(right)
        ctc_info['operands'] = operands
    return ctc_info