/**
 */
package rhea.metamodels.PropLogicCTCs;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implies</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Implies#getLeft <em>Left</em>}</li>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Implies#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getImplies()
 * @model
 * @generated
 */
public interface Implies extends Term {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Term)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getImplies_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getLeft();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.Implies#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Term value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Term)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getImplies_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getRight();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.Implies#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Term value);

} // Implies
