package rhea.transformations.main;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.EMFIO;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;

public class ApplyTransformation {
	private static final String INPUTS_MODELS = "inputs/";
	
	public static void main(String[] args) {
		// Arguments
		String modelName = "gc_ab";
		
		String inputModel = INPUTS_MODELS + modelName + ".txt";
		String inputModelAS = INPUTS_MODELS + modelName + ".xmi";
		String outputModelTransformed = INPUTS_MODELS + modelName + "-transformed.xmi";
		String outputModelTransformed2 = INPUTS_MODELS + modelName + "-transformed2.xmi";
		String outputModelTransformedClafer = INPUTS_MODELS + modelName + "-transformed.txt";
		
		//String transformationFilepath = Rhea.LANGUAGEGENERATOR_DIR + "nondeterministic/" + "GroupCardinalities.henshin";
		String transformationFilepath = Rhea.REFACTORINGS_DIR + "pruebas2.henshin";
		String ruleName = "Main";
		
		
		// Parse the input model
		System.out.println("Parsing Clafer feature model " + inputModel);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputModel);
		
		// Serialize the abstract syntax
		try {
			System.out.println("Serializing feature model " + inputModelAS);
			EMFIO.saveModel(fm, Rhea.STATIC_METAMODELS, inputModelAS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Get the Henshin engine
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
				
		// Register static metamodels in Henshin
		System.out.println("Registering metamodels in Henshin...");
		for (EPackage metamodel : Rhea.STATIC_METAMODELS) {
			henshin.registerStaticMetamodel(metamodel);
		}
		
		// Get the unit/rule to execute
		System.out.println("Loading Henshin module and unit/rule " + transformationFilepath + ". Rule: " + ruleName);
		Module module = henshin.getModule(transformationFilepath);
		Unit unit = module.getUnit(ruleName);
		
		// Provide the parameters to the transformation
		Map<String, Object> params = Map.of("k", 2);
				
		// Execute the transformation
		System.out.println("Executing the transformation...");
		boolean successTransformation = henshin.executeTransformation(unit, params, fm);
		//List<EObject> modelsTransformed = henshin.executeRuleForAllMatches(unit, params, fm);
		
		System.out.println("FM: " + fm.toString());
		
		//if (!modelsTransformed.isEmpty()) {
		if (successTransformation) {
			System.out.println("Transformation applied succesfully.");
		
			FMGenerator toClafer = new ToClafer();
			String fmClafer = toClafer.fm2text(fm);
			Utils.serialize(fmClafer, Rhea.BASEDIR + "rhea.transformations/" + outputModelTransformedClafer);
			
			
			// Serialize the transformed model
			System.out.println("Saving the transformed model in " + Rhea.BASEDIR + "rhea.transformations/" + outputModelTransformed + "...");
			henshin.saveModel(fm, Rhea.BASEDIR + "rhea.transformations/" + outputModelTransformed);
			try {
				EMFIO.saveModel(fm, Rhea.STATIC_METAMODELS, outputModelTransformed2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { 
			System.out.println("Transformation was not applied.");
		}
		
		System.out.println("Done!");
	}

}
