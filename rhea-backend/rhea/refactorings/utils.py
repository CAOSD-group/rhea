from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation




def get_new_feature_name(fm: FeatureModel, name: str) -> str:
    count = 1
    new_name = f'{name}'
    while fm.get_feature_by_name(new_name) is not None:
        new_name = f'{name}{count}'
        count += 1
    return new_name

def is_there_mandatory(relations: list[Relation]) -> bool:
    mandatory = False
    for rel in relations:
        if rel.is_mandatory():
            mandatory = True
    return mandatory

def is_there_node(parent: Feature, child_node: Feature) -> Feature:
    result = ''
    for child in parent.get_children():
        if child==child_node:
            result = child
    return result

def convert_parent_to_mandatory(fm: FeatureModel, f: Feature) -> FeatureModel:
    parent = f.get_parent()
    if parent is not None:
        # print(f'PARENT: {parent.name}')
        # print(f'PARENT RELATIONS: {[str(r) for r in parent.get_relations()]}')
        rel_mand = next((r for r in parent.relations if f in r.children), None)
        if rel_mand is not None:
            rel_mand.card_min = 1
        fm = convert_parent_to_mandatory(fm, parent)
    return fm

def add_node_to_tree(model: FeatureModel, node: Feature) -> FeatureModel:
    if node not in model.get_features(): 
        #  If model does not contain F (node), the result is None
        return None
    elif model.root==node:
        # If F (node) is the root of model, the result is model. 
        return model
    else:
        parent = node.parent  # Let the parent feature of F (node) be P (parent).
        if (not parent.is_group()) and node.is_optional():  # parent.is_root() or parent.is_mandatory() or parent.is_optional()
            # If P is a MandOpt feature and F is an optional subfeature, make F a mandatory subfeature of P
            rel_mand = next((r for r in parent.get_relations() if node in r.children), None)
            rel_mand.card_min = 1
        elif parent.is_alternative_group():
            # If P is an Xor feature, make P a MandOpt feature which has F as single
            # mandatory subfeature and has no optional subfeatures. All other
            # subfeatures of P are removed from the tree.
            rel = next((r for r in parent.get_relations()), None)
            parent.get_relations().remove(rel)
            r_mand = Relation(parent, [node], 1, 1)  # mandatory
            parent.add_relation(r_mand)
        elif parent.is_or_group():
            # If P is an Or feature, make P a MandOpt feature which has F as single
            # mandatory subfeature, and has all other subfeatures of P as optional subfeatures. 
            relations = [r for r in parent.get_relations()]
            r_mand = Relation(parent, [node], 1, 1)  # mandatory
            parent.add_relation(r_mand)
            for child in parent.get_children():
                if child!=node:
                    r_opt = Relation(parent, [child], 0, 1)  # optional
                    parent.add_relation(r_opt)
            for rel in relations:
                parent.get_relations().remove(rel)

        # Convert P to mandatory.
        model = convert_parent_to_mandatory(model, parent)

    # GOTO step 2 with P instead of F.
    model = add_node_to_tree(model, parent)
    # print(f'NEW MODEL PLUS after: {model}')
    return model

def eliminate_node_from_tree(model: FeatureModel, node: Feature) -> FeatureModel:
    
    # print(f'MODEL LESS PARA {node}: {model}')
    # print(f'{node} ES MANDATORY: {node.is_mandatory()}')

    if node not in model.get_features():
        # If model does not contain node, the result is model.
        return model
    elif model.root==node:
        # If F is the root of T, the result is NIL.
        return None
    else:
        parent = node.parent  # Let the parent feature of F be P.
        if (not parent.is_group()) and node.is_mandatory():  # parent.is_root() or parent.is_mandatory() or parent.is_optional()
            # If P is a MandOpt feature and F is a mandatory subfeature of P, GOTO
            # step 2 with P instead of F.
            model = eliminate_node_from_tree(model, parent)
        elif (not parent.is_group()) and node.is_optional():  # parent.is_root() or parent.is_mandatory() or parent.is_optional()
            # If P is a MandOpt feature and F is an optional subfeature of P, delete F.
            r_opt = next((r for r in parent.get_relations() if r.is_optional() and node in r.children), None)
            parent.get_relations().remove(r_opt)
        elif parent.is_or_group() or parent.is_alternative_group():
            # If P is an Xor feature or an Or feature, delete F; if P has only one
            # remaining subfeature, make P a MandOpt feature and
            # its subfeature a mandatory subfeature. 

            rel = next((r for r in parent.get_relations()), None)
            rel.children.remove(node)
            if rel.card_max > 1:
                rel.card_max -= 1
            if len(rel.children) == 1:
                rel.card_min = 1
            
    return model