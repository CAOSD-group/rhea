package rhea.transformations;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.helpers.EMFIO;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.transformations.engine.HenshinEngine;

public class ApplyRefactoring {
	public static final String BASEDIR = "B:/Trabajo/Investigación/Proyectos/RHEA/rhea/";
	//public static final String BASEDIR = "D:/Workspaces/RHEA-ws/rhea/";
	public static final String BASEDIR_METAMODELS = "rhea.metamodels/metamodels/";
	public static final String BASEDIR_TRANSFORMATIONS = BASEDIR + "rhea.transformations/refactorings/";
	public static final String BASEDIR_INPUT_MODELS = BASEDIR + "rhea.transformations/inputs/";
	
	
	public static void main(String[] args) throws IOException {
		String inputFMName = "casoBase005";
		
		List<String> dynamicMetamodels = List.of(BASEDIR_METAMODELS + "BasicFMs/BasicFMs.ecore",
												 BASEDIR_METAMODELS + "CardinalityBasedFMs/CardinalityBasedFMs.ecore");
		
		List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE);
		
		HenshinEngine henshin = new HenshinEngine(BASEDIR);
		
		// Load and register the metamodels
		for (EPackage mm : staticMetamodels) {
			henshin.registerStaticMetamodel(mm);
		}
		
		// Load the model
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(BASEDIR_INPUT_MODELS + inputFMName + ".txt");
		
		//EMFIO.saveModel(fm, staticMetamodels, BASEDIR_INPUT_MODELS + inputFMName + ".xmi");
		//EObject model = henshin.loadModel(BASEDIR_INPUT_MODELS + inputFMName + ".xmi");
		//**********************************************//
		
		Module module = henshin.getModule(BASEDIR_TRANSFORMATIONS + "GroupCardinalities.henshin");
		Unit unit = module.getUnit("GroupCardinality_XOR");
		henshin.executeTransformation(unit, Map.of(), fm);
		System.out.println("Transformation done!");
		henshin.saveModel(fm, BASEDIR_INPUT_MODELS + inputFMName + "-transformed.xmi");
		System.out.println("All done!");
	}
}
