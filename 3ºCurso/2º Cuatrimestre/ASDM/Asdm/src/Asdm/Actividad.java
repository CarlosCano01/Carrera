/**
 */
package Asdm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actividad</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Asdm.Actividad#getNombre <em>Nombre</em>}</li>
 *   <li>{@link Asdm.Actividad#getSubdiag <em>Subdiag</em>}</li>
 * </ul>
 *
 * @see Asdm.AsdmPackage#getActividad()
 * @model annotation="gmf.node label='nombre' label.icon='false' tool.description='A\361ade una actividad, que puede contener subactividades'"
 * @generated
 */
public interface Actividad extends Nodo {
	/**
	 * Returns the value of the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nombre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nombre</em>' attribute.
	 * @see #setNombre(String)
	 * @see Asdm.AsdmPackage#getActividad_Nombre()
	 * @model
	 * @generated
	 */
	String getNombre();

	/**
	 * Sets the value of the '{@link Asdm.Actividad#getNombre <em>Nombre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nombre</em>' attribute.
	 * @see #getNombre()
	 * @generated
	 */
	void setNombre(String value);

	/**
	 * Returns the value of the '<em><b>Subdiag</b></em>' containment reference list.
	 * The list contents are of type {@link Asdm.Nodo}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subdiag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subdiag</em>' containment reference list.
	 * @see Asdm.AsdmPackage#getActividad_Subdiag()
	 * @model containment="true"
	 *        annotation="gmf.compartment foo='bar'"
	 * @generated
	 */
	EList<Nodo> getSubdiag();

} // Actividad
