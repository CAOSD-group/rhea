package rhea.parsers;

import uma.caosd.rhea.metamodels.BasicFMs.FeatureModel;

public interface FMParser {
	public FeatureModel readFeatureModel(String filepath);
}
