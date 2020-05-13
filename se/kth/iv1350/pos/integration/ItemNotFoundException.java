package se.kth.iv1350.pos.integration;
/**
 * Thrown when item can not be found in the inventory
 * @author cantonio
 *
 */
public class ItemNotFoundException extends Exception {
	
	/**
	 * Creates instance of exception when item searched for can not be found in inventory
	 * @param message Describes reason for item not being found
	 */
	public ItemNotFoundException(String message) {
		super(message);
	}
}
