package rhea.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClaferParserMain {

	public static void main(String[] args) throws IOException {
		String filename = "src/test/resources/inputs-models/FM-TelematicsSystem.txt";
		Path filepath = Path.of(filename);
		String text = Files.readString(filepath);
		System.out.println(text);
		
		
		
	}

}
