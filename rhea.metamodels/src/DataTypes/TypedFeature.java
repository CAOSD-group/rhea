/**
 */
package DataTypes;

import BasicFMs.Feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DataTypes.TypedFeature#getType <em>Type</em>}</li>
 *   <li>{@link DataTypes.TypedFeature#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see DataTypes.DataTypesPackage#getTypedFeature()
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
	 * @see DataTypes.DataTypesPackage#getTypedFeature_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link DataTypes.TypedFeature#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link DataTypes.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see DataTypes.DataTypesPackage#getTypedFeature_Value()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getValue();
} // TypedFeature
