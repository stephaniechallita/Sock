package org.eclipse.gemoc.gemoc_language_workbench.deciders;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderChecker;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderHelper;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;

public class RandomSockDecider extends SockDecider {
	
	private Actor replacement;
	
	@Override
	protected Optional<String> getNextPredicate(
			final List<String> substepsForResource, 
			final Resource resource,
			final Predicate<String> predicate) {
		if (predicate.equals(SockDeciderChecker.enter)) {
			return this.getNextEnter(substepsForResource, resource);
		} else if (predicate.equals(SockDeciderChecker.takesOver)) {
			return this.getNextTakesOver(substepsForResource, resource);
		} else {
			return super.getNextPredicate(substepsForResource, resource, predicate);
		}
	}
	
	private Optional<String> getNextEnter(final List<String> substepsForResource, final Resource resource) {
		final Optional<String> enteringActorNameOpt = 
				substepsForResource.stream().filter(SockDeciderChecker.enter).sorted(this.schedulerPerResource.get(resource)).findFirst();
		if (enteringActorNameOpt.isPresent()) {
			final String enteringActorStep = enteringActorNameOpt.get();
			final List<String> randomEnteringActorSteps = 
					substepsForResource.stream().filter(SockDeciderChecker.enter).filter(enteringActor -> ! enteringActor.equals(enteringActorStep)).collect(Collectors.toList());
			if (randomEnteringActorSteps.isEmpty()) {
				return Optional.of(enteringActorStep);
			}
			final String randomEnteringActorStep = randomEnteringActorSteps.get(SockDeciderHelper.RAND.nextInt(randomEnteringActorSteps.size()));
			final String enteringActorName = SockDeciderHelper.getEntityNameFromClockName(enteringActorStep);
			final String randomActorName = SockDeciderHelper.getEntityNameFromClockName(randomEnteringActorStep);
			final Actor firstEnteringActor = resource.getActor().stream()
					.filter(actor -> actor.getName().equals(enteringActorName)).findFirst().get();
			final Actor secondEnteringActor = resource.getActor().stream()
					.filter(actor -> actor.getName().equals(randomActorName)).findFirst().get();
			final int nextPeriod = ((this.nbDecide / firstEnteringActor.getPeriodTime()) + 1) * firstEnteringActor.getPeriodTime();
//			System.out.println(this.nbDecide + "+" + SockDeciderHelper.computeRealProcessTime(secondEnteringActor) + "+" + 
//					SockDeciderHelper.computeRealProcessTime(firstEnteringActor) + "(" +
//					(this.nbDecide +
//					SockDeciderHelper.computeRealProcessTime(secondEnteringActor)
//					+ SockDeciderHelper.computeRealProcessTime(firstEnteringActor)) + ")" +
//					"<" + nextPeriod);
			if (this.nbDecide + SockDeciderHelper.computeRealProcessTime(secondEnteringActor)
					+ SockDeciderHelper.computeRealProcessTime(firstEnteringActor) < nextPeriod){
				this.replacement = secondEnteringActor;
				return Optional.of(randomEnteringActorStep);
			} else {
				return Optional.of(enteringActorStep);
			}
		} else {
			return Optional.empty();
		}
	}
	
	private Optional<String> getNextTakesOver(final List<String> substepsForResource, final Resource resource) {
		final Optional<String> takesOverStepOpt = 
				substepsForResource.stream().filter(SockDeciderChecker.takesOver).sorted(this.schedulerPerResource.get(resource)).findFirst();
		final Optional<String> processStepOpt = 
				substepsForResource.stream().filter(SockDeciderChecker.process).sorted(this.schedulerPerResource.get(resource)).findFirst();
		if (takesOverStepOpt.isPresent() && processStepOpt.isPresent()) {
			final String takesOverStep = takesOverStepOpt.get();
			final String actorNameTakingOver = SockDeciderHelper.getEntityNameFromClockName(takesOverStep);
			final String processStep = processStepOpt.get();
			final String actorNameProcessing = SockDeciderHelper.getEntityNameFromClockName(processStep);
			if (this.replacement != null && !this.replacement.getName().equals(actorNameProcessing)) {
				this.replacement = null;
			}
			if (this.replacement != null && this.replacement.getName().equals(actorNameProcessing) || 
					super.schedulerPerResource.get(resource).compare(actorNameProcessing, actorNameTakingOver) <= 0) {
				return Optional.of(processStep);
			} else {
				return Optional.of(takesOverStep);
			}
		} else {
			return Optional.empty();
		}
	}

}
