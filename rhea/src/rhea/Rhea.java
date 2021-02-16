package rhea;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage;

public class Rhea {
	//public static final String BASEDIR = "D:/Workspaces/RHEA-ws/rhea/";
	public static final String BASEDIR = "B:/Trabajo/Investigación/Proyectos/RHEA/rhea/";
	
	public static final String METAMODELS_DIR = BASEDIR + "rhea.metamodels/metamodels/";
	public static final String REFACTORINGS_DIR = BASEDIR + "rhea.transformations/refactorings/";
	public static final String LANGUAGEGENERATOR_DIR = BASEDIR + "rhea.transformations/languagegenerators/";
	public static final String INPUTS_DIR = BASEDIR + "rhea.evaluation/inputs/";
	public static final String OUTPUTS_DIR = BASEDIR + "rhea.evaluation/outputs/";
	
	public static final String TRANSFORMATION_OUTPUTS_DIR = BASEDIR + "rhea.transformations/output/";
	
	public static final String ABSTRACTSYNTAX_INPUTS_DIR = INPUTS_DIR + "AbstractSyntax/";
	public static final String ABSTRACTSYNTAX_OUTPUTS_DIR = OUTPUTS_DIR + "AbstractSyntax/";
	
	public static final String CLAFER_INPUTS_DIR = INPUTS_DIR + "clafer/";
	public static final String CLAFER_OUTPUTS_DIR = OUTPUTS_DIR + "clafer/";
	
	public static final String EVALUATION_PACKAGE = "rhea.evaluation.refactorings.";
	
	public static final int EVALUATION_ITERATIONS = 30;
	public static final String REFACTOR_PATH = "FMGenerated/";
	
	public static final String TRANSFORMATIONS_OUTPUT = BASEDIR + "rhea.transformations/output/";
	
	public static final List<String> DYNAMIC_METAMODELS = List.of(METAMODELS_DIR + "BasicFMs/BasicFMs.ecore",
																  METAMODELS_DIR + "CardinalityBasedFMs/CardinalityBasedFMs.ecore");
	
	public static final List<EPackage> STATIC_METAMODELS = List.of(BasicFMsPackage.eINSTANCE, 
																   CardinalityBasedFMsPackage.eINSTANCE, 
																   PropLogicCTCsPackage.eINSTANCE);
}
