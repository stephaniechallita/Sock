package fr.inria.kairos.sock.dsl.attacks.sidechannel;

import java.util.stream.Collectors;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;
import fr.inria.kairos.sock.dsl.model.sock.SockFactory;
import fr.inria.kairos.sock.utils.Interval;
import fr.inria.kairos.sock.utils.Utils;

public class Main {

	public static void main(String [] args) {
		final IotSystem s = SockFactory.eINSTANCE.createIotSystem();
		s.setName("s");
		
		final Resource r = SockFactory.eINSTANCE.createResource();
		r.setName("r");
		
		final Actor a1 = SockFactory.eINSTANCE.createActor();
		a1.setName("a1");
		a1.setPeriodTime(5);
		a1.setProcessTime(1);
		a1.setResource(r); 
		
		final Actor a2 = SockFactory.eINSTANCE.createActor();
		a2.setName("a2");
		a2.setPeriodTime(6);
		a2.setProcessTime(2);
		a2.setResource(r);
		
		final Actor a3 = SockFactory.eINSTANCE.createActor();
		a3.setName("a3");
		a3.setPeriodTime(10);
		a3.setProcessTime(2);
		a3.setResource(r); 
		
		r.getActor().add(a1);
		r.getActor().add(a2);
		r.getActor().add(a3);
		
		s.getOwnedActor().add(a1);
		s.getOwnedActor().add(a2);
		s.getOwnedActor().add(a3);
		s.getOwnedResource().add(r);
		
		final int lcm = Utils.lcm(s.getOwnedActor().stream().map(Actor::getPeriodTime).collect(Collectors.toList()));
		System.out.println("LCM " +s.getOwnedActor().stream().map(Actor::getPeriodTime).collect(Collectors.toList()) + " = " + lcm);
		
		// reproduction of the table in the paper for having :
		// ω1 8 [0,8]
		// ω2 6 [10,16]
		// ω3 5 [18,23]
		// ω4 4 [24,27]
		
		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 8));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(10, 16));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(18, 23));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(24, 27));
		ScheduLeak.getInstance().run();
	}
	
}
