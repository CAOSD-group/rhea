package test;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.ComparativeCTCs.impl.LessImpl;
import rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl;
import rhea.metamodels.DataTypes.PrimitiveTypeEnum;
import rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl;
import rhea.metamodels.NumericalFMs.impl.NumericalFeatureImpl;
import rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl;
import rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.FeatureModelGeneratorHelper;
import rhea.transformations.engine.LanguageGeneratorType;

public class NumericalFeatureTest {

	public static void main(String[] args) {
		FMParser p = new ClaferParser();
		FMGenerator g = new ToClafer();
		FeatureModelGeneratorHelper fmg = new FeatureModelGeneratorHelper();
		FeatureModel fm;
		
		//fm = createFM(fmg);
		fm = p.readFeatureModel(Rhea.CLAFER_INPUTS_DIR + "NumericalFeature/nf001.txt");
		System.out.println();
		Utils.serialize(g.fm2text(fm), Rhea.CLAFER_OUTPUTS_DIR + "NumericalFeature/nf001.txt"); // Except Constraints, works fine
	}
	
	private static FeatureModel createFM(FeatureModelGeneratorHelper fmg)
	{
		//Create the model
		FeatureModel fm = fmg.createEmptyFeatureModel("fm");
		fmg.addFeature(fm, LanguageGeneratorType.OrdinaryRoot ,"Root",true,false);
		
		NumericalFeatureImpl f = new NumericalFeatureImpl();
		f.setName("Numeric1");
		f.setId("Numeric1");
		f.setMandatory(true);
		f.setAbstract(true);
		
		PrimitiveTypeImpl dt = new PrimitiveTypeImpl();
		dt.setType(PrimitiveTypeEnum.INTEGER);
		f.setType(dt);
		f.setValue(Integer.valueOf(18));
		
		fm.getFeature("Root").getChildren().add(f);
		
		//Constraints
		AdvancedConstraintImpl ac = new AdvancedConstraintImpl();
		LessImpl lt = new LessImpl();
		
		FeatureTermImpl ft = new FeatureTermImpl();
		ft.setFeature(f);
		lt.setLeft(ft);
		
		NumericTermImpl nt = new NumericTermImpl();
		nt.setValue(15.2f);
		lt.setRight(nt);
		
		ac.setExpr(lt);
		fm.getCrosstreeconstraints().add(ac);
		
		return fm;
	}
}
