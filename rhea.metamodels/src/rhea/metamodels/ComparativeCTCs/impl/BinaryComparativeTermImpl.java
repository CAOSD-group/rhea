/**
 */
package rhea.metamodels.ComparativeCTCs.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rhea.metamodels.ComparativeCTCs.BinaryComparativeTerm;
import rhea.metamodels.ComparativeCTCs.ComparativeCTCsPackage;

import rhea.metamodels.PropLogicCTCs.Term;

import rhea.metamodels.PropLogicCTCs.impl.TermImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Comparative Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link rhea.metamodels.ComparativeCTCs.impl.BinaryComparativeTermImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link rhea.metamodels.ComparativeCTCs.impl.BinaryComparativeTermImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryComparativeTermImpl extends TermImpl implements BinaryComparativeTerm {
	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected Term left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected Term right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryComparativeTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComparativeCTCsPackage.Literals.BINARY_COMPARATIVE_TERM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term getLeft() {
		if (left != null && left.eIsProxy()) {
			InternalEObject oldLeft = (InternalEObject)left;
			left = (Term)eResolveProxy(oldLeft);
			if (left != oldLeft) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT, oldLeft, left));
			}
		}
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term basicGetLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeft(Term newLeft) {
		Term oldLeft = left;
		left = newLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT, oldLeft, left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term getRight() {
		if (right != null && right.eIsProxy()) {
			InternalEObject oldRight = (InternalEObject)right;
			right = (Term)eResolveProxy(oldRight);
			if (right != oldRight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT, oldRight, right));
			}
		}
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Term basicGetRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRight(Term newRight) {
		Term oldRight = right;
		right = newRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT:
				if (resolve) return getLeft();
				return basicGetLeft();
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT:
				if (resolve) return getRight();
				return basicGetRight();
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
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT:
				setLeft((Term)newValue);
				return;
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT:
				setRight((Term)newValue);
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
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT:
				setLeft((Term)null);
				return;
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT:
				setRight((Term)null);
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
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT:
				return left != null;
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT:
				return right != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryComparativeTermImpl
