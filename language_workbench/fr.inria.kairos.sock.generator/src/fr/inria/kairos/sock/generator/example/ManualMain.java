package fr.inria.kairos.sock.generator.example;

import java.io.File;
import java.util.Random;

import fr.inria.kairos.sock.generator.GeneratorHelper;
import fr.inria.kairos.sock.generator.io.SockWriter;
import fr.inria.kairos.sock.generator.launch.LaunchGenerator;
import fr.inria.kairos.sock.generator.model.Actor;
import fr.inria.kairos.sock.generator.model.IotSystem;
import fr.inria.kairos.sock.generator.model.Resource;

public class ManualMain {
	
	private static final String folder = "manual";

	public static void main(String[] args) {
		new File(GeneratorHelper.PATH_OUTPUT + folder + "/").delete();
		new File(GeneratorHelper.PATH_OUTPUT + folder + "/").mkdirs();
		new File(GeneratorHelper.PATH_OUTPUT + folder + "/launch/").mkdirs();
		final SockWriter writer = new SockWriter(GeneratorHelper.PATH_OUTPUT +  folder + "/");
		Actor.flushTaskCost = 1;
		final IotSystem system = new IotSystem("sockExample");
		final Resource resource = new Resource("r");
		system.getOwnedResource().add(resource); 
		system.getOwnedActor().add(
				new Actor("a", 1, 4, 25, resource)
		);
		
		system.getOwnedActor().add(
				new Actor("b", 0, 7, 35, resource)
		);
		system.getOwnedActor().add(
				new Actor("c", 0, 1, 15, resource)
		);
		
		System.out.println(system.isSchedulable(true));
		System.out.println(resource.getBound());
		system.getOwnedActor().stream()
			.forEach(actor -> System.out.println(actor.getName() + " " + actor.getScore(true)));
		System.out.println(system.getOwnedActor().stream().map(actor -> actor.getScore(true)).reduce((acc, actor) -> acc + actor));
		writer.write(system.getName(), system);
		writer.write("/launch/"  + system.getName() + SockWriter.LAUNCH_EXTENSION, new LaunchGenerator().generateLaunchConfiguration(
				"/test-project/" +  folder + "/" + system.getName() + SockWriter.TSOCK_EXTENSION, false));
	}
	

}
