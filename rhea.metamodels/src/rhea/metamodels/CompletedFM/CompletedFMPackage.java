/**
 */
package rhea.metamodels.CompletedFM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see rhea.metamodels.CompletedFM.CompletedFMFactory
 * @model kind="package"
 * @generated
 */
public interface CompletedFMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CompletedFM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.CompletedFM";

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
	CompletedFMPackage eINSTANCE = rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl.init();

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.FeatureImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__MANDATORY = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CHILDREN = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PARENT = 4;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ABSTRACT = 5;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 6;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___IS_LEAF = 0;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE___IS_ROOT = 1;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.FeatureGroupImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getFeatureGroup()
	 * @generated
	 */
	int FEATURE_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__ID = FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__MANDATORY = FEATURE__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__CHILDREN = FEATURE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__PARENT = FEATURE__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__ABSTRACT = FEATURE__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Feature Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP___IS_LEAF = FEATURE___IS_LEAF;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP___IS_ROOT = FEATURE___IS_ROOT;

	/**
	 * The number of operations of the '<em>Feature Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.AlternativeGroupImpl <em>Alternative Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.AlternativeGroupImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getAlternativeGroup()
	 * @generated
	 */
	int ALTERNATIVE_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP__ID = FEATURE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP__NAME = FEATURE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP__MANDATORY = FEATURE_GROUP__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP__CHILDREN = FEATURE_GROUP__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP__PARENT = FEATURE_GROUP__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP__ABSTRACT = FEATURE_GROUP__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Alternative Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP_FEATURE_COUNT = FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP___IS_LEAF = FEATURE_GROUP___IS_LEAF;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP___IS_ROOT = FEATURE_GROUP___IS_ROOT;

	/**
	 * The number of operations of the '<em>Alternative Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_GROUP_OPERATION_COUNT = FEATURE_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.FeatureModelImpl <em>Feature Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.FeatureModelImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getFeatureModel()
	 * @generated
	 */
	int FEATURE_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__ROOT = 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__FEATURES = 2;

	/**
	 * The feature id for the '<em><b>Crosstreeconstraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL__CROSSTREECONSTRAINTS = 3;

	/**
	 * The number of structural features of the '<em>Feature Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Feature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL___GET_FEATURE__STRING = 0;

	/**
	 * The number of operations of the '<em>Feature Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_MODEL_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.SelectionGroupImpl <em>Selection Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.SelectionGroupImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getSelectionGroup()
	 * @generated
	 */
	int SELECTION_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP__ID = FEATURE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP__NAME = FEATURE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP__MANDATORY = FEATURE_GROUP__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP__CHILDREN = FEATURE_GROUP__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP__PARENT = FEATURE_GROUP__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP__ABSTRACT = FEATURE_GROUP__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Selection Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP_FEATURE_COUNT = FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP___IS_LEAF = FEATURE_GROUP___IS_LEAF;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP___IS_ROOT = FEATURE_GROUP___IS_ROOT;

	/**
	 * The number of operations of the '<em>Selection Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_GROUP_OPERATION_COUNT = FEATURE_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.CrossTreeConstraintImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getCrossTreeConstraint()
	 * @generated
	 */
	int CROSS_TREE_CONSTRAINT = 5;

	/**
	 * The number of structural features of the '<em>Cross Tree Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Cross Tree Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_TREE_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.MutexGroupImpl <em>Mutex Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.MutexGroupImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getMutexGroup()
	 * @generated
	 */
	int MUTEX_GROUP = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__ID = FEATURE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__NAME = FEATURE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__MANDATORY = FEATURE_GROUP__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__CHILDREN = FEATURE_GROUP__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__PARENT = FEATURE_GROUP__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP__ABSTRACT = FEATURE_GROUP__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Mutex Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP_FEATURE_COUNT = FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP___IS_LEAF = FEATURE_GROUP___IS_LEAF;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP___IS_ROOT = FEATURE_GROUP___IS_ROOT;

	/**
	 * The number of operations of the '<em>Mutex Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_GROUP_OPERATION_COUNT = FEATURE_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.MultiplicityImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getMultiplicity()
	 * @generated
	 */
	int MULTIPLICITY = 7;

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
	 * The number of operations of the '<em>Multiplicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link rhea.metamodels.CompletedFM.impl.GroupCardinalityImpl <em>Group Cardinality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see rhea.metamodels.CompletedFM.impl.GroupCardinalityImpl
	 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getGroupCardinality()
	 * @generated
	 */
	int GROUP_CARDINALITY = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__ID = FEATURE_GROUP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__NAME = FEATURE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__MANDATORY = FEATURE_GROUP__MANDATORY;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__CHILDREN = FEATURE_GROUP__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__PARENT = FEATURE_GROUP__PARENT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__ABSTRACT = FEATURE_GROUP__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY__MULTIPLICITY = FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Group Cardinality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_FEATURE_COUNT = FEATURE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY___IS_LEAF = FEATURE_GROUP___IS_LEAF;

	/**
	 * The operation id for the '<em>Is Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY___IS_ROOT = FEATURE_GROUP___IS_ROOT;

	/**
	 * The number of operations of the '<em>Group Cardinality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CARDINALITY_OPERATION_COUNT = FEATURE_GROUP_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.Feature#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature#isMandatory()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Mandatory();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.CompletedFM.Feature#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature#getChildren()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Children();

	/**
	 * Returns the meta object for the container reference '{@link rhea.metamodels.CompletedFM.Feature#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature#getParent()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Parent();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.Feature#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see rhea.metamodels.CompletedFM.Feature#isAbstract()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Abstract();

	/**
	 * Returns the meta object for the '{@link rhea.metamodels.CompletedFM.Feature#isLeaf() <em>Is Leaf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Leaf</em>' operation.
	 * @see rhea.metamodels.CompletedFM.Feature#isLeaf()
	 * @generated
	 */
	EOperation getFeature__IsLeaf();

	/**
	 * Returns the meta object for the '{@link rhea.metamodels.CompletedFM.Feature#isRoot() <em>Is Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Root</em>' operation.
	 * @see rhea.metamodels.CompletedFM.Feature#isRoot()
	 * @generated
	 */
	EOperation getFeature__IsRoot();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Group</em>'.
	 * @see rhea.metamodels.CompletedFM.FeatureGroup
	 * @generated
	 */
	EClass getFeatureGroup();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.AlternativeGroup <em>Alternative Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Group</em>'.
	 * @see rhea.metamodels.CompletedFM.AlternativeGroup
	 * @generated
	 */
	EClass getAlternativeGroup();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Model</em>'.
	 * @see rhea.metamodels.CompletedFM.FeatureModel
	 * @generated
	 */
	EClass getFeatureModel();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.FeatureModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see rhea.metamodels.CompletedFM.FeatureModel#getName()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EAttribute getFeatureModel_Name();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.CompletedFM.FeatureModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see rhea.metamodels.CompletedFM.FeatureModel#getRoot()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Root();

	/**
	 * Returns the meta object for the reference list '{@link rhea.metamodels.CompletedFM.FeatureModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see rhea.metamodels.CompletedFM.FeatureModel#getFeatures()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link rhea.metamodels.CompletedFM.FeatureModel#getCrosstreeconstraints <em>Crosstreeconstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Crosstreeconstraints</em>'.
	 * @see rhea.metamodels.CompletedFM.FeatureModel#getCrosstreeconstraints()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Crosstreeconstraints();

	/**
	 * Returns the meta object for the '{@link rhea.metamodels.CompletedFM.FeatureModel#getFeature(java.lang.String) <em>Get Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Feature</em>' operation.
	 * @see rhea.metamodels.CompletedFM.FeatureModel#getFeature(java.lang.String)
	 * @generated
	 */
	EOperation getFeatureModel__GetFeature__String();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.SelectionGroup <em>Selection Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Group</em>'.
	 * @see rhea.metamodels.CompletedFM.SelectionGroup
	 * @generated
	 */
	EClass getSelectionGroup();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.CrossTreeConstraint <em>Cross Tree Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Tree Constraint</em>'.
	 * @see rhea.metamodels.CompletedFM.CrossTreeConstraint
	 * @generated
	 */
	EClass getCrossTreeConstraint();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.MutexGroup <em>Mutex Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutex Group</em>'.
	 * @see rhea.metamodels.CompletedFM.MutexGroup
	 * @generated
	 */
	EClass getMutexGroup();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.Multiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity</em>'.
	 * @see rhea.metamodels.CompletedFM.Multiplicity
	 * @generated
	 */
	EClass getMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.Multiplicity#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see rhea.metamodels.CompletedFM.Multiplicity#getLower()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_Lower();

	/**
	 * Returns the meta object for the attribute '{@link rhea.metamodels.CompletedFM.Multiplicity#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see rhea.metamodels.CompletedFM.Multiplicity#getUpper()
	 * @see #getMultiplicity()
	 * @generated
	 */
	EAttribute getMultiplicity_Upper();

	/**
	 * Returns the meta object for class '{@link rhea.metamodels.CompletedFM.GroupCardinality <em>Group Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Cardinality</em>'.
	 * @see rhea.metamodels.CompletedFM.GroupCardinality
	 * @generated
	 */
	EClass getGroupCardinality();

	/**
	 * Returns the meta object for the containment reference '{@link rhea.metamodels.CompletedFM.GroupCardinality#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Multiplicity</em>'.
	 * @see rhea.metamodels.CompletedFM.GroupCardinality#getMultiplicity()
	 * @see #getGroupCardinality()
	 * @generated
	 */
	EReference getGroupCardinality_Multiplicity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompletedFMFactory getCompletedFMFactory();

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
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.FeatureImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__MANDATORY = eINSTANCE.getFeature_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CHILDREN = eINSTANCE.getFeature_Children();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__PARENT = eINSTANCE.getFeature_Parent();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ABSTRACT = eINSTANCE.getFeature_Abstract();

		/**
		 * The meta object literal for the '<em><b>Is Leaf</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FEATURE___IS_LEAF = eINSTANCE.getFeature__IsLeaf();

		/**
		 * The meta object literal for the '<em><b>Is Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FEATURE___IS_ROOT = eINSTANCE.getFeature__IsRoot();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.FeatureGroupImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getFeatureGroup()
		 * @generated
		 */
		EClass FEATURE_GROUP = eINSTANCE.getFeatureGroup();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.AlternativeGroupImpl <em>Alternative Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.AlternativeGroupImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getAlternativeGroup()
		 * @generated
		 */
		EClass ALTERNATIVE_GROUP = eINSTANCE.getAlternativeGroup();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.FeatureModelImpl <em>Feature Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.FeatureModelImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getFeatureModel()
		 * @generated
		 */
		EClass FEATURE_MODEL = eINSTANCE.getFeatureModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_MODEL__NAME = eINSTANCE.getFeatureModel_Name();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__ROOT = eINSTANCE.getFeatureModel_Root();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__FEATURES = eINSTANCE.getFeatureModel_Features();

		/**
		 * The meta object literal for the '<em><b>Crosstreeconstraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_MODEL__CROSSTREECONSTRAINTS = eINSTANCE.getFeatureModel_Crosstreeconstraints();

		/**
		 * The meta object literal for the '<em><b>Get Feature</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FEATURE_MODEL___GET_FEATURE__STRING = eINSTANCE.getFeatureModel__GetFeature__String();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.SelectionGroupImpl <em>Selection Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.SelectionGroupImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getSelectionGroup()
		 * @generated
		 */
		EClass SELECTION_GROUP = eINSTANCE.getSelectionGroup();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.CrossTreeConstraintImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getCrossTreeConstraint()
		 * @generated
		 */
		EClass CROSS_TREE_CONSTRAINT = eINSTANCE.getCrossTreeConstraint();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.MutexGroupImpl <em>Mutex Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.MutexGroupImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getMutexGroup()
		 * @generated
		 */
		EClass MUTEX_GROUP = eINSTANCE.getMutexGroup();

		/**
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.MultiplicityImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getMultiplicity()
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
		 * The meta object literal for the '{@link rhea.metamodels.CompletedFM.impl.GroupCardinalityImpl <em>Group Cardinality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see rhea.metamodels.CompletedFM.impl.GroupCardinalityImpl
		 * @see rhea.metamodels.CompletedFM.impl.CompletedFMPackageImpl#getGroupCardinality()
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

	}

} //CompletedFMPackage
