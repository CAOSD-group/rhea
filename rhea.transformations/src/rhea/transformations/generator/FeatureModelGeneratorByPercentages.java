package rhea.transformations.generator;

import java.util.Map;
import java.util.Random;

import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.engine.FeatureModelGenerator;
import rhea.transformations.engine.LanguageGeneratorType;

public class FeatureModelGeneratorByPercentages {
	private FeatureModelGenerator fmg;
	
	public FeatureModelGeneratorByPercentages() {
		fmg = new FeatureModelGenerator();

	}
	
	public FeatureModel generateFeatureModel(String name, int nFeatures, Map<String,Double> percentages) {
		FeatureModel fm = fmg.createEmptyFeatureModel(name);
		
		double percentage,lowestPercentage = 1;
		String lowestFeature="";
		int totalNFeatures;
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"Root",true,false);
		
		for (int i = 0; i < nFeatures; i++) 
		{
			totalNFeatures = fm.getFeatures().size();
			lowestPercentage = 1;
			lowestFeature = "";

			for (String f : percentages.keySet()) // CHECK
			{
				
				// Contamos las Features y comprobamos su porcentaje
				if(f.contains("Feature"))
				{
					percentage = (double) FMHelper.getAllOrdinaryFeatures(fm).size()/(double) totalNFeatures;
				}
				else
				{
					percentage = (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) totalNFeatures;
				}
				
				// Si es la feature con menor porcentaje y aún no ha llegado a su porcentaje definido
				if(percentage<lowestPercentage && percentage<percentages.get(f)) {
					lowestPercentage = percentage;
					lowestFeature = f;
				}
			}
			
			Random rd = new Random();
			
			if(lowestFeature.contains("Selection")) 
			{
				fmg.addFeature(fm, LanguageGeneratorType.SelectionGroup, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
			}
			else if(lowestFeature.contains("Alternative"))
			{
				fmg.addFeature(fm, LanguageGeneratorType.AlternativeGroup, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
			}
			else if(lowestFeature.contains("Feature")) // Cambiar por Feature normales
			{
				fmg.addFeature(fm, LanguageGeneratorType.OptionalFeature, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
			}
		}
		
		return fm;
	}
}
