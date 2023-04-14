package fr.inria.kairos.sock.dsl.attacks.sidechannel.steps;

public class TheoremOne {
	
	public static int[] theoremOne(int duration, int computationTime, int periodTime) {
		for (int i = 0; i < duration; i++) {
			if (theoremOneEquationOne(duration, computationTime, periodTime, i)) {
				return new int[] { i };
			} else if (theoremOneEquationTwo(duration, computationTime, periodTime, i)) {
				return new int[] { i, i + 1 }; // and i + 1
			}
		}
		throw new RuntimeException("Should have found a candidate for N");
	}

	private static boolean theoremOneEquationOne(int duration, int computationTime, int periodTime, int candidate) {
		// C(ωk) < N · pi + ci <=>
		// C(ωk) - ci < N · pi <=>
		// (C(ωk) - ci) / pi < N

		// (N·pi−ci)+ ≤C(ωk) <=>
		// N ≤ (C(ωk) + ci) / pi

		// (C(ωk) - ci) / pi < N ≤ (C(ωk) + ci) / pi <=> (N·pi−ci)+ ≤C(ωk)<N·pi+ci
//		System.out.println( 
//				((float) (duration - computationTime) / (float) periodTime) 
//				+ " < " + candidate + " <= " +
//				((float) (duration + computationTime) / (float) periodTime)
//		);
		return ((float) (duration - computationTime) / (float) periodTime) < candidate
				&& candidate <= ((float) (duration + computationTime) / (float) periodTime);
	}

	private static boolean theoremOneEquationTwo(int duration, int computationTime, int periodTime, int candidate) {
		// C(ωk)<(N+1)·pi−ci <=>
		// (C(ωk) + ci) / pi < N+1 <=>
		// ((C(ωk) + ci) / pi) - 1 < N

		// N·pi+ci ≤C(ωk) <=>
		// N ≤ (C(ωk) - ci) / pi
		// ((C(ωk) + ci) / pi) - 1 < N ≤ (C(ωk) - ci) / pi <=> N·pi+ci
		// ≤C(ωk)<(N+1)·pi−ci

		// N·pi+ci ≤C(ωk) <=> N ≤ (C(ωk) - ci) / pi
		// C(ωk)<(N+1)·pi−ci <=> ((C(ωk) + ci) / pi) - 1 < N
//		System.out.println( 
//				((float) (duration + computationTime) / (float) periodTime) - 1
//				+ " < " + candidate + " <= " +
//				((float) (duration - computationTime) / (float) periodTime)
//		);
		return ((float) (duration + computationTime) / (float) periodTime) - 1 < candidate
				&& candidate <= ((float) (duration - computationTime) / (float) periodTime);
	}

}
