package fr.inria.kairos.sock.generator.launch;

import java.util.Arrays;
import java.util.stream.Collectors;

import fr.inria.kairos.sock.generator.io.SockWriter;

public class LaunchGenerator {
	
	public LaunchGenerator() {
		
	}

	private static final String HEADER_LAUNCH_CONFIGURATION = 
			Arrays.stream(new String[] {
					"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>",
					"<launchConfiguration type=\"org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher\">",
					"<booleanAttribute key=\"Concurrent\" value=\"false\"/>",
					"<booleanAttribute key=\"Do Exhaustive Simulation\" value=\"false\"/>",
					"<intAttribute key=\"GEMOC_ANIMATE_DELAY\" value=\"0\"/>",
					"<stringAttribute key=\"GEMOC_LAUNCH_INITIALIZATION_ARGUMENTS\" value=\"\"/>",
					"<stringAttribute key=\"GEMOC_LAUNCH_INITIALIZATION_METHOD\" value=\"\"/>",
					"<stringAttribute key=\"GEMOC_LAUNCH_SELECTED_LANGUAGE\" value=\"fr.inria.kairos.sock.Sock\"/>",
					"<booleanAttribute key=\"General\" value=\"false\"/>",
					"<booleanAttribute key=\"Generic MultiDimensional Trace\" value=\"false\"/>",
					"<booleanAttribute key=\"MultiBranch Reflective Trace\" value=\"false\"/>",
					"<stringAttribute key=\"TIMEMODEL_PATH\" value=\"\"/>",
					"<booleanAttribute key=\"VCD visualization\" value=\"false\"/>",
					"<stringAttribute key=\"airdResource\" value=\"\"/>"
			}).collect(Collectors.joining(SockWriter.NEW_LINE));
	
	private static final String FOOTER_LAUNCH_CONFIGURATION = "</launchConfiguration>";
	
	private static final String CONFIGURATION_PATH_TO_SOCK_MODEL = "<stringAttribute key=\"Resource\" value=\"";
	
	private static final String CLOSING_CONFIGURATION = "\"/>";
	
	private static final String CONFIGURATION_DECIDER = "<stringAttribute key=\"GEMOC_LAUNCH_SELECTED_DECIDER\" value=\"";
	
	private static final String RANDOM_SOCK_DECIDER_KEY = "Random Sock decider";
			
	private static final String SOCK_DECIDER_KEY = "Sock decider";
	
	public String generateLaunchConfiguration(String pathToModel, boolean random) {
		return HEADER_LAUNCH_CONFIGURATION + SockWriter.NEW_LINE +
				CONFIGURATION_DECIDER + (random ? RANDOM_SOCK_DECIDER_KEY : SOCK_DECIDER_KEY) + CLOSING_CONFIGURATION + SockWriter.NEW_LINE +
				CONFIGURATION_PATH_TO_SOCK_MODEL + pathToModel + CLOSING_CONFIGURATION + SockWriter.NEW_LINE +
				FOOTER_LAUNCH_CONFIGURATION;
	}
	
}
