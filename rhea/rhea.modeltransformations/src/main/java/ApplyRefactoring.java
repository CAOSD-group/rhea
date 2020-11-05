import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import uma.caosd.rhea.henshin.HenshinEngine;
import uma.caosd.rhea.metamodels.BasicFMs.BasicFMsPackage;
import uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;

public class ApplyRefactoring {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<String> dynamicMetamodels = List.of("D:\\Workspaces\\RHEA-ws\\rhea\\rhea\\rhea.metamodels\\src\\main\\resources\\metamodels\\BasicFMs\\BasicFMs.ecore",
												 "D:\\Workspaces\\RHEA-ws\\rhea\\rhea\\rhea.metamodels\\src\\main\\resources\\metamodels\\CardinalityBasedFMs\\CardinalityBasedFMs.ecore");
		
		List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE);
		
		HenshinEngine henshin = new HenshinEngine("D:\\Workspaces\\RHEA-ws\\rhea\\rhe\\");
		
		// Load and register the metamodels
		for (String mm : dynamicMetamodels) {
			henshin.registerMetamodel(mm);
		}
		
		// Load the model
		EObject fm = henshin.loadModel("D:\\Workspaces\\RHEA-ws\\rhea\\rhea\\rhea.modeltransformations\\src\\test\\resources\\input-models\\GroupCardinalities\\test0.xmi");
		//**********************************************//
		
		Module module = henshin.getModule("D:\\Workspaces\\RHEA-ws\\rhea\\rhea\\rhea.modeltransformations\\src\\main\\resources\\refactorings\\GroupCardinalities.henshin");
		Unit unit = module.getUnit("GroupCardinalities");
		henshin.executeTransformation(unit, Map.of(), fm);
		System.out.println("Transformation done!");
		henshin.saveModel(fm, "D:\\Workspaces\\RHEA-ws\\rhea\\rhea\\rhea.modeltransformations\\src\\test\\resources\\input-models\\GroupCardinalities\\test0-transformed.xmi");
		System.out.println("All done!");
	}
}
