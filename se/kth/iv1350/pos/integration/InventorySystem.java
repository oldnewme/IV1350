package se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;

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
	public ItemDTO getItem(long itemIdentifier){
		ItemDTO itemDTO = null;
		for(Item item : itemRegistry) {
			if(item.getItemIdentifier() == itemIdentifier)
				itemDTO = new ItemDTO(item);
		}
		return itemDTO;
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
        itemRegistry.add(new Item(1000L, "Butter", 25, 0.12, 1));
        itemRegistry.add(new Item(1001L, "Milk", 12,  0.06, 1));
        itemRegistry.add(new Item(1002L, "Garlic", 3,  0.06, 1));
        itemRegistry.add(new Item(1003L, "Chocolate", 19,  0.25, 1));
        itemRegistry.add(new Item(1004L, "BBQ-Sauce", 36, 0.25, 1));
        itemRegistry.add(new Item(1005L, "Candy cane", 8, 0.12, 1));
    }

	public void updateIventory(SaleDTO saleDTO) {
		// TODO Auto-generated method stub
	}
}
