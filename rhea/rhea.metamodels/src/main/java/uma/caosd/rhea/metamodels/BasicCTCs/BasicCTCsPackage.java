/**
 */
package uma.caosd.rhea.metamodels.BasicCTCs;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uma.caosd.rhea.metamodels.BasicCTCs.BasicCTCsFactory
 * @model kind="package"
 * @generated
 */
public interface BasicCTCsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BasicCTCs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "metamodels.BasicCTCs";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uma.caosd.rhea";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasicCTCsPackage eINSTANCE = uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl.init();

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicConstraintImpl <em>Basic Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicConstraintImpl
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl#getBasicConstraint()
	 * @generated
	 */
	int BASIC_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__LEFT_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT__RIGHT_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Basic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Basic Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.BasicCTCs.impl.RequiresImpl <em>Requires</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.RequiresImpl
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl#getRequires()
	 * @generated
	 */
	int REQUIRES = 0;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES__LEFT_FEATURE = BASIC_CONSTRAINT__LEFT_FEATURE;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES__RIGHT_FEATURE = BASIC_CONSTRAINT__RIGHT_FEATURE;

	/**
	 * The number of structural features of the '<em>Requires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_FEATURE_COUNT = BASIC_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Requires</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_OPERATION_COUNT = BASIC_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.BasicCTCs.impl.ExcludesImpl <em>Excludes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.ExcludesImpl
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl#getExcludes()
	 * @generated
	 */
	int EXCLUDES = 1;

	/**
	 * The feature id for the '<em><b>Left Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__LEFT_FEATURE = BASIC_CONSTRAINT__LEFT_FEATURE;

	/**
	 * The feature id for the '<em><b>Right Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES__RIGHT_FEATURE = BASIC_CONSTRAINT__RIGHT_FEATURE;

	/**
	 * The number of structural features of the '<em>Excludes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_FEATURE_COUNT = BASIC_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Excludes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDES_OPERATION_COUNT = BASIC_CONSTRAINT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.BasicCTCs.Requires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requires</em>'.
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.Requires
	 * @generated
	 */
	EClass getRequires();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.BasicCTCs.Excludes <em>Excludes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Excludes</em>'.
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.Excludes
	 * @generated
	 */
	EClass getExcludes();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint <em>Basic Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Constraint</em>'.
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint
	 * @generated
	 */
	EClass getBasicConstraint();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint#getLeftFeature <em>Left Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Feature</em>'.
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint#getLeftFeature()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EReference getBasicConstraint_LeftFeature();

	/**
	 * Returns the meta object for the reference '{@link uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint#getRightFeature <em>Right Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Feature</em>'.
	 * @see uma.caosd.rhea.metamodels.BasicCTCs.BasicConstraint#getRightFeature()
	 * @see #getBasicConstraint()
	 * @generated
	 */
	EReference getBasicConstraint_RightFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BasicCTCsFactory getBasicCTCsFactory();

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
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.BasicCTCs.impl.RequiresImpl <em>Requires</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.RequiresImpl
		 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl#getRequires()
		 * @generated
		 */
		EClass REQUIRES = eINSTANCE.getRequires();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.BasicCTCs.impl.ExcludesImpl <em>Excludes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.ExcludesImpl
		 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl#getExcludes()
		 * @generated
		 */
		EClass EXCLUDES = eINSTANCE.getExcludes();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicConstraintImpl <em>Basic Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicConstraintImpl
		 * @see uma.caosd.rhea.metamodels.BasicCTCs.impl.BasicCTCsPackageImpl#getBasicConstraint()
		 * @generated
		 */
		EClass BASIC_CONSTRAINT = eINSTANCE.getBasicConstraint();

		/**
		 * The meta object literal for the '<em><b>Left Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONSTRAINT__LEFT_FEATURE = eINSTANCE.getBasicConstraint_LeftFeature();

		/**
		 * The meta object literal for the '<em><b>Right Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_CONSTRAINT__RIGHT_FEATURE = eINSTANCE.getBasicConstraint_RightFeature();

	}

} //BasicCTCsPackage
