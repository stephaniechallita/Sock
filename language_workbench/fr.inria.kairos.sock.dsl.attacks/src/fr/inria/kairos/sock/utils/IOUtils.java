package fr.inria.kairos.sock.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.core.resources.ResourcesPlugin;

public class IOUtils {
	
	public static final String PATH_PROPERTIES = "sock.properties";
	
	public static final String NAME_PROPERTY_BASE_PATH_OUTPUT = "path.output";
	
	public static final String BASE_PATH_OUTPUT;
	
	static {
		final Properties sockProperties = Utils.getSockProperties();
		BASE_PATH_OUTPUT = sockProperties.getProperty(NAME_PROPERTY_BASE_PATH_OUTPUT);
	}
	
	public static String PATH_OUTPUT = "";
	
	public static final String NEW_LINE = System.lineSeparator();
	
	public static int get(List<String> list, int offset, int index) {
		
		final int indexInList = (list.size() - offset) < 0 ? 0 : list.size() - offset;
		if (indexInList >= list.size()) {
			return list.isEmpty() ? 0 : Integer.parseInt(list.get(indexInList - 1).split(" ")[index]);
		}
		return list.isEmpty() ? 0 : Integer.parseInt(list.get(indexInList).split(" ")[index]);
	}
	
	public static List<String> readFile(String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(BASE_PATH_OUTPUT + path))) {
			return reader.lines().collect(Collectors.toList());
		} catch (Exception ignored) {
		}
		return Collections.emptyList();
	}
	
	public static void write(int time, int toBeWritten, String path) {
		write(time, toBeWritten + "" , path);
	}
	
	public static void write(int time, String toBeWritten, String path) {
		writeRaw(time + " " + toBeWritten, path);
	}
	
	public static void writeRaw(String toBeWritten, String path) {
		try (FileWriter writer = new FileWriter(new File(BASE_PATH_OUTPUT + path), true)) {
			writer.write(toBeWritten + NEW_LINE);
		} catch (Exception ignored) {
		}
	}
	
	public static void initFolders(String outputFolderPath) {
		final File baseFolder = new File(BASE_PATH_OUTPUT);
		if (!baseFolder.exists()) {
			baseFolder.mkdirs();
		}
		final File outputFolder = new File(BASE_PATH_OUTPUT + "/" + outputFolderPath);
		if (outputFolder.exists()) {
			for (File file : outputFolder.listFiles()) {
				file.delete();
			}
			outputFolder.delete();
		}
		outputFolder.mkdirs();
	}
	
}
