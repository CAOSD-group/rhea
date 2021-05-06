package rhea.evaluation.refactoringHenshin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MutexGroupRefactoringHenshin extends HenshingRefactoring{

	public MutexGroupRefactoringHenshin(Boolean debug) {
		super(debug);
	}

	@Override
	public List<HenshinTransformation> getTransformations() {
		return new ArrayList<HenshinTransformation>(Arrays.asList(new HenshinTransformation("MutexGroup", "MutexGroup_Refactoring")));
	}
}
