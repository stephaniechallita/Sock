package fr.inria.kairos.sock.generator.example;

import fr.inria.kairos.sock.generator.model.IotSystem;
import fr.inria.kairos.sock.generator.Generator;
import fr.inria.kairos.sock.generator.GeneratorHelper;
import fr.inria.kairos.sock.generator.Interval;
import fr.inria.kairos.sock.generator.io.SideChannelAttackReader;
import fr.inria.kairos.sock.generator.io.SideChannelAttackReader.Result;
import fr.inria.kairos.sock.generator.io.SockWriter;
import fr.inria.kairos.sock.generator.launch.LaunchGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainScheduLeak {
	
	private static int NB_CONFIGURATION = 10;

	private static int minNbActor = 3;

	private static int maxNbActor = 6;

	private static int minPeriodTime = 5;

	private static int maxPeriodTime = 50;

	private static int stepPeriodTime = 5;

	private static int minProcessTime = 1;

	private static int maxProcessTime = 5;
	
	private static int maxHyperPeriod = 250;
	
	private static final Random random = new Random(32L);
	
	private static final Interval interval = new Interval(0.6d, 0.8d);
	
	private static SockWriter writer;
	
	static {
		new File(GeneratorHelper.PATH_OUTPUT + "schedule_side_channel_attacks/").delete();
		new File(GeneratorHelper.PATH_OUTPUT + "schedule_side_channel_attacks/").mkdirs();
		new File(GeneratorHelper.PATH_OUTPUT + "schedule_side_channel_attacks/launch/").mkdirs();
	}
	
	private static final LaunchGenerator launchGenerator = new LaunchGenerator();
	private static final List<Result[]> resultForEachSystem = new ArrayList<>();

	public static void main(String[] args) {
		writer = new SockWriter(GeneratorHelper.PATH_OUTPUT + "schedule_side_channel_attacks/");
		generateForNbActor(1, 10);
		Collections.sort(resultForEachSystem, new Comparator<Result[]>() {
			@Override
			public int compare(Result[] a, Result[] b) {
				return (int) (a[0].toPerc() - b[0].toPerc());
			}
		});
		final Result medianMatchingOriginal = resultForEachSystem.get(resultForEachSystem.size() / 2)[0];
		Collections.sort(resultForEachSystem, new Comparator<Result[]>() {
			@Override
			public int compare(Result[] a, Result[] b) {
				return (int) (a[1].toPerc() - b[1].toPerc());
			}
		});
		final Result medianMatchingRandom = resultForEachSystem.get(resultForEachSystem.size() / 2)[1];
		System.out.println("\\midrule");
		System.out.println(Arrays.stream(new String[] {
				NB_CONFIGURATION + "",
				"",
				"",
				medianMatchingOriginal + "",
				medianMatchingRandom  + ""
		}).collect(Collectors.joining("\t&\t")));
//		System.out.println("Generation of " + NB_CONFIGURATION + " tsock model successful");
	}
	
	public static void generateForNbActor(int nbActor, int nbConfiguration) {
		for (int i = 0; i < nbConfiguration; i++) {
			final Generator generator = new Generator(random, minPeriodTime, maxPeriodTime, stepPeriodTime, minProcessTime,
					maxProcessTime, minNbActor, maxNbActor);
			final IotSystem system = new IotSystem("GenSystScheduLeak" + resultForEachSystem.size());
			generator.initSystemWithGivenBoundForResource(interval, system, true);
			if (new ArrayList<>(system.getOwnedResource()).get(0).getHyperPeriod() > maxHyperPeriod) {
//				System.out.println(new ArrayList<>(system.getOwnedResource()).get(0).getHyperPeriod());
				--i;
				continue;
			}
			writer.write(system.getName(), system);
			writer.write("launch/" + system.getName() + SockWriter.LAUNCH_EXTENSION,
					launchGenerator.generateLaunchConfiguration(
							"/test-project/schedule_side_channel_attacks/" + system.getName() + SockWriter.TSOCK_EXTENSION, false));
			system.setName(system.getName() + "rnd");
			writer.write(system.getName(), system);
			writer.write("launch/" + system.getName() + SockWriter.LAUNCH_EXTENSION,
					launchGenerator.generateLaunchConfiguration(
							"/test-project/schedule_side_channel_attacks/" + system.getName() + SockWriter.TSOCK_EXTENSION, true));
//			writer.write(system.getName(), system);
			system.setName("GenSystScheduLeak" + i);
//			System.out.println(system.getOwnedResource().get(0).getHyperPeriod());
			System.out.println(system.toLatex());
			resultForEachSystem.add(SideChannelAttackReader.readResultFor(system));
//			system.setName("s" + i);
		}
	}
	

}
