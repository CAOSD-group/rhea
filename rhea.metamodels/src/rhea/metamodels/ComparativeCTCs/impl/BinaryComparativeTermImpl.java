/**
 */
package rhea.metamodels.ComparativeCTCs.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
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
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected Term left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
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
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeft(Term newLeft, NotificationChain msgs) {
		Term oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT, oldLeft, newLeft);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeft(Term newLeft) {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT, newLeft, newLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Term getRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRight(Term newRight, NotificationChain msgs) {
		Term oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT, oldRight, newRight);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRight(Term newRight) {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT, newRight, newRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT:
				return basicSetLeft(null, msgs);
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT:
				return basicSetRight(null, msgs);
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
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__LEFT:
				return getLeft();
			case ComparativeCTCsPackage.BINARY_COMPARATIVE_TERM__RIGHT:
				return getRight();
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
