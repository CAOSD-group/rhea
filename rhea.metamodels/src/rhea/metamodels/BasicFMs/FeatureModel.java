/**
 */
package rhea.metamodels.BasicFMs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.BasicFMs.FeatureModel#getName <em>Name</em>}</li>
 *   <li>{@link rhea.metamodels.BasicFMs.FeatureModel#getRoot <em>Root</em>}</li>
 *   <li>{@link rhea.metamodels.BasicFMs.FeatureModel#getFeatures <em>Features</em>}</li>
 *   <li>{@link rhea.metamodels.BasicFMs.FeatureModel#getCrosstreeconstraints <em>Crosstreeconstraints</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.BasicFMs.BasicFMsPackage#getFeatureModel()
 * @model
 * @generated
 */
public interface FeatureModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see rhea.metamodels.BasicFMs.BasicFMsPackage#getFeatureModel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link rhea.metamodels.BasicFMs.FeatureModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Feature)
	 * @see rhea.metamodels.BasicFMs.BasicFMsPackage#getFeatureModel_Root()
	 * @model containment="true"
	 * @generated
	 */
	Feature getRoot();

	/**
	 * Sets the value of the '{@link rhea.metamodels.BasicFMs.FeatureModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Feature value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link rhea.metamodels.BasicFMs.Feature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see rhea.metamodels.BasicFMs.BasicFMsPackage#getFeatureModel_Features()
	 * @model
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Crosstreeconstraints</b></em>' containment reference list.
	 * The list contents are of type {@link rhea.metamodels.BasicFMs.CrossTreeConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crosstreeconstraints</em>' containment reference list.
	 * @see rhea.metamodels.BasicFMs.BasicFMsPackage#getFeatureModel_Crosstreeconstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<CrossTreeConstraint> getCrosstreeconstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Feature getFeature(String id);
} // FeatureModel
