/**
 */
package rhea.metamodels.PropLogicCTCs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import rhea.metamodels.PropLogicCTCs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropLogicCTCsFactoryImpl extends EFactoryImpl implements PropLogicCTCsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PropLogicCTCsFactory init() {
		try {
			PropLogicCTCsFactory thePropLogicCTCsFactory = (PropLogicCTCsFactory)EPackage.Registry.INSTANCE.getEFactory(PropLogicCTCsPackage.eNS_URI);
			if (thePropLogicCTCsFactory != null) {
				return thePropLogicCTCsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PropLogicCTCsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropLogicCTCsFactoryImpl() {
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
			case PropLogicCTCsPackage.ADVANCED_CONSTRAINT: return createAdvancedConstraint();
			case PropLogicCTCsPackage.FEATURE_TERM: return createFeatureTerm();
			case PropLogicCTCsPackage.NOT: return createNot();
			case PropLogicCTCsPackage.AND: return createAnd();
			case PropLogicCTCsPackage.OR: return createOr();
			case PropLogicCTCsPackage.XOR: return createXor();
			case PropLogicCTCsPackage.EQUIV: return createEquiv();
			case PropLogicCTCsPackage.IMPLIES: return createImplies();
			case PropLogicCTCsPackage.EXCLUDES: return createExcludes();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedConstraint createAdvancedConstraint() {
		AdvancedConstraintImpl advancedConstraint = new AdvancedConstraintImpl();
		return advancedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureTerm createFeatureTerm() {
		FeatureTermImpl featureTerm = new FeatureTermImpl();
		return featureTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xor createXor() {
		XorImpl xor = new XorImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equiv createEquiv() {
		EquivImpl equiv = new EquivImpl();
		return equiv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implies createImplies() {
		ImpliesImpl implies = new ImpliesImpl();
		return implies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Excludes createExcludes() {
		ExcludesImpl excludes = new ExcludesImpl();
		return excludes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropLogicCTCsPackage getPropLogicCTCsPackage() {
		return (PropLogicCTCsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PropLogicCTCsPackage getPackage() {
		return PropLogicCTCsPackage.eINSTANCE;
	}

} //PropLogicCTCsFactoryImpl
