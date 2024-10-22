package Asdm.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class AsdmEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {

			case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.DiagramaEditPart(view);

			case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.ActividadEditPart(view);

			case Asdm.diagram.edit.parts.ActividadNombreEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.ActividadNombreEditPart(view);

			case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.DecisionEditPart(view);

			case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.RamificacionEditPart(view);

			case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.NodoInicialEditPart(view);

			case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.NodoFinalEditPart(view);

			case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.Actividad2EditPart(view);

			case Asdm.diagram.edit.parts.ActividadNombre2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.ActividadNombre2EditPart(view);

			case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.Decision2EditPart(view);

			case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.Ramificacion2EditPart(view);

			case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.NodoInicial2EditPart(view);

			case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.NodoFinal2EditPart(view);

			case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart(view);

			case Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart(view);

			case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.AristaEditPart(view);

			case Asdm.diagram.edit.parts.AristaNombreEditPart.VISUAL_ID:
				return new Asdm.diagram.edit.parts.AristaNombreEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
