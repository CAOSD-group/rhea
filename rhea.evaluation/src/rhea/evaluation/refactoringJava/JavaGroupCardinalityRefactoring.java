package rhea.evaluation.refactoringJava;

import rhea.Rhea;
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
	public List<TransformationInformation> refactor(int times) {
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
			//TODO Extract this code, so only executed once, first time
			tf.setRun(i);
			tf.setInputModel(fm.getName());
			tf.setnFeaturesBefore(fm.getFeatures().size());
			tf.setNumberOfFeaturesTypeBefore(gcr.getMatchingFeatures().size());
			tf.setnConstraints(fm.getCrosstreeconstraints().size());
			tf.setnOptionals(FMHelper.getAllOptionalFeatures(fm).size());
			tf.setnMandatories(FMHelper.getAllMandatoryFeatures(fm).size());
			tf.setnAlternativeGroups(FMHelper.getAllFeaturesOf(fm,"rhea.metamodels.BasicFMs.AlternativeGroup").size());
			tf.setnSelectionGroups(FMHelper.getAllFeaturesOf(fm,"rhea.metamodels.BasicFMs.SelectionGroup").size());
			tf.setPercentageOfFeaturesType(Math.round((double) tf.numberOfFeaturesTypeBefore/(double) tf.nFeaturesBefore * 100d)/100d);
			
			tf.setTimeBefore(System.nanoTime()/1e9);
			
			//Do the refactoring
			if(gcbr.executeRefactoring() && gcr.executeRefactoring()) System.out.println("Transformation applied sucessfully");
			
			//Get the information after the refactoring
			tf.setTimeAfter(System.nanoTime()/1e9);
			tf.setnFeaturesAfter(fm.getFeatures().size());
			tf.setNumberOfFeaturesTypeAfter(gcr.getMatchingFeatures().size());
			
			result.add(tf);
		}
		
		//Save the file (optional)
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/GroupCardinality/" + fm.getName() + ".txt";
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(gcr.getFeatureModel()), outputFile);
		
		return result;
	}
}
