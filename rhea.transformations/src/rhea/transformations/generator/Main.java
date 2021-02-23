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
		
		// 5000 Features empieza a costar generar modelos, al menos en mi pc.
		int nFeature = 20,  nChildMin = 2, nChildMax = 4;
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
		
		// <Class_Path,Porcentaje> Entorno a un 20% de feature groups es lo ideal (preferiblemente, menos).
		LinkedHashMap<String, Double> percentages = new LinkedHashMap<String,Double>();
		percentages.put("rhea.metamodels.BasicFMs.AlternativeGroup", 0.0);
		percentages.put("rhea.metamodels.BasicFMs.SelectionGroup", 0.0);
		percentages.put("rhea.metamodels.CardinalityBasedFMs.MutexGroup", 0.0);
		percentages.put("rhea.metamodels.CardinalityBasedFMs.GroupCardinality", 0.1);

		FeatureModelGeneratorByPercentages fmgi = new FeatureModelGeneratorByPercentages();
		
		FeatureModel fm = fmgi.generateFeatureModel(modelName, nFeature, percentages, nChildMax, nChildMin);
		
		// Save models 
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(fm), Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".txt");
		henshin.saveModel(fm, Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".xmi");
	}
}