/**
 */
package Asdm.tests;

import Asdm.AsdmFactory;
import Asdm.Ramificacion;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ramificacion</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RamificacionTest extends NodoTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RamificacionTest.class);
	}

	/**
	 * Constructs a new Ramificacion test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RamificacionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Ramificacion test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Ramificacion getFixture() {
		return (Ramificacion)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AsdmFactory.eINSTANCE.createRamificacion());
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

} //RamificacionTest
