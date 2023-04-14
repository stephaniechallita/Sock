/**
 */
package fr.inria.kairos.sock.dsl.model.sock;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Resource#getActor <em>Actor</em>}</li>
 * </ul>
 *
 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.kairos.sock.dsl.model.sock.Actor}.
	 * It is bidirectional and its opposite is '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference list.
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getResource_Actor()
	 * @see fr.inria.kairos.sock.dsl.model.sock.Actor#getResource
	 * @model opposite="resource"
	 * @generated
	 */
	EList<Actor> getActor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void clean();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void idle();

} // Resource
