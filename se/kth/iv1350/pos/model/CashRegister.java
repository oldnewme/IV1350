package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.InventorySystem;
import se.kth.iv1350.pos.dbhandler.Item;

public class CashRegister {
	private InventorySystem itemRegistry;
    private double amountInRegister;
    private double currentSaleAmount;
	
	public CashRegister() {
		itemRegistry = new InventorySystem();
		amountInRegister = 0;
		currentSaleAmount = 0;
	}
	
	public Sale newSale() {
		
		Sale newCreatedSale = new Sale();
		return newCreatedSale;
	}

	public Item registerItem(long itemIdentifier) {
		
		
		if(itemRegistry.getItem(itemIdentifier) != null) {
			Item currentItem = itemRegistry.getItem(itemIdentifier);
            increaseCurrentSaleAmount(currentItem.getPrice());
            return currentItem;
		}
		else {
			return itemRegistry.getItem(0L);
		}
		
	}
	
	public void increaseCurrentSaleAmount(double amount) {
		currentSaleAmount += amount;
	}
}
