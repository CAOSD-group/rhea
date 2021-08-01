/**
 */
package rhea.metamodels.NumericalFMs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rhea.metamodels.NumericalFMs.NumericalFMsPackage
 * @generated
 */
public interface NumericalFMsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NumericalFMsFactory eINSTANCE = rhea.metamodels.NumericalFMs.impl.NumericalFMsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Numerical Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numerical Feature</em>'.
	 * @generated
	 */
	NumericalFeature createNumericalFeature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NumericalFMsPackage getNumericalFMsPackage();

} //NumericalFMsFactory
