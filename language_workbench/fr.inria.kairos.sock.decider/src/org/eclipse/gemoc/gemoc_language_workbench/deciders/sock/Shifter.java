package org.eclipse.gemoc.gemoc_language_workbench.deciders.sock;

import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderChecker;
import org.eclipse.gemoc.gemoc_language_workbench.deciders.sock.utils.SockDeciderHelper;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;

public class Shifter {

	private IotSystem system;

	private int shiftBeforeEnter;
	
	private String shiftedEnteringActorName;

	public Shifter(IotSystem system) {
		this.system = system;
	}

	public boolean shiftEnter(Step<?> choosenStep) {
		 final String choosenEnteringActorName = SockDeciderHelper
			.getAllSubStepsNameMatchingPredicate(choosenStep, SockDeciderChecker.enter).get(0).split("_")[1];
		if (this.shiftedEnteringActorName != null && !shiftedEnteringActorName.equals(choosenEnteringActorName)) {
			this.shiftBeforeEnter = -1;
			return false;
		}
		if (this.shiftBeforeEnter == -1) {
			this.shiftBeforeEnter = this.computePossibleShift(choosenStep);
			this.shiftedEnteringActorName = choosenEnteringActorName;
			if (this.shiftBeforeEnter <= 0) {
				this.shiftBeforeEnter = -1;
				return false;
			}
		} else {
			--this.shiftBeforeEnter;
			if (this.shiftBeforeEnter <= 0) {
				this.shiftBeforeEnter = -1;
				return false;
			}
		}
		System.out.println("Shifting enter of " + this.shiftedEnteringActorName + "(" + this.shiftBeforeEnter + ")");
		return true;
	}

	private int computePossibleShift(Step<?> choosenStep) {
		final String enteringActorName = SockDeciderHelper
				.getAllSubStepsNameMatchingPredicate(choosenStep, SockDeciderChecker.enter).get(0).split("_")[1];
		final Actor enteringActor = this.system.getOwnedActor().stream()
				.filter(actor -> actor.getName().equals(enteringActorName)).findFirst().get();
		int shift = 0;
		while (this.isSchedulable(enteringActor.getResource(), enteringActor, shift++))
			;
		return SockDeciderHelper.RAND.nextInt(shift - 1);
	}

	private boolean isSchedulable(Resource resource, Actor shiftedActor, int shift) {
		double acc = 0.0D;
		for (Actor actor : resource.getActor()) {
			acc += (double) (((double) SockDeciderHelper.computeRealProcessTime(actor)
					+ (actor.equals(shiftedActor) ? shift : 0)) / (double) actor.getPeriodTime());
		}
//		System.out.println(acc + "<" + SockDeciderHelper.getBound(resource) + " {" + shift + "}");
		return acc < SockDeciderHelper.getBound(resource);
	}

}
