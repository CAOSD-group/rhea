/**
 */
package rhea.metamodels.CardinalityBasedFMs;

import org.eclipse.emf.common.util.EList;

import rhea.metamodels.BasicFMs.FeatureGroup;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Cardinality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.CardinalityBasedFMs.GroupCardinality#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getGroupCardinality()
 * @model
 * @generated
 */
public interface GroupCardinality extends FeatureGroup {
	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference list.
	 * The list contents are of type {@link rhea.metamodels.CardinalityBasedFMs.Multiplicity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' containment reference list.
	 * @see rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#getGroupCardinality_Multiplicity()
	 * @model containment="true"
	 * @generated
	 */
	EList<Multiplicity> getMultiplicity();

} // GroupCardinality
