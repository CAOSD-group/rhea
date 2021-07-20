/**
 */
package DataTypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DataTypes.ObjectType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see DataTypes.DataTypesPackage#getObjectType()
 * @model
 * @generated
 */
public interface ObjectType extends DataType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see DataTypes.DataTypesPackage#getObjectType_Type()
	 * @model dataType="DataTypes.Object"
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link DataTypes.ObjectType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

} // ObjectType
