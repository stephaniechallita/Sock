package fr.inria.kairos.sock.generator;

import java.util.List;
import java.util.stream.Collectors;

import fr.inria.kairos.sock.generator.model.IotSystem;

public class GeneratorHelper {
	
	public static final String PATH_OUTPUT = "/Users/stephaniechallita/Desktop/workspace-models-2020/modeling_workbench/test-project/";
	
	public static final String NEW_LINE = System.lineSeparator();
	
	public static List<IotSystem> computeUnschedulableSystems(List<IotSystem> systems, boolean withFlushTask) {
		return systems.stream()
				.filter(system -> ! system.isSchedulable(withFlushTask))
				.collect(Collectors.toList());
	}

}
