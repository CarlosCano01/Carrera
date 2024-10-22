/**
 */
package Asdm.impl;

import Asdm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AsdmFactoryImpl extends EFactoryImpl implements AsdmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AsdmFactory init() {
		try {
			AsdmFactory theAsdmFactory = (AsdmFactory)EPackage.Registry.INSTANCE.getEFactory(AsdmPackage.eNS_URI);
			if (theAsdmFactory != null) {
				return theAsdmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AsdmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsdmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AsdmPackage.DIAGRAMA: return createDiagrama();
			case AsdmPackage.ARISTA: return createArista();
			case AsdmPackage.ACTIVIDAD: return createActividad();
			case AsdmPackage.DECISION: return createDecision();
			case AsdmPackage.RAMIFICACION: return createRamificacion();
			case AsdmPackage.NODO_INICIAL: return createNodoInicial();
			case AsdmPackage.NODO_FINAL: return createNodoFinal();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagrama createDiagrama() {
		DiagramaImpl diagrama = new DiagramaImpl();
		return diagrama;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arista createArista() {
		AristaImpl arista = new AristaImpl();
		return arista;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actividad createActividad() {
		ActividadImpl actividad = new ActividadImpl();
		return actividad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decision createDecision() {
		DecisionImpl decision = new DecisionImpl();
		return decision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ramificacion createRamificacion() {
		RamificacionImpl ramificacion = new RamificacionImpl();
		return ramificacion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodoInicial createNodoInicial() {
		NodoInicialImpl nodoInicial = new NodoInicialImpl();
		return nodoInicial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodoFinal createNodoFinal() {
		NodoFinalImpl nodoFinal = new NodoFinalImpl();
		return nodoFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsdmPackage getAsdmPackage() {
		return (AsdmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AsdmPackage getPackage() {
		return AsdmPackage.eINSTANCE;
	}

} //AsdmFactoryImpl
