/**
 */
package Asdm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nodo</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Asdm.Nodo#getSalientes <em>Salientes</em>}</li>
 *   <li>{@link Asdm.Nodo#getEntrantes <em>Entrantes</em>}</li>
 * </ul>
 *
 * @see Asdm.AsdmPackage#getNodo()
 * @model abstract="true"
 * @generated
 */
public interface Nodo extends EObject {
	/**
	 * Returns the value of the '<em><b>Salientes</b></em>' reference list.
	 * The list contents are of type {@link Asdm.Arista}.
	 * It is bidirectional and its opposite is '{@link Asdm.Arista#getOrigen <em>Origen</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salientes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salientes</em>' reference list.
	 * @see Asdm.AsdmPackage#getNodo_Salientes()
	 * @see Asdm.Arista#getOrigen
	 * @model opposite="origen"
	 * @generated
	 */
	EList<Arista> getSalientes();

	/**
	 * Returns the value of the '<em><b>Entrantes</b></em>' reference list.
	 * The list contents are of type {@link Asdm.Arista}.
	 * It is bidirectional and its opposite is '{@link Asdm.Arista#getDestino <em>Destino</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entrantes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entrantes</em>' reference list.
	 * @see Asdm.AsdmPackage#getNodo_Entrantes()
	 * @see Asdm.Arista#getDestino
	 * @model opposite="destino"
	 * @generated
	 */
	EList<Arista> getEntrantes();

} // Nodo
