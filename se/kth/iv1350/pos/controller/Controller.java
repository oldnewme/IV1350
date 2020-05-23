package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;

/**
 * Controls the program and separates the {@link View} from the {@link Model}. 
 * All method calls to the {@link Model} from the {@link View} passes the {@link Controller}
 */
public class Controller {
	
	private CashRegister cashRegister;
	private AccountingSystem accountingSystem;
	private Printer printer;
	
	
	/**
	 * Creates a new {@link Controller} that a view can communicate with objects in the model through
	 * @param cashRegister The cashRegister that handles each new sale
	 */
	public Controller(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
		this.accountingSystem = new AccountingSystem();
		this.printer = new Printer();
	}
	
	/**
	 * Calls on the {@link CashRegister} to start a new sale
	 */
	public void startNewSale() {
		cashRegister.startNewSale();
	}
	
	/**
	 * Registers {@link Item} in ongoing {@link Sale} by calling the corresponding method in {@link CashRegister}
	 * @param itemIdentifier
	 * @return saleDTO
	 */
	public SaleDTO registerItem(long itemIdentifier) {
	
		return cashRegister.registerItem(itemIdentifier);
	}
	
	public SaleDTO endSale() {
		
		return cashRegister.endSale();
	}

	public SaleDTO getDiscount(int customerID, SaleDTO saleDTO) {
		
		return cashRegister.getDiscount(customerID, saleDTO);
	}

	public void enterPayment(double amountPaid, SaleDTO saleDTO) {
		accountingSystem.logSale(saleDTO);
		saleDTO = cashRegister.enterPayment(amountPaid, saleDTO);
		printer.printReceipt(saleDTO);
		
	}
	
	
	
//
//	/**
//	 * Creates a new {@link Sale} object by calling the {@link CashRegister}
//	 * @return
//	 */
//	public void startNewSale() {
//		
//		cashRegister.newSale();
//	}
//	
//	/**
//	 * Registers {@link Item} in ongoing {@link Sale} by calling the corresponding method in {@link CashRegister}
//	 * @param itemIdentifier
//	 * @return the {@link Item} that corresponds with the itemIdentifier
//	 */
//	public ItemDTO registerItem(long itemIdentifier) {
//		
//		return cashRegister.registerItem(itemIdentifier);
//	}
//	
//	/**
//	 * Confirms that all {@link Item}'s in ongoing {@Sale} has been registered and ends the {link @Sale}
//	 * @param sale
//	 * @return the {@link Sale} that has been completed
//	 */
//    public SaleDTO terminateSale()
//    {
//        return cashRegister.terminateSale();
//    }
//    
//    /**
//     * Creates a new {@link Receipt} based on current sale that has been completed
//     * @param sale
//     * @return a new {@link Receipt} that includes information about the completed sale
//     */
//	public void getReceipt(SaleDTO saleDTO) {
//		
//		Receipt receipt = cashRegister.printReceipt(cashRegister.getSaleDTO());
//		printReceipt(receipt);
//	}
//
//	public void updateSale(ItemDTO lastItem) {
//		cashRegister.updateSale(lastItem);
//	}
//
//	public SaleDTO getSaleDTO() {
//		return cashRegister.getSaleDTO();
//	}
//	
//	public void printReceipt(Receipt receipt) {
//		System.out.println(receipt.toString());
//	}
//	

}
