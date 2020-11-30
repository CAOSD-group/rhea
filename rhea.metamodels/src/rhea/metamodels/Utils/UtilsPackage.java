/**
 */
package rhea.metamodels.Utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see rhea.metamodels.Utils.UtilsFactory
 * @model kind="package"
 * @generated
 */
public interface UtilsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Utils";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.Utils";

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
	UtilsPackage eINSTANCE = rhea.metamodels.Utils.impl.UtilsPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.Utils.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.Utils.impl.NamedElementImpl
	 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.Utils.impl.IntResultImpl <em>Int Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.Utils.impl.IntResultImpl
	 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getIntResult()
	 * @generated
	 */
	int INT_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESULT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESULT__RESULT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESULT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESULT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.Utils.impl.DoubleResultImpl <em>Double Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.Utils.impl.DoubleResultImpl
	 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getDoubleResult()
	 * @generated
	 */
	int DOUBLE_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RESULT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RESULT__RESULT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RESULT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Double Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RESULT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.Utils.impl.StringResultImpl <em>String Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.Utils.impl.StringResultImpl
	 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getStringResult()
	 * @generated
	 */
	int STRING_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESULT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESULT__RESULT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESULT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_RESULT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link rhea.metamodels.Utils.IntResult <em>Int Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Result</em>'.
	 * @see rhea.metamodels.Utils.IntResult
	 * @generated
	 */
	EClass getIntResult();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.Utils.IntResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see rhea.metamodels.Utils.IntResult#getResult()
	 * @see #getIntResult()
	 * @generated
	 */
	EAttribute getIntResult_Result();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.Utils.DoubleResult <em>Double Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Result</em>'.
	 * @see rhea.metamodels.Utils.DoubleResult
	 * @generated
	 */
	EClass getDoubleResult();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.Utils.DoubleResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see rhea.metamodels.Utils.DoubleResult#getResult()
	 * @see #getDoubleResult()
	 * @generated
	 */
	EAttribute getDoubleResult_Result();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.Utils.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see rhea.metamodels.Utils.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.Utils.NamedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see rhea.metamodels.Utils.NamedElement#getId()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Id();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.Utils.StringResult <em>String Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Result</em>'.
	 * @see rhea.metamodels.Utils.StringResult
	 * @generated
	 */
	EClass getStringResult();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.Utils.StringResult#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see rhea.metamodels.Utils.StringResult#getResult()
	 * @see #getStringResult()
	 * @generated
	 */
	EAttribute getStringResult_Result();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UtilsFactory getUtilsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link rhea.metamodels.Utils.impl.IntResultImpl <em>Int Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.Utils.impl.IntResultImpl
		 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getIntResult()
		 * @generated
		 */
		EClass INT_RESULT = eINSTANCE.getIntResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_RESULT__RESULT = eINSTANCE.getIntResult_Result();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.Utils.impl.DoubleResultImpl <em>Double Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.Utils.impl.DoubleResultImpl
		 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getDoubleResult()
		 * @generated
		 */
		EClass DOUBLE_RESULT = eINSTANCE.getDoubleResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RESULT__RESULT = eINSTANCE.getDoubleResult_Result();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.Utils.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.Utils.impl.NamedElementImpl
		 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__ID = eINSTANCE.getNamedElement_Id();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.Utils.impl.StringResultImpl <em>String Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.Utils.impl.StringResultImpl
		 * @see rhea.metamodels.Utils.impl.UtilsPackageImpl#getStringResult()
		 * @generated
		 */
		EClass STRING_RESULT = eINSTANCE.getStringResult();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_RESULT__RESULT = eINSTANCE.getStringResult_Result();

	}

} //UtilsPackage
