package Asdm.diagram.providers;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
