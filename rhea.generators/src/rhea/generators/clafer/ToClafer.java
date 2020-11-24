package rhea.generators.clafer;

import org.eclipse.emf.common.util.EList;

import rhea.generators.FMGenerator;
import rhea.metamodels.BasicCTCs.Excludes;
import rhea.metamodels.BasicCTCs.Requires;
import rhea.metamodels.BasicFMs.AlternativeGroup;
import rhea.metamodels.BasicFMs.CrossTreeConstraint;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.SelectionGroup;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.MutexGroup;
import rhea.thirdpartyplugins.utils.Utils;

/**
 * Transform a feature model (from its abstract syntax) to a Clafer model.
 * 
 * @author Jose-Miguel Horcas
 *
 */
public class ToClafer implements FMGenerator {
	public static final String TAB = "\t";
	
	public String fm2text(FeatureModel fm) {
		StringBuffer claferFM = new StringBuffer();
		
		if (fm.getRoot() != null) {
			traverseTree(claferFM, fm.getRoot(), 0);
			addConstraints(claferFM, fm.getCrosstreeconstraints());	
			
			// Add the initial instance
			claferFM.append("config").append(": ").append(fm.getRoot().getName());
		}
		
		return claferFM.toString();
	}
	
	private void traverseTree(StringBuffer claferFM, Feature feature, int tab) {
		addTabs(claferFM, tab);
		
		if (feature.isRoot()) {
			claferFM.append("abstract ").append(feature.getName());
		} else {
			if (feature instanceof AlternativeGroup) {
				claferFM.append("xor ");
			} else if (feature instanceof SelectionGroup) {
				claferFM.append("or " );
			} else if (feature instanceof GroupCardinality) {
				var mul = ((GroupCardinality) feature).getMultiplicity();
				claferFM.append(mul.getLower()).append("..").append(mul.getUpper()).append(" ");
			} else if (feature instanceof MutexGroup) {
				claferFM.append("mux " );
			}
			claferFM.append(feature.getName());
			if (!feature.isMandatory() && !(feature.getParent() instanceof FeatureGroup)) {	// Optional feature
				claferFM.append(" ?");
			}
		}
		claferFM.append(System.lineSeparator());	// End of line
		
		// Rest of children
		for (int i = 0; i < feature.getChildren().size(); i++) {
			traverseTree(claferFM, feature.getChildren().get(i), tab+1);
		}
		
	}
	
	private void addConstraints(StringBuffer claferFM, EList<CrossTreeConstraint> crossTreeConstraints) {
		for (CrossTreeConstraint ctc : crossTreeConstraints) {
			System.out.println("Constraints: " + ctc);
			if (ctc instanceof Requires) {
				Feature left = ((Requires) ctc).getLeftFeature();
				Feature right = ((Requires) ctc).getRightFeature();
				claferFM.append("[").append(left.getName()).append(" => ").append(right.getName()).append("]");
			} else if (ctc instanceof Excludes) {
				Feature left = ((Excludes) ctc).getLeftFeature();
				Feature right = ((Excludes) ctc).getRightFeature();
				claferFM.append("[").append(left.getName()).append(" xor ").append(right.getName()).append("]");
			}
			claferFM.append(System.lineSeparator());	// End of line
		}
	}
	
	private void addTabs(StringBuffer claferFM, int tab) {
		for (int j = 0 ; j < tab ; j++) {
			claferFM.append(TAB);
		}
	}
	
	/*
	public void serialize(String content, String outputFilepath) {
		try {
			Path path = Paths.get(outputFilepath);
			if (!Files.exists(path)) {
				Files.createDirectories(path.getParent());
				Files.createFile(path);
			}
			FileWriter writer = new FileWriter(path.toString());
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * Given a feature model, it translates it to Clafer notation and serialize it.
	 * 
	 * @param fm	Feature model.
	 * @return		Filepath of the Clafer model generated (.txt).
	 */
	public static String toClafer(String basedir, FeatureModel fm) {
		ToClafer toClafer = new ToClafer();
		String claferModel = toClafer.fm2text(fm);
		String modelPath = basedir + fm.getName() + ".txt";
		Utils.serialize(claferModel, modelPath);
		
		return modelPath;
	}
}
