/**
 */
package rhea.metamodels.CardinalityBasedFMs;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory
 * @model kind="package"
 * @generated
 */
public interface CardinalityBasedFMsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CardinalityBasedFMs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.CardinalityBasedFMs";

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
	CardinalityBasedFMsPackage eINSTANCE = rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.CardinalityBasedFMs.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CardinalityBasedFMs.impl.MultiplicityImpl
	 * @see rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl#getMultiplicity()
	 * @generated
	 */
	int MULTIPLICITY = 0;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY__LOWER = 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY__UPPER = 1;

	/**
	 * The number of structural features of the '<em>Multiplicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl <em>Group Cardinality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl
	 * @see rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl#getGroupCardinality()
	 * @generated
	 */
	int GROUP_CARDINALITY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__ID = BasicFMsPackage.FEATURE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__NAME = BasicFMsPackage.FEATURE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__MANDATORY = BasicFMsPackage.FEATURE_GROUP__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__CHILDREN = BasicFMsPackage.FEATURE_GROUP__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__PARENT = BasicFMsPackage.FEATURE_GROUP__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__ABSTRACT = BasicFMsPackage.FEATURE_GROUP__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__MULTIPLICITY = BasicFMsPackage.FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Group Cardinality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_FEATURE_COUNT = BasicFMsPackage.FEATURE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CardinalityBasedFMs.impl.MutexGroupImpl <em>Mutex Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CardinalityBasedFMs.impl.MutexGroupImpl
	 * @see rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl#getMutexGroup()
	 * @generated
	 */
	int MUTEX_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__ID = BasicFMsPackage.FEATURE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__NAME = BasicFMsPackage.FEATURE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__MANDATORY = BasicFMsPackage.FEATURE_GROUP__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__CHILDREN = BasicFMsPackage.FEATURE_GROUP__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__PARENT = BasicFMsPackage.FEATURE_GROUP__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__ABSTRACT = BasicFMsPackage.FEATURE_GROUP__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Mutex Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP_FEATURE_COUNT = BasicFMsPackage.FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CardinalityBasedFMs.Multiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity</em>'.
	 * @see rhea.metamodels.CardinalityBasedFMs.Multiplicity
	 * @generated
	 */
	EClass getMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CardinalityBasedFMs.Multiplicity#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see rhea.metamodels.CardinalityBasedFMs.Multiplicity#getLower()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_Lower();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CardinalityBasedFMs.Multiplicity#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see rhea.metamodels.CardinalityBasedFMs.Multiplicity#getUpper()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_Upper();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CardinalityBasedFMs.GroupCardinality <em>Group Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Cardinality</em>'.
	 * @see rhea.metamodels.CardinalityBasedFMs.GroupCardinality
	 * @generated
	 */
	EClass getGroupCardinality();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.CardinalityBasedFMs.GroupCardinality#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see rhea.metamodels.CardinalityBasedFMs.GroupCardinality#getMultiplicity()
	 * @see #getGroupCardinality()
	 * @generated
	 */
	EReference getGroupCardinality_Multiplicity();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CardinalityBasedFMs.MutexGroup <em>Mutex Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutex Group</em>'.
	 * @see rhea.metamodels.CardinalityBasedFMs.MutexGroup
	 * @generated
	 */
	EClass getMutexGroup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CardinalityBasedFMsFactory getCardinalityBasedFMsFactory();

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
		 * The meta object literal for the '{@link rhea.metamodels.CardinalityBasedFMs.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CardinalityBasedFMs.impl.MultiplicityImpl
		 * @see rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl#getMultiplicity()
		 * @generated
		 */
		EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY__LOWER = eINSTANCE.getMultiplicity_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICITY__UPPER = eINSTANCE.getMultiplicity_Upper();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl <em>Group Cardinality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl
		 * @see rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl#getGroupCardinality()
		 * @generated
		 */
		EClass GROUP_CARDINALITY = eINSTANCE.getGroupCardinality();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_CARDINALITY__MULTIPLICITY = eINSTANCE.getGroupCardinality_Multiplicity();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CardinalityBasedFMs.impl.MutexGroupImpl <em>Mutex Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CardinalityBasedFMs.impl.MutexGroupImpl
		 * @see rhea.metamodels.CardinalityBasedFMs.impl.CardinalityBasedFMsPackageImpl#getMutexGroup()
		 * @generated
		 */
		EClass MUTEX_GROUP = eINSTANCE.getMutexGroup();

	}

} //CardinalityBasedFMsPackage
