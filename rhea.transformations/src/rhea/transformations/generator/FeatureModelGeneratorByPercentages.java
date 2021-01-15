package rhea.transformations.generator;

import java.util.Map;
import java.util.Random;

import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
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
		
		double percentage;
		Random rd = new Random();
		Feature parent;
		Boolean mandatory;
		LanguageGeneratorType lgt = null;
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"Root",true,false);
		
		int i = 0;
	
		for (String f : percentages.keySet())
		{
			percentage = 0;
			
			while(percentage<percentages.get(f) && i<nFeatures)
			{
				mandatory = rd.nextBoolean();
				
				if(f.contains("Feature"))
				{
					lgt = LanguageGeneratorType.OrdinaryFeatureNonDeterministic;
					fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean());
					if(fm.getFeature(Integer.toString(i)).getParent() instanceof FeatureGroup) fm.getFeature(Integer.toString(i)).setMandatory(false);
					i++;
				}
				
				// Si puedo crear un FeatureGroup entero, lo creo.
				if(i+3<=nFeatures)
				{
					if(f.contains("Selection")) lgt = LanguageGeneratorType.SelectionGroupNonDeterministic;
					else if(f.contains("Alternative")) lgt = LanguageGeneratorType.AlternativeGroupNonDeterministic;
					
					fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean());
					parent = fm.getFeature(Integer.toString(i));
					if(parent.getParent() instanceof FeatureGroup) parent.setMandatory(false);
					i++;
					
					fmg.addFeature(fm, LanguageGeneratorType.OrdinaryFeatureDeterministic, Integer.toString(i), false, rd.nextBoolean(), parent);
					i++;

					fmg.addFeature(fm, LanguageGeneratorType.OrdinaryFeatureDeterministic, Integer.toString(i), false, rd.nextBoolean(), parent);
					i++;
				}
				else
				{
					break;
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
