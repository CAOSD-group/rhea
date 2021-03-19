package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.interpreter.impl.LoggingApplicationMonitor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.neominik.uvl.printer__init;
import rhea.Rhea;
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
import rhea.transformations.engine.MyLoggingApplicationMonitor;
import rhea.transformations.refactorings.GroupCardinalities;


@RunWith(Suite.class)
@SuiteClasses({})
public class RefactoringsTests {
	public static final String BASEDIR = "E:/Workspaces/RHEA-ws/rhea/";
	public static final String BASEDIR_METAMODELS = Rhea.BASEDIR + "rhea.metamodels/metamodels/";
	public static final String BASEDIR_TRANSFORMATIONS = Rhea.BASEDIR + "rhea.transformations/refactorings/";
	public static final String BASEDIR_INPUT_MODELS_CLAFER = Rhea.BASEDIR + "rhea.evaluation/inputs/clafer/";
	public static final String BASEDIR_OUTPUT_MODELS_CLAFER = Rhea.BASEDIR + "rhea.evaluation/outputs/clafer/";
	public static final String BASEDIR_INPUT_MODELS_AS = Rhea.BASEDIR + "rhea.evaluation/inputs/AS/";
	public static final String BASEDIR_OUTPUT_MODELS_AS = Rhea.BASEDIR + "rhea.evaluation/outputs/AS/";
	
	public static final List<String> dynamicMetamodels = List.of(BASEDIR_METAMODELS + "BasicFMs/BasicFMs.ecore",
			 													 BASEDIR_METAMODELS + "CardinalityBasedFMs/CardinalityBasedFMs.ecore");
	public static final List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE);
	
	@ParameterizedTest
	@ValueSource(strings = {"Model.txt"})
	//@ValueSource(strings = {"gc001.txt", "gc001a.txt", "gc001a2.txt", "gc001b.txt", "gc001b2.txt", "gc001b3.txt", "gc001c.txt", "gc001d.txt", "gc001e.txt", "gc001f.txt", "gc001g.txt"})
	void groupCardinalitiesXOR(String filepath) {
		String inputFile = BASEDIR_INPUT_MODELS_CLAFER + "GroupCardinalities/" + filepath;
		String transformationFilepath = BASEDIR_TRANSFORMATIONS + "GroupCardinalities11.henshin";
		String ruleName = "AllGroupCardinality11";
		
		System.out.println("Parsing Clafer feature model " + inputFile);
		FMParser p = new ClaferParser();
		
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		int nExpectedRefactors = GroupCardinalities.getGroupsCardinalities(fm).stream().filter(gc -> gc.getMultiplicity().getLower() == 1 && gc.getMultiplicity().getUpper() == 1).collect(Collectors.toList()).size();

		// Calculate expected configurations
		//AutomatedAnalysisFM aafm = new AAFMClafer();
		//var expectedConfigs = aafm.configurations(fm);
				
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
				
		LoggingApplicationMonitor monitor = new MyLoggingApplicationMonitor();
		
		try {monitor.setLogStream(new PrintStream(new File(BASEDIR_OUTPUT_MODELS_CLAFER + this.getClass().toString()  + "-log.txt")));} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		System.out.println(BASEDIR_INPUT_MODELS_AS + fm.getName() + ".xmi");
		
		// Execute the transformation
		EObject model = henshin.executeTransformation(transformationFilepath, ruleName,  Map.of(), BASEDIR_INPUT_MODELS_AS + fm.getName() + ".xmi", monitor);
		FeatureModel fmD = (FeatureModel) model;
		System.out.println("Feature model transformed: " + fmD.getName());
		
		// Serialize the abstract syntax
		henshin.saveModel(model, BASEDIR_OUTPUT_MODELS_AS +  fm.getName() + ".xmi");
		
		// Load again the abstract syntax
		FeatureModel fm2 = (FeatureModel) EMFIO.loadModel(staticMetamodels, BASEDIR_OUTPUT_MODELS_AS + fm.getName() + ".xmi");
		
		int refactorsDone = nExpectedRefactors - GroupCardinalities.getGroupsCardinalities(fm2).stream().filter(gc -> gc.getMultiplicity().getLower() == 1 && gc.getMultiplicity().getUpper() == 1).collect(Collectors.toList()).size();
		
		// Serialize the model in Clafer
		FMGenerator g = new ToClafer();
		String contents = g.fm2text(fm2);
		Utils.serialize(contents, BASEDIR_OUTPUT_MODELS_CLAFER + fm2.getName() + ".txt");
		
		//aafm = new AAFMClafer();
		//var configs = aafm.configurations(fm2);
		
		
		//System.out.println("FM configs: " + configs.size() + " -> " + configs);
		//System.out.println("FM configs (expected): " + expectedConfigs.size() + " -> " + expectedConfigs);
		
		//assertEquals(configs, expectedConfigs);
		assertEquals(nExpectedRefactors, refactorsDone);
	}
	
}
