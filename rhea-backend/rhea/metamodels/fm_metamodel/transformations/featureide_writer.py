from xml.etree import ElementTree as ET
from xml.etree.ElementTree import Element
import inspect
import importlib
import sys
import json
from typing import Any 
from enum import Enum

from flamapy.core.models.ast import Node, ASTOperation
from flamapy.core.transformations import ModelToText

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Constraint, Attribute, Relation

from rhea import refactorings
from rhea import language_constructs
from rhea.fm_tools import fm_tool_info
from rhea.fm_characterization import FMAnalysis


class FeatureIDEWriter(ModelToText):

    CTC_TYPES = {ASTOperation.NOT: 'not',
                 ASTOperation.AND: 'conj',
                 ASTOperation.OR: 'disj',
                 ASTOperation.XOR: 'alt',
                 ASTOperation.IMPLIES: 'imp',
                 ASTOperation.REQUIRES: 'imp',
                 ASTOperation.EXCLUDES: 'impn',
                 ASTOperation.EQUIVALENCE: 'eq',
                 'FEATURE': 'Feature'}

    @staticmethod
    def get_destination_extension() -> str:
        return '.xml'

    def __init__(self, path: str, source_model: FeatureModel) -> None:
        self.path = path
        self.source_model = source_model

    def transform(self) -> str:
        et = _to_featureidexml(self.source_model).getroot()
        xml_str = ET.tostring(et, encoding='unicode', method='xml')
        return pretty_print_xml_elementtree(xml_str)



def _to_featureidexml(feature_model: FeatureModel):
    featureModel = ET.Element("featureModel")
    tree = ET.ElementTree(featureModel)
    struct = ET.SubElement(featureModel, "struct")
    constraints = ET.SubElement(featureModel, "constraints")
    root = ET.SubElement(struct, _tag_element(feature_model.root), _get_attributes(feature_model.root))
    _create_tree(root, feature_model.root.get_relations())
    _get_constraints(constraints, feature_model.get_constraints())
    return tree


def _create_tree(parentElement: Element, relations: list[Relation]):
    for rel in relations:
        for child in rel.children:
            newElem = ET.SubElement(parentElement, _tag_element(child), _get_attributes(child))
            _create_tree(newElem, child.get_relations())


def _get_attributes(feature: Feature):
    atributes = {}
    if feature.is_mandatory(): atributes['mandatory'] ='true'
    if feature.is_abstract: atributes['abstract'] ='true'
    atributes['name'] = feature.name
    return atributes
 

def _tag_element(feature :Feature):
    name = ''
    if feature.is_leaf(): name = 'feature'
    else: 
        if feature.is_or_group(): name = 'or'
        elif feature.is_alternative_group(): name = 'alt'
        else: name = 'and'
    return name


def _get_constraints(parentElement: Element, constraints: list[Constraint]):
    dictConstraints = _get_constraints_info(constraints)
    for const in dictConstraints:
        rule = ET.SubElement(parentElement, 'rule')
        newConstraint = ET.SubElement(rule, const['ast']['type'])
        for operand in const['ast']['operands']:
            _create_elem_constraint(operand, newConstraint)
            

def _create_elem_constraint(operand, parentElement: Element):
    if operand['type'] == 'Feature':
        elem = ET.SubElement(parentElement, 'var')
        elem.text = operand['operands'][0]
    elif operand['type'] == 'not':
        elem = ET.SubElement(parentElement, 'not')
    elif operand['type'] == 'conj':
        elem = ET.SubElement(parentElement, 'conj')
    elif operand['type'] == 'disj':
         elem = ET.SubElement(parentElement, 'disj')
    if len(operand['operands'])>1 or operand['type'] == 'not':
        for op in operand['operands']:
            _create_elem_constraint(op, elem)            

 
def _get_constraints_info(constraints: list[Constraint]) -> list[dict[str, Any]]:
    constraints_info = []
    for ctc in constraints:
        ctc_info = {}
        ctc_info['name'] = ctc.name
        ctc_info['expr'] = ctc.ast.pretty_str()
        ctc_info['ast'] = _get_ctc_info(ctc.ast.root)
        constraints_info.append(ctc_info)
    return constraints_info


def _get_ctc_info(ast_node: Node) -> dict[str, Any]:
    ctc_info: dict[str, Any] = {}
    if ast_node.is_term():
        ctc_info['type'] = FeatureIDEWriter.CTC_TYPES['FEATURE']
        ctc_info['operands'] = [ast_node.data]
    else:
        ctc_info['type'] = FeatureIDEWriter.CTC_TYPES[ast_node.data]
        operands = []
        left = _get_ctc_info(ast_node.left)
        operands.append(left)
        if ast_node.right is not None:
            right = _get_ctc_info(ast_node.right)
            operands.append(right)
        ctc_info['operands'] = operands
    return ctc_info

def pretty_print_xml_elementtree(xml_string):
   # Parse the XML string
   root = ET.fromstring(xml_string)

   # Indent the XML
   indent(root)

   # Convert the XML element back to a string
   pretty_xml = ET.tostring(root, encoding="unicode")

   # Print the pretty XML
   return pretty_xml

def indent(elem, level=0):
   # Add indentation
   indent_size = "  "
   i = "\n" + level * indent_size
   if len(elem):
      if not elem.text or not elem.text.strip():
         elem.text = i + indent_size
      if not elem.tail or not elem.tail.strip():
         elem.tail = i
      for elem in elem:
         indent(elem, level + 1)
      if not elem.tail or not elem.tail.strip():
         elem.tail = i
   else:
      if level and (not elem.tail or not elem.tail.strip()):
         elem.tail = i