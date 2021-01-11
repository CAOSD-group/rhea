package rhea.transformations.generator;

import java.util.HashMap;
import java.util.Map;
import rhea.metamodels.BasicFMs.FeatureModel;

public class Main {

	public static void main(String[] args) {
		
		// <Class_Path,Porcentaje>
		Map<String, Double> percentages = new HashMap<String,Double>();
		FeatureModelGeneratorByInputs fmgi = new FeatureModelGeneratorByInputs(0.0,0.0,0.0,0.0);
		
		FeatureModel fm = fmgi.generateFeatureModel("MyFeatureModel", 1, percentages);
	}

}
