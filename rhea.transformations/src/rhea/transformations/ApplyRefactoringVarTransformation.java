package rhea.transformations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.transformations.engine.HenshinEngine;

public class ApplyRefactoringVarTransformation {
	public static final String BASEDIR = "D:/Workspaces/RHEA-ws/rhea/";
	public static final String BASEDIR_METAMODELS = "rhea.metamodels/metamodels/";
	public static final String BASEDIR_TRANSFORMATIONS = BASEDIR + "rhea.transformations/refactorings/";
	public static final String BASEDIR_INPUT_MODELS = BASEDIR + "rhea.transformations/inputs/";
	
	
	public static void main(String[] args) {
		String inputFMName = "casoBase005.txt";
		
		List<String> dynamicMetamodels = List.of(BASEDIR_METAMODELS + "BasicFMs/BasicFMs.ecore",
												 BASEDIR_METAMODELS + "CardinalityBasedFMs/CardinalityBasedFMs.ecore");
		
		List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE);
		
		HenshinEngine henshin = new HenshinEngine(BASEDIR);
		
		// Load and register the metamodels
		for (EPackage mm : staticMetamodels) {
			henshin.registerStaticMetamodel(mm);
		}
		
//		Map<String, Boolean> configuration = Map.of("root", false, 
//													"parent", true);
		
		Map<String, Boolean> configuration = null;
		
		// Load the model
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(BASEDIR_INPUT_MODELS + inputFMName);
		
		//EObject fm = henshin.loadModel(BASEDIR_INPUT_MODELS + inputFMName + ".xmi");
		//**********************************************//
		
		Module module = henshin.getModule(BASEDIR_TRANSFORMATIONS + "GCvar.henshin");
		Unit unit = module.getUnit("GroupCardinality");
		//henshin.executeVariableTransformation(unit, Map.of(), configuration, fm);
		System.out.println("Transformation done!");
		henshin.saveModel(fm, BASEDIR_INPUT_MODELS + inputFMName + "-transformed.xmi");
		System.out.println("All done!");
	}
}
