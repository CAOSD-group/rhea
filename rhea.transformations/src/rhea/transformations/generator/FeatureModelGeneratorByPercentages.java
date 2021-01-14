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
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"Root",true,false);
		
		int i = 0;
	
		for (String f : percentages.keySet())
		{
			percentage = 0;
			
			while(percentage<percentages.get(f) && i<nFeatures)
			{
				parent = null;
				
				//Comprobamos si hay FeatureGroups que no cumplen que el modelo seá válido
				for (Feature fet: fm.getFeatures()) 
				{
					if(fet instanceof FeatureGroup && (fet.getChildren()==null || fet.getChildren().size()<2))
					{
						parent = fet;
						break;
					}
				}
				

				LanguageGeneratorType lgt = null;
				
				//De no ser válido el modelo, añadimos los hijos a los FeatureGroups. Y si ya es válido, de manera aleatoria. COMPROBAR SI SOLO QUEDAN 2 FEATURES //TODO
				if(f.contains("Selection") && parent==null) lgt = LanguageGeneratorType.SelectionGroupNonDeterministic;
				else if (f.contains("Selection")) lgt = LanguageGeneratorType.SelectionGroupDeterministic;
				else if(f.contains("Alternative") && parent==null) lgt = LanguageGeneratorType.AlternativeGroupNonDeterministic;
				else if(f.contains("Alternative")) lgt = LanguageGeneratorType.AlternativeGroupDeterministic;
				else if(f.contains("Feature") && parent==null) lgt = LanguageGeneratorType.OrdinaryFeatureNonDeterministic;
				else if(f.contains("Feature")) lgt = LanguageGeneratorType.OrdinaryFeatureDeterministic;
				
				fmg.addFeature(fm, lgt, Integer.toString(i), rd.nextBoolean(), rd.nextBoolean(), parent);
				i++;
				
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
