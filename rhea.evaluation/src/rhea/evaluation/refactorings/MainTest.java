package rhea.evaluation.refactorings;

import java.util.ArrayList;
import java.util.List;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;

public class MainTest {
	
	List<TransformationInformation> tis;
	TransformationInformation ti;
	
	AutomatedAnalysisFM aafm;
	
	//String outputFileAS;
	String outputFile;
	
	public MainTest() {
		tis = new ArrayList<>();
		aafm = new AAFMClafer();
	}
	
	public List<TransformationInformation> run(String model, List<Refactoring> mds) {
		String inputFile = Rhea.EVALUATION_DIR + model + ".txt";
		outputFile = Rhea.EVALUATION_DIR + model + "-refactored.txt";
		//outputFileAS = Rhea.ABSTRACTSYNTAX_OUTPUTS_DIR + model + "-refactored.xmi";
	
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		try 
		{	
			for (Refactoring r : mds) {
				ti = new TransformationInformation();
				
				List<String> units = new ArrayList<>();
				
				for (HenshinTransformation ht : r.getTransformations()) {
					units.add(ht.getUnitName());
				}
				
				// Primero obtenemos los pasos.
				r.executeTransformation(fm);
				ti.setRulesExecuted(((HenshingRefactoring) r).getMonitor().getSteps());
				ti.setRulesSuccessExecuted(((HenshingRefactoring) r).getMonitor().getSuccessSteps());
				((HenshingRefactoring) r).setDebugMode(false);
				
				tis.add(ti);
				
				// Luego hacemos todas las execuciones para obtener los tiempos.
				for (int i = 0; i < Rhea.EVALUATION_ITERATIONS; i++) 
				{
					ti = new TransformationInformation();
					ti.setInputModel(model);
					ti.setHenshinModule(r.getClass().getName().substring(r.getClass().getName().lastIndexOf(".")+1));
					ti.setHenshinUnits(units);
					
					// Full Transformation Block
					preTransformation(fm);
					r.executeTransformation(fm);
					postTransformation(fm);
				}
			}
		
		} 
		catch (SecurityException e) {e.printStackTrace();}
		catch (IllegalArgumentException e) {e.printStackTrace();}
		
		return tis;
	}
	
	private void preTransformation(FeatureModel fm) {
		// Save information
		ti.setProductsBefore(aafm.products(fm));
		ti.setNumberOfFeaturesTypeBefore(FMHelper.getAllFeaturesOf(fm,"rhea.metamodels.CardinalityBasedFMs.MutexGroup").size());
		ti.setTimeBefore(System.nanoTime());
	}
	
	private void postTransformation(FeatureModel fm) {
		// Save information
		ti.setTimeAfter(System.nanoTime());
		ti.setProductsAfter(aafm.products(fm));
		ti.setNumberOfFeaturesTypeAfter(FMHelper.getAllFeaturesOf(fm,"rhea.metamodels.CardinalityBasedFMs.MutexGroup").size());
		ti.setnFeatures(fm.getFeatures().size());
	
		tis.add(ti);
		
		// Serialize the abstract syntax
		//henshin.saveModel(fm, outputFileAS);
		//EMFIO.saveModel(fm, Rhea.STATIC_METAMODELS, outputFileAS);
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(fm), outputFile);
	}
}
