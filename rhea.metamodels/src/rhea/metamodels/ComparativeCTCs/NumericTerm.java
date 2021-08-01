/**
 */
package rhea.metamodels.ComparativeCTCs;

import rhea.metamodels.PropLogicCTCs.Term;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.ComparativeCTCs.NumericTerm#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage#getNumericTerm()
 * @model
 * @generated
 */
public interface NumericTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(float)
	 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage#getNumericTerm_Value()
	 * @model
	 * @generated
	 */
	float getValue();

	/**
	 * Sets the value of the '{@link rhea.metamodels.ComparativeCTCs.NumericTerm#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(float value);

} // NumericTerm
