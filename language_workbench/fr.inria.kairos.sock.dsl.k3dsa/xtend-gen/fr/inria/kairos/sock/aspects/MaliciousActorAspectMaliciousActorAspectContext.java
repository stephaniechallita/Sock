package fr.inria.kairos.sock.aspects;

import fr.inria.kairos.sock.dsl.model.sock.MaliciousActor;
import java.util.Map;

@SuppressWarnings("all")
public class MaliciousActorAspectMaliciousActorAspectContext {
  public static final MaliciousActorAspectMaliciousActorAspectContext INSTANCE = new MaliciousActorAspectMaliciousActorAspectContext();

  public static MaliciousActorAspectMaliciousActorAspectProperties getSelf(final MaliciousActor _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.kairos.sock.aspects.MaliciousActorAspectMaliciousActorAspectProperties());
    		return INSTANCE.map.get(_self);
  }

  private Map<MaliciousActor, MaliciousActorAspectMaliciousActorAspectProperties> map = new java.util.WeakHashMap<fr.inria.kairos.sock.dsl.model.sock.MaliciousActor, fr.inria.kairos.sock.aspects.MaliciousActorAspectMaliciousActorAspectProperties>();

  public Map<MaliciousActor, MaliciousActorAspectMaliciousActorAspectProperties> getMap() {
    return map;
  }
}
