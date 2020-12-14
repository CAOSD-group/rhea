package rhea.thirdpartyplugins.utils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

/**
 * Utils to facilitate the usage of third-party plugins.
 * 
 * @author Jose-Miguel Horcas
 * 
 */
public class Utils {
	
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
	 * Serialize the contents of the string in a file.
	 * 
	 * @param contents		Content in a string format.
	 * @param filepath		File path.
	 */
	public static void serialize(String contents, String filepath) {
		Path path = Paths.get(filepath);
		try {
			if (!Files.exists(path)) {
				Files.createDirectories(path.getParent());
				Files.createFile(path);
			} else {
				Files.deleteIfExists(path);
			}
			Files.write(path, contents.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Remove comments and blank lines from the source code contents.
	 * 
	 * @param lines		Source code content as list of strings.
	 * @param comments	Character used for comments.
	 * @return
	 */
	public static List<String> cleanSourceCode(List<String> lines, String comments) {
		// Remove line comments and blank lines
		lines = lines.stream().filter(l -> !l.startsWith(comments) && !l.isBlank()).collect(Collectors.toList());
		
		// Remove rest of comments
		lines = lines.stream().map(l -> l.contains(comments) ? l.substring(0, l.indexOf(comments)) : l).collect(Collectors.toList());
		
		return lines;
	}
	
	/**
	 * Build a map with the indentation for each line.
	 * 
	 * @param lines		Source code content as list of strings.
	 * @return			Map with the indentations per line (line -> tabs).
	 */
	public static Map<Integer, Integer> getIndentationMap(List<String> lines) {
		var indentations = new HashMap<Integer, Integer>();			
		int n = 0;
		for (String line : lines) {
			int tabs = getIndentation(line);
			indentations.put(n, tabs);
			n++;
		}
		return indentations;
	}
	
	/**
	 * Count the indentations (tabs) for a string line.
	 * 
	 * @param line	String line.
	 * @return		Number of indentations (tabs).
	 */
	public static int getIndentation(String line) {
		Pattern r = Pattern.compile("([\t]+)");	
		Matcher m = r.matcher(line);
		
		int tabs = 0;
		if (m.find()) {
			tabs = m.group(1).length();
		}
		return tabs;
	}
	
	/**
	 * Execute a command line process.
	 *  
	 * @param directory		Working directory
	 * @param arguments		Program to be execute with arguments.
	 */
	public static void runCLI(File directory, String... arguments) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.directory(directory);
		processBuilder.command(arguments);
		
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
			//e.printStackTrace();
		}		
	}
	
	 /**
     * Clean up a directory by removing all its files.
     * 
     * @param baseDir	Base dir.
     * @param folder	Folder name to be cleaned.
     */
	public static void cleanDirectory(String folder) { 
		try {
			Path resourceSetRoot = Paths.get(folder);
			File file = resourceSetRoot.toFile();
			
			if(file.exists()) {
				FileUtils.cleanDirectory(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
