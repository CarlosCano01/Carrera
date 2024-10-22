/**
 */
package Asdm.tests;

import Asdm.AsdmFactory;
import Asdm.NodoFinal;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Nodo Final</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NodoFinalTest extends NodoTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodoFinalTest.class);
	}

	/**
	 * Constructs a new Nodo Final test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodoFinalTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Nodo Final test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NodoFinal getFixture() {
		return (NodoFinal)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AsdmFactory.eINSTANCE.createNodoFinal());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //NodoFinalTest
