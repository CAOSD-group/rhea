package rhea.transformations.refactoringJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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

public class JavaNumericalFeatureRule extends JavaRule {
	Set<Set<Number>> intervals;
	List<Term> complexConstraints;
	NumericalFeature nf;
	PrimitiveType dt;
	private boolean remove = false;
	
	private final int MAX_STEPS = 32;
	private final int STEP_SIZE = 1;
	
	public JavaNumericalFeatureRule(FeatureModel fm, String cp) {
		super(fm, cp);
	}

	@Override
	protected boolean applyRule(String id) 
	{
		//Clean the values
		intervals = new HashSet<Set<Number>>();
		complexConstraints = new ArrayList<>();
		remove = false;
		
		//Obtain the feature
		nf = (NumericalFeature) fm.getFeature(id);
		dt = (PrimitiveType) nf.getType();
		
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
		container.setId(nf.getId());
		
		// Create a feature for each value
		for (Number value : getPossibleValues()) 
		{
			Float v;
			if(value instanceof Integer) v = value.floatValue();
			else v = (Float) value;
			Feature f = new FeatureImpl();
			f.setName(nf.getName()+":("+v.toString()+")");
			f.setId(f.getName());
			container.getChildren().add(f);
			fm.getFeatures().add(f);
		}
		
		// Add the new child to the Numerical Feature
		nf.getParent().getChildren().add(container);

		
		// Move children to the new father
		Iterator<Feature> itf = nf.getChildren().iterator();
		while(itf.hasNext())
		{
			Feature f = itf.next();
			itf.remove();
			container.getChildren().add(f);
		}
		
		// Remove the NF
		fm.getFeatures().remove(nf);
		nf.getParent().getChildren().remove(nf);
		
		transformRestrictions();
		
		return true;
	}

	private Set<Number> getPossibleValues() {
		SortedSet<Number> values = new TreeSet<>();
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
			if(((Implies) p).getLeft() instanceof BinaryComparativeTerm) complexConstraints.add(p);
			else if (((Implies) p).getRight() instanceof BinaryComparativeTerm) complexConstraints.add(p);
			else
			{
				obtainConstraints(((Implies) p).getLeft());
				obtainConstraints(((Implies) p).getRight());
			}
		}
		else if (p instanceof Excludes) 
		{
			if(((Excludes) p).getLeft() instanceof BinaryComparativeTerm) complexConstraints.add(p);
			else if (((Excludes) p).getRight() instanceof BinaryComparativeTerm) complexConstraints.add(p);
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
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					value = value - 0.5f;
					interval.add(value);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					value = value + 0.5f;
					interval.add(value);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=			
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					interval.add(value);
					value = value - 0.5f;
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					interval.add(value);
					value = value + 0.5f;
				}
			}
		}
		else
		{
			value = (int) ((NumericTerm) t.getLeft()).getValue();
			
			if(t instanceof Less)
			{
				// <
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					value = value + 0.5f;
					interval.add(value);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					value = value - 0.5f;
					interval.add(value);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=			
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					interval.add(value);
					value = value + 0.5f;
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = 0; i <= MAX_STEPS ; i = i + STEP_SIZE)
				{
					interval.add(value);
					value = value - 0.5f;
				}
			}
		}
		
		if(t instanceof NotEqual)
		{
			// !=
			for (float i = 0; i <= MAX_STEPS/2 ; i = i + STEP_SIZE)
			{
				value = value + 0.5f;
				interval.add(value);
			}
			
			for (float i = 0; i <= MAX_STEPS/2 ; i = i + STEP_SIZE)
			{
				value = value - 0.5f;
				interval.add(value);
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
				for (int i = value-1; i >= value - MAX_STEPS - 1; i = i - STEP_SIZE)
				{
					interval.add(i);
					if(i<=1) break;
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value+1; i <= value + MAX_STEPS + 1; i = i + STEP_SIZE)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i >= value - MAX_STEPS; i = i - STEP_SIZE)
				{
					interval.add(i);
					if(i<=1) break;
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i <= value + MAX_STEPS; i = i + STEP_SIZE)
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
				for (int i = value+1; i <= value + MAX_STEPS + 1; i = i + STEP_SIZE)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value-1; i >= value - MAX_STEPS - 1; i = i - STEP_SIZE)
				{
					interval.add(i);
					if(i<=1) break;
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i <= value + MAX_STEPS; i = i + STEP_SIZE)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i >= value - MAX_STEPS; i = i - STEP_SIZE)
				{
					interval.add(i);
					if(i<=1) break;
				}
			}
		}
		
		if(t instanceof NotEqual)
		{
			// !=
			for (int i = value+1; i <= value + MAX_STEPS/2; i = i + STEP_SIZE)
			{
				interval.add(i);
			}
			
			for (int i = value-1; i >= value - MAX_STEPS/2; i = i - STEP_SIZE)
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
				for (int i = value-1; i >= value - MAX_STEPS - 1; i = i - STEP_SIZE)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value+1; i <= value + MAX_STEPS + 1; i = i + STEP_SIZE)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i >= value - MAX_STEPS; i = i - STEP_SIZE)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i <= value + MAX_STEPS; i = i + STEP_SIZE)
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
				for (int i = value+1; i <= value + MAX_STEPS + 1; i = i + STEP_SIZE)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof More)
			{
				// >
				for (int i = value-1; i >= value - MAX_STEPS - 1; i = i - STEP_SIZE)
				{
					interval.add(i);
				}
				
			}
			else if(t instanceof LessOrEqual)
			{
				// <=
				for (int i = value; i <= value + MAX_STEPS; i = i + STEP_SIZE)
				{
					interval.add(i);
				}

			}
			else if(t instanceof MoreOrEqual)
			{
				// >=
				for (int i = value; i >= value - MAX_STEPS; i = i - STEP_SIZE)
				{
					interval.add(i);
				}
			}
		}
		
		if(t instanceof NotEqual)
		{
			// !=
			for (int i = value+1; i <= value + MAX_STEPS/2; i = i + STEP_SIZE)
			{
				interval.add(i);
			}
			
			for (int i = value-1; i >= value - MAX_STEPS/2; i = i - STEP_SIZE)
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
		FeatureTermImpl newTerm = null;
		Implies i;
		Excludes e;
		Equal eq;
		
		for(Term t : complexConstraints)
		{
			if(t instanceof Implies)
			{
				i = (Implies) t;
				
				if(i.getLeft() instanceof Equal)
				{
					eq = (Equal) i.getLeft();
					
					if(eq.getLeft() instanceof FeatureTerm && ((FeatureTerm) eq.getLeft()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getRight()).getValue()+")"));
					}
					else if(eq.getRight() instanceof FeatureTerm && ((FeatureTerm) eq.getRight()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getLeft()).getValue()+")"));
					}
					
					//Ponerlo como parte del hijo
					if(newTerm!=null && newTerm.getFeature()!=null) 
					{
						i.setLeft(newTerm);
					}
				}
				else if (i.getRight() instanceof Equal)
				{
					eq = (Equal) i.getRight();
					
					if(eq.getLeft() instanceof FeatureTerm && ((FeatureTerm) eq.getLeft()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getRight()).getValue()+")"));
					}
					else if(eq.getRight() instanceof FeatureTerm && ((FeatureTerm) eq.getRight()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getLeft()).getValue()+")"));
					}
					
					//Ponerlo como parte del hijo
					if(newTerm!=null && newTerm.getFeature()!=null) 
					{
						i.setRight(newTerm);
					}
				}
			}
			else if(t instanceof Excludes)
			{
				e = (Excludes) t;
				
				if(e.getLeft() instanceof Equal)
				{
					eq = (Equal) e.getLeft();
					
					if(eq.getLeft() instanceof FeatureTerm && ((FeatureTerm) eq.getLeft()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getRight()).getValue()+")"));
					}
					else if(eq.getRight() instanceof FeatureTerm && ((FeatureTerm) eq.getRight()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getLeft()).getValue()+")"));
					}	
					
					//Ponerlo como parte del hijo
					if(newTerm!=null && newTerm.getFeature()!=null) 
					{
						e.setLeft(newTerm);
					}
				}
				else if (e.getRight() instanceof Equal)
				{
					eq = (Equal) e.getLeft();
					
					if(eq.getLeft() instanceof FeatureTerm && ((FeatureTerm) eq.getLeft()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getRight()).getValue()+")"));
					}
					else if(eq.getRight() instanceof FeatureTerm && ((FeatureTerm) eq.getRight()).getFeature().equals(nf))
					{
						newTerm = new FeatureTermImpl();
						newTerm.setFeature(fm.getFeature(nf.getName()+":("+((NumericTerm) eq.getLeft()).getValue()+")"));
					}	
					
					//Ponerlo como parte del hijo
					if(newTerm!=null && newTerm.getFeature()!=null) 
					{
						e.setRight(newTerm);
					}
				}
			}
		}
	}
}