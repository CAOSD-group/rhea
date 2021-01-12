package rhea.transformations.generator;

import java.util.HashMap;
import java.util.Map;
import rhea.metamodels.BasicFMs.FeatureModel;

public class Main {

	public static void main(String[] args) {
		
		// <Class_Path,Porcentaje>
		Map<String, Double> percentages = new HashMap<String,Double>();
		percentages.put("rhea.metamodels.BasicFMs.AlternativeGroup", 0.20);
		percentages.put("rhea.metamodels.BasicFMs.SelectionGroup", 0.30);
		percentages.put("rhea.metamodels.BasicFMs.Feature", 0.50);
		
		FeatureModelGeneratorByPercentages fmgi = new FeatureModelGeneratorByPercentages();
		
		FeatureModel fm = fmgi.generateFeatureModel("MyFeatureModel", 10, percentages);
		
		System.out.println();
	}

}
