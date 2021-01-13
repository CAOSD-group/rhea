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
		
		double percentage=0;
		Random rd = new Random();
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"Root",true,false);
		
		int i = 0;
	
		for (String f : percentages.keySet())
		{
			while(percentage<percentages.get(f) && i<nFeatures)
			{
				if(f.contains("Selection")) 
				{
					fmg.addFeature(fm, LanguageGeneratorType.SelectionGroup, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
					i++;
				}
				else if(f.contains("Alternative"))
				{
					fmg.addFeature(fm, LanguageGeneratorType.AlternativeGroup, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
					i++;
				}
				else if(f.contains("Feature")) //Si hay Algun Group con menos de 2 hijos, rellena ahí //TODO
				{
					fmg.addFeature(fm, LanguageGeneratorType.OrdinaryFeature, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
					i++;
				}
				
				// Contamos las Features y comprobamos su porcentaje
				if(f.contains("Feature"))
				{
					percentage = (double) FMHelper.getAllOrdinaryFeatures(fm).size()/(double) nFeatures;
				}
				else
				{
					percentage = (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) nFeatures;
				}
			}
			
		}		
		
		if(!FMHelper.isValid(fm))
		{
			System.out.println("EL FM NO ES VÁLIDO");
		}
		
		return fm;
	}
}
