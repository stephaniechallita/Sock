// AspectJ classes that have been aspectized and name
package fr.inria.kairos.sock.dsl.model.sock;
public aspect AspectJActor{
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Actor.ready(  ) ) ) { fr.inria.kairos.sock.aspects.ActorAspect.ready(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Actor.enterIn(  ) ) ) { fr.inria.kairos.sock.aspects.ActorAspect.enterIn(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Actor.process(  ) ) ) { fr.inria.kairos.sock.aspects.ActorAspect.process(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Actor.exitOf(  ) ) ) { fr.inria.kairos.sock.aspects.ActorAspect.exitOf(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) && (call ( void fr.inria.kairos.sock.dsl.model.sock.Actor.idle(  ) ) ) { fr.inria.kairos.sock.aspects.ActorAspect.idle(self );}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void Actor.setIsSensible(java.lang.Integer)){fr.inria.kairos.sock.aspects.ActorAspect.isSensible(self, (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void fr.inria.kairos.sock.aspects.ActorAspect.isSensible(fr.inria.kairos.sock.dsl.model.sock.Actor,java.lang.Integer)){self.setIsSensible( (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void Actor.setProcessTime(java.lang.Integer)){fr.inria.kairos.sock.aspects.ActorAspect.processTime(self, (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void fr.inria.kairos.sock.aspects.ActorAspect.processTime(fr.inria.kairos.sock.dsl.model.sock.Actor,java.lang.Integer)){self.setProcessTime( (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void Actor.setPeriodTime(java.lang.Integer)){fr.inria.kairos.sock.aspects.ActorAspect.periodTime(self, (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void fr.inria.kairos.sock.aspects.ActorAspect.periodTime(fr.inria.kairos.sock.dsl.model.sock.Actor,java.lang.Integer)){self.setPeriodTime( (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void Actor.setCurrentProcessTime(java.lang.Integer)){fr.inria.kairos.sock.aspects.ActorAspect.currentProcessTime(self, (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void fr.inria.kairos.sock.aspects.ActorAspect.currentProcessTime(fr.inria.kairos.sock.dsl.model.sock.Actor,java.lang.Integer)){self.setCurrentProcessTime( (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void Actor.setCode(java.lang.String)){fr.inria.kairos.sock.aspects.ActorAspect.code(self, (java.lang.String)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.Actor self)  :target (self) &&  call ( void fr.inria.kairos.sock.aspects.ActorAspect.code(fr.inria.kairos.sock.dsl.model.sock.Actor,java.lang.String)){self.setCode( (java.lang.String)thisJoinPoint.getArgs()[0]);proceed(self);
}

}
