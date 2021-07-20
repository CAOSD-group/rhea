/**
 */
package NumericalFMs.impl;

import NumericalFMs.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NumericalFMsFactoryImpl extends EFactoryImpl implements NumericalFMsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NumericalFMsFactory init() {
		try {
			NumericalFMsFactory theNumericalFMsFactory = (NumericalFMsFactory)EPackage.Registry.INSTANCE.getEFactory(NumericalFMsPackage.eNS_URI);
			if (theNumericalFMsFactory != null) {
				return theNumericalFMsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NumericalFMsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalFMsFactoryImpl() {
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
			case NumericalFMsPackage.NUMERICAL_FM: return createNumericalFM();
			case NumericalFMsPackage.NUMERICAL_FEATURE: return createNumericalFeature();
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
	public NumericalFM createNumericalFM() {
		NumericalFMImpl numericalFM = new NumericalFMImpl();
		return numericalFM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalFeature createNumericalFeature() {
		NumericalFeatureImpl numericalFeature = new NumericalFeatureImpl();
		return numericalFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalFMsPackage getNumericalFMsPackage() {
		return (NumericalFMsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NumericalFMsPackage getPackage() {
		return NumericalFMsPackage.eINSTANCE;
	}

} //NumericalFMsFactoryImpl
