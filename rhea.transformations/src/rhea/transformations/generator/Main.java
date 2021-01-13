package rhea.transformations.generator;

import java.util.LinkedHashMap;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.thirdpartyplugins.utils.Utils;

public class Main {

	public static void main(String[] args) {
		
		String modelName = "MyFeatureModel";
		
		// <Class_Path,Porcentaje>
		LinkedHashMap<String, Double> percentages = new LinkedHashMap<String,Double>();
		percentages.put("rhea.metamodels.BasicFMs.AlternativeGroup", 0.20);
		percentages.put("rhea.metamodels.BasicFMs.SelectionGroup", 0.30);
		percentages.put("rhea.metamodels.BasicFMs.Feature", 0.50);
		
		FeatureModelGeneratorByPercentages fmgi = new FeatureModelGeneratorByPercentages();
		
		FeatureModel fm = fmgi.generateFeatureModel(modelName, 10, percentages);
		
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(fm), Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".txt");
	}

}
