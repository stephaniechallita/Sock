package fr.inria.kairos.sock.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import fr.inria.kairos.sock.generator.model.Actor;
import fr.inria.kairos.sock.generator.model.IotSystem;
import fr.inria.kairos.sock.generator.model.Resource;

public class Generator {
	
	private Random random;
	
	private int minPeriodTime;
	
	private int maxPeriodTime;
	
	private int stepPeriodTime;
	
	private int minProcessTime;
	
	private int maxProcessTime;
	
	private int minNbActor;
	
	private int maxNbActor;
	
	public Generator(Random random) {
		this(random, 50, 1000, 50, 3, 30, 2, 10);
	}
	
	public Generator(Random random, int minPeriodTime, int maxPeriodTime, int stepPeriodTime, int minProcessTime, int maxProcessTime, int minNbActor, int maxNbActor) {
		this.random = random;
		this.minPeriodTime = minPeriodTime;
		this.maxPeriodTime = maxPeriodTime;
		this.stepPeriodTime = stepPeriodTime;
		this.minProcessTime = minProcessTime;
		this.maxProcessTime = maxProcessTime;
		this.minNbActor = minNbActor;
		this.maxNbActor = maxNbActor;
	}
	
	public List<IotSystem> generateSystemsWithGivenBaseUtilization(int targetNumberSystems, Interval targetedInterval) {
		List<IotSystem> systems = new ArrayList<>();
		while (systems.size() < targetNumberSystems) {
			systems.add(
					initSystemWithGivenBaseUtilization(
							targetedInterval, 
							new IotSystem("s" + targetedInterval.format() + "" + systems.size()))
			);
		}
		return systems;
	}
	
	public IotSystem initSystemWithGivenBaseUtilization(Interval targetedInterval, final IotSystem system) {
		return this.initSystemWithGivenBaseUtilization(targetedInterval, system, false);
	}
	
	public IotSystem initSystemWithGivenBoundForResource(Interval targetedInterval, final IotSystem system) {
		return this.initSystemWithGivenBoundForResource(targetedInterval, system, false);
	}
	
	public IotSystem initSystemWithGivenBoundForResource(Interval targetedInterval, final IotSystem system, boolean withFlushTask) {
		final Resource resource = new Resource("r"  + system.getOwnedResource().size());
		while (true) {
			final int nbActor = this.minNbActor + this.random.nextInt(this.maxNbActor - this.minNbActor);
			while (resource.getActors().size() < nbActor) {
				final Actor actor = getNextActor(resource);
				resource.getActors().add(actor);
			}
			double score = resource.computeSchedulableScore(withFlushTask);
			double bound = resource.getBound();
			if (targetedInterval.i <= score && score <= targetedInterval.j
					&& score <= bound) {
				break;
			} else {
				resource.getActors().clear();
			}
		}
		system.getOwnedResource().add(resource);
		Collections.sort(resource.getActors(), new Comparator<Actor>() {
			@Override
			public int compare(Actor a, Actor b) {
				return a.getName().compareTo(b.getName());
			}
		});
		system.getOwnedActor().addAll(resource.getActors());
		return system;
	}
	
	public IotSystem initSystemWithGivenBaseUtilization(Interval targetedInterval, final IotSystem system, boolean withFlushTask) {
		final Resource resource = new Resource("r" + system.getOwnedResource().size());
		while (true) {
			final int nbActor = 2 + this.random.nextInt(8);
			for (int i = 0 ; i < nbActor ; i++) {
				final Actor actor = getNextActor(resource);
				resource.getActors().add(actor);
			}
			double score = resource.computeSchedulableScore(withFlushTask);
			if (targetedInterval.i <= score && score <= targetedInterval.j) {
				break;
			} else {
				resource.getActors().clear();
			}
		}
		system.getOwnedResource().add(resource);
		return system;
	}
	
	private int getNextPeriod(final Resource resource) {
		int[] periodTime = new int[] {this.minPeriodTime + (this.stepPeriodTime *  this.random.nextInt( (this.maxPeriodTime - this.minPeriodTime) / this.stepPeriodTime))};
		while ((!resource.getActors().isEmpty()) && resource.getActors().stream().anyMatch(actor -> actor.getPeriodTime() == periodTime[0])) {
			periodTime[0] = this.minPeriodTime + (this.stepPeriodTime *  this.random.nextInt( (this.maxPeriodTime - this.minPeriodTime) / this.stepPeriodTime));
			if (resource.getActors().stream().anyMatch(actor -> actor.getPeriodTime() == periodTime[0])) {
				if (this.random.nextFloat() > 0.5) {
					return periodTime[0];
				}
			}
		}
		return periodTime[0];
	}
	
	private int getNextProcessTime(final Resource resource) {
		int[] processTime = new int[] {this.minProcessTime + this.random.nextInt(this.maxProcessTime - this.minProcessTime)};
		while ((!resource.getActors().isEmpty()) && resource.getActors().stream().anyMatch(actor -> actor.getProcessTime() == processTime[0])) {
			processTime[0] = this.minProcessTime + this.random.nextInt(this.maxProcessTime - this.minProcessTime);
			if (this.random.nextFloat() > 0.5) {
				return processTime[0];
			}
		}
		return processTime[0];
	}
		
	public Actor getNextActor(final Resource resource) {
		final int periodTime = this.minPeriodTime + (this.stepPeriodTime *  this.random.nextInt( (this.maxPeriodTime - this.minPeriodTime) / this.stepPeriodTime));//this.getNextPeriod(resource);
		final int processTime  = this.minProcessTime + this.random.nextInt(this.maxProcessTime - this.minProcessTime);
		final int isPriority;
		if (this.random.nextFloat() >= 0.33) {
			isPriority = 0;
		} else {
			isPriority = 1;
		}
		return new Actor("a" + 
				resource.getName() + 
				resource.getActors().size(), isPriority, processTime, periodTime, resource);
	}
}
