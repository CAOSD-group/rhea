package rhea.transformations.refactorings;

import java.util.Iterator;
import java.util.List;

import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.impl.AlternativeGroupImpl;
import rhea.metamodels.BasicFMs.impl.FeatureImpl;
import rhea.metamodels.BasicFMs.impl.SelectionGroupImpl;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;
import rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl;
import rhea.metamodels.CardinalityBasedFMs.impl.MultiplicityImpl;

public class GroupCardinalityBaseRefactoring extends Refactoring{

	public GroupCardinalityBaseRefactoring(FeatureModel fm, String cp) 
	{
		super(fm, cp);
	}

	@Override
	protected boolean applyRule(String id) 
	{
		//Obtain the feature
		GroupCardinality gc = (GroupCardinality) fm.getFeature(id);
		List<Feature> childrenGC = gc.getChildren();
		
		//Obtain the Multiplicity
		int lower = gc.getMultiplicity().getLower();
		int upper = gc.getMultiplicity().getUpper();
		
		Feature f,fParent;
		List<Feature> childrenF;
		
		//Select the base case TODO
		if(lower==1 && upper==1)
		{
			//Create the feature
			f = new AlternativeGroupImpl();
			f.setName(gc.getName());
			f.setId(gc.getId());
			f.setMandatory(gc.isMandatory());
			f.setAbstract(gc.isAbstract());
			
			//Change father
			f.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			childrenF =  f.getChildren();
			
			//Change Children
			for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
			{
				Feature feature = it.next();
				it.remove();
				feature.setParent(f);
				childrenF.add(feature);
			}
			
			//Add the feature to the fm
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if(lower==1 && upper==-1)
		{
			//Create the feature
			f = new SelectionGroupImpl();
			f.setName(gc.getName());
			f.setId(gc.getId());
			f.setMandatory(gc.isMandatory());
			f.setAbstract(gc.isAbstract());
			
			//Change father
			f.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			childrenF =  f.getChildren();
			
			//Change Children
			for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
			{
				Feature feature = it.next();
				it.remove();
				feature.setParent(f);
				childrenF.add(feature);
			}
			
			//Add the feature to the fm
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==0 && upper==1)
		{
			//Create the parent feature
			fParent = new FeatureImpl();
			fParent.setName(gc.getName());
			fParent.setId(gc.getId());
			fParent.setMandatory(gc.isMandatory());
			fParent.setAbstract(gc.isAbstract());
			
			//Create the feature
			f = new AlternativeGroupImpl();
			f.setName(gc.getName()+"P");
			f.setId(gc.getId()+"P");
			f.setMandatory(false);
			f.setAbstract(true);
			
			//Change father
			f.setParent(fParent);
			fParent.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			childrenF =  f.getChildren();
			
			//Change Children
			for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
			{
				Feature feature = it.next();
				it.remove();
				feature.setParent(f);
				childrenF.add(feature);
			}
			
			//Add the feature to the fm
			fm.getFeatures().add(fParent);
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==0 && upper==-1)
		{
			//Create the parent feature
			fParent = new FeatureImpl();
			fParent.setName(gc.getName());
			fParent.setId(gc.getId());
			fParent.setMandatory(gc.isMandatory());
			fParent.setAbstract(gc.isAbstract());
			
			//Create the feature
			f = new SelectionGroupImpl();
			f.setName(gc.getName()+"P");
			f.setId(gc.getId()+"P");
			f.setMandatory(false);
			f.setAbstract(true);
			
			//Change father
			f.setParent(fParent);
			fParent.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			childrenF =  f.getChildren();
			
			//Change Children
			for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
			{
				Feature feature = it.next();
				it.remove();
				feature.setParent(f);
				childrenF.add(feature);
			}
			
			//Add the feature to the fm
			fm.getFeatures().add(fParent);
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==0)
		{
			//Create the parent feature
			fParent = new FeatureImpl();
			fParent.setName(gc.getName());
			fParent.setId(gc.getId());
			fParent.setMandatory(gc.isMandatory());
			fParent.setAbstract(gc.isAbstract());
			
			//Create the feature
			f = new GroupCardinalityImpl();
			f.setName(gc.getName()+"P");
			f.setId(gc.getId()+"P");
			f.setMandatory(false);
			f.setAbstract(true);
			
			//Create the multiplicity
			Multiplicity m = new MultiplicityImpl();
			m.setLower(1);
			m.setUpper(upper);
			((GroupCardinality) f).setMultiplicity(m);
			
			//Change father
			f.setParent(fParent);
			fParent.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			childrenF =  f.getChildren();
			
			//Change Children
			for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
			{
				Feature feature = it.next();
				it.remove();
				feature.setParent(f);
				childrenF.add(feature);
			}
			
			//Add the feature to the fm
			fm.getFeatures().add(fParent);
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		
		return true;
	}
}
