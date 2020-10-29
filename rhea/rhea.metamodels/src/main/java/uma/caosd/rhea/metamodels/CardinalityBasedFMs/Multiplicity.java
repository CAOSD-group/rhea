/**
 */
package uma.caosd.rhea.metamodels.CardinalityBasedFMs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.Multiplicity#getLower <em>Lower</em>}</li>
 *   <li>{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.Multiplicity#getUpper <em>Upper</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getMultiplicity()
 * @model
 * @generated
 */
public interface Multiplicity extends EObject {
	/**
	 * Returns the value of the '<em><b>Lower</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower</em>' attribute.
	 * @see #setLower(int)
	 * @see uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getMultiplicity_Lower()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getLower();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.Multiplicity#getLower <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower</em>' attribute.
	 * @see #getLower()
	 * @generated
	 */
	void setLower(int value);

	/**
	 * Returns the value of the '<em><b>Upper</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper</em>' attribute.
	 * @see #setUpper(int)
	 * @see uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getMultiplicity_Upper()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getUpper();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.Multiplicity#getUpper <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper</em>' attribute.
	 * @see #getUpper()
	 * @generated
	 */
	void setUpper(int value);

} // Multiplicity
