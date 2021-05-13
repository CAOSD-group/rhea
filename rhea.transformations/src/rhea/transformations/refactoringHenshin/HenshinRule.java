package rhea.transformations.refactoringHenshin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Unit;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.transformations.engine.HenshinEngine;
import rhea.transformations.engine.MyLoggingApplicationMonitor;

public abstract class HenshinRule{
	
	MyLoggingApplicationMonitor monitor;
	HenshinEngine henshin;
	Boolean debugMode = false;
	
	FeatureModel fm;
	
	List<Feature> matchingFeatures;
	
	public HenshinRule(FeatureModel fm) {
		this.fm = fm;
		henshin = new HenshinEngine(Rhea.BASEDIR);
		monitor = new MyLoggingApplicationMonitor();
		
		matchingFeatures = FMHelper.getAllFeaturesOf(this.fm, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality");
		
		for (EPackage mm : Rhea.STATIC_METAMODELS) {
			henshin.registerStaticMetamodel(mm);	
		}		
	}

	public boolean executeTransformation() {
		List<HenshinTransformation> transformations = getTransformations();
		Unit unit;
		
		for (HenshinTransformation hs : transformations) {
			unit = henshin.getModule(Rhea.REFACTORINGS_DIR + hs.getfileName() + ".henshin").getUnit(hs.getUnitName());
			
			if(debugMode) 
			{
					monitor = new MyLoggingApplicationMonitor();
					
					try {monitor.setLogStream(new PrintStream(new File(Rhea.OUTPUTS_DIR + this.getClass().toString()  + "-log.txt")));} 
					catch (FileNotFoundException e) {e.printStackTrace();}
				
					if (henshin.executeTransformation(unit,  Map.of(), fm, monitor)) System.out.println("Transformation applied succesfully.");
					else System.out.println("Transformation was not applied.");
			}
			else
			{
					if (henshin.executeTransformation(unit,  Map.of(), fm)) System.out.println("Transformation applied succesfully.");
					else System.out.println("Transformation was not applied.");
			}
		}
		
		return true;
	}
	
	public abstract List<HenshinTransformation> getTransformations();
	
	public MyLoggingApplicationMonitor getMonitor() {
		return monitor;
	}
	
	public void setDebugMode(Boolean debug) {
		this.debugMode = debug;
	}
	
	public void setFeatureModel(FeatureModel fm) {
		this.fm = fm;
	}
	
	public FeatureModel getFeatureModel() {
		return fm;
	}
	
	public List<Feature> getMatchingFeatures()
	{
		return matchingFeatures;
	}
	
}
