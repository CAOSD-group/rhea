package rhea.evaluation.refactorings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rhea.Rhea;
import rhea.evaluation.refactoringHenshin.GroupCardinalitiesNMRefactoring;
import rhea.evaluation.refactoringHenshin.GroupCardinalitiesRefactoring;
import rhea.evaluation.refactoringHenshin.MainTest;
import rhea.evaluation.refactoringHenshin.Refactoring;

public class MainHenshin {
	public static boolean DEBUG = true;

	
	public static void main(String[] args) {
		String inputName = "fm";
		
		//Par�metros
		List<Refactoring> mds = new ArrayList<Refactoring>();
		//mds.add(new MutexGroupRefactoring(DEBUG));
		mds.add(new GroupCardinalitiesRefactoring(DEBUG));
		mds.add(new GroupCardinalitiesNMRefactoring(DEBUG));
		
		List<String> fms = new ArrayList<String>();
		fms.add(inputName);
		
		List<List<TransformationInformation>> tiss = new ArrayList<>();
		
		for (String model : fms) {
			tiss.add(new MainTest().run(model, mds));
		}
		
		saveData(tiss,inputName);
		processData(inputName);
	}
	
	private static void saveData(List<List<TransformationInformation>> tiss, String inputName) {
		try 
		{
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/" + inputName + "-raw.csv");
			fw.write("Run,HenshinModule,HenshinUnits,inputModel,nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,nRefactors,nRulesSucessExecuted, Time(ns) \n");
			
			for (List<TransformationInformation> tis : tiss) {
				int rulesSuccessExecuted=0, rulesExecuted=0;
		
				for (TransformationInformation ti : tis) {
					if (ti.getRun()==-1) {
						rulesSuccessExecuted = ti.getRulesSuccessExecuted();
						rulesExecuted = ti.getRulesExecuted();
					}
					else
					{
						fw.write(ti.getRun() + "," + ti.getHenshinModule() + "," + ti.getHenshinUnits() + "," + ti.getInputModel() + "," + ti.getnFeaturesBefore() + "," 
						+ ti.getnFeaturesAfter() + "," + ti.getNumberOfFeaturesTypeBefore() + "," + ti.getNumberOfFeaturesTypeAfter() + "," 
						+ (ti.getNumberOfFeaturesTypeBefore() - ti.getNumberOfFeaturesTypeAfter()) + "," + rulesSuccessExecuted + "," + ti.getPerformance() + "\n");
					}
				}
			}
			fw.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	private static void processData(String inputName) {
		try 
		{
			FileReader fr = new FileReader(Rhea.BASEDIR + "temp/" + inputName + "-raw.csv");
			BufferedReader bf = new BufferedReader(fr);
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/" + inputName + "-processed.csv");
			
			fw.write("HenshinModule,HenshinRule,inputModel,nFeaturesBefore,nFeaturesAfter,nFeaturesTypeBefore,nFeaturesTypeAfter,nRefactors,nRulesSucessExecuted,mean,median,sd \n");
			
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