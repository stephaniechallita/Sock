package fr.inria.kairos.sock.generator.model;

public abstract class NamedElement {
	
	protected String name;
	
	public NamedElement(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
