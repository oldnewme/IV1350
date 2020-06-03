package se.kth.iv1350.pos.model;


import java.util.ArrayList;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.DatabaseFailureException;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.integration.ItemNotFoundException;

/**
 * This class represents the cash register that handles each ongoing sale
 * @author cantonio
 *
 */
public class CashRegister {
	private ArrayList<SaleObserver> saleObservers = new ArrayList<>();
	private Sale currentSale;
	private InventorySystem inventory;
	private double amountInRegister;
	
    
    /**
     * Creates a new {@link CashRegister} which initiates {@link InventorySystem} and {@link DiscountRules}
     */
	public CashRegister() {
		inventory = new InventorySystem();
	}
	
	/**
	 * Initiates a new {@link Sale} in the cashRegister
	 */
	public void startNewSale() {
		currentSale = new Sale();
	}
	
	/**
	 * Registers each item that is scanned in the view to the current sale
	 * @param itemIdentifier identifies the scanned Item
	 * @return currentSaleDTO information about the ongoing sale
	 * @throws DatabaseFailureException is thrown when the {@link InventorySystem} class cannot connect to database
	 * @throws ItemNotFoundException is thrown when the itemIdentifier doesn't correspond to any {@link Item} in the inventory
	 */
	
	public SaleDTO registerItem(long itemIdentifier) throws DatabaseFailureException, ItemNotFoundException {
		ItemDTO itemDTO = inventory.getItem(itemIdentifier);
		currentSale.updateSale(itemDTO);
		currentSale.calculateVAT();
		SaleDTO currentSaleDTO = new SaleDTO(currentSale);
		return currentSaleDTO;
	}
	
	/**
	 * Ends the ongoing sale
	 * @return a new saleDTO containing information about the current sale
	 */
	public SaleDTO endSale() {

		return new SaleDTO(currentSale);
	}
	
	/**
	 * Calls {@link DiscountRules} to apply discount to current sale
	 * @param customerID the identification number of the current customer
	 * @param saleDTO information about the current sale
	 * @return a {@link SaleDTO} with discount deducted when customer is eligible
	 */
	public SaleDTO getDiscount(int customerID, SaleDTO saleDTO) {
		return DiscountRules.getDiscount(customerID, saleDTO);
	}
	
	/**
	 * Registers payment from customer and possibly updates inventory and updates the amount in the cashregister
	 * @param amountPaid paid amount by customer
	 * @param saleDTO contains information about the current sale
	 * @return a new {@link SaleDTO} containing information about current sale including information about change
	 */
	public SaleDTO enterPayment(double amountPaid, SaleDTO saleDTO) {
		updateInventory(saleDTO);
		double change = calculateChange(amountPaid, currentSale.getRunningTotal());
		setChangeInCurrentSale(change);
		updateAmountInRegister(amountPaid, currentSale.getChange());
		notifyObservers();
		return saleDTO = new SaleDTO(currentSale);
	}
	
	/**
	 * Used to add observers of the CashRegister class
	 * @param obs is the observer to be added
	 */
	public void addSaleObserver(SaleObserver obs) {
		saleObservers.add(obs);
	}
	
	private void notifyObservers() {
		for(SaleObserver obs : saleObservers) {
			obs.completedSale(new SaleDTO(currentSale));
		}
	}
	
	private void updateInventory(SaleDTO saleDTO) {
		inventory.updateIventory(saleDTO);
	}
	
	private void setChangeInCurrentSale(double change) {
		currentSale.setChange(change);
	}
	
	private double calculateChange(double amountPaid, double finalTotal) {
		return (amountPaid - finalTotal);
	}
	
	private void updateAmountInRegister(double amountPaid, double change) {
		amountInRegister += amountPaid - change;
	}
	
}
