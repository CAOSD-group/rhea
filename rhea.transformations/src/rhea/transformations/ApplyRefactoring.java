package rhea.transformations;

import java.util.List;
import java.util.Map;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.transformations.engine.HenshinEngine;

public class ApplyRefactoring {
	public static final String BASEDIR = "D:/Workspaces/RHEA-ws/rhea/rhea/";
	public static final String BASEDIR_METAMODELS = BASEDIR + "rhea.metamodels/src/main/resources/metamodels/";
	public static final String BASEDIR_TRANSFORMATIONS = BASEDIR + "rhea.modeltransformations/src/main/resources/refactorings/";
	public static final String BASEDIR_INPUT_MODELS = BASEDIR + "rhea.modeltransformations/src/test/resources/input-models/";
	
	
	public static void main(String[] args) {
		String inputFMName = "test03";
		
		List<String> dynamicMetamodels = List.of(BASEDIR_METAMODELS + "BasicFMs/BasicFMs.ecore",
												 BASEDIR_METAMODELS + "CardinalityBasedFMs/CardinalityBasedFMs.ecore");
		
		List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE);
		
		HenshinEngine henshin = new HenshinEngine(BASEDIR);
		
		// Load and register the metamodels
		for (String mm : dynamicMetamodels) {
			henshin.registerMetamodel(mm);
		}
		
		// Load the model
		EObject fm = henshin.loadModel(BASEDIR_INPUT_MODELS + "GroupCardinalities/" + inputFMName + ".xmi");
		//**********************************************//
		
		Module module = henshin.getModule(BASEDIR_TRANSFORMATIONS + "GroupCardinalities.henshin");
		Unit unit = module.getUnit("GroupCardinalities");
		henshin.executeTransformation(unit, Map.of(), fm);
		System.out.println("Transformation done!");
		henshin.saveModel(fm, BASEDIR_INPUT_MODELS + "GroupCardinalities/" + inputFMName + "-transformed.xmi");
		System.out.println("All done!");
	}
}
