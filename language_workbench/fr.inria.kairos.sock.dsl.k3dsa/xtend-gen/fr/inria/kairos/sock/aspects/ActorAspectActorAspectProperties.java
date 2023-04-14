package fr.inria.kairos.sock.aspects;

import java.util.Random;

@SuppressWarnings("all")
public class ActorAspectActorAspectProperties {
  public Integer isSensible = Integer.valueOf(0);
  
  public Integer processTime = Integer.valueOf(3);
  
  public Integer periodTime = Integer.valueOf(25);
  
  public String secret = Integer.valueOf(new Random().nextInt()).toString();
  
  public Integer currentProcessTime = Integer.valueOf(0);
  
  public String code = "";
  
  public final String folder = "/Users/stephaniechallita/Desktop/runtime-EclipseApplication/";
  
  public String subFolder = "";
  
  public Integer actorTimeIndex = Integer.valueOf(0);
}
