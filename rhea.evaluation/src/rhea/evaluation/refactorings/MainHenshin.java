package rhea.evaluation.refactorings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import rhea.Rhea;
import rhea.evaluation.refactoringHenshin.HenshinGroupCardinalityRefactoring;
import rhea.evaluation.refactoringHenshin.HenshinMutexGroupRefactoring;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;

public class MainHenshin {
	public static void main(String[] args) {
		String modelType = "Test";
		String folderPath = Rhea.INPUTS_DIR + "clafer/" + modelType;
		
		List<TransformationInformation> tis = new ArrayList<>();
		List<FeatureModel> models = new ArrayList<>();
		File folder = new File(folderPath);
		FMParser fmp = new ClaferParser();
		
		for (File f: folder.listFiles()) 
		{
			models.add(fmp.readFeatureModel(f.getPath()));
		}
		
		for (FeatureModel fm : models) {
			tis.addAll(new HenshinGroupCardinalityRefactoring(fm).refactor(Rhea.EVALUATION_ITERATIONS,modelType));
			//tis.addAll(new HenshinMutexGroupRefactoring(fm).refactor(Rhea.EVALUATION_ITERATIONS,modelType));
		}
		
		tis = sortTransformationInformation(tis);
		
		saveData(tis,"Henshin"+modelType);
		processData("Henshin"+modelType);
	}
	
	private static void saveData(List<TransformationInformation> tis, String inputName) {
		try 
		{
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/Evaluation/" + inputName + "-raw.csv");
			//fw.write("Run,nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,percentageOfFeaturesType,nProductsBefore,nProductsAfter,nConstraints,nOptionals,nMandatories,nAlternativeGroups,nSelectionGroups,nRefactors,nRulesSucessfullyExecuted,Time(s) \n");
			fw.write("Run,nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,percentageOfFeaturesType,nConstraints,nOptionals,nMandatories,nAlternativeGroups,nSelectionGroups,nRefactors,nRulesSucessfullyExecuted,Time(s) \n");
			
			int rulesSuccessExecuted=0, rulesExecuted=0;
			
			for (TransformationInformation ti : tis) {
				if (ti.getRun()==-1) {
					rulesSuccessExecuted = ti.getRulesSuccessExecuted();
					rulesExecuted = ti.getRulesExecuted();
				}
				else
				{
					fw.write(ti.getRun() + "," + ti.getnFeaturesBefore() + "," + ti.getnFeaturesAfter() + "," + ti.getNumberOfFeaturesTypeBefore() + "," + ti.getNumberOfFeaturesTypeAfter() + ","
					+ ti.getPercentageOfFeaturesType() + "," + ti.getnConstraints() + "," + ti.getnOptionals() + "," + ti.getnMandatories() + "," + ti.getnAlternativeGroups() + "," + ti.getnSelectionGroups() + ","
					+ (ti.getNumberOfFeaturesTypeBefore() - ti.getNumberOfFeaturesTypeAfter()) + "," + rulesSuccessExecuted + "," + ti.getPerformance() + "\n");
					
					/*fw.write(ti.getRun() + "," + ti.getnFeaturesBefore() + "," + ti.getnFeaturesAfter() + "," + ti.getNumberOfFeaturesTypeBefore() + "," + ti.getNumberOfFeaturesTypeAfter() + ","
					+ ti.getPercentageOfFeaturesType() + "," + ti.getProductsBefore().size() + "," + ti.getProductsAfter().size() + "," + ti.getnConstraints() + "," + ti.getnOptionals() + "," + ti.getnMandatories() + "," + ti.getnAlternativeGroups() + "," + ti.getnSelectionGroups() + ","
					+ (ti.getNumberOfFeaturesTypeBefore() - ti.getNumberOfFeaturesTypeAfter()) + "," + rulesSuccessExecuted + "," + ti.getPerformance() + "\n");*/
				}
			}
			fw.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	private static void processData(String inputName) {
		try 
		{
			FileReader fr = new FileReader(Rhea.BASEDIR + "temp/Evaluation/" + inputName + "-raw.csv");
			BufferedReader bf = new BufferedReader(fr);
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/Evaluation/" + inputName + "-processed.csv");
			
			//fw.write("nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,percentageOfFeaturesType,nProductsBefore,nProductsAfter,nConstraints,nOptionals,nMandatories,nAlternativeGroups,nSelectionGroups,nRefactors,nRulesSucessfullyExecuted,mean(s),median(s),sd(s) \n");
			fw.write("nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,percentageOfFeaturesType,nContraints,nOptionals,nMandatories,nAlternativeGroups,nSelectionGroups,nRefactors,nRulesSucessfullyExecuted,mean(s),median(s),sd(s) \n");
			
			String run;
			double sd, mean, median;
			run=bf.readLine();
			
			while(run!=null) {
				
				sd=0;
				mean=0;
				median=0;
				
				double[] times = new double[Rhea.EVALUATION_ITERATIONS];
				
				for (int i=0; i<Rhea.EVALUATION_ITERATIONS; i++)
				{
						if((run=bf.readLine())!=null) times[i] = Double.parseDouble(run.substring(run.lastIndexOf(",")+1));
						else break;
				}
				
				Arrays.sort(times);
				
				median = times[times.length/2];
				mean = Arrays.stream(times).sum()/times.length;
				
				double[] difs2 = new double[Rhea.EVALUATION_ITERATIONS];
				for (int i=0;i<times.length;i++) difs2[i] = Math.pow(times[i]-mean, 2);
				
				sd = Math.sqrt((Arrays.stream(difs2).sum())/times.length);
				
				if(run!=null) fw.write(run.substring(0,run.lastIndexOf(",")).substring(run.indexOf(",")+1) + "," + mean + "," + median + "," + sd + "\n");
			}
			fr.close();
			fw.close();
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	private static List<TransformationInformation> sortTransformationInformation(List<TransformationInformation> tis) {
		Comparator<TransformationInformation> comparator = Comparator.comparing(transformationInformation -> transformationInformation.nFeaturesBefore);
		comparator = comparator.thenComparing(transformationInformation -> transformationInformation.numberOfFeaturesTypeBefore);
		
		Stream<TransformationInformation> personStream = tis.stream().sorted(comparator);
	    return personStream.collect(Collectors.toList());
	}
}