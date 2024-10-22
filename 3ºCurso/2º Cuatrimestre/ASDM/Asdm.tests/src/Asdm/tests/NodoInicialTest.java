/**
 */
package Asdm.tests;

import Asdm.AsdmFactory;
import Asdm.NodoInicial;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Nodo Inicial</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NodoInicialTest extends NodoTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodoInicialTest.class);
	}

	/**
	 * Constructs a new Nodo Inicial test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodoInicialTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Nodo Inicial test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NodoInicial getFixture() {
		return (NodoInicial)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AsdmFactory.eINSTANCE.createNodoInicial());
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

} //NodoInicialTest
