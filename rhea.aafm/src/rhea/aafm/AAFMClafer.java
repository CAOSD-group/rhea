package rhea.aafm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
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

	private FeatureModel fm;
	private List<List<String>> configs;
	
	public AAFMClafer() {
		this.fm = null;
		this.configs = new ArrayList<List<String>>();
	}
	
	@Override
	public int numberOfConfigurations(FeatureModel fm) {
		if (this.fm != null && this.fm.equals(fm)) {
			return configs.size();
		}
		configs = configurations(fm);
		return configs.size();
	}

	@Override
	public List<List<String>> configurations(FeatureModel fm) {
		if (this.fm != null && this.fm.equals(fm)) {
			return configs;
		}
		String claferFilepath = ToClafer.toClafer(TEMP_DIR, fm);
		String chocoFilepath = ClaferUtils.compileClafer(claferFilepath);
		String configsFilepath = ClaferUtils.generateConfigurations(chocoFilepath);
		configs = ClaferUtils.parserConfigs(configsFilepath);
		
		Utils.cleanUp(TEMP_DIR);
		
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
