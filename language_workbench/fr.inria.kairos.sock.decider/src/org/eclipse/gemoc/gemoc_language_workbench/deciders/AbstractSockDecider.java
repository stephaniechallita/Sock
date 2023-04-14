package org.eclipse.gemoc.gemoc_language_workbench.deciders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.Scheduler;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderChecker;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderHelper;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import fr.inria.kairos.sock.utils.IOUtils;
import fr.inria.kairos.sock.utils.Utils;
import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;

public abstract class AbstractSockDecider implements ILogicalStepDecider {

	private final static String NAME_PROPERTY_NB_HYPER_PERIOD = "nb.hyper.period";

	protected int nbHyperPeriodToDo;

	private final static String NAME_PROPERTY_ENABLE_BUTTERFLY_ATTACK = "enable.butterfly.attack";

	protected boolean enableButterflyAttack;

	private final static String NAME_PROPERTY_PROBA_BUTTERFLY_ATTACK = "proba.butterfly.attack";

	protected float probabilityButterFlyAttack;

	protected Map<Resource, Scheduler> schedulerPerResource;

	protected int nbDecide;

	protected Map<Resource, List<ArrivalTime>> schedulePerResource;

	private IotSystem lastSystem;

	public AbstractSockDecider() {
		super();
		this.nbDecide = 0;
		this.schedulePerResource = new HashMap<>();
	}

	private void init(IotSystem system) {
		final Properties sockProperties = Utils.getSockProperties();
		this.nbHyperPeriodToDo = Integer.parseInt(sockProperties.getProperty(NAME_PROPERTY_NB_HYPER_PERIOD, "-1"));
		this.enableButterflyAttack = Boolean
				.parseBoolean(sockProperties.getProperty(NAME_PROPERTY_ENABLE_BUTTERFLY_ATTACK, "false"));
		this.probabilityButterFlyAttack = Float
				.parseFloat(sockProperties.getProperty(NAME_PROPERTY_PROBA_BUTTERFLY_ATTACK, "0.0F"));
		this.schedulePerResource.clear();
		this.schedulerPerResource = null;
		this.nbDecide = 0;
		SockDeciderHelper.hyperPeriod = -1;
	}

	protected boolean shouldStop(final int hyperPeriod) {
		final int nbHyperPeriodDone = this.nbDecide / hyperPeriod;
		return nbHyperPeriodDone == this.nbHyperPeriodToDo && this.nbDecide % hyperPeriod == 2;
	}

	protected void stop(final int hyperPeriod, final IotSystem system, AbstractConcurrentExecutionEngine engine) {
		final long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(String.format("Reach nb hyper period %d/%d {%d}", this.nbDecide / hyperPeriod,
				this.nbHyperPeriodToDo, this.nbDecide));
		for (Resource resource : system.getOwnedResource()) {
			IOUtils.writeRaw(this.toString(this.schedulePerResource.get(resource)), system.getName() + "/schedule_" + resource.getName());	
		}
		this.init(system);
		IOUtils.writeRaw(elapsedTime + "", system.getName() + "/time");
		engine.stop();
		
	}
	
	protected abstract List<String> decideForResource(final Resource resource, final List<Step<?>> possibleLogicalSteps);
	
	private long startTime;

	private void initWhenNewSystem(IotSystem system) {
		if (this.lastSystem == null || !this.lastSystem.equals(system)) {
			this.lastSystem = system;
			IOUtils.initFolders(system.getName());
			this.init(system);
			startTime = System.currentTimeMillis();
		}
	}

	private void initSchedulers(IotSystem system) {
		this.schedulerPerResource = new LinkedHashMap<>();
		for (Resource resource : system.getOwnedResource()) {
			this.schedulerPerResource.put(resource, new Scheduler(resource));
			this.schedulePerResource.put(resource, new ArrayList<>());
		}
	}

	public Step<?> decide(AbstractConcurrentExecutionEngine engine, final List<Step<?>> possibleLogicalSteps) {
//		System.out.println(possibleLogicalSteps.stream().map(step -> SockDeciderHelper.concatAllSubStepsName(step)).collect(Collectors.joining("\n\n")));
		final IotSystem system = (IotSystem) engine.getExecutionContext().getResourceModel().getContents().get(0);
		this.initWhenNewSystem(system);
		if (this.schedulerPerResource == null) {
			this.initSchedulers(system);
		}
		final int hyperPeriod = SockDeciderHelper.getHyperPeriod(system);
		if (shouldStop(hyperPeriod)) {
			this.stop(hyperPeriod, system, engine);
			return null;
		}
		if (possibleLogicalSteps.size() == 1) {
			this.nbDecide++;
			return possibleLogicalSteps.get(0);
		}
		final List<String> decisions = system.getOwnedResource().stream()
				.flatMap(resource -> this.decideForResource(resource, possibleLogicalSteps).stream())
				.collect(Collectors.toList());
		decisions.add(SockDeciderHelper.getAllSubStepsName(possibleLogicalSteps.get(0)).stream()
				.filter(SockDeciderChecker.timeEvent).findAny().get());
//		System.out.println("Decision:");
//		System.out.println(decisions);
		final Step<?> choosen = findStepMatchingAllDecisions(possibleLogicalSteps, decisions);
		this.nbDecide++;
		return choosen;
	}

	private Step<?> findStepMatchingAllDecisions(final List<Step<?>> possibleLogicalSteps,
			final List<String> decisions) {
		return possibleLogicalSteps.stream()
				.filter(step -> SockDeciderHelper.getAllSubStepsName(step).stream().allMatch(decisions::contains))
				.findAny().get();
	}
	
	protected List<String> getSubstepForResource(final List<Step<?>> possibleLogicalSteps, Resource resource) {
		return new ArrayList<>(possibleLogicalSteps.stream()
				.flatMap(step -> SockDeciderHelper.getAllSubStepsName(step).stream()).filter(subStepName -> {
					final String entityName = SockDeciderHelper.getEntityNameFromClockName(subStepName);
					return resource.getName().equals(entityName)
							|| resource.getActor().stream().map(Actor::getName).anyMatch(entityName::equals);
				}).collect(Collectors.toSet()));
	}
	
	protected void fillWithIdle(final List<String> choosenSubstepsForResource, final List<String> substepsForResource) {
		final List<String> entityNamesAlreadyAdded = choosenSubstepsForResource.stream()
				.map(SockDeciderHelper::getEntityNameFromClockName).collect(Collectors.toList());
		choosenSubstepsForResource.addAll(substepsForResource.stream().filter(SockDeciderChecker.isIdle.or(SockDeciderChecker.periodStart)).filter(
				substep -> !entityNamesAlreadyAdded.contains(SockDeciderHelper.getEntityNameFromClockName(substep)))
				.collect(Collectors.toList()));
	}

	protected Optional<String> getNextPredicate(final List<String> substepsForResource, final Resource resource,
			final Predicate<String> predicate) {
		return substepsForResource.stream().filter(predicate).sorted(this.schedulerPerResource.get(resource))
				.findFirst();
	}
	
	protected void addNext(final List<String> choosenSubstepsForResource, final List<String> substepsForResource,
			final String subStepToBeAddedActor, final Predicate<String> predicate) {
		final String substepResource = substepsForResource.stream().filter(predicate).findFirst().get();
		choosenSubstepsForResource.add(substepResource);
		choosenSubstepsForResource.add(subStepToBeAddedActor);
	}

	private Step<?> returnRandomLogicalStep(final List<Step<?>> possibleLogicalSteps) {
		List<Step<?>> logicalStepsWithoutButterflyAttack = possibleLogicalSteps.stream()
				.filter(possibleLogicalStep -> SockDeciderChecker.hasNoClockPredicate(possibleLogicalStep,
						SockDeciderChecker.butterflyAttack))
				.collect(Collectors.toList());
		final Step<?> choosenOne = SockDeciderHelper.returnRandomOne(logicalStepsWithoutButterflyAttack);
		return choosenOne;
	}

	@Override
	public void dispose() {
		// nothing to do
	}

	@Override
	public void preempt() {
		// not possible
	}

	protected class ArrivalTime {
		public final String actor;
		public final int arrivalTime;

		public ArrivalTime(String actor, int arrivalTime) {
			this.actor = actor;
			this.arrivalTime = arrivalTime;
		}
	}

	public String toString(List<ArrivalTime> schedule) {
		return schedule.stream().map(arrivalTime -> arrivalTime.actor + " " + arrivalTime.arrivalTime)
				.collect(Collectors.joining(IOUtils.NEW_LINE));
	}

}
