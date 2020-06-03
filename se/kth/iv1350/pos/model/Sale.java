package se.kth.iv1350.pos.model;
import java.util.*;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.Item;

/**
 * This class represents an actual Sale being made
 * @author cantonio
 *
 */
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
	
	public Sale(SaleDTO saleDTO) {
		this.runningTotal = saleDTO.getRunningTotal();
		this.VAT = saleDTO.getVAT();
		this.change = saleDTO.getChange();
		this.itemsInSale = saleDTO.getItems();
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
	 * @param itemDTO an {@link ItemDTO} that represents the {@link Item} that last registered in {@link CashRegister}
	 */
    public void updateSale(ItemDTO itemDTO)
    {
    	 if(duplicateItem(itemDTO))
             incrementQuantity(itemDTO);
         else {
        	 Item currentItem = new Item(itemDTO);
             itemsInSale.add(currentItem);
         }
        updateTotalPrice(itemDTO);
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
    
    /**
     * sets change in sale object
     * @param amount the amount the change is set to
     */
    public void setChange(double amount) {
    	this.change = amount;
    }
    
    /**
     * sets the runningTotal of the sale
     * @param newRunningTotal the total that running total will be set to
     */
    public void setRunningTotal(double newRunningTotal) {
    	this.runningTotal = newRunningTotal;
    }
    
    /**
     * gets the VAT rate
     * @return VAT the tax of the sale
     */
	public double getVAT() {

		return VAT;
	}
	
	/**
	 * retrieves the change of the sale
	 * @return change the change that the sale results in
	 */
	public double getChange() {

		return change;
	}
    
    private void incrementQuantity(ItemDTO itemDTO) {
    	for(Item item : itemsInSale) {
    		if(sameIdentifier(itemDTO.getItemIdentifier(), item.getItemIdentifier())) {
    			item.setQuantity(item.getQuantity() + 1);
    		}
    	}
    }
	
    private void updateTotalPrice(ItemDTO itemDTO) {
        runningTotal += (itemDTO.getPrice()+itemDTO.getPrice()*itemDTO.getVAT());
    }
    
    private boolean duplicateItem(ItemDTO itemDTO) {
        for (Item item : itemsInSale)
        {
            if(sameIdentifier(itemDTO.getItemIdentifier(), item.getItemIdentifier()))
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
