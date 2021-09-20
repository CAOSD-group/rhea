package rhea.generators.clafer;

import java.util.stream.Collectors;

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
import rhea.metamodels.ComparativeCTCs.*;
import rhea.metamodels.DataTypes.PrimitiveType;
import rhea.metamodels.NumericalFMs.NumericalFeature;
import rhea.metamodels.PropLogicCTCs.AdvancedConstraint;
import rhea.metamodels.PropLogicCTCs.And;
import rhea.metamodels.PropLogicCTCs.Equiv;
import rhea.metamodels.PropLogicCTCs.FeatureTerm;
import rhea.metamodels.PropLogicCTCs.Implies;
import rhea.metamodels.PropLogicCTCs.Not;
import rhea.metamodels.PropLogicCTCs.Or;
import rhea.metamodels.PropLogicCTCs.Term;
import rhea.metamodels.PropLogicCTCs.Xor;
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
				String upper = mul.getUpper() == -1 ? "*" : String.valueOf(mul.getUpper());
				claferFM.append(mul.getLower()).append("..").append(upper).append(" ");
			} else if (feature instanceof MutexGroup) {
				claferFM.append("mux " );
			}
			claferFM.append(feature.getName());
			if (feature instanceof NumericalFeature && ((NumericalFeature) feature).getType() instanceof PrimitiveType) {
				claferFM.append(" -> " + ((PrimitiveType)((NumericalFeature) feature).getType()).getType());
				
				if(((NumericalFeature) feature).getValue() != 0.0) {
					claferFM.append(" : " + ((NumericalFeature) feature).getValue());
				}
			}
			
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
			if (ctc instanceof Requires) {
				Feature left = ((Requires) ctc).getLeftFeature();
				Feature right = ((Requires) ctc).getRightFeature();
				claferFM.append("[").append(left.getName()).append(" => ").append(right.getName()).append("]");
			} else if (ctc instanceof Excludes) {
				Feature left = ((Excludes) ctc).getLeftFeature();
				Feature right = ((Excludes) ctc).getRightFeature();
				claferFM.append("[").append(left.getName()).append(" xor ").append(right.getName()).append("]");
			} else if (ctc instanceof AdvancedConstraint) {
				String advancedCTC = addAdvanceConstraint(((AdvancedConstraint) ctc).getExpr());
				claferFM.append("[").append(advancedCTC).append("]");
			}
			claferFM.append(System.lineSeparator());	// End of line
		}
	}
	
	private String addAdvanceConstraint(Term t) {
		StringBuffer constraint = new StringBuffer(); 
		if (t instanceof FeatureTerm) {
			constraint.append(((FeatureTerm) t).getFeature().getName());
		} else if (t instanceof Not) {
			Not not = (Not) t;
			String n = not.getTerm() instanceof FeatureTerm ? ((FeatureTerm) not.getTerm()).getFeature().getName() : "(" + addAdvanceConstraint(not.getTerm()) + ")";
			constraint.append("!").append(n);
		} else if (t instanceof Implies) {
			Term left = ((Implies) t).getLeft();
			Term right = ((Implies) t).getRight();
			String l = left instanceof FeatureTerm ? ((FeatureTerm) left).getFeature().getName() : addAdvanceConstraint(left);
			String r = right instanceof FeatureTerm ? ((FeatureTerm) right).getFeature().getName() : addAdvanceConstraint(right);
			constraint.append(l).append(" => ").append(r);
		} else if (t instanceof Excludes) {
			Term left = ((Implies) t).getLeft();
			Term right = ((Implies) t).getRight();
			String l = left instanceof FeatureTerm ? ((FeatureTerm) left).getFeature().getName() : addAdvanceConstraint(left);
			String r = right instanceof FeatureTerm ? "!" + ((FeatureTerm) right).getFeature().getName() : "!" + addAdvanceConstraint(right);
			constraint.append(l).append(" => ").append(r);
		} else if (t instanceof Xor) {
			Xor xor = (Xor) t;
			String x = xor.getTerms().stream().map(tx -> addAdvanceConstraint(tx)).collect(Collectors.joining(","));
			constraint.append("xor(").append(x).append(")");
		} else if (t instanceof And) {
			And and = (And) t;
			String a = and.getTerms().stream().map(ta -> addAdvanceConstraint(ta)).collect(Collectors.joining(" && "));
			constraint.append("(").append(a).append(")");
		} else if (t instanceof Or) {
			Or or = (Or) t;
			String o = or.getTerms().stream().map(to -> addAdvanceConstraint(to)).collect(Collectors.joining(" || "));
			constraint.append("(").append(o).append(")");
		} else if (t instanceof Equiv) {
			Equiv equiv = (Equiv) t;
			String e = equiv.getTerms().stream().map(te -> addAdvanceConstraint(te)).collect(Collectors.joining(" <=> "));
			constraint.append(e);
		}
		
		// Restricciones Numéricas
		if(t instanceof BinaryComparativeTerm)
		{
			BinaryComparativeTerm bct = (BinaryComparativeTerm) t;
			Term left = bct.getLeft(); 
			Term right = bct.getRight();
			
			String l,r;
			
			if(left instanceof FeatureTerm) l = ((FeatureTerm) left).getFeature().getName();
			else if (left instanceof NumericTerm) l = Float.toString(((NumericTerm) left).getValue());
			else l = addAdvanceConstraint(left);

			if(right instanceof FeatureTerm) r = ((FeatureTerm) right).getFeature().getName();
			else if (right instanceof NumericTerm) r = Float.toString(((NumericTerm) right).getValue());
			else r = addAdvanceConstraint(right);
		
			if(t instanceof Equal) constraint.append(l).append(" = ").append(r);
			else if(t instanceof NotEqual) constraint.append(l).append(" != ").append(r);
			else if (t instanceof Less) constraint.append(l).append(" < ").append(r);
			else if (t instanceof More) constraint.append(l).append(" > ").append(r);
			else if (t instanceof LessOrEqual) constraint.append(l).append(" <= ").append(r);
			else if (t instanceof MoreOrEqual) constraint.append(l).append(" >= ").append(r);
		}
		
		return constraint.toString();
	}
	
	private void addTabs(StringBuffer claferFM, int tab) {
		for (int j = 0 ; j < tab ; j++) {
			claferFM.append(TAB);
		}
	}
	
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
