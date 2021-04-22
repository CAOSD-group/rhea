package rhea.transformations.refactorings;

import java.util.Iterator;
import java.util.List;

import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.SelectionGroup;
import rhea.metamodels.BasicFMs.impl.SelectionGroupImpl;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.PropLogicCTCs.AdvancedConstraint;
import rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl;
import rhea.metamodels.PropLogicCTCs.impl.AndImpl;
import rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl;
import rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl;
import rhea.metamodels.PropLogicCTCs.impl.NotImpl;

public class GroupCardinalityRefactoring extends Refactoring{

	public GroupCardinalityRefactoring(FeatureModel fm, String cp) 
	{
		super(fm, cp);
	}

	@Override
	protected boolean applyRule(String id) 
	{
		//Obtain the feature
		GroupCardinality gc = (GroupCardinality) fm.getFeature(id);
		List<Feature> childrenGC = gc.getChildren();
		
		//Create the new feature/features
		SelectionGroup sg = new SelectionGroupImpl();
		List<Feature> childrenSG = sg.getChildren();
		sg.setName(gc.getName());
		sg.setId(gc.getId());
		sg.setMandatory(gc.isMandatory());
		sg.setAbstract(gc.isAbstract());
		
		//Change father
		sg.setParent(gc.getParent());
		gc.getParent().getChildren().remove(gc);
		
		//Change Children
		for (Iterator<Feature> it = childrenGC.iterator(); it.hasNext();) 
		{
			Feature feature = it.next();
			it.remove();
			feature.setParent(sg);
			childrenSG.add(feature);
		}
		
		//Create Constraints
		int lower = gc.getMultiplicity().getLower();
		int upper = gc.getMultiplicity().getUpper() == -1 ? sg.getChildren().size() : gc.getMultiplicity().getUpper();
		
		AndImpl root = new AndImpl();
		
		// Calculate the posible combinations
		for (int i = 0; i < Math.pow(childrenSG.size(),2) - 1; i++)
		{	
			String format = "%" + childrenSG.size() + "s";
			char [] comb = String.format(format, Integer.toBinaryString(i)).replace(' ','0').toCharArray();
			int numberOfElements = 0;
			
			for (int j = 0; j < comb.length ; j++)
			{
				if(Character.getNumericValue(comb[j]) == 1) numberOfElements++;
			}
			
			// If the combination match, we create the implies
			if(lower <= numberOfElements && numberOfElements <= upper && numberOfElements != childrenSG.size() && lower > 0)
			{
				// Create implies , left and right
				ImpliesImpl implies = new ImpliesImpl();
				AndImpl left = new AndImpl();
				AndImpl right = new AndImpl();
				
				// For each child, we decide to use (or not) not 
				for (int k = 0; k < comb.length; k++)
				{
					FeatureTermImpl feature = new FeatureTermImpl();
					feature.setFeature(childrenSG.get(k));
					
					if(Character.getNumericValue(comb[k])==0)
					{
						NotImpl not = new NotImpl();
						not.setTerm(feature);
						right.addTerm(not);
					}
					else left.addTerm(feature);
				}
				
				implies.setLeft(left);
				implies.setRight(right);
				
				root.addTerm(implies);
			}
		}
		
		//Add the constraint to the fm
		List<CrossTreeConstraint> ctc = fm.getCrosstreeconstraints();
		AdvancedConstraint ac = new AdvancedConstraintImpl();
		ac.setExpr(root);
		ctc.add(ac);
		
		//Delete the feature from fm
		fm.getFeatures().remove(gc);
		
		//Add the feature to the fm
		fm.getFeatures().add(sg);
		
		return true;
	}
}
