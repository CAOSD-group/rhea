package rhea.aafm;

import java.util.List;

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
	 * @return		List with all configurations.
	 */
	public List<List<String>> configurations(FeatureModel fm);
}
