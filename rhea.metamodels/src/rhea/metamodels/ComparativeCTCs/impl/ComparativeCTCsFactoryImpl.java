/**
 */
package rhea.metamodels.ComparativeCTCs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rhea.metamodels.ComparativeCTCs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComparativeCTCsFactoryImpl extends EFactoryImpl implements ComparativeCTCsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComparativeCTCsFactory init() {
		try {
			ComparativeCTCsFactory theComparativeCTCsFactory = (ComparativeCTCsFactory)EPackage.Registry.INSTANCE.getEFactory(ComparativeCTCsPackage.eNS_URI);
			if (theComparativeCTCsFactory != null) {
				return theComparativeCTCsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComparativeCTCsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparativeCTCsFactoryImpl() {
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
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM: return createBinaryComparativeTerm();
			case ComparativeCTCsPackage.EQUAL: return createEqual();
			case ComparativeCTCsPackage.NOT_EQUAL: return createNotEqual();
			case ComparativeCTCsPackage.LESS: return createLess();
			case ComparativeCTCsPackage.MORE: return createMore();
			case ComparativeCTCsPackage.LESS_OR_EQUAL: return createLessOrEqual();
			case ComparativeCTCsPackage.MORE_OR_EQUAL: return createMoreOrEqual();
			case ComparativeCTCsPackage.NUMERIC_TERM: return createNumericTerm();
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
	public BinaryComparativeTerm createBinaryComparativeTerm() {
		BinaryComparativeTermImpl binaryComparativeTerm = new BinaryComparativeTermImpl();
		return binaryComparativeTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Equal createEqual() {
		EqualImpl equal = new EqualImpl();
		return equal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotEqual createNotEqual() {
		NotEqualImpl notEqual = new NotEqualImpl();
		return notEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Less createLess() {
		LessImpl less = new LessImpl();
		return less;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public More createMore() {
		MoreImpl more = new MoreImpl();
		return more;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LessOrEqual createLessOrEqual() {
		LessOrEqualImpl lessOrEqual = new LessOrEqualImpl();
		return lessOrEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MoreOrEqual createMoreOrEqual() {
		MoreOrEqualImpl moreOrEqual = new MoreOrEqualImpl();
		return moreOrEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericTerm createNumericTerm() {
		NumericTermImpl numericTerm = new NumericTermImpl();
		return numericTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComparativeCTCsPackage getComparativeCTCsPackage() {
		return (ComparativeCTCsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComparativeCTCsPackage getPackage() {
		return ComparativeCTCsPackage.eINSTANCE;
	}

} //ComparativeCTCsFactoryImpl
