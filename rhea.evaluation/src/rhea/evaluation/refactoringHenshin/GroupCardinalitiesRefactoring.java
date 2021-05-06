package rhea.evaluation.refactoringHenshin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupCardinalitiesRefactoring extends HenshingRefactoring{
	
	public GroupCardinalitiesRefactoring(Boolean debugMode) {
		super(debugMode);
	}

	@Override
	public List<HenshinTransformation> getTransformations() {
		ArrayList<HenshinTransformation> hs = new ArrayList<HenshinTransformation>(Arrays.asList(new HenshinTransformation("GroupCardinalities", "GroupCardinalitiesRefactor")));
		return hs;
	}
}
