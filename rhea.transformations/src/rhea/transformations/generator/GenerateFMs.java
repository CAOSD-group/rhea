package rhea.transformations.generator;

import java.util.LinkedHashMap;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;

public class GenerateFMs {
	public static void main(String[] args) {
		
		String modelName;
		
		// 5000 Features empieza a costar generar modelos, al menos en mi pc.
		int nChildMin = 2, nChildMax = 4, featureStep = 100, featureLimit = 1000;
		
		//Basic + GCs
		double nAlternativeGroup = 0, nSelectionGroup = 0, nMutexGroup = 0, nGroupCardinality = 0;
		
		//Numerical
		double nNumerical = 0;
		double percentageStep = 0.02, percentageLimit = 0.06;
		
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
		
		// <Class_Path,Porcentaje> Entorno a un 20% de feature groups es lo ideal (preferiblemente, menos).
		LinkedHashMap<String, Double> percentages = new LinkedHashMap<String,Double>();
		FeatureModelGenerator fmgi = new FeatureModelGenerator();
		
		for (int i = 100 ; i <= featureLimit ; i = i + featureStep)
		{
			for (double j = percentageStep ; j <= percentageLimit ; j = j + percentageStep)
			{
				j = Math.round(j * 100.0) / 100.0;
				nAlternativeGroup = Math.round((percentageLimit-j)/2d* 1000.0) / 1000.0;
				nSelectionGroup = nAlternativeGroup;
				
				//Basic + GCs
				percentages.put("rhea.metamodels.BasicFMs.AlternativeGroup", nAlternativeGroup);
				percentages.put("rhea.metamodels.BasicFMs.SelectionGroup", nSelectionGroup);
				percentages.put("rhea.metamodels.CardinalityBasedFMs.MutexGroup", nMutexGroup);
				percentages.put("rhea.metamodels.CardinalityBasedFMs.GroupCardinality", j);
				
				//Numerical
				//percentages.put("rhea.metamodels.", nNumerical);
				
				modelName = Integer.toString(i) +"_"+ Double.toString(nAlternativeGroup) +"-"+ Double.toString(nSelectionGroup) +"-"+ Double.toString(nMutexGroup) +"-"+ 
						Double.toString(j) +"_"+ Integer.toString(nChildMin) +"-"+ Integer.toString(nChildMax);
						
				FeatureModel fm = fmgi.generateFeatureModel(modelName, i, percentages, nChildMax, nChildMin);
				
				// Save model
				FMGenerator g = new ToClafer();
				Utils.serialize(g.fm2text(fm), Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".txt");
				//henshin.saveModel(fm, Rhea.TRANSFORMATIONS_OUTPUT + modelName + ".xmi");
			}
		}
	}
}