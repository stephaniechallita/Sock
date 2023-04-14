package fr.inria.kairos.sock.aspects;

import fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties;
import fr.inria.kairos.sock.dsl.model.sock.Actor;
import java.util.Map;

@SuppressWarnings("all")
public class ActorAspectActorAspectContext {
  public final static ActorAspectActorAspectContext INSTANCE = new ActorAspectActorAspectContext();
  
  public static ActorAspectActorAspectProperties getSelf(final Actor _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Actor, ActorAspectActorAspectProperties> map = new java.util.WeakHashMap<fr.inria.kairos.sock.dsl.model.sock.Actor, fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties>();
  
  public Map<Actor, ActorAspectActorAspectProperties> getMap() {
    return map;
  }
}
