package se.kth.iv1350.pos.dbhandler;

public class Item {
	
	private long itemIdentifier;
	private String name;
    private double price;
    private double VAT;
    private int quantity;
    
    public Item(Item item) {
    	this.itemIdentifier = item.itemIdentifier;
    	this.name = item.name;
    	this.price = item.price;
    	this.VAT = item.VAT;
    	this.quantity = item.quantity;
    	
    	
    }
    
    public Item(long itemIdentifier, String name, double price, double VAT, int quantity) {
    	this.name = name;
        this.price = price;
        this.itemIdentifier = itemIdentifier;
        this.VAT = VAT;
        this.quantity = quantity;
	}
    
    public long getItemIdentifier() {
		return itemIdentifier;
	}
	public void setItemIdentifier(long itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVAT() {
		return VAT;
	}
	public void setVAT(double vAT) {
		VAT = vAT;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
