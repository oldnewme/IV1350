package se.kth.iv1350.pos.model;
import java.util.*;

import se.kth.iv1350.pos.integration.Item;

public class Sale {
    
    private double runningTotal = 0;
    private double VAT = 0;
    private double change = 0;
    private ArrayList<Item> itemsInSale;
	
    /**
     * creates a new {@link Sale} that will hold all items that customer wants to buy
     */
	public Sale() {
		this.itemsInSale = new ArrayList<Item>();
	}
	/**
	 * Gets the {@link runningTotal} in the current ongoing {@link Sale}	
	 * @return runningTotal the total price of {@link Item}'s that have been added to the {@link Sale}
	 */
	public double getRunningTotal() {
		return runningTotal;
	}
	
	/**
	 * Creates a copied list of all {@link Item}'s in the current {@link Sale}
	 * @return copyOfItemsInSale
	 */ 
	public ArrayList<Item> getItems(){
		ArrayList<Item> copyOfItemsInSale = new ArrayList<Item>();
		for(Item item : itemsInSale) {
			copyOfItemsInSale.add(item);
		}
		return copyOfItemsInSale;
	}
	
	/**
	 * Adds an {@link Item} to the current sale
	 * @param item the {@link Item} that last registered in {@link CashRegister}
	 */
    public void updateSale(Item item)
    {
    	 if(duplicateItem(item)) {
             incrementQuantity(item);
    	 System.out.println(item.getQuantity());}
         else
             itemsInSale.add(item);
        updateTotalPrice(item);
    }
    
    public void calculateVAT()
    {
        float VAT = 0f;

        for (Item item : itemsInSale)
        {
            VAT += (item.getPrice() * item.getQuantity() * item.getVAT());
        }

        this.VAT = VAT;
    }
    
    public void setChange(double amount) {
    	this.change = amount;
    }

	public double getVAT() {

		return VAT;
	}

	public double getChange() {

		return change;
	}
    
    private void incrementQuantity(Item item1) {
    	for(Item item2 : itemsInSale) {
    		if(sameIdentifier(item1.getItemIdentifier(), item2.getItemIdentifier())) {
    			item2.setQuantity(item2.getQuantity() + 1);
    		}
    	}
    }
	
    private void updateTotalPrice(Item item) {
        runningTotal += item.getPrice();
    }
    
    private boolean duplicateItem(Item item1) {
        for (Item item2 : itemsInSale)
        {
            if(sameIdentifier(item1.getItemIdentifier(), item2.getItemIdentifier()))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean sameIdentifier(long identifier1, long identifier2) {
        return (identifier1 == identifier2);
    }
}
