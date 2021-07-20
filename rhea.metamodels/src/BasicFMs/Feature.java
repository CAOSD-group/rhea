/**
 */
package BasicFMs;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link BasicFMs.Feature#getId <em>Id</em>}</li>
 *   <li>{@link BasicFMs.Feature#getName <em>Name</em>}</li>
 *   <li>{@link BasicFMs.Feature#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link BasicFMs.Feature#getChildren <em>Children</em>}</li>
 *   <li>{@link BasicFMs.Feature#getParent <em>Parent</em>}</li>
 *   <li>{@link BasicFMs.Feature#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see BasicFMs.BasicFMsPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see BasicFMs.BasicFMsPackage#getFeature_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link BasicFMs.Feature#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see BasicFMs.BasicFMsPackage#getFeature_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link BasicFMs.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(boolean)
	 * @see BasicFMs.BasicFMsPackage#getFeature_Mandatory()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMandatory();

	/**
	 * Sets the value of the '{@link BasicFMs.Feature#isMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #isMandatory()
	 * @generated
	 */
	void setMandatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link BasicFMs.Feature}.
	 * It is bidirectional and its opposite is '{@link BasicFMs.Feature#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see BasicFMs.BasicFMsPackage#getFeature_Children()
	 * @see BasicFMs.Feature#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	List<rhea.metamodels.BasicFMs.Feature> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link BasicFMs.Feature#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Feature)
	 * @see BasicFMs.BasicFMsPackage#getFeature_Parent()
	 * @see BasicFMs.Feature#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Feature getParent();

	/**
	 * Sets the value of the '{@link BasicFMs.Feature#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Feature value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see BasicFMs.BasicFMsPackage#getFeature_Abstract()
	 * @model default="false"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link BasicFMs.Feature#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isRoot();

} // Feature
