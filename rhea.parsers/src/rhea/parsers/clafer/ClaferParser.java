package rhea.parsers.clafer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import clafer.claferLexer;
import clafer.claferParser;
import clafer.claferParserBaseListener;
import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.helpers.EMFIO;
import rhea.parsers.FMParser;
import rhea.thirdpartyplugins.utils.Utils;

public class ClaferParser implements FMParser {
	public static final String CLAFER_COMMENTS = "//";

	@Override
	public FeatureModel readFeatureModel(String filepath) {
		FeatureModel fm = null;
		Path path = Path.of(filepath);
		try {	
			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			
			// Remove comments and blank lines
			lines = Utils.cleanSourceCode(lines, CLAFER_COMMENTS);
			
			// Build the indentations map (line -> tabs)
			var indentations = Utils.getIndentationMap(lines);
			
			CharStream codePointCharStream = CharStreams.fromString(String.join(System.lineSeparator(), lines));
			claferLexer lexer = new claferLexer(codePointCharStream);
	        claferParser parser = new claferParser(new CommonTokenStream(lexer));
	        parser.addParseListener(new claferParserBaseListener());
	       
	        ParseTree tree = parser.module();
	        ParseTreeWalker walker = new ParseTreeWalker();
	        MyClaferParserListener listener = new MyClaferParserListener(indentations);
	        walker.walk(listener, tree);
	        
	        fm = listener.getFeatureModel();
	        //fm.setName(fm.getRoot().getName());
	        String name = path.getFileName().toString();
	        fm.setName(name.substring(0, name.indexOf(".")));
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fm;
	}
	
	
	/**
	 * Main para probar/jugar con el parser de Clafer generado desde su gramática.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filename = "inputs/FM-TelematicsSystem.txt";
		Path path = Path.of(filename);

		List<String> lines = Files.readAllLines(path);
		
		// Remove comments and blank lines
		lines = lines.stream().filter(l -> !l.startsWith(CLAFER_COMMENTS) && !l.isBlank()).collect(Collectors.toList());
		
		// Build the indentations map (line -> tabs)
		var indentations = Utils.getIndentationMap(lines);
		
		CharStream codePointCharStream = CharStreams.fromString(String.join(System.lineSeparator(), lines));
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
}
