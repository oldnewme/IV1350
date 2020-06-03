package se.kth.iv1350.pos.integration;
/**
 * Thrown when connection to database can not be made
 * @author cantonio
 *
 */

public class DatabaseFailureException extends RuntimeException{
	
	/**
	 * Creates instance of exception when for example database is offline
	 * @param message Describes what went wrong in more detail
	 */
	public DatabaseFailureException(String message) {
		super(message);
	}
}