package rhea.transformations.refactoringJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import rhea.metamodels.BasicFMs.AlternativeGroup;
import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.impl.AlternativeGroupImpl;
import rhea.metamodels.BasicFMs.impl.FeatureImpl;
import rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm;
import rhea.metamodels.ComparativeCTCs.Equal;
import rhea.metamodels.ComparativeCTCs.Less;
import rhea.metamodels.ComparativeCTCs.LessOrEqual;
import rhea.metamodels.ComparativeCTCs.More;
import rhea.metamodels.ComparativeCTCs.MoreOrEqual;
import rhea.metamodels.ComparativeCTCs.NotEqual;
import rhea.metamodels.ComparativeCTCs.NumericTerm;
import rhea.metamodels.DataTypes.PrimitiveType;
import rhea.metamodels.DataTypes.PrimitiveTypeEnum;
import rhea.metamodels.NumericalFMs.NumericalFeature;
import rhea.metamodels.PropLogicCTCs.*;
import rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl;

public class JavaNumericalFeature extends JavaRule {
	Set<Set<Number>> intervals = new HashSet<>();
	List<Term> complexConstraints = new ArrayList<>();
	NumericalFeature nf;
	PrimitiveType dt;
	private boolean remove = false;
	
	private final int MAX_STEPS = 32;
	
	public JavaNumericalFeature(FeatureModel fm, String cp) {
		super(fm, cp);
	}

	@Override
	protected boolean applyRule(String id) 
	{
		//Obtain the feature
		nf = (NumericalFeature) fm.getFeature(id);
		dt = (PrimitiveType) nf.getType();
		//Object value = nf.getValue();
		
		//Search for constraints
		List<CrossTreeConstraint> ctc = fm.getCrosstreeconstraints();
		Iterator<CrossTreeConstraint> itr = ctc.iterator();
		
		while(itr.hasNext()) {
			obtainConstraints(((AdvancedConstraint) itr.next()).getExpr());
			if(remove) itr.remove();
			remove = false;
		}
		
		// Create the feature that contains the values
		AlternativeGroup container = new AlternativeGroupImpl();
		container.setName(nf.getName());
		
		// Create a feature for each value
		for (Number value : getPossibleValues()) 
		{
			Feature f = new FeatureImpl();
			f.setName(nf.getName()+":("+value.toString()+")");
			container.getChildren().add(f);
		}
		
		// Add the new child to the Numerical Feature
		nf.getParent().getChildren().add(container);
		nf.getParent().getChildren().remove(nf);
		
		//Change restrictions
		transformRestrictions();
		
		return true;
	}

	private Set<Number> getPossibleValues() {
		Set<Number> values = new HashSet<>();
		boolean first = true;
		
	      for (Set<Number> set : intervals) {
	          if (first) 
	          {
	              values.addAll(set);
	              first = false;
	          } 
	          else values.retainAll(set);
	      }
	      return values;
	}

	private void obtainConstraints(Term p) 
	{
		BinaryComparativeTerm t;
		
		if(p instanceof BinaryComparativeTerm)
		{
			t = (BinaryComparativeTerm) p;
			
			if (t.getLeft() instanceof FeatureTerm && ((FeatureTerm) t.getLeft()).getFeature().equals(nf) ||
				t.getRight() instanceof FeatureTerm && ((FeatureTerm) t.getRight()).getFeature().equals(nf))
			{
				generateGaps(t);
				remove = true;
			}
		}
		else if (p instanceof Implies) 
		{
			if(((Implies) p).getLeft() instanceof BinaryComparativeTerm) complexConstraints.add(((Implies) p).getLeft()); 
			else if (((Implies) p).getRight() instanceof BinaryComparativeTerm) complexConstraints.add(((Implies) p).getRight());
			else
			{
				obtainConstraints(((Implies) p).getLeft());
				obtainConstraints(((Implies) p).getRight());
			}
		}
		else if (p instanceof Excludes) 
		{
			if(((Implies) p).getLeft() instanceof BinaryComparativeTerm) complexConstraints.add(((Implies) p).getLeft()); 
			else if (((Implies) p).getRight() instanceof BinaryComparativeTerm) complexConstraints.add(((Implies) p).getRight());
			else
			{
				obtainConstraints(((Excludes) p).getLeft());
				obtainConstraints(((Excludes) p).getRight());
			}
		}
		else if (p instanceof And) 
		{
			for (Term equivTerm : ((And) p).getTerms()) {
				obtainConstraints(equivTerm);
			}
		}
		else if (p instanceof Or) 
		{
			for (Term equivTerm : ((Or) p).getTerms()) {
				obtainConstraints(equivTerm);
			}
		}
		else if (p instanceof Xor) 
		{
			for (Term equivTerm : ((Xor) p).getTerms()) {
				obtainConstraints(equivTerm);
			}
		}
		else if (p instanceof Equiv) 
		{
			for (Term equivTerm : ((Equiv) p).getTerms()) {
				obtainConstraints(equivTerm);
			}
		}
	}	

	private void generateGaps(BinaryComparativeTerm t) {
		if(dt.getType().equals(PrimitiveTypeEnum.INTEGER)) generateGapForInteger(t);
		if(dt.getType().equals(PrimitiveTypeEnum.NATURAL)) generateGapForNatural(t);
		if(dt.getType().equals(PrimitiveTypeEnum.REAL)) generateGapForReal(t);
	}

	private void generateGapForReal(BinaryComparativeTerm t) {
		float value;
		Set<Number> interval = new HashSet<>();
		
		if (t.getLeft() instanceof FeatureTerm)
		{
			value = (int) ((NumericTerm) t.getRight()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (float i = value-Float.MIN_VALUE; i >= value - MAX_STEPS; i = i - value/MAX_STEPS)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (float i = value+Float.MIN_VALUE; i <= value + MAX_STEPS; i = i + value/MAX_STEPS)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (float i = value; i >= value - MAX_STEPS; i = i - value/MAX_STEPS)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (float i = value; i <= value + MAX_STEPS; i = i + value/MAX_STEPS)
				{
					interval.add(i);
				}
			}
		}
		else
		{
			value = (int) ((NumericTerm) t.getLeft()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (float i = value+Float.MIN_VALUE; i <= value + MAX_STEPS; i = i + value/MAX_STEPS)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (float i = value-Float.MIN_VALUE; i >= value - MAX_STEPS; i = i - value/MAX_STEPS)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (float i = value; i <= value + MAX_STEPS; i = i + value/MAX_STEPS)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (float i = value; i >= value - MAX_STEPS; i = i - value/MAX_STEPS)
				{
					interval.add(i);
				}
			}
		}
		
		if(t instanceof NotEqual)
		{
			// !=
			for (float i = value+Float.MIN_VALUE; i <= value + MAX_STEPS/2; i = i + value/MAX_STEPS)
			{
				interval.add(i);
			}
			
			for (float i = value-Float.MIN_VALUE; i >= value - MAX_STEPS/2; i = i - value/MAX_STEPS)
			{
				interval.add(i);
			}

		}
		else if(t instanceof Equal)
		{
			// =
			interval.add(value);
		}
		
		intervals.add(interval);
		
	}

	private void generateGapForNatural(BinaryComparativeTerm t) {
		int value;
		Set<Number> interval = new HashSet<>();
		
		if (t.getLeft() instanceof FeatureTerm)
		{
			value = (int) ((NumericTerm) t.getRight()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (int i = value-1; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
					if(i<=1) break;
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value+1; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
					if(i<=1) break;
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}
			}
		}
		else
		{
			value = (int) ((NumericTerm) t.getLeft()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (int i = value+1; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value-1; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
					if(i<=1) break;
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
					if(i<=1) break;
				}
			}
		}
		
		if(t instanceof NotEqual)
		{
			// !=
			for (int i = value+1; i <= value + MAX_STEPS/2; i++)
			{
				interval.add(i);
			}
			
			for (int i = value-1; i >= value - MAX_STEPS/2; i--)
			{
				interval.add(i);
				if(i<=1) break;
			}

		}
		else if(t instanceof Equal)
		{
			// =
			interval.add(value);
		}
		
		intervals.add(interval);
	}

	private void generateGapForInteger(BinaryComparativeTerm t) {
		int value;
		Set<Number> interval = new HashSet<>();
		
		if (t.getLeft() instanceof FeatureTerm)
		{
			value = (int) ((NumericTerm) t.getRight()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (int i = value-1; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value+1; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}
			}
		}
		else
		{
			value = (int) ((NumericTerm) t.getLeft()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (int i = value+1; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value-1; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i <= value + MAX_STEPS; i++)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i >= value - MAX_STEPS; i--)
				{
					interval.add(i);
				}
			}
		}
		
		if(t instanceof NotEqual)
		{
			// !=
			for (int i = value+1; i <= value + MAX_STEPS/2; i++)
			{
				interval.add(i);
			}
			
			for (int i = value-1; i >= value - MAX_STEPS/2; i--)
			{
				interval.add(i);
			}

		}
		else if(t instanceof Equal)
		{
			// =
			interval.add(value);
		}
		
		intervals.add(interval);
	}
	
	private void transformRestrictions() {
		BinaryComparativeTerm bct;
		FeatureTermImpl newTerm;
		
		for (Term t : complexConstraints) {
			bct = (BinaryComparativeTerm) t;
			newTerm = new FeatureTermImpl();
			
			if(bct.getLeft() instanceof FeatureTerm && ((FeatureTerm) bct.getLeft()).getFeature().equals(nf))
			{
				newTerm.setFeature(fm.getFeature(nf.getName()+"-"+((NumericTerm) bct.getRight()).getValue()));
			}
			else
			{
				newTerm.setFeature(fm.getFeature(nf.getName()+"-"+((NumericTerm) bct.getLeft()).getValue()));
			}
			
			t = newTerm;
		}
	}
}