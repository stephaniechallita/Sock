package fr.inria.kairos.sock.generator.example.groovy;

public class GroovyScriptCommon {
	
	public static String getReadAFileToAVariable(String path, String variable) {
		return GroovyScriptCommon.getReadAFileToAVariable(path, variable, false);
	}
	
	public static String getReadAFileToAVariable(String path, String variable, boolean hasAReader) {
		return  "		String " + variable + "Time = \"\";\n" + 
				"		String " + variable + " = \"\";\n" + 
				"		String " + variable + "2Time = \"\";\n" + 
				"		String " + variable + "2 = \"\";\n" + 
				(hasAReader ? "" : "		java.io.BufferedReader reader = null;\n") + 
				"		try {\n" + 
				"			reader = new java.io.BufferedReader(new java.io.FileReader(outputFolder + \"/" + path +"\"));\n" + 
				"			java.util.List<String> lines = reader.lines().collect(java.util.stream.Collectors.toList());\n" + 
				"			" + variable + "Time = lines.get(lines.size() - 1).split(\" \")[0];\n" +
				"			" + variable + " = lines.get(lines.size() - 1).split(\" \")[1];\n" +
				"			" + variable + "2Time = lines.get(lines.size() - 1).split(\" \")[0];\n" +
				"			" + variable + "2 = lines.get(lines.size() - 1).split(\" \")[1];\n" +
				"		} catch (Exception e) {\n" + 
				"		} finally {\n" + 
				"			if (reader != null) {\n" + 
				"				try {\n" + 
				"					reader.close();\n" + 
				"				} catch (Exception e) {\n" + 
				"					e.printStackTrace();\n" + 
				"				}\n" + 
				"			}\n" + 
				"		}\n";
	}
	
	public static String getWriterToFileAGivenVariable(String path, String variable) {
		return getWriterToFileAGivenVariable(path,variable, "time");
	}
	
	public static String getWriterToFileAGivenVariable(String path, String variable, String time) {
		return  "		java.io.FileWriter writer = null;\n" + 
				"		try {\n" + 
				"			writer = new java.io.FileWriter(new java.io.File(outputFolder + \"/" + path + "\"), true);\n" + 
				"			writer.write(" + time + "+ \" \" + " + variable + " + newLine);\n" + 
				"		} catch (Exception e) {\n" + 
				"		} finally {\n" + 
				"			if (writer != null) {\n" + 
				"				try {\n" + 
				"					writer.close();\n" + 
				"				} catch (Exception e) {\n" + 
				"					e.printStackTrace();\n" + 
				"				}\n" + 
				"			}\n" + 
				"		}\n";
	}

}
