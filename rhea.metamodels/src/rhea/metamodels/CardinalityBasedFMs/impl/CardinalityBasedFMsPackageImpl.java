/**
 */
package rhea.metamodels.CardinalityBasedFMs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import rhea.metamodels.BasicFMs.BasicFMsPackage;

import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;
import rhea.metamodels.CardinalityBasedFMs.MutexGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CardinalityBasedFMsPackageImpl extends EPackageImpl implements CardinalityBasedFMsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupCardinalityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutexGroupEClass = null;

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
	 * @see rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CardinalityBasedFMsPackageImpl() {
		super(eNS_URI, CardinalityBasedFMsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CardinalityBasedFMsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CardinalityBasedFMsPackage init() {
		if (isInited) return (CardinalityBasedFMsPackage)EPackage.Registry.INSTANCE.getEPackage(CardinalityBasedFMsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCardinalityBasedFMsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CardinalityBasedFMsPackageImpl theCardinalityBasedFMsPackage = registeredCardinalityBasedFMsPackage instanceof CardinalityBasedFMsPackageImpl ? (CardinalityBasedFMsPackageImpl)registeredCardinalityBasedFMsPackage : new CardinalityBasedFMsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasicFMsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCardinalityBasedFMsPackage.createPackageContents();

		// Initialize created meta-data
		theCardinalityBasedFMsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCardinalityBasedFMsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CardinalityBasedFMsPackage.eNS_URI, theCardinalityBasedFMsPackage);
		return theCardinalityBasedFMsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicity() {
		return multiplicityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_Lower() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_Upper() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupCardinality() {
		return groupCardinalityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupCardinality_Multiplicity() {
		return (EReference)groupCardinalityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutexGroup() {
		return mutexGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityBasedFMsFactory getCardinalityBasedFMsFactory() {
		return (CardinalityBasedFMsFactory)getEFactoryInstance();
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
		multiplicityEClass = createEClass(MULTIPLICITY);
		createEAttribute(multiplicityEClass, MULTIPLICITY__LOWER);
		createEAttribute(multiplicityEClass, MULTIPLICITY__UPPER);

		groupCardinalityEClass = createEClass(GROUP_CARDINALITY);
		createEReference(groupCardinalityEClass, GROUP_CARDINALITY__MULTIPLICITY);

		mutexGroupEClass = createEClass(MUTEX_GROUP);
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
		groupCardinalityEClass.getESuperTypes().add(theBasicFMsPackage.getFeatureGroup());
		mutexGroupEClass.getESuperTypes().add(theBasicFMsPackage.getFeatureGroup());

		// Initialize classes, features, and operations; add parameters
		initEClass(multiplicityEClass, Multiplicity.class, "Multiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicity_Lower(), ecorePackage.getEInt(), "lower", "1", 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicity_Upper(), ecorePackage.getEInt(), "upper", "-1", 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupCardinalityEClass, GroupCardinality.class, "GroupCardinality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupCardinality_Multiplicity(), this.getMultiplicity(), null, "multiplicity", null, 1, 1, GroupCardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutexGroupEClass, MutexGroup.class, "MutexGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CardinalityBasedFMsPackageImpl
