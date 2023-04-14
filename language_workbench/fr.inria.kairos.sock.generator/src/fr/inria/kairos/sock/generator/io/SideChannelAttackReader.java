package fr.inria.kairos.sock.generator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import fr.inria.kairos.sock.generator.model.IotSystem;

public class SideChannelAttackReader {

	private static final String ROOT_PATH = "/Users/stephaniechallita/Desktop/workspace-models-2020/modeling_workbench/";
	
//	private static final String ROOT_PATH = "/Users/stephaniechallita/Desktop/workspace-models-2020/modeling_workbench";

	private static final String NAME_SCHEDULE = "schedule_r0";

	private static final String NAME_ATTACKED_SCHEDULE = "attack_schedule";

	private static final String SUFFIX_RND = "rnd";
	
	public static class Result {
		public final int total;
		public final int matching;
		public Result(int total, int matching) {
			this.total = total;
			this.matching = matching;
		}
		@Override
		public String toString() {
			return String.format("%.2f", this.toPerc());	
		}
		public float toPerc() {
			return (float) ((float) (matching) / (float) (total)) * 100.0f;
		}
	}
	
	public static String formatResult(Result [] results) {
		return results[0] + "\t&\t" + results[1];
	}

	public static Result[] readResultFor(IotSystem system) {
		final Map<Integer, String> schedule = getResult(system, ROOT_PATH + system.getName() + "/" + NAME_SCHEDULE);
		final Map<Integer, String> attackedSchedule = getResult(system,
				ROOT_PATH + system.getName() + "/" + NAME_ATTACKED_SCHEDULE);
		final Map<Integer, String> rndSchedule = getResult(system,
				ROOT_PATH + system.getName() + SUFFIX_RND + "/" + NAME_SCHEDULE);
		final Map<Integer, String> rndSttackedSchedule = getResult(system,
				ROOT_PATH + system.getName() + SUFFIX_RND + "/" + NAME_ATTACKED_SCHEDULE);
		return new Result[] {
				buildPercentage(schedule, attackedSchedule),
				buildPercentage(rndSchedule, rndSttackedSchedule)
		};
	}

	private static Result buildPercentage(final Map<Integer, String> schedule,
			final Map<Integer, String> attackedSchedule) {
		int maxAttackedTimestamp = Integer.MIN_VALUE;
		for (int attackedTimeStamp : attackedSchedule.keySet()) {
			if (attackedTimeStamp > maxAttackedTimestamp) {
				maxAttackedTimestamp = attackedTimeStamp;
			}
		}
		int total = schedule.size();
		int matching = 0;
		for (int timestamp : schedule.keySet()) {
			if (timestamp > maxAttackedTimestamp) {
				total--;
			} else if (check(timestamp, schedule, attackedSchedule)) {
				matching++;
			}
		}
		return new Result(total, matching);
//		return String.format("%.2f", (float) ((float) (matching) / (float) (total)) * 100.0f);
	}

	private static boolean check(int timestamp, final Map<Integer, String> schedule,
			final Map<Integer, String> attackedSchedule) {
		for (int i = 0; i < 2; i++) {
			final int attackedTimeStampWithError = timestamp + i;
			if (schedule.get(timestamp).equals(attackedSchedule.get(attackedTimeStampWithError))) {
				return true;
			}
		}
		return false;
	}

	private static Map<Integer, String> getResult(IotSystem system, String path) {
		final Map<Integer, String> schedule = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			reader.lines().forEach(line -> schedule.put(Integer.parseInt(line.split(" ")[1]), line.split(" ")[0]));
		} catch (Exception ignored) {
//			ignored.printStackTrace(); 
		}
		return schedule;
	}

}
