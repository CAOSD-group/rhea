package rhea.transformations.refactoringHenshin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rhea.metamodels.BasicFMs.FeatureModel;

public class HenshinMutexGroupRule extends HenshinRule{

	public HenshinMutexGroupRule(FeatureModel fm) {
		super(fm);
	}

	@Override
	public List<HenshinTransformation> getTransformations() {
		return new ArrayList<HenshinTransformation>(Arrays.asList(new HenshinTransformation("MutexGroup", "MutexGroupRefactor")));
	}
}