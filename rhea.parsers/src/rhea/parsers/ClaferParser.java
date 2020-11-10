package rhea.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import rhea.metamodels.FMGenerator;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;

public class ClaferParser implements FMParser {
	private static String ROOT_REGEX = "(abstract )?(.+)$";
	private static String OPTIONALFEATURE_REGEX = "\t+(.+) ?[?]$";
	//private static String GROUPCARDINALITY_REGEX = "\t+(xor) (.+)$";
	private Map<Integer, Feature> indentParent;
	
	public static void main(String[] args) throws IOException {
		String filename = "inputs/FM-TelematicsSystem.txt";
		Path filepath = Path.of(filename);
		String text = Files.readString(filepath);
		System.out.println(text);
		
		FMParser parser = new ClaferParser();
		parser.readFeatureModel(filename);
	}
	
	public ClaferParser() {
		indentParent = new HashMap<Integer, Feature>();
	}
	
	@Override
	public FeatureModel readFeatureModel(String filepath) {
		Path path = Path.of(filepath);
		try {
			List<String> lines = Files.readAllLines(path);
			
			// Remove comments and blank lines
			lines = lines.stream().filter(l -> !l.startsWith("//") && !l.isBlank()).collect(Collectors.toList());
			
			// Create empty feature model
			FMGenerator fmGen = new FMGenerator();
			
			// Get the root feature
			String rootName = parseRoot(lines.get(0));
			Feature root = fmGen.createRoot(rootName);
			indentParent.put(1, root);
			
			// Create feature tree
			for (String line : lines.subList(1, lines.size())) {
				parseLine(line);
			}
			
			
			FeatureModel fm = fmGen.getFeatureModel();
			
			// set the name of the feature model
			String fmName = path.getFileName().toString();
			fmName = fmName.substring(0, fmName.indexOf('.'));
			fm.setName(fmName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private int getIndentation(String line) {
		Pattern r = Pattern.compile("([ \t]+)");	
		Matcher m = r.matcher(line);
		
		int tabs = 0;
		if (m.find()) {
			tabs = m.group(1).length();
		}
		return tabs;
	}
	
	
	private void parseLine(String line) {
		Scanner sc = new Scanner(line);
		int tabs = getIndentation(line);
		Feature parent = null;
		if (indentParent.containsKey(tabs)) {
			parent = indentParent.get(tabs);
		}
		System.out.println(tabs);
		
		//System.out.println(line + " -> " + line.split("\t").length);
		/*
				
		if (line.contains(" xor ")) {	// Optional feature
			System.out.println("xor");
		} else if (line.contains("..")) {
			System.out.println("or");
		} else if (line.startsWith("[")) { // Constraint
			System.out.println("constraint");
		} else {
			System.out.println("normal feature");
		}
*/
	}
	
	private String parseRoot(String line) {
	    Pattern r = Pattern.compile(ROOT_REGEX);	
	    Matcher m = r.matcher(line);
	    
	    //System.out.println("line: " + line);
	    
	    if (m.find()) {
	    	return m.group(2);
	    } else {
	    	return null;
	    }
	}
}
