/**
 */
package Asdm.impl;

import Asdm.Actividad;
import Asdm.Arista;
import Asdm.AsdmFactory;
import Asdm.AsdmPackage;
import Asdm.Decision;
import Asdm.Diagrama;
import Asdm.Nodo;
import Asdm.NodoFinal;
import Asdm.NodoInicial;
import Asdm.Ramificacion;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AsdmPackageImpl extends EPackageImpl implements AsdmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aristaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actividadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ramificacionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodoInicialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodoFinalEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see Asdm.AsdmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AsdmPackageImpl() {
		super(eNS_URI, AsdmFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AsdmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AsdmPackage init() {
		if (isInited) return (AsdmPackage)EPackage.Registry.INSTANCE.getEPackage(AsdmPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAsdmPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AsdmPackageImpl theAsdmPackage = registeredAsdmPackage instanceof AsdmPackageImpl ? (AsdmPackageImpl)registeredAsdmPackage : new AsdmPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theAsdmPackage.createPackageContents();

		// Initialize created meta-data
		theAsdmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAsdmPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AsdmPackage.eNS_URI, theAsdmPackage);
		return theAsdmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagrama() {
		return diagramaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagrama_Nodos() {
		return (EReference)diagramaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagrama_Aristas() {
		return (EReference)diagramaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodo() {
		return nodoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodo_Salientes() {
		return (EReference)nodoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodo_Entrantes() {
		return (EReference)nodoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArista() {
		return aristaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArista_Nombre() {
		return (EAttribute)aristaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArista_Origen() {
		return (EReference)aristaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArista_Destino() {
		return (EReference)aristaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActividad() {
		return actividadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActividad_Nombre() {
		return (EAttribute)actividadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActividad_Subdiag() {
		return (EReference)actividadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecision() {
		return decisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRamificacion() {
		return ramificacionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodoInicial() {
		return nodoInicialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodoFinal() {
		return nodoFinalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsdmFactory getAsdmFactory() {
		return (AsdmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		diagramaEClass = createEClass(DIAGRAMA);
		createEReference(diagramaEClass, DIAGRAMA__NODOS);
		createEReference(diagramaEClass, DIAGRAMA__ARISTAS);

		nodoEClass = createEClass(NODO);
		createEReference(nodoEClass, NODO__SALIENTES);
		createEReference(nodoEClass, NODO__ENTRANTES);

		aristaEClass = createEClass(ARISTA);
		createEAttribute(aristaEClass, ARISTA__NOMBRE);
		createEReference(aristaEClass, ARISTA__ORIGEN);
		createEReference(aristaEClass, ARISTA__DESTINO);

		actividadEClass = createEClass(ACTIVIDAD);
		createEAttribute(actividadEClass, ACTIVIDAD__NOMBRE);
		createEReference(actividadEClass, ACTIVIDAD__SUBDIAG);

		decisionEClass = createEClass(DECISION);

		ramificacionEClass = createEClass(RAMIFICACION);

		nodoInicialEClass = createEClass(NODO_INICIAL);

		nodoFinalEClass = createEClass(NODO_FINAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actividadEClass.getESuperTypes().add(this.getNodo());
		decisionEClass.getESuperTypes().add(this.getNodo());
		ramificacionEClass.getESuperTypes().add(this.getNodo());
		nodoInicialEClass.getESuperTypes().add(this.getNodo());
		nodoFinalEClass.getESuperTypes().add(this.getNodo());

		// Initialize classes and features; add operations and parameters
		initEClass(diagramaEClass, Diagrama.class, "Diagrama", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagrama_Nodos(), this.getNodo(), null, "nodos", null, 0, -1, Diagrama.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagrama_Aristas(), this.getArista(), null, "aristas", null, 0, -1, Diagrama.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodoEClass, Nodo.class, "Nodo", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodo_Salientes(), this.getArista(), this.getArista_Origen(), "salientes", null, 0, -1, Nodo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodo_Entrantes(), this.getArista(), this.getArista_Destino(), "entrantes", null, 0, -1, Nodo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aristaEClass, Arista.class, "Arista", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArista_Nombre(), ecorePackage.getEString(), "nombre", null, 0, 1, Arista.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArista_Origen(), this.getNodo(), this.getNodo_Salientes(), "origen", null, 1, 1, Arista.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArista_Destino(), this.getNodo(), this.getNodo_Entrantes(), "destino", null, 1, 1, Arista.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actividadEClass, Actividad.class, "Actividad", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActividad_Nombre(), ecorePackage.getEString(), "nombre", null, 0, 1, Actividad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActividad_Subdiag(), this.getNodo(), null, "subdiag", null, 0, -1, Actividad.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decisionEClass, Decision.class, "Decision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ramificacionEClass, Ramificacion.class, "Ramificacion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodoInicialEClass, NodoInicial.class, "NodoInicial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodoFinalEClass, NodoFinal.class, "NodoFinal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf
		createGmfAnnotations();
		// gmf.diagram
		createGmf_1Annotations();
		// gmf.link
		createGmf_2Annotations();
		// gmf.node
		createGmf_3Annotations();
		// gmf.compartment
		createGmf_4Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "foo", "bar"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.diagram";
		addAnnotation
		  (diagramaEClass,
		   source,
		   new String[] {
			   "foo", "bar"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.link";
		addAnnotation
		  (aristaEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "source", "origen",
			   "target", "destino",
			   "target.decoration", "arrow",
			   "tool.description", "A\u00f1ade una arista entre dos nodos"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.node";
		addAnnotation
		  (actividadEClass,
		   source,
		   new String[] {
			   "label", "nombre",
			   "label.icon", "false",
			   "tool.description", "A\u00f1ade una actividad, que puede contener subactividades"
		   });
		addAnnotation
		  (decisionEClass,
		   source,
		   new String[] {
			   "label.placement", "none",
			   "figure", "polygon",
			   "polygon.x", "20 40 20  0",
			   "polygon.y", " 0 20 40 20",
			   "tool.name", "Decisi\u00f3n",
			   "tool.description", "A\u00f1ade un nodo de decisi\u00f3n entre varias ramas excluyentes"
		   });
		addAnnotation
		  (ramificacionEClass,
		   source,
		   new String[] {
			   "label.placement", "none",
			   "figure", "polygon",
			   "color", "0,0,0",
			   "size", "10,40",
			   "polygon.x", "0 10 10  0",
			   "polygon.y", "0  0 40 40",
			   "tool.name", "Ramificaci\u00f3n",
			   "tool.description", "A\u00f1ade un nodo que ramifica la ejecuci\u00f3n a varias ramas paralelas"
		   });
		addAnnotation
		  (nodoInicialEClass,
		   source,
		   new String[] {
			   "label.placement", "none",
			   "figure", "svg",
			   "svg.uri", "platform:/plugin/dsdm.eugenia/iconos/nodo-inicial.svg",
			   "tool.name", "Nodo inicial",
			   "tool.description", "A\u00f1ade un nodo por el que comienza la ejecuci\u00f3n de las actividades o subactividades"
		   });
		addAnnotation
		  (nodoFinalEClass,
		   source,
		   new String[] {
			   "label.placement", "none",
			   "figure", "svg",
			   "svg.uri", "platform:/plugin/dsdm.eugenia/iconos/nodo-final.svg",
			   "tool.name", "Nodo final",
			   "tool.description", "A\u00f1ade un nodo por el que termina la ejecuci\u00f3n de las actividades o subactividades"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_4Annotations() {
		String source = "gmf.compartment";
		addAnnotation
		  (getActividad_Subdiag(),
		   source,
		   new String[] {
			   "foo", "bar"
		   });
	}

} //AsdmPackageImpl
