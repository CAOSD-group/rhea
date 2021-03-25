package rhea.transformations.refactorings;

import java.util.List;

import rhea.metamodels.BasicFMs.*;
import rhea.metamodels.helpers.FMHelper;

public abstract class Refactoring {
	
	protected FeatureModel fm;
	protected String cp;
	protected List<Feature> matchingFeatures;
	
	public Refactoring (FeatureModel fm, String cp)
	{
		matchingFeatures = FMHelper.getAllFeaturesOf(fm,cp);
		this.fm = fm;
		this.cp = cp;
	}
	
	public boolean executeRefactoring ()
	{	
		Boolean sucess = false;
		
		for (Feature feature : matchingFeatures) 
		{
			sucess = applyRule(feature.getId());
			if (!sucess) break;
		}
		
		return sucess;
	}
	
	protected abstract boolean applyRule (String id);
}
