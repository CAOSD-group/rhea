package rhea.aafm;

import java.util.Set;

import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;

public interface AutomatedAnalysisFM {

	/**
	 * Calculate the number of configurations.
	 * 
	 * @param fm	Feature model.
	 * @return		Number of configurations.
	 */
	public int numberOfConfigurations(FeatureModel fm);
	
	/**
	 * Enumerate all configurations.
	 * 
	 * @param fm	Feature model.
	 * @return		Set with all configurations.
	 */
	public Set<Set<Feature>> configurations(FeatureModel fm);
	
	/**
	 * Enumerate all products.
	 * Products are configurations regardless abstract features.
	 * 
	 * @param fm	Feature model.
	 * @return		Set with all products.
	 */
	public Set<Set<Feature>> products(FeatureModel fm);
}
