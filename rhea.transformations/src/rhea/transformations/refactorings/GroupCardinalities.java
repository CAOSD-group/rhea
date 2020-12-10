package rhea.transformations.refactorings;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.NodePair;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.helpers.EMFIO;
import rhea.transformations.engine.HenshinEngine;

public class GroupCardinalities {
	public static final String GROUPCARDINALITYMN_REFACTORING_TEMPLATE_FILEPATH = Rhea.REFACTORINGS_DIR + "";
	private static EPackage basicFMsMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.BASICFMS_METAMODEL);
	private static EPackage groupCardinalityMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.CARDINALITYBASEDFMS_METAMODEL);
	private static EPackage propLogicCTCsMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.PROPLOGICCTCS_METAMODEL);
	
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
	 * @throws ParseException 
	 */
	public static Module completeModuleForGC(String modulePath, GroupCardinality gc) throws ParseException {
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
	 * @throws ParseException 
	 */
	public static Rule createRuleForK(int k, String gcID) throws ParseException {
		// Create the kernel rule
		Rule rule = HenshinFactory.eINSTANCE.createRule();
		rule.setName(gcID + "_k" + k);
		
		// Create the multi-rule (nestedrule)
		Rule nestedRule = createNestedRule(rule);
		
		// Get the eClass type for the objects
		EClass gcType = (EClass) groupCardinalityMetamodel.getEClassifier("GroupCardinality");
		EClass featureType = (EClass) basicFMsMetamodel.getEClassifier("Feature");
		EClass featureTermType = (EClass) propLogicCTCsMetamodel.getEClassifier("FeatureTerm");
		
		// Create the node for the group cardinality
		NodePair gcNode = HenshinRuleAnalysisUtilEx.createPreservedNodeWithAttribute(rule, "", gcType, (EAttribute) gcType.getEStructuralFeature("id"), gcID, false);
		// Create the node image node for the group cardinality in the nested rule
		NodePair nestedGC = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", gcType);
		nestedRule.getMultiMappings().add(gcNode.getLhsNode(), nestedGC.getLhsNode());
		nestedRule.getMultiMappings().add(gcNode.getRhsNode(), nestedGC.getRhsNode());
		
		// Create the nodes for the children of the group cardinality (k children - 1)
		for (int i = 1; i <= k-1; i++) {
			// Create the node in the kernel and nested rule.
			NodePair childNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType);
			NodePair nestedChild = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
			nestedRule.getMultiMappings().add(childNode.getLhsNode(), nestedChild.getLhsNode());
			nestedRule.getMultiMappings().add(childNode.getRhsNode(), nestedChild.getRhsNode());
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, gcNode, childNode, (EReference) gcType.getEStructuralFeature("children"));
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, childNode, gcNode, (EReference) featureType.getEStructuralFeature("parent"));
			
			
			// For each child we create a multi-node FeatureTerm <<create>> and another <<forbid>>
			Node nestedFeatureTermNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", featureTermType);
			HenshinRuleAnalysisUtilEx.createCreateEdge(nestedFeatureTermNode, nestedChild.getRhsNode(), (EReference) featureTermType.getEStructuralFeature("feature"));
			
			// forbid
			Node nestedFeatureTermForbidNode = HenshinRuleAnalysisUtilEx.createForbidNode(nestedRule, featureTermType);
			nestedFeatureTermForbidNode.setAction(Action.parse("forbid*"));
			
			//nestedFeatureTermForbidNode.getGraph().getNestedConditions().get(0).getMappings().add(childNode.getLhsNode(), nestedChild.getLhsNode());
			Node imageChild = HenshinRuleAnalysisUtilEx.getNodeImage(nestedChild.getLhsNode(), nestedFeatureTermForbidNode.getGraph(), nestedRule.getAllMappings());
			System.out.println("imageChild: " + imageChild);
			HenshinRuleAnalysisUtilEx.createForbidEdge(nestedFeatureTermForbidNode, imageChild, (EReference) featureTermType.getEStructuralFeature("feature"), nestedRule);
			//nestedRule.getLhs().getNestedConditions().get(0).getMappings().add(child.getLhsNode(), nestedForbidChild);	// Mapping between the nodes of the kernel and nested rules.
			
			//HenshinRuleAnalysisUtilEx.createForbidEdge(nestedFeatureTermForbidNode, nestedForbidChild, (EReference) featureTermType.getEStructuralFeature("feature"), nestedRule);
		}
		/*
		//NodePair childNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType); // Create the feature node in the kernel rule
		NodePair nestedChildNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType); // Create the feature node in the nested rule
		NodePair gcNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", gcType); // Create the feature node in the nested rule
		
		// Create the mapping between the nodes
		nestedRule.getMultiMappings().add(gcNode.getLhsNode(), gcNestedNode.getLhsNode());
		//nestedRule.getMultiMappings().add(childNode.getRhsNode(), nestedChildNode.getRhsNode());
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, gcNestedNode, nestedChildNode, (EReference) gcType.getEStructuralFeature("children"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, nestedChildNode, gcNestedNode, (EReference) featureType.getEStructuralFeature("parent"));
		*/
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
