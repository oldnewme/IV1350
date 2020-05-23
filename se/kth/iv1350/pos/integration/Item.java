package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.DTO.ItemDTO;

/**
 * Represents an Item in the store inventory that is for sale
 * @author cantonio
 *
 */
public class Item {
	
	private long itemIdentifier;
	private String name;
    private double price;
    private double VAT;
    private int quantity;
    
    
    /**
     * Creates an {@link Item} from an existing item
     * @param item An item in the store
     */
    public Item(Item item) {
    	this.itemIdentifier = item.itemIdentifier;
    	this.name = item.name;
    	this.price = item.price;
    	this.VAT = item.VAT;
    	this.quantity = item.quantity;
    	
    	
    }
    
    /**
     * Creates an {@link Item} from an existing {@link ItemDTO}
     * @param itemDTO The {@link ItemDTO} that an {@link Item} will be created from
     */
    public Item(ItemDTO itemDTO) {
    	this.itemIdentifier = itemDTO.getItemIdentifier();
    	this.name = itemDTO.getName();
    	this.price = itemDTO.getPrice();
    	this.VAT = itemDTO.getVAT();
    	this.quantity = itemDTO.getQuantity();
    	
    	
    }
    
    /**
     * Creates a new {@link Item} with given parameters which represents an item for sale.
     * @param itemIdentifier unique identifier
     * @param name The name of the {@link Item}
     * @param price The price of the {@link Item}
     * @param VAT The VAT rate of the {@link Item}
     * @param quantity The quantity of the {@link Item}
     */
    public Item(long itemIdentifier, String name, double price, double VAT, int quantity) {
    	this.name = name;
        this.price = price;
        this.itemIdentifier = itemIdentifier;
        this.VAT = VAT;
        this.quantity = quantity;
	}
    
    /**
     * Returns identifier of given {@link Item}
     * @return itemIdentifier uniquely identifies an {@link Item}
     */
    public long getItemIdentifier() {
		return itemIdentifier;
	}
    
    /**
     * Sets identifier of given {@link Item}
     * @param itemIdentifier uniquely identifies an {@link Item}
     */
	public void setItemIdentifier(long itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}
	
	/**
	 * Returns name of given {@link Item}
	 * @return name The name of the {@link Item}
	 */
	public String getName() {
		return name;
	}
	
	/**
     * Sets name of given {@link Item}
     * @param name The name of {@link Item}
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns price of given {@link Item}
	 * @return price The price of the {@link Item}
	 */
	public double getPrice() {
		return price;
	}
	
	/**
     * Sets price of given {@link Item}
     * @param price The price of the {@link Item}
     */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Returns VAT tax rate of given {@link Item}
	 * @return VAT The tax rate of given {@link Item}
	 */
	public double getVAT() {
		return VAT;
	}
	
	/**
     * Sets VAT tax rate {@link Item}
     * @param VAT tax rate of given {@link Item}
     */
	public void setVAT(double VAT) {
		this.VAT = VAT;
	}
	
	/**
	 * Returns quantity of given {@link Item}
	 * @return item The quantity of given {@link Item}
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
     * Sets quantity of the {@link Item}
     * @param quantity The quantity of given {@link Item}
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
