package rhea.evaluation.refactoringJava;

import java.util.List;

import rhea.evaluation.refactorings.TransformationInformation;
import rhea.metamodels.BasicFMs.FeatureModel;

public abstract class JavaRefactoring {

	protected FeatureModel fm;
	protected String classPath;
	
	public JavaRefactoring(FeatureModel featureModel) {
		fm = featureModel;
	}
	
	public abstract List<TransformationInformation> testRefactoring(int times);
}
