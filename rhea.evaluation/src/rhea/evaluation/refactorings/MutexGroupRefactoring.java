package rhea.evaluation.refactorings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rhea.metamodels.BasicFMs.FeatureModel;

public class MutexGroupRefactoring extends HenshingRefactoring{

	public MutexGroupRefactoring(FeatureModel fm) {
		super(fm);
	}

	@Override
	public List<HenshinTransformation> getTransformations() {
		return new ArrayList<HenshinTransformation>(Arrays.asList(new HenshinTransformation("MutexGroup", "MutexGroup_Refactoring")));
	}
}
