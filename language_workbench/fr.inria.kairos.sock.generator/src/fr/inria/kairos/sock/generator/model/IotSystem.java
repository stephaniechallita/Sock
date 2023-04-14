package fr.inria.kairos.sock.generator.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fr.inria.kairos.sock.generator.io.SideChannelAttackReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import static fr.inria.kairos.sock.generator.GeneratorHelper.NEW_LINE;

public class IotSystem extends NamedElement {

	private Set<Actor> ownedActor;

	private Set<Resource> ownedResource;

	public IotSystem(String name) {
		super(name);
		this.ownedActor = new HashSet<>();
		this.ownedResource = new HashSet<>();
	}

	public Set<Actor> getOwnedActor() {
		return ownedActor;
	}

	public Set<Resource> getOwnedResource() {
		return ownedResource;
	}

	public boolean isSchedulable() {
		return this.isSchedulable(true);
	}

	public boolean isSchedulable(boolean withFlushTask) {
		for (Resource resource : this.getOwnedResource()) {
			if (!resource.isSchedulable(withFlushTask)) {
				return false;
			}
		}
		return true;
	}

	public String toLatexPerResource() {
		final int nbActorPerResource = 5;
		List<String> rowsResource = new ArrayList<>();
		List<Resource> resources = new ArrayList<>(this.getOwnedResource());
		Collections.sort(resources, new Comparator<Resource>() {
			@Override
			public int compare(Resource a, Resource b) {
				return a.getName().compareTo(b.getName());
			}
		});
		for (Resource resource : resources) {
			String actors = "\\begin{tabular}{l}\t";
			int nbSubList = resource.getActors().size() / nbActorPerResource;
			for (int i = 0; i < nbSubList; i++) {
				actors += new ArrayList<>(resource.getActors())
						.subList(i * nbActorPerResource, Math.min((i + 1) * nbActorPerResource, resource.getActors().size())).stream().map(Actor::toLatex)
						.collect(Collectors.joining(", ")) + "\\\\";
			}
			actors += new ArrayList<>(resource.getActors())
					.subList(nbSubList * nbActorPerResource, Math.min((nbSubList + 1) * nbActorPerResource, resource.getActors().size())).stream()
					.map(Actor::toLatex).collect(Collectors.joining(", "));
			actors += "\\end{tabular}";
			rowsResource.add(Arrays.stream(new String[] {
					resource.getName(),
					resource.getHyperPeriod() + "",
					actors
			}).collect(Collectors.joining("\t&\t")) + "\\\\");
		}
		return rowsResource.stream().collect(Collectors.joining("\n"));
	}

	public String toLatex() {
		String actors = "";
		actors = "\\begin{tabular}{l}\t";
		int nbSubList = this.getOwnedActor().size() / 3;
		for (int i = 0; i < nbSubList; i++) {
			actors += new ArrayList<>(this.getOwnedActor())
					.subList(i * 3, Math.min((i + 1) * 3, this.getOwnedActor().size())).stream().map(Actor::toLatex)
					.collect(Collectors.joining(", ")) + "\\\\";
		}
		actors += new ArrayList<>(this.getOwnedActor())
				.subList(nbSubList * 3, Math.min((nbSubList + 1) * 3, this.getOwnedActor().size())).stream()
				.map(Actor::toLatex).collect(Collectors.joining(", "));
		actors += "\\end{tabular}";
		return Arrays
				.stream(new String[] { "" + this.getOwnedActor().size(),
						"" + new ArrayList<>(this.getOwnedResource()).get(0).getHyperPeriod(), actors,
						SideChannelAttackReader.formatResult(SideChannelAttackReader.readResultFor(this)) })
				.collect(Collectors.joining("\t&\t")) + "\\\\";
	}

	public String toTSock() {
		final List<Actor> sortedActor = new ArrayList<>(this.ownedActor);
		Collections.sort(sortedActor, new Comparator<Actor>() {
			@Override
			public int compare(Actor a, Actor b) {
				return a.getName().compareTo(b.getName());
			}
		});
		final List<Resource> sortedResource = new ArrayList<>(this.ownedResource);
		Collections.sort(sortedResource, new Comparator<Resource>() {
			@Override
			public int compare(Resource a, Resource b) {
				return a.getName().compareTo(b.getName());
			}
		});
		
		return "IotSystem " + this.name + " {" + NEW_LINE + "\tcurrentTime 0" + NEW_LINE + "\townedActor {" + NEW_LINE
				+ sortedActor.stream().map(a -> a.toTSock()).collect(Collectors.joining("," + NEW_LINE)) + NEW_LINE
				+ "\t}" + NEW_LINE + "\townedResource {" + NEW_LINE
				+ sortedResource.stream().map(r -> r.toTSock()).collect(Collectors.joining("," + NEW_LINE))
				+ NEW_LINE + "\t}" + NEW_LINE + "}";

	}

}
