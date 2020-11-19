/**
 */
package rhea.metamodels.CardinalityBasedFMs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;

import rhea.metamodels.CardinalityBasedFMs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage
 * @generated
 */
public class CardinalityBasedFMsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CardinalityBasedFMsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityBasedFMsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CardinalityBasedFMsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityBasedFMsSwitch<Adapter> modelSwitch =
		new CardinalityBasedFMsSwitch<Adapter>() {
			@Override
			public Adapter caseMultiplicity(Multiplicity object) {
				return createMultiplicityAdapter();
			}
			@Override
			public Adapter caseGroupCardinality(GroupCardinality object) {
				return createGroupCardinalityAdapter();
			}
			@Override
			public Adapter caseMutexGroup(MutexGroup object) {
				return createMutexGroupAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseFeatureGroup(FeatureGroup object) {
				return createFeatureGroupAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link rhea.metamodels.CardinalityBasedFMs.Multiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rhea.metamodels.CardinalityBasedFMs.Multiplicity
	 * @generated
	 */
	public Adapter createMultiplicityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rhea.metamodels.CardinalityBasedFMs.GroupCardinality <em>Group Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rhea.metamodels.CardinalityBasedFMs.GroupCardinality
	 * @generated
	 */
	public Adapter createGroupCardinalityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rhea.metamodels.CardinalityBasedFMs.MutexGroup <em>Mutex Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rhea.metamodels.CardinalityBasedFMs.MutexGroup
	 * @generated
	 */
	public Adapter createMutexGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rhea.metamodels.BasicFMs.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rhea.metamodels.BasicFMs.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rhea.metamodels.BasicFMs.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rhea.metamodels.BasicFMs.FeatureGroup
	 * @generated
	 */
	public Adapter createFeatureGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CardinalityBasedFMsAdapterFactory
