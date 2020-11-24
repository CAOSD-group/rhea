package rhea.evaluation.refactorings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Unit;
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
import rhea.metamodels.utils.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;


@RunWith(Suite.class)
@SuiteClasses({})
public class MutexGroupTest {
	
	@BeforeAll
    public static void setup() {
		System.out.println("Clean up!");
        Utils.cleanDirectory(Rhea.OUTPUTS_DIR);
    }
	
	@ParameterizedTest
	@ValueSource(strings = {"mutex001", "mutex002", "mutex003", "mutex004", "mutex005"})
	void mutexGroup(String inputModel) throws IOException {
		// Test parameters
		String inputFile = Rhea.CLAFER_INPUTS_DIR + inputModel + ".txt";
		String outputFile = Rhea.CLAFER_OUTPUTS_DIR + inputModel + ".txt";
		//String inputFileAS = Rhea.ABSTRACTSYNTAX_INPUTS_DIR + inputModel + ".xmi";
		String outputFileAS = Rhea.ABSTRACTSYNTAX_OUTPUTS_DIR + inputModel + ".xmi";
		
		String transformationFilepath = Rhea.REFACTORINGS_DIR + "MutexGroup.henshin";
		String ruleName = "MutexGroup_Refactoring";
		
		// Load the feature model input
		System.out.println("Parsing Clafer feature model: " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
				
		System.out.println("FM: " + fm.getRoot());
		// Calculate expected configurations
		System.out.println("Calculating expected products...");
		AutomatedAnalysisFM aafm = new AAFMClafer();
		var expectedProducts = aafm.products(fm);
				
		/********** REFACTORING **********/
		// Prepare the transformation
		System.out.println("Transforming model...");
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
		
		// Register metamodels
		for (EPackage mm : Rhea.STATIC_METAMODELS) {
			henshin.registerStaticMetamodel(mm);	
		}		
		
		Unit unit = henshin.getModule(transformationFilepath).getUnit(ruleName);
		
		// Execute the transformation
		boolean successTransformation = henshin.executeTransformation(unit,  Map.of(), fm);
		if (successTransformation)
			System.out.println("Transformation applied succesfully.");
		else 
			System.out.println("Transformation was not applied.");
		
		/********** END REFACTORING **********/
		
		// Serialize the abstract syntax
		System.out.println("Serialize abstract syntax of output model: " + outputFileAS);
		henshin.saveModel(fm, outputFileAS);
		
		// Load the model from the abstract syntax
		FeatureModel fm2 = (FeatureModel) EMFIO.loadModel(Rhea.STATIC_METAMODELS, outputFileAS);
		
		// Calculate new configurations
		System.out.println("Calculating new products...");
		aafm = new AAFMClafer();
		var products = aafm.products(fm2);
		
		// Serialize the model in Clafer
		System.out.println("Serializing the transformed feature model in Clafer: " + outputFile);
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm2);
		Utils.serialize(contents, outputFile);

		
		var expectedProductsIDs = FMHelper.configurationsToString(expectedProducts);
		var productsIDs = FMHelper.configurationsToString(products);
		
		System.out.println("FM configs (expected): " + expectedProductsIDs.size() + " -> " + expectedProductsIDs);
		System.out.println("FM configs: " + productsIDs.size() + " -> " + productsIDs);
		
		assertEquals(expectedProductsIDs, productsIDs);
	}
	
	
}
