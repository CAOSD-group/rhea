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
 *   <li>{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getAdvancedConstraint()
 * @model
 * @generated
 */
public interface AdvancedConstraint extends CrossTreeConstraint {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Term)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getAdvancedConstraint_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getExpr();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Term value);

} // AdvancedConstraint
