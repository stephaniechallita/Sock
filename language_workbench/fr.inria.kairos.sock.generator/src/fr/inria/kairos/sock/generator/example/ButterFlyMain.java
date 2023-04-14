package fr.inria.kairos.sock.generator.example;

import java.io.File;
import java.util.ArrayList;

import fr.inria.kairos.sock.generator.GeneratorHelper;
import fr.inria.kairos.sock.generator.example.groovy.DCMotorGroovy;
import fr.inria.kairos.sock.generator.example.groovy.VehiculePositionningGroovy;
import fr.inria.kairos.sock.generator.io.SockWriter;
import fr.inria.kairos.sock.generator.launch.LaunchGenerator;
import fr.inria.kairos.sock.generator.model.Actor;
import fr.inria.kairos.sock.generator.model.IotSystem;
import fr.inria.kairos.sock.generator.model.Resource;

public class ButterFlyMain {

	private static final String folder = "butterfly";
	
	public static void main(String[] args) {
		new File(GeneratorHelper.PATH_OUTPUT + folder + "/").delete();
		new File(GeneratorHelper.PATH_OUTPUT + folder + "/").mkdirs();
		new File(GeneratorHelper.PATH_OUTPUT + folder + "/launch/").mkdirs();
		Actor.flushTaskCost = 1;
		final SockWriter writer = new SockWriter(GeneratorHelper.PATH_OUTPUT +  folder + "/");
		final IotSystem[] butterflySystems = new IotSystem[] {
			createDisabledButterfly(),
			createEnabledButterfly(),
//			createCounteredEnabledButterfly()
		};
		for (IotSystem system : butterflySystems) {
			System.out.println(system.isSchedulable(true));
			System.out.println(new ArrayList<>(system.getOwnedResource()).get(0).getBound());
			system.getOwnedActor().stream()
					.forEach(actor -> System.out.println(actor.getName() + " " + actor.getScore(true)));
			System.out.println(
					system.getOwnedActor().stream().map(actor -> actor.getScore(true)).reduce((acc, actor) -> acc + actor));
			writer.write(system.getName(), system);
			writer.write("/launch/"  + system.getName() + SockWriter.LAUNCH_EXTENSION, new LaunchGenerator().generateLaunchConfiguration(
					"/test-project/" +  folder + "/" + system.getName() + SockWriter.TSOCK_EXTENSION, false));
		}
	}
	
	public static IotSystem createDisabledButterfly() {
		final IotSystem system = new IotSystem("DisabledButterFly");
		final Resource resource = new Resource("CPU");
		system.getOwnedResource().add(resource);
		system.getOwnedActor().add(new Actor("ControllerVehiculePositionning", 0, 7, 15, resource, VehiculePositionningGroovy.getVehiculePositionningGroovyScript()));
		system.getOwnedActor().add(new Actor("DCMotor", 0, 3, 30, resource, DCMotorGroovy.getDCMotorGroovyScript()));
		resource.getActors().addAll(system.getOwnedActor());
//		system.getOwnedActor().add(new Actor("Dummy", 0, 1, 15, resource));
		return system;
	}
	
	public static IotSystem createEnabledButterfly() {
		final IotSystem system = new IotSystem("EnabledButterFly");
		final Resource resource = new Resource("CPU");
		system.getOwnedResource().add(resource);
		system.getOwnedActor().add(new Actor("ControllerVehiculePositionning", 0, 7, 60, resource, VehiculePositionningGroovy.getVehiculePositionningGroovyScript()));
		system.getOwnedActor().add(new Actor("DCMotor", 0, 3, 30, resource, DCMotorGroovy.getDCMotorGroovyScript()));
		resource.getActors().addAll(system.getOwnedActor());
		return system;
	}
	
	public static IotSystem createCounteredEnabledButterfly() {
		final IotSystem system = new IotSystem("EnabledButterFly");
		final Resource resource = new Resource("CPU");
		system.getOwnedResource().add(resource);
		system.getOwnedActor().add(new Actor("ControllerVehiculePositionning", 0, 7, 60, resource, VehiculePositionningGroovy.getVehiculePositionningGroovyScript()));
		system.getOwnedActor().add(new Actor("DCMotor", 0, 3, 30, resource, DCMotorGroovy.getDCMotorGroovyScript()));
		system.getOwnedActor().add(new Actor("Dummy", 0, 1, 15, resource));
		resource.getActors().addAll(system.getOwnedActor());
		return system;
	}
}
