package rhea.evaluation.refactorings;

import java.util.List;

import rhea.metamodels.BasicFMs.FeatureModel;

public abstract class Refactoring {
	protected FeatureModel fm;
	protected String classPath;
	
	public Refactoring(FeatureModel featureModel) {
		fm = featureModel;
	}
	
	public abstract List<TransformationInformation> refactor(int times, String output);
}
