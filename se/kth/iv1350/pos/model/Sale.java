package se.kth.iv1350.pos.model;
import java.util.*;

import se.kth.iv1350.pos.dbhandler.Item;

public class Sale {
    
    private double runningTotal = 0;
    private double VAT = 0;
    private double change = 0;
    private ArrayList<Item> itemsInSale;
	
	public Sale() {
		this.itemsInSale = new ArrayList<Item>();
	}
	
	public double getRunningTotal() {
		return runningTotal;
	}
	
	public ArrayList<Item> getItems(){
		ArrayList<Item> copyOfItemsInSale = new ArrayList<Item>();
		for(Item item : itemsInSale) {
			copyOfItemsInSale.add(item);
		}
		return copyOfItemsInSale;
	}
	
    public void updateSale(Item item)
    {
    	 if(duplicateItem(item)) {
             incrementQuantity(item);
    	 System.out.println(item.getQuantity());}
         else
             itemsInSale.add(item);
        updateTotalPrice(item);
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
    
    private boolean duplicateItem(Item item1)
    {
        for (Item item2 : itemsInSale)
        {
            if(sameIdentifier(item1.getItemIdentifier(), item2.getItemIdentifier()))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean sameIdentifier(long identifier1, long identifier2)
    {
        return (identifier1 == identifier2);
    }
    
    public StringBuilder printItems() {
    	StringBuilder sb = new StringBuilder();
    	for(Item item : itemsInSale) {
    		sb.append("[" + item.getName() + " " + item.getQuantity() +"]" +  ", ");
    	}
    	
    	return sb;
    }
    
	
}
