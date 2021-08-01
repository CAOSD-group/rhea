/**
 */
package rhea.metamodels.ComparativeCTCs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import rhea.metamodels.PropLogicCTCs.PropLogicCTCsPackage;

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
 * @see rhea.metamodels.ComparativeCTCs.ComparativeCTCsFactory
 * @model kind="package"
 * @generated
 */
public interface ComparativeCTCsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ComparativeCTCs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.ComparativeCTCs";

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
	ComparativeCTCsPackage eINSTANCE = rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.BinaryComparativeTermImpl <em>Binary Comparative Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.BinaryComparativeTermImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getBinaryComparativeTerm()
	 * @generated
	 */
	int BINARY_COMPARATIVE_TERM = 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPARATIVE_TERM__LEFT = PropLogicCTCsPackage.TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPARATIVE_TERM__RIGHT = PropLogicCTCsPackage.TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Comparative Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_COMPARATIVE_TERM_FEATURE_COUNT = PropLogicCTCsPackage.TERM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.EqualImpl <em>Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.EqualImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getEqual()
	 * @generated
	 */
	int EQUAL = 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__LEFT = BINARY_COMPARATIVE_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__RIGHT = BINARY_COMPARATIVE_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_FEATURE_COUNT = BINARY_COMPARATIVE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.NotEqualImpl <em>Not Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.NotEqualImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getNotEqual()
	 * @generated
	 */
	int NOT_EQUAL = 2;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__LEFT = BINARY_COMPARATIVE_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL__RIGHT = BINARY_COMPARATIVE_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>Not Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL_FEATURE_COUNT = BINARY_COMPARATIVE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.LessImpl <em>Less</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.LessImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getLess()
	 * @generated
	 */
	int LESS = 3;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__LEFT = BINARY_COMPARATIVE_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__RIGHT = BINARY_COMPARATIVE_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>Less</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_FEATURE_COUNT = BINARY_COMPARATIVE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.MoreImpl <em>More</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.MoreImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getMore()
	 * @generated
	 */
	int MORE = 4;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE__LEFT = BINARY_COMPARATIVE_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE__RIGHT = BINARY_COMPARATIVE_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>More</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE_FEATURE_COUNT = BINARY_COMPARATIVE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.LessOrEqualImpl <em>Less Or Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.LessOrEqualImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getLessOrEqual()
	 * @generated
	 */
	int LESS_OR_EQUAL = 5;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__LEFT = BINARY_COMPARATIVE_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__RIGHT = BINARY_COMPARATIVE_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Or Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_FEATURE_COUNT = BINARY_COMPARATIVE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.MoreOrEqualImpl <em>More Or Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.MoreOrEqualImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getMoreOrEqual()
	 * @generated
	 */
	int MORE_OR_EQUAL = 6;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE_OR_EQUAL__LEFT = BINARY_COMPARATIVE_TERM__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE_OR_EQUAL__RIGHT = BINARY_COMPARATIVE_TERM__RIGHT;

	/**
	 * The number of structural features of the '<em>More Or Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORE_OR_EQUAL_FEATURE_COUNT = BINARY_COMPARATIVE_TERM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl <em>Numeric Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl
	 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getNumericTerm()
	 * @generated
	 */
	int NUMERIC_TERM = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TERM__VALUE = PropLogicCTCsPackage.TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TERM_FEATURE_COUNT = PropLogicCTCsPackage.TERM_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm <em>Binary Comparative Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Comparative Term</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm
	 * @generated
	 */
	EClass getBinaryComparativeTerm();

	/**
	 * Returns the meta object for the reference '{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getLeft()
	 * @see #getBinaryComparativeTerm()
	 * @generated
	 */
	EReference getBinaryComparativeTerm_Left();

	/**
	 * Returns the meta object for the reference '{@link rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm#getRight()
	 * @see #getBinaryComparativeTerm()
	 * @generated
	 */
	EReference getBinaryComparativeTerm_Right();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.Equal
	 * @generated
	 */
	EClass getEqual();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.NotEqual <em>Not Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Equal</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.NotEqual
	 * @generated
	 */
	EClass getNotEqual();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.Less <em>Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.Less
	 * @generated
	 */
	EClass getLess();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.More <em>More</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>More</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.More
	 * @generated
	 */
	EClass getMore();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.LessOrEqual <em>Less Or Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Or Equal</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.LessOrEqual
	 * @generated
	 */
	EClass getLessOrEqual();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.MoreOrEqual <em>More Or Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>More Or Equal</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.MoreOrEqual
	 * @generated
	 */
	EClass getMoreOrEqual();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.ComparativeCTCs.NumericTerm <em>Numeric Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Term</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.NumericTerm
	 * @generated
	 */
	EClass getNumericTerm();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.ComparativeCTCs.NumericTerm#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see rhea.metamodels.ComparativeCTCs.NumericTerm#getValue()
	 * @see #getNumericTerm()
	 * @generated
	 */
	EAttribute getNumericTerm_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComparativeCTCsFactory getComparativeCTCsFactory();

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
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.BinaryComparativeTermImpl <em>Binary Comparative Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.BinaryComparativeTermImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getBinaryComparativeTerm()
		 * @generated
		 */
		EClass BINARY_COMPARATIVE_TERM = eINSTANCE.getBinaryComparativeTerm();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_COMPARATIVE_TERM__LEFT = eINSTANCE.getBinaryComparativeTerm_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_COMPARATIVE_TERM__RIGHT = eINSTANCE.getBinaryComparativeTerm_Right();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.EqualImpl <em>Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.EqualImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getEqual()
		 * @generated
		 */
		EClass EQUAL = eINSTANCE.getEqual();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.NotEqualImpl <em>Not Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.NotEqualImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getNotEqual()
		 * @generated
		 */
		EClass NOT_EQUAL = eINSTANCE.getNotEqual();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.LessImpl <em>Less</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.LessImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getLess()
		 * @generated
		 */
		EClass LESS = eINSTANCE.getLess();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.MoreImpl <em>More</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.MoreImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getMore()
		 * @generated
		 */
		EClass MORE = eINSTANCE.getMore();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.LessOrEqualImpl <em>Less Or Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.LessOrEqualImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getLessOrEqual()
		 * @generated
		 */
		EClass LESS_OR_EQUAL = eINSTANCE.getLessOrEqual();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.MoreOrEqualImpl <em>More Or Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.MoreOrEqualImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getMoreOrEqual()
		 * @generated
		 */
		EClass MORE_OR_EQUAL = eINSTANCE.getMoreOrEqual();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl <em>Numeric Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.ComparativeCTCs.impl.NumericTermImpl
		 * @see rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsPackageImpl#getNumericTerm()
		 * @generated
		 */
		EClass NUMERIC_TERM = eINSTANCE.getNumericTerm();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_TERM__VALUE = eINSTANCE.getNumericTerm_Value();

	}

} //ComparativeCTCsPackage
