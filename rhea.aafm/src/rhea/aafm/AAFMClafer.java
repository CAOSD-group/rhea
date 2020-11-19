package rhea.aafm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.utils.FMHelper;
import rhea.thirdpartyplugins.clafer.ClaferUtils;
import rhea.thirdpartyplugins.utils.Utils;

/**
 * Implement operations analysis of feature models using Clafer and Chocosolver.
 * 
 * @author José Miguel Horcas
 *
 */
public class AAFMClafer implements AutomatedAnalysisFM {
	public static final String TEMP_DIR = "temp/Clafer/";
	
	@Override
	public int numberOfConfigurations(FeatureModel fm) {
		return configurations(fm).size();
	}

	@Override
	public Set<Set<Feature>> configurations(FeatureModel fm) {
		String claferFilepath = ToClafer.toClafer(TEMP_DIR, fm);
		String chocoFilepath = ClaferUtils.compileClafer(claferFilepath);
		String configsFilepath = ClaferUtils.generateConfigurations(chocoFilepath);
		var configs = ClaferUtils.parserConfigs(configsFilepath);
		
		Utils.cleanDirectory(TEMP_DIR);
		
		// Convert from string to Feature
		var featuresConfigs = new HashSet<Set<Feature>>();
		for (List<String> c : configs) {
			var config = new HashSet<Feature>();
			for (String fName : c) {
				List<Feature> features = FMHelper.getFeatures(fm, fName);
				if (!features.isEmpty()) {
					config.add(features.get(0));
				}
			}
			featuresConfigs.add(config);
		}
		return featuresConfigs;
	}

	@Override
	public Set<Set<Feature>> products(FeatureModel fm) {
		var configs = configurations(fm);
		var abstractFeatures = fm.getFeatures().stream().filter(f -> f.isAbstract()).collect(Collectors.toSet());
		
		for (Set<Feature> c : configs) {
			c.removeAll(abstractFeatures);
		}
		return configs;
	}
	
	public static List<List<String>> configurations(String claferFMFilepath) {
		String chocoFilepath = ClaferUtils.compileClafer(claferFMFilepath);
		String configsFilepath = ClaferUtils.generateConfigurations(chocoFilepath);
		var configs = ClaferUtils.parserConfigs(configsFilepath);
		
		try {
			Files.delete(Path.of(chocoFilepath));
			Files.delete(Path.of(configsFilepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return configs;
	}
}
