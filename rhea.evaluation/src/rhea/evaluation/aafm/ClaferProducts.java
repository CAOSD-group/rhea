package rhea.evaluation.aafm;

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
import rhea.metamodels.helpers.EMFIO;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;

@RunWith(Suite.class)
@SuiteClasses({})
public class ClaferProducts {
	
	@BeforeAll
    public static void setup() {
		System.out.println("Clean up!");
        Utils.cleanDirectory(Rhea.OUTPUTS_DIR);
    }
	
	@ParameterizedTest
	@ValueSource(strings = {"gc001", "gc002", "gc003", "gc004", "gc005"})
	void productsGenerationInClafer(String inputModel) {
		String inputFile = Rhea.CLAFER_INPUTS_DIR + "GroupCardinalities/" + inputModel + ".txt";
		
		System.out.println("Parsing Clafer feature model " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		AutomatedAnalysisFM aafm = new AAFMClafer();
		var products = aafm.products(fm);
		var productsIDs = FMHelper.configurationsToString(products);
		
		System.out.println("FM products: " + inputModel + " -> " + productsIDs.size() + " -> " + productsIDs);
	}
	
}
