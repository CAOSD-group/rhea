/**
 */
package uma.caosd.rhea.metamodels.CardinalityBasedFMs;

import uma.caosd.rhea.metamodels.BasicFMs.FeatureGroup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Cardinality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.GroupCardinality#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getGroupCardinality()
 * @model
 * @generated
 */
public interface GroupCardinality extends FeatureGroup {
	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' containment reference.
	 * @see #setMultiplicity(Multiplicity)
	 * @see uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getGroupCardinality_Multiplicity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Multiplicity getMultiplicity();

	/**
	 * Sets the value of the '{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.GroupCardinality#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(Multiplicity value);

} // GroupCardinality
