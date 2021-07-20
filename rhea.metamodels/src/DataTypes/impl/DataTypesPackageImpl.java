/**
 */
package DataTypes.impl;

import BasicFMs.BasicFMsPackage;

import BasicFMs.impl.BasicFMsPackageImpl;

import DataTypes.DataType;
import DataTypes.DataTypesFactory;
import DataTypes.DataTypesPackage;
import DataTypes.NonTraditionalFM;
import DataTypes.ObjectType;
import DataTypes.PrimitiveType;
import DataTypes.PrimitiveTypeEnum;
import DataTypes.TypedFeature;
import DataTypes.Value;

import NumericalFMs.NumericalFMsPackage;

import NumericalFMs.impl.NumericalFMsPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataTypesPackageImpl extends EPackageImpl implements DataTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonTraditionalFMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

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
	 * @see DataTypes.DataTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataTypesPackageImpl() {
		super(eNS_URI, DataTypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataTypesPackage init() {
		if (isInited) return (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDataTypesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = registeredDataTypesPackage instanceof DataTypesPackageImpl ? (DataTypesPackageImpl)registeredDataTypesPackage : new DataTypesPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NumericalFMsPackage.eNS_URI);
		NumericalFMsPackageImpl theNumericalFMsPackage = (NumericalFMsPackageImpl)(registeredPackage instanceof NumericalFMsPackageImpl ? registeredPackage : NumericalFMsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BasicFMsPackage.eNS_URI);
		BasicFMsPackageImpl theBasicFMsPackage = (BasicFMsPackageImpl)(registeredPackage instanceof BasicFMsPackageImpl ? registeredPackage : BasicFMsPackage.eINSTANCE);

		// Create package meta-data objects
		theDataTypesPackage.createPackageContents();
		theNumericalFMsPackage.createPackageContents();
		theBasicFMsPackage.createPackageContents();

		// Initialize created meta-data
		theDataTypesPackage.initializePackageContents();
		theNumericalFMsPackage.initializePackageContents();
		theBasicFMsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataTypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataTypesPackage.eNS_URI, theDataTypesPackage);
		return theDataTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPrimitiveType_Type() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypedFeature() {
		return typedFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedFeature_Type() {
		return (EReference)typedFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedFeature_Value() {
		return (EReference)typedFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValue_Type() {
		return (EReference)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectType() {
		return objectTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getObjectType_Type() {
		return (EAttribute)objectTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNonTraditionalFM() {
		return nonTraditionalFMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNonTraditionalFM_Typedfeatures() {
		return (EReference)nonTraditionalFMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPrimitiveTypeEnum() {
		return primitiveTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataTypesFactory getDataTypesFactory() {
		return (DataTypesFactory)getEFactoryInstance();
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
		dataTypeEClass = createEClass(DATA_TYPE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__TYPE);

		typedFeatureEClass = createEClass(TYPED_FEATURE);
		createEReference(typedFeatureEClass, TYPED_FEATURE__TYPE);
		createEReference(typedFeatureEClass, TYPED_FEATURE__VALUE);

		valueEClass = createEClass(VALUE);
		createEReference(valueEClass, VALUE__TYPE);

		objectTypeEClass = createEClass(OBJECT_TYPE);
		createEAttribute(objectTypeEClass, OBJECT_TYPE__TYPE);

		nonTraditionalFMEClass = createEClass(NON_TRADITIONAL_FM);
		createEReference(nonTraditionalFMEClass, NON_TRADITIONAL_FM__TYPEDFEATURES);

		// Create enums
		primitiveTypeEnumEEnum = createEEnum(PRIMITIVE_TYPE_ENUM);

		// Create data types
		objectEDataType = createEDataType(OBJECT);
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
		primitiveTypeEClass.getESuperTypes().add(this.getDataType());
		typedFeatureEClass.getESuperTypes().add(theBasicFMsPackage.getFeature());
		objectTypeEClass.getESuperTypes().add(this.getDataType());
		nonTraditionalFMEClass.getESuperTypes().add(theBasicFMsPackage.getFeatureModel());

		// Initialize classes and features; add operations and parameters
		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveType_Type(), this.getPrimitiveTypeEnum(), "type", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedFeatureEClass, TypedFeature.class, "TypedFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedFeature_Type(), this.getDataType(), null, "type", null, 1, 1, TypedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedFeature_Value(), this.getValue(), null, "value", null, 0, -1, TypedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValue_Type(), this.getDataType(), null, "type", null, 1, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTypeEClass, ObjectType.class, "ObjectType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectType_Type(), this.getObject(), "type", null, 0, 1, ObjectType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nonTraditionalFMEClass, NonTraditionalFM.class, "NonTraditionalFM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonTraditionalFM_Typedfeatures(), this.getTypedFeature(), null, "typedfeatures", null, 0, -1, NonTraditionalFM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(primitiveTypeEnumEEnum, PrimitiveTypeEnum.class, "PrimitiveTypeEnum");
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.BOOLEAN);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.NATURAL);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.INTEGER);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.REAL);
		addEEnumLiteral(primitiveTypeEnumEEnum, PrimitiveTypeEnum.STRING);

		// Initialize data types
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DataTypesPackageImpl
