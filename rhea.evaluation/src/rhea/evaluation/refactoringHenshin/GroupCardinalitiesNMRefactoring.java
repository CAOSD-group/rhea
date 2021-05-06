package rhea.evaluation.refactoringHenshin;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Module;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.henshin.HenshinUtils;
import rhea.transformations.refactoringHenshin.GroupCardinalities;

public class GroupCardinalitiesNMRefactoring extends HenshingRefactoring{

	FeatureModel fm;
	
	public GroupCardinalitiesNMRefactoring(Boolean debugMode) {
		super(debugMode);
	}

	public List<HenshinTransformation> getTransformations() {
		ArrayList<HenshinTransformation> hs = new ArrayList<>();
		for ( Feature f : FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality")) {
			hs.add(new HenshinTransformation("generated/GroupCardinalitiesNM-"+f.getId(), "GroupCardinalitiesNM"));
		}
		return hs;
	}
	
	public void generateTemplates() {
		Module module = null;
		String transformationFilepath = Rhea.REFACTORINGS_DIR + "GroupCardinalitiesNM.henshin";
		List<GroupCardinality> gcs = GroupCardinalities.getGroupsCardinalities(fm);
		
		for (HenshinTransformation hs : getTransformations()) {
			try {
				for (GroupCardinality gc : gcs) {
					module = GroupCardinalities.completeModuleForGC(transformationFilepath, gc);
					HenshinUtils.serializeModule(module, Rhea.REFACTORINGS_DIR + "/generated");	// hay que arreglar esto para que no lo genere una carpeta.
					System.out.println("Template Completed!!");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteTemplates() {
		String modulesGeneratedPath = Rhea.REFACTORINGS_DIR + "/generated";
		File generatedDir = new File(modulesGeneratedPath);
		
		for (File f : generatedDir.listFiles()) 
		{
			f.delete();
		}
		
	}
	
	public void setFeatureModel(FeatureModel fm) {
		this.fm = fm;
	}
}