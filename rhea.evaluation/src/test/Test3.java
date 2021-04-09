package test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.transformations.refactorings.GroupCardinalityRefactoring;
import rhea.transformations.refactorings.MutexGroupRefactoring;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;


class Test3 {

	@BeforeAll
    public static void setup() {
		System.out.println("Clean up!");
        Utils.cleanDirectory(Rhea.OUTPUTS_DIR);
    }
	
	@ParameterizedTest
	@ValueSource(strings = {"fm"})
	void test(String inputModel) throws IOException {
		
		String modelType = "GroupCardinalities";
		String classPath = "rhea.metamodels.CardinalityBasedFMs.GroupCardinality";
		
		String inputFile = Rhea.INPUTS_DIR + "clafer/" + modelType + "/" + inputModel + ".txt";
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/" + modelType + "/" + inputModel + ".txt";
		String transformationFilepath = Rhea.REFACTORINGS_DIR + modelType + ".henshin";

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Load Model
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		AutomatedAnalysisFM aafm = new AAFMClafer();
		FMHelper fmh = new FMHelper();
		
		var gcBefore = FMHelper.getAllFeaturesOf(fm, classPath).size();
		
		// Execute the transformation
		GroupCardinalityRefactoring mgr = new GroupCardinalityRefactoring(fm, classPath);
		
		if (mgr.executeRefactoring())
			System.out.println("Transformation applied succesfully.");
		else 
			System.out.println("Transformation was not applied.");

		/********** END REFACTORING **********/

		var gcAfter = FMHelper.getAllFeaturesOf(fm, classPath).size();
		
		//Save Model
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm);
		Utils.serialize(contents, outputFile);
		
		assertTrue(gcAfter < gcBefore);
	}

}
