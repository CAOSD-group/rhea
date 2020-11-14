package rhea.metamodels.utils;

import java.util.Iterator;
import java.util.List;

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
	public static boolean isComplete(FeatureModel fm, List<String> features) {
		for (String name : features) {
			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
				return false;
			}
		}
		return true;
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
