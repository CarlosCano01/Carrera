package Asdm.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class AsdmNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7004;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof Asdm.diagram.navigator.AsdmNavigatorItem) {
			Asdm.diagram.navigator.AsdmNavigatorItem item = (Asdm.diagram.navigator.AsdmNavigatorItem) element;
			return Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
