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
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.parsers.FMParser;
import rhea.parsers.clafer.ClaferParser;

public class Main {
	public static boolean DEBUG = true;
	
	public static void main(String[] args) {
		
		String inputName = "gc005";
		
		// Adicional, necesario para GroupCardinalities.
		String inputFile = Rhea.CLAFER_INPUTS_DIR + "GroupCardinalities/" + inputName + ".txt";
		FMParser p = new ClaferParser();
		FeatureModel fm = p.readFeatureModel(inputFile);
		// End 
		
		//Parametros
		List<Refactoring> mds = new ArrayList<Refactoring>();
		//mds.add(new MutexGroupRefactoring(DEBUG));
		mds.add(new GroupCardinalitiesRefactoring(DEBUG));
		mds.add(new GroupCardinalitiesNMRefactoring(DEBUG,fm));
		
		List<String> fms = new ArrayList<String>();
		//fms.add("mutex001");
		fms.add(inputName);
		
		List<List<TransformationInformation>> tiss = new ArrayList<>();
		
		for (String model : fms) {
			tiss.add(new MainTest().run(model, mds));
		}
		
		saveData(tiss);
		processData();
	}
	
	private static void saveData(List<List<TransformationInformation>> tiss) {
		try 
		{
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/raw_data.csv");
			fw.write("Run,HenshinModule,HenshinUnits,inputModel,nFeatures,nRefactors,nRulesSucessExecuted, Time(ns) \n");
			
			for (List<TransformationInformation> tis : tiss) {
				int i = 1; // ¿Para todo los  GroupCardinalities o por un lado los casos base y por otro los NM?
				int rulesSuccessExecuted=0, rulesExecuted;
		
				for (TransformationInformation ti : tis) {
					if (ti.getRun()==-1) {
						rulesSuccessExecuted = ti.getRulesSuccessExecuted();
						rulesExecuted = ti.getRulesExecuted();
					}
					else
					{
						fw.write(ti.getRun() + "," + ti.getHenshinModule() + "," + ti.getHenshinUnits() + "," + ti.getInputModel() + "," + ti.getnFeatures() + "," 
					+ (ti.getNumberOfFeaturesTypeBefore() - ti.getNumberOfFeaturesTypeAfter()) + "," + rulesSuccessExecuted + "," + ti.getPerformance() + "\n");
					}
				}
				
			}
			fw.close();
		} 
		catch (IOException e) {e.printStackTrace();}
		
	}
	
	private static void processData() {
		try 
		{

			FileReader fr = new FileReader(Rhea.BASEDIR + "temp/raw_data.csv");
			BufferedReader bf = new BufferedReader(fr);
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/processed_data.csv");
			
			fw.write("HenshinModule,HenshinRule,inputModel,nFeatures,nRefactors,nRulesSucessExecuted,mean,median,sd \n");
			
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
