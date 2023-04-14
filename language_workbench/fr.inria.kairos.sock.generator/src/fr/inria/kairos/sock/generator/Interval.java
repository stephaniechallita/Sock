package fr.inria.kairos.sock.generator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.inria.kairos.sock.generator.model.IotSystem;

public class Interval {
	
	public final double i;
	public final double j;

	public Interval(double i, double j) {
		this.i = i;
		this.j = j;
	}

	public boolean check(double toBeChecked) {
		return this.i <= toBeChecked && toBeChecked <= this.j;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Interval && this.hashCode() == o.hashCode();
	}

	@Override
	public int hashCode() {
		return (int) (Float.parseFloat(String.format("%.2f", this.i)) * 100);
	}

	public String toString() {
		return "[" + String.format("%.2f", this.i) + ";" + String.format("%.2f", this.j) + "]";
	}

	public String format() {
		return String.format("%.2f", this.i).replaceAll("\\.", "")
				+ String.format("%.2f", this.j).replaceAll("\\.", "");
	}
	
	public static Map<Interval, List<IotSystem>> initInterval() {
		final Map<Interval, List<IotSystem>> intervals = new LinkedHashMap<>();
		for (int i = 0 ; i < 10 ; i++) {
			intervals.put(
					new Interval(0.02D + (0.1D * (double)i),  0.08d + (0.1d * (double)i)), new ArrayList<>()
			);
		}
		return intervals;
	}
	
	public String toDot() {
		return String.format("%.2f", (this.i + this.j) / 2.0D); 
	}
}