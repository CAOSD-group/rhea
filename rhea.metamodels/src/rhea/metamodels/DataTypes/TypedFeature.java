/**
 */
package rhea.metamodels.DataTypes;

import rhea.metamodels.BasicFMs.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.DataTypes.TypedFeature#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.DataTypes.DataTypesPackage#getTypedFeature()
 * @model
 * @generated
 */
public interface TypedFeature extends Feature {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(DataType)
	 * @see rhea.metamodels.DataTypes.DataTypesPackage#getTypedFeature_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link rhea.metamodels.DataTypes.TypedFeature#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

} // TypedFeature
