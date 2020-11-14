package rhea.thirdpartyplugins.utils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Utils {

	/**
	 * Read a file as a list of strings.
	 * 
	 * @param filepath	Filepath.
	 * @return			List of strings.
	 */
	public static List<String> readFile(String filepath) {
		Path path = Paths.get(filepath);
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
	/**
	 * Read a JSON file as a map object.
	 * 
	 * @param filepath	Filepath.
	 * @return			Map object with the contents.
	 */
	public static Map<?,?> readJsonFile(String filepath) {
		Map<?,?> map = new HashMap<Object,Object>();
		
		try {
			// create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(filepath));

		    // convert JSON file to map
		    map = gson.fromJson(reader, Map.class);

		    // close reader
		    reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * Execute a command line process.
	 *  
	 * @param directory		Working directory
	 * @param arguments		Program to be execute with arguments.
	 */
	public static void runCLI(File directory, String... arguments) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command(arguments);
		processBuilder.directory(directory);
		
		try {			
			Process process = processBuilder.start();

			int exitVal = process.waitFor();
			if (exitVal != 0) {
				System.out.print("Error! running ");
				for (String arg : arguments) {
					System.out.print(arg + " ");	
				}
				System.out.println();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	 /**
     * Clean up a directory by removing all its files.
     * 
     * @param baseDir	Base dir.
     * @param folder	Folder name to be cleaned.
     */
	public static void cleanUp(String folder) {
		try {
			Path resourceSetRoot = Paths.get(folder);
			File file = resourceSetRoot.toFile();
		
			if(file.exists()) {
				Files.walk(file.toPath())
				    .sorted(Comparator.reverseOrder())
				    .map(Path::toFile)
				    .forEach(File::delete);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
