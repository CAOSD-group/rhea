package rhea.evaluation.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;

@RunWith(Suite.class)
@SuiteClasses({})
public class ClaferTests {
	private static final String INPUT_FILES = "inputs/";
	private static final String CLAFER_FILES = "clafer/";
	
	@ParameterizedTest
	@ValueSource(strings = {"FM-TelematicsSystem.txt", "casoBase0-1.txt"})
	void parseGeneratorForClafer(String filepath) {
		String inputFile = INPUT_FILES + CLAFER_FILES + filepath;
		
		System.out.println("Parsing Clafer feature model " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		AutomatedAnalysisFM aafm = new AAFMClafer();
		var configs = aafm.configurations(fm);
		var expectedConfigs = AAFMClafer.configurations(inputFile);
		
		
		System.out.println("FM configs: " + configs.size() + " -> " + configs);
		System.out.println("FM configs (expected): " + expectedConfigs.size() + " -> " + expectedConfigs);
		
		assertEquals(configs, expectedConfigs);
		
		/*
		try {
			// Serialize the abstract syntax
			EMFIO.saveModel(fm, List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE), "output/fm.xmi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		// Serialize the Clafer model
		/*
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm);
		Utils.serialize(contents, tempFile);
		*/
	}
	
}
