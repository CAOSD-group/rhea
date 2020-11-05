package rhea.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import uma.caosd.rhea.metamodels.BasicFMs.FeatureModel;

public class ClaferParser implements FMParser {

	@Override
	public FeatureModel readFeatureModel(String filepath) {
		Path path = Path.of(filepath);
		try {
			List<String> lines = Files.readAllLines(path);
			for (String line : lines) {
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	private void parseLine(String line, int tab) {
		if (line.startsWith("//")) {	// Comments (ignore)
			
		} else if (line.strip().equals("")) { // Empty line
			
		} else if (line.startsWith("[")) { // Constraint
			
		} else {	// Feature
			
		}
	}
}
