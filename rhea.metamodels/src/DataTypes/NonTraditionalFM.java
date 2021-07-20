/**
 */
package DataTypes;

import BasicFMs.FeatureModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Traditional FM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DataTypes.NonTraditionalFM#getTypedfeatures <em>Typedfeatures</em>}</li>
 * </ul>
 *
 * @see DataTypes.DataTypesPackage#getNonTraditionalFM()
 * @model
 * @generated
 */
public interface NonTraditionalFM extends FeatureModel {
	/**
	 * Returns the value of the '<em><b>Typedfeatures</b></em>' reference list.
	 * The list contents are of type {@link DataTypes.TypedFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typedfeatures</em>' reference list.
	 * @see DataTypes.DataTypesPackage#getNonTraditionalFM_Typedfeatures()
	 * @model
	 * @generated
	 */
	EList<TypedFeature> getTypedfeatures();

} // NonTraditionalFM
