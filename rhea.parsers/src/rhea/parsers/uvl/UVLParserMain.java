package rhea.parsers.uvl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import de.neominik.uvl.UVLParser;
import de.neominik.uvl.ast.UVLModel;

/**
 * Example of usage for the UVL parser library.
 * 
 */
public class UVLParserMain {

	public static void main(String[] args) throws IOException {
		String filename = "src/test/resources/inputs-models/FM-MTGCard.uvl";
		Path filepath = Path.of(filename);
		String text = Files.readString(filepath);
		
		UVLModel model = (UVLModel) UVLParser.parse(text);
		
		System.out.println(model.toString());
		System.out.println("#Features: " + model.getAllFeatures().size());
		System.out.println("#CTCs: " + model.getConstraints().length);
		
	}

}
