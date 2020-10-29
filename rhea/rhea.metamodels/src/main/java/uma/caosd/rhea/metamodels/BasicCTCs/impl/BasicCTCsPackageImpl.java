/**
 */
package uma.caosd.rhea.metamodels.BasicCTCs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import uma.caosd.rhea.metamodels.BasicCTCs.BasicCTCsFactory;
import uma.caosd.rhea.metamodels.BasicCTCs.BasicCTCsPackage;
import uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint;
import uma.caosd.rhea.metamodels.BasicCTCs.Excludes;
import uma.caosd.rhea.metamodels.BasicCTCs.Requires;

import uma.caosd.rhea.metamodels.BasicFMs.BasicFMsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicCTCsPackageImpl extends EPackageImpl implements BasicCTCsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiresEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass excludesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicConstraintEClass = null;

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
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.BasicCTCsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BasicCTCsPackageImpl() {
		super(eNS_URI, BasicCTCsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BasicCTCsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BasicCTCsPackage init() {
		if (isInited) return (BasicCTCsPackage)EPackage.Registry.INSTANCE.getEPackage(BasicCTCsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBasicCTCsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BasicCTCsPackageImpl theBasicCTCsPackage = registeredBasicCTCsPackage instanceof BasicCTCsPackageImpl ? (BasicCTCsPackageImpl)registeredBasicCTCsPackage : new BasicCTCsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicFMsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBasicCTCsPackage.createPackageContents();

		// Initialize created meta-data
		theBasicCTCsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBasicCTCsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BasicCTCsPackage.eNS_URI, theBasicCTCsPackage);
		return theBasicCTCsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequires() {
		return requiresEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExcludes() {
		return excludesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicConstraint() {
		return basicConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicConstraint_LeftFeature() {
		return (EReference)basicConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicConstraint_RightFeature() {
		return (EReference)basicConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicCTCsFactory getBasicCTCsFactory() {
		return (BasicCTCsFactory)getEFactoryInstance();
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
		requiresEClass = createEClass(REQUIRES);

		excludesEClass = createEClass(EXCLUDES);

		basicConstraintEClass = createEClass(BASIC_CONSTRAINT);
		createEReference(basicConstraintEClass, BASIC_CONSTRAINT__LEFT_FEATURE);
		createEReference(basicConstraintEClass, BASIC_CONSTRAINT__RIGHT_FEATURE);
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
		requiresEClass.getESuperTypes().add(this.getBasicConstraint());
		excludesEClass.getESuperTypes().add(this.getBasicConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(requiresEClass, Requires.class, "Requires", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(excludesEClass, Excludes.class, "Excludes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicConstraintEClass, BasicConstraint.class, "BasicConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicConstraint_LeftFeature(), theBasicFMsPackage.getFeature(), null, "leftFeature", null, 1, 1, BasicConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicConstraint_RightFeature(), theBasicFMsPackage.getFeature(), null, "rightFeature", null, 1, 1, BasicConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BasicCTCsPackageImpl
