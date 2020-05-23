package se.kth.iv1350.pos.DTO;

/**
 * Stores information about the store in which the sale  is ongoing
 * @author cantonio
 *
 */
public class StoreDTO {
	private String name;
	private String address;
	
	/**
	 * Instantiates a {@link StoreDTO} with a given name and address
	 * @param name The name of the store
	 * @param address The address of the store
	 */
	public StoreDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	/**
	 * Getter for the name of the store
	 * @return name The name of the store
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for the address of the store
	 * @return address the address of the store
	 */
	public String getAddress() {
		return address;
	}
}
