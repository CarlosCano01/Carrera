package Asdm.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AsdmParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser actividadNombre_5002Parser;

	/**
	* @generated
	*/
	private IParser getActividadNombre_5002Parser() {
		if (actividadNombre_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { Asdm.AsdmPackage.eINSTANCE.getActividad_Nombre() };
			Asdm.diagram.parsers.MessageFormatParser parser = new Asdm.diagram.parsers.MessageFormatParser(features);
			actividadNombre_5002Parser = parser;
		}
		return actividadNombre_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser actividadNombre_5001Parser;

	/**
	* @generated
	*/
	private IParser getActividadNombre_5001Parser() {
		if (actividadNombre_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { Asdm.AsdmPackage.eINSTANCE.getActividad_Nombre() };
			Asdm.diagram.parsers.MessageFormatParser parser = new Asdm.diagram.parsers.MessageFormatParser(features);
			actividadNombre_5001Parser = parser;
		}
		return actividadNombre_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser aristaNombre_6001Parser;

	/**
	* @generated
	*/
	private IParser getAristaNombre_6001Parser() {
		if (aristaNombre_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { Asdm.AsdmPackage.eINSTANCE.getArista_Nombre() };
			Asdm.diagram.parsers.MessageFormatParser parser = new Asdm.diagram.parsers.MessageFormatParser(features);
			aristaNombre_6001Parser = parser;
		}
		return aristaNombre_6001Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case Asdm.diagram.edit.parts.ActividadNombreEditPart.VISUAL_ID:
			return getActividadNombre_5002Parser();
		case Asdm.diagram.edit.parts.ActividadNombre2EditPart.VISUAL_ID:
			return getActividadNombre_5001Parser();
		case Asdm.diagram.edit.parts.AristaNombreEditPart.VISUAL_ID:
			return getAristaNombre_6001Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (Asdm.diagram.providers.AsdmElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
