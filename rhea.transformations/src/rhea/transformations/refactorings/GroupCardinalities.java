package rhea.transformations.refactorings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;

public class GroupCardinalities {
	public static final String GROUPCARDINALITYMN_REFACTORING_TEMPLATE_FILEPATH = Rhea.REFACTORINGS_DIR + "";
	
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
	 * Create the Henshin module for a group cardinality based on the refactoring template for group cardinalities MN (generic case).
	 * 
	 * @param gcID	ID of the group cardinality.
	 * @return		Henshin module.
	 */
	public static Module getModuleForGC(String gcID) {
		
		
		return null;
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
		rule.setName(gcID + k);
		
		return null;
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
