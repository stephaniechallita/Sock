package fr.inria.kairos.sock.dsl.attacks.sidechannel.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.utils.Interval;
import fr.inria.kairos.sock.utils.Utils;

public class TheoremTwo {

	public static List<Interval> classify(Actor actor, Interval busyInterval, boolean isSecondEquation, int n) {
		System.out.println(actor.getName() + " " + busyInterval.toString() + " " + isSecondEquation + " " + n);
		if (!isSecondEquation) {
			return equationOne(actor, busyInterval, n);
		} else {
			List<Interval> intervals = equationTwo(actor, busyInterval, n);
			intervals.addAll(equationTwoBis(actor, busyInterval, n + 1));
			return intervals;
		}
	}

	private static List<Interval> equationOne(Actor actor, Interval busyInterval, int n) {
		final List<Interval> intervals = new ArrayList<>();
		// Ak(τi)j = [a + (j − 1)pi, min{b−(N −j)pi −ci,a+jpi −ci}]
		for (int j = 1; j <= n; j++) {
			// a + (j − 1)pi
			int AkActorJ_left = busyInterval.time1 + ((j - 1) * actor.getPeriodTime());
			// min{b−(N −j)pi −ci,a+jpi −ci}
			int AkActorJ_right = Math.min(busyInterval.time2 - ((n - j) * actor.getPeriodTime()) - Utils.computeRealProcessTime(actor, busyInterval),
					busyInterval.time1 + (j * actor.getPeriodTime()) - Utils.computeRealProcessTime(actor, busyInterval));
//			System.out.println(j + " 1 " + new Interval(AkActorJ_left, AkActorJ_right));
			if (AkActorJ_left > AkActorJ_right) {
				intervals.add(new Interval(AkActorJ_left, AkActorJ_left, Interval.Category.Interval_1));
			} else {
				intervals.add(new Interval(AkActorJ_left, AkActorJ_right, Interval.Category.Interval_1));
			}
		}
		return intervals;
	}

	private static List<Interval> equationTwo(Actor actor, Interval busyInterval, int n) {
		final List<Interval> intervals = new ArrayList<>();
		// Ak(τi)j =[a+(j−1)pi,a+jpi−ci]
		for (int j = 1; j <= n ; j++) {
			// a+(j−1)pi
			int AkActorJ_left = busyInterval.time1 + ((j - 1) * actor.getPeriodTime());
			// a+jpi−ci
			int AkActorJ_right = busyInterval.time1 + j * actor.getPeriodTime() - Utils.computeRealProcessTime(actor, busyInterval);
//			System.out.println(j + " 2 " + new Interval(AkActorJ_left, AkActorJ_right));
			intervals.add(new Interval(AkActorJ_left, AkActorJ_right, Interval.Category.Interval_1));
		}
		return intervals;
	}

	private static List<Interval> equationTwoBis(Actor actor, Interval busyInterval, int n) {
		// Ak(τi)j =[a+(j−1)pi,b−ci]
		// a+(j−1)pi
		int AkActorJ_left = busyInterval.time1 + ((n - 1) * actor.getPeriodTime());
		// b−ci
		int AkActorJ_right = busyInterval.time2 - Utils.computeRealProcessTime(actor, busyInterval);
//		System.out.println(n + " 2b " + new Interval(AkActorJ_left, AkActorJ_right));
		return Collections.singletonList(new Interval(AkActorJ_left, AkActorJ_right, Interval.Category.Interval_0_1));
	}

}
