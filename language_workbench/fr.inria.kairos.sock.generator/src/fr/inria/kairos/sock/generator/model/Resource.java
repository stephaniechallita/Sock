package fr.inria.kairos.sock.generator.model;

import java.util.List;
import java.util.stream.Collectors;

import static fr.inria.kairos.sock.generator.GeneratorHelper.NEW_LINE;

import java.util.ArrayList;
import java.util.Collections;

public class Resource extends NamedElement {

	private final List<Actor> actors;
	
	public Resource(String name) {
		super(name);
		this.actors = new ArrayList<>();
	}
	
	public void addActor(Actor actor) {
		this.actors.add(actor);
	}

	public List<Actor> getActors() {
		return actors;
	}
	
	public double computeSchedulableScore(boolean withFlushTask) {
		double acc = 0.0f;
		for (Actor actor : this.actors) {
			acc += actor.getScore(withFlushTask);
		}
		return acc;
	}
	
	public boolean isSchedulable(boolean withFlushTask) {
		return computeSchedulableScore(withFlushTask) < getBound();
	}
	
	public double getBound() {
		final double n = this.actors.size();
		return n * (Math.pow(2.0d, 1 / n) - 1);
	}
	
	public int getHyperPeriod() {
		return lcm(this.actors.stream().map(actor -> actor.getPeriodTime()).collect(Collectors.toList()));
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
	
	public String toTSock() {
		return "\t\tResource " + this.getName() + " {" + NEW_LINE +
					"\t\t\tactor (" + 
						this.actors.stream()
							.map(a -> "\"" + a.getName() + "\"")
							.collect(Collectors.joining(", ")) + 
						")" + NEW_LINE +
				"\t\t}";
	}

}
