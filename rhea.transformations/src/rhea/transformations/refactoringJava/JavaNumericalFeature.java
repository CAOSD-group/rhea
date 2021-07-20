package rhea.transformations.refactoringJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DataTypes.DataType;
import DataTypes.PrimitiveType;
import DataTypes.Value;
import NumericalFMs.NumericalFeature;
import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.impl.AlternativeGroupImpl;
import rhea.metamodels.BasicFMs.impl.FeatureImpl;

public class JavaNumericalFeature extends JavaRule {
	PrimitiveType dt;

	public JavaNumericalFeature(FeatureModel fm, String cp) {
		super(fm, cp);
	}

	@Override
	protected boolean applyRule(String id) 
	{
		//Obtain the feature
		NumericalFeature nf = (NumericalFeature) fm.getFeature(id);
		List<Feature> childrenNF = nf.getChildren();
		dt = (PrimitiveType) nf.getType();
		
		//Obtain the data
		List<String> names = null; // TODO
		
		//Search for constraints
		List<CrossTreeConstraint> ctc = fm.getCrosstreeconstraints();
		Map<String,List<Number>> ranges = new HashMap<String,List<Number>>();
		
		for (String name: names) ranges.put(name,obtainRange(ctc,name));
		
		for (String name: ranges.keySet())
		{
			List<Number> values = ranges.get(name);
			
			// Create the feature that contains the values
			Feature container = new AlternativeGroupImpl();
			container.setName(name);
			
			// Create a feature for each value
			for (Number value : values) 
			{
				Feature f = new FeatureImpl();
				f.setName(value.toString());
				container.getChildren().add(f);
			}
			
			// Add the new child to the Numerical Feature
			nf.getChildren().add(container);
		}
		
		return true;
	}

	private List<Number> obtainRange(List<CrossTreeConstraint> ctc, String name) 
	{
		List<Number> result = new ArrayList<Number>();
		
		for (CrossTreeConstraint crossTreeConstraint : ctc) {
			// TODO
			// Hallar los valores posibles
		}
		
		return result;
	}
}