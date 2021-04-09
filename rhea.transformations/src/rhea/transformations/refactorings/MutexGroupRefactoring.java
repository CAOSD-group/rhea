package rhea.transformations.refactorings;

import java.util.Iterator;
import java.util.List;

import rhea.metamodels.BasicFMs.*;
import rhea.metamodels.BasicFMs.impl.AlternativeGroupImpl;
import rhea.metamodels.BasicFMs.impl.FeatureImpl;
import rhea.metamodels.CardinalityBasedFMs.MutexGroup;

public class MutexGroupRefactoring extends Refactoring{
	
	public MutexGroupRefactoring(FeatureModel fm, String cp) 
	{
		super(fm, cp);
	}

	@Override
	protected boolean applyRule(String id) 
	{
		//Obtain the feature
		MutexGroup mg = (MutexGroup) fm.getFeature(id);
		List<Feature> childrenMG = mg.getChildren();
		
		//Create the new feature/features
		AlternativeGroup ag = new AlternativeGroupImpl();
		List<Feature> childrenAG = ag.getChildren();
		ag.setName(mg.getName()+"P");
		ag.setId(mg.getId()+"P");
		ag.setMandatory(false);
		ag.setAbstract(true);
		
		Feature f = new FeatureImpl();
		f.setName(mg.getName());
		f.setId(mg.getId());
		f.setMandatory(mg.isMandatory());
		f.setAbstract(mg.isAbstract());
		
		//Change father
		ag.setParent(f);
		f.setParent(mg.getParent());
		mg.getParent().getChildren().remove(ag);
		
		//Change Children
		for (Iterator<Feature> it = childrenMG.iterator(); it.hasNext();) 
		{
			Feature feature = it.next();
			it.remove();
			feature.setParent(ag);
			childrenAG.add(feature);
		}
		
		//Delete the feature from fm
		fm.getFeatures().remove(mg);
		
		//Add the feature to the fm
		fm.getFeatures().add(ag);
		fm.getFeatures().add(f);

		return true;
	}
}
