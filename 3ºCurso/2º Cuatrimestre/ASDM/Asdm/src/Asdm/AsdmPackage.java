/**
 */
package Asdm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Asdm.AsdmFactory
 * @model kind="package"
 *        annotation="gmf foo='bar'"
 * @generated
 */
public interface AsdmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Asdm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Asdm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Asdm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AsdmPackage eINSTANCE = Asdm.impl.AsdmPackageImpl.init();

	/**
	 * The meta object id for the '{@link Asdm.impl.DiagramaImpl <em>Diagrama</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.DiagramaImpl
	 * @see Asdm.impl.AsdmPackageImpl#getDiagrama()
	 * @generated
	 */
	int DIAGRAMA = 0;

	/**
	 * The feature id for the '<em><b>Nodos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAMA__NODOS = 0;

	/**
	 * The feature id for the '<em><b>Aristas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAMA__ARISTAS = 1;

	/**
	 * The number of structural features of the '<em>Diagrama</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAMA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Asdm.impl.NodoImpl <em>Nodo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.NodoImpl
	 * @see Asdm.impl.AsdmPackageImpl#getNodo()
	 * @generated
	 */
	int NODO = 1;

	/**
	 * The feature id for the '<em><b>Salientes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO__SALIENTES = 0;

	/**
	 * The feature id for the '<em><b>Entrantes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO__ENTRANTES = 1;

	/**
	 * The number of structural features of the '<em>Nodo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link Asdm.impl.AristaImpl <em>Arista</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.AristaImpl
	 * @see Asdm.impl.AsdmPackageImpl#getArista()
	 * @generated
	 */
	int ARISTA = 2;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARISTA__NOMBRE = 0;

	/**
	 * The feature id for the '<em><b>Origen</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARISTA__ORIGEN = 1;

	/**
	 * The feature id for the '<em><b>Destino</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARISTA__DESTINO = 2;

	/**
	 * The number of structural features of the '<em>Arista</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARISTA_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link Asdm.impl.ActividadImpl <em>Actividad</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.ActividadImpl
	 * @see Asdm.impl.AsdmPackageImpl#getActividad()
	 * @generated
	 */
	int ACTIVIDAD = 3;

	/**
	 * The feature id for the '<em><b>Salientes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVIDAD__SALIENTES = NODO__SALIENTES;

	/**
	 * The feature id for the '<em><b>Entrantes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVIDAD__ENTRANTES = NODO__ENTRANTES;

	/**
	 * The feature id for the '<em><b>Nombre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVIDAD__NOMBRE = NODO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subdiag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVIDAD__SUBDIAG = NODO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Actividad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVIDAD_FEATURE_COUNT = NODO_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link Asdm.impl.DecisionImpl <em>Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.DecisionImpl
	 * @see Asdm.impl.AsdmPackageImpl#getDecision()
	 * @generated
	 */
	int DECISION = 4;

	/**
	 * The feature id for the '<em><b>Salientes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__SALIENTES = NODO__SALIENTES;

	/**
	 * The feature id for the '<em><b>Entrantes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__ENTRANTES = NODO__ENTRANTES;

	/**
	 * The number of structural features of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_FEATURE_COUNT = NODO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link Asdm.impl.RamificacionImpl <em>Ramificacion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.RamificacionImpl
	 * @see Asdm.impl.AsdmPackageImpl#getRamificacion()
	 * @generated
	 */
	int RAMIFICACION = 5;

	/**
	 * The feature id for the '<em><b>Salientes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMIFICACION__SALIENTES = NODO__SALIENTES;

	/**
	 * The feature id for the '<em><b>Entrantes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMIFICACION__ENTRANTES = NODO__ENTRANTES;

	/**
	 * The number of structural features of the '<em>Ramificacion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAMIFICACION_FEATURE_COUNT = NODO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link Asdm.impl.NodoInicialImpl <em>Nodo Inicial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.NodoInicialImpl
	 * @see Asdm.impl.AsdmPackageImpl#getNodoInicial()
	 * @generated
	 */
	int NODO_INICIAL = 6;

	/**
	 * The feature id for the '<em><b>Salientes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_INICIAL__SALIENTES = NODO__SALIENTES;

	/**
	 * The feature id for the '<em><b>Entrantes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_INICIAL__ENTRANTES = NODO__ENTRANTES;

	/**
	 * The number of structural features of the '<em>Nodo Inicial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_INICIAL_FEATURE_COUNT = NODO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link Asdm.impl.NodoFinalImpl <em>Nodo Final</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Asdm.impl.NodoFinalImpl
	 * @see Asdm.impl.AsdmPackageImpl#getNodoFinal()
	 * @generated
	 */
	int NODO_FINAL = 7;

	/**
	 * The feature id for the '<em><b>Salientes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_FINAL__SALIENTES = NODO__SALIENTES;

	/**
	 * The feature id for the '<em><b>Entrantes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_FINAL__ENTRANTES = NODO__ENTRANTES;

	/**
	 * The number of structural features of the '<em>Nodo Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODO_FINAL_FEATURE_COUNT = NODO_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link Asdm.Diagrama <em>Diagrama</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagrama</em>'.
	 * @see Asdm.Diagrama
	 * @generated
	 */
	EClass getDiagrama();

	/**
	 * Returns the meta object for the containment reference list '{@link Asdm.Diagrama#getNodos <em>Nodos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodos</em>'.
	 * @see Asdm.Diagrama#getNodos()
	 * @see #getDiagrama()
	 * @generated
	 */
	EReference getDiagrama_Nodos();

	/**
	 * Returns the meta object for the containment reference list '{@link Asdm.Diagrama#getAristas <em>Aristas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aristas</em>'.
	 * @see Asdm.Diagrama#getAristas()
	 * @see #getDiagrama()
	 * @generated
	 */
	EReference getDiagrama_Aristas();

	/**
	 * Returns the meta object for class '{@link Asdm.Nodo <em>Nodo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nodo</em>'.
	 * @see Asdm.Nodo
	 * @generated
	 */
	EClass getNodo();

	/**
	 * Returns the meta object for the reference list '{@link Asdm.Nodo#getSalientes <em>Salientes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Salientes</em>'.
	 * @see Asdm.Nodo#getSalientes()
	 * @see #getNodo()
	 * @generated
	 */
	EReference getNodo_Salientes();

	/**
	 * Returns the meta object for the reference list '{@link Asdm.Nodo#getEntrantes <em>Entrantes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entrantes</em>'.
	 * @see Asdm.Nodo#getEntrantes()
	 * @see #getNodo()
	 * @generated
	 */
	EReference getNodo_Entrantes();

	/**
	 * Returns the meta object for class '{@link Asdm.Arista <em>Arista</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arista</em>'.
	 * @see Asdm.Arista
	 * @generated
	 */
	EClass getArista();

	/**
	 * Returns the meta object for the attribute '{@link Asdm.Arista#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see Asdm.Arista#getNombre()
	 * @see #getArista()
	 * @generated
	 */
	EAttribute getArista_Nombre();

	/**
	 * Returns the meta object for the reference '{@link Asdm.Arista#getOrigen <em>Origen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origen</em>'.
	 * @see Asdm.Arista#getOrigen()
	 * @see #getArista()
	 * @generated
	 */
	EReference getArista_Origen();

	/**
	 * Returns the meta object for the reference '{@link Asdm.Arista#getDestino <em>Destino</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destino</em>'.
	 * @see Asdm.Arista#getDestino()
	 * @see #getArista()
	 * @generated
	 */
	EReference getArista_Destino();

	/**
	 * Returns the meta object for class '{@link Asdm.Actividad <em>Actividad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actividad</em>'.
	 * @see Asdm.Actividad
	 * @generated
	 */
	EClass getActividad();

	/**
	 * Returns the meta object for the attribute '{@link Asdm.Actividad#getNombre <em>Nombre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nombre</em>'.
	 * @see Asdm.Actividad#getNombre()
	 * @see #getActividad()
	 * @generated
	 */
	EAttribute getActividad_Nombre();

	/**
	 * Returns the meta object for the containment reference list '{@link Asdm.Actividad#getSubdiag <em>Subdiag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subdiag</em>'.
	 * @see Asdm.Actividad#getSubdiag()
	 * @see #getActividad()
	 * @generated
	 */
	EReference getActividad_Subdiag();

	/**
	 * Returns the meta object for class '{@link Asdm.Decision <em>Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision</em>'.
	 * @see Asdm.Decision
	 * @generated
	 */
	EClass getDecision();

	/**
	 * Returns the meta object for class '{@link Asdm.Ramificacion <em>Ramificacion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ramificacion</em>'.
	 * @see Asdm.Ramificacion
	 * @generated
	 */
	EClass getRamificacion();

	/**
	 * Returns the meta object for class '{@link Asdm.NodoInicial <em>Nodo Inicial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nodo Inicial</em>'.
	 * @see Asdm.NodoInicial
	 * @generated
	 */
	EClass getNodoInicial();

	/**
	 * Returns the meta object for class '{@link Asdm.NodoFinal <em>Nodo Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nodo Final</em>'.
	 * @see Asdm.NodoFinal
	 * @generated
	 */
	EClass getNodoFinal();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AsdmFactory getAsdmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Asdm.impl.DiagramaImpl <em>Diagrama</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.DiagramaImpl
		 * @see Asdm.impl.AsdmPackageImpl#getDiagrama()
		 * @generated
		 */
		EClass DIAGRAMA = eINSTANCE.getDiagrama();

		/**
		 * The meta object literal for the '<em><b>Nodos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAMA__NODOS = eINSTANCE.getDiagrama_Nodos();

		/**
		 * The meta object literal for the '<em><b>Aristas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAMA__ARISTAS = eINSTANCE.getDiagrama_Aristas();

		/**
		 * The meta object literal for the '{@link Asdm.impl.NodoImpl <em>Nodo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.NodoImpl
		 * @see Asdm.impl.AsdmPackageImpl#getNodo()
		 * @generated
		 */
		EClass NODO = eINSTANCE.getNodo();

		/**
		 * The meta object literal for the '<em><b>Salientes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODO__SALIENTES = eINSTANCE.getNodo_Salientes();

		/**
		 * The meta object literal for the '<em><b>Entrantes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODO__ENTRANTES = eINSTANCE.getNodo_Entrantes();

		/**
		 * The meta object literal for the '{@link Asdm.impl.AristaImpl <em>Arista</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.AristaImpl
		 * @see Asdm.impl.AsdmPackageImpl#getArista()
		 * @generated
		 */
		EClass ARISTA = eINSTANCE.getArista();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARISTA__NOMBRE = eINSTANCE.getArista_Nombre();

		/**
		 * The meta object literal for the '<em><b>Origen</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARISTA__ORIGEN = eINSTANCE.getArista_Origen();

		/**
		 * The meta object literal for the '<em><b>Destino</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARISTA__DESTINO = eINSTANCE.getArista_Destino();

		/**
		 * The meta object literal for the '{@link Asdm.impl.ActividadImpl <em>Actividad</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.ActividadImpl
		 * @see Asdm.impl.AsdmPackageImpl#getActividad()
		 * @generated
		 */
		EClass ACTIVIDAD = eINSTANCE.getActividad();

		/**
		 * The meta object literal for the '<em><b>Nombre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVIDAD__NOMBRE = eINSTANCE.getActividad_Nombre();

		/**
		 * The meta object literal for the '<em><b>Subdiag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVIDAD__SUBDIAG = eINSTANCE.getActividad_Subdiag();

		/**
		 * The meta object literal for the '{@link Asdm.impl.DecisionImpl <em>Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.DecisionImpl
		 * @see Asdm.impl.AsdmPackageImpl#getDecision()
		 * @generated
		 */
		EClass DECISION = eINSTANCE.getDecision();

		/**
		 * The meta object literal for the '{@link Asdm.impl.RamificacionImpl <em>Ramificacion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.RamificacionImpl
		 * @see Asdm.impl.AsdmPackageImpl#getRamificacion()
		 * @generated
		 */
		EClass RAMIFICACION = eINSTANCE.getRamificacion();

		/**
		 * The meta object literal for the '{@link Asdm.impl.NodoInicialImpl <em>Nodo Inicial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.NodoInicialImpl
		 * @see Asdm.impl.AsdmPackageImpl#getNodoInicial()
		 * @generated
		 */
		EClass NODO_INICIAL = eINSTANCE.getNodoInicial();

		/**
		 * The meta object literal for the '{@link Asdm.impl.NodoFinalImpl <em>Nodo Final</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Asdm.impl.NodoFinalImpl
		 * @see Asdm.impl.AsdmPackageImpl#getNodoFinal()
		 * @generated
		 */
		EClass NODO_FINAL = eINSTANCE.getNodoFinal();

	}

} //AsdmPackage
