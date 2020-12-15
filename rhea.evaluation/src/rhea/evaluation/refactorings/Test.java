package rhea.evaluation.refactorings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.opentest4j.AssertionFailedError;
import rhea.Rhea;

public class Test {

	final static int NUMBER_OF_ITERATIONS = 2;
	
	public static void main(String[] args) {
		
		getData();
		processData();
		
	}
	
	public static void getData() {
		String[] featureModels = {"gc001", "gc002"};
			
		try 
		{
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/raw_data.csv");
			fw.write("run,method,rule,inputModel,nFeatures,nRefactors,nTime \n");
			var run = 1;
			
			for (String fm : featureModels) 
			{
				for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) 
				{
					fw.write(run+"," + GroupCardinalitiesTest.cardinalitiesGroup(fm) + "\n");
					run++;
				}
			}
			fw.close();
		} 
		catch (IOException e) {e.printStackTrace();}
		catch (AssertionFailedError e) {System.err.println("No cumple las propiedades");}
	}
	
	public static void processData() {
		
		try 
		{

			FileReader fr = new FileReader(Rhea.BASEDIR + "temp/raw_data.csv");
			BufferedReader bf = new BufferedReader(fr);
			FileWriter fw = new FileWriter(Rhea.BASEDIR + "temp/processed_data.csv");
			
			fw.write("method,rule,inputModel,nFeatures,nRefactors,mean,median,sd \n");
			
			String run;
			double sd, mean, median;
			run=bf.readLine();
			
			while(run!=null) {
				
				sd=0;
				mean=0;
				median=0;
				
				double[] times = new double[NUMBER_OF_ITERATIONS];
				
				for (int i=0; i<NUMBER_OF_ITERATIONS; i++)
				{
						if((run=bf.readLine())!=null) times[i] = Double.parseDouble(run.substring(run.lastIndexOf(",")+1));
						else break;
				}
				
				Arrays.sort(times);
				
				median = times[times.length/2];
				mean = Arrays.stream(times).sum()/times.length;
				
				double[] difs2 = new double[NUMBER_OF_ITERATIONS];
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
