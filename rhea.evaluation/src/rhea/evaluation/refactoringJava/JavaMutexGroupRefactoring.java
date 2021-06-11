package rhea.evaluation.refactoringJava;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.refactoringJava.JavaMutexGroupRule;
import rhea.evaluation.refactorings.Refactoring;
import rhea.evaluation.refactorings.TransformationInformation;

public class JavaMutexGroupRefactoring extends Refactoring{

	public JavaMutexGroupRefactoring(FeatureModel featureModel) {
		super(featureModel);
		classPath = "rhea.metamodels.CardinalityBasedFMs.MutexGroup";
	}

	@Override
	public List<TransformationInformation> refactor(int times, String output) {
		List<TransformationInformation> result = new ArrayList<>();
		FeatureModel f;
		
		JavaMutexGroupRule mgr = new JavaMutexGroupRule(EcoreUtil.copy(fm), classPath);
		
		// The number of iterations
		for(int i = 0; i < times ; i++)
		{
			//Set the base state
			TransformationInformation tf = new TransformationInformation();
			f = EcoreUtil.copy(fm);
			mgr.setFeatureModel(f);
			
			//Get the information before the refactoring
			//TODO Extract this code, so only executed once, first time
			tf.setRun(i);
			tf.setInputModel(f.getName());
			tf.setnFeaturesBefore(f.getFeatures().size());
			tf.setNumberOfFeaturesTypeBefore(mgr.getMatchingFeatures().size());
			tf.setnConstraints(f.getCrosstreeconstraints().size());
			tf.setnOptionals(FMHelper.getAllOptionalFeatures(f).size());
			tf.setnMandatories(FMHelper.getAllMandatoryFeatures(f).size());
			tf.setnAlternativeGroups(FMHelper.getAllFeaturesOf(f,"rhea.metamodels.BasicFMs.AlternativeGroup").size());
			tf.setnSelectionGroups(FMHelper.getAllFeaturesOf(f,"rhea.metamodels.BasicFMs.SelectionGroup").size());
			tf.setPercentageOfFeaturesType(Math.round((double) tf.numberOfFeaturesTypeBefore/(double) tf.nFeaturesBefore * 100d)/100d);
			
			tf.setTimeBefore(System.nanoTime()/1e9);
			
			//Do the refactoring
			if(mgr.executeRefactoring()) System.out.println("Transformation applied sucessfully");
			
			//Get the information after the refactoring
			tf.setTimeAfter(System.nanoTime()/1e9);
			tf.setnFeaturesAfter(f.getFeatures().size());
			tf.setNumberOfFeaturesTypeAfter(mgr.getMatchingFeatures().size());
			
			result.add(tf);
		}
		
		//Save the file (optional)
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/" + output + "/" + fm.getName() + ".txt";
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(mgr.getFeatureModel()), outputFile);
		
		return result;
	}

}
