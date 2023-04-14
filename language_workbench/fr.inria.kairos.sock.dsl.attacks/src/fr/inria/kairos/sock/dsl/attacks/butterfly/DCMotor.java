package fr.inria.kairos.sock.dsl.attacks.butterfly;

import java.util.List;

import fr.inria.kairos.sock.utils.IOUtils;

public class DCMotor {

	private final int period = 30;
	
	private int lastOrder = 0;
	
	private int lastTimeOrder = 0;
	
	private int lastAcceleration = 0;

	public final static DCMotor instance = new DCMotor();

	public DCMotor() {
	}
	
	public int accelerate(int time) {
		int energyCost = 0;
		final List<String> orders = IOUtils.readFile(IOUtils.PATH_OUTPUT + "order");
		final int consideredPeriod;
		final int currentOrder;
		final List<String> speeds = IOUtils.readFile(IOUtils.PATH_OUTPUT + "speed");
		final int lastSpeed = IOUtils.get(speeds, 1, 1);
		int currentSpeed = lastSpeed;
		int currentAcceleration = lastAcceleration; 
		if ((!orders.isEmpty()) &&
				orders.get(orders.size() - 1).endsWith(">")) {
			final int lastOrder = 
					Integer.parseInt(orders.get(orders.size() - 1).split(" ")[1].split(">")[0]);
			consideredPeriod = Math.abs(lastOrder);
			currentOrder = lastOrder < 0 ? -1 : 1;
			for (int i = 0 ; i < consideredPeriod ; i++) {
				energyCost += Math.abs(currentAcceleration);
				currentSpeed = currentSpeed + currentOrder;
				IOUtils.write(time + i, currentSpeed, IOUtils.PATH_OUTPUT + "speed");
			}
		} else {
			consideredPeriod = this.period;
			currentOrder = IOUtils.get(orders, 1, 1);	
			for (int i = 0 ; i < consideredPeriod ; i++) {
				energyCost += Math.abs(currentAcceleration);
				currentSpeed = currentSpeed + currentAcceleration;
				IOUtils.write(time + i, currentSpeed, IOUtils.PATH_OUTPUT +"speed");
				if (currentAcceleration != currentOrder) {
					currentAcceleration += (currentOrder < currentAcceleration ? -1 : +1);
				}
			}
		}
		
		this.lastAcceleration = currentAcceleration;
		return energyCost;
	}
	
	// Let's say 1 point of energy cost for each acceleration points
	public int oldaccelerate(int time) {
		int energyCost = 0;
		final List<String> orders = IOUtils.readFile("order");
		final List<String> speeds = IOUtils.readFile("speed");
		final int lastSpeed = IOUtils.get(speeds, 1, 1);
		int lastTime = IOUtils.get(speeds, 1, 0);
		int currentSpeed = lastSpeed;
		if ((!orders.isEmpty()) && orders.get(orders.size() - 1).endsWith(">")) {
			if (Math.abs(lastOrder) == 1) {
				IOUtils.write(time, (currentSpeed + lastOrder) + "", "speed");
				return 1;
			}
			energyCost += lastOrder * (lastOrder > 0 ? 1 : -1);
			for (int i = lastTime + 1; i < time; i++) {
				if (Math.abs(lastOrder) != 1) {
					lastOrder += lastOrder > 0 ? -1 : 1;
				}
				IOUtils.write(i, (currentSpeed + lastOrder) + "", "speed");
			}
			return energyCost;
		}
		this.lastOrder = IOUtils.get(orders, 2, 1);
		final int currentOrder = IOUtils.get(orders, 1, 1);
		int indexLastOrder = VehiculPositionning.ACCELERATION.indexOf(lastOrder < 0 ? lastOrder * -1 : lastOrder);
		int indexCurrentOrder = VehiculPositionning.ACCELERATION
				.indexOf(currentOrder < 0 ? currentOrder * -1 : currentOrder);
		int currentIndexAcceleration = indexLastOrder;
		int signOfCurrentOrder = currentOrder < 0 ? -1 : 1;
		if (lastOrder * currentOrder < 0) {
			for (int i = indexLastOrder; i != indexCurrentOrder;) {
				lastTime++;
				int currentAcceleration = VehiculPositionning.ACCELERATION.get(i);
				currentSpeed += currentAcceleration * signOfCurrentOrder;
				energyCost += currentAcceleration;
				IOUtils.write(lastTime, currentSpeed + " " + currentAcceleration * signOfCurrentOrder, "speed");
				if (lastTime % 2 == 0) {
					i = i + signOfCurrentOrder;
				}
			}
			for (int i = lastTime + 1; i < time; i++) {
				int currentAcceleration = VehiculPositionning.ACCELERATION.get(indexCurrentOrder);
				currentSpeed += currentAcceleration * signOfCurrentOrder;
				energyCost += currentAcceleration;
				IOUtils.write(i, currentSpeed + " " + currentAcceleration * signOfCurrentOrder, "speed");
			}
		} else {
			for (int i = lastTime + 1; i < time; i++) {
				int currentAcceleration = VehiculPositionning.ACCELERATION.get(currentIndexAcceleration);
				currentSpeed += currentAcceleration * signOfCurrentOrder;
				energyCost += currentAcceleration;
				IOUtils.write(i, currentSpeed + "", "speed");
				if (i % 2 == 0) {
					if (currentIndexAcceleration < indexCurrentOrder) {
						currentIndexAcceleration++;
					} else if (currentIndexAcceleration > indexCurrentOrder) {
						currentIndexAcceleration--;
					}
				}
			}
		}
		return energyCost;
	}

}
