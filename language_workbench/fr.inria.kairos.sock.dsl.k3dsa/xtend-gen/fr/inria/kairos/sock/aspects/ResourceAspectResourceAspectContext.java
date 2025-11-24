package fr.inria.kairos.sock.aspects;

import fr.inria.kairos.sock.dsl.model.sock.Resource;
import java.util.Map;

@SuppressWarnings("all")
public class ResourceAspectResourceAspectContext {
  public static final ResourceAspectResourceAspectContext INSTANCE = new ResourceAspectResourceAspectContext();

  public static ResourceAspectResourceAspectProperties getSelf(final Resource _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties());
    		return INSTANCE.map.get(_self);
  }

  private Map<Resource, ResourceAspectResourceAspectProperties> map = new java.util.WeakHashMap<fr.inria.kairos.sock.dsl.model.sock.Resource, fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties>();

  public Map<Resource, ResourceAspectResourceAspectProperties> getMap() {
    return map;
  }
}
