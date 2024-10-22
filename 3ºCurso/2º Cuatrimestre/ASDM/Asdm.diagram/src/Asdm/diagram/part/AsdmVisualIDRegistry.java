package Asdm.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class AsdmVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "Asdm.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID.equals(view.getType())) {
				return Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (Asdm.AsdmPackage.eINSTANCE.getDiagrama().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((Asdm.Diagrama) domainElement)) {
			return Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = Asdm.diagram.part.AsdmVisualIDRegistry.getModelID(containerView);
		if (!Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			if (Asdm.AsdmPackage.eINSTANCE.getActividad().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getDecision().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getRamificacion().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getNodoInicial().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getNodoFinal().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID;
			}
			break;
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID:
			if (Asdm.AsdmPackage.eINSTANCE.getActividad().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getDecision().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getRamificacion().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getNodoInicial().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getNodoFinal().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID;
			}
			break;
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID:
			if (Asdm.AsdmPackage.eINSTANCE.getActividad().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getDecision().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getRamificacion().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getNodoInicial().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID;
			}
			if (Asdm.AsdmPackage.eINSTANCE.getNodoFinal().isSuperTypeOf(domainElement.eClass())) {
				return Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = Asdm.diagram.part.AsdmVisualIDRegistry.getModelID(containerView);
		if (!Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			if (Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			if (Asdm.diagram.edit.parts.ActividadNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			if (Asdm.diagram.edit.parts.ActividadNombre2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID:
			if (Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID:
			if (Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			if (Asdm.diagram.edit.parts.AristaNombreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (Asdm.AsdmPackage.eINSTANCE.getArista().isSuperTypeOf(domainElement.eClass())) {
			return Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(Asdm.Diagrama element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			return false;
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		* @generated
		*/
		@Override

		public int getVisualID(View view) {
			return Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return Asdm.diagram.part.AsdmVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return Asdm.diagram.part.AsdmVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return Asdm.diagram.part.AsdmVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return Asdm.diagram.part.AsdmVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return Asdm.diagram.part.AsdmVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}
