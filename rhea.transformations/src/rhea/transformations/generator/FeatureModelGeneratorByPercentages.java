package rhea.transformations.generator;

import java.util.List;
import java.util.Map;
import java.util.Random;

import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.engine.FeatureModelGenerator;
import rhea.transformations.engine.LanguageGeneratorType;

public class FeatureModelGeneratorByPercentages {
	private FeatureModelGenerator fmg;
	private int nChildMin = 2;
	
	public FeatureModelGeneratorByPercentages() {
		fmg = new FeatureModelGenerator();

	}
	
	public FeatureModel generateFeatureModel(String name, int nFeatures, Map<String,Double> percentages, int nChildMax) {
		FeatureModel fm = fmg.createEmptyFeatureModel(name);
		
		double percentage;
		Random rd = new Random();
		Feature parent;
		Boolean mandatory;
		LanguageGeneratorType lgt = null;
		int nChilds;
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"Root",true,false);
		
		int i = 0;
		
		for (String f : percentages.keySet())
		{
			percentage = 0;
			
			while(percentage<percentages.get(f) && i<nFeatures)
			{
				mandatory = rd.nextBoolean();
								
				// Si puedo crear un FeatureGroup entero, lo creo.
				if(i+3<=nFeatures)
				{
					nChilds = rd.nextInt(nChildMax-nChildMin) + nChildMin;
					
					if(f.contains("Selection")) lgt = LanguageGeneratorType.SelectionGroupNonDeterministic;
					else if(f.contains("Alternative")) lgt = LanguageGeneratorType.AlternativeGroupNonDeterministic;
					else if(f.contains("Mutex")) lgt = LanguageGeneratorType.MutexGroupNonDeterministic;						
					else if(f.contains("Cardinality")) lgt = LanguageGeneratorType.GroupCardinalityNonDeterministic;
					
					
					if(f.contains("Cardinality")) fmg.addGroupCardinality(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean(), 0, 0);
					else fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean());
					
					parent = fm.getFeature(Integer.toString(i));
					if(parent.getParent() instanceof FeatureGroup) parent.setMandatory(false);
					i++;
				}
				else break;
				
				percentage = (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) nFeatures;
			}
			
		}
		
		lgt = LanguageGeneratorType.OrdinaryFeatureNonDeterministic;
		List<Feature> groups = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.BasicFMs.FeatureGroup");
		
		// Completamos los FeatureGroups //REVISAR, PETA CON GROUP CARDINALITY
		for (Feature feature : groups) 
		{
			if(feature.getChildren().size()<2)
			{				
				nChilds = rd.nextInt(nChildMax-nChildMin) + nChildMin;
				
				for (int j = feature.getChildren().size(); j <= nChilds; j++) 
				{
					fmg.addFeature(fm, lgt, Integer.toString(i), false, rd.nextBoolean(), feature);
					i++;
				}
				
				if(feature instanceof GroupCardinality) 
				{
					int lower,upper;
			
					System.out.println();
					
					do
					{
						lower = rd.nextInt(feature.getChildren().size());
						upper = rd.nextInt(feature.getChildren().size());
					}
					while(upper<lower || (lower==upper && lower==0));
				}
			}
		}
		
		// Rellenamos el resto del modelo
		while(i<nFeatures)
		{			
			mandatory = rd.nextBoolean();
			fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean());
			if(fm.getFeature(Integer.toString(i)).getParent() instanceof FeatureGroup) fm.getFeature(Integer.toString(i)).setMandatory(false);
			i++;
		}
		
		
		if(!FMHelper.isValid(fm) && fm.getFeatures().size()==nFeatures)
		{
			System.out.println("EL FM NO ES VÁLIDO");
		}
		
		// Comprobamos los Porcentajes
		for (String f : percentages.keySet()) {
			if(!f.contains("Feature")) System.out.println("Porcentaje de " + f +": " + (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) nFeatures);
		}
		
		System.out.println("Porcentaje de OrdinaryFeatures: " + FMHelper.getAllOrdinaryFeatures(fm).size()/(double) nFeatures);
		
		return fm;
	}
}
