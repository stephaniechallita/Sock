package org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;

public class SockDeciderHelper {

	public static final Random RAND = new Random(23L);

	public static final String NEW_LINE = System.lineSeparator();

	public static String getEntityNameFromClockName(String clockName) {
		return clockName.split("_")[1];
	}

	public static Step<?> returnRandomOne(List<Step<?>> possibleLogicalSteps) {
		return possibleLogicalSteps
				.get(possibleLogicalSteps.size() < 2 ? 0 : RAND.nextInt(possibleLogicalSteps.size()));
	}

	public static List<String> getAllSubStepsNameMatchingPredicate(Step<?> possibleLogicalStep,
			Predicate<String> predicate) {
		return possibleLogicalStep instanceof GenericParallelStep
				? getAllSubStepsNameMatchingPredicate((GenericParallelStep) possibleLogicalStep, predicate)
				: Collections.emptyList();
	}

	public static List<String> getAllSubStepsNameMatchingPredicate(GenericParallelStep possibleLogicalStep,
			Predicate<String> predicate) {
		return possibleLogicalStep.getSubSteps().stream().map(substep -> substep.getMseoccurrence().getMse().getName())
				.filter(predicate::test).collect(Collectors.toList());
	}

	public static List<String> getAllSubStepsName(Step<?> possibleLogicalStep) {
		return possibleLogicalStep instanceof GenericParallelStep
				? getAllSubStepsName((GenericParallelStep) possibleLogicalStep)
				: Collections.emptyList();
	}

	public static List<String> getAllSubStepsName(GenericParallelStep possibleLogicalStep) {
		return possibleLogicalStep.getSubSteps().stream().map(substep -> substep.getMseoccurrence().getMse().getName())
				.collect(Collectors.toList());
	}

	public static String concatAllSubStepsName(Step<?> possibleLogicalStep) {
		return possibleLogicalStep instanceof GenericParallelStep
				? concatAllSubStepsName((GenericParallelStep) possibleLogicalStep)
				: "";
	}

	public static String concatAllSubStepsName(GenericParallelStep possibleLogicalStep) {
		return possibleLogicalStep.getSubSteps().stream().map(substep -> substep.getMseoccurrence().getMse().getName())
				.collect(Collectors.joining(NEW_LINE));
	}

	public static Step<?> getLogicalStepThatHaveOnlyGivenPredicate(List<Step<?>> possibleLogicalSteps,
			Predicate<String> predicate) {
		return possibleLogicalSteps.stream()
				.filter(possibleLogicalStep -> possibleLogicalStep instanceof GenericParallelStep)
				.filter(possibleLogicalStep -> ((GenericParallelStep) possibleLogicalStep).getSubSteps().stream()
						.allMatch(subStep -> predicate.test(subStep.getMseoccurrence().getMse().getName())))
				.findFirst().get();
	}
	
	public static int hyperPeriod = -1;

	public static int getHyperPeriod(IotSystem system) {
		if (hyperPeriod == -1) {
			hyperPeriod = system.getOwnedResource()
				.stream()
				.map(resource -> 
					lcm(resource.getActor().stream().map(Actor::getPeriodTime).collect(Collectors.toList()))
				).max(new Comparator<Integer>() {
					@Override
					public int compare(Integer a, Integer b) {
						return a - b;
					}
				}).get();
			System.out.println("Hyper-period: " + hyperPeriod);
		}
		return hyperPeriod;
	}

	public static int lcm(List<Integer> integers) {
		Collections.sort(integers);
		final int[] lcm = new int[] { integers.get(integers.size() - 1) };
		while (true) {
			if (integers.stream().allMatch(integer -> lcm[0] % integer == 0)) {
				return lcm[0];
			} else {
				lcm[0]++;
			}
		}
	}

	public static double getBound(Resource resource) {
		final double n = resource.getActor().size();
		return n * (Math.pow(2.0d, 1 / n) - 1);
	}

	public static final Map<Actor, List<Integer>> indicesOfTakesOver = new HashMap<>();

	private static final int enterTaskCost = 1;

	private static final int exitTaskCost = 1;

	private static final int flushTaskCost = 1;

	public static double getScore(Actor actor) {
		return  (double)((double)computeRealProcessTime(actor) / ((double)actor.getPeriodTime()));
	}
	
	public static double computeRealProcessTime(Actor actor) {
		return actor.getProcessTime() + enterTaskCost + exitTaskCost + (actor.getIsSensible() == 1 ? flushTaskCost : 0);
	}

}
