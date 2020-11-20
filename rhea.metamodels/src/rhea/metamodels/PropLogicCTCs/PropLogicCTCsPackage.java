/**
 */
package rhea.metamodels.PropLogicCTCs;

import org.eclipse.emf.ecore.EClass;
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
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_CONSTRAINT__EXPR = BasicFMsPackage.CROSS_TREE_CONSTRAINT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl <em>Feature Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getFeatureTerm()
	 * @generated
	 */
	int FEATURE_TERM = 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TERM__FEATURE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.NotImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 3;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__TERM = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.AndImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 4;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TERMS = 0;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.OrImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getOr()
	 * @generated
	 */
	int OR = 5;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__TERMS = 0;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.XorImpl <em>Xor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.XorImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getXor()
	 * @generated
	 */
	int XOR = 6;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__TERMS = 0;

	/**
	 * The number of structural features of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.EquivImpl <em>Equiv</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.EquivImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getEquiv()
	 * @generated
	 */
	int EQUIV = 7;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIV__TERMS = 0;

	/**
	 * The number of structural features of the '<em>Equiv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIV_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Equiv</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIV_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl <em>Implies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getImplies()
	 * @generated
	 */
	int IMPLIES = 8;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__LEFT = 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Implies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Implies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.PropLogicCTCs.impl.ExcludesImpl <em>Excludes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.PropLogicCTCs.impl.ExcludesImpl
	 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getExcludes()
	 * @generated
	 */
	int EXCLUDES = 9;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__LEFT = 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__RIGHT = 1;

	/**
	 * The number of structural features of the '<em>Excludes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Excludes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.AdvancedConstraint#getExpr()
	 * @see #getAdvancedConstraint()
	 * @generated
	 */
	EReference getAdvancedConstraint_Expr();

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
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.FeatureTerm <em>Feature Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Term</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.FeatureTerm
	 * @generated
	 */
	EClass getFeatureTerm();

	/**
	 * Returns the meta object for the reference '{@link rhea.metamodels.PropLogicCTCs.FeatureTerm#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.FeatureTerm#getFeature()
	 * @see #getFeatureTerm()
	 * @generated
	 */
	EReference getFeatureTerm_Feature();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.Not#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Not#getTerm()
	 * @see #getNot()
	 * @generated
	 */
	EReference getNot_Term();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.PropLogicCTCs.And#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.And#getTerms()
	 * @see #getAnd()
	 * @generated
	 */
	EReference getAnd_Terms();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.PropLogicCTCs.Or#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Or#getTerms()
	 * @see #getOr()
	 * @generated
	 */
	EReference getOr_Terms();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Xor
	 * @generated
	 */
	EClass getXor();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.PropLogicCTCs.Xor#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Xor#getTerms()
	 * @see #getXor()
	 * @generated
	 */
	EReference getXor_Terms();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Equiv <em>Equiv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equiv</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Equiv
	 * @generated
	 */
	EClass getEquiv();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.PropLogicCTCs.Equiv#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Equiv#getTerms()
	 * @see #getEquiv()
	 * @generated
	 */
	EReference getEquiv_Terms();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Implies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implies</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Implies
	 * @generated
	 */
	EClass getImplies();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.Implies#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Implies#getLeft()
	 * @see #getImplies()
	 * @generated
	 */
	EReference getImplies_Left();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.Implies#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Implies#getRight()
	 * @see #getImplies()
	 * @generated
	 */
	EReference getImplies_Right();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.PropLogicCTCs.Excludes <em>Excludes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excludes</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Excludes
	 * @generated
	 */
	EClass getExcludes();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.Excludes#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Excludes#getLeft()
	 * @see #getExcludes()
	 * @generated
	 */
	EReference getExcludes_Left();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.PropLogicCTCs.Excludes#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see rhea.metamodels.PropLogicCTCs.Excludes#getRight()
	 * @see #getExcludes()
	 * @generated
	 */
	EReference getExcludes_Right();

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
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_CONSTRAINT__EXPR = eINSTANCE.getAdvancedConstraint_Expr();

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
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl <em>Feature Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.FeatureTermImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getFeatureTerm()
		 * @generated
		 */
		EClass FEATURE_TERM = eINSTANCE.getFeatureTerm();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TERM__FEATURE = eINSTANCE.getFeatureTerm_Feature();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.NotImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT__TERM = eINSTANCE.getNot_Term();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.AndImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND__TERMS = eINSTANCE.getAnd_Terms();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.OrImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR__TERMS = eINSTANCE.getOr_Terms();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.XorImpl <em>Xor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.XorImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getXor()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXor();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XOR__TERMS = eINSTANCE.getXor_Terms();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.EquivImpl <em>Equiv</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.EquivImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getEquiv()
		 * @generated
		 */
		EClass EQUIV = eINSTANCE.getEquiv();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUIV__TERMS = eINSTANCE.getEquiv_Terms();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl <em>Implies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.ImpliesImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getImplies()
		 * @generated
		 */
		EClass IMPLIES = eINSTANCE.getImplies();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLIES__LEFT = eINSTANCE.getImplies_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLIES__RIGHT = eINSTANCE.getImplies_Right();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.PropLogicCTCs.impl.ExcludesImpl <em>Excludes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.PropLogicCTCs.impl.ExcludesImpl
		 * @see rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsPackageImpl#getExcludes()
		 * @generated
		 */
		EClass EXCLUDES = eINSTANCE.getExcludes();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUDES__LEFT = eINSTANCE.getExcludes_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUDES__RIGHT = eINSTANCE.getExcludes_Right();

	}

} //PropLogicCTCsPackage
