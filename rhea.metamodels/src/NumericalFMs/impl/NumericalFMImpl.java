/**
 */
package NumericalFMs.impl;

import BasicFMs.impl.FeatureModelImpl;

import NumericalFMs.NumericalFM;
import NumericalFMs.NumericalFMsPackage;
import NumericalFMs.NumericalFeature;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical FM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link NumericalFMs.impl.NumericalFMImpl#getNumericalfeatures <em>Numericalfeatures</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericalFMImpl extends FeatureModelImpl implements NumericalFM {
	/**
	 * The cached value of the '{@link #getNumericalfeatures() <em>Numericalfeatures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericalfeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<NumericalFeature> numericalfeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericalFMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NumericalFMsPackage.Literals.NUMERICAL_FM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NumericalFeature> getNumericalfeatures() {
		if (numericalfeatures == null) {
			numericalfeatures = new EObjectResolvingEList<NumericalFeature>(NumericalFeature.class, this, NumericalFMsPackage.NUMERICAL_FM__NUMERICALFEATURES);
		}
		return numericalfeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NumericalFMsPackage.NUMERICAL_FM__NUMERICALFEATURES:
				return getNumericalfeatures();
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
			case NumericalFMsPackage.NUMERICAL_FM__NUMERICALFEATURES:
				getNumericalfeatures().clear();
				getNumericalfeatures().addAll((Collection<? extends NumericalFeature>)newValue);
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
			case NumericalFMsPackage.NUMERICAL_FM__NUMERICALFEATURES:
				getNumericalfeatures().clear();
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
			case NumericalFMsPackage.NUMERICAL_FM__NUMERICALFEATURES:
				return numericalfeatures != null && !numericalfeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NumericalFMImpl
