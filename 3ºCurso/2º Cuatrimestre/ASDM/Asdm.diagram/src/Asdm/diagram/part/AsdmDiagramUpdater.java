package Asdm.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class AsdmDiagramUpdater {

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmNodeDescriptor> getSemanticChildren(View view) {
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			return getDiagrama_1000SemanticChildren(view);
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID:
			return getActividadActividadSubdiagCompartment_7001SemanticChildren(view);
		case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID:
			return getActividadActividadSubdiagCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmNodeDescriptor> getDiagrama_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Asdm.Diagrama modelElement = (Asdm.Diagrama) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmNodeDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodos().iterator(); it.hasNext();) {
			Asdm.Nodo childElement = (Asdm.Nodo) it.next();
			int visualID = Asdm.diagram.part.AsdmVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmNodeDescriptor> getActividadActividadSubdiagCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Asdm.Actividad modelElement = (Asdm.Actividad) containerView.getElement();
		LinkedList<Asdm.diagram.part.AsdmNodeDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSubdiag().iterator(); it.hasNext();) {
			Asdm.Nodo childElement = (Asdm.Nodo) it.next();
			int visualID = Asdm.diagram.part.AsdmVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmNodeDescriptor> getActividadActividadSubdiagCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Asdm.Actividad modelElement = (Asdm.Actividad) containerView.getElement();
		LinkedList<Asdm.diagram.part.AsdmNodeDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSubdiag().iterator(); it.hasNext();) {
			Asdm.Nodo childElement = (Asdm.Nodo) it.next();
			int visualID = Asdm.diagram.part.AsdmVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID) {
				result.add(new Asdm.diagram.part.AsdmNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getContainedLinks(View view) {
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			return getDiagrama_1000ContainedLinks(view);
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			return getActividad_2001ContainedLinks(view);
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
			return getDecision_2002ContainedLinks(view);
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
			return getRamificacion_2003ContainedLinks(view);
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
			return getNodoInicial_2004ContainedLinks(view);
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
			return getNodoFinal_2005ContainedLinks(view);
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			return getActividad_3001ContainedLinks(view);
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
			return getDecision_3002ContainedLinks(view);
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
			return getRamificacion_3003ContainedLinks(view);
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
			return getNodoInicial_3004ContainedLinks(view);
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return getNodoFinal_3005ContainedLinks(view);
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			return getArista_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getIncomingLinks(View view) {
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			return getActividad_2001IncomingLinks(view);
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
			return getDecision_2002IncomingLinks(view);
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
			return getRamificacion_2003IncomingLinks(view);
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
			return getNodoInicial_2004IncomingLinks(view);
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
			return getNodoFinal_2005IncomingLinks(view);
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			return getActividad_3001IncomingLinks(view);
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
			return getDecision_3002IncomingLinks(view);
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
			return getRamificacion_3003IncomingLinks(view);
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
			return getNodoInicial_3004IncomingLinks(view);
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return getNodoFinal_3005IncomingLinks(view);
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			return getArista_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getOutgoingLinks(View view) {
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			return getActividad_2001OutgoingLinks(view);
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
			return getDecision_2002OutgoingLinks(view);
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
			return getRamificacion_2003OutgoingLinks(view);
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
			return getNodoInicial_2004OutgoingLinks(view);
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
			return getNodoFinal_2005OutgoingLinks(view);
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			return getActividad_3001OutgoingLinks(view);
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
			return getDecision_3002OutgoingLinks(view);
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
			return getRamificacion_3003OutgoingLinks(view);
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
			return getNodoInicial_3004OutgoingLinks(view);
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return getNodoFinal_3005OutgoingLinks(view);
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			return getArista_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDiagrama_1000ContainedLinks(View view) {
		Asdm.Diagrama modelElement = (Asdm.Diagrama) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getActividad_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDecision_2002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getRamificacion_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoInicial_2004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoFinal_2005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getActividad_3001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDecision_3002ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getRamificacion_3003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoInicial_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoFinal_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getArista_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getActividad_2001IncomingLinks(View view) {
		Asdm.Actividad modelElement = (Asdm.Actividad) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDecision_2002IncomingLinks(View view) {
		Asdm.Decision modelElement = (Asdm.Decision) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getRamificacion_2003IncomingLinks(View view) {
		Asdm.Ramificacion modelElement = (Asdm.Ramificacion) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoInicial_2004IncomingLinks(View view) {
		Asdm.NodoInicial modelElement = (Asdm.NodoInicial) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoFinal_2005IncomingLinks(View view) {
		Asdm.NodoFinal modelElement = (Asdm.NodoFinal) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getActividad_3001IncomingLinks(View view) {
		Asdm.Actividad modelElement = (Asdm.Actividad) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDecision_3002IncomingLinks(View view) {
		Asdm.Decision modelElement = (Asdm.Decision) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getRamificacion_3003IncomingLinks(View view) {
		Asdm.Ramificacion modelElement = (Asdm.Ramificacion) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoInicial_3004IncomingLinks(View view) {
		Asdm.NodoInicial modelElement = (Asdm.NodoInicial) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoFinal_3005IncomingLinks(View view) {
		Asdm.NodoFinal modelElement = (Asdm.NodoFinal) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Arista_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getArista_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getActividad_2001OutgoingLinks(View view) {
		Asdm.Actividad modelElement = (Asdm.Actividad) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDecision_2002OutgoingLinks(View view) {
		Asdm.Decision modelElement = (Asdm.Decision) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getRamificacion_2003OutgoingLinks(View view) {
		Asdm.Ramificacion modelElement = (Asdm.Ramificacion) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoInicial_2004OutgoingLinks(View view) {
		Asdm.NodoInicial modelElement = (Asdm.NodoInicial) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoFinal_2005OutgoingLinks(View view) {
		Asdm.NodoFinal modelElement = (Asdm.NodoFinal) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getActividad_3001OutgoingLinks(View view) {
		Asdm.Actividad modelElement = (Asdm.Actividad) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getDecision_3002OutgoingLinks(View view) {
		Asdm.Decision modelElement = (Asdm.Decision) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getRamificacion_3003OutgoingLinks(View view) {
		Asdm.Ramificacion modelElement = (Asdm.Ramificacion) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoInicial_3004OutgoingLinks(View view) {
		Asdm.NodoInicial modelElement = (Asdm.NodoInicial) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getNodoFinal_3005OutgoingLinks(View view) {
		Asdm.NodoFinal modelElement = (Asdm.NodoFinal) view.getElement();
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Arista_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<Asdm.diagram.part.AsdmLinkDescriptor> getArista_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<Asdm.diagram.part.AsdmLinkDescriptor> getContainedTypeModelFacetLinks_Arista_4001(
			Asdm.Diagrama container) {
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		for (Iterator<?> links = container.getAristas().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Asdm.Arista) {
				continue;
			}
			Asdm.Arista link = (Asdm.Arista) linkObject;
			if (Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID != Asdm.diagram.part.AsdmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Asdm.Nodo dst = link.getDestino();
			Asdm.Nodo src = link.getOrigen();
			result.add(new Asdm.diagram.part.AsdmLinkDescriptor(src, dst, link,
					Asdm.diagram.providers.AsdmElementTypes.Arista_4001,
					Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<Asdm.diagram.part.AsdmLinkDescriptor> getIncomingTypeModelFacetLinks_Arista_4001(
			Asdm.Nodo target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != Asdm.AsdmPackage.eINSTANCE.getArista_Destino()
					|| false == setting.getEObject() instanceof Asdm.Arista) {
				continue;
			}
			Asdm.Arista link = (Asdm.Arista) setting.getEObject();
			if (Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID != Asdm.diagram.part.AsdmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Asdm.Nodo src = link.getOrigen();
			result.add(new Asdm.diagram.part.AsdmLinkDescriptor(src, target, link,
					Asdm.diagram.providers.AsdmElementTypes.Arista_4001,
					Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<Asdm.diagram.part.AsdmLinkDescriptor> getOutgoingTypeModelFacetLinks_Arista_4001(
			Asdm.Nodo source) {
		Asdm.Diagrama container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Asdm.Diagrama) {
				container = (Asdm.Diagrama) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<Asdm.diagram.part.AsdmLinkDescriptor> result = new LinkedList<Asdm.diagram.part.AsdmLinkDescriptor>();
		for (Iterator<?> links = container.getAristas().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Asdm.Arista) {
				continue;
			}
			Asdm.Arista link = (Asdm.Arista) linkObject;
			if (Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID != Asdm.diagram.part.AsdmVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Asdm.Nodo dst = link.getDestino();
			Asdm.Nodo src = link.getOrigen();
			if (src != source) {
				continue;
			}
			result.add(new Asdm.diagram.part.AsdmLinkDescriptor(src, dst, link,
					Asdm.diagram.providers.AsdmElementTypes.Arista_4001,
					Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<Asdm.diagram.part.AsdmNodeDescriptor> getSemanticChildren(View view) {
			return AsdmDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<Asdm.diagram.part.AsdmLinkDescriptor> getContainedLinks(View view) {
			return AsdmDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<Asdm.diagram.part.AsdmLinkDescriptor> getIncomingLinks(View view) {
			return AsdmDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<Asdm.diagram.part.AsdmLinkDescriptor> getOutgoingLinks(View view) {
			return AsdmDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
