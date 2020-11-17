/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see rhea.metamodels.PropLogicCTCs.PropLogicCTCsFactory
 * @model kind="package"
 * @generated
 */
public interface PropLogicCTCsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PropLogicCTCs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.PropLogicCTCs";

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
	PropLogicCTCsPackage eINSTANCE = rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl <em>Advanced Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getAdvancedConstraint()
	 * @generated
	 */
	int ADVANCED_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT__TERM = BasicFMsPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Advanced Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT_FEATURE_COUNT = BasicFMsPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Advanced Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT_OPERATION_COUNT = BasicFMsPackage.CROSS_TREE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.TermImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__TERM = 1;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM__OPERANDS = 2;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.TermType <em>Term Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.TermType
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getTermType()
	 * @generated
	 */
	int TERM_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint <em>Advanced Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advanced Constraint</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.AdvancedConstraint
	 * @generated
	 */
	EClass getAdvancedConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getTerm()
	 * @see #getAdvancedConstraint()
	 * @generated
	 */
	EReference getAdvancedConstraint_Term();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.PropLogicCTCs.Term#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Term#getType()
	 * @see #getTerm()
	 * @generated
	 */
	EAttribute getTerm_Type();

	/**
	 * Returns the meta object for the reference '{@link rhea.metamodels.PropLogicCTCs.Term#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Term</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Term#getTerm()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Term();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.PropLogicCTCs.Term#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Term#getOperands()
	 * @see #getTerm()
	 * @generated
	 */
	EReference getTerm_Operands();

	/**
	 * Returns the meta object for enum '{@link rhea.metamodels.PropLogicCTCs.TermType <em>Term Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Term Type</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.TermType
	 * @generated
	 */
	EEnum getTermType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PropLogicCTCsFactory getPropLogicCTCsFactory();

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
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl <em>Advanced Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.AdvancedConstraintImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getAdvancedConstraint()
		 * @generated
		 */
		EClass ADVANCED_CONSTRAINT = eINSTANCE.getAdvancedConstraint();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_CONSTRAINT__TERM = eINSTANCE.getAdvancedConstraint_Term();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.TermImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM__TYPE = eINSTANCE.getTerm_Type();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__TERM = eINSTANCE.getTerm_Term();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM__OPERANDS = eINSTANCE.getTerm_Operands();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.TermType <em>Term Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.TermType
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getTermType()
		 * @generated
		 */
		EEnum TERM_TYPE = eINSTANCE.getTermType();

	}

} //PropLogicCTCsPackage
