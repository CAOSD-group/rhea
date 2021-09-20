package rhea.evaluation.refactoringJava;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;

import java.util.List;
import java.util.ArrayList;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.helpers.FMHelper;
import rhea.thirdpartyplugins.utils.Utils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.evaluation.refactorings.Refactoring;
import rhea.evaluation.refactorings.TransformationInformation;
import rhea.transformations.refactoringJava.JavaGroupCardinalityRule;
import rhea.transformations.refactoringJava.JavaGroupCardinalityBaseRule;


public class JavaGroupCardinalityRefactoring extends Refactoring{

	public JavaGroupCardinalityRefactoring(FeatureModel featureModel) {
		super(featureModel);
		classPath = "rhea.metamodels.CardinalityBasedFMs.GroupCardinality";
	}

	@Override
	public List<TransformationInformation> refactor(int times, String output) {
		List<TransformationInformation> result = new ArrayList<>();
		FeatureModel f;
		
		JavaGroupCardinalityBaseRule gcbr = new JavaGroupCardinalityBaseRule(EcoreUtil.copy(fm), classPath);
		JavaGroupCardinalityRule gcr = new JavaGroupCardinalityRule(EcoreUtil.copy(fm), classPath);
		
		// The number of iterations
		for(int i = 0; i < times ; i++)
		{
			//Set the base state
			TransformationInformation tf = new TransformationInformation();
			f = EcoreUtil.copy(fm);
			gcbr.setFeatureModel(f);
			gcr.setFeatureModel(f);
			
			//Get the information before the refactoring
			tf.setRun(i);
			tf.setInputModel(f.getName());
			tf.setnFeaturesBefore(f.getFeatures().size());
			tf.setNumberOfFeaturesTypeBefore(gcr.getMatchingFeatures().size());
			tf.setnConstraints(f.getCrosstreeconstraints().size());
			tf.setnOptionals(FMHelper.getAllOptionalFeatures(f).size());
			tf.setnMandatories(FMHelper.getAllMandatoryFeatures(f).size());
			tf.setnAlternativeGroups(FMHelper.getAllFeaturesOf(f,"rhea.metamodels.BasicFMs.AlternativeGroup").size());
			tf.setnSelectionGroups(FMHelper.getAllFeaturesOf(f,"rhea.metamodels.BasicFMs.SelectionGroup").size());
			tf.setPercentageOfFeaturesType(Math.round((double) tf.numberOfFeaturesTypeBefore/(double) tf.nFeaturesBefore * 100d)/100d);
			
			//ONLY ON LITTLE MODELS
			//AutomatedAnalysisFM aafm = new AAFMClafer();
			//tf.setProductsBefore(aafm.products(f));
			
			// Full Transformation Block
			tf.setTimeBefore(System.nanoTime()/1e9);
			if(gcbr.executeRefactoring() && gcr.executeRefactoring()) System.out.println("Transformation applied sucessfully");
			tf.setTimeAfter(System.nanoTime()/1e9);
			
			//ONLY ON LITTLE MODELS
			//tf.setProductsAfter(aafm.products(f));
			
			//Get the information after the refactoring
			tf.setnFeaturesAfter(f.getFeatures().size());
			tf.setNumberOfFeaturesTypeAfter(gcr.getMatchingFeatures().size());
			
			result.add(tf);
		}
		
		//Save the file (optional)
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/" + output + "/" + fm.getName() + ".txt";
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(gcr.getFeatureModel()), outputFile);
		
		return result;
	}
}
