/**
 */
package fr.inria.kairos.sock.dsl.model.sock.impl;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.IotSystem;
import fr.inria.kairos.sock.dsl.model.sock.Resource;
import fr.inria.kairos.sock.dsl.model.sock.SockPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iot System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.IotSystemImpl#getOwnedActor <em>Owned Actor</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.IotSystemImpl#getOwnedResource <em>Owned Resource</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.IotSystemImpl#getCurrentTime <em>Current Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IotSystemImpl extends NamedElementImpl implements IotSystem {
	/**
	 * The cached value of the '{@link #getOwnedActor() <em>Owned Actor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedActor()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> ownedActor;

	/**
	 * The cached value of the '{@link #getOwnedResource() <em>Owned Resource</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedResource()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> ownedResource;

	/**
	 * The default value of the '{@link #getCurrentTime() <em>Current Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTime()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentTime() <em>Current Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentTime()
	 * @generated
	 * @ordered
	 */
	protected int currentTime = CURRENT_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IotSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SockPackage.Literals.IOT_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getOwnedActor() {
		if (ownedActor == null) {
			ownedActor = new EObjectContainmentEList<Actor>(Actor.class, this, SockPackage.IOT_SYSTEM__OWNED_ACTOR);
		}
		return ownedActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getOwnedResource() {
		if (ownedResource == null) {
			ownedResource = new EObjectContainmentEList<Resource>(Resource.class, this,
					SockPackage.IOT_SYSTEM__OWNED_RESOURCE);
		}
		return ownedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentTime() {
		return currentTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentTime(int newCurrentTime) {
		int oldCurrentTime = currentTime;
		currentTime = newCurrentTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.IOT_SYSTEM__CURRENT_TIME, oldCurrentTime,
					currentTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void time() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SockPackage.IOT_SYSTEM__OWNED_ACTOR:
			return ((InternalEList<?>) getOwnedActor()).basicRemove(otherEnd, msgs);
		case SockPackage.IOT_SYSTEM__OWNED_RESOURCE:
			return ((InternalEList<?>) getOwnedResource()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SockPackage.IOT_SYSTEM__OWNED_ACTOR:
			return getOwnedActor();
		case SockPackage.IOT_SYSTEM__OWNED_RESOURCE:
			return getOwnedResource();
		case SockPackage.IOT_SYSTEM__CURRENT_TIME:
			return getCurrentTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SockPackage.IOT_SYSTEM__OWNED_ACTOR:
			getOwnedActor().clear();
			getOwnedActor().addAll((Collection<? extends Actor>) newValue);
			return;
		case SockPackage.IOT_SYSTEM__OWNED_RESOURCE:
			getOwnedResource().clear();
			getOwnedResource().addAll((Collection<? extends Resource>) newValue);
			return;
		case SockPackage.IOT_SYSTEM__CURRENT_TIME:
			setCurrentTime((Integer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SockPackage.IOT_SYSTEM__OWNED_ACTOR:
			getOwnedActor().clear();
			return;
		case SockPackage.IOT_SYSTEM__OWNED_RESOURCE:
			getOwnedResource().clear();
			return;
		case SockPackage.IOT_SYSTEM__CURRENT_TIME:
			setCurrentTime(CURRENT_TIME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SockPackage.IOT_SYSTEM__OWNED_ACTOR:
			return ownedActor != null && !ownedActor.isEmpty();
		case SockPackage.IOT_SYSTEM__OWNED_RESOURCE:
			return ownedResource != null && !ownedResource.isEmpty();
		case SockPackage.IOT_SYSTEM__CURRENT_TIME:
			return currentTime != CURRENT_TIME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case SockPackage.IOT_SYSTEM___TIME:
			time();
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (currentTime: ");
		result.append(currentTime);
		result.append(')');
		return result.toString();
	}

} //IotSystemImpl
