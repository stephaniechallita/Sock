package fr.inria.kairos.sock.utils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;

import fr.inria.kairos.sock.dsl.model.sock.Actor;

public class Utils {
	
	/**
	 * Looks into the first project of the workspace for a sock.properties file
	 * @return Properties
	 */
	public static Properties getSockProperties() {
		final String absolutePathToSockProperties = ResourcesPlugin.getWorkspace().getRoot().getProjects()[0]
				.getFile(IOUtils.PATH_PROPERTIES).getLocation().toOSString();
		System.out.println(IOUtils.readFile(absolutePathToSockProperties));
		Properties sockProperties = new Properties();
		try {
			sockProperties.load(new FileReader(absolutePathToSockProperties));
			return sockProperties;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int lcm(List<Integer> integers) {
		Collections.sort(integers);
		final int[] lcm = new int[] {integers.get(integers.size() - 1)};
		while (true) {
			if (integers.stream().allMatch(integer -> lcm[0] % integer == 0)) {
				return lcm[0];
			} else {
				lcm[0]++;
			}
		}
	}
	
	public static int getSmallest(List<int[]> estimationsN, int indexActor) {
		int smallest = Integer.MAX_VALUE;
		for(int[] array : estimationsN) {
			if (array[indexActor] < smallest) {
				smallest = array[indexActor];
			}
		}
		return smallest;
	}
	
	public static final Map<Actor, List<Integer>> indicesOfTakesOver = new HashMap<>();
	
	private static final int enterTaskCost = 1;
	
	private static final int exitTaskCost = 1;
	
	private static final int flushTaskCost = 1;
	
	public static int computeRealProcessTime(Actor actor, Interval time) {
//		System.out.println(actor.getName() + " " + time + " " + (indicesOfTakesOver.containsKey(actor) ?
//				indicesOfTakesOver.get(actor).stream().filter(time::isWithin).count() : 0));
		 return (int) (actor.getProcessTime() + enterTaskCost + exitTaskCost
			+ (actor.getIsSensible() == 1 ? flushTaskCost : 0) + 
			(indicesOfTakesOver.containsKey(actor) ?
					indicesOfTakesOver.get(actor).stream().filter(time::isWithin).count() : 0));
	}
	
//	public static int computeRealProcessTime(Actor actor, Interval time) {
//		 return actor.getProcessTime() + enterTaskCost + exitTaskCost
//			+ (actor.getIsSensible() == 1 ? flushTaskCost : 0);
//	}
	
//	public static int computeRealProcessTime(Actor actor, Interval time) {
//		 return actor.getProcessTime();
//	}

}
