package org.eclipse.gemoc.gemoc_language_workbench.deciders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.gemoc.gemoc_language_workbench.deciders.AbstractSockDecider.ArrivalTime;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderChecker;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderHelper;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;

public class SockDecider extends AbstractSockDecider {

	protected List<String> decideForResource(final Resource resource, final List<Step<?>> possibleLogicalSteps) {
		final List<String> choosenSubstepsForResource = new ArrayList<>();
		final List<String> substepsForResource = this.getSubstepForResource(possibleLogicalSteps, resource);
		Optional<String> next = getNextPredicate(substepsForResource, resource, SockDeciderChecker.enter);
		if (next.isPresent()) {
			final String substepEnteringActor = next.get();
			this.schedulePerResource.get(resource).add(new ArrivalTime(SockDeciderHelper.getEntityNameFromClockName(substepEnteringActor), this.nbDecide));
			this.addNext(choosenSubstepsForResource, substepsForResource, substepEnteringActor,
					SockDeciderChecker.isEntered);
		} else {
			next = getNextPredicate(substepsForResource, resource, SockDeciderChecker.takesOver);
			Optional<String> nextProcess = getNextPredicate(substepsForResource, resource, SockDeciderChecker.process);
			if (next.isPresent() && nextProcess.isPresent()) {
				final String takesOverActorSubstep = next.get();
				final String actorNameTakingOver = SockDeciderHelper.getEntityNameFromClockName(takesOverActorSubstep);
				final String processingActorSubstep = getNextPredicate(substepsForResource, resource,
						SockDeciderChecker.process).get();
				final String actorNameProcessing = SockDeciderHelper.getEntityNameFromClockName(processingActorSubstep);
				if (this.schedulerPerResource.get(resource).compare(actorNameProcessing, actorNameTakingOver) <= 0) {
					this.addNext(choosenSubstepsForResource, substepsForResource, processingActorSubstep,
							SockDeciderChecker.isProcessed);
				} else {
					this.addNext(choosenSubstepsForResource, substepsForResource, takesOverActorSubstep,
							SockDeciderChecker.anActorIsTakenOver);
					choosenSubstepsForResource
							.add(substepsForResource.stream().filter(SockDeciderChecker.isTakenOver).findFirst().get());
					this.schedulePerResource.get(resource).add(new ArrivalTime(SockDeciderHelper.getEntityNameFromClockName(takesOverActorSubstep), this.nbDecide));
				}
			} else {
				if (substepsForResource.stream().filter(
						substep -> SockDeciderHelper.getEntityNameFromClockName(substep).equals(resource.getName())).count() > 1) {
					throw new RuntimeException("Should not have two actions for resource " + resource.getName() + "\n" + 
							substepsForResource.stream().filter(
									substep -> SockDeciderHelper.getEntityNameFromClockName(substep).equals(resource.getName()))
							.collect(Collectors.toList()));
				}
				final String subStepOfResource = substepsForResource.stream().filter(
						substep -> SockDeciderHelper.getEntityNameFromClockName(substep).equals(resource.getName()))
						.findFirst().get();
				if (SockDeciderChecker.clean.test(subStepOfResource)) {
					choosenSubstepsForResource.add(subStepOfResource);
				} else if (SockDeciderChecker.isExited.test(subStepOfResource)) {
					final String nameOfActor = SockDeciderHelper.getEntityNameFromClockName(
							substepsForResource.stream().filter(SockDeciderChecker.exited).findFirst().get());
					final Predicate<String> correspondingNamePredicate = name -> nameOfActor
							.equals(SockDeciderHelper.getEntityNameFromClockName(name));
					this.addNext(choosenSubstepsForResource, substepsForResource, subStepOfResource,
							SockDeciderChecker.exited.and(correspondingNamePredicate));
					choosenSubstepsForResource.add(substepsForResource.stream()
							.filter(SockDeciderChecker.taskCompleted.and(correspondingNamePredicate)).findFirst()
							.get());
					choosenSubstepsForResource.add(substepsForResource.stream()
							.filter(SockDeciderChecker.sensible.and(correspondingNamePredicate)).findFirst().get());
				} else if (SockDeciderChecker.isProcessed.test(subStepOfResource)){
					this.addNext(choosenSubstepsForResource, substepsForResource, subStepOfResource,
							SockDeciderChecker.process);
				}
			}
		}
		fillWithIdle(choosenSubstepsForResource, substepsForResource);
		return choosenSubstepsForResource;
	}
	
}
