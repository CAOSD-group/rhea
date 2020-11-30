/**
 */
package rhea.metamodels.Utils.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rhea.metamodels.Utils.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilsFactoryImpl extends EFactoryImpl implements UtilsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UtilsFactory init() {
		try {
			UtilsFactory theUtilsFactory = (UtilsFactory)EPackage.Registry.INSTANCE.getEFactory(UtilsPackage.eNS_URI);
			if (theUtilsFactory != null) {
				return theUtilsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UtilsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UtilsFactoryImpl() {
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
			case UtilsPackage.INT_RESULT: return createIntResult();
			case UtilsPackage.DOUBLE_RESULT: return createDoubleResult();
			case UtilsPackage.NAMED_ELEMENT: return createNamedElement();
			case UtilsPackage.STRING_RESULT: return createStringResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntResult createIntResult() {
		IntResultImpl intResult = new IntResultImpl();
		return intResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleResult createDoubleResult() {
		DoubleResultImpl doubleResult = new DoubleResultImpl();
		return doubleResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringResult createStringResult() {
		StringResultImpl stringResult = new StringResultImpl();
		return stringResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UtilsPackage getUtilsPackage() {
		return (UtilsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UtilsPackage getPackage() {
		return UtilsPackage.eINSTANCE;
	}

} //UtilsFactoryImpl
