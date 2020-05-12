package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;


public class Controller {
	
	private CashRegister cashRegister;
	
	
	/**
	 * Creates a new {@link Controller} that a potential view can communicate with objects in the model through
	 */
	public Controller() {
		this.cashRegister = new CashRegister();
	}
	
	/**
	 * Creates a new {@link Sale} object by calling the {@link CashRegister}
	 * @return
	 */
	public void startNewSale() {
		
		cashRegister.newSale();
	}
	
	/**
	 * Registers {@link Item} in ongoing {@link Sale} by calling the corresponding method in {@link CashRegister}
	 * @param itemIdentifier
	 * @return the {@link Item} that corresponds with the itemIdentifier
	 * @throws ItemNotFoundException 
	 */
	public ItemDTO registerItem(long itemIdentifier) throws ItemNotFoundException, DatabaseFailureException {
		
		try {
			return cashRegister.registerItem(itemIdentifier);
		} catch (ItemNotFoundException e) {
			throw new ItemNotFoundException("still not found");
		}
		catch (DatabaseFailureException e) {
			throw new DatabaseFailureException("Failed connection to database");
		}
	}
	
	/**
	 * Confirms that all {@link Item}'s in ongoing {@Sale} has been registered and ends the {link @Sale}
	 * @param sale
	 * @return the {@link Sale} that has been completed
	 */
    public SaleDTO terminateSale()
    {
        return cashRegister.terminateSale();
    }
    
    /**
     * Creates a new {@link Receipt} based on current sale that has been completed
     * @param sale
     * @return a new {@link Receipt} that includes information about the completed sale
     */
	public void getReceipt(SaleDTO saleDTO) {
		
		Receipt receipt = cashRegister.printReceipt(cashRegister.getSaleDTO());
		printReceipt(receipt);
	}

	public void updateSale(ItemDTO lastItem) {
		cashRegister.updateSale(lastItem);
	}

	public SaleDTO getSaleDTO() {
		return cashRegister.getSaleDTO();
	}
	
	public void printReceipt(Receipt receipt) {
		System.out.println(receipt.toString());
	}
	

}
