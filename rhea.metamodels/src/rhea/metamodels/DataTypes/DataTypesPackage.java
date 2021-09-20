/**
 */
package rhea.metamodels.DataTypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import rhea.metamodels.BasicFMs.BasicFMsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see rhea.metamodels.DataTypes.DataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface DataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.DataTypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rhea";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataTypesPackage eINSTANCE = rhea.metamodels.DataTypes.impl.DataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.DataTypes.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.DataTypes.impl.DataTypeImpl
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rhea.metamodels.DataTypes.impl.TypedFeatureImpl <em>Typed Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.DataTypes.impl.TypedFeatureImpl
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getTypedFeature()
	 * @generated
	 */
	int TYPED_FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__ID = BasicFMsPackage.FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__NAME = BasicFMsPackage.FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__MANDATORY = BasicFMsPackage.FEATURE__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__CHILDREN = BasicFMsPackage.FEATURE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__PARENT = BasicFMsPackage.FEATURE__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__ABSTRACT = BasicFMsPackage.FEATURE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE__TYPE = BasicFMsPackage.FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_FEATURE_FEATURE_COUNT = BasicFMsPackage.FEATURE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rhea.metamodels.DataTypes.impl.ObjectTypeImpl <em>Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.DataTypes.impl.ObjectTypeImpl
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rhea.metamodels.DataTypes.impl.NonTraditionalFMImpl <em>Non Traditional FM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.DataTypes.impl.NonTraditionalFMImpl
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getNonTraditionalFM()
	 * @generated
	 */
	int NON_TRADITIONAL_FM = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TRADITIONAL_FM__NAME = BasicFMsPackage.FEATURE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TRADITIONAL_FM__ROOT = BasicFMsPackage.FEATURE_MODEL__ROOT;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TRADITIONAL_FM__FEATURES = BasicFMsPackage.FEATURE_MODEL__FEATURES;

	/**
	 * The feature id for the '<em><b>Crosstreeconstraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TRADITIONAL_FM__CROSSTREECONSTRAINTS = BasicFMsPackage.FEATURE_MODEL__CROSSTREECONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Typedfeatures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TRADITIONAL_FM__TYPEDFEATURES = BasicFMsPackage.FEATURE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Non Traditional FM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_TRADITIONAL_FM_FEATURE_COUNT = BasicFMsPackage.FEATURE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rhea.metamodels.DataTypes.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.DataTypes.PrimitiveTypeEnum
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getPrimitiveTypeEnum()
	 * @generated
	 */
	int PRIMITIVE_TYPE_ENUM = 5;

	/**
	 * The meta object id for the '<em>Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 6;


	/**
	 * Returns the meta object for class '{@link rhea.metamodels.DataTypes.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see rhea.metamodels.DataTypes.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.DataTypes.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see rhea.metamodels.DataTypes.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.DataTypes.PrimitiveType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see rhea.metamodels.DataTypes.PrimitiveType#getType()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Type();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.DataTypes.TypedFeature <em>Typed Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Feature</em>'.
	 * @see rhea.metamodels.DataTypes.TypedFeature
	 * @generated
	 */
	EClass getTypedFeature();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.DataTypes.TypedFeature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see rhea.metamodels.DataTypes.TypedFeature#getType()
	 * @see #getTypedFeature()
	 * @generated
	 */
	EReference getTypedFeature_Type();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.DataTypes.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Type</em>'.
	 * @see rhea.metamodels.DataTypes.ObjectType
	 * @generated
	 */
	EClass getObjectType();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.DataTypes.ObjectType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see rhea.metamodels.DataTypes.ObjectType#getType()
	 * @see #getObjectType()
	 * @generated
	 */
	EAttribute getObjectType_Type();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.DataTypes.NonTraditionalFM <em>Non Traditional FM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Traditional FM</em>'.
	 * @see rhea.metamodels.DataTypes.NonTraditionalFM
	 * @generated
	 */
	EClass getNonTraditionalFM();

	/**
	 * Returns the meta object for the reference list '{@link rhea.metamodels.DataTypes.NonTraditionalFM#getTypedfeatures <em>Typedfeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Typedfeatures</em>'.
	 * @see rhea.metamodels.DataTypes.NonTraditionalFM#getTypedfeatures()
	 * @see #getNonTraditionalFM()
	 * @generated
	 */
	EReference getNonTraditionalFM_Typedfeatures();

	/**
	 * Returns the meta object for enum '{@link rhea.metamodels.DataTypes.PrimitiveTypeEnum <em>Primitive Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type Enum</em>'.
	 * @see rhea.metamodels.DataTypes.PrimitiveTypeEnum
	 * @generated
	 */
	EEnum getPrimitiveTypeEnum();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataTypesFactory getDataTypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link rhea.metamodels.DataTypes.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.DataTypes.impl.DataTypeImpl
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.DataTypes.impl.PrimitiveTypeImpl
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__TYPE = eINSTANCE.getPrimitiveType_Type();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.DataTypes.impl.TypedFeatureImpl <em>Typed Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.DataTypes.impl.TypedFeatureImpl
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getTypedFeature()
		 * @generated
		 */
		EClass TYPED_FEATURE = eINSTANCE.getTypedFeature();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_FEATURE__TYPE = eINSTANCE.getTypedFeature_Type();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.DataTypes.impl.ObjectTypeImpl <em>Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.DataTypes.impl.ObjectTypeImpl
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getObjectType()
		 * @generated
		 */
		EClass OBJECT_TYPE = eINSTANCE.getObjectType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_TYPE__TYPE = eINSTANCE.getObjectType_Type();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.DataTypes.impl.NonTraditionalFMImpl <em>Non Traditional FM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.DataTypes.impl.NonTraditionalFMImpl
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getNonTraditionalFM()
		 * @generated
		 */
		EClass NON_TRADITIONAL_FM = eINSTANCE.getNonTraditionalFM();

		/**
		 * The meta object literal for the '<em><b>Typedfeatures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_TRADITIONAL_FM__TYPEDFEATURES = eINSTANCE.getNonTraditionalFM_Typedfeatures();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.DataTypes.PrimitiveTypeEnum <em>Primitive Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.DataTypes.PrimitiveTypeEnum
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getPrimitiveTypeEnum()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE_ENUM = eINSTANCE.getPrimitiveTypeEnum();

		/**
		 * The meta object literal for the '<em>Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see rhea.metamodels.DataTypes.impl.DataTypesPackageImpl#getObject()
		 * @generated
		 */
		EDataType OBJECT = eINSTANCE.getObject();

	}

} //DataTypesPackage
