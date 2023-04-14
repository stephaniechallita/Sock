package fr.inria.kairos.sock.dsl.attacks.sidechannel.steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.utils.Interval;

public class ArrivalWindows {
	
	public static List<Interval> findArrivalWindows(List<Interval> partitionnedInterval, Actor actor) {
		final List<Interval> arrivalWindows = new ArrayList<>();
		final List<List<Interval>> convertedPartitionnedIntervals = new ArrayList<>();
		Interval forNext = null;
		for (Interval interval : partitionnedInterval) {
			List<Interval> convertedInterval = interval.convert(actor.getPeriodTime());
			if (convertedInterval.size() > 1) {
				// should not happens if we are at the first interval...
				convertedPartitionnedIntervals.get(convertedPartitionnedIntervals.size() - 1).add(convertedInterval.get(1));
				forNext = convertedInterval.get(1);
			} else {
				if (forNext != null) {
					convertedInterval.add(forNext);
					forNext = null;
				}
				convertedPartitionnedIntervals.add(convertedInterval);
			}
		}
		if (forNext != null) {
			convertedPartitionnedIntervals.get(convertedPartitionnedIntervals.size() - 1).add(forNext);
			forNext = null;
		}		
		int[][] indicesCandidates = new int[convertedPartitionnedIntervals.size()][];
		for (int i = 0 ; i < convertedPartitionnedIntervals.size() ; i++) {
			indicesCandidates[i] = new int[convertedPartitionnedIntervals.get(i).size()];
			for (int j = 0 ; j < convertedPartitionnedIntervals.get(i).size() ; j++) {
				indicesCandidates[i][j] = j;	
			}
		}
//		System.out.println(Arrays.toString(indicesCandidates));
		List<int[]> possibilities = Estimation.findPossibilites(indicesCandidates);
		for (int i = 0 ; i < possibilities.size() ; i++) {
//			System.out.println(i + "/" + possibilities.size());
//			System.out.println(convertedPartitionnedIntervals + " " + Arrays.toString(possibilities.get(i)));
			Interval intersection = computeIntersection(possibilities.get(i), convertedPartitionnedIntervals);
			if (intersection != Interval.EMPTY && !arrivalWindows.contains(intersection)) {
				if (intersection.time1 > intersection.time2) {
					arrivalWindows.add(new Interval(intersection.time2, intersection.time1));
				} else {
					arrivalWindows.add(intersection);
				}
			}
		}
		return arrivalWindows;
	}
	
	public static Interval computeIntersection(int[] indices, final List<List<Interval>> convertedPartiotionnedIntervals) {
		Interval intersection = convertedPartiotionnedIntervals.get(0).get(indices[0]);
		for (int i = 1 ; i < convertedPartiotionnedIntervals.size() ; i++) {
			Interval tmpIntersection = intersection.intersection(convertedPartiotionnedIntervals.get(i).get(indices[i]));
			if (intersection.getDuration() > 0) {
				intersection = tmpIntersection;
			}
		}
		return intersection;
	}

}
