package rhea.evaluation.refactorings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.EMFIO;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;

public class MainTest {
	
	List<TransformationInformation> tis;
	TransformationInformation ti;
	
	AutomatedAnalysisFM aafm;
	HenshinEngine henshin;
	
	String outputFileAS;
	String outputFile;
	String inputFile;
	
	//Cambiar con cada run
	private String CLASS_PATH = "rhea.metamodels.CardinalityBasedFMs.GroupCardinality";
	//private String CLASS_PATH = "rhea.metamodels.CardinalityBasedFMs.MutexGroup";
	
	public MainTest() {
		tis = new ArrayList<>();
		aafm = new AAFMClafer();
		henshin = new HenshinEngine(Rhea.BASEDIR);
	}
	
	public List<TransformationInformation> run(String model, List<Refactoring> mds) {
		inputFile = Rhea.CLAFER_INPUTS_DIR + Rhea.REFACTOR_PATH + model + ".txt";
		outputFile = Rhea.CLAFER_OUTPUTS_DIR + Rhea.REFACTOR_PATH + model + "-refactored.txt";
		outputFileAS = Rhea.ABSTRACTSYNTAX_OUTPUTS_DIR + model + "-refactored.xmi";
		
		FMParser p = new ClaferParser();
		
		// fm es una variable auxiliar para almacenar el fm transformado, fmAux contiene el fm tal y como sale despues del anterior modulo.
		// Esto es necesario porque necesitamos reiniciar el modelo entre iteraciones, y poder almacenarlo de alguna manera. Adem�s,
		// necesitamos tambi�n una manera de reiniciar el modelo una vez hemos obtenido los n�meros de pasos.
		FeatureModel fmAux = p.readFeatureModel(inputFile);
		FeatureModel fm = EcoreUtil.copy(fmAux);
		
		try 
		{	
			// Para cada modulo
			for (Refactoring r : mds) {
				
				fmAux = EcoreUtil.copy(fm);
				ti = new TransformationInformation();
				Set<String> units = new HashSet<>();
				
				// Comprobaci�n solo necesaria para GroupCardinalitiesNM
				if (r instanceof GroupCardinalitiesNMRefactoring) {
					
					((GroupCardinalitiesNMRefactoring) r).setFeatureModel(fmAux);
					((GroupCardinalitiesNMRefactoring) r).generateTemplates();
				}
				
				for (HenshinTransformation ht : r.getTransformations()) units.add(ht.getUnitName());
				
				// Primero obtenemos los pasos.
				r.executeTransformation(fm);
				ti.setRun(-1);
				ti.setRulesExecuted(((HenshingRefactoring) r).getMonitor().getSteps());
				ti.setRulesSuccessExecuted(((HenshingRefactoring) r).getMonitor().getSuccessSteps());
				((HenshingRefactoring) r).setDebugMode(false);
				
				tis.add(ti);
				
				// Luego hacemos todas las execuciones para obtener los tiempos.
				for (int i = 0; i < Rhea.EVALUATION_ITERATIONS; i++) 
				{
					fm = EcoreUtil.copy(fmAux);
					
					ti = new TransformationInformation();
					ti.setRun(i);
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
		//ti.setProductsBefore(aafm.products(fm));
		ti.setNumberOfFeaturesTypeBefore(FMHelper.getAllFeaturesOf(fm,this.CLASS_PATH).size());
		ti.setnFeaturesBefore(fm.getFeatures().size());
		ti.setTimeBefore(System.nanoTime());
	}
	
	private void postTransformation(FeatureModel fm) {
		// Save information
		ti.setTimeAfter(System.nanoTime());
		//ti.setProductsAfter(aafm.products(fm));
		ti.setNumberOfFeaturesTypeAfter(FMHelper.getAllFeaturesOf(fm,this.CLASS_PATH).size());
		ti.setnFeaturesAfter(fm.getFeatures().size());
	
		tis.add(ti);
		
		// Serialize the abstract syntax
		/*henshin.saveModel(fm, outputFileAS);
		
		try {EMFIO.saveModel(fm, Rhea.STATIC_METAMODELS, outputFileAS);}
		catch (IOException e) {e.printStackTrace();}*/
		
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(fm), outputFile);
	}
}
