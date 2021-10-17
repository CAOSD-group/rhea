package rhea.transformations.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm;
import rhea.metamodels.ComparativeCTCs.Equal;
import rhea.metamodels.ComparativeCTCs.Less;
import rhea.metamodels.ComparativeCTCs.LessOrEqual;
import rhea.metamodels.ComparativeCTCs.More;
import rhea.metamodels.ComparativeCTCs.MoreOrEqual;
import rhea.metamodels.ComparativeCTCs.NumericTerm;
import rhea.metamodels.ComparativeCTCs.impl.EqualImpl;
import rhea.metamodels.ComparativeCTCs.impl.LessImpl;
import rhea.metamodels.ComparativeCTCs.impl.LessOrEqualImpl;
import rhea.metamodels.ComparativeCTCs.impl.MoreImpl;
import rhea.metamodels.ComparativeCTCs.impl.MoreOrEqualImpl;
import rhea.metamodels.ComparativeCTCs.impl.NotEqualImpl;
import rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl;
import rhea.metamodels.DataTypes.DataType;
import rhea.metamodels.DataTypes.PrimitiveType;
import rhea.metamodels.DataTypes.PrimitiveTypeEnum;
import rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl;
import rhea.metamodels.NumericalFMs.NumericalFeature;
import rhea.metamodels.PropLogicCTCs.AdvancedConstraint;
import rhea.metamodels.PropLogicCTCs.FeatureTerm;
import rhea.metamodels.PropLogicCTCs.Implies;
import rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl;
import rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl;
import rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.engine.FeatureModelGeneratorHelper;
import rhea.transformations.engine.LanguageGeneratorType;

public class FeatureModelGenerator {
	private FeatureModelGeneratorHelper fmg;
	
	public FeatureModelGenerator() {
		fmg = new FeatureModelGeneratorHelper();
	}
	
	public FeatureModel generateFeatureModel(String name, int nFeatures, Map<String,Double> percentages, int nChildMax, int nChildMin) {
		
		FeatureModel fm = fmg.createEmptyFeatureModel(name);
		
		Random rd = new Random();
		double percentage;
		int i = 2;

		Feature parent;
		Boolean mandatory = false;
		LanguageGeneratorType lgt = null;
		
		// Crear una root de una Feature cuyo porcentaje no sea 0.
		/*List<String> possibleRoots = new ArrayList<>();
		possibleRoots.add("Ordinary");
		
		for (String key : percentages.keySet()) 
		{
			if(percentages.get(key) > 0) possibleRoots.add(key);		
		}
		
		String rootGenerator = possibleRoots.get(rd.nextInt(possibleRoots.size()));
		
		if(rootGenerator.contains("Selection")) lgt = LanguageGeneratorType.SelectionGroupRoot;
		else if(rootGenerator.contains("Alternative")) lgt = LanguageGeneratorType.AlternativeGroupRoot;
		else if(rootGenerator.contains("Mutex")) lgt = LanguageGeneratorType.MutexGroupRoot;						
		else if(rootGenerator.contains("Cardinality")) lgt = LanguageGeneratorType.GroupCardinalityRoot;
		else if(rootGenerator.contains("Ordinary")) lgt = LanguageGeneratorType.OrdinaryRoot;
		
		fmg.addFeature(fm, lgt ,"Root",true,false);*/
		//End Create Root
		
		fmg.addFeature(fm, LanguageGeneratorType.OrdinaryRoot ,"Root",true,false);
		
		//NEW CODE
		//Este c�digo genera las features en funci�n de su porcentaje actual (siempre escoge el que tenga menor porcentaje actualmente).
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
			
			if(minClassPath.contains("SelectionGroup")) lgt = LanguageGeneratorType.SelectionGroupNonDeterministic;
			else if(minClassPath.contains("AlternativeGroup")) lgt = LanguageGeneratorType.AlternativeGroupNonDeterministic;
			else if(minClassPath.contains("MutexGroup")) lgt = LanguageGeneratorType.MutexGroupNonDeterministic;						
			else if(minClassPath.contains("GroupCardinality")) lgt = LanguageGeneratorType.GroupCardinalityNonDeterministic;
			else if(minClassPath.contains("NumericalFeature")) lgt = LanguageGeneratorType.NumericalFeatureNonDeterministic;
			
			if (lgt!=null)
			{ 
				if(minClassPath.contains("GroupCardinality")) 
				{	
					fmg.addGroupCardinality(fm, lgt, "F"+Integer.toString(i), rd.nextBoolean(), rd.nextBoolean(), 0, 0);
				}
				else if (minClassPath.contains("NumericalFeature"))
				{
					fmg.addNumericalFeature(fm, lgt, "F"+Integer.toString(i), rd.nextBoolean(), rd.nextBoolean(), 0);
				}
				else fmg.addFeature(fm, lgt, "F"+Integer.toString(i), rd.nextBoolean(), rd.nextBoolean());
				
				if(fm.getFeature("F"+Integer.toString(i)).getParent() instanceof FeatureGroup) fm.getFeature("F"+Integer.toString(i)).setMandatory(false);
				
				System.out.println("Feature: " + i);
				i++;
			}
		}
		
		//END NEW CODE
		
		lgt = LanguageGeneratorType.OrdinaryFeatureDeterministic;
		List<Feature> groups = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.BasicFMs.FeatureGroup");
		
		// Completamos los FeatureGroups
		// ESTE BUCLE NO CUMPLE LAS RESTRICCIONES DE i<nFeatures, para que el modelo de salida siempre sea v�lido.
		for (Feature feature : groups) 
		{
			int nChilds = feature.getChildren().size();	
			
			for (int j = nChilds; j <= nChildMin; j++) 
			{
				fmg.addFeature(fm, lgt, "F"+Integer.toString(i), rd.nextBoolean(), rd.nextBoolean(), feature);
				System.out.println("Completing: " + i);
				i++;
			}
		}		
		
		
		List<Feature> features = new ArrayList<>(fm.getFeatures());
		
		//Rellenamos el resto del modelo
		while(i<=nFeatures)
		{			
			parent = features.get(rd.nextInt(features.size()));
			
			while(parent instanceof FeatureGroup && nChildMax==parent.getChildren().size())
			{
				features.remove(parent);
				parent = features.get(rd.nextInt(features.size()));
			}
			
			if(parent instanceof FeatureGroup) mandatory = false;
			fmg.addFeature(fm, lgt, "F"+Integer.toString(i), mandatory, rd.nextBoolean(), parent);
			System.out.println("Filling: " + i);
			
			i++;
		}
		
		// Añadimos las restricciones y cambiamos el valor de las numéricas
		groups = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.NumericalFMs.NumericalFeature");
		
		BinaryComparativeTerm bct = null;
		NumericTerm nt;
		FeatureTerm ft;
		AdvancedConstraint ac;
		PrimitiveType pt;
		
		for (Feature feature: groups)
		{
			pt = new PrimitiveTypeImpl();
			nt = new NumericTermImpl();
			
			switch(rd.nextInt(3))
			{
				case 0:
					pt.setType(PrimitiveTypeEnum.NATURAL);
					nt.setValue(rd.nextInt(100));
					break;
				case 1:
					pt.setType(PrimitiveTypeEnum.INTEGER);
					nt.setValue(rd.nextInt(50+50) - 50);
					break;
				case 2:
					pt.setType(PrimitiveTypeEnum.REAL);
					nt.setValue((rd.nextFloat()*100)-50);
					break;
			}
			

			((NumericalFeature) feature).setType(pt);
			
			ac = new AdvancedConstraintImpl();
			
			switch(rd.nextInt(6))
			{
				case 0:
					bct = new LessImpl();
					break;
				case 1:
					bct = new MoreImpl();
					break;
				case 2:
					bct = new LessOrEqualImpl();
					break;
				case 3:
					bct = new MoreOrEqualImpl();
					break;
				case 4:
					bct = new EqualImpl();
					break;
				case 5:
					bct = new NotEqualImpl();
					break;
			}
			
			bct.setLeft(nt);
			
			ft = new FeatureTermImpl();
			ft.setFeature(feature);
			bct.setRight(ft);
			
			ac.setExpr(bct);
			fm.getCrosstreeconstraints().add(ac);
			
			// Añadimos restricciones complejas
			
			if(!(bct instanceof Equal))
			{
				float value = nt.getValue();
				nt = new NumericTermImpl();
				
				if(bct instanceof Less || bct instanceof LessOrEqual)
				{
					if(value <= 0) nt.setValue(value+1);
					else nt.setValue(value-1);
				}
				else if (bct instanceof More || bct instanceof MoreOrEqual) 
				{
					if(value <= 0) nt.setValue(value-1);
					else nt.setValue(value+1);
				}
				else nt.setValue(value+1);
				
				ac = new AdvancedConstraintImpl();
				Implies implies = new ImpliesImpl();
				
				ft = new FeatureTermImpl();
				ft.setFeature(fm.getFeatures().get(rd.nextInt(fm.getFeatures().size())));
				implies.setLeft(ft);
				
				bct = new EqualImpl();
				
				ft = new FeatureTermImpl();
				ft.setFeature(feature);
				
				bct.setLeft(ft);
				bct.setRight(nt);
				
				implies.setRight(bct);
				
				ac.setExpr(implies);
				fm.getCrosstreeconstraints().add(ac);
			}
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
			while(upper<lower || upper==0); // || feature.getChildren().size() <= lower
			
			// Cambiamos upper por *
			if((lower==0 || lower==1) && upper==feature.getChildren().size()) upper = -1;
			
			((GroupCardinality) feature).getMultiplicity().setLower(lower);
			((GroupCardinality) feature).getMultiplicity().setUpper(upper);
		}
		
		
		if(!FMHelper.isValid(fm))
		{
			System.out.println("EL FM NO ES V�LIDO");
		}

		// Comprobamos los Porcentajes
		for (String f : percentages.keySet()) {
			if(!f.contains("OrdinaryFeature")) System.out.println("Porcentaje de " + f +": " + (double) FMHelper.getAllFeaturesOf(fm,f).size()/(double) nFeatures);
		}
		
		System.out.println("Porcentaje de OrdinaryFeatures: " + FMHelper.getAllOrdinaryFeatures(fm).size()/(double) nFeatures);
		return fm;
	}
}

//OLD CODE
// Este c�digo por el contrario, genera las Feature hasta llegar a su cupo. Crea FM menos heterog�neos.
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
