/**
 */
package NumericalFMs;

import BasicFMs.FeatureModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical FM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link NumericalFMs.NumericalFM#getNumericalfeatures <em>Numericalfeatures</em>}</li>
 * </ul>
 *
 * @see NumericalFMs.NumericalFMsPackage#getNumericalFM()
 * @model
 * @generated
 */
public interface NumericalFM extends FeatureModel {
	/**
	 * Returns the value of the '<em><b>Numericalfeatures</b></em>' reference list.
	 * The list contents are of type {@link NumericalFMs.NumericalFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numericalfeatures</em>' reference list.
	 * @see NumericalFMs.NumericalFMsPackage#getNumericalFM_Numericalfeatures()
	 * @model
	 * @generated
	 */
	EList<NumericalFeature> getNumericalfeatures();

} // NumericalFM
