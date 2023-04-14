package fr.inria.kairos.sock.aspects;

import fr.inria.kairos.sock.aspects.NamedElementAspectNamedElementAspectProperties;
import fr.inria.kairos.sock.dsl.model.sock.NamedElement;
import java.util.Map;

@SuppressWarnings("all")
public class NamedElementAspectNamedElementAspectContext {
  public final static NamedElementAspectNamedElementAspectContext INSTANCE = new NamedElementAspectNamedElementAspectContext();
  
  public static NamedElementAspectNamedElementAspectProperties getSelf(final NamedElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.kairos.sock.aspects.NamedElementAspectNamedElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NamedElement, NamedElementAspectNamedElementAspectProperties> map = new java.util.WeakHashMap<fr.inria.kairos.sock.dsl.model.sock.NamedElement, fr.inria.kairos.sock.aspects.NamedElementAspectNamedElementAspectProperties>();
  
  public Map<NamedElement, NamedElementAspectNamedElementAspectProperties> getMap() {
    return map;
  }
}
