package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.refactoringJava.JavaGroupCardinalityBaseRule;
import rhea.transformations.refactoringJava.JavaGroupCardinalityRule;


class JavaRefactoringTest {

	@BeforeAll
    public static void setup() {
		System.out.println("Clean up!");
        Utils.cleanDirectory(Rhea.OUTPUTS_DIR);
    }
	
	@ParameterizedTest
	@ValueSource(strings = {"gc011"})
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
		var configsBefore = aafm.configurations(fm).size();
		var gcBefore = FMHelper.getAllFeaturesOf(fm, classPath).size();
		
		// Execute the transformation
		JavaGroupCardinalityBaseRule gcbr = new JavaGroupCardinalityBaseRule(fm, classPath);
		JavaGroupCardinalityRule gcr = new JavaGroupCardinalityRule(fm, classPath);
		
		if (gcbr.executeRefactoring() && gcr.executeRefactoring())
			System.out.println("Transformation applied succesfully.");
		else 
			System.out.println("Transformation was not applied.");

		/********** END REFACTORING **********/

		
		var gcAfter = FMHelper.getAllFeaturesOf(fm, classPath).size();
		var configsAfter = aafm.configurations(fm).size();
		
		//Save Model
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm);
		Utils.serialize(contents, outputFile);
		
		assertEquals(configsAfter, configsBefore);
		//assertTrue(gcAfter < gcBefore);
	}
}