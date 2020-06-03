package se.kth.iv1350.pos.DTO;

/**
 * Class that contains information about customers
 * @author cantonio
 *
 */
public class CustomerDTO {
	private String name;
	private int ID;
	
	/**
	 * Creates a new customerDTO
	 * @param name name of customer
	 * @param ID identification number of customer
	 */
	public CustomerDTO(String name, int ID ) {
		this.name = name;
		this.ID = ID;
	}
	
	/**
	 * Returns the name of the customer. 
	 * @return	name of the Customer.
	 */
	public String getName() {
		return new String(name);
	}
	
	/**
	 * Returns the ID
	 * @return ID the customer ID
	 */
	public int getID() {
		return ID;
	}
}
