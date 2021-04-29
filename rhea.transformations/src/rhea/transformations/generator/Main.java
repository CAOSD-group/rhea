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
		
		String modelName;
		
		// 5000 Features empieza a costar generar modelos, al menos en mi pc.
		int nFeature = 250,  nChildMin = 2, nChildMax = 4;
		double nAlternativeGroup = 0, nSelectionGroup = 0, nMutexGroup = 0, nGroupCardinality = 0.1;
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
		
		// <Class_Path,Porcentaje> Entorno a un 20% de feature groups es lo ideal (preferiblemente, menos).
		LinkedHashMap<String, Double> percentages = new LinkedHashMap<String,Double>();
		percentages.put("rhea.metamodels.BasicFMs.AlternativeGroup", nAlternativeGroup);
		percentages.put("rhea.metamodels.BasicFMs.SelectionGroup", nSelectionGroup);
		percentages.put("rhea.metamodels.CardinalityBasedFMs.MutexGroup", nMutexGroup);
		percentages.put("rhea.metamodels.CardinalityBasedFMs.GroupCardinality", nGroupCardinality);

		FeatureModelGeneratorByPercentages fmgi = new FeatureModelGeneratorByPercentages();
		
		for (int i = nFeature ; i <= 1000 ; i = i + 250)
		{
			modelName = Integer.toString(i) +"_"+ Double.toString(nAlternativeGroup) +"-"+ Double.toString(nSelectionGroup) +"-"+ Double.toString(nMutexGroup) +"-"+ 
			Double.toString(nGroupCardinality) +"_"+ Integer.toString(nChildMin) +"-"+ Integer.toString(nChildMax); 
			
			FeatureModel fm = fmgi.generateFeatureModel(modelName, i, percentages, nChildMax, nChildMin);
			
			// Save model
			FMGenerator g = new ToClafer();
			Utils.serialize(g.fm2text(fm), Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".txt");
			//henshin.saveModel(fm, Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".xmi");
		}
	}
}