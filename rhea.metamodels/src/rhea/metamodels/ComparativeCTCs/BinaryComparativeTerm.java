/**
 */
package rhea.metamodels.ComparativeCTCs;

import rhea.metamodels.PropLogicCTCs.Term;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Comparative Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getLeft <em>Left</em>}</li>
 *   <li>{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage#getBinaryComparativeTerm()
 * @model
 * @generated
 */
public interface BinaryComparativeTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(Term)
	 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage#getBinaryComparativeTerm_Left()
	 * @model required="true"
	 * @generated
	 */
	Term getLeft();

	/**
	 * Sets the value of the '{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Term value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(Term)
	 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage#getBinaryComparativeTerm_Right()
	 * @model required="true"
	 * @generated
	 */
	Term getRight();

	/**
	 * Sets the value of the '{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Term value);

} // BinaryComparativeTerm
