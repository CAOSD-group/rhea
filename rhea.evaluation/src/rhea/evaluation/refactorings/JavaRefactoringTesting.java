package rhea.evaluation.refactorings;

import java.util.List;

import rhea.metamodels.BasicFMs.FeatureModel;

public abstract class JavaRefactoringTesting {

	protected FeatureModel fm;
	protected String classPath;
	
	public JavaRefactoringTesting(FeatureModel featureModel) {
		fm = featureModel;
	}
	
	public abstract List<TransformationInformation> testRefactoring(int times);
}
