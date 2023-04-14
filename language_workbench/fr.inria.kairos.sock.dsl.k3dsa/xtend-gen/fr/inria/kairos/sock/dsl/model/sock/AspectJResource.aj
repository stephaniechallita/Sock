// AspectJ classes that have been aspectized and name
package fr.inria.kairos.sock.dsl.model.sock;
public aspect AspectJResource{
void around (fr.inria.kairos.sock.dsl.model.sock.Resource self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Resource.isEntered( fr.inria.kairos.sock.dsl.model.sock.Actor,java.lang.String ) ) ) { fr.inria.kairos.sock.aspects.ResourceAspect.isEntered(self,(fr.inria.kairos.sock.dsl.model.sock.Actor)thisJoinPoint.getArgs()[0],(java.lang.String)thisJoinPoint.getArgs()[1] );}
void around (fr.inria.kairos.sock.dsl.model.sock.Resource self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Resource.isProcessed(  ) ) ) { fr.inria.kairos.sock.aspects.ResourceAspect.isProcessed(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Resource self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Resource.isExited(  ) ) ) { fr.inria.kairos.sock.aspects.ResourceAspect.isExited(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Resource self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Resource.clean(  ) ) ) { fr.inria.kairos.sock.aspects.ResourceAspect.clean(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Resource self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Resource.idle(  ) ) ) { fr.inria.kairos.sock.aspects.ResourceAspect.idle(self );}

}
