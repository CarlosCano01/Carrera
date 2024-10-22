package Asdm.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class AsdmModelingAssistantProviderOfActividadEditPart
		extends Asdm.diagram.providers.AsdmModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((Asdm.diagram.edit.parts.ActividadEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(Asdm.diagram.edit.parts.ActividadEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((Asdm.diagram.edit.parts.ActividadEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(Asdm.diagram.edit.parts.ActividadEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof Asdm.diagram.edit.parts.ActividadEditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.DecisionEditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.RamificacionEditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.NodoInicialEditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.NodoFinalEditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.Actividad2EditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.Decision2EditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.Ramificacion2EditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.NodoInicial2EditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		if (targetEditPart instanceof Asdm.diagram.edit.parts.NodoFinal2EditPart) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((Asdm.diagram.edit.parts.ActividadEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(Asdm.diagram.edit.parts.ActividadEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == Asdm.diagram.providers.AsdmElementTypes.Arista_4001) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_2001);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_2002);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_2003);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_2004);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_2005);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_3001);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_3002);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_3003);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_3004);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_3005);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((Asdm.diagram.edit.parts.ActividadEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(Asdm.diagram.edit.parts.ActividadEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Arista_4001);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((Asdm.diagram.edit.parts.ActividadEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(Asdm.diagram.edit.parts.ActividadEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == Asdm.diagram.providers.AsdmElementTypes.Arista_4001) {
			types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_2001);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_2002);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_2003);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_2004);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_2005);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_3001);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_3002);
			types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_3003);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_3004);
			types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_3005);
		}
		return types;
	}

}
