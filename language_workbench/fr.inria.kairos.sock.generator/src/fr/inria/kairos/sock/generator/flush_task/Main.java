package fr.inria.kairos.sock.generator.flush_task;

import fr.inria.kairos.sock.generator.model.Actor;
import fr.inria.kairos.sock.generator.model.IotSystem;
import fr.inria.kairos.sock.generator.Generator;
import fr.inria.kairos.sock.generator.GeneratorHelper;
import fr.inria.kairos.sock.generator.Interval;

import java.util.List;
import java.util.Random;
import java.util.Map;

public class Main {

	private final static int NB_SEEDS = 30;
	
	private final static Random GLOBAL_RANDOM = new Random(23L);

	public static void main(String[] args) {
		final int[] flushTaskCosts = new int[]{1, 5, 10};
		for (int flushTaskCost : flushTaskCosts) {
			Actor.flushTaskCost = flushTaskCost;
			computeForAGivenTaskCost();
		}
	}
	
	private static void computeForAGivenTaskCost() {
		final Map<Interval, List<IotSystem>> globalClassification = Interval.initInterval();
		for (int indexSeed = 0; indexSeed < NB_SEEDS; indexSeed++) {
			final Map<Interval, List<IotSystem>> classification = Interval.initInterval();
			final int nbSystemPerInterval = 200;
			for (Interval interval : classification.keySet()) {
				List<IotSystem> systems = new Generator(new Random(GLOBAL_RANDOM.nextInt()))
						.generateSystemsWithGivenBaseUtilization(nbSystemPerInterval, interval);
				classification.get(interval).addAll(systems);
				globalClassification.get(interval).addAll(systems);
			}
		}
		for (Interval interval : globalClassification.keySet()) {
			final List<IotSystem> unschedulableSystems = GeneratorHelper
					.computeUnschedulableSystems(globalClassification.get(interval), true);
			double percUnschedulable = (double) unschedulableSystems.size() / (double) globalClassification.get(interval).size();
			double percSchedulable = (double) (globalClassification.get(interval).size() - unschedulableSystems.size()) / (double) globalClassification.get(interval).size();
//			System.out.println(interval + " / " + String.format("%.2f", percUnschedulable) + " / " + String.format("%.2f", percSchedulable));
			System.out.println(interval.toDot() + " " + String.format("%.2f", percSchedulable));
		}
	}

}
