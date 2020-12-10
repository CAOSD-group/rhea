package rhea.transformations.refactorings;

import java.text.ParseException;
import java.util.List;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.transformations.henshin.HenshinUtils;

import org.eclipse.emf.henshin.model.Module;

public class CompleteHenshinTemplate {
	private static final String INPUTS_MODELS = "inputs/";
	
	public static void main(String[] args) throws ParseException {
		// Arguments
		String modelName = "gc_ab";		
		String inputModel = INPUTS_MODELS + modelName + ".txt";
		String templateFilePath = Rhea.REFACTORINGS_DIR + "pruebas2.henshin";
		String completedRefactoringFilePath = Rhea.REFACTORINGS_DIR + "templateGC-completed.henshin";
		
		// Parse the input model
		System.out.println("Parsing Clafer feature model " + inputModel);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputModel);
				
		List<GroupCardinality> gcs = GroupCardinalities.getGroupsCardinalities(fm);
		System.out.println("Group Cardinality: " + gcs.get(0) + " -> " + gcs.get(0).getMultiplicity());
		
		Module module = GroupCardinalities.completeModuleForGC(templateFilePath, gcs.get(0));
		HenshinUtils.serializeModule(module, completedRefactoringFilePath);

	}

}
