/**
 */
package rhea.metamodels.BasicCTCs;

import org.eclipse.emf.ecore.EObject;

import rhea.metamodels.BasicFMs.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.BasicCTCs.BasicConstraint#getLeftFeature <em>Left Feature</em>}</li>
 *   <li>{@link rhea.metamodels.BasicCTCs.BasicConstraint#getRightFeature <em>Right Feature</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.BasicCTCs.BasicCTCsPackage#getBasicConstraint()
 * @model abstract="true"
 * @generated
 */
public interface BasicConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Feature</em>' reference.
	 * @see #setLeftFeature(Feature)
	 * @see rhea.metamodels.BasicCTCs.BasicCTCsPackage#getBasicConstraint_LeftFeature()
	 * @model required="true"
	 * @generated
	 */
	Feature getLeftFeature();

	/**
	 * Sets the value of the '{@link rhea.metamodels.BasicCTCs.BasicConstraint#getLeftFeature <em>Left Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Feature</em>' reference.
	 * @see #getLeftFeature()
	 * @generated
	 */
	void setLeftFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Feature</em>' reference.
	 * @see #setRightFeature(Feature)
	 * @see rhea.metamodels.BasicCTCs.BasicCTCsPackage#getBasicConstraint_RightFeature()
	 * @model required="true"
	 * @generated
	 */
	Feature getRightFeature();

	/**
	 * Sets the value of the '{@link rhea.metamodels.BasicCTCs.BasicConstraint#getRightFeature <em>Right Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Feature</em>' reference.
	 * @see #getRightFeature()
	 * @generated
	 */
	void setRightFeature(Feature value);

} // BasicConstraint
