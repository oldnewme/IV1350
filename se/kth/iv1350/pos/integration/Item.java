package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.DTO.ItemDTO;

public class Item {
	
	private long itemIdentifier;
	private String name;
    private double price;
    private double VAT;
    private int quantity;
    
    
    /**
     * Creates an {@link Item} from an existing item
     * @param item
     */
    public Item(Item item) {
    	this.itemIdentifier = item.itemIdentifier;
    	this.name = item.name;
    	this.price = item.price;
    	this.VAT = item.VAT;
    	this.quantity = item.quantity;
    	
    	
    }
    
    /**
     * Creates an {@link Item} from an existing item
     * @param itemDTO
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
     * @param name
     * @param price
     * @param VAT
     * @param quantity
     */
    public Item(long itemIdentifier, String name, double price, double VAT, int quantity) {
    	this.name = name;
        this.price = price;
        this.itemIdentifier = itemIdentifier;
        this.VAT = VAT;
        this.quantity = quantity;
	}
    
    /**
     * Returns identifier of given {@Item}
     * @return itemIdentifier
     */
    public long getItemIdentifier() {
		return itemIdentifier;
	}
    
    /**
     * Sets identifier of given {@Item}
     * @param itemIdentifier
     */
	public void setItemIdentifier(long itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}
	
	/**
	 * Returns name of given {@Item}
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
     * Sets name of given {@Item}
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns price of given {@Item}
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
     * Sets price of given {@Item}
     * @param price
     */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Returns VAT tax rate of given {@Item}
	 * @return VAT
	 */
	public double getVAT() {
		return VAT;
	}
	
	/**
     * Sets VAT tax rate {@Item}
     * @param VAT
     */
	public void setVAT(double VAT) {
		this.VAT = VAT;
	}
	
	/**
	 * Returns quantity of given {@Item}
	 * @return item
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
     * Sets quantity {@Item}
     * @param quantity
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
