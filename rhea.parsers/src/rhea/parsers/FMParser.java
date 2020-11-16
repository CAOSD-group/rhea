package rhea.parsers;

import rhea.metamodels.BasicFMs.FeatureModel;

/**
 * Interface to convert a feature model from a concrete syntax to the abstract syntax of the metamodels.
 *
 */
public interface FMParser {
	
	/**
	 * Parse a feature model in a concrete syntax to the abstract syntax of the metamodels.
	 * 
	 * @param filepath		Filepath of the feature model (any type/extension).
	 * @return				Feature model representation in the abstract syntax.
	 */
	public FeatureModel readFeatureModel(String filepath);
}
