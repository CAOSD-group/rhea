from typing import Any

from flamapy.metamodels.fm_metamodel.models import FeatureModel, Feature, Relation

from rhea.refactorings import FMRefactoring


class ComplexProLogCrossTreeConstraintRefactoring(FMRefactoring):

    @staticmethod
    def get_name() -> str:
        return 'Complex prop. log. cross-tree constraint'

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
            # constraints = get_constraints_from_card(feature, r_card.card_min, r_card.card_max)

            # fm.ctcs = constraints

        return model
