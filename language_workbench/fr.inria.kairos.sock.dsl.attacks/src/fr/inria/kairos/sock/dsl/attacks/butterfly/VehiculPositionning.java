package fr.inria.kairos.sock.dsl.attacks.butterfly;

import java.util.ArrayList;
import java.util.List;

import fr.inria.kairos.sock.utils.IOUtils;

public class VehiculPositionning {
	
	public static final VehiculPositionning instance = new VehiculPositionning();
	
	private int timeToIncreaseSpeed;
	
	private int targetSpeed;
	
	public VehiculPositionning() {
		this.timeToIncreaseSpeed = 120;
		this.targetSpeed = 1000;
	}
	
	public VehiculPositionning(int timeToIncreaseSpeed, int targetSpeed) {
		this.timeToIncreaseSpeed = timeToIncreaseSpeed;
		this.targetSpeed = targetSpeed;
	}
	
	public int new_order(int time) {
		final List<String> speeds = IOUtils.readFile(IOUtils.PATH_OUTPUT + "speed");
		final int currentSpeed = IOUtils.get(speeds, 1, 1);
		int targetSpeed = 0;
		if ( time >= timeToIncreaseSpeed ) {
			targetSpeed = this.targetSpeed;
		}
		int diffSpeed = targetSpeed - currentSpeed;
		IOUtils.write(time, diffSpeed + " ", IOUtils.PATH_OUTPUT + "order");
		return 1;
	}

	public int order(int time) {
		final List<String> speeds = IOUtils.readFile(IOUtils.PATH_OUTPUT + "speed");
		final int currentSpeed = IOUtils.get(speeds, 1, 1);
		int targetSpeed = 0;
		if ( time >= timeToIncreaseSpeed ) {
			targetSpeed = this.targetSpeed;
		}
		int diffSpeed = Math.abs(targetSpeed - currentSpeed);
		int signDiffSpeed = (targetSpeed - currentSpeed) / (diffSpeed > 0 ? diffSpeed : 1);
		int order = this.computeOrder(diffSpeed, currentSpeed);
		if (order == Integer.MIN_VALUE) {
			// here we are a bit hacking the system
			IOUtils.write(time, targetSpeed - currentSpeed + ">", IOUtils.PATH_OUTPUT + "order");	
		} else {
			IOUtils.write(time, (signDiffSpeed * order) + " ", IOUtils.PATH_OUTPUT + "order");	
		}
		return 1;
	}
	
	private int computeOrder(int diffSpeed, int currentSpeed) {
		if (diffSpeed == 0) {
			return 0;
		} else if (diffSpeed < 5) {
			return Integer.MIN_VALUE;
		} else {
			for (int i = 0 ; i < NB_RATES ; i++) {
//				final int rate = (int)((i * (1.0D / (float)ACCELERATION.size())) * this.targetSpeed);
				final int rate = (int)(RATES.get(i) * this.targetSpeed);
				if (diffSpeed < rate) {
					System.out.println(
							diffSpeed + " " + rate + " " + 
							(1.0D / (float)ACCELERATION.size()) + " " +
							(i * (1.0D / (float)ACCELERATION.size())) + " " +
							(i * (1.0D / (float)ACCELERATION.size())) * this.targetSpeed + " " +
							ACCELERATION.get(i) + " " +
							RATES.get(i) * this.targetSpeed
					);
					return ACCELERATION.get(i);
				}
			}
		}
		return ACCELERATION.get(ACCELERATION.size() - 1);
	}
	
	public static final List<Float> RATES = new ArrayList<Float>();
	
	public static final List<Integer> ACCELERATION = new ArrayList<Integer>();
	
	static {
		ACCELERATION.add(0);
		RATES.add(0.0F);
		ACCELERATION.add(1);
		RATES.add(0.05F);
		ACCELERATION.add(3);
		RATES.add(0.1F);
		ACCELERATION.add(5);
		RATES.add(0.25F);
		ACCELERATION.add(10);
		RATES.add(0.5F);
		ACCELERATION.add(15);
		RATES.add(0.75F);
		ACCELERATION.add(25);
		RATES.add(0.F);
	}; 

	public static final int NB_RATES = ACCELERATION.size();
	
}
