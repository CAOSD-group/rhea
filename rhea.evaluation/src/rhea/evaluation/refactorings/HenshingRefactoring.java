package rhea.evaluation.refactorings;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Unit;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.transformations.engine.HenshinEngine;

public abstract class HenshingRefactoring implements Refactoring{
		
	HenshinEngine henshin;
	FeatureModel fm;
	
	public HenshingRefactoring(FeatureModel fm) {
		henshin = new HenshinEngine(Rhea.BASEDIR);
		this.fm = fm;
		
		for (EPackage mm : Rhea.STATIC_METAMODELS) {
			henshin.registerStaticMetamodel(mm);	
		}		
	}

	@Override
	public void executeTransformation(FeatureModel fm, HenshinTransformation hs) {
		Unit unit = henshin.getModule(Rhea.REFACTORINGS_DIR + hs.getfileName() + ".henshin").getUnit(hs.getUnitName());
		
		if (henshin.executeTransformation(unit,  Map.of(), fm))
			System.out.println("Transformation applied succesfully.");
		else 
			System.out.println("Transformation was not applied.");
	}

}
