/**
 */
package fr.inria.kairos.sock.dsl.model.sock;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iot System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.IotSystem#getOwnedActor <em>Owned Actor</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.IotSystem#getOwnedResource <em>Owned Resource</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.IotSystem#getCurrentTime <em>Current Time</em>}</li>
 * </ul>
 *
 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getIotSystem()
 * @model
 * @generated
 */
public interface IotSystem extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Actor</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.kairos.sock.dsl.model.sock.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Actor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Actor</em>' containment reference list.
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getIotSystem_OwnedActor()
	 * @model containment="true"
	 * @generated
	 */
	EList<Actor> getOwnedActor();

	/**
	 * Returns the value of the '<em><b>Owned Resource</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.kairos.sock.dsl.model.sock.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Resource</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Resource</em>' containment reference list.
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getIotSystem_OwnedResource()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getOwnedResource();

	/**
	 * Returns the value of the '<em><b>Current Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Time</em>' attribute.
	 * @see #setCurrentTime(int)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getIotSystem_CurrentTime()
	 * @model
	 * @generated
	 */
	int getCurrentTime();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.IotSystem#getCurrentTime <em>Current Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Time</em>' attribute.
	 * @see #getCurrentTime()
	 * @generated
	 */
	void setCurrentTime(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void time();

} // IotSystem
