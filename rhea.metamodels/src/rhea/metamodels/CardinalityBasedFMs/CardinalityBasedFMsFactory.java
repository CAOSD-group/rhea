/**
 */
package rhea.metamodels.CardinalityBasedFMs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage
 * @generated
 */
public interface CardinalityBasedFMsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CardinalityBasedFMsFactory eINSTANCE = rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Multiplicity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity</em>'.
	 * @generated
	 */
	Multiplicity createMultiplicity();

	/**
	 * Returns a new object of class '<em>Group Cardinality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Cardinality</em>'.
	 * @generated
	 */
	GroupCardinality createGroupCardinality();

	/**
	 * Returns a new object of class '<em>Mutex Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutex Group</em>'.
	 * @generated
	 */
	MutexGroup createMutexGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CardinalityBasedFMsPackage getCardinalityBasedFMsPackage();

} //CardinalityBasedFMsFactory
