package rhea.evaluation.languagegenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.utils.FMHelper;
import rhea.transformations.engine.FeatureModelGenerator;
import rhea.transformations.engine.LanguageGeneratorType;

public class LanguageGeneratorsTests {

	public static void main(String[] args) {
		// Input
		Set<String> features = Set.of("A", "B", "C");
		Set<LanguageGeneratorType> lcs = Set.of(LanguageGeneratorType.Root, LanguageGeneratorType.Feature);
		
		// Generate all possible feature models 
		System.out.println("Generating all possible feature models...");
		FeatureModelGenerator fmGen = new FeatureModelGenerator();
		List<FeatureModel> fms = fmGen.generateAllFeatureModels("fm", features, lcs);
		
		//System.out.println("MODELS TRANSFORMED4: " + fms);
		// Calculate configurations
		System.out.println("Calculating configurations of feature models...");
		AutomatedAnalysisFM aafm = new AAFMClafer();
		
		for (FeatureModel fm : fms) {
			if (fm.getFeatures().size() > 0) {
				var configs = aafm.configurations(fm);
				System.out.println("FM: " + fm.getName() + " -> " + FMHelper.configurationsToString(configs));
			} else {
				System.out.println("FM: " + fm.getName() + " -> empty feature model.");
			}
			
			
			
			
		}
		
		System.out.println("Done!");
	}
}
