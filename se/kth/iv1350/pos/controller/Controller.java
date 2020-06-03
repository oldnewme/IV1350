package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.*;
import se.kth.iv1350.pos.model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.kth.iv1350.pos.view.TotalRevenueView;

/**
 * Controls the program and separates the view from the model
 * All method calls to the model from the view passes the {@link Controller}
 */
public class Controller {
	
	private CashRegister cashRegister;
	private AccountingSystem accountingSystem;
	private Printer printer;
	final static Logger logger = Logger.getAnonymousLogger();
	
	/**
	 * Creates a new {@link Controller} that a view can communicate with objects in the model through
	 * @param cashRegister The cashRegister that handles each new sale
	 */
	public Controller(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
		this.accountingSystem = new AccountingSystem();
		this.printer = Printer.getPrinter();
	}
	
	/**
	 * Calls on the {@link CashRegister} to start a new sale
	 */
	public void startNewSale() {
		cashRegister.startNewSale();
	}
	
	/**
	 * Registers {@link Item} in ongoing {@link Sale} by calling the corresponding method in {@link CashRegister}
	 * @param itemIdentifier identifies the scanned {@link Item}
	 * @return saleDTO contains information about current {@link Sale}
	 * @throws OperationFailedException a general exception that can be used for different errors the user does not need to know in detail
	 * @throws ItemNotFoundException is thrown when the itemIdentifier doesn't correspond to any {@link Item} in the inventory
	 */
	
	public SaleDTO registerItem(long itemIdentifier) throws OperationFailedException, ItemNotFoundException {
		try {
			return cashRegister.registerItem(itemIdentifier);			
		}
		catch (DatabaseFailureException e) {

			System.out.println("Developer log: ");
			logger.log(Level.SEVERE, "an exception was thrown", e);
			throw new OperationFailedException("Failed connection to database");
			
		}
		catch (ItemNotFoundException e) {
			
			
			System.out.println("Developer log: ");
			logger.log(Level.SEVERE, "an exception was thrown", e);
			throw new ItemNotFoundException("Item not in inventory");
		}
		
	}
	
	/**
	 * Calls on the {@link  CashRegister} to end the currentSale
	 * @return a SaleDTO that contains information about the finished sale
	 */
	public SaleDTO endSale() {
		
		return cashRegister.endSale();
	}
	
	/**
	 * Calls on {@link  CashRegister} to apply discount to the ongoing sale
	 * @param customerID  the identification number of the current customer
	 * @param saleDTO the current ongoing {@link Sale}
	 * @return a {@link SaleDTO} with discount deducted when customer is eligible
	 */
	public SaleDTO getDiscount(int customerID, SaleDTO saleDTO) {
		
		return cashRegister.getDiscount(customerID, saleDTO);
	}
	
	/**
	 * Adds an observer to
	 * @param totalRevenueView is the view that will continually show the updated revenue
	 */
	public void addSaleObserver(TotalRevenueView totalRevenueView) {
		cashRegister.addSaleObserver(totalRevenueView);
		
	}
	
	
	/**
	 * Calls on {@link  CashRegister} to add payment
	 * @param amountPaid paid amount by customer
	 * @param saleDTO contains information about the current sale
	 */
	public void enterPayment(double amountPaid, SaleDTO saleDTO) {
		logSale(saleDTO);
		saleDTO = cashRegister.enterPayment(amountPaid, saleDTO);
		printReceipt(saleDTO);
	}
	
	private void logSale(SaleDTO saleDTO) {
		accountingSystem.logSale(saleDTO);
	}
	
	private void printReceipt(SaleDTO saleDTO) {
		printer.printReceipt(saleDTO);	
	}
}
