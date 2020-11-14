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
	 * Returns a new object of class '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term</em>'.
	 * @generated
	 */
	Term createTerm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PropLogicCTCsPackage getPropLogicCTCsPackage();

} //PropLogicCTCsFactory
