package Asdm.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class AsdmElementTypes {

	/**
	* @generated
	*/
	private AsdmElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Diagrama_1000 = getElementType("Asdm.diagram.Diagrama_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Actividad_2001 = getElementType("Asdm.diagram.Actividad_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Decision_2002 = getElementType("Asdm.diagram.Decision_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Ramificacion_2003 = getElementType("Asdm.diagram.Ramificacion_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType NodoInicial_2004 = getElementType("Asdm.diagram.NodoInicial_2004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType NodoFinal_2005 = getElementType("Asdm.diagram.NodoFinal_2005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Actividad_3001 = getElementType("Asdm.diagram.Actividad_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Decision_3002 = getElementType("Asdm.diagram.Decision_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Ramificacion_3003 = getElementType("Asdm.diagram.Ramificacion_3003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType NodoInicial_3004 = getElementType("Asdm.diagram.NodoInicial_3004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType NodoFinal_3005 = getElementType("Asdm.diagram.NodoFinal_3005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Arista_4001 = getElementType("Asdm.diagram.Arista_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Diagrama_1000, Asdm.AsdmPackage.eINSTANCE.getDiagrama());

			elements.put(Actividad_2001, Asdm.AsdmPackage.eINSTANCE.getActividad());

			elements.put(Decision_2002, Asdm.AsdmPackage.eINSTANCE.getDecision());

			elements.put(Ramificacion_2003, Asdm.AsdmPackage.eINSTANCE.getRamificacion());

			elements.put(NodoInicial_2004, Asdm.AsdmPackage.eINSTANCE.getNodoInicial());

			elements.put(NodoFinal_2005, Asdm.AsdmPackage.eINSTANCE.getNodoFinal());

			elements.put(Actividad_3001, Asdm.AsdmPackage.eINSTANCE.getActividad());

			elements.put(Decision_3002, Asdm.AsdmPackage.eINSTANCE.getDecision());

			elements.put(Ramificacion_3003, Asdm.AsdmPackage.eINSTANCE.getRamificacion());

			elements.put(NodoInicial_3004, Asdm.AsdmPackage.eINSTANCE.getNodoInicial());

			elements.put(NodoFinal_3005, Asdm.AsdmPackage.eINSTANCE.getNodoFinal());

			elements.put(Arista_4001, Asdm.AsdmPackage.eINSTANCE.getArista());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Diagrama_1000);
			KNOWN_ELEMENT_TYPES.add(Actividad_2001);
			KNOWN_ELEMENT_TYPES.add(Decision_2002);
			KNOWN_ELEMENT_TYPES.add(Ramificacion_2003);
			KNOWN_ELEMENT_TYPES.add(NodoInicial_2004);
			KNOWN_ELEMENT_TYPES.add(NodoFinal_2005);
			KNOWN_ELEMENT_TYPES.add(Actividad_3001);
			KNOWN_ELEMENT_TYPES.add(Decision_3002);
			KNOWN_ELEMENT_TYPES.add(Ramificacion_3003);
			KNOWN_ELEMENT_TYPES.add(NodoInicial_3004);
			KNOWN_ELEMENT_TYPES.add(NodoFinal_3005);
			KNOWN_ELEMENT_TYPES.add(Arista_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID:
			return Diagrama_1000;
		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID:
			return Actividad_2001;
		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID:
			return Decision_2002;
		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID:
			return Ramificacion_2003;
		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID:
			return NodoInicial_2004;
		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID:
			return NodoFinal_2005;
		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID:
			return Actividad_3001;
		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID:
			return Decision_3002;
		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID:
			return Ramificacion_3003;
		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID:
			return NodoInicial_3004;
		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID:
			return NodoFinal_3005;
		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID:
			return Arista_4001;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return Asdm.diagram.providers.AsdmElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return Asdm.diagram.providers.AsdmElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return Asdm.diagram.providers.AsdmElementTypes.getElement(elementTypeAdapter);
		}
	};

}
