/**
 */
package uma.caosd.rhea.metamodels.M0;

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
 * @see uma.caosd.rhea.metamodels.M0.M0Factory
 * @model kind="package"
 * @generated
 */
public interface M0Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "M0";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "metamodels.M0";

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
	M0Package eINSTANCE = uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl.init();

	/**
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.M0.impl.FeatureModelImpl <em>Feature Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.M0.impl.FeatureModelImpl
	 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getFeatureModel()
	 * @generated
	 */
	int FEATURE_MODEL = 0;

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
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.M0.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.M0.impl.FeatureImpl
	 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

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
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 5;

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
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.M0.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.M0.impl.CrossTreeConstraintImpl
	 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getCrossTreeConstraint()
	 * @generated
	 */
	int CROSS_TREE_CONSTRAINT = 2;

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
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.M0.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.M0.impl.FeatureGroupImpl
	 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getFeatureGroup()
	 * @generated
	 */
	int FEATURE_GROUP = 3;

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
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.M0.impl.AlternativeGroupImpl <em>Alternative Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.M0.impl.AlternativeGroupImpl
	 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getAlternativeGroup()
	 * @generated
	 */
	int ALTERNATIVE_GROUP = 4;

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
	 * The meta object id for the '{@link uma.caosd.rhea.metamodels.M0.impl.SelectionGroupImpl <em>Selection Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uma.caosd.rhea.metamodels.M0.impl.SelectionGroupImpl
	 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getSelectionGroup()
	 * @generated
	 */
	int SELECTION_GROUP = 5;

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
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.M0.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Model</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureModel
	 * @generated
	 */
	EClass getFeatureModel();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.metamodels.M0.FeatureModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureModel#getName()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EAttribute getFeatureModel_Name();

	/**
	 * Returns the meta object for the containment reference '{@link uma.caosd.rhea.metamodels.M0.FeatureModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureModel#getRoot()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Root();

	/**
	 * Returns the meta object for the reference list '{@link uma.caosd.rhea.metamodels.M0.FeatureModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureModel#getFeatures()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link uma.caosd.rhea.metamodels.M0.FeatureModel#getCrosstreeconstraints <em>Crosstreeconstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Crosstreeconstraints</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureModel#getCrosstreeconstraints()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Crosstreeconstraints();

	/**
	 * Returns the meta object for the '{@link uma.caosd.rhea.metamodels.M0.FeatureModel#getFeature(java.lang.String) <em>Get Feature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Feature</em>' operation.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureModel#getFeature(java.lang.String)
	 * @generated
	 */
	EOperation getFeatureModel__GetFeature__String();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.M0.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.metamodels.M0.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.metamodels.M0.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link uma.caosd.rhea.metamodels.M0.Feature#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#isMandatory()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Mandatory();

	/**
	 * Returns the meta object for the containment reference list '{@link uma.caosd.rhea.metamodels.M0.Feature#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#getChildren()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Children();

	/**
	 * Returns the meta object for the container reference '{@link uma.caosd.rhea.metamodels.M0.Feature#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#getParent()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Parent();

	/**
	 * Returns the meta object for the '{@link uma.caosd.rhea.metamodels.M0.Feature#isLeaf() <em>Is Leaf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Leaf</em>' operation.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#isLeaf()
	 * @generated
	 */
	EOperation getFeature__IsLeaf();

	/**
	 * Returns the meta object for the '{@link uma.caosd.rhea.metamodels.M0.Feature#isRoot() <em>Is Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Root</em>' operation.
	 * @see uma.caosd.rhea.metamodels.M0.Feature#isRoot()
	 * @generated
	 */
	EOperation getFeature__IsRoot();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.M0.CrossTreeConstraint <em>Cross Tree Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Tree Constraint</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.CrossTreeConstraint
	 * @generated
	 */
	EClass getCrossTreeConstraint();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.M0.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Group</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.FeatureGroup
	 * @generated
	 */
	EClass getFeatureGroup();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.M0.AlternativeGroup <em>Alternative Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Group</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.AlternativeGroup
	 * @generated
	 */
	EClass getAlternativeGroup();

	/**
	 * Returns the meta object for class '{@link uma.caosd.rhea.metamodels.M0.SelectionGroup <em>Selection Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Group</em>'.
	 * @see uma.caosd.rhea.metamodels.M0.SelectionGroup
	 * @generated
	 */
	EClass getSelectionGroup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	M0Factory getM0Factory();

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
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.M0.impl.FeatureModelImpl <em>Feature Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.M0.impl.FeatureModelImpl
		 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getFeatureModel()
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
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.M0.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.M0.impl.FeatureImpl
		 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getFeature()
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
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.M0.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.M0.impl.CrossTreeConstraintImpl
		 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getCrossTreeConstraint()
		 * @generated
		 */
		EClass CROSS_TREE_CONSTRAINT = eINSTANCE.getCrossTreeConstraint();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.M0.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.M0.impl.FeatureGroupImpl
		 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getFeatureGroup()
		 * @generated
		 */
		EClass FEATURE_GROUP = eINSTANCE.getFeatureGroup();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.M0.impl.AlternativeGroupImpl <em>Alternative Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.M0.impl.AlternativeGroupImpl
		 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getAlternativeGroup()
		 * @generated
		 */
		EClass ALTERNATIVE_GROUP = eINSTANCE.getAlternativeGroup();

		/**
		 * The meta object literal for the '{@link uma.caosd.rhea.metamodels.M0.impl.SelectionGroupImpl <em>Selection Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uma.caosd.rhea.metamodels.M0.impl.SelectionGroupImpl
		 * @see uma.caosd.rhea.metamodels.M0.impl.M0PackageImpl#getSelectionGroup()
		 * @generated
		 */
		EClass SELECTION_GROUP = eINSTANCE.getSelectionGroup();

	}

} //M0Package
