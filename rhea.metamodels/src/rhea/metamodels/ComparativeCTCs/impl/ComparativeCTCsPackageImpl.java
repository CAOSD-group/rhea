/**
 */
package rhea.metamodels.ComparativeCTCs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import rhea.metamodels.BasicFMs.BasicFMsPackage;

import rhea.metamodels.BasicFMs.impl.BasicFMsPackageImpl;

import rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm;
import rhea.metamodels.ComparativeCTCs.ComparativeCTCsFactory;
import rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage;
import rhea.metamodels.ComparativeCTCs.Equal;
import rhea.metamodels.ComparativeCTCs.Less;
import rhea.metamodels.ComparativeCTCs.LessOrEqual;
import rhea.metamodels.ComparativeCTCs.More;
import rhea.metamodels.ComparativeCTCs.MoreOrEqual;
import rhea.metamodels.ComparativeCTCs.NotEqual;
import rhea.metamodels.ComparativeCTCs.NumericTerm;

import rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage;

import rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComparativeCTCsPackageImpl extends EPackageImpl implements ComparativeCTCsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryComparativeTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessOrEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moreOrEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericTermEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComparativeCTCsPackageImpl() {
		super(eNS_URI, ComparativeCTCsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ComparativeCTCsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComparativeCTCsPackage init() {
		if (isInited) return (ComparativeCTCsPackage)EPackage.Registry.INSTANCE.getEPackage(ComparativeCTCsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredComparativeCTCsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ComparativeCTCsPackageImpl theComparativeCTCsPackage = registeredComparativeCTCsPackage instanceof ComparativeCTCsPackageImpl ? (ComparativeCTCsPackageImpl)registeredComparativeCTCsPackage : new ComparativeCTCsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PropLogicCTCsPackage.eNS_URI);
		PropLogicCTCsPackageImpl thePropLogicCTCsPackage = (PropLogicCTCsPackageImpl)(registeredPackage instanceof PropLogicCTCsPackageImpl ? registeredPackage : PropLogicCTCsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BasicFMsPackage.eNS_URI);
		BasicFMsPackageImpl theBasicFMsPackage = (BasicFMsPackageImpl)(registeredPackage instanceof BasicFMsPackageImpl ? registeredPackage : BasicFMsPackage.eINSTANCE);

		// Create package meta-data objects
		theComparativeCTCsPackage.createPackageContents();
		thePropLogicCTCsPackage.createPackageContents();
		theBasicFMsPackage.createPackageContents();

		// Initialize created meta-data
		theComparativeCTCsPackage.initializePackageContents();
		thePropLogicCTCsPackage.initializePackageContents();
		theBasicFMsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComparativeCTCsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComparativeCTCsPackage.eNS_URI, theComparativeCTCsPackage);
		return theComparativeCTCsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBinaryComparativeTerm() {
		return binaryComparativeTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryComparativeTerm_Left() {
		return (EReference)binaryComparativeTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBinaryComparativeTerm_Right() {
		return (EReference)binaryComparativeTermEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEqual() {
		return equalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNotEqual() {
		return notEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLess() {
		return lessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMore() {
		return moreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLessOrEqual() {
		return lessOrEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMoreOrEqual() {
		return moreOrEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumericTerm() {
		return numericTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNumericTerm_Value() {
		return (EAttribute)numericTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComparativeCTCsFactory getComparativeCTCsFactory() {
		return (ComparativeCTCsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		binaryComparativeTermEClass = createEClass(BINARY_COMPARATIVE_TERM);
		createEReference(binaryComparativeTermEClass, BINARY_COMPARATIVE_TERM__LEFT);
		createEReference(binaryComparativeTermEClass, BINARY_COMPARATIVE_TERM__RIGHT);

		equalEClass = createEClass(EQUAL);

		notEqualEClass = createEClass(NOT_EQUAL);

		lessEClass = createEClass(LESS);

		moreEClass = createEClass(MORE);

		lessOrEqualEClass = createEClass(LESS_OR_EQUAL);

		moreOrEqualEClass = createEClass(MORE_OR_EQUAL);

		numericTermEClass = createEClass(NUMERIC_TERM);
		createEAttribute(numericTermEClass, NUMERIC_TERM__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PropLogicCTCsPackage thePropLogicCTCsPackage = (PropLogicCTCsPackage)EPackage.Registry.INSTANCE.getEPackage(PropLogicCTCsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		binaryComparativeTermEClass.getESuperTypes().add(thePropLogicCTCsPackage.getTerm());
		equalEClass.getESuperTypes().add(this.getBinaryComparativeTerm());
		notEqualEClass.getESuperTypes().add(this.getBinaryComparativeTerm());
		lessEClass.getESuperTypes().add(this.getBinaryComparativeTerm());
		moreEClass.getESuperTypes().add(this.getBinaryComparativeTerm());
		lessOrEqualEClass.getESuperTypes().add(this.getBinaryComparativeTerm());
		moreOrEqualEClass.getESuperTypes().add(this.getBinaryComparativeTerm());
		numericTermEClass.getESuperTypes().add(thePropLogicCTCsPackage.getTerm());

		// Initialize classes and features; add operations and parameters
		initEClass(binaryComparativeTermEClass, BinaryComparativeTerm.class, "BinaryComparativeTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryComparativeTerm_Left(), thePropLogicCTCsPackage.getTerm(), null, "left", null, 1, 1, BinaryComparativeTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryComparativeTerm_Right(), thePropLogicCTCsPackage.getTerm(), null, "right", null, 1, 1, BinaryComparativeTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equalEClass, Equal.class, "Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEqualEClass, NotEqual.class, "NotEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessEClass, Less.class, "Less", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moreEClass, More.class, "More", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessOrEqualEClass, LessOrEqual.class, "LessOrEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moreOrEqualEClass, MoreOrEqual.class, "MoreOrEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericTermEClass, NumericTerm.class, "NumericTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericTerm_Value(), ecorePackage.getEFloat(), "value", null, 0, 1, NumericTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ComparativeCTCsPackageImpl
