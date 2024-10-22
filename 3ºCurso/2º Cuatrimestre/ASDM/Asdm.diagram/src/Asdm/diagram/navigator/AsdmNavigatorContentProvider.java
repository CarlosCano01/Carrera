package Asdm.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class AsdmNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public AsdmNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	* @generated
	*/
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
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
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<Asdm.diagram.navigator.AsdmNavigatorItem> result = new ArrayList<Asdm.diagram.navigator.AsdmNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews, Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof Asdm.diagram.navigator.AsdmNavigatorGroup) {
			Asdm.diagram.navigator.AsdmNavigatorGroup group = (Asdm.diagram.navigator.AsdmNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof Asdm.diagram.navigator.AsdmNavigatorItem) {
			Asdm.diagram.navigator.AsdmNavigatorItem navigatorItem = (Asdm.diagram.navigator.AsdmNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (Asdm.diagram.part.AsdmVisualIDRegistry.getVisualID(view)) {

		case Asdm.diagram.edit.parts.DiagramaEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup links = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Diagrama_1000_links, "icons/linksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Actividad_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Actividad_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Decision_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Decision_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Ramificacion_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Ramificacion_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoInicial_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoInicial_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoFinal_2005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoFinal_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Actividad_3001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Actividad_3001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadActividadSubdiagCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Decision_3002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Decision_3002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Ramificacion_3003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Ramificacion_3003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoInicial_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoInicial_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Node sv = (Node) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup incominglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoFinal_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup outgoinglinks = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_NodoFinal_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Asdm.diagram.edit.parts.AristaEditPart.VISUAL_ID: {
			LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem> result = new LinkedList<Asdm.diagram.navigator.AsdmAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			Asdm.diagram.navigator.AsdmNavigatorGroup target = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Arista_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Asdm.diagram.navigator.AsdmNavigatorGroup source = new Asdm.diagram.navigator.AsdmNavigatorGroup(
					Asdm.diagram.part.Messages.NavigatorGroupName_Arista_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.ActividadEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					Asdm.diagram.part.AsdmVisualIDRegistry.getType(Asdm.diagram.edit.parts.DecisionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.RamificacionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicialEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Actividad2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Decision2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.Ramificacion2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoInicial2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv), Asdm.diagram.part.AsdmVisualIDRegistry
					.getType(Asdm.diagram.edit.parts.NodoFinal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return Asdm.diagram.edit.parts.DiagramaEditPart.MODEL_ID
				.equals(Asdm.diagram.part.AsdmVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<Asdm.diagram.navigator.AsdmNavigatorItem> createNavigatorItems(Collection<View> views,
			Object parent, boolean isLeafs) {
		ArrayList<Asdm.diagram.navigator.AsdmNavigatorItem> result = new ArrayList<Asdm.diagram.navigator.AsdmNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new Asdm.diagram.navigator.AsdmNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof Asdm.diagram.navigator.AsdmAbstractNavigatorItem) {
			Asdm.diagram.navigator.AsdmAbstractNavigatorItem abstractNavigatorItem = (Asdm.diagram.navigator.AsdmAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
