package rhea.transformations.generator;

import java.util.Map;

import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.engine.FeatureModelGenerator;
import rhea.transformations.engine.LanguageGeneratorType;

public class FeatureModelGeneratorByInputs {
	private FeatureModelGenerator fmg;
	private double pOptional;
	private double pMandatory;
	private double pSelection;
	private double pAlternative;
	
	public FeatureModelGeneratorByInputs(Double pO, Double pM, Double pS, Double pA) {
		fmg = new FeatureModelGenerator();
		pOptional = pO;
		pMandatory = pM;
		pSelection = pS;
		pAlternative = pA;
	}
	
	public FeatureModel generateFeatureModel(String name, int nFeatures, Map<String,Double> percentages) {
		FeatureModel fm = fmg.createEmptyFeatureModel(name);
		
		// Comprobamos que feature es la que tiene menor porcentaje, y creamos una de este tipo.
		double percentage,lowestPercentage = 1;
		String lowestFeature="";
		int totalNFeatures;
		
		fmg.addFeature(fm, LanguageGeneratorType.Root ,"Root",true,false);
		
		for (int i = 0; i < nFeatures; i++) 
		{
			totalNFeatures = fm.getFeatures().size();
			/*
			if((percentage = (double) totalNFeatures/(double) FMHelper.getAllOptionalFeaturesOf(fm).size())<pOptional)
			{
				
			}
			else if((percentage = (double) totalNFeatures/(double) FMHelper.getAllMandatoryFeaturesOf(fm).size())<pMandatory)
			{
				
			}
			else if
			{
				
			}
			*/
			for (String f : percentages.keySet()) // CHECK
			{
				// Contamos las Features y comprobamos su porcentaje
				percentage = (double) totalNFeatures/(double) FMHelper.getAllFeaturesOf(fm,f).size();
				
				// Si es la feature con menor porcentaje y aún no ha llegado a su porcentaje definido
				if(percentage<lowestPercentage && percentage<percentages.get(f)) {
					lowestPercentage = percentage;
					lowestFeature = f;
				}
			}
		}
		
		return fm;
	}
}
