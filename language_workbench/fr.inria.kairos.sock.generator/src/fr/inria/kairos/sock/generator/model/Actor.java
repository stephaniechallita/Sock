package fr.inria.kairos.sock.generator.model;

import static fr.inria.kairos.sock.generator.GeneratorHelper.NEW_LINE;

public class Actor extends NamedElement {
	
	public static int flushTaskCost = 1;
	
	public static int enterTaskCost = 1;
	
	public static int exitTaskCost = 1;
	
	private final Resource resource;
	
	private final int isSensible;
	
	private final int processTime;

	private final int periodTime;
	
	private final String code;
	
	public Actor(String name, int isSensible, int processTime, int periodTime, Resource resource) {
		this(name, isSensible, processTime, periodTime, resource, "");
	}
	
	public Actor(String name, int isSensible, int processTime, int periodTime, Resource resource, String code) {
		super(name);
		this.isSensible = isSensible;
		this.processTime = processTime;
		this.periodTime = periodTime;
		this.resource = resource;
//		this.resource.addActor(this);
		this.code = code;
	}

	public Resource getResource() {
		return resource;
	}
	
	public double getScore() {
		return this.getScore(true);
	}

	public double getScore(boolean withFlushTask) {
		return  this.computeProccessTime(withFlushTask) / ((double)this.getPeriodTime());
	}
	
	public int getIsSensible() {
		return this.isSensible;
	}

	public int getProcessTime() {
		return processTime;
	}

	public int getPeriodTime() {
		return periodTime;
	}
	
	public double computeProccessTime(boolean withFlushTask) {
		return this.getProcessTime() + Actor.enterTaskCost + Actor.exitTaskCost
				+ (withFlushTask && this.getIsSensible() == 1 ? Actor.flushTaskCost : 0);
	}
	
	public String toTSock() {
		return "\t\tActor " + this.getName() + " {" + NEW_LINE +
					"\t\t\tisSensible " + this.getIsSensible() + NEW_LINE +
					"\t\t\tprocessTime " + this.getProcessTime() + NEW_LINE +
					"\t\t\tperiodTime " + this.getPeriodTime() + NEW_LINE +
					"\t\t\tcurrentProcessTime 0" + NEW_LINE +
					"\t\t\tresource \"" + this.resource.getName() + "\"" + NEW_LINE +
					(this.code.isEmpty() ? "" : "\t\t\tcode \"" + this.formatCode() + "\"" + NEW_LINE) +
				"\t\t}";
	}
	
	private String formatCode() {
		return this.code.replaceAll("\"", "\\\"");
	}
	
	public String toLatex() {
		return String.format("(%d, %d, %s)" , this.getPeriodTime(), this.processTime, this.getIsSensible() == 1? "\\cmark" : "\\xmark");
	}

	@Override
	public String toString() {
		return "Actor [resource=" + resource.getName() + ", isSensible=" + getIsSensible() + ", processTime=" + processTime
				+ ", periodTime=" + periodTime + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
	
}
