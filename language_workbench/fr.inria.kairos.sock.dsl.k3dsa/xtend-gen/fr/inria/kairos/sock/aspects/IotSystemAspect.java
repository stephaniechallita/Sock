package fr.inria.kairos.sock.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.SynchroField;
import fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties;
import fr.inria.kairos.sock.aspects.NamedElementAspect;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;

@Aspect(className = IotSystem.class)
@SuppressWarnings("all")
public class IotSystemAspect extends NamedElementAspect {
  public static void time(final IotSystem _self) {
    final fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties _self_ = fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void time()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.IotSystem){
    	fr.inria.kairos.sock.aspects.IotSystemAspect._privk3_time(_self_, (fr.inria.kairos.sock.dsl.model.sock.IotSystem)_self);
    };
  }
  
  @SynchroField
  public static Integer currentTime(final IotSystem _self) {
    final fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties _self_ = fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer currentTime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.IotSystem){
    	result = fr.inria.kairos.sock.aspects.IotSystemAspect._privk3_currentTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.IotSystem)_self);
    };
    return (java.lang.Integer)result;
  }
  
  @SynchroField
  public static void currentTime(final IotSystem _self, final Integer currentTime) {
    final fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectProperties _self_ = fr.inria.kairos.sock.aspects.IotSystemAspectIotSystemAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void currentTime(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.IotSystem){
    	fr.inria.kairos.sock.aspects.IotSystemAspect._privk3_currentTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.IotSystem)_self,currentTime);
    };
  }
  
  protected static void _privk3_time(final IotSystemAspectIotSystemAspectProperties _self_, final IotSystem _self) {
    int _currentTime = _self.getCurrentTime();
    int _plus = (_currentTime + 1);
    _self.setCurrentTime(_plus);
  }
  
  protected static Integer _privk3_currentTime(final IotSystemAspectIotSystemAspectProperties _self_, final IotSystem _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentTime") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.lang.Integer) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.currentTime;
  }
  
  protected static void _privk3_currentTime(final IotSystemAspectIotSystemAspectProperties _self_, final IotSystem _self, final Integer currentTime) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCurrentTime")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, currentTime);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.currentTime = currentTime;
    }
  }
}
