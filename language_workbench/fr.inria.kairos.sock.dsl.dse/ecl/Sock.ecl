import 'http://kairos.inria.fr/sock'

import 'http://www.eclipse.org/emf/2002/Ecore'

ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/kernel.ccslLib"
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/CCSL.ccslLib"

ECLimport "platform:/resource/fr.inria.kairos.sock.dsl.moccml/mocc/resourceUsageCycle.moccml"
ECLimport "platform:/resource/fr.inria.kairos.sock.dsl.moccml/mocc/actorProcessingCycle.moccml"
ECLimport "platform:/resource/fr.inria.kairos.sock.dsl.moccml/mocc/isSensibleActor.moccml"


package sock

	-- ========================================================================================================
	--						BEGIN GLOBAL
	-- ========================================================================================================
	-- Mapping event and methods

	context IotSystem
		def : timeEvent : Event = self.time()
		def : zeroValue : Integer = 0
		
		
	-- ========================================================================================================
	--						BEGIN BUTTERFLY ATTACK
	-- ========================================================================================================
	
	-- Mapping event and methods
	
	context Actor
		def : butterflyAttackActorEvent : Event = self
		def : taskCompletedActorEvent : Event = self
		def : exitActorEvent : Event = self.exitOf()
		
	-- Constraints
	
	context Actor
		inv butterflyAttackAndExitIsTaskCompletedActorEvent:
			let unionButterflyAttackAndExit : Event = Expression Union(
				self.butterflyAttackActorEvent,
				self.exitActorEvent
			) in
			Relation Coincides(self.taskCompletedActorEvent, unionButterflyAttackAndExit)
		

	-- ========================================================================================================
	--						BEGIN RESOURCE USAGE CYCLE 
	-- 				This resource usage includes : 
	--					- the basic cycle enter process exit
	--					- the management of the time that the actor must process
	--					- the takes over by a high-priority actor from a resource of 
	--					a low-priority actor
	-- ========================================================================================================

	-- Mapping event and methods
	
	context Resource
		def : isEnteredResourceEvent : Event = self
		def : isProcessedResourceEvent : Event = self
		def : isExitedResourceEvent : Event = self
		def : idleResourceEvent : Event = self.idle()
		def : anActorIsTakenOverByAnotherOneResourceEvent : Event = self
	
	context  Actor
		def : enterActorEvent : Event = self.enterIn()
		def : processActorEvent : Event = self.process()
		def : idleActorEvent : Event = self.idle()
		def : processTimeActorValue : Integer = self.processTime
		def : isSensibleActorValue : Integer = self.isSensible
		def : isTakenOverActorEvent : Event = self.exitOf()
		def : takesOverActorEvent : Event = self.enterIn()
		def : periodStartActorEvent : Event = self.ready()
		
	-- Constraints
	
	context IotSystem
		inv oneTakeOverCoincidesWithOneIsTakenOverActor:
			let unionIsTakenOverForCoincidesWithTakesOver : Event = Expression Union(
				self.ownedActor.isTakenOverActorEvent
			) in
			let unionTakeOverForCoincidesWithIsTakenOver : Event = Expression Union(
				self.ownedActor.takesOverActorEvent
			) in
			Relation Coincides(
				unionTakeOverForCoincidesWithIsTakenOver,
				unionIsTakenOverForCoincidesWithTakesOver
			)
	
	context Resource
		inv isEnteredCoincidesWithOneActorEnter:
			let unionEnterForCoincides : Event = Expression Union(
				self.actor.enterActorEvent
			) in
			Relation Coincides(self.isEnteredResourceEvent, unionEnterForCoincides)
		inv isExitedCoincidesWithOneActorExit:
			let unionExitForCoincides : Event = Expression Union(
				self.actor.exitActorEvent
			) in
			Relation Coincides(self.isExitedResourceEvent, unionExitForCoincides)
		inv isProcessedCoincidesWithOneActorProcess:
			let unionProcessForCoincides : Event = Expression Union(
				self.actor.processActorEvent
			) in
			Relation Coincides(self.isProcessedResourceEvent, unionProcessForCoincides)
		inv AnActorIsTakenOverCoincidesWithOneActorIsTakenOver:
			let unionIsTakenOverForCoincides : Event = Expression Union(
				self.actor.isTakenOverActorEvent
			) in
			let unionTakeOverForCoincides : Event = Expression Union(
				self.actor.takesOverActorEvent
			) in
			let intersectionTakeOverIsTakenOverActorForCoincides : Event = Expression Intersection(
				unionIsTakenOverForCoincides,
				unionTakeOverForCoincides
			) in
			Relation Coincides(self.anActorIsTakenOverByAnotherOneResourceEvent, intersectionTakeOverIsTakenOverActorForCoincides)
		inv oneActorCanEnterInTheResourceInTheSameTimeBehavior:
			Relation Exclusion(self.actor.enterActorEvent)
		
	context Actor
		inv processTimeBehavior:
			Relation ActorProcessingCycle(
				self.enterActorEvent,
				self.processActorEvent,
				self.processTimeActorValue,
				self.exitActorEvent,
				self.idleActorEvent,
				self.isTakenOverActorEvent,
				self.takesOverActorEvent,
				self.periodStartActorEvent,
				self.butterflyAttackActorEvent
			)
		inv ActorCannotBeTakenOverAndTakesOverInTheSameTime:
			Relation Exclusion(
				self.takesOverActorEvent,
				self.isTakenOverActorEvent
			)
			
	-- ========================================================================================================
	--						BEGIN PERIODICITY 
	-- ========================================================================================================
	
	-- Mapping event and methods
	
	context Actor
		def : periodTimeActorValue  : Integer = self.periodTime
		
	--Constraints

	context Actor
		inv periodStartBehavior: 
			let periodStartDefinition : Event = Expression Periodic(
				self.oclAsType(ecore::EObject).eContainer().oclAsType(IotSystem).timeEvent,
				self.periodTimeActorValue,
				self.periodTimeActorValue
			) in
			Relation Coincides(self.periodStartActorEvent, periodStartDefinition)
		inv mustCompleteProcessAtEachPeriodActor:
			let periodStartFirstTickEvent : Event = Expression OneTickAndDie(
				self.oclAsType(ecore::EObject).eContainer().oclAsType(IotSystem).timeEvent
			) in
			let periodStartEvent : Event = Expression Concatenation(
				self.periodStartActorEvent,
				periodStartFirstTickEvent
			) in
			Relation Alternates(self.taskCompletedActorEvent, periodStartEvent)
	
	-- ========================================================================================================
	--						BEGIN RESOURCE CLEANING AFTER HIGH Sensible
	-- ========================================================================================================
	
	-- Mapping event and methods	
	
	context Resource
		def : cleanResourceEvent : Event = self.clean()
		
	context Actor
		def : exitSensibleActorEvent : Event = self
		def : exitNotSensibleActorEvent : Event = self
		
	-- Constraints
	
	context Actor
		inv unionExitWithOrWithoutSensibleCoincidesExitActor:
			let unionExitWithOrWithoutSensibleForCoincides :  Event = Expression Union(
				self.exitSensibleActorEvent,
				self.exitNotSensibleActorEvent			
			) in
			Relation Coincides(self.exitActorEvent, unionExitWithOrWithoutSensibleForCoincides)
		inv excludeExitWithAndWithoutSensibleActor:
			Relation Exclusion(self.exitSensibleActorEvent, self.exitNotSensibleActorEvent)
		inv SensibleOnExitBehavior:
			Relation IsSensibleActorRelation(
				self.exitSensibleActorEvent, 
				self.exitNotSensibleActorEvent,
				self.isSensibleActorValue
			)
	
	context Resource
		inv resourceUsageCycleBehavior:
			let unionSensibleActorExitForResourceUsageCycle : Event = Expression Union(
				self.actor.exitSensibleActorEvent
			) in
			let unionNotSensibleActorExitForResourceUsageCycle : Event = Expression Union(
				self.actor.exitNotSensibleActorEvent
			) in
			Relation ResourceUsageCycleRelation(
				self.isEnteredResourceEvent,
				unionNotSensibleActorExitForResourceUsageCycle,
				unionSensibleActorExitForResourceUsageCycle,
				self.isProcessedResourceEvent,
				self.idleResourceEvent,
				self.anActorIsTakenOverByAnotherOneResourceEvent,
				self.cleanResourceEvent
			)
			
	-- ========================================================================================================
	--						BEGIN TIME MANAGEMENT
	-- 		Every components must tick at each step
	--		Explicitly like if they do not do anything, they tick a clock doesNothing
	--		Component cannot doesNothing and something else (exclusion)
	-- ========================================================================================================
			
	-- Mapping event and methods
	
	-- Constraints
		
	context Actor
		inv unionEventsOfActorCoincidesWithTimeEvent:
			let unionEnterProcess : Event = Expression Union(
				self.enterActorEvent,
				self.processActorEvent
			) in
			let unionEnterProcessExit : Event = Expression Union(
				unionEnterProcess,
				self.exitActorEvent
			) in
			let unionEnterProcessExitIdle : Event = Expression Union(
				unionEnterProcessExit,
				self.idleActorEvent
			) in
			let unionEnterProcessExitIdleIsTakenOver : Event = Expression Union(
				unionEnterProcessExitIdle,
				self.isTakenOverActorEvent
			) in
			let unionEnterProcessExitIdleIsTakenOverTakesOver : Event = Expression Union(
				unionEnterProcessExitIdleIsTakenOver,
				self.takesOverActorEvent
			) in
			let unionEnterProcessExitIdleIsTakenOverTakesOverPeriodStart : Event = Expression Union(
				unionEnterProcessExitIdleIsTakenOverTakesOver,
				self.periodStartActorEvent
			) in
			let unionEnterProcessExitIdleIsTakenOverTakesOverPeriodStartTaskCompleted : Event = Expression Union(
				unionEnterProcessExitIdleIsTakenOverTakesOverPeriodStart,
				self.taskCompletedActorEvent
			) in
			Relation Coincides(
				unionEnterProcessExitIdleIsTakenOverTakesOverPeriodStartTaskCompleted,
				self.oclAsType(ecore::EObject).eContainer().oclAsType(IotSystem).timeEvent
			)

	context Resource
		inv unionEventsOfResourceCoincidesWithTimeEvent:
			let unionIsEnteredAndIsProcessed : Event = Expression Union(
				self.isEnteredResourceEvent,
				self.isProcessedResourceEvent
			) in
			let unionIsEnteredAndIsProcessedIsExited : Event = Expression Union(
				unionIsEnteredAndIsProcessed,
				self.isExitedResourceEvent
			) in
			let unionIsEnteredAndIsProcessedIsExitedIdle : Event = Expression Union(
				unionIsEnteredAndIsProcessedIsExited,
				self.idleResourceEvent
			) in
			let unionIsEnteredAndIsProcessedIsExitedIdleClean : Event = Expression Union(
				unionIsEnteredAndIsProcessedIsExitedIdle,
				self.cleanResourceEvent
			) in
			let unionIsEnteredAndIsProcessedIsExitedIdleCleanAnActorIsTakenOverByAnotherOne : Event = Expression Union(
				unionIsEnteredAndIsProcessedIsExitedIdleClean,
				self.anActorIsTakenOverByAnotherOneResourceEvent
			) in
			Relation Coincides(
				unionIsEnteredAndIsProcessedIsExitedIdleCleanAnActorIsTakenOverByAnotherOne,
				self.oclAsType(ecore::EObject).eContainer().oclAsType(IotSystem).timeEvent
			)
			
endpackage