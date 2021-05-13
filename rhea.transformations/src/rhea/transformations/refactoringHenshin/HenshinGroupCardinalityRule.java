package rhea.transformations.refactoringHenshin;

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

public class HenshinGroupCardinalityRule extends HenshinRule{	
	public HenshinGroupCardinalityRule(FeatureModel fm) {
		super(fm);
		matchingFeatures = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality");
	}

	public List<HenshinTransformation> getTransformations() {
		ArrayList<HenshinTransformation> hs = new ArrayList<>();
		for ( Feature f : matchingFeatures) {
			hs.add(new HenshinTransformation("generated/GroupCardinalitiesNM-"+f.getId(), "GroupCardinalitiesNM"));
		}
		return hs;
	}
	
	public void generateTemplates() {
		Module module;
		String transformationFilepath = Rhea.REFACTORINGS_DIR + "GroupCardinalitiesNM.henshin";
		
		try 
		{
			for (Feature gc : matchingFeatures) 
			{
				module = GroupCardinalities.completeModuleForGC(transformationFilepath, ((GroupCardinality) gc));
				HenshinUtils.serializeModule(module, Rhea.REFACTORINGS_DIR + "/generated");
				System.out.println("Template Completed for " + gc.getName());
			}
		} 
		catch (ParseException e) {e.printStackTrace();};
	}
	
	public void deleteTemplates() {
		String modulesGeneratedPath = Rhea.REFACTORINGS_DIR + "/generated";
		File generatedDir = new File(modulesGeneratedPath);
		
		for (File f : generatedDir.listFiles()) 
		{
			f.delete();
		}
		
	}
}
