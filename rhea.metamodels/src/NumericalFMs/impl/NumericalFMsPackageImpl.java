/**
 */
package NumericalFMs.impl;

import BasicFMs.BasicFMsPackage;

import BasicFMs.impl.BasicFMsPackageImpl;

import DataTypes.DataTypesPackage;

import DataTypes.impl.DataTypesPackageImpl;

import NumericalFMs.NumericalFM;
import NumericalFMs.NumericalFMsFactory;
import NumericalFMs.NumericalFMsPackage;
import NumericalFMs.NumericalFeature;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NumericalFMsPackageImpl extends EPackageImpl implements NumericalFMsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericalFMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericalFeatureEClass = null;

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
	 * @see NumericalFMs.NumericalFMsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NumericalFMsPackageImpl() {
		super(eNS_URI, NumericalFMsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NumericalFMsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NumericalFMsPackage init() {
		if (isInited) return (NumericalFMsPackage)EPackage.Registry.INSTANCE.getEPackage(NumericalFMsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredNumericalFMsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		NumericalFMsPackageImpl theNumericalFMsPackage = registeredNumericalFMsPackage instanceof NumericalFMsPackageImpl ? (NumericalFMsPackageImpl)registeredNumericalFMsPackage : new NumericalFMsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BasicFMsPackage.eNS_URI);
		BasicFMsPackageImpl theBasicFMsPackage = (BasicFMsPackageImpl)(registeredPackage instanceof BasicFMsPackageImpl ? registeredPackage : BasicFMsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(registeredPackage instanceof DataTypesPackageImpl ? registeredPackage : DataTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theNumericalFMsPackage.createPackageContents();
		theBasicFMsPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();

		// Initialize created meta-data
		theNumericalFMsPackage.initializePackageContents();
		theBasicFMsPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNumericalFMsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NumericalFMsPackage.eNS_URI, theNumericalFMsPackage);
		return theNumericalFMsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumericalFM() {
		return numericalFMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNumericalFM_Numericalfeatures() {
		return (EReference)numericalFMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNumericalFeature() {
		return numericalFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalFMsFactory getNumericalFMsFactory() {
		return (NumericalFMsFactory)getEFactoryInstance();
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
		numericalFMEClass = createEClass(NUMERICAL_FM);
		createEReference(numericalFMEClass, NUMERICAL_FM__NUMERICALFEATURES);

		numericalFeatureEClass = createEClass(NUMERICAL_FEATURE);
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
		DataTypesPackage theDataTypesPackage = (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		numericalFMEClass.getESuperTypes().add(theBasicFMsPackage.getFeatureModel());
		numericalFeatureEClass.getESuperTypes().add(theDataTypesPackage.getTypedFeature());

		// Initialize classes and features; add operations and parameters
		initEClass(numericalFMEClass, NumericalFM.class, "NumericalFM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericalFM_Numericalfeatures(), this.getNumericalFeature(), null, "numericalfeatures", null, 0, -1, NumericalFM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericalFeatureEClass, NumericalFeature.class, "NumericalFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //NumericalFMsPackageImpl
