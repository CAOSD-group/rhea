package rhea.parsers.glencoe;

import java.util.List;
import java.util.Map;

import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;
import rhea.parsers.FMParser;
import rhea.thirdpartyplugins.utils.Utils;

public class GlencoeToFM implements FMParser {
	
	@Override
	public FeatureModel readFeatureModel(String filepath) {
		Map<?, ?> map = Utils.readJsonFile(filepath);
		
		FeatureModel fm = BasicFMsFactory.eINSTANCE.createFeatureModel();
		String name = (String) map.get("name");
		fm.setName(name);
	    
		Map<?,?> featuresInfo = (Map<?, ?>) map.get("features");
		Map<?,?> root = (Map<?, ?>) map.get("tree");
		addFeature(fm, root, null, featuresInfo);
		
		Map<?,?> constraints = (Map<?, ?>) map.get("constraints");
		for (Object constraint : constraints.values()) {
			addConstraint(fm, (Map<?, ?>) constraint, featuresInfo);
		}
		
		return fm;
	}
	
	private void addFeature(FeatureModel fm, Map<?, ?> feature, String parentId, Map<?, ?> featuresInfo) {
		String id = (String) feature.get("id");
		Map<?, ?> info = (Map<?, ?>) featuresInfo.get(id);
		String name = (String) info.get("name");
		boolean mandatory = ! (boolean) info.get("optional");
		String type = (String) info.get("type");
		List<?> children = (List<?>) feature.get("children");
		
		Feature f = null;
		if (type.equals("FEATURE")) {
			f = BasicFMsFactory.eINSTANCE.createFeature();
		} else if (type.equals("OR")) {
			f = CardinalityBasedFMsFactory.eINSTANCE.createGroupCardinality();
			Multiplicity mul = CardinalityBasedFMsFactory.eINSTANCE.createMultiplicity();
			mul.setLower(1);
			mul.setUpper(children.size());
			((GroupCardinality) f).setMultiplicity(mul);
		} else if (type.equals("GENOR")) {
			f = CardinalityBasedFMsFactory.eINSTANCE.createGroupCardinality();
			Multiplicity mul = CardinalityBasedFMsFactory.eINSTANCE.createMultiplicity();
			int lower = (int) info.get("min");
			int upper = (int) info.get("max");
			mul.setLower(lower);
			mul.setUpper(upper);
			((GroupCardinality) f).setMultiplicity(mul);
		} else if (type.equals("XOR")) {
			f = CardinalityBasedFMsFactory.eINSTANCE.createGroupCardinality();
			Multiplicity mul = CardinalityBasedFMsFactory.eINSTANCE.createMultiplicity();
			mul.setLower(1);
			mul.setUpper(1);
			((GroupCardinality) f).setMultiplicity(mul);
		}
		f.setId(id);
		f.setName(name);
		f.setMandatory(mandatory);
		Feature parent = fm.getFeature(parentId);
		f.setParent(parent);
		if (parent == null) {
			fm.setRoot(f);
		} else {
			parent.getChildren().add(f);
		}
		fm.getFeatures().add(f);
		
		if (children != null) {
			for (Object child : children) {
				addFeature(fm, (Map<?, ?>) child, id, featuresInfo);
			}
		}
	}
	
	private void addConstraint(FeatureModel fm, Map<?, ?> constraint, Map<?, ?> featuresInfo) {
		String type = (String) constraint.get("type");
		List<?> operands = (List<?>) constraint.get("operands");
		
		// TODO Glencoe supports complex constraints (not only REQUIRES, EXCLUDES).
	}

}
