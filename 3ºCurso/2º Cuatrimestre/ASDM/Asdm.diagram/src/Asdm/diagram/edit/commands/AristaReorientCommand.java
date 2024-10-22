package Asdm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class AristaReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public AristaReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Asdm.Arista) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Asdm.Nodo && newEnd instanceof Asdm.Nodo)) {
			return false;
		}
		Asdm.Nodo target = getLink().getDestino();
		if (!(getLink().eContainer() instanceof Asdm.Diagrama)) {
			return false;
		}
		Asdm.Diagrama container = (Asdm.Diagrama) getLink().eContainer();
		return Asdm.diagram.edit.policies.AsdmBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistArista_4001(container, getLink(), getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Asdm.Nodo && newEnd instanceof Asdm.Nodo)) {
			return false;
		}
		Asdm.Nodo source = getLink().getOrigen();
		if (!(getLink().eContainer() instanceof Asdm.Diagrama)) {
			return false;
		}
		Asdm.Diagrama container = (Asdm.Diagrama) getLink().eContainer();
		return Asdm.diagram.edit.policies.AsdmBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistArista_4001(container, getLink(), source, getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setOrigen(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setDestino(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected Asdm.Arista getLink() {
		return (Asdm.Arista) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected Asdm.Nodo getOldSource() {
		return (Asdm.Nodo) oldEnd;
	}

	/**
	* @generated
	*/
	protected Asdm.Nodo getNewSource() {
		return (Asdm.Nodo) newEnd;
	}

	/**
	* @generated
	*/
	protected Asdm.Nodo getOldTarget() {
		return (Asdm.Nodo) oldEnd;
	}

	/**
	* @generated
	*/
	protected Asdm.Nodo getNewTarget() {
		return (Asdm.Nodo) newEnd;
	}
}
