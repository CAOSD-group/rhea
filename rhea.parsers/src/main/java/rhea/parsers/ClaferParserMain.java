package rhea.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.clafer.ast.AstModel;
import org.clafer.ast.Asts;

public class ClaferParserMain {

	public static void main(String[] args) throws IOException {
		String filename = "src/test/resources/inputs-models/FM-TelematicsSystem.txt";
		Path filepath = Path.of(filename);
		String text = Files.readString(filepath);
		
		AstModel m = org.clafer.ast.Asts.newModel();
		
		
	}

}
