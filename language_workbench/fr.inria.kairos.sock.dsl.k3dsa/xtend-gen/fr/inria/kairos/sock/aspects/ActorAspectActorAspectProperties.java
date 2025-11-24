package fr.inria.kairos.sock.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.SynchroField;
import java.util.Random;

@SuppressWarnings("all")
public class ActorAspectActorAspectProperties {
  @SynchroField
  public Integer isSensible = Integer.valueOf(0);

  @SynchroField
  public Integer processTime = Integer.valueOf(3);

  @SynchroField
  public Integer periodTime = Integer.valueOf(25);

  public String secret = Integer.valueOf(new Random().nextInt()).toString();

  @SynchroField
  public Integer currentProcessTime = Integer.valueOf(0);

  @SynchroField
  public String code = "";

  public final String folder = "/Users/stephaniechallita/Desktop/runtime-EclipseApplication/";

  public String subFolder = "";

  public Integer actorTimeIndex = Integer.valueOf(0);
}
