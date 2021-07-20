/**
 */
package BasicFMs;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see BasicFMs.BasicFMsFactory
 * @model kind="package"
 * @generated
 */
public interface BasicFMsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BasicFMs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "rhea.metamodels.BasicFMs";

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
	BasicFMsPackage eINSTANCE = BasicFMs.impl.BasicFMsPackageImpl.init();

	/**
	 * The meta object id for the '{@link BasicFMs.impl.FeatureModelImpl <em>Feature Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see BasicFMs.impl.FeatureModelImpl
	 * @see BasicFMs.impl.BasicFMsPackageImpl#getFeatureModel()
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
	 * The meta object id for the '{@link BasicFMs.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see BasicFMs.impl.FeatureImpl
	 * @see BasicFMs.impl.BasicFMsPackageImpl#getFeature()
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
	 * The meta object id for the '{@link BasicFMs.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see BasicFMs.impl.CrossTreeConstraintImpl
	 * @see BasicFMs.impl.BasicFMsPackageImpl#getCrossTreeConstraint()
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
	 * The meta object id for the '{@link BasicFMs.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see BasicFMs.impl.FeatureGroupImpl
	 * @see BasicFMs.impl.BasicFMsPackageImpl#getFeatureGroup()
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
	 * The meta object id for the '{@link BasicFMs.impl.AlternativeGroupImpl <em>Alternative Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see BasicFMs.impl.AlternativeGroupImpl
	 * @see BasicFMs.impl.BasicFMsPackageImpl#getAlternativeGroup()
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
	 * The meta object id for the '{@link BasicFMs.impl.SelectionGroupImpl <em>Selection Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see BasicFMs.impl.SelectionGroupImpl
	 * @see BasicFMs.impl.BasicFMsPackageImpl#getSelectionGroup()
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
	 * Returns the meta object for class '{@link BasicFMs.FeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Model</em>'.
	 * @see BasicFMs.FeatureModel
	 * @generated
	 */
	EClass getFeatureModel();

	/**
	 * Returns the meta object for the attribute '{@link BasicFMs.FeatureModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see BasicFMs.FeatureModel#getName()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EAttribute getFeatureModel_Name();

	/**
	 * Returns the meta object for the containment reference '{@link BasicFMs.FeatureModel#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see BasicFMs.FeatureModel#getRoot()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Root();

	/**
	 * Returns the meta object for the reference list '{@link BasicFMs.FeatureModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see BasicFMs.FeatureModel#getFeatures()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link BasicFMs.FeatureModel#getCrosstreeconstraints <em>Crosstreeconstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Crosstreeconstraints</em>'.
	 * @see BasicFMs.FeatureModel#getCrosstreeconstraints()
	 * @see #getFeatureModel()
	 * @generated
	 */
	EReference getFeatureModel_Crosstreeconstraints();

	/**
	 * Returns the meta object for class '{@link BasicFMs.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see BasicFMs.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link BasicFMs.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see BasicFMs.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link BasicFMs.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see BasicFMs.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link BasicFMs.Feature#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see BasicFMs.Feature#isMandatory()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Mandatory();

	/**
	 * Returns the meta object for the containment reference list '{@link BasicFMs.Feature#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see BasicFMs.Feature#getChildren()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Children();

	/**
	 * Returns the meta object for the container reference '{@link BasicFMs.Feature#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see BasicFMs.Feature#getParent()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Parent();

	/**
	 * Returns the meta object for the attribute '{@link BasicFMs.Feature#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see BasicFMs.Feature#isAbstract()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Abstract();

	/**
	 * Returns the meta object for class '{@link BasicFMs.CrossTreeConstraint <em>Cross Tree Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Tree Constraint</em>'.
	 * @see BasicFMs.CrossTreeConstraint
	 * @generated
	 */
	EClass getCrossTreeConstraint();

	/**
	 * Returns the meta object for class '{@link BasicFMs.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Group</em>'.
	 * @see BasicFMs.FeatureGroup
	 * @generated
	 */
	EClass getFeatureGroup();

	/**
	 * Returns the meta object for class '{@link BasicFMs.AlternativeGroup <em>Alternative Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Group</em>'.
	 * @see BasicFMs.AlternativeGroup
	 * @generated
	 */
	EClass getAlternativeGroup();

	/**
	 * Returns the meta object for class '{@link BasicFMs.SelectionGroup <em>Selection Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Group</em>'.
	 * @see BasicFMs.SelectionGroup
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
	BasicFMsFactory getBasicFMsFactory();

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
		 * The meta object literal for the '{@link BasicFMs.impl.FeatureModelImpl <em>Feature Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see BasicFMs.impl.FeatureModelImpl
		 * @see BasicFMs.impl.BasicFMsPackageImpl#getFeatureModel()
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
		 * The meta object literal for the '{@link BasicFMs.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see BasicFMs.impl.FeatureImpl
		 * @see BasicFMs.impl.BasicFMsPackageImpl#getFeature()
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
		 * The meta object literal for the '{@link BasicFMs.impl.CrossTreeConstraintImpl <em>Cross Tree Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see BasicFMs.impl.CrossTreeConstraintImpl
		 * @see BasicFMs.impl.BasicFMsPackageImpl#getCrossTreeConstraint()
		 * @generated
		 */
		EClass CROSS_TREE_CONSTRAINT = eINSTANCE.getCrossTreeConstraint();

		/**
		 * The meta object literal for the '{@link BasicFMs.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see BasicFMs.impl.FeatureGroupImpl
		 * @see BasicFMs.impl.BasicFMsPackageImpl#getFeatureGroup()
		 * @generated
		 */
		EClass FEATURE_GROUP = eINSTANCE.getFeatureGroup();

		/**
		 * The meta object literal for the '{@link BasicFMs.impl.AlternativeGroupImpl <em>Alternative Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see BasicFMs.impl.AlternativeGroupImpl
		 * @see BasicFMs.impl.BasicFMsPackageImpl#getAlternativeGroup()
		 * @generated
		 */
		EClass ALTERNATIVE_GROUP = eINSTANCE.getAlternativeGroup();

		/**
		 * The meta object literal for the '{@link BasicFMs.impl.SelectionGroupImpl <em>Selection Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see BasicFMs.impl.SelectionGroupImpl
		 * @see BasicFMs.impl.BasicFMsPackageImpl#getSelectionGroup()
		 * @generated
		 */
		EClass SELECTION_GROUP = eINSTANCE.getSelectionGroup();

	}

} //BasicFMsPackage
