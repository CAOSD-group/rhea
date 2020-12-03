/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage
 * @generated
 */
public interface PropLogicCTCsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PropLogicCTCsFactory eINSTANCE = rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Advanced Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advanced Constraint</em>'.
	 * @generated
	 */
	AdvancedConstraint createAdvancedConstraint();

	/**
	 * Returns a new object of class '<em>Feature Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Term</em>'.
	 * @generated
	 */
	FeatureTerm createFeatureTerm();

	/**
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Xor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xor</em>'.
	 * @generated
	 */
	Xor createXor();

	/**
	 * Returns a new object of class '<em>Equiv</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equiv</em>'.
	 * @generated
	 */
	Equiv createEquiv();

	/**
	 * Returns a new object of class '<em>Implies</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implies</em>'.
	 * @generated
	 */
	Implies createImplies();

	/**
	 * Returns a new object of class '<em>Excludes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Excludes</em>'.
	 * @generated
	 */
	Excludes createExcludes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PropLogicCTCsPackage getPropLogicCTCsPackage();

} //PropLogicCTCsFactory
