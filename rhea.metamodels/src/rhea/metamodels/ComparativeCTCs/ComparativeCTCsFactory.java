/**
 */
package rhea.metamodels.ComparativeCTCs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage
 * @generated
 */
public interface ComparativeCTCsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComparativeCTCsFactory eINSTANCE = rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Binary Comparative Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Comparative Term</em>'.
	 * @generated
	 */
	BinaryComparativeTerm createBinaryComparativeTerm();

	/**
	 * Returns a new object of class '<em>Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equal</em>'.
	 * @generated
	 */
	Equal createEqual();

	/**
	 * Returns a new object of class '<em>Not Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Equal</em>'.
	 * @generated
	 */
	NotEqual createNotEqual();

	/**
	 * Returns a new object of class '<em>Less</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less</em>'.
	 * @generated
	 */
	Less createLess();

	/**
	 * Returns a new object of class '<em>More</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>More</em>'.
	 * @generated
	 */
	More createMore();

	/**
	 * Returns a new object of class '<em>Less Or Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less Or Equal</em>'.
	 * @generated
	 */
	LessOrEqual createLessOrEqual();

	/**
	 * Returns a new object of class '<em>More Or Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>More Or Equal</em>'.
	 * @generated
	 */
	MoreOrEqual createMoreOrEqual();

	/**
	 * Returns a new object of class '<em>Numeric Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Term</em>'.
	 * @generated
	 */
	NumericTerm createNumericTerm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComparativeCTCsPackage getComparativeCTCsPackage();

} //ComparativeCTCsFactory
