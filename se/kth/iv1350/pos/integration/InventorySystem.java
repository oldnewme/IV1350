package se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;

public class InventorySystem {
	
	private ArrayList<Item> itemRegistry;
	
	/**
	 * Creates a new instance representing the inventory system
	 */
	public InventorySystem() {
		itemRegistry = new ArrayList<Item>();
		createInventory();
	}
	
	/**
	 * Returns information about an {@link Item} with specified identifier.
	 * @param itemIdentifier Identifier that uniquely identifies an {@link Item}
	 * @return an {@link ItemDTO} with information about the {@link Item} requested
	 */
	public ItemDTO getItem(long itemIdentifier){
		
		ItemDTO itemDTO = null;;
		itemDTO = returnItemInfo(itemIdentifier, itemDTO);
		return itemDTO;
    }
	
	/**
	 * Could be implemented to update inventory based on a {@link SaleDTO}
	 * @param saleDTO Contains information about current sale to update inventory
	 */
	public void updateIventory(SaleDTO saleDTO) {
		// TODO Auto-generated method stub
	}
	
	private boolean sameIdentifier(long id1, long id2) {
        return (id1 == id2);
    }
	
	private ItemDTO returnItemInfo(long itemIdentifier, ItemDTO itemDTO) {
		for(Item item : itemRegistry) {
			if (sameIdentifier(itemIdentifier, item.getItemIdentifier()))
				itemDTO = new ItemDTO(item);
		}
		return itemDTO;
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

	
}
