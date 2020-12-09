package rhea.transformations.refactorings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.NodePair;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.helpers.EMFIO;
import rhea.transformations.engine.HenshinEngine;

public class GroupCardinalities {
	public static final String GROUPCARDINALITYMN_REFACTORING_TEMPLATE_FILEPATH = Rhea.REFACTORINGS_DIR + "";
	private static EPackage basicFMsMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.BASICFMS_METAMODEL);
	private static EPackage groupCardinalityMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.CARDINALITYBASEDFMS_METAMODEL);
	
	/**
	 * Obtain all groups cardinalities from the feature model.
	 * 
	 * @param fm	Feature model.
	 * @return		List of groups cardinalities.
	 */
	public static List<GroupCardinality> getGroupsCardinalities(FeatureModel fm) {
		List<GroupCardinality> groups = new ArrayList<GroupCardinality>();
		for (Feature f : fm.getFeatures()) {
			if (f instanceof GroupCardinality) {
				groups.add((GroupCardinality) f);
			}
		}
		return groups;
	}
	
	/**
	 * Complete the given Henshin module for a group cardinality based on the refactoring template for group cardinalities MN (generic case).
	 * 
	 * @param modulePath	Path of the module template for group cardinalities MN.
	 * @param gc			Group cardinality.
	 * @return				Henshin module completed.
	 */
	public static Module completeModuleForGC(String modulePath, GroupCardinality gc) {
		HenshinEngine ee = new HenshinEngine(Rhea.BASEDIR);
		
		Module module = ee.getModule(modulePath);
		System.out.println("Module: " + module.getName());
		
		int lower = gc.getMultiplicity().getLower();
		int upper = gc.getMultiplicity().getUpper();
		
		for (int k = lower; k <= upper; k++) {
			Rule r = createRuleForK(k, gc.getId());
			module.getUnits().add(r);
			System.out.println("rule: " + r);
		}
		
		return module;
	}
	
	/**
	 * Create the Henshin rule for the K combinations.
	 * 
	 * @param k		Combinations.
	 * @param gcID	ID of the group cardinality.
	 * @return		Henshin rule.
	 */
	public static Rule createRuleForK(int k, String gcID) {
		Rule rule = HenshinFactory.eINSTANCE.createRule();
		rule.setName(gcID + "_k" + k);
		
		// Create the node for the group cardinality
		EClass gcType = (EClass) groupCardinalityMetamodel.getEClassifier("GroupCardinality");
		NodePair node = HenshinRuleAnalysisUtilEx.createPreservedNodeWithAttribute(rule, "", gcType, (EAttribute) gcType.getEStructuralFeature("id"), gcID, false);
		
		// Create the nodes for the children of the group cardinality
		EClass featureType = (EClass) basicFMsMetamodel.getEClassifier("Feature");
		for (int i = 1; i <= k-1; i++) {
			NodePair child = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType);
			//Optional<EReference> reference = sourceEClass.getEAllReferences().stream().filter(ref -> ref.getEType().equals(targetEClass)).findAny();
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, node, child, (EReference) gcType.getEStructuralFeature("children"));
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, child, node, (EReference) featureType.getEStructuralFeature("parent"));
		}
		
		// Create the multi-node
		Rule nestedRule = createNestedRule(rule);
		//NodePair childNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType); // Create the feature node in the kernel rule
		NodePair nestedChildNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType); // Create the feature node in the nested rule
		NodePair gcNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", gcType); // Create the feature node in the nested rule
		
		// Create the mapping between the nodes
		nestedRule.getMultiMappings().add(node.getLhsNode(), gcNestedNode.getLhsNode());
		//nestedRule.getMultiMappings().add(childNode.getRhsNode(), nestedChildNode.getRhsNode());
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, gcNestedNode, nestedChildNode, (EReference) gcType.getEStructuralFeature("children"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, nestedChildNode, gcNestedNode, (EReference) featureType.getEStructuralFeature("parent"));
		
		return rule;
	}

	private static Rule createNestedRule(Rule rule) {
		Rule nestedRule = HenshinFactory.eINSTANCE.createRule();
		nestedRule.setActivated(true);
		rule.getMultiRules().add(nestedRule);
		
		return nestedRule;
	}
	
	/**
	 * Create the loop unit for the K combinations with the given rule.
	 * 
	 * @param rule	Subunit (rule).
	 * @return		Unit created with the given rule.
	 */
	public static Unit createUnitForK(Rule rule) {
		Unit unit = HenshinFactory.eINSTANCE.createLoopUnit();
		unit.setName(rule.getName() + "Loop");
		unit.getSubUnits(false).add(rule);			// Cuidado con el parametro 'deep' que no sabemos que significa.
		return unit;
	}
}
