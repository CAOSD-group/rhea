/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import rhea.metamodels.BasicFMs.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Term#getType <em>Type</em>}</li>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Term#getTerm <em>Term</em>}</li>
 *   <li>{@link rhea.metamodels.PropLogicCTCs.Term#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link rhea.metamodels.PropLogicCTCs.TermType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see rhea.metamodels.PropLogicCTCs.TermType
	 * @see #setType(TermType)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getTerm_Type()
	 * @model
	 * @generated
	 */
	TermType getType();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.Term#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see rhea.metamodels.PropLogicCTCs.TermType
	 * @see #getType()
	 * @generated
	 */
	void setType(TermType value);

	/**
	 * Returns the value of the '<em><b>Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' reference.
	 * @see #setTerm(Feature)
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getTerm_Term()
	 * @model
	 * @generated
	 */
	Feature getTerm();

	/**
	 * Sets the value of the '{@link rhea.metamodels.PropLogicCTCs.Term#getTerm <em>Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Feature value);

	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link rhea.metamodels.PropLogicCTCs.Term}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#getTerm_Operands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Term> getOperands();

} // Term
