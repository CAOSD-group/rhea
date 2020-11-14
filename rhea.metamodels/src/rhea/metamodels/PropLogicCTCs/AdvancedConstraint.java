/**
 */
package rhea.metamodels.PropLogicCTCs;

import rhea.metamodels.BasicFMs.CrossTreeConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getAdvancedConstraint()
 * @model
 * @generated
 */
public interface AdvancedConstraint extends CrossTreeConstraint {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference.
	 * @see #setTerm(Term)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getAdvancedConstraint_Term()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getTerm <em>Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' containment reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

} // AdvancedConstraint
