package rhea.evaluation.refactorings;

import java.util.List;

import rhea.metamodels.BasicFMs.FeatureModel;

public interface Refactoring {
	public abstract List<HenshinTransformation> getTransformations();
	public abstract void executeTransformation(FeatureModel fm);
}
