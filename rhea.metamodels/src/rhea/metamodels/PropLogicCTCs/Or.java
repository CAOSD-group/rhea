/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Or#getTerms <em>Terms</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getOr()
 * @model
 * @generated
 */
public interface Or extends Term {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link rhea.metamodels.PropLogicCTCs.Term}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getOr_Terms()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Term> getTerms();

} // Or
