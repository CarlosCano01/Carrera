package Asdm.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class AsdmModelingAssistantProviderOfDiagramaEditPart
		extends Asdm.diagram.providers.AsdmModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_2001);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_2002);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_2003);
		types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_2004);
		types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_2005);
		return types;
	}

}
