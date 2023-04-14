// AspectJ classes that have been aspectized and name
package fr.inria.kairos.sock.dsl.model.sock;
public aspect AspectJIotSystem{
void around (fr.inria.kairos.sock.dsl.model.sock.IotSystem self)  :target (self) &&  call ( void IotSystem.setCurrentTime(java.lang.Integer)){fr.inria.kairos.sock.aspects.IotSystemAspect.currentTime(self, (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}
void around (fr.inria.kairos.sock.dsl.model.sock.IotSystem self)  :target (self) &&  call ( void fr.inria.kairos.sock.aspects.IotSystemAspect.currentTime(fr.inria.kairos.sock.dsl.model.sock.IotSystem,java.lang.Integer)){self.setCurrentTime( (java.lang.Integer)thisJoinPoint.getArgs()[0]);proceed(self);
}

}
