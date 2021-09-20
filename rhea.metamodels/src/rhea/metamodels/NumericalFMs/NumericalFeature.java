/**
 */
package rhea.metamodels.NumericalFMs;

import rhea.metamodels.BasicFMs.Feature;

import rhea.metamodels.DataTypes.DataType;
import rhea.metamodels.DataTypes.TypedFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.NumericalFMs.NumericalFeature#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.NumericalFMs.NumericalFMsPackage#getNumericalFeature()
 * @model
 * @generated
 */
public interface NumericalFeature extends TypedFeature {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see rhea.metamodels.NumericalFMs.NumericalFMsPackage#getNumericalFeature_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link rhea.metamodels.NumericalFMs.NumericalFeature#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

} // NumericalFeature
