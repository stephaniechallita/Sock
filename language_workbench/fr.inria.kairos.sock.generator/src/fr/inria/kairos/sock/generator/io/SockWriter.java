package fr.inria.kairos.sock.generator.io;

import java.io.FileWriter;
import java.io.IOException;

import fr.inria.kairos.sock.generator.model.IotSystem;

public class SockWriter {
	
	public static final String NEW_LINE = System.lineSeparator();
	
	private final String outputPath;
	
	public static final String TSOCK_EXTENSION = ".tsock";
	
	public static final String LAUNCH_EXTENSION = ".launch";
	
	public SockWriter(String outputPath) {
		this.outputPath = outputPath;
	}
	
	public void write(String fileName, IotSystem system) {
		this.write(fileName + TSOCK_EXTENSION, system.toTSock());
	}
	
	public void write(String fileName, String toBeWritten) {
		try (FileWriter writer = new FileWriter(this.outputPath + "/" + fileName , false)) {
			writer.write(toBeWritten);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
