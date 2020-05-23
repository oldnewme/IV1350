package se.kth.iv1350.pos.DTO;

import se.kth.iv1350.pos.integration.Item;

/**
 * An data transfer object which is used to pass information about
 * an {@link Item} across different layers in the architecture
 * @author cantonio
 *
 */
public class ItemDTO {
	
	private long itemIdentifier;
	private String name;
    private double price;
    private double VAT;
    private int quantity;
    
    
    /**
     * Instantiates an {@link ItemDTO} based on an {@link Item}
     * @param item The {@link Item} that the {@link ItemDTO} will be based on
     */
    public ItemDTO(Item item) {
		this.itemIdentifier = item.getItemIdentifier();
		this.name = item.getName();
		this.price = item.getPrice();
		this.VAT = item.getVAT();
		this.quantity = item.getQuantity();
	}
    
    /**
     * Gets the itemIdentifier that corresponds to an item
     * @return itemIdentifier that uniquely identifies an {@link Item}
     */
	public long getItemIdentifier() {
		return itemIdentifier;
	}
	
	/**
	 * Gets the name of an {@link Item}
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the price of an {@link Item}
	 * @return the price of the {@link Item}
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Gets the VATrate of an {@link Item}
	 * @return the VATrate of an {@link Item}
	 */
	public double getVAT() {
		return VAT;
	}
	
	/**
	 * Gets the quantity of a certain {@link Item}
	 * @return the quantity of that {@link Item}
	 */
	public int getQuantity() {
		return quantity;
	}
    
    
}
