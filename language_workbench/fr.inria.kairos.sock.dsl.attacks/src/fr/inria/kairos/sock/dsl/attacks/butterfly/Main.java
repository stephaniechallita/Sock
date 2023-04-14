package fr.inria.kairos.sock.dsl.attacks.butterfly;

import java.io.File;

import fr.inria.kairos.sock.utils.IOUtils;

public class Main {
	
	public static void main(String [] args) {
		IOUtils.PATH_OUTPUT = IOUtils.BASE_PATH_OUTPUT + "dis_java/";
		run(15); // DisabledButterflyAttack
		IOUtils.PATH_OUTPUT = IOUtils.BASE_PATH_OUTPUT + "en_java/";
		run(60); // EnabledButterflyAttack/
	}
	
	public static void run(int periodVehiculPositionning) {
		new File(IOUtils.PATH_OUTPUT + "/order").delete();
		new File(IOUtils.PATH_OUTPUT + "/speed").delete();
		final int timeToSpeedUp = 120;
		final int targetSpeed = 1000;
		final DCMotor m = new DCMotor();
		final VehiculPositionning v = new VehiculPositionning(timeToSpeedUp, targetSpeed);
		final int maxTime = 600;
		for (int i = 0 ; i < maxTime ; i++) {
			if (i % periodVehiculPositionning == 0) {
				v.order(i);
			}
			if (i % 30 == 0) {
				m.accelerate(i);
			}
		}
	}

}
