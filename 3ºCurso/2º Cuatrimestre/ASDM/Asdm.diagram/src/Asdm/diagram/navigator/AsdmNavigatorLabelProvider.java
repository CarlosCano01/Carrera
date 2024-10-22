package Asdm.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class AsdmNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof Asdm.diagram.navigator.AsdmNavigatorItem
				&& !isOwnView(((Asdm.diagram.navigator.AsdmNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof Asdm.diagram.navigator.AsdmNavigatorGroup) {
			Asdm.diagram.navigator.AsdmNavigatorGroup group = (Asdm.diagram.navigator.AsdmNavigatorGroup) element;
			return Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof Asdm.diagram.navigator.AsdmNavigatorItem) {
			Asdm.diagram.navigator.AsdmNavigatorItem navigatorItem = (Asdm.diagram.navigator.AsdmNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?Asdm?Diagrama", Asdm.diagram.providers.AsdmElementTypes.Diagrama_1000); //$NON-NLS-1$
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?Asdm?Actividad", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.Actividad_2001);
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?Asdm?Decision", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.Decision_2002);
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?Asdm?Ramificacion", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.Ramificacion_2003);
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?Asdm?NodoInicial", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.NodoInicial_2004);
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?Asdm?NodoFinal", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.NodoFinal_2005);
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?Asdm?Actividad", Asdm.diagram.providers.AsdmElementTypes.Actividad_3001); //$NON-NLS-1$
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?Asdm?Decision", Asdm.diagram.providers.AsdmElementTypes.Decision_3002); //$NON-NLS-1$
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?Asdm?Ramificacion", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.Ramificacion_3003);
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?Asdm?NodoInicial", //$NON-NLS-1$
					Asdm.diagram.providers.AsdmElementTypes.NodoInicial_3004);
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?Asdm?NodoFinal", Asdm.diagram.providers.AsdmElementTypes.NodoFinal_3005); //$NON-NLS-1$
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			return getImage("Navigator?Link?Asdm?Arista", Asdm.diagram.providers.AsdmElementTypes.Arista_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& Asdm.diagram.providers.AsdmElementTypes.isKnownElementType(elementType)) {
			image = Asdm.diagram.providers.AsdmElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof Asdm.diagram.navigator.AsdmNavigatorGroup) {
			Asdm.diagram.navigator.AsdmNavigatorGroup group = (Asdm.diagram.navigator.AsdmNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof Asdm.diagram.navigator.AsdmNavigatorItem) {
			Asdm.diagram.navigator.AsdmNavigatorItem navigatorItem = (Asdm.diagram.navigator.AsdmNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			return getDiagrama_1000Text(view);
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			return getActividad_2001Text(view);
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
			return getDecision_2002Text(view);
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
			return getRamificacion_2003Text(view);
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
			return getNodoInicial_2004Text(view);
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
			return getNodoFinal_2005Text(view);
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			return getActividad_3001Text(view);
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
			return getDecision_3002Text(view);
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
			return getRamificacion_3003Text(view);
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
			return getNodoInicial_3004Text(view);
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return getNodoFinal_3005Text(view);
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			return getArista_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getDiagrama_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getActividad_2001Text(View view) {
		IParser parser = Asdm.diagram.providers.AsdmParserProvider.getParser(
				Asdm.diagram.providers.AsdmElementTypes.Actividad_2001,
				view.getElement() != null ? view.getElement() : view, Asdm.diagram.part.AsdmVisualIDRegistry
						.getType(Asdm.diagram.edit.parts.ActividadNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDecision_2002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getRamificacion_2003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getNodoInicial_2004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getNodoFinal_2005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getActividad_3001Text(View view) {
		IParser parser = Asdm.diagram.providers.AsdmParserProvider.getParser(
				Asdm.diagram.providers.AsdmElementTypes.Actividad_3001,
				view.getElement() != null ? view.getElement() : view, Asdm.diagram.part.AsdmVisualIDRegistry
						.getType(Asdm.diagram.edit.parts.ActividadNombre2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDecision_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getRamificacion_3003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getNodoInicial_3004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getNodoFinal_3005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getArista_4001Text(View view) {
		IParser parser = Asdm.diagram.providers.AsdmParserProvider.getParser(
				Asdm.diagram.providers.AsdmElementTypes.Arista_4001,
				view.getElement() != null ? view.getElement() : view,
				Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaNombreEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID
				.equals(Asdm.diagram.part.AsdmVisualIDRegistry.getModelID(view));
	}

}
