package rhea.transformations.generator;

import java.util.LinkedHashMap;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;

public class Main {

	public static void main(String[] args) {
		
		String modelName = "MyFeatureModel";
		int nFeature = 10;
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
		
		// <Class_Path,Porcentaje>
		LinkedHashMap<String, Double> percentages = new LinkedHashMap<String,Double>();
		percentages.put("rhea.metamodels.BasicFMs.AlternativeGroup", 0.20);
		percentages.put("rhea.metamodels.BasicFMs.SelectionGroup", 0.20);
		percentages.put("rhea.metamodels.BasicFMs.Feature", 0.60);
		
		FeatureModelGeneratorByPercentages fmgi = new FeatureModelGeneratorByPercentages();
		
		FeatureModel fm = fmgi.generateFeatureModel(modelName, nFeature, percentages);
		
		// Save models 
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(fm), Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".txt");
		henshin.saveModel(fm, Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".xmi");
	}

}
