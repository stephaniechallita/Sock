package fr.inria.kairos.sock.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.ReplaceAspectMethod;
import fr.inria.kairos.sock.dsl.attacks.sidechannel.ScheduLeak;
import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;

@Aspect(className = Resource.class)
@SuppressWarnings("all")
public class ResourceAspect extends NamedElementAspect {
  @ReplaceAspectMethod
  public static void isEntered(final Resource _self, final Actor actor, final String secret) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void isEntered(Actor,String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_isEntered(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self,actor,secret);
    };
  }

  @ReplaceAspectMethod
  public static void isProcessed(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void isProcessed()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_isProcessed(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
  }

  @ReplaceAspectMethod
  public static void isExited(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void isExited()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_isExited(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
  }

  @ReplaceAspectMethod
  public static void clean(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void clean()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_clean(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
  }

  @ReplaceAspectMethod
  public static void idle(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void idle()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_idle(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
  }

  public static void run(final Resource _self, final String message) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void run(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_run(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self,message);
    };
  }

  public static void time(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void time()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_time(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
  }

  public static void untime(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void untime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_untime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
  }

  public static String currentData(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String currentData()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	result = fr.inria.kairos.sock.aspects.ResourceAspect._privk3_currentData(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
    return (java.lang.String)result;
  }

  public static void currentData(final Resource _self, final String currentData) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void currentData(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_currentData(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self,currentData);
    };
  }

  public static Integer lastActorSensibility(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer lastActorSensibility()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	result = fr.inria.kairos.sock.aspects.ResourceAspect._privk3_lastActorSensibility(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
    return (java.lang.Integer)result;
  }

  public static void lastActorSensibility(final Resource _self, final Integer lastActorSensibility) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void lastActorSensibility(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_lastActorSensibility(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self,lastActorSensibility);
    };
  }

  private static Integer startingIdleIntervalTime(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer startingIdleIntervalTime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	result = fr.inria.kairos.sock.aspects.ResourceAspect._privk3_startingIdleIntervalTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
    return (java.lang.Integer)result;
  }

  private static void startingIdleIntervalTime(final Resource _self, final Integer startingIdleIntervalTime) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void startingIdleIntervalTime(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_startingIdleIntervalTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self,startingIdleIntervalTime);
    };
  }

  public static Integer resourceTimeIndex(final Resource _self) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer resourceTimeIndex()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	result = fr.inria.kairos.sock.aspects.ResourceAspect._privk3_resourceTimeIndex(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self);
    };
    return (java.lang.Integer)result;
  }

  public static void resourceTimeIndex(final Resource _self, final Integer resourceTimeIndex) {
    final fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectProperties _self_ = fr.inria.kairos.sock.aspects.ResourceAspectResourceAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void resourceTimeIndex(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Resource){
    	fr.inria.kairos.sock.aspects.ResourceAspect._privk3_resourceTimeIndex(_self_, (fr.inria.kairos.sock.dsl.model.sock.Resource)_self,resourceTimeIndex);
    };
  }

  protected static void _privk3_isEntered(final ResourceAspectResourceAspectProperties _self_, final Resource _self, final Actor actor, final String secret) {
    ResourceAspect.currentData(_self, secret);
    ResourceAspect.lastActorSensibility(_self, Integer.valueOf(actor.getIsSensible()));
    String _name = _self.getName();
    String _plus = (_name + " is entered");
    ResourceAspect.run(_self, _plus);
  }

  protected static void _privk3_isProcessed(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    String _name = _self.getName();
    String _plus = (_name + " is busy");
    ResourceAspect.run(_self, _plus);
  }

  protected static void _privk3_isExited(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    String _name = _self.getName();
    String _plus = (_name + " is exited");
    ResourceAspect.run(_self, _plus);
  }

  protected static void _privk3_clean(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    Integer _resourceTimeIndex = ResourceAspect.resourceTimeIndex(_self);
    String _plus = ("[" + _resourceTimeIndex);
    String _plus_1 = (_plus + "] ");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + " clean");
    InputOutput.<String>println(_plus_3);
    String _name_1 = _self.getName();
    String _plus_4 = (_name_1 + " clean");
    ResourceAspect.run(_self, _plus_4);
    ResourceAspect.currentData(_self, "");
  }

  protected static void _privk3_idle(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    EObject _eContainer = _self.eContainer();
    ScheduLeak.idle(((IotSystem) _eContainer), (ResourceAspect.resourceTimeIndex(_self)).intValue());
    String _name = _self.getName();
    String _plus = (_name + " idle");
    ResourceAspect.run(_self, _plus);
  }

  protected static void _privk3_run(final ResourceAspectResourceAspectProperties _self_, final Resource _self, final String message) {
    ResourceAspect.time(_self);
  }

  protected static void _privk3_time(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    Integer _resourceTimeIndex = ResourceAspect.resourceTimeIndex(_self);
    int _plus = ((_resourceTimeIndex).intValue() + 1);
    ResourceAspect.resourceTimeIndex(_self, Integer.valueOf(_plus));
  }

  protected static void _privk3_untime(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    Integer _resourceTimeIndex = ResourceAspect.resourceTimeIndex(_self);
    int _minus = ((_resourceTimeIndex).intValue() - 1);
    ResourceAspect.resourceTimeIndex(_self, Integer.valueOf(_minus));
  }

  protected static String _privk3_currentData(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentData") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.lang.String) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.currentData;
  }

  protected static void _privk3_currentData(final ResourceAspectResourceAspectProperties _self_, final Resource _self, final String currentData) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCurrentData")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, currentData);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.currentData = currentData;
    }
  }

  protected static Integer _privk3_lastActorSensibility(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getLastActorSensibility") &&
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
    return _self_.lastActorSensibility;
  }

  protected static void _privk3_lastActorSensibility(final ResourceAspectResourceAspectProperties _self_, final Resource _self, final Integer lastActorSensibility) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setLastActorSensibility")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, lastActorSensibility);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.lastActorSensibility = lastActorSensibility;
    }
  }

  protected static Integer _privk3_startingIdleIntervalTime(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getStartingIdleIntervalTime") &&
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
    return _self_.startingIdleIntervalTime;
  }

  protected static void _privk3_startingIdleIntervalTime(final ResourceAspectResourceAspectProperties _self_, final Resource _self, final Integer startingIdleIntervalTime) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setStartingIdleIntervalTime")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, startingIdleIntervalTime);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.startingIdleIntervalTime = startingIdleIntervalTime;
    }
  }

  protected static Integer _privk3_resourceTimeIndex(final ResourceAspectResourceAspectProperties _self_, final Resource _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getResourceTimeIndex") &&
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
    return _self_.resourceTimeIndex;
  }

  protected static void _privk3_resourceTimeIndex(final ResourceAspectResourceAspectProperties _self_, final Resource _self, final Integer resourceTimeIndex) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setResourceTimeIndex")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, resourceTimeIndex);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.resourceTimeIndex = resourceTimeIndex;
    }
  }
}
