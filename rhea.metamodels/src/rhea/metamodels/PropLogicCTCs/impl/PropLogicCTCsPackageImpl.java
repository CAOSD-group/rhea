/**
 */
package rhea.metamodels.PropLogicCTCs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import rhea.metamodels.BasicFMs.BasicFMsPackage;

import rhea.metamodels.PropLogicCTCs.AdvancedConstraint;
import rhea.metamodels.PropLogicCTCs.PropLogicCTCsFactory;
import rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage;
import rhea.metamodels.PropLogicCTCs.Term;
import rhea.metamodels.PropLogicCTCs.TermType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropLogicCTCsPackageImpl extends EPackageImpl implements PropLogicCTCsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass advancedConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum termTypeEEnum = null;

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
	 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PropLogicCTCsPackageImpl() {
		super(eNS_URI, PropLogicCTCsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PropLogicCTCsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PropLogicCTCsPackage init() {
		if (isInited) return (PropLogicCTCsPackage)EPackage.Registry.INSTANCE.getEPackage(PropLogicCTCsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPropLogicCTCsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PropLogicCTCsPackageImpl thePropLogicCTCsPackage = registeredPropLogicCTCsPackage instanceof PropLogicCTCsPackageImpl ? (PropLogicCTCsPackageImpl)registeredPropLogicCTCsPackage : new PropLogicCTCsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicFMsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePropLogicCTCsPackage.createPackageContents();

		// Initialize created meta-data
		thePropLogicCTCsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePropLogicCTCsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PropLogicCTCsPackage.eNS_URI, thePropLogicCTCsPackage);
		return thePropLogicCTCsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdvancedConstraint() {
		return advancedConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdvancedConstraint_Term() {
		return (EReference)advancedConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerm_Type() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerm_Term() {
		return (EReference)termEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerm_Operands() {
		return (EReference)termEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTermType() {
		return termTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropLogicCTCsFactory getPropLogicCTCsFactory() {
		return (PropLogicCTCsFactory)getEFactoryInstance();
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
		advancedConstraintEClass = createEClass(ADVANCED_CONSTRAINT);
		createEReference(advancedConstraintEClass, ADVANCED_CONSTRAINT__TERM);

		termEClass = createEClass(TERM);
		createEAttribute(termEClass, TERM__TYPE);
		createEReference(termEClass, TERM__TERM);
		createEReference(termEClass, TERM__OPERANDS);

		// Create enums
		termTypeEEnum = createEEnum(TERM_TYPE);
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
		BasicFMsPackage theBasicFMsPackage = (BasicFMsPackage)EPackage.Registry.INSTANCE.getEPackage(BasicFMsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		advancedConstraintEClass.getESuperTypes().add(theBasicFMsPackage.getCrossTreeConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(advancedConstraintEClass, AdvancedConstraint.class, "AdvancedConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdvancedConstraint_Term(), this.getTerm(), null, "term", null, 1, 1, AdvancedConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerm_Type(), this.getTermType(), "type", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerm_Term(), theBasicFMsPackage.getFeature(), null, "term", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerm_Operands(), this.getTerm(), null, "operands", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(termTypeEEnum, TermType.class, "TermType");
		addEEnumLiteral(termTypeEEnum, TermType.FEATURE);
		addEEnumLiteral(termTypeEEnum, TermType.NOT);
		addEEnumLiteral(termTypeEEnum, TermType.AND);
		addEEnumLiteral(termTypeEEnum, TermType.OR);
		addEEnumLiteral(termTypeEEnum, TermType.XOR);
		addEEnumLiteral(termTypeEEnum, TermType.IMPLIES);
		addEEnumLiteral(termTypeEEnum, TermType.EXCLUDES);
		addEEnumLiteral(termTypeEEnum, TermType.EQUIV);

		// Create resource
		createResource(eNS_URI);
	}

} //PropLogicCTCsPackageImpl
