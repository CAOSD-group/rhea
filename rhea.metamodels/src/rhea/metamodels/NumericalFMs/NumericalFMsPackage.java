/**
 */
package rhea.metamodels.NumericalFMs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import rhea.metamodels.BasicFMs.BasicFMsPackage;
import rhea.metamodels.DataTypes.DataTypesPackage;

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
 * @see rhea.metamodels.NumericalFMs.NumericalFMsFactory
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
	NumericalFMsPackage eINSTANCE = rhea.metamodels.NumericalFMs.impl.NumericalFMsPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.NumericalFMs.impl.NumericalFeatureImpl <em>Numerical Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.NumericalFMs.impl.NumericalFeatureImpl
	 * @see rhea.metamodels.NumericalFMs.impl.NumericalFMsPackageImpl#getNumericalFeature()
	 * @generated
	 */
	int NUMERICAL_FEATURE = 0;

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
	 * The feature id for the '<em><b>Value</b></em>' attribute.
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
	 * Returns the meta object for class '{@link rhea.metamodels.NumericalFMs.NumericalFeature <em>Numerical Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Feature</em>'.
	 * @see rhea.metamodels.NumericalFMs.NumericalFeature
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
		 * The meta object literal for the '{@link rhea.metamodels.NumericalFMs.impl.NumericalFeatureImpl <em>Numerical Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.NumericalFMs.impl.NumericalFeatureImpl
		 * @see rhea.metamodels.NumericalFMs.impl.NumericalFMsPackageImpl#getNumericalFeature()
		 * @generated
		 */
		EClass NUMERICAL_FEATURE = eINSTANCE.getNumericalFeature();

	}

} //NumericalFMsPackage
