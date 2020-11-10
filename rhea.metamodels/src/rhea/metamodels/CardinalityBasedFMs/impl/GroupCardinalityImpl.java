/**
 */
package rhea.metamodels.CardinalityBasedFMs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rhea.metamodels.BasicFMs.impl.FeatureGroupImpl;

import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Cardinality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupCardinalityImpl extends FeatureGroupImpl implements GroupCardinality {
	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected EList<Multiplicity> multiplicity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupCardinalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CardinalityBasedFMsPackage.Literals.GROUP_CARDINALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Multiplicity> getMultiplicity() {
		if (multiplicity == null) {
			multiplicity = new EObjectContainmentEList<Multiplicity>(Multiplicity.class, this, CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY);
		}
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY:
				return ((InternalEList<?>)getMultiplicity()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY:
				return getMultiplicity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY:
				getMultiplicity().clear();
				getMultiplicity().addAll((Collection<? extends Multiplicity>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY:
				getMultiplicity().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY:
				return multiplicity != null && !multiplicity.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GroupCardinalityImpl
