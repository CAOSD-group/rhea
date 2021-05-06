package rhea.transformations.refactoringJava;

import java.util.Iterator;
import java.util.List;

import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.impl.AlternativeGroupImpl;
import rhea.metamodels.BasicFMs.impl.FeatureImpl;
import rhea.metamodels.BasicFMs.impl.SelectionGroupImpl;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;
import rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl;
import rhea.metamodels.CardinalityBasedFMs.impl.MultiplicityImpl;
import rhea.metamodels.PropLogicCTCs.AdvancedConstraint;
import rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl;
import rhea.metamodels.PropLogicCTCs.impl.AndImpl;
import rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl;
import rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl;

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
		
		//Select the base case
		if(lower==1 && upper==1)
		{
			//Create the feature
			f = createAlternativeGroup(gc);
			
			//Change father
			f.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			//Change Children
			changeChildren(f, childrenGC);
			
			//Add the feature to the fm
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if(lower==1 && upper==-1)
		{
			//Create the feature
			f = createSelectionGroup(gc);
			
			//Change father
			f.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			//Change Children
			changeChildren(f, childrenGC);
			
			//Add the feature to the fm
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==0 && upper==1)
		{
			//Create the parent feature
			fParent = createParent(gc);
			
			//Create the feature
			f = createAlternativeGroupP(gc);
			
			//Change father
			f.setParent(fParent);
			fParent.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			//Change Children
			changeChildren(f, childrenGC);
			
			//Add the feature to the fm
			fm.getFeatures().add(fParent);
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==0 && upper==-1)
		{
			//Create the parent feature
			fParent = createParent(gc);
			
			//Create the feature
			f = createSelectionGroupP(gc);
			
			//Change father
			f.setParent(fParent);
			fParent.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			//Change Children
			changeChildren(f, childrenGC);
			
			//Add the feature to the fm
			fm.getFeatures().add(fParent);
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==0)
		{
			//Create the parent feature
			fParent = createParent(gc);
			
			//Create the feature
			f = createGroupCardinalityP(gc, 1, upper);
			
			//Change father
			f.setParent(fParent);
			fParent.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			//Change Children
			changeChildren(f, childrenGC);
			
			//Add the feature to the fm
			fm.getFeatures().add(fParent);
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
		}
		else if (lower==upper && lower==childrenGC.size())
		{
			//Create the feature
			f = createSelectionGroup(gc);
			
			//Change father
			f.setParent(gc.getParent());
			gc.getParent().getChildren().remove(gc);
			
			//Change Children
			changeChildren(f, childrenGC);
			
			// Create implies , left and right
			AndImpl root = new AndImpl();
			ImpliesImpl implies = new ImpliesImpl();
			FeatureTermImpl left = new FeatureTermImpl();
			AndImpl right = new AndImpl();
			
			FeatureTermImpl ft;
			
			for (Feature feature : f.getChildren()) 
			{
				ft = new FeatureTermImpl();
				ft.setFeature(feature);
				right.addTerm(ft);
			}
			
			left.setFeature(f);
			implies.setLeft(left);
			implies.setRight(right);
			
			root.addTerm(implies);
			
			//Add the feature to the fm
			fm.getFeatures().add(f);
			
			//Delete the feature from fm
			fm.getFeatures().remove(gc);
			
			//Add the constraint to the fm
			List<CrossTreeConstraint> ctc = fm.getCrosstreeconstraints();
			AdvancedConstraint ac = new AdvancedConstraintImpl();
			ac.setExpr(root);
			ctc.add(ac);
		}
		
		return true;
	}
	
	private AlternativeGroupImpl createAlternativeGroup(Feature gc)
	{
		AlternativeGroupImpl f = new AlternativeGroupImpl();
		f.setName(gc.getName());
		f.setId(gc.getId());
		f.setMandatory(gc.isMandatory());
		f.setAbstract(gc.isAbstract());
		return f;
	}
	
	private AlternativeGroupImpl createAlternativeGroupP(Feature gc)
	{
		AlternativeGroupImpl f = new AlternativeGroupImpl();
		f.setName(gc.getName()+"P");
		f.setId(gc.getId()+"P");
		f.setMandatory(gc.isMandatory());
		f.setAbstract(gc.isAbstract());
		return f;
	}
	
	private SelectionGroupImpl createSelectionGroup(Feature gc)
	{
		SelectionGroupImpl f = new SelectionGroupImpl();
		f.setName(gc.getName());
		f.setId(gc.getId());
		f.setMandatory(gc.isMandatory());
		f.setAbstract(gc.isAbstract());
		return f;
	}
	
	private SelectionGroupImpl createSelectionGroupP(Feature gc)
	{
		SelectionGroupImpl f = new SelectionGroupImpl();
		f.setName(gc.getName()+"P");
		f.setId(gc.getId()+"P");
		f.setMandatory(gc.isMandatory());
		f.setAbstract(gc.isAbstract());
		return f;
	}
	
	private Feature createParent(Feature gc)
	{
		Feature fParent = new FeatureImpl();
		fParent.setName(gc.getName());
		fParent.setId(gc.getId());
		fParent.setMandatory(gc.isMandatory());
		fParent.setAbstract(gc.isAbstract());
		return fParent;
	}
	
	private GroupCardinality createGroupCardinalityP(Feature gc, int lower, int upper)
	{
		//Create the feature
		GroupCardinalityImpl f = new GroupCardinalityImpl();
		f.setName(gc.getName()+"P");
		f.setId(gc.getId()+"P");
		f.setMandatory(false);
		f.setAbstract(true);
		
		//Create the multiplicity
		Multiplicity m = new MultiplicityImpl();
		m.setLower(lower);
		m.setUpper(upper);
		((GroupCardinality) f).setMultiplicity(m);
		
		return f;
	}
	
	private void changeChildren(Feature f, List<Feature> childrenGC)
	{
		List<Feature> childrenF =  f.getChildren();
		
		for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
		{
			Feature feature = it.next();
			it.remove();
			feature.setParent(f);
			childrenF.add(feature);
		}
	}
}
