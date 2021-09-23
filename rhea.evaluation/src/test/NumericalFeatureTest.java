package test;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicCTCs.BasicCTCsPackage;
import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.impl.FeatureModelImpl;
import rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage;
import rhea.metamodels.ComparativeCTCs.impl.LessImpl;
import rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl;
import rhea.metamodels.DataTypes.DataTypesPackage;
import rhea.metamodels.DataTypes.PrimitiveTypeEnum;
import rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl;
import rhea.metamodels.NumericalFMs.NumericalFMsPackage;
import rhea.metamodels.NumericalFMs.impl.NumericalFeatureImpl;
import rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage;
import rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl;
import rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.FeatureModelGeneratorHelper;
import rhea.transformations.engine.HenshinEngine;
import rhea.transformations.engine.LanguageGeneratorType;
import rhea.transformations.refactoringJava.JavaNumericalFeature;

public class NumericalFeatureTest {
	public static final List<EPackage> staticMetamodels = List.of(BasicFMsPackage.eINSTANCE, NumericalFMsPackage.eINSTANCE, ComparativeCTCsPackage.eINSTANCE, DataTypesPackage.eINSTANCE, PropLogicCTCsPackage.eINSTANCE, BasicCTCsPackage.eINSTANCE);
	
	public static void main(String[] args) {
		FMParser p = new ClaferParser();
		FMGenerator g = new ToClafer();
		JavaNumericalFeature transformator;
		FeatureModelGeneratorHelper fmg = new FeatureModelGeneratorHelper();
		HenshinEngine henshin = new HenshinEngine(Rhea.BASEDIR);
		FeatureModelImpl fm;
		
		for (EPackage mm : staticMetamodels) henshin.registerStaticMetamodel(mm);	
		
		fm = (FeatureModelImpl) henshin.loadModel(Rhea.BASEDIR + "rhea.evaluation/inputs/AbstractSyntax/FeatureModel.xmi");
		
		/* Ecore cuando lee el modelo no crea ni completa la lista de features */
		fm.createFeatureList();
		fm.getFeatures().add(fm.getRoot());
		fm.getFeatures().add(fm.getRoot().getChildren().get(0));
		
		transformator = new JavaNumericalFeature(fm, "rhea.metamodels.NumericalFMs.NumericalFeature");
		//fm = createFM(fmg);
		//fm = p.readFeatureModel(Rhea.CLAFER_INPUTS_DIR + "NumericalFeature/nf001.txt");
		transformator.executeRefactoring();
		Utils.serialize(g.fm2text(transformator.getFeatureModel()), Rhea.CLAFER_OUTPUTS_DIR + "NumericalFeature/nf001.txt"); // Except Constraints, works fine
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
