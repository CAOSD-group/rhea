package rhea.evaluation.refactoringHenshin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import rhea.Rhea;
import rhea.aafm.AAFMClafer;
import rhea.aafm.AutomatedAnalysisFM;
import rhea.evaluation.refactorings.Refactoring;
import rhea.evaluation.refactorings.TransformationInformation;
import rhea.generators.FMGenerator;
import rhea.generators.clafer.ToClafer;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;
import rhea.thirdpartyplugins.utils.Utils;
import rhea.transformations.engine.HenshinEngine;
import rhea.transformations.refactoringHenshin.HenshinGroupCardinalityBaseRule;
import rhea.transformations.refactoringHenshin.HenshinGroupCardinalityRule;
import rhea.transformations.refactoringHenshin.HenshinMutexGroupRule;
import rhea.transformations.refactoringJava.JavaMutexGroupRule;

public class HenshinMutexGroupRefactoring extends Refactoring{
	public HenshinMutexGroupRefactoring(FeatureModel fm) {
		super(fm);
	}
	
	public List<TransformationInformation> refactor(int times, String output) {
		List<TransformationInformation> result = new ArrayList<>();
		FeatureModel f;
		FMGenerator g = new ToClafer();
		TransformationInformation ti = new TransformationInformation();
		
		f = EcoreUtil.copy(fm);
		HenshinMutexGroupRule mgr = new HenshinMutexGroupRule(f);
		mgr.setDebugMode(true);
		mgr.executeTransformation();
		
		ti.setRun(-1);
		ti.setRulesExecuted(mgr.getMonitor().getSteps());
		ti.setRulesSuccessExecuted(mgr.getMonitor().getSuccessSteps());
		mgr.setDebugMode(false);
		
		result.add(ti);
		
		// Luego hacemos todas las execuciones para obtener los tiempos.
		for (int i = 0; i < times; i++) 
		{
			TransformationInformation tf = new TransformationInformation();
			f = EcoreUtil.copy(fm);
			mgr.setFeatureModel(f);
			
			ti = new TransformationInformation();
			tf.setRun(i);
			tf.setInputModel(f.getName());
			tf.setnFeaturesBefore(f.getFeatures().size());
			tf.setNumberOfFeaturesTypeBefore(FMHelper.getAllFeaturesOf(f, "rhea.metamodels.CardinalityBasedFMs.MutexGroup").size());
			tf.setnConstraints(f.getCrosstreeconstraints().size());
			tf.setnOptionals(FMHelper.getAllOptionalFeatures(f).size());
			tf.setnMandatories(FMHelper.getAllMandatoryFeatures(f).size());
			tf.setnAlternativeGroups(FMHelper.getAllFeaturesOf(f,"rhea.metamodels.BasicFMs.AlternativeGroup").size());
			tf.setnSelectionGroups(FMHelper.getAllFeaturesOf(f,"rhea.metamodels.BasicFMs.SelectionGroup").size());
			tf.setPercentageOfFeaturesType(Math.round((double) tf.numberOfFeaturesTypeBefore/(double) tf.nFeaturesBefore * 100d)/100d);
		
			tf.setTimeBefore(System.nanoTime()/1e9);
			
			// Full Transformation Block
			if(mgr.executeTransformation()) System.out.println("Transformation applied sucessfully");
			
			//Get the information after the refactoring
			tf.setTimeAfter(System.nanoTime()/1e9);
			tf.setnFeaturesAfter(f.getFeatures().size());
			tf.setNumberOfFeaturesTypeAfter(FMHelper.getAllFeaturesOf(f, "rhea.metamodels.CardinalityBasedFMs.GroupCardinality").size());
			
			result.add(tf);
		}
		
		//Save the file (optional)
		String outputFile = Rhea.OUTPUTS_DIR + "clafer/" + output + "/" + fm.getName() + ".txt";
		Utils.serialize(g.fm2text(mgr.getFeatureModel()), outputFile);
		
		return result;
	}
}