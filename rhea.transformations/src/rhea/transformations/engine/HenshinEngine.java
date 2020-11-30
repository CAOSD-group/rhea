package rhea.transformations.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.PartitionedEGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.ParameterKind;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.variability.VarRuleApplicationImpl;

/**
 * Helper to register metamodels in Henshin, load/save model instances, and execute rules.
 * It uses static model instances and metamodels.
 * 
 * @author Jose Miguel Horcas
 *
 */
public class HenshinEngine {
	private HenshinResourceSet rs;
	private Engine engine;
	private int threads;
	
	public HenshinEngine(String basedir) {
		this.rs = new HenshinResourceSet(basedir);
		this.engine = new EngineImpl();
		
		// Determine number of threads to be used:
		this.threads = Math.max(Runtime.getRuntime().availableProcessors() / 2, 1);
		engine.getOptions().put(Engine.OPTION_WORKER_THREADS, threads);
		//engine.getOptions().put(Engine.OPTION_DESTROY_MATCHES, true);
	}
	
	/**
	 * Load and register a metamodel from its .ecore file (dynamic metamodel).
	 * 
	 * @param metamodelPath	Filepath of the metamodel
	 * @return				Metamodel as an EPackage instance.
	 */
	public EPackage registerDynamicMetamodel(String metamodelPath) {
		Resource res = rs.getResource(metamodelPath);
		EPackage metamodel = (EPackage) res.getContents().get(0);
		rs.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		EcoreUtil.resolveAll(rs);
		
		return metamodel;
	}
	
	/**
	 * Load and register a metamodel from its EPackage (static metamodel).
	 * 
	 * @param metamodel		EPackage of the metamodel.
	 */
	public void registerStaticMetamodel(EPackage metamodel) {
		rs.getPackageRegistry().put(metamodel.getNsURI(), metamodel);
		EcoreUtil.resolveAll(rs);
	}
	
	/**
	 * Load a model in the Henshin resource set from its filepath.
	 * 
	 * @param modelPath Filepath of the model.
	 * @return			Model instance as an EObject pointing to the root element.
	 */
	public EObject loadModel(String modelPath) {
		Resource res = rs.getResource(modelPath);
		/*try {
			res.load(rs.getLoadOptions());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		EObject modelRoot = res.getContents().get(0);
		EcoreUtil.resolveAll(rs);
		return modelRoot;
	}
	
	/**
	 * Save the model instance in the specified filepath.
	 * 
	 * @param model		Model instance.
	 * @param modelPath	Filepath.
	 */
	public void saveModel(EObject model, String modelPath) {
		Resource res = rs.createResource(modelPath);
		//res.getContents().addAll(model.eContents());
		res.getContents().add(model);
		//EcoreUtil.resolveAll(rs);
		
		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Module getModule(String modulePath) {
		System.out.println("Modulepath: " + modulePath);
		return rs.getModule(modulePath, true);
	}
	
	public List<EObject> executeRuleForAllMatches(Unit rule, Map<String, Object> parameters, EObject model) {
		return executeRuleForAllMatches((Rule) rule, parameters, model);
	}
	
	public List<EObject> executeRuleForAllMatches(String modulePath, String ruleName, Map<String, Object> parameters, String modelPath) {
		EObject model = loadModel(modelPath);
		Module module = rs.getModule(modulePath, true);
		Unit rule = module.getUnit(ruleName);
		return executeRuleForAllMatches((Rule) rule, parameters, model);
	}
	
	public List<EObject> executeRuleForAllMatches(String modulePath, String ruleName, Map<String, Object> parameters, EObject model) {
		Module module = rs.getModule(modulePath, true);
		Unit rule = module.getUnit(ruleName);
		return executeRuleForAllMatches((Rule) rule, parameters, model);
	}
	
	private List<EObject> executeRuleForAllMatches(Rule rule, Map<String, Object> parameters, EObject model) {						
		//EObject modelCopy = EcoreUtil.copy(model);
		
		// Initialize the graph
		EGraph graph = new PartitionedEGraphImpl(model, threads);
		
		// Set parameters
		Match partialMatch = new MatchImpl(rule);
		for (Parameter p : rule.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				partialMatch.setParameterValue(p, parameters.get(p.getName()));
			}
		}
		
		//System.out.println("rule: " + rule);
		List<EObject> results = new ArrayList<EObject>();
		for (Match match : engine.findMatches(rule, graph, partialMatch)) {
			//System.out.println(match);
			
			// Copy the model
			EObject m = EcoreUtil.copy(model);
			
			// Initialize the graph:
			EGraph g = new PartitionedEGraphImpl(m, threads);
						
			UnitApplication application = new UnitApplicationImpl(engine, g, match.getRule(), match);
			//RuleApplication application = new RuleApplicationImpl(engine, g, match.getRule(), match);
			//application.setCompleteMatch(match);
			//application.execute(new LoggingApplicationMonitor());
			
			// Set engine options
			engine.getOptions().put(Engine.OPTION_CHECK_DANGLING, false);
			engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
			application.execute(null);

			results.add(m);
		}
		return results;
	}
	
	/**
	 * Execute a Henshin unit/rule.
	 * 
	 * @param unit			Unit/rule.
	 * @param parameters	Parameters of the unit/rule: name -> value.
	 * @param model			Model to be transformed.
	 * @return				True if the transformation was successfully applied.
	 */
	public boolean executeTransformation(Unit unit, Map<String, Object> parameters, EObject model) {						
		// Initialize the graph
		EGraph graph = new EGraphImpl(model);
		
		// Prepare application of the unit/rule
		UnitApplication application = new UnitApplicationImpl(engine, graph, unit, null);
		
		// Assign parameters values before execution
		for (Parameter p : unit.getParameters()) {
			if (p.getKind().equals(ParameterKind.IN)) {
				application.setParameterValue(p.getName(), parameters.get(p.getName()));
			}
		}
		
		// Set engine options
		engine.getOptions().put(Engine.OPTION_CHECK_DANGLING, false);
		engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
		
		// Execute the unit/rule
		//ApplicationMonitor monitor = new LoggingApplicationMonitor();
		boolean status = application.execute(null);
		
		System.out.println("Roots: " + graph.getRoots());
		return status;
	}
	
	/**
	 * Execute a Henshin unit/rule.
	 * 
	 * @param modulePath	Path of the .henshin module file.
	 * @param ruleName		Name of the unit/rule contained in the module.
	 * @param parameters	Parameters of the unit/rule: name -> value.
	 * @param modelPath		Path of the model to be transformed.
	 * @return				Model object transformed.
	 */
	public EObject executeTransformation(String modulePath, String ruleName, Map<String, Object> parameters, String modelPath) {
		EObject model = loadModel(modelPath);
		Module module = getModule(modulePath);
		Unit rule = module.getUnit(ruleName);
		executeTransformation(rule, parameters, model);
		return model;
	}
	
//	/**
//	 * Execute a variability Henshin unit/rule.
//	 * 
//	 * @param unit			Unit/rule.
//	 * @param parameters	Parameters of the unit/rule: name -> value.
//	 * @param configuration	Configuration of the variability rule.
//	 * @param model			Model to be transformed.
//	 * @return				True if the transformation was successfully applied.
//	 */
//	public boolean executeVariableTransformation(Unit unit, Map<String,String> parameters, Map<String, Boolean> configuration, EObject model) {						
//		// Initialize the graph
//		EGraph graph = new EGraphImpl(model);
//		
//		// Prepare application of the unit/rule
//		RuleApplicationImpl vbRuleApp = new VarRuleApplicationImpl(engine, graph, (Rule) unit, configuration, null);
//		
//		// Assign parameters values before execution
//		for (Parameter p : unit.getParameters()) {
//			if (p.getKind().equals(ParameterKind.IN)) {
//				vbRuleApp.setParameterValue(p.getName(), parameters.get(p.getName()));
//			}
//		}
//		
//		// Set engine options
//		engine.getOptions().put(Engine.OPTION_CHECK_DANGLING, false);
//		
//		// Execute the unit/rule
//		//ApplicationMonitor monitor = new LoggingApplicationMonitor();
//		boolean status = vbRuleApp.execute(null);
//		
//		return status;
//	}
//	
//	/**
//	 * Execute a variability Henshin unit/rule.
//	 * 
//	 * @param modulePath	Path of the .henshin module file.
//	 * @param ruleName		Name of the unit/rule contained in the module.
//	 * @param parameters	Parameters of the unit/rule: name -> value.
//	 * @param configuration	Configuration of the variability rule.
//	 * @param model			Model to be transformed.
//	 * @return				Model transformed.
//	 */
//	public boolean executeVariableTransformation(String modulePath, String ruleName, Map<String,String> parameters, Map<String, Boolean> configuration, String modelPath) {
//		EObject model = loadModel(modelPath);
//		Module module = getModule(modulePath);
//		Unit rule = module.getUnit(ruleName);
//		return executeVariableTransformation(rule, parameters, configuration, model);
//	}
	
}
