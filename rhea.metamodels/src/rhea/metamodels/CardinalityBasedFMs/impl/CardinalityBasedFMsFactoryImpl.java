/**
 */
package rhea.metamodels.CardinalityBasedFMs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rhea.metamodels.CardinalityBasedFMs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CardinalityBasedFMsFactoryImpl extends EFactoryImpl implements CardinalityBasedFMsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CardinalityBasedFMsFactory init() {
		try {
			CardinalityBasedFMsFactory theCardinalityBasedFMsFactory = (CardinalityBasedFMsFactory)EPackage.Registry.INSTANCE.getEFactory(CardinalityBasedFMsPackage.eNS_URI);
			if (theCardinalityBasedFMsFactory != null) {
				return theCardinalityBasedFMsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CardinalityBasedFMsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityBasedFMsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CardinalityBasedFMsPackage.MULTIPLICITY: return createMultiplicity();
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY: return createGroupCardinality();
			case CardinalityBasedFMsPackage.MUTEX_GROUP: return createMutexGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Multiplicity createMultiplicity() {
		MultiplicityImpl multiplicity = new MultiplicityImpl();
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupCardinality createGroupCardinality() {
		GroupCardinalityImpl groupCardinality = new GroupCardinalityImpl();
		return groupCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MutexGroup createMutexGroup() {
		MutexGroupImpl mutexGroup = new MutexGroupImpl();
		return mutexGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityBasedFMsPackage getCardinalityBasedFMsPackage() {
		return (CardinalityBasedFMsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CardinalityBasedFMsPackage getPackage() {
		return CardinalityBasedFMsPackage.eINSTANCE;
	}

} //CardinalityBasedFMsFactoryImpl
