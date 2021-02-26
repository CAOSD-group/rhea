package rhea.transformations.refactorings;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.common.henshin.NodePair;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.transformations.engine.HenshinEngine;

public class GroupCardinalities {
	public static final String GROUPCARDINALITYMN_REFACTORING_TEMPLATE_FILEPATH = Rhea.REFACTORINGS_DIR + "";
	//private static EPackage basicFMsMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.BASICFMS_METAMODEL);
	//private static EPackage groupCardinalityMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.CARDINALITYBASEDFMS_METAMODEL);
	//private static EPackage propLogicCTCsMetamodel = (EPackage) EMFIO.loadMetamodel(Rhea.PROPLOGICCTCS_METAMODEL);
	//private static EPackage basicFMsMetamodel = null;
	//private static EPackage groupCardinalityMetamodel = null;
	//private static EPackage propLogicCTCsMetamodel = null;
	private static List<EPackage> imports = null;
	
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
	
	private static EClass getEClass(String name, List<EPackage> metamodels) {
		Optional<EPackage> optMM = metamodels.stream().filter(mm -> mm.getEClassifier(name) != null).findFirst();
		if (optMM.isPresent()) {
			return (EClass) optMM.get().getEClassifier(name);
		} else {
			return null;	
		}
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
		
		// Register metamodels
//		basicFMsMetamodel = ee.registerDynamicMetamodel(Rhea.BASICFMS_METAMODEL);
//		groupCardinalityMetamodel = ee.registerDynamicMetamodel(Rhea.CARDINALITYBASEDFMS_METAMODEL);
//		propLogicCTCsMetamodel = ee.registerDynamicMetamodel(Rhea.PROPLOGICCTCS_METAMODEL);
//		ee.registerStaticMetamodel(TracePackage.eINSTANCE);
		
		// get the module, the imports (metamodels), and the multiplicities
		Module module = ee.getModule(modulePath);
		module.setName(module.getName() + "-" + gc.getId());
		imports = module.getImports();
		int lower = gc.getMultiplicity().getLower();
		int upper = gc.getMultiplicity().getUpper();
		
		// EClass types
		EClass gcType = getEClass("GroupCardinality", imports);
		EClass sgType = getEClass("SelectionGroup", imports);
		
		// Create the main rule
		SequentialUnit mainUnit = createSequentialUnit("GroupCardinalitiesNM");
		mainUnit.setRollback(true);
		mainUnit.setStrict(true);

		Unit u1 = module.getUnit("CreateConstraint");
		mainUnit.getSubUnits().add(u1);
		
		// Special case in template for K = 1, Create the combis' rules
		if (lower == 1) {
			Rule combiK1 = (Rule) module.getUnit("CombiK1");
			Node gcLhsNode = combiK1.getLhs().getNode("gc");
			Node gcRhsNode = combiK1.getRhs().getNode("gc");
			HenshinFactory.eINSTANCE.createAttribute(gcLhsNode, (EAttribute) gcType.getEStructuralFeature("id"), "\"" + gc.getId() + "\"");
			HenshinFactory.eINSTANCE.createAttribute(gcRhsNode, (EAttribute) gcType.getEStructuralFeature("id"), "\"" + gc.getId() + "\"");	
			
			Unit combiK1unit = module.getUnit("MultiCombiK1_Clean");
			
			mainUnit.getSubUnits().add(combiK1unit);
			lower++;
		}
		
		// Create the combis' rules
		for (int k = lower; k <= upper; k++) {
			// create the rule for K combi
			Rule r = createRuleForK(k, gc.getId(), imports);
			module.getUnits().add(r);
			
			// Create the loop unit
			Unit unit = createLoopUnit(r, "Multi" + r.getName());
			module.getUnits().add(unit);
			
			// Create sequential unit with the loop and the clean
			SequentialUnit seqUnit = createSequentialUnit(unit.getName() + "Clean");
			seqUnit.setRollback(true);
			seqUnit.setStrict(true);
			seqUnit.getSubUnits().add(unit);
			seqUnit.getSubUnits().add(module.getUnit("CleanFeatureTrace"));
			module.getUnits().add(seqUnit);
			
			// Add to the main sequential unit
			mainUnit.getSubUnits().add(seqUnit);
		}
		
		// Add  the negative rules
		Rule negRule = (Rule) module.getUnit("AddNegative");
		Node gcLhsNode = negRule.getLhs().getNode("gc");
		Node gcRhsNode = negRule.getRhs().getNode("gc");
		HenshinFactory.eINSTANCE.createAttribute(gcLhsNode, (EAttribute) gcType.getEStructuralFeature("id"), "\"" + gc.getId() + "\"");
		HenshinFactory.eINSTANCE.createAttribute(gcRhsNode, (EAttribute) gcType.getEStructuralFeature("id"), "\"" + gc.getId() + "\"");
	
		mainUnit.getSubUnits().add(module.getUnit("MultiNegative"));
		
		// Add the Transform group rule
		
		Rule tRule = (Rule) module.getUnit("TransformGroupCardinality");
		Node gcDeleteNode = tRule.getLhs().getNode("gc");
		HenshinFactory.eINSTANCE.createAttribute(gcDeleteNode, (EAttribute) gcType.getEStructuralFeature("id"), "\"" + gc.getId() + "\"");
		Node sgCreateNode = tRule.getRhs().getNode("sg");
		HenshinFactory.eINSTANCE.createAttribute(sgCreateNode, (EAttribute) sgType.getEStructuralFeature("id"), "\"" + gc.getId() + "\"");
		
		mainUnit.getSubUnits().add(module.getUnit("TransformGroupCardinality"));
		mainUnit.getSubUnits().add(module.getUnit("Clean"));
		
		module.getUnits().add(mainUnit);
		
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
	public static Rule createRuleForK(int k, String gcID, List<EPackage> metamodels) throws ParseException {
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
		/*
		EClass gcType = (EClass) groupCardinalityMetamodel.getEClassifier("GroupCardinality");
		EClass featureType = (EClass) basicFMsMetamodel.getEClassifier("Feature");
		EClass featureTermType = (EClass) propLogicCTCsMetamodel.getEClassifier("FeatureTerm");
		EClass andType = (EClass) propLogicCTCsMetamodel.getEClassifier("And");
		EClass impliesType = (EClass) propLogicCTCsMetamodel.getEClassifier("Implies");
		EClass orType = (EClass) propLogicCTCsMetamodel.getEClassifier("Or");
		EClass traceType = (EClass) TracePackage.eINSTANCE.getEClassifier("Trace");
		*/
		EClass gcType = getEClass("GroupCardinality", metamodels);
		EClass featureType = getEClass("Feature", metamodels);
		EClass featureTermType = getEClass("FeatureTerm", metamodels);
		EClass andType = getEClass("And", metamodels);
		EClass impliesType = getEClass("Implies", metamodels);
		EClass orType = getEClass("Or", metamodels);
		EClass traceType = getEClass("Trace", metamodels);
		
		
		// Create gc node in the kernel rule, in the nested rule, in the NAC, and in the nested NAC
		NodePair gcNode = HenshinRuleAnalysisUtilEx.createPreservedNodeWithAttribute(rule, "", gcType, (EAttribute) gcType.getEStructuralFeature("id"), gcID, false);
		NodePair gcNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNodeWithAttribute(nestedRule, "", gcType, (EAttribute) gcType.getEStructuralFeature("id"), gcID, false);
		nestedRule.getMultiMappings().add(gcNode.getLhsNode(), gcNestedNode.getLhsNode());
		nestedRule.getMultiMappings().add(gcNode.getRhsNode(), gcNestedNode.getRhsNode());
		Node gcNACNode = HenshinRuleAnalysisUtilEx.createNode(kernelNAC.getConclusion(), gcType);
		kernelNAC.getMappings().add(gcNode.getLhsNode(), gcNACNode);
		Node gcNestedNACNode = HenshinRuleAnalysisUtilEx.createNode(nestedNAC.getConclusion(), gcType);
		nestedNAC.getMappings().add(gcNestedNode.getLhsNode(), gcNestedNACNode);
		
		// Create implies node 
		NodePair impliesNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", impliesType);
		NodePair impliesNested = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", impliesType);
		nestedRule.getMultiMappings().add(impliesNode.getLhsNode(), impliesNested.getLhsNode());
		nestedRule.getMultiMappings().add(impliesNode.getRhsNode(), impliesNested.getRhsNode());
		Node impliesNACNode = HenshinRuleAnalysisUtilEx.createNode(kernelNAC.getConclusion(), impliesType);
		kernelNAC.getMappings().add(impliesNode.getLhsNode(), impliesNACNode);
		Node impliesNestedNACNode = HenshinRuleAnalysisUtilEx.createNode(nestedNAC.getConclusion(), impliesType);
		nestedNAC.getMappings().add(impliesNested.getLhsNode(), impliesNestedNACNode);
		
		// Create or node
		NodePair orNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", orType);
		NodePair orNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", orType);
		nestedRule.getMultiMappings().add(orNode.getLhsNode(), orNestedNode.getLhsNode());
		nestedRule.getMultiMappings().add(orNode.getRhsNode(), orNestedNode.getRhsNode());
		Node orNACNode = HenshinRuleAnalysisUtilEx.createNode(kernelNAC.getConclusion(), orType);
		kernelNAC.getMappings().add(orNode.getLhsNode(), orNACNode);
		Node orNestedNACNode = HenshinRuleAnalysisUtilEx.createNode(nestedNAC.getConclusion(), orType);
		nestedNAC.getMappings().add(orNestedNode.getLhsNode(), orNestedNACNode);
		
		// Create trace node 
		NodePair traceNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", traceType);
		NodePair traceNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", traceType);
		nestedRule.getMultiMappings().add(traceNode.getLhsNode(), traceNestedNode.getLhsNode());
		nestedRule.getMultiMappings().add(traceNode.getRhsNode(), traceNestedNode.getRhsNode());
		Node traceNACNode = HenshinRuleAnalysisUtilEx.createNode(kernelNAC.getConclusion(), traceType);
		kernelNAC.getMappings().add(traceNode.getLhsNode(), traceNACNode);
		Node traceNestedNACNode = HenshinRuleAnalysisUtilEx.createNode(nestedNAC.getConclusion(), traceType);
		nestedNAC.getMappings().add(traceNestedNode.getLhsNode(), traceNestedNACNode);
		
		// Create the edges
		HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, impliesNode, orNode, (EReference) impliesType.getEStructuralFeature("right"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, impliesNested, orNestedNode, (EReference) impliesType.getEStructuralFeature("right"));
		HenshinRuleAnalysisUtilEx.createEdge(impliesNACNode, orNACNode, (EReference) impliesType.getEStructuralFeature("right"), kernelNAC.getConclusion());
		HenshinRuleAnalysisUtilEx.createEdge(impliesNestedNACNode, orNestedNACNode, (EReference) impliesType.getEStructuralFeature("right"), nestedNAC.getConclusion());
		HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, traceNode, impliesNode, (EReference) traceType.getEStructuralFeature("source"));
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, traceNestedNode, impliesNested, (EReference) traceType.getEStructuralFeature("source"));
		HenshinRuleAnalysisUtilEx.createEdge(traceNACNode, impliesNACNode, (EReference) traceType.getEStructuralFeature("source"), kernelNAC.getConclusion());
		HenshinRuleAnalysisUtilEx.createEdge(traceNestedNACNode, impliesNestedNACNode, (EReference) traceType.getEStructuralFeature("source"), nestedNAC.getConclusion());
		
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
		Node featureMultiNodeNestedNACNode = HenshinRuleAnalysisUtilEx.createNode(nestedNAC.getConclusion(), featureType);
		nestedNAC.getMappings().add(featureMultiNode.getLhsNode(), featureMultiNodeNestedNACNode);
		
		// Create the edges
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, gcNestedNode, featureMultiNode, (EReference) featureType.getEStructuralFeature("children"));
		HenshinRuleAnalysisUtilEx.createEdge(gcNestedNACNode, featureMultiNodeNestedNACNode, (EReference) featureType.getEStructuralFeature("children"), nestedNAC.getConclusion());
		HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, featureMultiNode, gcNestedNode, (EReference) featureType.getEStructuralFeature("parent"));
		HenshinRuleAnalysisUtilEx.createEdge(featureMultiNodeNestedNACNode, gcNestedNACNode, (EReference) featureType.getEStructuralFeature("parent"), nestedNAC.getConclusion());
		
		HenshinRuleAnalysisUtilEx.createCreateEdge(featuretermMultiNode, featureMultiNode.getRhsNode(), (EReference) featureTermType.getEStructuralFeature("feature"));
		HenshinRuleAnalysisUtilEx.createForbidEdge(featureTermMultiNodeForbid, featureMultiNodeNestedNACNode, (EReference) featureTermType.getEStructuralFeature("feature"), nestedRule);
		
		// Create the simple nodes for the children of the group cardinality (k children - 1)
		for (int i = 1; i <= k-1; i++) {
			// Create the node in the kernel and nested rule and in the NACs
			NodePair childNode = HenshinRuleAnalysisUtilEx.createPreservedNode(rule, "", featureType);
			NodePair childNestedNode = HenshinRuleAnalysisUtilEx.createPreservedNode(nestedRule, "", featureType);
			nestedRule.getMultiMappings().add(childNode.getLhsNode(), childNestedNode.getLhsNode());
			nestedRule.getMultiMappings().add(childNode.getRhsNode(), childNestedNode.getRhsNode());
			Node childNACNode = HenshinRuleAnalysisUtilEx.copyNode(kernelNAC.getConclusion(), childNode.getLhsNode());
			kernelNAC.getMappings().add(childNode.getLhsNode(), childNACNode);
			Node childNestedNACNode = HenshinRuleAnalysisUtilEx.copyNode(nestedNAC.getConclusion(), childNode.getLhsNode());
			nestedNAC.getMappings().add(childNestedNode.getLhsNode(), childNestedNACNode);
			
			// create the parent/child edges
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, gcNode, childNode, (EReference) featureType.getEStructuralFeature("children"));
			HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, gcNestedNode, childNestedNode, (EReference) featureType.getEStructuralFeature("children"));
			HenshinRuleAnalysisUtilEx.createEdge(gcNACNode, childNACNode, (EReference) featureType.getEStructuralFeature("children"), kernelNAC.getConclusion());
			HenshinRuleAnalysisUtilEx.createEdge(gcNestedNACNode, childNestedNACNode, (EReference) featureType.getEStructuralFeature("children"), nestedNAC.getConclusion());
			HenshinRuleAnalysisUtilEx.createPreservedEdge(rule, childNode, gcNode, (EReference) featureType.getEStructuralFeature("parent"));
			HenshinRuleAnalysisUtilEx.createPreservedEdge(nestedRule, childNestedNode, gcNestedNode, (EReference) featureType.getEStructuralFeature("parent"));
			HenshinRuleAnalysisUtilEx.createEdge(childNACNode, gcNACNode, (EReference) featureType.getEStructuralFeature("parent"), kernelNAC.getConclusion());
			HenshinRuleAnalysisUtilEx.createEdge(childNestedNACNode, gcNestedNACNode, (EReference) featureType.getEStructuralFeature("parent"), nestedNAC.getConclusion());
			
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
			Node traceNestedChildNode = HenshinRuleAnalysisUtilEx.createCreateNode(nestedRule.getRhs(), "", traceType);
			nestedRule.getMultiMappings().add(traceChildNode, traceNestedChildNode);
			HenshinRuleAnalysisUtilEx.createCreateEdge(traceChildNode, childNode.getRhsNode(), (EReference) traceType.getEStructuralFeature("source"));
			HenshinRuleAnalysisUtilEx.createCreateEdge(traceNestedChildNode, childNestedNode.getRhsNode(), (EReference) traceType.getEStructuralFeature("source"));
			
			Node traceForbidChildNode = HenshinRuleAnalysisUtilEx.createForbidNode(rule, traceType);
			HenshinRuleAnalysisUtilEx.createForbidEdge(traceForbidChildNode, childNACNode, (EReference) traceType.getEStructuralFeature("source"), rule);
		}
		return rule;
	}

	private static LoopUnit createLoopUnit(Rule rule, String name) {
		LoopUnit unit = HenshinFactory.eINSTANCE.createLoopUnit();
		unit.setName(name);
		unit.setSubUnit(rule);
		unit.setActivated(true);
		
		return unit;
	}
	
	private static SequentialUnit createSequentialUnit(String name) {
		SequentialUnit unit = HenshinFactory.eINSTANCE.createSequentialUnit();
		unit.setName(name);
		unit.setActivated(true);
		
		return unit;
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
