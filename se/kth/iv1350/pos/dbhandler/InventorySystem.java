package se.kth.iv1350.pos.dbhandler;

import java.util.ArrayList;

public class InventorySystem {
	
	private ArrayList<Item> itemRegistry;
	
	public InventorySystem() {
		itemRegistry = new ArrayList<Item>();
		createInventory();
	}
	
	public Item getItem(long itemIdentifier){
		Item itemInCurrentSale = null;
		for(Item item : itemRegistry) {
			if(item.getItemIdentifier() == itemIdentifier && item.getQuantity() > 0) {
				item.setQuantity(item.getQuantity()-1);
				itemInCurrentSale = new Item(item);
				itemInCurrentSale.setQuantity(1);
			}
		}
		
		
		return itemInCurrentSale;
    }
	
	
    private void createInventory() {
        itemRegistry.add(new Item(0L, "Invalid", 00.00,  0.00, 0));
        itemRegistry.add(new Item(1000L, "Marabou Choklad 200g", 24.99, 0.12, 10));
        itemRegistry.add(new Item(1001L, "Röd Mjölk", 11.99,  0.06, 10));
        itemRegistry.add(new Item(1002L, "Onion", 6.99,  0.06, 10));
        itemRegistry.add(new Item(1003L, "Red Wine", 69.99,  0.25, 10));
        itemRegistry.add(new Item(1004L, "Saffran 1g", 27.99, 0.25, 10));
        itemRegistry.add(new Item(1005L, "Energy Drank Deluxe 500ml", 12.49, 0.12, 10));
    }
}
