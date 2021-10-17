package rhea.transformations.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;

/**
 * Helper to generate feature models with Henshin.
 *
 */
public class FeatureModelGeneratorHelper {
	private HenshinEngine henshin;
	
	public FeatureModelGeneratorHelper() {
		this.henshin = new HenshinEngine(Rhea.BASEDIR);
		registerStaticMetamodels();
	}
	
	private void registerStaticMetamodels() {
		for (EPackage mm : Rhea.STATIC_METAMODELS) {
			henshin.registerStaticMetamodel(mm);
		}
	}
	
	private Module getHenshinModule(LanguageGeneratorType lc) {
		return henshin.getModule(Rhea.LANGUAGEGENERATOR_DIR + lc.getHenshinModule() + ".henshin");
	}
	
	/**
	 * Create an empty feature model.
	 * 
	 * @param name	Name of the feature model.
	 * @return		A new empty feature model instance.
	 */
	public FeatureModel createEmptyFeatureModel(String name) {
		FeatureModel fm = BasicFMsFactory.eINSTANCE.createFeatureModel();
		fm.setName(name);
		return fm;
	}
	
	/**
	 * Execute a language generator (Henshin transformation) over the provided feature model.
	 * 
	 * @param fm			Feature model.
	 * @param lc			Language generator type specification.
	 * @param parameters	Parameters for the language generators (e.g., feature name).
	 * @return				True if the generator was succesfully applied, false otherwise.
	 */
	public boolean executeLanguageGenerator(FeatureModel fm, LanguageGeneratorType lc, Map<String, Object> parameters) {
		Module module = getHenshinModule(lc);
		Unit unit = module.getUnit(lc.getHenshinRule());
		return henshin.executeTransformation(unit, parameters, fm);
	}
	
	public boolean addFeature(FeatureModel fm, String featureName) {
		LanguageGeneratorType lc = LanguageGeneratorType.OptionalFeature;
		return addFeature(fm, lc, featureName, false,false);
	}
	
	public boolean addFeature(FeatureModel fm, LanguageGeneratorType lc ,String featureName, boolean mandatory, boolean abs) {
		Map<String, Object> params = Map.of("name", featureName, "mandatory", mandatory, "abs", abs);
		return executeLanguageGenerator(fm, lc, params);
	}
	
	public boolean addFeature(FeatureModel fm, LanguageGeneratorType lc ,String featureName, boolean mandatory, boolean abs, Feature parent) {
		if(parent==null) return addFeature(fm, lc, featureName, mandatory, abs);
		Map<String, Object> params = Map.of("name", featureName, "mandatory", mandatory, "abs", abs, "parentId", parent.getId());
		return executeLanguageGenerator(fm, lc, params);
	}
	
	public boolean addGroupCardinality(FeatureModel fm, LanguageGeneratorType lc ,String featureName, boolean mandatory, boolean abs, int lower, int upper) {
		Map<String, Object> params = Map.of("name", featureName, "mandatory", mandatory, "abs", abs, "lower", lower, "upper", upper);
		return executeLanguageGenerator(fm, lc, params);
	}
	
	public boolean addGroupCardinality(FeatureModel fm, LanguageGeneratorType lc ,String featureName, boolean mandatory, boolean abs, Feature parent, int lower, int upper) {
		if(parent==null) return addGroupCardinality(fm, lc, featureName, mandatory, abs, lower, upper);
		Map<String, Object> params = Map.of("name", featureName, "mandatory", mandatory, "abs", abs, "parentId", parent.getId(), "lower", lower, "upper", upper);
		return executeLanguageGenerator(fm, lc, params);
	}
	
	public boolean addNumericalFeature(FeatureModel fm, LanguageGeneratorType lc ,String featureName, boolean mandatory, boolean abs, float value) {
		Map<String, Object> params = Map.of("name", featureName, "mandatory", mandatory, "abs", abs, "value" , value);
		return executeLanguageGenerator(fm, lc, params);
	}
	
	public boolean addNumericalFeature(FeatureModel fm, LanguageGeneratorType lc ,String featureName, boolean mandatory, boolean abs, Feature parent, float value) {
		if(parent==null) return addNumericalFeature(fm, lc, featureName, mandatory, abs, value);
		Map<String, Object> params = Map.of("name", featureName, "mandatory", mandatory, "abs", abs, "parentId", parent.getId(), "value" , value);
		return executeLanguageGenerator(fm, lc, params);
	}
	
	public boolean deleteFeature(FeatureModel fm, int id) {
		return executeLanguageGenerator(fm, LanguageGeneratorType.DeleteFeature, Map.of("Id", id));
	}
	
	/**
	 * Generates all possible feature models with the set of features and the provided language generators.
	 * 
	 * @param fmPrefixName	Feature model name prefix.
	 * @param featureNames	Features' names.
	 * @param lcs			Language generators to be applied.
	 * @return				Set of all possible feature models.
	 */
	public List<FeatureModel> generateAllFeatureModels(String fmPrefixName, Set<String> featureNames, Set<LanguageGeneratorType> lcs) {
		List<FeatureModel> allFMs = new ArrayList<FeatureModel>();
		int n = 0;
		
		// Initialize with empty feature model
		FeatureModel initialEmptyFM = createEmptyFeatureModel(fmPrefixName);
		initialEmptyFM.setName(fmPrefixName + n);
		allFMs.add(initialEmptyFM);
		
		// Models to be transformed with Henshin
		Stack<FeatureModel> modelsToTransform = new Stack<FeatureModel>();
		modelsToTransform.add(initialEmptyFM);
		
		while (!modelsToTransform.isEmpty()) {
			FeatureModel m = modelsToTransform.pop();
			
			// Apply all language generators to the current model with Henshin
			Set<FeatureModel> modelsTransformed = this.applyGenerators(m, featureNames, lcs);
			
			//allFMs.addAll(modelsTransformed);
			//modelsToTransform.addAll(modelsTransformed);
			
			for (FeatureModel fm : modelsTransformed) {
				if (FMHelper.isValid(fm)) {		// Control here also the duplicates in case there are.
					n++;
					fm.setName(fmPrefixName + n);
					allFMs.add(fm);
					modelsToTransform.add(fm);
				}
			}
		}
		return allFMs;
	}
	
//	private List<FeatureModel> generateAllPossibleModels(String prefixName, List<String> features) {
//		// Initialize with empty feature model
//		FeatureModel initialEmptyFM = createEmptyFeatureModel(prefixName);
//		try {
//			EMFIO.saveModel(initialEmptyFM, this.staticMetamodels, basedir + TEMPORAL_FM);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		EObject initialModel = henshin.loadModel(TEMPORAL_FM);
//		
//		// All models to be returned as result
//		List<EObject> allModels = new ArrayList<EObject>();
//		allModels.add(initialModel);
//		
//		// All models as feature model to be returned as result
//		List<FeatureModel> allFMs = new ArrayList<FeatureModel>();
//		allFMs.add(initialEmptyFM);
//		
//		// Models to be transformed with Henshin
//		Stack<EObject> modelsToTransform = new Stack<EObject>();
//		modelsToTransform.add(initialModel);
//		
//		
//		while (!modelsToTransform.isEmpty()) {
//			EObject m = modelsToTransform.pop();
//			
//			// Apply all language generators to the current model with Henshin
//			List<EObject> modelsTransformed = this.applyGenerators(m, features);
//			
//			// Remove duplicates
//			for (EObject mt : modelsTransformed) {
//				henshin.saveModel(mt, TEMPORAL_FM);
//				FeatureModel fm = (FeatureModel) EMFIO.loadModel(this.staticMetamodels, basedir + TEMPORAL_FM);
//				if (FMHelper.isValid(fm)) {
//					// Filter duplicated
//					if (!allModels.stream().anyMatch(m2 -> EcoreUtil.equals(mt, m2))) {
//						allModels.add(mt);
//						allFMs.add(fm);
//						modelsToTransform.add(mt);
//					}
//				}
//			}
//		}
//		Utils.cleanDirectory(basedir + TEMPORAL_FOLDER);
//		System.out.println("allModels: " + allModels.size());
//		System.out.println("allFMs: " + allFMs.size());
//		return allFMs;
//	}
	
	/**
	 * Apply all generators over the feature model in every possible place (match) for each feature.
	 * The application is individually, thus, at the end we only add one feature.
	 * 
	 * Agrega una feature de forma aleatoria en todos los posibles lugares del feature model, usando los constructores indicados.
	 * 
	 * @param fm			Feature model.
	 * @param featureNames	Features' names.
	 * @param lcs			Language generators to be applied.
	 * @return				Set of all generated feature models.
	 */
	private Set<FeatureModel> applyGenerators(FeatureModel fm, Set<String> featureNames, Set<LanguageGeneratorType> lcs) {
		Set<FeatureModel> fms = new HashSet<FeatureModel>();
		
		for (LanguageGeneratorType lc : lcs) {
			Module module = getHenshinModule(lc);
			Unit unit = module.getUnit(lc.getHenshinRule());
			for (String fName : featureNames) {
				Map<String, Object> parameters = new HashMap<String, Object>(lc.getParams());
				parameters.put(LanguageGeneratorParam.NAME.getName(), fName);
				parameters.put(LanguageGeneratorParam.ABSTRACT.getName(), false);
				List<EObject> modelsTransformed = henshin.executeRuleForAllMatches(unit, parameters, fm);
				//System.out.println("MODELS TRANSFORMED1: " + modelsTransformed);	
				/************/
				/*
				for (EObject m : modelsTransformed) {
					System.out.println("FM TRANSFORMED: " + ((FeatureModel)m).getFeatures());	
				}
				*/
				/*************/
				for (EObject m : modelsTransformed) {
					fms.add((FeatureModel) m);	
				}
				
				//fms.addAll((Collection<? extends FeatureModel>) modelsTransformed);
			}
		}
		//System.out.println("MODELS TRANSFORMED2: " + fms);	
		/*for (FeatureModel m : fms) {
			System.out.println("FM TRANSFORMED: " + m.getFeatures());	
		}*/
		return fms;
	}

//	private boolean isFeatureModelComplete(FeatureModel fm, List<String> features) {
//		// Check if all features are present in the feature model
//		for (String name : features) {
//			if (!fm.getFeatures().stream().anyMatch(f -> f.getName().equals(name))) {
//				return false;
//			}
//		}
//		return true;
//	}
	
//	private List<FeatureModel> filterValidFeatureModels(List<FeatureModel> fms, List<String> features) {
//		
//		// Feature model contains all features
//		fms = fms.stream().filter(fm -> isFeatureModelComplete(fm, features)).collect(Collectors.toList());
//		
//		// Feature groups cannot be leafs
//		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.isLeaf() && (f instanceof FeatureGroup))).collect(Collectors.toList());
//		
//		// Feature groups must have at least 2 childs
//		fms = fms.stream().filter(fm -> !fm.getFeatures().stream().anyMatch(f -> f.getChildren().size() < 2 && (f instanceof FeatureGroup))).collect(Collectors.toList());
//		
//		return fms;
//	}
	
}
