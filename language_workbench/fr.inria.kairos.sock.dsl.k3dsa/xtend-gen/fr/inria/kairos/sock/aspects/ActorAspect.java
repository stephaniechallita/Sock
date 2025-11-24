package fr.inria.kairos.sock.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.ReplaceAspectMethod;
import fr.inria.diverse.k3.al.annotationprocessor.SynchroField;
import fr.inria.kairos.sock.dsl.attacks.sidechannel.ScheduLeak;
import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;
import fr.inria.kairos.sock.utils.IOUtils;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.io.File;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@Aspect(className = Actor.class)
@SuppressWarnings("all")
public class ActorAspect extends NamedElementAspect {
  @ReplaceAspectMethod
  public static void ready(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void ready()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_ready(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  private static Actor lastExitedActor = null;

  private static Integer anActorEntered = Integer.valueOf((-1));

  private static Integer anActorExited = Integer.valueOf((-2));

  @ReplaceAspectMethod
  public static void enterIn(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void enterIn()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_enterIn(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  @ReplaceAspectMethod
  public static void process(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void process()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_process(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  @ReplaceAspectMethod
  public static void exitOf(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void exitOf()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_exitOf(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  @ReplaceAspectMethod
  public static void idle(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void idle()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_idle(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  public static void createIfDoesNotExists(final Actor _self, final String pathfolder) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void createIfDoesNotExists(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_createIfDoesNotExists(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,pathfolder);
    };
  }

  public static void initFolder(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void initFolder()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_initFolder(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  public static void write(final Actor _self, final String action) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void write(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_write(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,action);
    };
  }

  public static void write(final Actor _self, final String action, final String filename) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void write(String,String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_write(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,action,filename);
    };
  }

  public static boolean checkSensible(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# boolean checkSensible()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_checkSensible(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (boolean)result;
  }

  public static void run(final Actor _self, final String message) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void run(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_run(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,message);
    };
  }

  public static void time(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void time()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_time(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  public static void untime(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void untime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_untime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
  }

  @SynchroField
  public static Integer isSensible(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer isSensible()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_isSensible(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.Integer)result;
  }

  @SynchroField
  public static void isSensible(final Actor _self, final Integer isSensible) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void isSensible(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_isSensible(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,isSensible);
    };
  }

  @SynchroField
  public static Integer processTime(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer processTime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_processTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.Integer)result;
  }

  @SynchroField
  public static void processTime(final Actor _self, final Integer processTime) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void processTime(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_processTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,processTime);
    };
  }

  @SynchroField
  public static Integer periodTime(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer periodTime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_periodTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.Integer)result;
  }

  @SynchroField
  public static void periodTime(final Actor _self, final Integer periodTime) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void periodTime(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_periodTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,periodTime);
    };
  }

  public static String secret(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String secret()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_secret(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.String)result;
  }

  public static void secret(final Actor _self, final String secret) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void secret(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_secret(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,secret);
    };
  }

  @SynchroField
  public static Integer currentProcessTime(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer currentProcessTime()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_currentProcessTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.Integer)result;
  }

  @SynchroField
  public static void currentProcessTime(final Actor _self, final Integer currentProcessTime) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void currentProcessTime(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_currentProcessTime(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,currentProcessTime);
    };
  }

  @SynchroField
  public static String code(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String code()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_code(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.String)result;
  }

  @SynchroField
  public static void code(final Actor _self, final String code) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void code(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_code(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,code);
    };
  }

  public static String folder(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String folder()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_folder(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.String)result;
  }

  public static String subFolder(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String subFolder()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_subFolder(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.String)result;
  }

  public static void subFolder(final Actor _self, final String subFolder) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void subFolder(String)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_subFolder(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,subFolder);
    };
  }

  public static Integer actorTimeIndex(final Actor _self) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Integer actorTimeIndex()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	result = fr.inria.kairos.sock.aspects.ActorAspect._privk3_actorTimeIndex(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self);
    };
    return (java.lang.Integer)result;
  }

  public static void actorTimeIndex(final Actor _self, final Integer actorTimeIndex) {
    final fr.inria.kairos.sock.aspects.ActorAspectActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.ActorAspectActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void actorTimeIndex(Integer)
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.Actor){
    	fr.inria.kairos.sock.aspects.ActorAspect._privk3_actorTimeIndex(_self_, (fr.inria.kairos.sock.dsl.model.sock.Actor)_self,actorTimeIndex);
    };
  }

  protected static void _privk3_ready(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    ActorAspect.write(_self, "+");
    EObject _eContainer = _self.eContainer();
    ScheduLeak.ready(((IotSystem) _eContainer), (ActorAspect.actorTimeIndex(_self)).intValue());
    String _name = _self.getName();
    String _plus = (_name + " is ready");
    ActorAspect.run(_self, _plus);
  }

  protected static void _privk3_enterIn(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    ActorAspect.initFolder(_self);
    EObject _eContainer = _self.eContainer();
    ScheduLeak.busy(((IotSystem) _eContainer), (ActorAspect.actorTimeIndex(_self)).intValue());
    ActorAspect.anActorEntered = ActorAspect.actorTimeIndex(_self);
    ActorAspect.write(_self, "1");
    int _currentProcessTime = _self.getCurrentProcessTime();
    int _processTime = _self.getProcessTime();
    boolean _equals = (_currentProcessTime == _processTime);
    if (_equals) {
      _self.setCurrentProcessTime(0);
    }
    Resource _resource = _self.getResource();
    String _name = _self.getName();
    String _plus = (_name + " ");
    String _secret = ActorAspect.secret(_self);
    String _plus_1 = (_plus + _secret);
    ResourceAspect.isEntered(_resource, _self, _plus_1);
    String _name_1 = _self.getName();
    String _plus_2 = (_name_1 + " enters in ");
    String _name_2 = _self.getResource().getName();
    String _plus_3 = (_plus_2 + _name_2);
    ActorAspect.run(_self, _plus_3);
  }

  protected static void _privk3_process(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    int _currentProcessTime = _self.getCurrentProcessTime();
    int _plus = (_currentProcessTime + 1);
    _self.setCurrentProcessTime(_plus);
    EObject _eContainer = _self.eContainer();
    ScheduLeak.busy(((IotSystem) _eContainer), (ActorAspect.actorTimeIndex(_self)).intValue());
    ResourceAspect.isProcessed(_self.getResource());
    String _name = _self.getName();
    String _plus_1 = (_name + " processes (");
    int _currentProcessTime_1 = _self.getCurrentProcessTime();
    String _plus_2 = (_plus_1 + Integer.valueOf(_currentProcessTime_1));
    String _plus_3 = (_plus_2 + "/");
    int _processTime = _self.getProcessTime();
    String _plus_4 = (_plus_3 + Integer.valueOf(_processTime));
    String _plus_5 = (_plus_4 + ") {");
    String _name_1 = _self.getResource().getName();
    String _plus_6 = (_plus_5 + _name_1);
    String _plus_7 = (_plus_6 + "}");
    ActorAspect.run(_self, _plus_7);
  }

  protected static void _privk3_exitOf(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    EObject _eContainer = _self.eContainer();
    ScheduLeak.busy(((IotSystem) _eContainer), (ActorAspect.actorTimeIndex(_self)).intValue());
    ActorAspect.anActorExited = ActorAspect.actorTimeIndex(_self);
    ActorAspect.lastExitedActor = _self;
    ActorAspect.write(_self, "0");
    ResourceAspect.isExited(_self.getResource());
    boolean _checkSensible = ActorAspect.checkSensible(_self);
    if (_checkSensible) {
      ActorAspect.time(_self);
      ActorAspect.write(_self, "-");
      EObject _eContainer_1 = _self.eContainer();
      ScheduLeak.busy(((IotSystem) _eContainer_1), (ActorAspect.actorTimeIndex(_self)).intValue());
      ActorAspect.untime(_self);
    }
    int _currentProcessTime = _self.getCurrentProcessTime();
    int _processTime = _self.getProcessTime();
    boolean _lessThan = (_currentProcessTime < _processTime);
    if (_lessThan) {
      EObject _eContainer_2 = _self.eContainer();
      ScheduLeak.takesOver(((IotSystem) _eContainer_2), (ActorAspect.actorTimeIndex(_self)).intValue(), _self);
    } else {
      if (((_self.getCode() != null) && (_self.getCode() != ""))) {
        try {
          final Binding binding = new Binding();
          binding.setVariable("time", ActorAspect.actorTimeIndex(_self));
          EObject _eContainer_3 = _self.eContainer();
          String _name = ((IotSystem) _eContainer_3).getName();
          String _plus = (_name + "/");
          binding.setVariable("outputFolder", _plus);
          final ClassLoader ucl = ActorAspect.class.getClassLoader();
          final GroovyShell shell = new GroovyShell(ucl, binding);
          Object _evaluate = shell.evaluate(_self.getCode());
          final Integer energyCost = ((Integer) _evaluate);
          String _plus_1 = (energyCost + "");
          String _name_1 = _self.getName();
          String _plus_2 = (_name_1 + "_energy");
          ActorAspect.write(_self, _plus_1, _plus_2);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception cnfe = (Exception)_t;
            String _code = _self.getCode();
            String _plus_3 = ("Failed to call Groovy script " + _code);
            InputOutput.<String>println(_plus_3);
            cnfe.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    String _name = _self.getName();
    String _plus = (_name + " exits of ");
    String _name_1 = _self.getResource().getName();
    String _plus_1 = (_plus + _name_1);
    ActorAspect.run(_self, _plus_1);
  }

  protected static void _privk3_idle(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    ActorAspect.time(_self);
  }

  protected static void _privk3_createIfDoesNotExists(final ActorAspectActorAspectProperties _self_, final Actor _self, final String pathfolder) {
    final File fd = new File(pathfolder);
    boolean _exists = fd.exists();
    boolean _not = (!_exists);
    if (_not) {
      fd.mkdir();
    }
  }

  protected static void _privk3_initFolder(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    ActorAspect.createIfDoesNotExists(_self, ActorAspect.folder(_self));
    boolean _isEmpty = ActorAspect.subFolder(_self).isEmpty();
    if (_isEmpty) {
      EObject _eContainer = _self.eContainer();
      String _name = ((IotSystem) _eContainer).getName();
      String _plus = (_name + "/");
      ActorAspect.subFolder(_self, _plus);
    }
    String _folder = ActorAspect.folder(_self);
    String _plus_1 = (_folder + "/");
    String _subFolder = ActorAspect.subFolder(_self);
    String _plus_2 = (_plus_1 + _subFolder);
    ActorAspect.createIfDoesNotExists(_self, _plus_2);
  }

  protected static void _privk3_write(final ActorAspectActorAspectProperties _self_, final Actor _self, final String action) {
    ActorAspect.write(_self, action, _self.getName());
  }

  protected static void _privk3_write(final ActorAspectActorAspectProperties _self_, final Actor _self, final String action, final String filename) {
    Integer _actorTimeIndex = ActorAspect.actorTimeIndex(_self);
    String _subFolder = ActorAspect.subFolder(_self);
    String _plus = (_subFolder + "/");
    String _plus_1 = (_plus + filename);
    IOUtils.write((_actorTimeIndex).intValue(), action, _plus_1);
  }

  protected static boolean _privk3_checkSensible(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    int _isSensible = _self.getIsSensible();
    return (_isSensible == 1);
  }

  protected static void _privk3_run(final ActorAspectActorAspectProperties _self_, final Actor _self, final String message) {
    Integer _actorTimeIndex = ActorAspect.actorTimeIndex(_self);
    String _plus = ("[" + _actorTimeIndex);
    String _plus_1 = (_plus + "] ");
    String _plus_2 = (_plus_1 + message);
    InputOutput.<String>println(_plus_2);
    ActorAspect.time(_self);
  }

  protected static void _privk3_time(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    Integer _actorTimeIndex = ActorAspect.actorTimeIndex(_self);
    int _plus = ((_actorTimeIndex).intValue() + 1);
    ActorAspect.actorTimeIndex(_self, Integer.valueOf(_plus));
  }

  protected static void _privk3_untime(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    Integer _actorTimeIndex = ActorAspect.actorTimeIndex(_self);
    int _minus = ((_actorTimeIndex).intValue() - 1);
    ActorAspect.actorTimeIndex(_self, Integer.valueOf(_minus));
  }

  protected static Integer _privk3_isSensible(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getIsSensible") &&
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
    return _self_.isSensible;
  }

  protected static void _privk3_isSensible(final ActorAspectActorAspectProperties _self_, final Actor _self, final Integer isSensible) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setIsSensible")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, isSensible);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.isSensible = isSensible;
    }
  }

  protected static Integer _privk3_processTime(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getProcessTime") &&
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
    return _self_.processTime;
  }

  protected static void _privk3_processTime(final ActorAspectActorAspectProperties _self_, final Actor _self, final Integer processTime) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setProcessTime")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, processTime);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.processTime = processTime;
    }
  }

  protected static Integer _privk3_periodTime(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getPeriodTime") &&
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
    return _self_.periodTime;
  }

  protected static void _privk3_periodTime(final ActorAspectActorAspectProperties _self_, final Actor _self, final Integer periodTime) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setPeriodTime")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, periodTime);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.periodTime = periodTime;
    }
  }

  protected static String _privk3_secret(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getSecret") &&
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
    return _self_.secret;
  }

  protected static void _privk3_secret(final ActorAspectActorAspectProperties _self_, final Actor _self, final String secret) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setSecret")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, secret);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.secret = secret;
    }
  }

  protected static Integer _privk3_currentProcessTime(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentProcessTime") &&
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
    return _self_.currentProcessTime;
  }

  protected static void _privk3_currentProcessTime(final ActorAspectActorAspectProperties _self_, final Actor _self, final Integer currentProcessTime) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCurrentProcessTime")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, currentProcessTime);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.currentProcessTime = currentProcessTime;
    }
  }

  protected static String _privk3_code(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCode") &&
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
    return _self_.code;
  }

  protected static void _privk3_code(final ActorAspectActorAspectProperties _self_, final Actor _self, final String code) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCode")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, code);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.code = code;
    }
  }

  protected static String _privk3_folder(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getFolder") &&
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
    return _self_.folder;
  }

  protected static String _privk3_subFolder(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getSubFolder") &&
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
    return _self_.subFolder;
  }

  protected static void _privk3_subFolder(final ActorAspectActorAspectProperties _self_, final Actor _self, final String subFolder) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setSubFolder")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, subFolder);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.subFolder = subFolder;
    }
  }

  protected static Integer _privk3_actorTimeIndex(final ActorAspectActorAspectProperties _self_, final Actor _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getActorTimeIndex") &&
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
    return _self_.actorTimeIndex;
  }

  protected static void _privk3_actorTimeIndex(final ActorAspectActorAspectProperties _self_, final Actor _self, final Integer actorTimeIndex) {
    boolean setterCalled = false;
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setActorTimeIndex")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, actorTimeIndex);
    			setterCalled = true;
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    if (!setterCalled) {
    	_self_.actorTimeIndex = actorTimeIndex;
    }
  }
}
