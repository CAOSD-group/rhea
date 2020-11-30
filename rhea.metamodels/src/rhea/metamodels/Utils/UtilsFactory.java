/**
 */
package rhea.metamodels.Utils;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rhea.metamodels.Utils.UtilsPackage
 * @generated
 */
public interface UtilsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UtilsFactory eINSTANCE = rhea.metamodels.Utils.impl.UtilsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Int Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Result</em>'.
	 * @generated
	 */
	IntResult createIntResult();

	/**
	 * Returns a new object of class '<em>Double Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Result</em>'.
	 * @generated
	 */
	DoubleResult createDoubleResult();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>String Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Result</em>'.
	 * @generated
	 */
	StringResult createStringResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UtilsPackage getUtilsPackage();

} //UtilsFactory
