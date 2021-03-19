/**
 */
package rhea.metamodels.CompletedFM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rhea.metamodels.CompletedFM.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompletedFMFactoryImpl extends EFactoryImpl implements CompletedFMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompletedFMFactory init() {
		try {
			CompletedFMFactory theCompletedFMFactory = (CompletedFMFactory)EPackage.Registry.INSTANCE.getEFactory(CompletedFMPackage.eNS_URI);
			if (theCompletedFMFactory != null) {
				return theCompletedFMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompletedFMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletedFMFactoryImpl() {
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
			case CompletedFMPackage.FEATURE: return createFeature();
			case CompletedFMPackage.ALTERNATIVE_GROUP: return createAlternativeGroup();
			case CompletedFMPackage.FEATURE_MODEL: return createFeatureModel();
			case CompletedFMPackage.SELECTION_GROUP: return createSelectionGroup();
			case CompletedFMPackage.MUTEX_GROUP: return createMutexGroup();
			case CompletedFMPackage.MULTIPLICITY: return createMultiplicity();
			case CompletedFMPackage.GROUP_CARDINALITY: return createGroupCardinality();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeGroup createAlternativeGroup() {
		AlternativeGroupImpl alternativeGroup = new AlternativeGroupImpl();
		return alternativeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel createFeatureModel() {
		FeatureModelImpl featureModel = new FeatureModelImpl();
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionGroup createSelectionGroup() {
		SelectionGroupImpl selectionGroup = new SelectionGroupImpl();
		return selectionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutexGroup createMutexGroup() {
		MutexGroupImpl mutexGroup = new MutexGroupImpl();
		return mutexGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiplicity createMultiplicity() {
		MultiplicityImpl multiplicity = new MultiplicityImpl();
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupCardinality createGroupCardinality() {
		GroupCardinalityImpl groupCardinality = new GroupCardinalityImpl();
		return groupCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletedFMPackage getCompletedFMPackage() {
		return (CompletedFMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompletedFMPackage getPackage() {
		return CompletedFMPackage.eINSTANCE;
	}

} //CompletedFMFactoryImpl
