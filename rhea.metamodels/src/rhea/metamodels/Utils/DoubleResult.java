/**
 */
package rhea.metamodels.Utils;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.Utils.DoubleResult#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.Utils.UtilsPackage#getDoubleResult()
 * @model
 * @generated
 */
public interface DoubleResult extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(double)
	 * @see rhea.metamodels.Utils.UtilsPackage#getDoubleResult_Result()
	 * @model default="0.0"
	 * @generated
	 */
	double getResult();

	/**
	 * Sets the value of the '{@link rhea.metamodels.Utils.DoubleResult#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(double value);

} // DoubleResult
