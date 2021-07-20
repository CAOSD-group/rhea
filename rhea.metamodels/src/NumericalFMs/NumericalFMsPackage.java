/**
 */
package NumericalFMs;

import BasicFMs.BasicFMsPackage;

import DataTypes.DataTypesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see NumericalFMs.NumericalFMsFactory
 * @model kind="package"
 * @generated
 */
public interface NumericalFMsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "NumericalFMs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.NumericalFMs";

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
	NumericalFMsPackage eINSTANCE = NumericalFMs.impl.NumericalFMsPackageImpl.init();

	/**
	 * The meta object id for the '{@link NumericalFMs.impl.NumericalFMImpl <em>Numerical FM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see NumericalFMs.impl.NumericalFMImpl
	 * @see NumericalFMs.impl.NumericalFMsPackageImpl#getNumericalFM()
	 * @generated
	 */
	int NUMERICAL_FM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FM__NAME = BasicFMsPackage.FEATURE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FM__ROOT = BasicFMsPackage.FEATURE_MODEL__ROOT;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FM__FEATURES = BasicFMsPackage.FEATURE_MODEL__FEATURES;

	/**
	 * The feature id for the '<em><b>Crosstreeconstraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FM__CROSSTREECONSTRAINTS = BasicFMsPackage.FEATURE_MODEL__CROSSTREECONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Numericalfeatures</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FM__NUMERICALFEATURES = BasicFMsPackage.FEATURE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numerical FM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FM_FEATURE_COUNT = BasicFMsPackage.FEATURE_MODEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link NumericalFMs.impl.NumericalFeatureImpl <em>Numerical Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see NumericalFMs.impl.NumericalFeatureImpl
	 * @see NumericalFMs.impl.NumericalFMsPackageImpl#getNumericalFeature()
	 * @generated
	 */
	int NUMERICAL_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__ID = DataTypesPackage.TYPED_FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__NAME = DataTypesPackage.TYPED_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__MANDATORY = DataTypesPackage.TYPED_FEATURE__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__CHILDREN = DataTypesPackage.TYPED_FEATURE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__PARENT = DataTypesPackage.TYPED_FEATURE__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__ABSTRACT = DataTypesPackage.TYPED_FEATURE__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__TYPE = DataTypesPackage.TYPED_FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE__VALUE = DataTypesPackage.TYPED_FEATURE__VALUE;

	/**
	 * The number of structural features of the '<em>Numerical Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_FEATURE_FEATURE_COUNT = DataTypesPackage.TYPED_FEATURE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link NumericalFMs.NumericalFM <em>Numerical FM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical FM</em>'.
	 * @see NumericalFMs.NumericalFM
	 * @generated
	 */
	EClass getNumericalFM();

	/**
	 * Returns the meta object for the reference list '{@link NumericalFMs.NumericalFM#getNumericalfeatures <em>Numericalfeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Numericalfeatures</em>'.
	 * @see NumericalFMs.NumericalFM#getNumericalfeatures()
	 * @see #getNumericalFM()
	 * @generated
	 */
	EReference getNumericalFM_Numericalfeatures();

	/**
	 * Returns the meta object for class '{@link NumericalFMs.NumericalFeature <em>Numerical Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Feature</em>'.
	 * @see NumericalFMs.NumericalFeature
	 * @generated
	 */
	EClass getNumericalFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NumericalFMsFactory getNumericalFMsFactory();

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
		 * The meta object literal for the '{@link NumericalFMs.impl.NumericalFMImpl <em>Numerical FM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see NumericalFMs.impl.NumericalFMImpl
		 * @see NumericalFMs.impl.NumericalFMsPackageImpl#getNumericalFM()
		 * @generated
		 */
		EClass NUMERICAL_FM = eINSTANCE.getNumericalFM();

		/**
		 * The meta object literal for the '<em><b>Numericalfeatures</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_FM__NUMERICALFEATURES = eINSTANCE.getNumericalFM_Numericalfeatures();

		/**
		 * The meta object literal for the '{@link NumericalFMs.impl.NumericalFeatureImpl <em>Numerical Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see NumericalFMs.impl.NumericalFeatureImpl
		 * @see NumericalFMs.impl.NumericalFMsPackageImpl#getNumericalFeature()
		 * @generated
		 */
		EClass NUMERICAL_FEATURE = eINSTANCE.getNumericalFeature();

	}

} //NumericalFMsPackage
