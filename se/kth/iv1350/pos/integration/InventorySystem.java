package se.kth.iv1350.pos.integration;

import java.util.ArrayList;

public class InventorySystem {
	
	private ArrayList<Item> itemRegistry;
	
	/**
	 * Creates a new instance representing the accounting system
	 */
	public InventorySystem() {
		itemRegistry = new ArrayList<Item>();
		createInventory();
	}
	
	/**
	 * Returns an {@link Item} with specified identifier.
	 * @param itemIdentifier represent the products identifier
	 * @return itemInCurrentSale
	 */
	public Item getItem(long itemIdentifier){

		for(Item item : itemRegistry) {
			if(item.getItemIdentifier() == itemIdentifier && item.getQuantity() > 0) {
				item.setQuantity(item.getQuantity()-1);
				Item itemInCurrentSale = new Item(item);
				itemInCurrentSale.setQuantity(1);
				return itemInCurrentSale;
			}
		}
		
		
		return new Item(itemRegistry.get(0));
    }
	
	/**
	 * Checks if item is in {@link InventorySystem}
	 * @param itemIdentifier
	 * @return 
	 */
	public boolean itemInInventory(long itemIdentifier) {
		for(Item item : itemRegistry) {
			if(sameIdentifier(itemIdentifier, item.getItemIdentifier()))
				return true;
		}
		return false;
	}
	
	
	private boolean sameIdentifier(long id1, long id2) {
        return (id1 == id2);
    }
	
    private void createInventory() {
        itemRegistry.add(new Item(0L, "identifier doesn't exist", 00.00,  0.00, 0));
        itemRegistry.add(new Item(1000L, "Butter", 25, 0.12, 10));
        itemRegistry.add(new Item(1001L, "Milk", 12,  0.06, 10));
        itemRegistry.add(new Item(1002L, "Garlic", 3,  0.06, 10));
        itemRegistry.add(new Item(1003L, "Chocolate", 19,  0.25, 10));
        itemRegistry.add(new Item(1004L, "BBQ-Sauce", 36, 0.25, 10));
        itemRegistry.add(new Item(1005L, "Candy cane", 8, 0.12, 10));
    }
}
