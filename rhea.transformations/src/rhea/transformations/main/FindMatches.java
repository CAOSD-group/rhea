package rhea.transformations.main;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.BasicFMsPackage;

public class FindMatches {
	private static final String INPUTS_MODELS = "inputs/";
	
	public static void main(String[] args) {
		// Arguments
		String modelName = "myDynamicModel";
		
		String inputModel = INPUTS_MODELS + modelName + ".txt";
		String inputModelAS = INPUTS_MODELS + modelName + ".xmi";
		String outputModelTransformed = INPUTS_MODELS + modelName + "-transformed.xmi";
		String outputModelTransformed2 = INPUTS_MODELS + modelName + "-transformed2.xmi";
		
		String transformationFilepath = Rhea.LANGUAGEGENERATOR_DIR + "nondeterministic/" + "TransFeatureRandomly.henshin";		
		String ruleName = "TransFeatureToAlternativeGroupRandomly";
		
		
		// Get the Henshin engine
		HenshinResourceSet resourceSet = new HenshinResourceSet(Rhea.BASEDIR);
		//BasicFMsPackage.eINSTANCE.eClass();
		resourceSet.getPackageRegistry().put(BasicFMsPackage.eINSTANCE.getNsURI(), BasicFMsPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource model = resourceSet.getResource("rhea.transformations/" + inputModelAS);
		org.eclipse.emf.henshin.model.Module module = resourceSet.getModule(transformationFilepath, true);
		Engine engine = new EngineImpl();
		EGraph graph = new EGraphImpl(model);
		Unit unit = module.getUnit(ruleName);
		Match pMatch = new MatchImpl((Rule) unit);
		
		List<Match> matches = InterpreterUtil.findAllMatches(engine, (Rule) unit, graph, null);
		//Iterable<Match> matches = engine.findMatches((Rule) unit, graph, pMatch);
		System.out.println("Matches: " + matches.size());
		for (Match m: matches) {
			System.out.println("M: " + m);
			System.out.println("**********");
		}		
		
		System.out.println("Done!");
	}

}
