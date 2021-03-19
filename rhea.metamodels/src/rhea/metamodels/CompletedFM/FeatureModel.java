/**
 */
package rhea.metamodels.CompletedFM;

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
 *   <li>{@link rhea.metamodels.CompletedFM.FeatureModel#getName <em>Name</em>}</li>
 *   <li>{@link rhea.metamodels.CompletedFM.FeatureModel#getRoot <em>Root</em>}</li>
 *   <li>{@link rhea.metamodels.CompletedFM.FeatureModel#getFeatures <em>Features</em>}</li>
 *   <li>{@link rhea.metamodels.CompletedFM.FeatureModel#getCrosstreeconstraints <em>Crosstreeconstraints</em>}</li>
 * </ul>
 *
 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getFeatureModel()
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
	 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getFeatureModel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link rhea.metamodels.CompletedFM.FeatureModel#getName <em>Name</em>}' attribute.
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
	 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getFeatureModel_Root()
	 * @model containment="true"
	 * @generated
	 */
	Feature getRoot();

	/**
	 * Sets the value of the '{@link rhea.metamodels.CompletedFM.FeatureModel#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Feature value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link rhea.metamodels.CompletedFM.Feature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getFeatureModel_Features()
	 * @model
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Crosstreeconstraints</b></em>' containment reference list.
	 * The list contents are of type {@link rhea.metamodels.CompletedFM.CrossTreeConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crosstreeconstraints</em>' containment reference list.
	 * @see rhea.metamodels.CompletedFM.CompletedFMPackage#getFeatureModel_Crosstreeconstraints()
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
