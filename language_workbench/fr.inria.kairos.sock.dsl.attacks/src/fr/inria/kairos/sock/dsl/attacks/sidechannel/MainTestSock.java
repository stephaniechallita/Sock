package fr.inria.kairos.sock.dsl.attacks.sidechannel;

import java.util.ArrayList;
import java.util.stream.Collectors;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;
import fr.inria.kairos.sock.dsl.model.sock.SockFactory;
import fr.inria.kairos.sock.utils.Interval;
import fr.inria.kairos.sock.utils.Utils;

public class MainTestSock {

	public static void main(String [] args) {
		final IotSystem s = SockFactory.eINSTANCE.createIotSystem();
		s.setName("s");
		
		final Resource r = SockFactory.eINSTANCE.createResource();
		r.setName("r");
		
//		final Actor a1 = SockFactory.eINSTANCE.createActor();
//		a1.setName("a");
//		a1.setPeriodTime(15);
//		a1.setProcessTime(3);
//		a1.setResource(r); 
//		a1.setIsSensible(1);
//		
//		final Actor a2 = SockFactory.eINSTANCE.createActor();
//		a2.setName("b");
//		a2.setPeriodTime(25);
//		a2.setProcessTime(5);
//		a2.setResource(r);
		
		// S 4
		
//		final Actor a1 = SockFactory.eINSTANCE.createActor();
//		a1.setName("a");
//		a1.setPeriodTime(10);
//		a1.setProcessTime(2);
//		a1.setResource(r); 
//		a1.setIsSensible(0);
//		
//		final Actor a2 = SockFactory.eINSTANCE.createActor();
//		a2.setName("b");
//		a2.setPeriodTime(35);
//		a2.setProcessTime(4);
//		a2.setResource(r);
//		a2.setIsSensible(1);
		
		
		// S 0
		
//		final Actor a1 = SockFactory.eINSTANCE.createActor();
//		a1.setName("a");
//		a1.setPeriodTime(20);
//		a1.setProcessTime(1);
//		a1.setResource(r); 
//		a1.setIsSensible(1);
//		
//		final Actor a2 = SockFactory.eINSTANCE.createActor();
//		a2.setName("b");
//		a2.setPeriodTime(45);
//		a2.setProcessTime(4);
//		a2.setResource(r);
//		a2.setIsSensible(1);
//		
//		final Actor a3 = SockFactory.eINSTANCE.createActor();
//		a3.setName("c");
//		a3.setPeriodTime(45);
//		a3.setProcessTime(4);
//		a3.setResource(r);
//		a3.setIsSensible(0);
//		
//		final Actor a4 = SockFactory.eINSTANCE.createActor();
//		a4.setName("d");
//		a4.setPeriodTime(45);
//		a4.setProcessTime(4);
//		a4.setResource(r);
//		a4.setIsSensible(1);
		
		// S 1
		
//		final Actor a1 = SockFactory.eINSTANCE.createActor();
//		a1.setName("a");
//		a1.setPeriodTime(25);
//		a1.setProcessTime(1);
//		a1.setResource(r); 
//		a1.setIsSensible(0);
//		
//		final Actor a2 = SockFactory.eINSTANCE.createActor();
//		a2.setName("b");
//		a2.setPeriodTime(25);
//		a2.setProcessTime(1);
//		a2.setResource(r);
//		a2.setIsSensible(1);
//		
//		final Actor a3 = SockFactory.eINSTANCE.createActor();
//		a3.setName("c");
//		a3.setPeriodTime(20);
//		a3.setProcessTime(2);
//		a3.setResource(r);
//		a3.setIsSensible(0);
//		
//		final Actor a4 = SockFactory.eINSTANCE.createActor();
//		a4.setName("d");
//		a4.setPeriodTime(25);
//		a4.setProcessTime(2);
//		a4.setResource(r);
//		a4.setIsSensible(1);
		
		// S 9 scheduleak
		
//		final Actor a1 = SockFactory.eINSTANCE.createActor();
//		a1.setName("a");
//		a1.setPeriodTime(20);
//		a1.setProcessTime(2);
//		a1.setResource(r); 
//		a1.setIsSensible(1);
//		
//		final Actor a2 = SockFactory.eINSTANCE.createActor();
//		a2.setName("b");
//		a2.setPeriodTime(30);
//		a2.setProcessTime(3);
//		a2.setResource(r);
//		a2.setIsSensible(1);
//		
//		final Actor a3 = SockFactory.eINSTANCE.createActor();
//		a3.setName("c");
//		a3.setPeriodTime(35);
//		a3.setProcessTime(4);
//		a3.setResource(r);
//		a3.setIsSensible(0);
//		
//		final Actor a4 = SockFactory.eINSTANCE.createActor();
//		a4.setName("d");
//		a4.setPeriodTime(40);
//		a4.setProcessTime(1);
//		a4.setResource(r);
//		a4.setIsSensible(0);
		
		// S 0
		
		final Actor a1 = SockFactory.eINSTANCE.createActor();
		a1.setName("a");
		a1.setPeriodTime(30);
		a1.setProcessTime(2);
		a1.setResource(r); 
		a1.setIsSensible(0);
		
		final Actor a2 = SockFactory.eINSTANCE.createActor();
		a2.setName("b");
		a2.setPeriodTime(25);
		a2.setProcessTime(1);
		a2.setResource(r); 
		a2.setIsSensible(0);
		
		final Actor a3 = SockFactory.eINSTANCE.createActor();
		a3.setName("c");
		a3.setPeriodTime(10); 
		a3.setProcessTime(1);
		a3.setResource(r); 
		a3.setIsSensible(0);
		
		final Actor a4 = SockFactory.eINSTANCE.createActor();
		a4.setName("d");
		a4.setPeriodTime(15);
		a4.setProcessTime(1);
		a4.setResource(r);
		a4.setIsSensible(0);
		
		s.getOwnedActor().add(a1);
		s.getOwnedActor().add(a2);
		s.getOwnedActor().add(a3);
		s.getOwnedActor().add(a4);
		s.getOwnedResource().add(r);
		
		final int lcm = Utils.lcm(s.getOwnedActor().stream().map(Actor::getPeriodTime).collect(Collectors.toList()));
		System.out.println("LCM " +s.getOwnedActor().stream().map(Actor::getPeriodTime).collect(Collectors.toList()) + " = " + lcm);
		
		// 1>[[0 ; 5] {5}, [16 ; 21] {5}, [26 ; 37] {11}, [47 ; 55] {8}, [62 ; 67] {5}]
//		ScheduLeak.initInstance(s).busyInterval.add(new Interval(0, 5));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(16, 21));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(26, 37));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(47, 55));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(62, 67));
		// 1>[[0 ; 12] {12}, [16 ; 21] {5}, [26 ; 40] {14}, [47 ; 59] {12}, [62 ; 67] {5}]
//		ScheduLeak.initInstance(s).busyInterval.add(new Interval(0, 12));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(16, 21));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(26, 40));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(47, 59));
//		ScheduLeak.getInstance().busyInterval.add(new Interval(62, 67));
//		1>[[0 ; 12] {13}, [16 ; 21] {6}, [26 ; 39] {14}, [46 ; 58] {13}, [61 ; 67] {7}]
//		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 12));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(16, 21));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(26, 39));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(46, 58));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(61, 67));
//		Utils.indicesOfTakesOver.put(a2, new ArrayList<>());
//		Utils.indicesOfTakesOver.get(a2).add(31);
//		[[0 ; 13] {14}, [16 ; 22] {7}, [26 ; 39] {14}, [46 ; 58] {13}, [61 ; 68] {8}]
//		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 13));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(16, 22));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(26, 39));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(46, 58));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(62, 68));
//		Utils.indicesOfTakesOver.put(a2, new ArrayList<>());
//		Utils.indicesOfTakesOver.get(a2).add(2);
//		Utils.indicesOfTakesOver.get(a2).add(32);
		// S4
//		[[0 ; 14] {15}, [21 ; 24] {4}, [31 ; 34] {4}, [36 ; 46] {11}, [51 ; 54] {4}, [61 ; 64] {4}]
//		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 14));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(21, 24));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(31, 34));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(36, 46));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(51, 54));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(61, 64));
		// S0
//		[[0 ; 28] {29}, [41 ; 44] {4}, [46 ; 70] {25}, [81 ; 84] {4}, [91 ; 115] {25}, [121 ; 124] {4}, [136 ; 159] {24}, [161 ; 164] {4}]
//		{fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl@6a14422 (name: a2060070) (isSensible: 0, processTime: 4, periodTime: 45, currentProcessTime: 4, code: null)=[101], 
//		fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl@25c2ca6d (name: a3060070) (isSensible: 1, processTime: 4, periodTime: 45, currentProcessTime: 4, code: null)=[21, 61]}
//		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 28));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(41, 44));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(46, 70));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(81, 84));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(91, 115));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(121, 124));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(136, 159));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(161, 164));
//		Utils.indicesOfTakesOver.put(a3, new ArrayList<>());
//		Utils.indicesOfTakesOver.get(a3).add(101);
//		Utils.indicesOfTakesOver.put(a4, new ArrayList<>());
//		Utils.indicesOfTakesOver.get(a4).add(21);
//		Utils.indicesOfTakesOver.get(a4).add(61);
		// S1
//		[[0 ; 15] {16}, [21 ; 24] {4}, [26 ; 37] {12}, [41 ; 44] {4}, [51 ; 66] {16}, [76 ; 91] {16}]
//		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 15));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(21, 24));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(26, 37));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(41, 44));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(51, 66));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(76, 91));
//		{fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl@33ab30b1 (name: ar02) (isSensible: 0, processTime: 4, periodTime: 35, currentProcessTime: 4, code: null)=[41]}
//		Utils.indicesOfTakesOver.put(a3, new ArrayList<>());
//		Utils.indicesOfTakesOver.get(a3).add(41);
//		Utils.indicesOfTakesOver.get(a3).add(221);
//		Utils.indicesOfTakesOver.get(a3).add(461);
//		Utils.indicesOfTakesOver.get(a3).add(641);
////		[[0 ; 19] {20}, [21 ; 25] {5}, [31 ; 51] {21}, [61 ; 77] {17}, [81 ; 88] {8}, [91 ; 96] {6}, [101 ; 111] {11}, [121 ; 134] {14}, [141 ; 157] {17},
//		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 19));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(21, 25));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(31, 51));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(61, 77));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(81, 88));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(91, 96));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(101, 111));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(121, 134));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(141, 157));
////		[161 ; 168] {8}, [176 ; 192] {17}, [201 ; 208] {8}, [211 ; 228] {18}, [241 ; 265] {25}, [271 ; 276] {6}, [281 ; 294] {14}, [301 ; 311] {11},
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(161, 168));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(176, 192));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(201, 208));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(211, 228));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(241, 265));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(271, 276));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(281, 294));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(301, 311));
////		[316 ; 329] {14}, [331 ; 336] {6}, [341 ; 345] {5}, [351 ; 356] {6}, [361 ; 374] {14}, [381 ; 397] {17}, [401 ; 408] {8}, [421 ; 437] {17},
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(316, 329));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(331, 336));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(341, 345));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(351, 356));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(361, 374));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(381, 397));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(401, 408));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(421, 437));
////		[441 ; 448] {8}, [451 ; 468] {18}, [481 ; 505] {25}, [511 ; 516] {6}, [521 ; 534] {14}, [541 ; 551] {11}, [561 ; 585] {25}, [596 ; 615] {20},
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(441, 448));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(451, 468));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(511, 516));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(521, 534));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(541, 551));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(561, 585));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(596, 615));
////		[621 ; 625] {5}, [631 ; 651] {21}, [661 ; 677] {17}, [681 ; 688] {8}, [691 ; 696] {6}, [701 ; 711] {11}, [721 ; 734] {14}, [736 ; 746] {11},
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(621, 625));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(631, 651));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(661, 677));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(681, 688));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(691, 696));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(701, 711));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(721, 734));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(736, 746));
////		[751 ; 756] {6}, [761 ; 768] {8}, [771 ; 776] {6}, [781 ; 791] {11}, [801 ; 825] {25}]
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(751, 756));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(761, 768));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(771, 776));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(781, 791));
//		ScheduLeak.getInstance().busyIntervals.add(new Interval(801, 825));
//		[[0 ; 19] {20}, [21 ; 23] {3}, [26 ; 28] {3}, [31 ; 43] {13}, [46 ; 48] {3}, [51 ; 56] {6}, [61 ; 73] {13}, [76 ; 84] {9}, [91 ; 109] {19}, 
		ScheduLeak.initInstance(s).busyIntervals.add(new Interval(0, 19));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(21, 23));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(26, 28));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(31, 43));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(46, 48));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(51, 56));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(61, 73));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(76, 84));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(91, 109));
//		[111 ; 113] {3}, [121 ; 144] {24}]
		ScheduLeak.getInstance().busyIntervals.add(new Interval(111, 113));
		ScheduLeak.getInstance().busyIntervals.add(new Interval(121, 144));
//		{fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl@5c6b5d80 (name: ar00) 
//		(isSensible: 0, processTime: 2, periodTime: 30, currentProcessTime: 2, code: null)=[11, 131, 136]}
		Utils.indicesOfTakesOver.put(a1, new ArrayList<>());
		Utils.indicesOfTakesOver.get(a1).add(11);
		Utils.indicesOfTakesOver.get(a1).add(131);
		Utils.indicesOfTakesOver.get(a1).add(136);
		
		ScheduLeak.getInstance().run();
	}
	
}
