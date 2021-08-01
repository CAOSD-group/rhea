/**
 */
package rhea.metamodels.DataTypes;

import org.eclipse.emf.common.util.EList;

import rhea.metamodels.BasicFMs.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Traditional FM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.DataTypes.NonTraditionalFM#getTypedfeatures <em>Typedfeatures</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.DataTypes.DataTypesPackage#getNonTraditionalFM()
 * @model
 * @generated
 */
public interface NonTraditionalFM extends FeatureModel {
	/**
	 * Returns the value of the '<em><b>Typedfeatures</b></em>' reference list.
	 * The list contents are of type {@link rhea.metamodels.DataTypes.TypedFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typedfeatures</em>' reference list.
	 * @see rhea.metamodels.DataTypes.DataTypesPackage#getNonTraditionalFM_Typedfeatures()
	 * @model
	 * @generated
	 */
	EList<TypedFeature> getTypedfeatures();

} // NonTraditionalFM
