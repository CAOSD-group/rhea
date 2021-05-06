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
import rhea.evaluation.refactoringJava.JavaGroupCardinalityRefactoringTesting;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.helpers.FMHelper;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;

public class MainJava {
	public static boolean DEBUG = true;

	public static void main(String[] args) {
		String modelType = "GroupCardinality";
		String folderPath = Rhea.INPUTS_DIR + "clafer/" + modelType;
		
		List<TransformationInformation> tis = new ArrayList<>();
		List<FeatureModel> models = new ArrayList<>();
		File folder = new File(folderPath);
		
		FMParser fmp = new ClaferParser();

		for (File f: folder.listFiles()) 
		{
			models.add(fmp.readFeatureModel(f.getPath()));
		}
		
		for (FeatureModel featureModel : models) 
		{
			tis.addAll(new JavaGroupCardinalityRefactoringTesting(featureModel).testRefactoring(Rhea.EVALUATION_ITERATIONS));
			//tis.addAll(new JavaMutexGroupRefactoringTesting(featureModel).testRefactoring(Rhea.EVALUATION_ITERATIONS));
		}
		
		tis = sortTransformationInformation(tis);
		
		//Change (Todo en un único archivo, o un archivo por fm) TODO
		saveData(tis,modelType);
		processData(modelType);
	}

	private static void saveData(List<TransformationInformation> tis, String name)
	{
			try 
			{
				FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/Evaluation/" + name + "-raw.csv");
				fw.write("Run,nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,percentageOfFeaturesType,nContraints,nOptionals,nMandatories,nAlternativeGroups,nSelectionGroups,nRefactors,Time(s) \n");
				
				for (TransformationInformation ti : tis) {
						fw.write(ti.getRun() + "," + ti.getnFeaturesBefore() + "," + ti.getnFeaturesAfter() + "," + ti.getNumberOfFeaturesTypeBefore() + "," + ti.getNumberOfFeaturesTypeAfter() + ","
						+ ti.getPercentageOfFeaturesType() + "," + ti.getnConstraints() + "," + ti.getnOptionals() + "," + ti.getnMandatories() + "," + ti.getnAlternativeGroups() + "," + ti.getnSelectionGroups() + ","
						+ (ti.getNumberOfFeaturesTypeBefore() - ti.getNumberOfFeaturesTypeAfter()) + "," + ti.getPerformance() + "\n");
				}
				
				fw.close();
			} 
			catch (IOException e) {e.printStackTrace();}
	}
	
	private static void processData(String name)
	{
			try 
			{
				FileReader fr = new FileReader(Rhea.BASEDIR + "temp/Evaluation/" + name + "-raw.csv");
				BufferedReader bf = new BufferedReader(fr);
				FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/Evaluation/" + name + "-processed.csv");
				
				String run;
				double sd, mean, median;
				run=bf.readLine();
				
				fw.write("nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,percentageOfFeaturesType,nContraints,nOptionals,nMandatories,nAlternativeGroups,nSelectionGroups,nRefactors,mean(s),median(s),sd(s) \n");
				
				while(run!=null) 
				{
					
					sd=0;
					mean=0;
					median=0;
					
					double[] times = new double[Rhea.EVALUATION_ITERATIONS];
					
					for (int i=0; i<Rhea.EVALUATION_ITERATIONS; i++)
					{
							if((run=bf.readLine())!=null) times[i] = Double.parseDouble(run.substring(run.lastIndexOf(",")+1));
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