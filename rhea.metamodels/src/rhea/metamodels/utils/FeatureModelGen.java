package rhea.metamodels.utils;

import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory;

public class FeatureModelGen {
	private BasicFMsFactory basicFMFactory = BasicFMsFactory.eINSTANCE;
	private CardinalityBasedFMsFactory cardinalityBasedFMFactory = CardinalityBasedFMsFactory.eINSTANCE;
	
	private FeatureModel fm;
	
	public FeatureModelGen() {
		fm = basicFMFactory.createFeatureModel();
	}
	
	public FeatureModel getFeatureModel() {
		return fm;
	}
	
	public Feature createRoot(String name) {
		Feature root = basicFMFactory.createFeature();
		root.setId(name);
		root.setName(name);
		
		fm.setRoot(root);
		fm.getFeatures().add(root);
		
		return root;
	}
	
	public Feature createFeature(String name, Feature parent) {
		Feature f = basicFMFactory.createFeature();
		addFeature(f, name, parent);
		return f;
	}
	
	public Feature createAlternativeGroup(String name, Feature parent) {
		Feature f = basicFMFactory.createAlternativeGroup();
		addFeature(f, name, parent);
		return f;
	}
	
	public Feature createSelectionGroup(String name, Feature parent) {
		Feature f = basicFMFactory.createSelectionGroup();
		addFeature(f, name, parent);
		return f;
	}
	
	public Feature createGroupCardinality(String name, Feature parent) {
		Feature f = cardinalityBasedFMFactory.createGroupCardinality();
		addFeature(f, name, parent);
		return f;
	}
	
	private void addFeature(Feature feature, String name, Feature parent) {
		feature.setId(parent.getId() + name);
		feature.setName(name);
		feature.setParent(parent);
		
		fm.getFeatures().add(feature);
	}
}
