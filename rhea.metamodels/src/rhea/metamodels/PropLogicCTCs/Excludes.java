/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Excludes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Excludes#getLeft <em>Left</em>}</li>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Excludes#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getExcludes()
 * @model
 * @generated
 */
public interface Excludes extends EObject {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Term)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getExcludes_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getLeft();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.Excludes#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Term value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Term)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getExcludes_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getRight();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.Excludes#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Term value);

} // Excludes
