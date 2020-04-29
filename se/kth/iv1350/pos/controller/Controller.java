package se.kth.iv1350.pos.controller;
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
	public Sale startNewSale() {
		
		return  cashRegister.newSale();
	}
	
	/**
	 * Registers {@link Item} in ongoing {@link Sale} by calling the corresponding method in {@link CashRegister}
	 * @param itemIdentifier
	 * @return the {@link Item} that corresponds with the itemIdentifier
	 */
	public Item registerItem(long itemIdentifier) {
		
		return cashRegister.registerItem(itemIdentifier);
	}
	
	/**
	 * Confirms that all {@link Item}'s in ongoing {@Sale} has been registered and ends the {link @Sale}
	 * @param sale
	 * @return the {@link Sale} that has been completed
	 */
    public Sale terminateSale(Sale sale)
    {
        return cashRegister.terminateSale(sale);
    }
    
    /**
     * Creates a new {@link Receipt} based on current sale that has been completed
     * @param sale
     * @return a new {@link Receipt} that includes information about the completed sale
     */
	public Receipt getReceipt(Sale sale) {
		
		return cashRegister.printReceipt(sale);
	}
	
	
	

}
