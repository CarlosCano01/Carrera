package Asdm.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	* @generated
	*/
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		Asdm.diagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		Asdm.diagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		Asdm.diagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		Asdm.diagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		Asdm.diagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
	* @generated
	*/
	protected IPreferenceStore getPreferenceStore() {
		return Asdm.diagram.part.AsdmDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
