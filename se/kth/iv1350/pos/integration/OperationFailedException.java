package se.kth.iv1350.pos.integration;

/**
 * Thrown when an operation in the view can't be accomplished
 * @author cantonio
 *
 */

public class OperationFailedException extends RuntimeException {
	
	/**
	 * Creates instance of exception whenever an operation originating in the view
	 * fails for some reason
	 * @param message A message to the user of the system that lets them know that the operation failed.
	 */
	public OperationFailedException(String message) {
		super(message);
	}
}