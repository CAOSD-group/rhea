/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Xor#getTerms <em>Terms</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getXor()
 * @model
 * @generated
 */
public interface Xor extends EObject {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link rhea.metamodels.PropLogicCTCs.Term}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getXor_Terms()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Term> getTerms();

} // Xor
