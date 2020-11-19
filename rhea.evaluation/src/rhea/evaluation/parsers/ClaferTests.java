package rhea.evaluation.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.utils.EMFIO;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;

@RunWith(Suite.class)
@SuiteClasses({})
public class ClaferTests {
	
	@BeforeAll
    public static void setup() {
		System.out.println("Clean up!");
        Utils.cleanDirectory(Rhea.OUTPUTS_DIR);
    }
	
	@ParameterizedTest
	@ValueSource(strings = {"mutex001", "casoBase005"})
	void parseGeneratorForClafer(String inputModel) {
		String inputFile = Rhea.CLAFER_INPUTS_DIR + inputModel + ".txt";
		String outputFile = Rhea.CLAFER_OUTPUTS_DIR + inputModel + ".txt";
		String outputFileAS = Rhea.ABSTRACTSYNTAX_OUTPUTS_DIR + inputModel + ".xmi";
		
		System.out.println("Parsing Clafer feature model " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		AutomatedAnalysisFM aafm = new AAFMClafer();
		var configs = aafm.configurations(fm);
		var expectedConfigs = AAFMClafer.configurations(inputFile);
		
		System.out.println("FM configs (expected): " + expectedConfigs.size() + " -> " + expectedConfigs);
		System.out.println("FM configs: " + configs.size() + " -> " + configs);
		
		assertEquals(expectedConfigs, configs);
		
		FeatureModel fm2 = null;
		try {
			// Serialize the abstract syntax
			EMFIO.saveModel(fm, Rhea.STATIC_METAMODELS, outputFileAS);
			fm2 = (FeatureModel) EMFIO.loadModel(Rhea.STATIC_METAMODELS, outputFileAS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// Serialize the Clafer model
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm2);
		Utils.serialize(contents, outputFile);
	}
	
}
