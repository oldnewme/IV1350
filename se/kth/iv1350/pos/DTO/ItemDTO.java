package se.kth.iv1350.pos.DTO;

import se.kth.iv1350.pos.integration.Item;

public class ItemDTO {
	
	private long itemIdentifier;
	private String name;
    private double price;
    private double VAT;
    private int quantity;
    
    public ItemDTO(Item item) {
		this.itemIdentifier = item.getItemIdentifier();
		this.name = item.getName();
		this.price = item.getPrice();
		this.VAT = item.getVAT();
		this.quantity = item.getQuantity();
	}

	public long getItemIdentifier() {
		return itemIdentifier;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getVAT() {
		return VAT;
	}

	public int getQuantity() {
		return quantity;
	}
    
    
}
