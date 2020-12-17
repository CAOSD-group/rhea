package rhea.evaluation.refactorings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
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
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.helpers.EMFIO;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;
import rhea.transformations.refactorings.GroupCardinalities;


@RunWith(Suite.class)
@SuiteClasses({})
public class GroupCardinalitiesTest {
	
	@BeforeAll
    public static void setup() {
		System.out.println("Clean up!");
        Utils.cleanDirectory(Rhea.OUTPUTS_DIR);
    }
	
	@ParameterizedTest
	//@ValueSource(strings = {"gc001", "gc002", "gc003", "gc004", "gc005", "gc006", "gc007", "gc008", "gc009", "gc010", "gc011", "gc012"})
	@ValueSource(strings = {"gc001"})
	public static String groupCardinalities(String inputModel) throws IOException {
		// Test parameters
		String inputFile = Rhea.INPUTS_DIR + "clafer/GroupCardinalities/" + inputModel + ".txt";
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/GroupCardinalities/" + inputModel + ".txt";
		//String inputFileAS = Rhea.ABSTRACTSYNTAX_INPUTS_DIR + inputModel + ".xmi";
		String outputFileAS = Rhea.ABSTRACTSYNTAX_OUTPUTS_DIR + "GroupCardinalities/" + inputModel + ".xmi";
		
		String transformationFilepath = Rhea.REFACTORINGS_DIR + "GroupCardinalities.henshin";
		String ruleName = "GroupCardinalitiesRefactor";
		
		// Load the feature model input
		System.out.println("Parsing Clafer feature model: " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
				
		System.out.println("FM: " + fm.getRoot());
		// Calculate expected configurations
		System.out.println("Calculating expected products...");
		AutomatedAnalysisFM aafm = new AAFMClafer();
		var expectedProducts = aafm.products(fm);
		
		System.out.print("Times begins!");
		var timeBefore = System.currentTimeMillis();
		
		var numberGroupCardinalitiesBefore = GroupCardinalities.getGroupsCardinalities(fm).size();
		System.out.println(numberGroupCardinalitiesBefore);
		
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
		
		var timeAfter = System.currentTimeMillis();
		System.out.println("Stop timer!");
	
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
		
		var numberGroupCardinalities = FMHelper.getAllFeaturesOf(fm, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality").size();
		
		System.out.println("FM number of group cardinalities remaining: " + numberGroupCardinalities);
		
		var performance = timeAfter-timeBefore;
		System.out.println("Performance: " + performance + " milliseconds." );
		
		assertEquals(expectedProductsIDs, productsIDs);
		assertEquals(0,numberGroupCardinalities);
		
		return "GroupCardinalities," + ruleName + "," + inputModel + "," + fm.getFeatures().size() + "," + numberGroupCardinalitiesBefore + "," + performance;
		}
}
