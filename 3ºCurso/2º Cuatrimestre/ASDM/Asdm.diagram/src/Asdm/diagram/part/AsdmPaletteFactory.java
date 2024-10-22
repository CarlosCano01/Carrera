
package Asdm.diagram.part;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class AsdmPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	* Creates "Objects" palette tool group
	* @generated
	*/
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Asdm.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createActividad1CreationTool());
		paletteContainer.add(createDecisión2CreationTool());
		paletteContainer.add(createNodofinal3CreationTool());
		paletteContainer.add(createNodoinicial4CreationTool());
		paletteContainer.add(createRamificación5CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Connections" palette tool group
	* @generated
	*/
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Asdm.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createArista1CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createActividad1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_2001);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Actividad_3001);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Asdm.diagram.part.Messages.Actividad1CreationTool_title,
				Asdm.diagram.part.Messages.Actividad1CreationTool_desc, types);
		entry.setId("createActividad1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Asdm.diagram.providers.AsdmElementTypes
				.getImageDescriptor(Asdm.diagram.providers.AsdmElementTypes.Actividad_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDecisión2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_3002);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Decision_2002);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Asdm.diagram.part.Messages.Decisión2CreationTool_title,
				Asdm.diagram.part.Messages.Decisión2CreationTool_desc, types);
		entry.setId("createDecisión2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Asdm.diagram.providers.AsdmElementTypes
				.getImageDescriptor(Asdm.diagram.providers.AsdmElementTypes.Decision_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNodofinal3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_3005);
		types.add(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_2005);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Asdm.diagram.part.Messages.Nodofinal3CreationTool_title,
				Asdm.diagram.part.Messages.Nodofinal3CreationTool_desc, types);
		entry.setId("createNodofinal3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Asdm.diagram.providers.AsdmElementTypes
				.getImageDescriptor(Asdm.diagram.providers.AsdmElementTypes.NodoFinal_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createNodoinicial4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_3004);
		types.add(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_2004);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Asdm.diagram.part.Messages.Nodoinicial4CreationTool_title,
				Asdm.diagram.part.Messages.Nodoinicial4CreationTool_desc, types);
		entry.setId("createNodoinicial4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Asdm.diagram.providers.AsdmElementTypes
				.getImageDescriptor(Asdm.diagram.providers.AsdmElementTypes.NodoInicial_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createRamificación5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_3003);
		types.add(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_2003);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Asdm.diagram.part.Messages.Ramificación5CreationTool_title,
				Asdm.diagram.part.Messages.Ramificación5CreationTool_desc, types);
		entry.setId("createRamificación5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Asdm.diagram.providers.AsdmElementTypes
				.getImageDescriptor(Asdm.diagram.providers.AsdmElementTypes.Ramificacion_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createArista1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Asdm.diagram.part.Messages.Arista1CreationTool_title,
				Asdm.diagram.part.Messages.Arista1CreationTool_desc,
				Collections.singletonList(Asdm.diagram.providers.AsdmElementTypes.Arista_4001));
		entry.setId("createArista1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(Asdm.diagram.providers.AsdmElementTypes
				.getImageDescriptor(Asdm.diagram.providers.AsdmElementTypes.Arista_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
