package Asdm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ActividadActividadSubdiagCompartment2ItemSemanticEditPolicy
		extends Asdm.diagram.edit.policies.AsdmBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ActividadActividadSubdiagCompartment2ItemSemanticEditPolicy() {
		super(Asdm.diagram.providers.AsdmElementTypes.Actividad_3001);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (Asdm.diagram.providers.AsdmElementTypes.Actividad_3001 == req.getElementType()) {
			return getGEFWrapper(new Asdm.diagram.edit.commands.Actividad2CreateCommand(req));
		}
		if (Asdm.diagram.providers.AsdmElementTypes.Decision_3002 == req.getElementType()) {
			return getGEFWrapper(new Asdm.diagram.edit.commands.Decision2CreateCommand(req));
		}
		if (Asdm.diagram.providers.AsdmElementTypes.Ramificacion_3003 == req.getElementType()) {
			return getGEFWrapper(new Asdm.diagram.edit.commands.Ramificacion2CreateCommand(req));
		}
		if (Asdm.diagram.providers.AsdmElementTypes.NodoInicial_3004 == req.getElementType()) {
			return getGEFWrapper(new Asdm.diagram.edit.commands.NodoInicial2CreateCommand(req));
		}
		if (Asdm.diagram.providers.AsdmElementTypes.NodoFinal_3005 == req.getElementType()) {
			return getGEFWrapper(new Asdm.diagram.edit.commands.NodoFinal2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
