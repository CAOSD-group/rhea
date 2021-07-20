/**
 */
package BasicFMs.impl;

import BasicFMs.AlternativeGroup;
import BasicFMs.BasicFMsFactory;
import BasicFMs.BasicFMsPackage;
import BasicFMs.CrossTreeConstraint;
import BasicFMs.Feature;
import BasicFMs.FeatureGroup;
import BasicFMs.FeatureModel;
import BasicFMs.SelectionGroup;

import DataTypes.DataTypesPackage;

import DataTypes.impl.DataTypesPackageImpl;

import NumericalFMs.NumericalFMsPackage;

import NumericalFMs.impl.NumericalFMsPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BasicFMsPackageImpl extends EPackageImpl implements BasicFMsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crossTreeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternativeGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionGroupEClass = null;

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
	 * @see BasicFMs.BasicFMsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BasicFMsPackageImpl() {
		super(eNS_URI, BasicFMsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BasicFMsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BasicFMsPackage init() {
		if (isInited) return (BasicFMsPackage)EPackage.Registry.INSTANCE.getEPackage(BasicFMsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBasicFMsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BasicFMsPackageImpl theBasicFMsPackage = registeredBasicFMsPackage instanceof BasicFMsPackageImpl ? (BasicFMsPackageImpl)registeredBasicFMsPackage : new BasicFMsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NumericalFMsPackage.eNS_URI);
		NumericalFMsPackageImpl theNumericalFMsPackage = (NumericalFMsPackageImpl)(registeredPackage instanceof NumericalFMsPackageImpl ? registeredPackage : NumericalFMsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(registeredPackage instanceof DataTypesPackageImpl ? registeredPackage : DataTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theBasicFMsPackage.createPackageContents();
		theNumericalFMsPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();

		// Initialize created meta-data
		theBasicFMsPackage.initializePackageContents();
		theNumericalFMsPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBasicFMsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BasicFMsPackage.eNS_URI, theBasicFMsPackage);
		return theBasicFMsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeatureModel() {
		return featureModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeatureModel_Name() {
		return (EAttribute)featureModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeatureModel_Root() {
		return (EReference)featureModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeatureModel_Features() {
		return (EReference)featureModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeatureModel_Crosstreeconstraints() {
		return (EReference)featureModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeature_Id() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeature_Name() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeature_Mandatory() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeature_Children() {
		return (EReference)featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeature_Parent() {
		return (EReference)featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getFeature_Abstract() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCrossTreeConstraint() {
		return crossTreeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeatureGroup() {
		return featureGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAlternativeGroup() {
		return alternativeGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSelectionGroup() {
		return selectionGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicFMsFactory getBasicFMsFactory() {
		return (BasicFMsFactory)getEFactoryInstance();
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
		featureModelEClass = createEClass(FEATURE_MODEL);
		createEAttribute(featureModelEClass, FEATURE_MODEL__NAME);
		createEReference(featureModelEClass, FEATURE_MODEL__ROOT);
		createEReference(featureModelEClass, FEATURE_MODEL__FEATURES);
		createEReference(featureModelEClass, FEATURE_MODEL__CROSSTREECONSTRAINTS);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__ID);
		createEAttribute(featureEClass, FEATURE__NAME);
		createEAttribute(featureEClass, FEATURE__MANDATORY);
		createEReference(featureEClass, FEATURE__CHILDREN);
		createEReference(featureEClass, FEATURE__PARENT);
		createEAttribute(featureEClass, FEATURE__ABSTRACT);

		crossTreeConstraintEClass = createEClass(CROSS_TREE_CONSTRAINT);

		featureGroupEClass = createEClass(FEATURE_GROUP);

		alternativeGroupEClass = createEClass(ALTERNATIVE_GROUP);

		selectionGroupEClass = createEClass(SELECTION_GROUP);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureGroupEClass.getESuperTypes().add(this.getFeature());
		alternativeGroupEClass.getESuperTypes().add(this.getFeatureGroup());
		selectionGroupEClass.getESuperTypes().add(this.getFeatureGroup());

		// Initialize classes and features; add operations and parameters
		initEClass(featureModelEClass, FeatureModel.class, "FeatureModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureModel_Name(), ecorePackage.getEString(), "name", null, 1, 1, FeatureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureModel_Root(), this.getFeature(), null, "root", null, 0, 1, FeatureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureModel_Features(), this.getFeature(), null, "features", null, 0, -1, FeatureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureModel_Crosstreeconstraints(), this.getCrossTreeConstraint(), null, "crosstreeconstraints", null, 0, -1, FeatureModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(featureModelEClass, this.getFeature(), "getFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Id(), ecorePackage.getEString(), "id", null, 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "false", 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Children(), this.getFeature(), this.getFeature_Parent(), "children", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_Parent(), this.getFeature(), this.getFeature_Children(), "parent", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(featureEClass, ecorePackage.getEBoolean(), "isLeaf", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureEClass, ecorePackage.getEBoolean(), "isRoot", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(crossTreeConstraintEClass, CrossTreeConstraint.class, "CrossTreeConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureGroupEClass, FeatureGroup.class, "FeatureGroup", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alternativeGroupEClass, AlternativeGroup.class, "AlternativeGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(selectionGroupEClass, SelectionGroup.class, "SelectionGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BasicFMsPackageImpl
