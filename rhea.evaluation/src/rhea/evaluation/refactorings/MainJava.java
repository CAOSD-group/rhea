package rhea.evaluation.refactorings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import rhea.Rhea;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;

public class MainJava {
	public static boolean DEBUG = true;

	public static void main(String[] args) {
		String modelType = "GroupCardinalities";
		String classPath = "rhea.metamodels.CardinalityBasedFMs.GroupCardinality";
		
		List<List<TransformationInformation>> tiss = new ArrayList<>();
		List<FeatureModel> models = new ArrayList<>();
		List<String> inputModels = new ArrayList<>();
		inputModels.add("fm");
		inputModels.add("fm2");
		
		FMParser fmp = new ClaferParser();
		
		for (String string : inputModels) 
		{
			String inputFile = Rhea.INPUTS_DIR + "clafer/" + modelType + "/" + string + ".txt";
			models.add(fmp.readFeatureModel(inputFile));
		}
		
		for (FeatureModel featureModel : models) tiss.add(new JavaGroupCardinalityRefactoringTesting(featureModel).testRefactoring(Rhea.EVALUATION_ITERATIONS));
		
		saveData(tiss,inputModels);
		processData(inputModels);
	}
	
	private static void saveData(List<List<TransformationInformation>> tiss, List<String> inputModels)
	{
		for (String string : inputModels) 
		{
			try 
			{
				FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/" + string + "-raw.csv");
				fw.write("Run,nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,nRefactors,Time(ns) \n");
				
				for (List<TransformationInformation> tis : tiss) {
					for (TransformationInformation ti : tis) {
							fw.write(ti.getRun() + "," + ti.getnFeaturesBefore() + "," + ti.getnFeaturesAfter() + "," + ti.getNumberOfFeaturesTypeBefore() + "," + ti.getNumberOfFeaturesTypeAfter() + "," 
							+ (ti.getNumberOfFeaturesTypeBefore() - ti.getNumberOfFeaturesTypeAfter()) + "," + ti.getPerformance() + "\n");
					}
				}
				fw.close();
			} 
			catch (IOException e) {e.printStackTrace();}
		}
	}
	
	private static void processData(List<String> inputModels)
	{
		for (String string : inputModels)
		{
			try 
			{
				FileReader fr = new FileReader(Rhea.BASEDIR + "temp/" + string + "-raw.csv");
				BufferedReader bf = new BufferedReader(fr);
				FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/" + string + "-processed.csv");
				
				fw.write("nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,nRefactors,mean,median,sd \n");
				
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
	}
}