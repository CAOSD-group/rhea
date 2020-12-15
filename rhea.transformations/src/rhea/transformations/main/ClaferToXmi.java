package rhea.transformations.main;

import java.io.IOException;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.EMFIO;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;

public class ClaferToXmi {

	public static void main(String[] args) {
		String inputModel = "gc013";
		
		String inputFile = "inputs/" + inputModel + ".txt";
		String outputFile = "inputs/" + inputModel + ".xmi";
		
		System.out.println("Parsing Clafer feature model " + inputFile);
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		
		try {
			System.out.println("Serializing feature model " + outputFile);
			// Serialize the abstract syntax
			EMFIO.saveModel(fm, Rhea.STATIC_METAMODELS, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done!");
	}

}
