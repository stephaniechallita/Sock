package fr.inria.kairos.sock.dsl.attacks.sidechannel.steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.utils.Interval;
import fr.inria.kairos.sock.utils.Utils;

public class Estimation {

	private IotSystem system;

	public Estimation(IotSystem system) {
		this.system = system;
	}

	public int[][] findCandidateForActor(Interval interval) {
		final int duration = interval.getDuration();
		final int[][] candidatesActor = new int[this.system.getOwnedActor().size()][];
		for (Actor actor : this.system.getOwnedActor()) {
			candidatesActor[this.system.getOwnedActor().indexOf(actor)] = TheoremOne.theoremOne(duration,
					Utils.computeRealProcessTime(actor, interval), actor.getPeriodTime());
		}
		return candidatesActor;
	}

	public List<int[]> estimateNbTaskForGivenInterval(Interval interval, int[][] candidatesActor) {
		final int duration = interval.getDuration();
		final List<int[]> possibilities = findPossibilites(candidatesActor);
		final List<int[]> matching = new ArrayList<>();
		for (int[] possibility : possibilities) {
			int totalComputationTime = computeTotalComputationTime(this.system.getOwnedActor(), possibility, interval);
			System.out.println(interval.toString() + " " + Arrays.toString(possibility) + " " + totalComputationTime + " vs " + duration);
			if (duration == totalComputationTime) {
				matching.add(possibility);
			}
		}
		return matching;
	}

	public static List<int[]> findPossibilites(int[][] candidates) {
		int size = candidates.length;
		int[] indices = new int[size];
		for (int i = 0; i < size; i++) {
			indices[i] = 0;
		}
		List<int[]> possibilities = new ArrayList<>();
		while (true) {
			int[] possibility = new int[size];
			for (int i = 0; i < size; i++) {
				possibility[i] = candidates[i][indices[i]];
			}
			possibilities.add(possibility);

			int next = size - 1;
			while (next >= 0 && (indices[next] + 1 >= candidates[next].length)) {
				next--;
			}
			if (next < 0) {
				return possibilities;
			}
			indices[next] += 1;
			for (int i = next + 1; i < size; i++) {
				indices[i] = 0;
			}
		}
	}

	private int computeTotalComputationTime(List<Actor> actors, int[] numberOfEach, Interval interval) {
		int acc = 0;
		for (int i = 0; i < actors.size(); i++) {
//			System.out.println(i + " " + Utils.computeRealProcessTime(actors.get(i), interval));
			acc += numberOfEach[i] * Utils.computeRealProcessTime(actors.get(i), interval);
		}
		return acc;
	}

}
