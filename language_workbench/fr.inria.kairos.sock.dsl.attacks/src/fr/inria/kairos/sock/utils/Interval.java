package fr.inria.kairos.sock.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Interval {
	
	public enum Category {NONE, Interval_1, Interval_0_1, Interval_0};
	
	public final int time1;
	public final int time2;
	public final Category category;
	
	public Interval(Interval interval) {
		this.time1 = interval.time1;
		this.time2 = interval.time2;
		this.category = interval.category;
	}
	
	public static final Interval EMPTY = new Interval(-1, -1);
	
	public boolean isWithin(int candidate) {
		return this.time1 <= candidate &&
				candidate <= this.time2;
	}
	
	public Interval intersection(Interval other) {
		Interval intersection = new Interval(
					Math.max(other.time1, this.time1),
					Math.min(other.time2, this.time2)
				);
//		System.out.println(this.toString() + " N " + other.toString() + " = " + intersection.toString());
		return intersection;
	}
	
	public List<Interval> convert(int max) {
		final List<Interval> res = new ArrayList<>();
		Interval interval = new Interval(
					this.time1 % max, 
					this.time2 % max,
					this.category
				);
		res.add(interval);
		if (interval.getDuration() < 0) {
			interval = new Interval(
					this.time1 % max,
					max - 1,
					this.category
			);
			Interval interval2 = new Interval(
					0,
					this.time2 % max,
					this.category
			);
			res.clear();
			res.add(interval);
			res.add(interval2);
		}
		return res;
	}
	
	public Interval(int time1, int time2) {
		this(time1, time2, Category.NONE);
	}
	
	public Interval(int time1, int time2, Category category) {
		this.time1 = time1;
		this.time2 = time2;
		this.category = category;
	}
	
	public int getDuration() {
		return this.time2 - this.time1 + 1;
	}
	
	@Override
	public String toString() {
		return "[" + this.time1 + " ; " + this.time2 + "] {"+ (this.getDuration()) +"}" + 
					(this.category != Category.NONE ? " " + this.category.toString() : "");
 	}
	
	@Override
	public boolean equals(Object o) {
		return o != null && this.toString().equals(o.toString());
	}

}
