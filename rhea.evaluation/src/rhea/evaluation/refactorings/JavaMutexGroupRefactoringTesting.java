package rhea.evaluation.refactorings;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import rhea.Rhea;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.refactorings.MutexGroupRefactoring;

public class JavaMutexGroupRefactoringTesting extends JavaRefactoringTesting{

	public JavaMutexGroupRefactoringTesting(FeatureModel featureModel) {
		super(featureModel);
		classPath = "rhea.metamodels.CardinalityBasedFMs.MutexGroup";
	}

	@Override
	public List<TransformationInformation> testRefactoring(int times) {
		List<TransformationInformation> result = new ArrayList<>();
		FeatureModel f;
		
		MutexGroupRefactoring mgr = new MutexGroupRefactoring(EcoreUtil.copy(fm), classPath);
		
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
			tf.setInputModel(fm.getName());
			tf.setnFeaturesBefore(fm.getFeatures().size());
			tf.setNumberOfFeaturesTypeBefore(mgr.getMatchingFeatures().size());
			tf.setnConstraints(fm.getCrosstreeconstraints().size());
			tf.setnOptionals(FMHelper.getAllOptionalFeatures(fm).size());
			tf.setnMandatories(FMHelper.getAllMandatoryFeatures(fm).size());
			tf.setnAlternativeGroups(FMHelper.getAllFeaturesOf(fm,"rhea.metamodels.BasicFMs.AlternativeGroup").size());
			tf.setnSelectionGroups(FMHelper.getAllFeaturesOf(fm,"rhea.metamodels.BasicFMs.SelectionGroup").size());
			
			tf.setTimeBefore(System.nanoTime()/1e9);
			
			//Do the refactoring
			if(mgr.executeRefactoring()) System.out.println("Transformation applied sucessfully");
			
			//Get the information after the refactoring
			tf.setTimeAfter(System.nanoTime()/1e9);
			tf.setnFeaturesAfter(fm.getFeatures().size());
			tf.setNumberOfFeaturesTypeAfter(mgr.getMatchingFeatures().size());
			
			result.add(tf);
		}
		
		//Save the file (optional)
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/MutexGroup/" + fm.getName() + ".txt";
		FMGenerator g = new ToClafer();
		Utils.serialize(g.fm2text(mgr.getFeatureModel()), outputFile);
		
		return result;
	}

}
