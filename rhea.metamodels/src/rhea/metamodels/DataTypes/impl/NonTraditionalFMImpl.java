/**
 */
package rhea.metamodels.DataTypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import rhea.metamodels.BasicFMs.impl.FeatureModelImpl;

import rhea.metamodels.DataTypes.DataTypesPackage;
import rhea.metamodels.DataTypes.NonTraditionalFM;
import rhea.metamodels.DataTypes.TypedFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Traditional FM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.DataTypes.impl.NonTraditionalFMImpl#getTypedfeatures <em>Typedfeatures</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NonTraditionalFMImpl extends FeatureModelImpl implements NonTraditionalFM {
	/**
	 * The cached value of the '{@link #getTypedfeatures() <em>Typedfeatures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedfeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedFeature> typedfeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonTraditionalFMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataTypesPackage.Literals.NON_TRADITIONAL_FM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedFeature> getTypedfeatures() {
		if (typedfeatures == null) {
			typedfeatures = new EObjectResolvingEList<TypedFeature>(TypedFeature.class, this, DataTypesPackage.NON_TRADITIONAL_FM__TYPEDFEATURES);
		}
		return typedfeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypesPackage.NON_TRADITIONAL_FM__TYPEDFEATURES:
				return getTypedfeatures();
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
			case DataTypesPackage.NON_TRADITIONAL_FM__TYPEDFEATURES:
				getTypedfeatures().clear();
				getTypedfeatures().addAll((Collection<? extends TypedFeature>)newValue);
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
			case DataTypesPackage.NON_TRADITIONAL_FM__TYPEDFEATURES:
				getTypedfeatures().clear();
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
			case DataTypesPackage.NON_TRADITIONAL_FM__TYPEDFEATURES:
				return typedfeatures != null && !typedfeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NonTraditionalFMImpl
