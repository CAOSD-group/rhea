package rhea.parsers;

import rhea.metamodels.BasicFMs.FeatureModel;

public interface FMParser {
	public FeatureModel readFeatureModel(String filepath);
}
