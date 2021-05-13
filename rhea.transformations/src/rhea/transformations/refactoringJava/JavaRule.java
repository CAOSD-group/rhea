package rhea.transformations.refactoringJava;

import java.util.List;

import rhea.metamodels.BasicFMs.*;
import rhea.metamodels.helpers.FMHelper;

public abstract class JavaRule {
	
	protected FeatureModel fm;
	protected String cp;
	protected List<Feature> matchingFeatures;
	
	public JavaRule (FeatureModel fm, String cp)
	{
		this.fm = fm;
		this.cp = cp;
	}
	
	public boolean executeRefactoring ()
	{	
		Boolean sucess = false;
		
		matchingFeatures = FMHelper.getAllFeaturesOf(fm,cp);
		
		for (Feature feature : matchingFeatures) 
		{
			sucess = applyRule(feature.getId());
			if (!sucess) break;
		}
		
		matchingFeatures = FMHelper.getAllFeaturesOf(fm, cp);
		
		return sucess;
	}
	
	public void setFeatureModel(FeatureModel fm)
	{
		this.fm = fm;
		matchingFeatures = FMHelper.getAllFeaturesOf(fm,cp);
	}
	
	public List<Feature> getMatchingFeatures()
	{
		return matchingFeatures;
	}
	
	public FeatureModel getFeatureModel()
	{
		return fm;
	}
	
	protected abstract boolean applyRule (String id);
}
