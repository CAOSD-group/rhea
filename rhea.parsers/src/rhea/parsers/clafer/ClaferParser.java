package rhea.parsers.clafer;

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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Trees;

import clafer.AbstractVisitor;
import clafer.PrettyPrinter;
import clafer.claferLexer;
import clafer.claferParser;
import clafer.claferParserBaseListener;
import clafer.claferParserListener;
import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.utils.EMFIO;
import rhea.metamodels.utils.FMGenerator;
import rhea.parsers.FMParser;

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
        
		var indentations = getIndentationMap(filename);
		System.out.println(indentations);
		
        CharStream codePointCharStream = CharStreams.fromFileName(filename);
        claferLexer lexer = new claferLexer(codePointCharStream);
        claferParser parser = new claferParser(new CommonTokenStream(lexer));
        parser.addParseListener(new claferParserBaseListener());
        
        // Start parsing
       /*
        claferParser.Start_ModuleContext pc = parser.start_Module();
        clafer.Absyn.Module ast = pc.result;
        System.out.println();
        System.out.println("Parse Succesful!");
        System.out.println();
        System.out.println("[Abstract Syntax]");
        System.out.println();
        System.out.println(PrettyPrinter.show(ast));
        System.out.println();
        System.out.println("[Linearized Tree]");
        System.out.println();
        System.out.println(PrettyPrinter.print(ast));
       */
        //ParseTree tree = parser.module();
        
        /*
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        System.out.println(tree.getClass());
        System.out.println(tree.getText());
        
        */

        //ParseTree tree = parser.clafer();
        /*
        System.out.println(tree);
        System.out.println(tree.getParent());
        System.out.println(tree.getChildCount());
        for (int i = 0; i < tree.getChildCount(); i++) {
        	System.out.println(tree.getChild(i));	
        }
        
        */
       // System.out.println(tree);
       // System.out.println(Trees.toStringTree(tree));
                
        System.out.println("****");
        ParseTree tree = parser.module();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyClaferParserListener listener = new MyClaferParserListener(indentations);
        walker.walk(listener, tree);
        
        FeatureModel fm = listener.getFeatureModel();
        System.out.println("Feature Model: " + fm);
        System.out.println("Root: " + fm.getRoot());
        System.out.println("N features: " + listener.getFeatures());
        System.out.println(fm.getRoot().getChildren());
        
        EMFIO.saveModel(fm, List.of(BasicFMsPackage.eINSTANCE, CardinalityBasedFMsPackage.eINSTANCE), "output/fm.xmi");
        /*
        ClaferVisitor classVisitor = new ClaferVisitor();
        parser.module().accept(classVisitor);
        */
        
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
	
	private static Map<Integer, Integer> getIndentationMap(String filepath) {
		Path path = Path.of(filepath);
		var indentations = new HashMap<Integer, Integer>();
		try {
			List<String> lines = Files.readAllLines(path);
			
			// Remove comments and blank lines
			lines = lines.stream().filter(l -> !l.startsWith("//") && !l.isBlank()).collect(Collectors.toList());
			
			int n = 0;
			for (String line : lines) {
				int tabs = getIndentation(line);
				indentations.put(n, tabs);
				n++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return indentations;
	}
	
	private static int getIndentation(String line) {
		Pattern r = Pattern.compile("([\t]+)");	
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
		sc.close();
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
