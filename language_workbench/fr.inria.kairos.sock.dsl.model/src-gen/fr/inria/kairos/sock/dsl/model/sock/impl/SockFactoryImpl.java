/**
 */
package fr.inria.kairos.sock.dsl.model.sock.impl;

import fr.inria.kairos.sock.dsl.model.sock.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SockFactoryImpl extends EFactoryImpl implements SockFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SockFactory init() {
		try {
			SockFactory theSockFactory = (SockFactory) EPackage.Registry.INSTANCE.getEFactory(SockPackage.eNS_URI);
			if (theSockFactory != null) {
				return theSockFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SockFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SockFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SockPackage.IOT_SYSTEM:
			return createIotSystem();
		case SockPackage.RESOURCE:
			return createResource();
		case SockPackage.ACTOR:
			return createActor();
		case SockPackage.MALICIOUS_ACTOR:
			return createMaliciousActor();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IotSystem createIotSystem() {
		IotSystemImpl iotSystem = new IotSystemImpl();
		return iotSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaliciousActor createMaliciousActor() {
		MaliciousActorImpl maliciousActor = new MaliciousActorImpl();
		return maliciousActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SockPackage getSockPackage() {
		return (SockPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SockPackage getPackage() {
		return SockPackage.eINSTANCE;
	}

} //SockFactoryImpl
