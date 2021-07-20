/**
 */
package DataTypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DataTypes.PrimitiveType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see DataTypes.DataTypesPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends DataType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link DataTypes.PrimitiveTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see DataTypes.PrimitiveTypeEnum
	 * @see #setType(PrimitiveTypeEnum)
	 * @see DataTypes.DataTypesPackage#getPrimitiveType_Type()
	 * @model
	 * @generated
	 */
	PrimitiveTypeEnum getType();

	/**
	 * Sets the value of the '{@link DataTypes.PrimitiveType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see DataTypes.PrimitiveTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(PrimitiveTypeEnum value);

} // PrimitiveType
