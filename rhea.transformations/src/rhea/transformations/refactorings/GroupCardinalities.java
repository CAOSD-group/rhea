package rhea.transformations.refactorings;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.trace.TracePackage;
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
		
		// Create the nested-rule (multi-rule)
		Rule nestedRule = createNestedRule(rule);
		
		// Create the NAC for the <<forbid>> nodes in the kernel rule
		NestedCondition kernelNAC = rule.getLhs().createNAC(null);
				
		// Create the NAC for the <<forbid>> nodes in the nested rule
		NestedCondition nestedNAC = nestedRule.getLhs().createNAC(null);
				
		// Get the eClass type for the objects
		EClass gcType = (EClass) groupCardinalityMetamodel.getEClassifier("GroupCardinality");
		EClass featureType = (EClass) basicFMsMetamodel.getEClassifier("Feature");
		EClass featureTermType = (EClass) propLogicCTCsMetamodel.getEClassifier("FeatureTerm");
		EClass andType = (EClass) propLogicCTCsMetamodel.getEClassifier("And");
		EClass impliesType = (EClass) propLogicCTCsMetamodel.getEClassifier("Implies");
		EClass orType = (EClass) propLogicCTCsMetamodel.getEClassifier("Or");
		EClass traceType = (EClass) TracePackage.eINSTANCE.getEClassifier("Trace");
		
		// Create gc node in the kernel rule, in the nested rule, in the NAC, and in the nested NAC
		NodePair gcNode = HenshinRuleAnalysisUtilEx.createPreservedNodeWithAttribute(rule, "", gcType, (EAttribute) gcType.getEStructuralFeature("id"), gcID, false);
		NodePair gcNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNodeWithAttribute(nestedRule, "", gcType, (EAttribute) gcType.getEStructuralFeature("id"), gcID, false);
		nestedRule.getMultiMappings().add(gcNode.getLhsNode(), gcNestedNode.getLhsNode());
		nestedRule.getMultiMappings().add(gcNode.getLhsNode(), gcNestedNode.getRhsNode());
		Node gcNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), gcNode.getLhsNode());
		kernelNAC.getMappings().add(gcNode.getLhsNode(), gcNACNode);
		Node gcNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), gcNode.getLhsNode());
		nestedNAC.getMappings().add(gcNode.getLhsNode(), gcNestedNACNode);
		
		// Create implies node 
		NodePair impliesNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", impliesType);
		NodePair impliesNested = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", impliesType);
		nestedRule.getMultiMappings().add(impliesNode.getLhsNode(), impliesNested.getLhsNode());
		nestedRule.getMultiMappings().add(impliesNode.getLhsNode(), impliesNested.getRhsNode());
		Node impliesNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), impliesNode.getLhsNode());
		kernelNAC.getMappings().add(impliesNode.getLhsNode(), impliesNACNode);
		Node impliesNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), impliesNode.getLhsNode());
		nestedNAC.getMappings().add(impliesNode.getLhsNode(), impliesNestedNACNode);
		
		// Create or node
		NodePair orNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", orType);
		NodePair orNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", orType);
		nestedRule.getMultiMappings().add(orNode.getLhsNode(), orNestedNode.getLhsNode());
		nestedRule.getMultiMappings().add(orNode.getLhsNode(), orNestedNode.getRhsNode());
		Node orNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), orNode.getLhsNode());
		kernelNAC.getMappings().add(orNode.getLhsNode(), orNACNode);
		Node orNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), orNode.getLhsNode());
		nestedNAC.getMappings().add(orNode.getLhsNode(), orNestedNACNode);
		
		// Create trace node 
		NodePair traceNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", traceType);
		NodePair traceNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", traceType);
		nestedRule.getMultiMappings().add(traceNode.getLhsNode(), traceNestedNode.getLhsNode());
		nestedRule.getMultiMappings().add(traceNode.getLhsNode(), traceNestedNode.getRhsNode());
		Node traceNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), traceNode.getLhsNode());
		kernelNAC.getMappings().add(traceNode.getLhsNode(), traceNACNode);
		Node traceNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), traceNode.getLhsNode());
		nestedNAC.getMappings().add(traceNode.getLhsNode(), traceNestedNACNode);
		
		// Create the edges
		HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, impliesNode, orNode, (EReference) impliesType.getEStructuralFeature("right"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, traceNode, impliesNode, (EReference) traceType.getEStructuralFeature("source"));
		
		// Create the multi-node And <<create>>
		Node andMultiNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", andType);
		HenshinRuleAnalysisUtilEx.createCreateEdge(orNestedNode.getRhsNode(), andMultiNode, (EReference) orType.getEStructuralFeature("terms"));
		
		// Create the multi-node And <<forbid>>
		Node andMultiNodeForbid = HenshinRuleAnalysisUtilEx.createForbidNode(nestedRule, andType);
		HenshinRuleAnalysisUtilEx.createForbidEdge(orNestedNACNode, andMultiNodeForbid, (EReference) orType.getEStructuralFeature("terms"), nestedRule);
		
		// Create the featureTerm <<create>>
		Node featuretermMultiNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", featureTermType);
		HenshinRuleAnalysisUtilEx.createCreateEdge(andMultiNode, featuretermMultiNode, (EReference) andType.getEStructuralFeature("terms"));
		
		// Create the featureTerm <<forbid>>
		Node featureTermMultiNodeForbid = HenshinRuleAnalysisUtilEx.createForbidNode(nestedRule, featureTermType);
		HenshinRuleAnalysisUtilEx.createForbidEdge(andMultiNodeForbid, featureTermMultiNodeForbid, (EReference) andType.getEStructuralFeature("terms"), nestedRule);
		
		// Create the basic feature multi-node <<preserve>>
		NodePair featureMultiNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
		Node featureMultiNodeNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), featureMultiNode.getLhsNode());
		kernelNAC.getMappings().add(featureMultiNode.getLhsNode(), featureMultiNodeNACNode);
		Node featureMultiNodeNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), featureMultiNode.getLhsNode());
		nestedNAC.getMappings().add(featureMultiNode.getLhsNode(), featureMultiNodeNestedNACNode);
		
		// Create the edges
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, gcNestedNode, featureMultiNode, (EReference) gcType.getEStructuralFeature("children"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, featureMultiNode, gcNestedNode, (EReference) featureType.getEStructuralFeature("parent"));
		
		HenshinRuleAnalysisUtilEx.createCreateEdge(featuretermMultiNode, featureMultiNode.getRhsNode(), (EReference) featureTermType.getEStructuralFeature("feature"));
		HenshinRuleAnalysisUtilEx.createForbidEdge(featureTermMultiNodeForbid, featureMultiNodeNestedNACNode, (EReference) featureTermType.getEStructuralFeature("feature"), nestedRule);
		
		// Create the simple nodes for the children of the group cardinality (k children - 1)
		for (int i = 1; i <= k-1; i++) {
			// Create the node in the kernel and nested rule and in the NACs
			NodePair childNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType);
			NodePair childNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
			nestedRule.getMultiMappings().add(childNode.getLhsNode(), childNestedNode.getLhsNode());
			nestedRule.getMultiMappings().add(childNode.getLhsNode(), childNestedNode.getRhsNode());
			Node childNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), childNode.getLhsNode());
			kernelNAC.getMappings().add(childNode.getLhsNode(), childNACNode);
			Node childNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), childNode.getLhsNode());
			nestedNAC.getMappings().add(childNode.getLhsNode(), childNestedNACNode);
			
			// create the parent/child edges
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, gcNode, childNode, (EReference) gcType.getEStructuralFeature("children"));
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, childNode, gcNode, (EReference) featureType.getEStructuralFeature("parent"));
			
			// Create the featureTerm <<create>>
			Node childFeaturetermMultiNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", featureTermType);
			HenshinRuleAnalysisUtilEx.createCreateEdge(andMultiNode, childFeaturetermMultiNode, (EReference) andType.getEStructuralFeature("terms"));
			
			// Create the featureTerm <<forbid>>
			Node childFeatureTermMultiNodeForbid = HenshinRuleAnalysisUtilEx.createForbidNode(nestedRule, featureTermType);
			HenshinRuleAnalysisUtilEx.createForbidEdge(andMultiNodeForbid, childFeatureTermMultiNodeForbid, (EReference) andType.getEStructuralFeature("terms"), nestedRule);
			
			// Create the edges
			HenshinRuleAnalysisUtilEx.createCreateEdge(childFeaturetermMultiNode, childNestedNode.getRhsNode(), (EReference) featureTermType.getEStructuralFeature("feature"));
			HenshinRuleAnalysisUtilEx.createForbidEdge(childFeatureTermMultiNodeForbid, childNestedNACNode, (EReference) featureTermType.getEStructuralFeature("feature"), nestedRule);
			
			// Create the traces <<create>> and <<forbid>> 
			Node traceChildNode = HenshinRuleAnalysisUtilEx.createCreateNode(rule.getRhs(), "", traceType);
			HenshinRuleAnalysisUtilEx.createCreateEdge(traceChildNode, childNode.getRhsNode(), (EReference) traceType.getEStructuralFeature("source"));
			
			Node traceForbidChildNode = HenshinRuleAnalysisUtilEx.createForbidNode(rule, traceType);
			HenshinRuleAnalysisUtilEx.createForbidEdge(traceForbidChildNode, childNACNode, (EReference) traceType.getEStructuralFeature("source"), rule);
			
			
			
			
//			NodePair childNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType);
//			NodePair nestedChild = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
//			nestedRule.getMultiMappings().add(childNode.getLhsNode(), nestedChild.getLhsNode());
//			nestedRule.getMultiMappings().add(childNode.getRhsNode(), nestedChild.getRhsNode());
//			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, gcNode, childNode, (EReference) gcType.getEStructuralFeature("children"));
//			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, childNode, gcNode, (EReference) featureType.getEStructuralFeature("parent"));
//				
//			// For each child we create a multi-node FeatureTerm <<create>> and another <<forbid>>
//			Node nestedFeatureTermNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", featureTermType);
//			HenshinRuleAnalysisUtilEx.createCreateEdge(nestedFeatureTermNode, nestedChild.getRhsNode(), (EReference) featureTermType.getEStructuralFeature("feature"));
//			// Edge to the and
//			HenshinRuleAnalysisUtilEx.createCreateEdge(nestedAndNode, nestedFeatureTermNode, (EReference) andType.getEStructuralFeature("terms"));
//			
//			// forbid multi
//			Node nestedFeatureTermForbidNode = HenshinRuleAnalysisUtilEx.createForbidNode(nestedRule, featureTermType);
//			nestedFeatureTermForbidNode.setAction(Action.parse("forbid*"));
//			// Edge to the and
//			HenshinRuleAnalysisUtilEx.createForbidEdge(nestedAndForbidNode, nestedFeatureTermForbidNode, (EReference) andType.getEStructuralFeature("terms"), nestedRule);
//			
//			// add node to the nac
//			Node nacChildNode = HenshinRuleAnalysisUtilEx.copyNode(nac.getConclusion(), childNode.getLhsNode());
//			nac.getMappings().add(childNode.getLhsNode(), nacChildNode);
//			
//			// Edge to the feature 
//			HenshinRuleAnalysisUtilEx.createForbidEdge(nestedFeatureTermForbidNode, nacChildNode, (EReference) featureTermType.getEStructuralFeature("feature"), nestedRule);
		}
		
		// Create the multinode for the child
		//NodePair nestedmultiChildNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
		//nestedmultiChildNode.getLhsNode().setAction(Action.parse("preserve*"));
		//nestedRule.getMultiMappings().add(multiChildNode.getLhsNode(), nestedmultiChildNode.getLhsNode());
		//nestedRule.getMultiMappings().add(multiChildNode.getRhsNode(), nestedmultiChildNode.getRhsNode());
		
		//HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, nestedGC, nestedmultiChildNode, (EReference) gcType.getEStructuralFeature("children"));
		//HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, nestedmultiChildNode, gcNode, (EReference) featureType.getEStructuralFeature("parent"));
		
		//nestedRule.getMultiMappings().add(multiChildNode.getLhsNode(), nestedmultiChildNode.getLhsNode());
		//nestedRule.getMultiMappings().add(multiChildNode.getRhsNode(), nestedmultiChildNode.getRhsNode());
		
		//multiChildNode.getLhsNode().setAction(Action.parse("preserve*"));
		
		/*
		NodePair nestedmultiChildNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
		nestedRule.getMultiMappings().add(multiChildNode.getLhsNode(), nestedmultiChildNode.getLhsNode());
		nestedRule.getMultiMappings().add(multiChildNode.getRhsNode(), nestedmultiChildNode.getRhsNode());
		HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, nestedGC, multiChildNode, (EReference) gcType.getEStructuralFeature("children"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, multiChildNode, nestedGC, (EReference) featureType.getEStructuralFeature("parent"));
		*/
		// We create a multi-node FeatureTerm <<create>> and another <<forbid>>
		//Node nestedFeatureTermNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", featureTermType);
		//HenshinRuleAnalysisUtilEx.createCreateEdge(nestedFeatureTermNode, nestedmultiChildNode.getRhsNode(), (EReference) featureTermType.getEStructuralFeature("feature"));
		
		// forbid multi
		//Node nestedFeatureTermForbidNode = HenshinRuleAnalysisUtilEx.createForbidNode(nestedRule, featureTermType);
		//nestedFeatureTermForbidNode.setAction(Action.parse("forbid*"));
		
		
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
