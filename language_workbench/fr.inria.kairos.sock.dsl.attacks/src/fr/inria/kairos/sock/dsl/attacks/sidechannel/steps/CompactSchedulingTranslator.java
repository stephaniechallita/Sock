package fr.inria.kairos.sock.dsl.attacks.sidechannel.steps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.utils.Interval;
import fr.inria.kairos.sock.utils.Utils;

public class CompactSchedulingTranslator {

	private IotSystem system;

	public CompactSchedulingTranslator(IotSystem system) {
		this.system = system;
	}

	public static class Record {
		public int indexActor;
		public int arrivalTime;
		public int timeProcess;

		public Record(int indexActor, int arrivalTime, int timeProcess) {
			super();
			this.indexActor = indexActor;
			this.arrivalTime = arrivalTime;
			this.timeProcess = timeProcess;
		}

		public Record(Record record) {
			this.indexActor = record.indexActor;
			this.arrivalTime = record.arrivalTime;
			this.timeProcess = record.timeProcess;
		}

		@Override
		public String toString() {
			return this.indexActor + " {" + this.arrivalTime + "}" + "[" + this.timeProcess + "]";
		}
	}

	public List<Record> run(Interval busyInterval, List<Record> arrivalTimes) {
		final Queue<Record> aQueue = new LinkedList<>();
		final Queue<Record> sQueue = new LinkedList<>();
		final List<Record> startTimeForEachTaskWithinBusyInterval = new ArrayList<Record>();
		new ArrayList<>(arrivalTimes).stream().sorted(new Comparator<Record>() {
			@Override
			public int compare(Record a, Record b) {
				if (a.arrivalTime == b.arrivalTime) {
					final Actor actorA = system.getOwnedActor().get(a.indexActor);
					final Actor actorB = system.getOwnedActor().get(b.indexActor);
					return actorA.getPeriodTime() - actorB.getPeriodTime();
				} else {
					return a.arrivalTime - b.arrivalTime;
				}
			}
		}).forEach(aQueue::add);
//		System.out.println("aQueue> " + aQueue);
		Record current = aQueue.poll();
		startTimeForEachTaskWithinBusyInterval.add(current);
		while (! (aQueue.isEmpty() && sQueue.isEmpty())) {
			Record next = this.getNext(aQueue, sQueue);
			if (current.arrivalTime == next.arrivalTime ||
					(!nextIsPriorOverCurrent(current, next) && next.arrivalTime < current.arrivalTime + current.timeProcess)) { // could have start in the same, but no
				next.arrivalTime = current.arrivalTime + current.timeProcess;
			} else if (nextIsPriorOverCurrent(current, next) && 
					current.arrivalTime + current.timeProcess > next.arrivalTime &&
					!isExiting(current, next)) { // has been taken over
//				System.out.println("1>" + current);
//				System.out.println("2>" + next);
				current = new Record(current);
				current.arrivalTime = next.arrivalTime + next.timeProcess;
				current.timeProcess -= current.arrivalTime - next.arrivalTime;
//				System.out.println("3>" + current);
				sQueue.add(current);
			}  else if (nextIsPriorOverCurrent(current, next) && 
					current.arrivalTime + current.timeProcess > next.arrivalTime &&
					isExiting(current, next)) {
				next.arrivalTime = current.arrivalTime + current.timeProcess;
			}
			startTimeForEachTaskWithinBusyInterval.add(new Record(next));
//			System.out.println("aQ > " + aQueue);
//			System.out.println("sQ > " + sQueue);
			current = new Record(next);
//			System.out.println("current > " + current);
		}
		return startTimeForEachTaskWithinBusyInterval;
	}
	
	private boolean isExiting(Record current, Record next) {
//		System.out.println((current.arrivalTime + current.timeProcess) - next.arrivalTime);
		return (current.arrivalTime + current.timeProcess) - next.arrivalTime ==
				(this.system.getOwnedActor().get(current.indexActor).getIsSensible() == 1 ? 2 : 1);
	}
	
	private boolean nextIsPriorOverCurrent(Record current, Record next) {
		final Actor currentActor = this.system.getOwnedActor().get(current.indexActor);
		final Actor nextActor = this.system.getOwnedActor().get(next.indexActor);
		return currentActor.getPeriodTime() > nextActor.getPeriodTime();
	}

	private Record getNext(Queue<Record> aQueue, Queue<Record> sQueue) {
		if (sQueue.isEmpty()) {
			return aQueue.poll();
		}
		if (aQueue.isEmpty()) {
			return sQueue.poll();
		}
		Record aQueueNext = aQueue.peek();
		Record sQueueNext = sQueue.peek();
		if (sQueueNext.arrivalTime < aQueueNext.arrivalTime) {
			return sQueue.poll();
		} else {
			return aQueue.poll();
		}
	}

}
