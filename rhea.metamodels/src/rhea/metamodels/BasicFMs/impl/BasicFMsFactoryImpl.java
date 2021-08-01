/**
 */
package rhea.metamodels.BasicFMs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rhea.metamodels.BasicFMs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicFMsFactoryImpl extends EFactoryImpl implements BasicFMsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BasicFMsFactory init() {
		try {
			BasicFMsFactory theBasicFMsFactory = (BasicFMsFactory)EPackage.Registry.INSTANCE.getEFactory(BasicFMsPackage.eNS_URI);
			if (theBasicFMsFactory != null) {
				return theBasicFMsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BasicFMsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFMsFactoryImpl() {
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
			case BasicFMsPackage.FEATURE_MODEL: return createFeatureModel();
			case BasicFMsPackage.FEATURE: return createFeature();
			case BasicFMsPackage.ALTERNATIVE_GROUP: return createAlternativeGroup();
			case BasicFMsPackage.SELECTION_GROUP: return createSelectionGroup();
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
	public FeatureModel createFeatureModel() {
		FeatureModelImpl featureModel = new FeatureModelImpl();
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlternativeGroup createAlternativeGroup() {
		AlternativeGroupImpl alternativeGroup = new AlternativeGroupImpl();
		return alternativeGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SelectionGroup createSelectionGroup() {
		SelectionGroupImpl selectionGroup = new SelectionGroupImpl();
		return selectionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicFMsPackage getBasicFMsPackage() {
		return (BasicFMsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BasicFMsPackage getPackage() {
		return BasicFMsPackage.eINSTANCE;
	}

} //BasicFMsFactoryImpl
