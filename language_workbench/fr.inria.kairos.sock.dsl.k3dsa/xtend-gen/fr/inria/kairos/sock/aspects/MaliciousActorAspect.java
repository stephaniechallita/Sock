package fr.inria.kairos.sock.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.kairos.sock.dsl.model.sock.MaliciousActor;
import org.eclipse.xtext.xbase.lib.InputOutput;

@Aspect(className = MaliciousActor.class)
@SuppressWarnings("all")
public class MaliciousActorAspect extends ActorAspect {
  public static void stealSensibleInformationFromResource(final MaliciousActor _self) {
    final fr.inria.kairos.sock.aspects.MaliciousActorAspectMaliciousActorAspectProperties _self_ = fr.inria.kairos.sock.aspects.MaliciousActorAspectMaliciousActorAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void stealSensibleInformationFromResource()
    if (_self instanceof fr.inria.kairos.sock.dsl.model.sock.MaliciousActor){
    	fr.inria.kairos.sock.aspects.MaliciousActorAspect._privk3_stealSensibleInformationFromResource(_self_, (fr.inria.kairos.sock.dsl.model.sock.MaliciousActor)_self);
    };
  }

  protected static void _privk3_stealSensibleInformationFromResource(final MaliciousActorAspectMaliciousActorAspectProperties _self_, final MaliciousActor _self) {
    Integer _lastActorSensibility = ResourceAspect.lastActorSensibility(_self.getResource());
    boolean _equals = ((_lastActorSensibility).intValue() == 1);
    if (_equals) {
      String _currentData = ResourceAspect.currentData(_self.getResource());
      boolean _notEquals = (!Objects.equal(_currentData, ""));
      if (_notEquals) {
        String _name = _self.getName();
        String _plus = ("WARNING: The resource " + _name);
        String _plus_1 = (_plus + " may have leak the following secret:");
        InputOutput.<String>println(_plus_1);
        InputOutput.<String>println(ResourceAspect.currentData(_self.getResource()));
      }
    }
  }
}
