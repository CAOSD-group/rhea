package rhea.transformations.refactoringHenshin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;

public class HenshinGroupCardinalityBaseRule extends HenshinRule{
	
	public HenshinGroupCardinalityBaseRule(FeatureModel fm) {
		super(fm);
	}

	@Override
	public List<HenshinTransformation> getTransformations() {
		ArrayList<HenshinTransformation> hs = new ArrayList<HenshinTransformation>(Arrays.asList(new HenshinTransformation("GroupCardinalities", "LoopGroupCardinalitiesRefactor")));
		return hs;
	}
}
