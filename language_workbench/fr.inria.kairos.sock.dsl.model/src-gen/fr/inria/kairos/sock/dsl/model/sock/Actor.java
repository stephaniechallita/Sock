/**
 */
package fr.inria.kairos.sock.dsl.model.sock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getResource <em>Resource</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getIsSensible <em>Is Sensible</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getProcessTime <em>Process Time</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getPeriodTime <em>Period Time</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getCurrentProcessTime <em>Current Process Time</em>}</li>
 *   <li>{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getCode <em>Code</em>}</li>
 * </ul>
 *
 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link fr.inria.kairos.sock.dsl.model.sock.Resource#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(Resource)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor_Resource()
	 * @see fr.inria.kairos.sock.dsl.model.sock.Resource#getActor
	 * @model opposite="actor"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Is Sensible</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sensible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sensible</em>' attribute.
	 * @see #setIsSensible(int)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor_IsSensible()
	 * @model default="0"
	 * @generated
	 */
	int getIsSensible();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getIsSensible <em>Is Sensible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sensible</em>' attribute.
	 * @see #getIsSensible()
	 * @generated
	 */
	void setIsSensible(int value);

	/**
	 * Returns the value of the '<em><b>Process Time</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Time</em>' attribute.
	 * @see #setProcessTime(int)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor_ProcessTime()
	 * @model default="3"
	 * @generated
	 */
	int getProcessTime();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getProcessTime <em>Process Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Time</em>' attribute.
	 * @see #getProcessTime()
	 * @generated
	 */
	void setProcessTime(int value);

	/**
	 * Returns the value of the '<em><b>Period Time</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period Time</em>' attribute.
	 * @see #setPeriodTime(int)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor_PeriodTime()
	 * @model default="10"
	 * @generated
	 */
	int getPeriodTime();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getPeriodTime <em>Period Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Time</em>' attribute.
	 * @see #getPeriodTime()
	 * @generated
	 */
	void setPeriodTime(int value);

	/**
	 * Returns the value of the '<em><b>Current Process Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Process Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Process Time</em>' attribute.
	 * @see #setCurrentProcessTime(int)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor_CurrentProcessTime()
	 * @model
	 * @generated
	 */
	int getCurrentProcessTime();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getCurrentProcessTime <em>Current Process Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Process Time</em>' attribute.
	 * @see #getCurrentProcessTime()
	 * @generated
	 */
	void setCurrentProcessTime(int value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see fr.inria.kairos.sock.dsl.model.sock.SockPackage#getActor_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link fr.inria.kairos.sock.dsl.model.sock.Actor#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void ready();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void enterIn();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void process();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void exitOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void idle();

} // Actor
