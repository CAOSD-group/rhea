package rhea.evaluation.refactorings;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.Module;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.henshin.HenshinUtils;
import rhea.transformations.refactorings.GroupCardinalities;

public class GroupCardinalitiesRefactoring extends HenshingRefactoring{
	
	public GroupCardinalitiesRefactoring(FeatureModel fm) {
		super(fm);
	}

	@Override
	public List<HenshinTransformation> getTransformations() {
		ArrayList<HenshinTransformation> hs = new ArrayList<HenshinTransformation>(Arrays.asList(new HenshinTransformation("GroupCardinalities", "GroupCardinalitiesRefactor")));
		for ( Feature f : FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality")) hs.add(new HenshinTransformation("GroupCardinalitiesNM-"+f.getId(), "GroupCardinalitiesNM"));
		return hs;
	}
	
	public void generateTemplates() {
		Module module = null;
		String transformationFilepath = Rhea.REFACTORINGS_DIR + "GroupCardinalitiesNM.henshin";
		List<GroupCardinality> gcs = GroupCardinalities.getGroupsCardinalities(fm);
		
		for (HenshinTransformation hs : getTransformations()) {
			try {
				module = GroupCardinalities.completeModuleForGC(transformationFilepath, gcs.get(0));
				HenshinUtils.serializeModule(module, Rhea.REFACTORINGS_DIR);	// hay que arreglar esto para que no lo genere una carpeta.
				System.out.println("Template Completed!!");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
