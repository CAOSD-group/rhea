/**
 */
package uma.caosd.rhea.metamodels.CardinalityBasedFMs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import uma.caosd.rhea.metamodels.BasicFMs.impl.FeatureGroupImpl;

import uma.caosd.rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsPackage;
import uma.caosd.rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import uma.caosd.rhea.metamodels.CardinalityBasedFMs.Multiplicity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Cardinality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uma.caosd.rhea.metamodels.CardinalityBasedFMs.impl.GroupCardinalityImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupCardinalityImpl extends FeatureGroupImpl implements GroupCardinality {
	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected Multiplicity multiplicity;

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
	public Multiplicity getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiplicity(Multiplicity newMultiplicity, NotificationChain msgs) {
		Multiplicity oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY, oldMultiplicity, newMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(Multiplicity newMultiplicity) {
		if (newMultiplicity != multiplicity) {
			NotificationChain msgs = null;
			if (multiplicity != null)
				msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
				return basicSetMultiplicity(null, msgs);
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CardinalityBasedFMsPackage.GROUP_CARDINALITY__MULTIPLICITY:
				setMultiplicity((Multiplicity)newValue);
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
				setMultiplicity((Multiplicity)null);
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
				return multiplicity != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupCardinalityImpl
