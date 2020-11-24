/**
 */
package rhea.metamodels.PropLogicCTCs;

import rhea.metamodels.BasicFMs.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.FeatureTerm#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getFeatureTerm()
 * @model
 * @generated
 */
public interface FeatureTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getFeatureTerm_Feature()
	 * @model required="true"
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.FeatureTerm#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

} // FeatureTerm
