package rhea.generators;

import rhea.metamodels.BasicFMs.FeatureModel;

/**
 * It represents a generator (i.e., a model to text transformation).
 * 
 * @author José Miguel Horcas
 *
 */
public interface FMGenerator {
	
	/**
	 * Transform a feature model (from its abstract syntax) to a concrete syntax representation.
	 * @param fm	Feature model.
	 * @return		Concrete syntax representation.
	 */
	public String fm2text(FeatureModel fm);
}
