/**
 */
package rhea.metamodels.CompletedFM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Cardinality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.CompletedFM.GroupCardinality#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getGroupCardinality()
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
	 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getGroupCardinality_Multiplicity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Multiplicity getMultiplicity();

	/**
	 * Sets the value of the '{@link rhea.metamodels.CompletedFM.GroupCardinality#getMultiplicity <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' containment reference.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(Multiplicity value);

} // GroupCardinality
