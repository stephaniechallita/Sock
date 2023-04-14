/**
 */
package fr.inria.kairos.sock.dsl.model.sock.impl;

import fr.inria.kairos.sock.dsl.model.sock.Actor;
import fr.inria.kairos.sock.dsl.model.sock.Resource;
import fr.inria.kairos.sock.dsl.model.sock.SockPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl#getIsSensible <em>Is Sensible</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl#getProcessTime <em>Process Time</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl#getPeriodTime <em>Period Time</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl#getCurrentProcessTime <em>Current Process Time</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.impl.ActorImpl#getCode <em>Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorImpl extends NamedElementImpl implements Actor {
	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected Resource resource;

	/**
	 * The default value of the '{@link #getIsSensible() <em>Is Sensible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSensible()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_SENSIBLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIsSensible() <em>Is Sensible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSensible()
	 * @generated
	 * @ordered
	 */
	protected int isSensible = IS_SENSIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessTime() <em>Process Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessTime()
	 * @generated
	 * @ordered
	 */
	protected static final int PROCESS_TIME_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getProcessTime() <em>Process Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessTime()
	 * @generated
	 * @ordered
	 */
	protected int processTime = PROCESS_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriodTime() <em>Period Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodTime()
	 * @generated
	 * @ordered
	 */
	protected static final int PERIOD_TIME_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getPeriodTime() <em>Period Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodTime()
	 * @generated
	 * @ordered
	 */
	protected int periodTime = PERIOD_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentProcessTime() <em>Current Process Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentProcessTime()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_PROCESS_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentProcessTime() <em>Current Process Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentProcessTime()
	 * @generated
	 * @ordered
	 */
	protected int currentProcessTime = CURRENT_PROCESS_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected String code = CODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SockPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResource() {
		if (resource != null && resource.eIsProxy()) {
			InternalEObject oldResource = (InternalEObject) resource;
			resource = (Resource) eResolveProxy(oldResource);
			if (resource != oldResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SockPackage.ACTOR__RESOURCE, oldResource,
							resource));
			}
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResource(Resource newResource, NotificationChain msgs) {
		Resource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__RESOURCE,
					oldResource, newResource);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(Resource newResource) {
		if (newResource != resource) {
			NotificationChain msgs = null;
			if (resource != null)
				msgs = ((InternalEObject) resource).eInverseRemove(this, SockPackage.RESOURCE__ACTOR, Resource.class,
						msgs);
			if (newResource != null)
				msgs = ((InternalEObject) newResource).eInverseAdd(this, SockPackage.RESOURCE__ACTOR, Resource.class,
						msgs);
			msgs = basicSetResource(newResource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__RESOURCE, newResource,
					newResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIsSensible() {
		return isSensible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSensible(int newIsSensible) {
		int oldIsSensible = isSensible;
		isSensible = newIsSensible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__IS_SENSIBLE, oldIsSensible,
					isSensible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProcessTime() {
		return processTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessTime(int newProcessTime) {
		int oldProcessTime = processTime;
		processTime = newProcessTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__PROCESS_TIME, oldProcessTime,
					processTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPeriodTime() {
		return periodTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodTime(int newPeriodTime) {
		int oldPeriodTime = periodTime;
		periodTime = newPeriodTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__PERIOD_TIME, oldPeriodTime,
					periodTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentProcessTime() {
		return currentProcessTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentProcessTime(int newCurrentProcessTime) {
		int oldCurrentProcessTime = currentProcessTime;
		currentProcessTime = newCurrentProcessTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__CURRENT_PROCESS_TIME,
					oldCurrentProcessTime, currentProcessTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		String oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SockPackage.ACTOR__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void ready() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void enterIn() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void process() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void exitOf() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void idle() {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SockPackage.ACTOR__RESOURCE:
			if (resource != null)
				msgs = ((InternalEObject) resource).eInverseRemove(this, SockPackage.RESOURCE__ACTOR, Resource.class,
						msgs);
			return basicSetResource((Resource) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SockPackage.ACTOR__RESOURCE:
			return basicSetResource(null, msgs);
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
		case SockPackage.ACTOR__RESOURCE:
			if (resolve)
				return getResource();
			return basicGetResource();
		case SockPackage.ACTOR__IS_SENSIBLE:
			return getIsSensible();
		case SockPackage.ACTOR__PROCESS_TIME:
			return getProcessTime();
		case SockPackage.ACTOR__PERIOD_TIME:
			return getPeriodTime();
		case SockPackage.ACTOR__CURRENT_PROCESS_TIME:
			return getCurrentProcessTime();
		case SockPackage.ACTOR__CODE:
			return getCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SockPackage.ACTOR__RESOURCE:
			setResource((Resource) newValue);
			return;
		case SockPackage.ACTOR__IS_SENSIBLE:
			setIsSensible((Integer) newValue);
			return;
		case SockPackage.ACTOR__PROCESS_TIME:
			setProcessTime((Integer) newValue);
			return;
		case SockPackage.ACTOR__PERIOD_TIME:
			setPeriodTime((Integer) newValue);
			return;
		case SockPackage.ACTOR__CURRENT_PROCESS_TIME:
			setCurrentProcessTime((Integer) newValue);
			return;
		case SockPackage.ACTOR__CODE:
			setCode((String) newValue);
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
		case SockPackage.ACTOR__RESOURCE:
			setResource((Resource) null);
			return;
		case SockPackage.ACTOR__IS_SENSIBLE:
			setIsSensible(IS_SENSIBLE_EDEFAULT);
			return;
		case SockPackage.ACTOR__PROCESS_TIME:
			setProcessTime(PROCESS_TIME_EDEFAULT);
			return;
		case SockPackage.ACTOR__PERIOD_TIME:
			setPeriodTime(PERIOD_TIME_EDEFAULT);
			return;
		case SockPackage.ACTOR__CURRENT_PROCESS_TIME:
			setCurrentProcessTime(CURRENT_PROCESS_TIME_EDEFAULT);
			return;
		case SockPackage.ACTOR__CODE:
			setCode(CODE_EDEFAULT);
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
		case SockPackage.ACTOR__RESOURCE:
			return resource != null;
		case SockPackage.ACTOR__IS_SENSIBLE:
			return isSensible != IS_SENSIBLE_EDEFAULT;
		case SockPackage.ACTOR__PROCESS_TIME:
			return processTime != PROCESS_TIME_EDEFAULT;
		case SockPackage.ACTOR__PERIOD_TIME:
			return periodTime != PERIOD_TIME_EDEFAULT;
		case SockPackage.ACTOR__CURRENT_PROCESS_TIME:
			return currentProcessTime != CURRENT_PROCESS_TIME_EDEFAULT;
		case SockPackage.ACTOR__CODE:
			return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
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
		case SockPackage.ACTOR___READY:
			ready();
			return null;
		case SockPackage.ACTOR___ENTER_IN:
			enterIn();
			return null;
		case SockPackage.ACTOR___PROCESS:
			process();
			return null;
		case SockPackage.ACTOR___EXIT_OF:
			exitOf();
			return null;
		case SockPackage.ACTOR___IDLE:
			idle();
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
		result.append(" (isSensible: ");
		result.append(isSensible);
		result.append(", processTime: ");
		result.append(processTime);
		result.append(", periodTime: ");
		result.append(periodTime);
		result.append(", currentProcessTime: ");
		result.append(currentProcessTime);
		result.append(", code: ");
		result.append(code);
		result.append(')');
		return result.toString();
	}

} //ActorImpl
