package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.helpers.EMFIO;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;


@RunWith(Suite.class)
@SuiteClasses({})
public class RefactoringsTests {
	public static final String BASEDIR = "E:/Workspaces/RHEA-ws/rhea/";
	public static final String BASEDIR_METAMODELS = BASEDIR + "rhea.metamodels/metamodels/";
	public static final String BASEDIR_TRANSFORMATIONS = BASEDIR + "rhea.transformations/refactorings/";
	public static final String BASEDIR_INPUT_MODELS_CLAFER = BASEDIR + "rhea.evaluation/inputs/clafer/";
	public static final String BASEDIR_OUTPUT_MODELS_CLAFER = BASEDIR + "rhea.evaluation/outputs/clafer/";
	public static final String BASEDIR_INPUT_MODELS_AS = BASEDIR + "rhea.evaluation/inputs/AS/";
	public static final String BASEDIR_OUTPUT_MODELS_AS = BASEDIR + "rhea.evaluation/outputs/AS/";
	
	public static final List<String> dynamicMetamodels = List.of(BASEDIR_METAMODELS + "BasicFMs/BasicFMs.ecore",
			 													 BASEDIR_METAMODELS + "CardinalityBasedFMs/CardinalityBasedFMs.ecore");
	public static final List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE);
	
	@ParameterizedTest
	@ValueSource(strings = {"FM-TelematicsSystem.txt", "casoBase0-1.txt"})
	void groupCardinalitiesXOR(String filepath) {
		String inputFile = BASEDIR_INPUT_MODELS_CLAFER + filepath;
		String transformationFilepath = BASEDIR_TRANSFORMATIONS + "GroupCardinalities.henshin";
		String ruleName = "GroupCardinality_XOR";
		
		System.out.println("Parsing Clafer feature model " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		// Serialize the abstract syntax
		try {
			EMFIO.saveModel(fm, staticMetamodels, BASEDIR_INPUT_MODELS_AS + fm.getName() + ".xmi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Calculate expected configurations
		AutomatedAnalysisFM aafm = new AAFMClafer();
		var expectedConfigs = aafm.configurations(fm);
				
		// Do the transformation
		HenshinEngine henshin = new HenshinEngine(BASEDIR);
		/*
		for (String metamodelPath : dynamicMetamodels) {
			System.out.println("mm: " + metamodelPath);
			henshin.registerDynamicMetamodel(metamodelPath);	
		}
		*/
		for (EPackage mm : staticMetamodels) {
			henshin.registerStaticMetamodel(mm);	
		}
		// Load the model
		//EObject model = henshin.loadModel(BASEDIR_INPUT_MODELS_AS + fm.getName() + ".xmi");
				
		// Execute the transformation
		EObject model = henshin.executeTransformation(transformationFilepath, ruleName,  Map.of(), BASEDIR_INPUT_MODELS_AS + fm.getName() + ".xmi");
		FeatureModel fmD = (FeatureModel) model;
		System.out.println("Feature model transformed: " + fmD.getName());
		
		// Serialize the abstract syntax
		henshin.saveModel(model, BASEDIR_OUTPUT_MODELS_AS +  fm.getName() + ".xmi");
		
		// Load again the abstract syntax
		FeatureModel fm2 = (FeatureModel) EMFIO.loadModel(staticMetamodels, BASEDIR_OUTPUT_MODELS_AS + fm.getName() + ".xmi");
		
		// Serialize the model in Clafer
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm2);
		Utils.serialize(contents, BASEDIR_OUTPUT_MODELS_CLAFER + fm2.getName() + ".txt");
		
		aafm = new AAFMClafer();
		var configs = aafm.configurations(fm2);
		
		
		System.out.println("FM configs: " + configs.size() + " -> " + configs);
		System.out.println("FM configs (expected): " + expectedConfigs.size() + " -> " + expectedConfigs);
		
		assertEquals(configs, expectedConfigs);
	}
	
}
