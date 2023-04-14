package fr.inria.kairos.sock.aspects;

import fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import java.util.Map;

@SuppressWarnings("all")
public class IotSystemAspectIotSystemAspectContext {
  public final static IotSystemAspectIotSystemAspectContext INSTANCE = new IotSystemAspectIotSystemAspectContext();
  
  public static IotSystemAspectIotSystemAspectProperties getSelf(final IotSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IotSystem, IotSystemAspectIotSystemAspectProperties> map = new java.util.WeakHashMap<fr.inria.kairos.sock.dsl.model.sock.IotSystem, fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties>();
  
  public Map<IotSystem, IotSystemAspectIotSystemAspectProperties> getMap() {
    return map;
  }
}
