package rhea.metamodels.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
import rhea.metamodels.BasicFMs.FeatureModel;

public class FMHelper {

	/**
	 * Check if the feature model is valid.
	 * 
	 * @param fm
	 * @param features
	 * @return
	 */
	public static boolean isValid(FeatureModel fm) {
		boolean valid = true;
		
		Iterator<Feature> it = fm.getFeatures().iterator();
		while (valid && it.hasNext()) {	
			Feature f = it.next();
			
			// Feature groups cannot be leafs
			valid = !(f.isLeaf() && (f instanceof FeatureGroup));
			
			// Feature groups must have at least 2 childs
			valid = valid &&  !(f.getChildren().size() < 2 && (f instanceof FeatureGroup));
			
			// Children of feature groups must be optional
			valid = valid && !((f instanceof FeatureGroup) && f.getChildren().stream().anyMatch(c -> c.isMandatory()));
		}
		return valid;
	}
	
	/**
	 * Check if all features are present in the feature model
	 * 
	 * @param fm
	 * @param features
	 * @return
	 */
	public static boolean isComplete(FeatureModel fm, Set<String> features) {
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Search for feature with the provided name (name is not unique).
	 * 
	 * @param fm		Feature model.
	 * @param name		Name of the feature.
	 * @return			List of feature with the given name.
	 */
	public static List<Feature> getFeatures(FeatureModel fm, String name) {
		return fm.getFeatures().stream().filter(f -> f.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}
	
	/**
	 * Convert a set of configurations/products of features into a set of configurations/products of features' names.
	 * 
	 * @param products	
	 * @return
	 */
	public static Set<Set<String>> configurationsToString(Set<Set<Feature>> configurations) {
		// Convert from string to Feature
		var configs = new HashSet<Set<String>>();
		for (Set<Feature> config : configurations) {
			configs.add(config.stream().map(c -> c.getName()).collect(Collectors.toSet()));
		}
		return configs;
	}
	
	
	/**
	 * Obtain all Features of the same class from the feature model.
	 * 
	 * @param fm	Feature model.
	 * @param name  The name of the class to get all features.
	 * @return		List of features.
	 */
	public static List<Feature> getAllFeaturesOf(FeatureModel fm, String name) {
		List<Feature> features = new ArrayList<Feature>();
		for (Feature f : fm.getFeatures()) {
			try {
				if (Class.forName(name).isInstance(f)) {
					features.add(f);
				}
			} catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		return features;
	}
	
	//Como todas las features heredan de feature "base", si queremos ver cuantas features base existen, debemos contar las features que no sean de ninguna otra instancia.
	public static List<Feature> getAllOrdinaryFeatures(FeatureModel fm) {
		List<Feature> features = new ArrayList<Feature>();
		for (Feature f : fm.getFeatures()) {
			try {
				if (!Class.forName("rhea.metamodels.BasicFMs.AlternativeGroup").isInstance(f) && !Class.forName("rhea.metamodels.BasicFMs.SelectionGroup").isInstance(f) && !Class.forName("rhea.metamodels.CardinalityBasedFMs.MutexGroup").isInstance(f) && !Class.forName("rhea.metamodels.CardinalityBasedFMs.GroupCardinality").isInstance(f)) {
					features.add(f);
				}
			} catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		return features;
	}
	
	
	
//	public FeatureModel createEmptyFeatureModel() {
//		EPackage initialMetamodel = BasicFMsPackage.eINSTANCE;
//		EFactory mFactory = initialMetamodel.getEFactoryInstance();
//		EClass eClass = (EClass) initialMetamodel.getEClassifier("FeatureModel");
//		EObject model = mFactory.create(eClass);
//		EAttribute eAttributeName = (EAttribute) eClass.getEStructuralFeature("name");
//		model.eSet(eAttributeName, "fm");
//
//		return (FeatureModel) model;
//	}
}
