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
	
	public FeatureModelGeneratorByPercentages() {
		fmg = new FeatureModelGenerator();
	}
	
	public FeatureModel generateFeatureModel(String name, int nFeatures, Map<String,Double> percentages, int nChildMax, int nChildMin) {
		
		FeatureModel fm = fmg.createEmptyFeatureModel(name);
		
		Random rd = new Random();
		double percentage;
		int i = 1;

		Feature parent;
		Boolean mandatory;
		LanguageGeneratorType lgt = null;
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"0",true,false);
		
		//NEW CODE
		//Este código genera las features en función de su porcentaje actual (siempre escoge el que tenga menor porcentaje actualmente).
		double minPercentage = 0;
		String minClassPath = "";
		
		
		while(minPercentage!=1 && i<=nFeatures)
		{
			minPercentage = 1;
			minClassPath = "";
			lgt = null;
			
			for (String f : percentages.keySet())
			{
				percentage = (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) nFeatures;
				
				if(percentage<minPercentage && percentage<percentages.get(f)) // Por exceso, si no llega al porcentaje, crea uno nuevo.
				{
					minPercentage = percentage;
					minClassPath = f;
				}
			}
			
			mandatory = rd.nextBoolean();
			
			if(minClassPath.contains("Selection")) lgt = LanguageGeneratorType.SelectionGroupNonDeterministic;
			else if(minClassPath.contains("Alternative")) lgt = LanguageGeneratorType.AlternativeGroupNonDeterministic;
			else if(minClassPath.contains("Mutex")) lgt = LanguageGeneratorType.MutexGroupNonDeterministic;						
			else if(minClassPath.contains("Cardinality")) lgt = LanguageGeneratorType.GroupCardinalityNonDeterministic;
			
			
			if (lgt!=null)
			{
				if(minClassPath.contains("Cardinality")) fmg.addGroupCardinality(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean(), 0, 0);
				else fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean());
				
				if(fm.getFeature(Integer.toString(i)).getParent() instanceof FeatureGroup) fm.getFeature(Integer.toString(i)).setMandatory(false);
				
				System.out.println("Feature: " + i);
				i++;
			}
		}

		
		//END NEW CODE
		
		lgt = LanguageGeneratorType.OrdinaryFeatureDeterministic;
		List<Feature> groups = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.BasicFMs.FeatureGroup");
		
		// Completamos los FeatureGroups
		// ESTE BUCLE NO CUMPLE LAS RESTRICCIONES DE i<nFeatures, para que el modelo de salida siempre sea válido.
		for (Feature feature : groups) 
		{
			int nChilds = feature.getChildren().size();	
			
			for (int j = nChilds; j <= nChildMin; j++) 
			{
				fmg.addFeature(fm, lgt, Integer.toString(i), false, rd.nextBoolean(), feature);
				System.out.println("Completing: " + i);
				i++;
			}
		}		
		
		
		List<Feature> features = fm.getFeatures();
		
		//Rellenamos el resto del modelo
		while(i<=nFeatures)
		{			
			mandatory = rd.nextBoolean();
			parent = features.get(rd.nextInt(features.size()));
			
			while(parent instanceof FeatureGroup && nChildMax==parent.getChildren().size())
			{
				features.remove(parent);
				parent = features.get(rd.nextInt(features.size()));
			}
			
			if(parent instanceof FeatureGroup) mandatory = false;
			fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean(), parent);
			System.out.println("Filling: " + i);
			
			i++;
		}
		
		// Arreglamos las multiplicidades
		groups = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality");
		
		int lower,upper;
		
		for(Feature feature : groups)
		{	
			do
			{
				lower = rd.nextInt(feature.getChildren().size()+1);
				upper = rd.nextInt(feature.getChildren().size()+1);
			}
			while(upper<lower || upper==0);
			
			((GroupCardinality) feature).getMultiplicity().setLower(lower);
			((GroupCardinality) feature).getMultiplicity().setUpper(upper);
		}
		
		
		if(!FMHelper.isValid(fm))
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

//OLD CODE
// Este código por el contrario, genera las Feature hasta llegar a su cupo. Crea FM menos heterogéneos.
/*
for (String f : percentages.keySet())
{
	percentage = 0;
	
	while(percentage<percentages.get(f) && i<=nFeatures)
	{				
		// Si puedo crear un FeatureGroup entero, lo creo.
			mandatory = rd.nextBoolean();
			
			if(f.contains("Selection")) lgt = LanguageGeneratorType.SelectionGroupNonDeterministic;
			else if(f.contains("Alternative")) lgt = LanguageGeneratorType.AlternativeGroupNonDeterministic;
			else if(f.contains("Mutex")) lgt = LanguageGeneratorType.MutexGroupNonDeterministic;						
			else if(f.contains("Cardinality")) lgt = LanguageGeneratorType.GroupCardinalityNonDeterministic;
			
			
			if(f.contains("Cardinality")) fmg.addGroupCardinality(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean(), 0, 0);
			else fmg.addFeature(fm, lgt, Integer.toString(i), mandatory, rd.nextBoolean());
			
			parent = fm.getFeature(Integer.toString(i));
			if(parent.getParent() instanceof FeatureGroup) parent.setMandatory(false);
			
			//System.out.println("Feature: " + i);
			i++;
		
			percentage = (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) nFeatures;
	}
	
}
*/
//END OLD CODE
