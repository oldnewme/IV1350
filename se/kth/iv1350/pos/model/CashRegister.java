package se.kth.iv1350.pos.model;

import java.util.Scanner;

import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.AccountingSystem;
import se.kth.iv1350.pos.integration.InventorySystem;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.integration.Printer;

public class CashRegister {
    private double paidAmount;
    private double leftToPay;
    private double moneyInRegister;
    private Printer printer;
    private InventorySystem itemRegistry;
    private AccountingSystem accountingSystem;
    private Sale currentSale;
	
    
    /**
     * Creates a new {@link CashRegister} which initiates {@link InventorySystem} and {@link AccountingSystem}
     */
	public CashRegister() {
		paidAmount = 0;
		leftToPay = 0;
		itemRegistry = new InventorySystem();
		accountingSystem = new AccountingSystem();
		printer = new Printer();
	}
	
	/**
	 * Initiates a new {@link Sale} based when a customer arrives to the {@link CashRegister}
	 * @return the newly Created {@link Sale}
	 */
	public void newSale() {
		
		this.currentSale = new Sale();
	}
	
	/**
	 * Gets an {@link Item} based on the given identifier
	 * @param itemIdentifier
	 * @return an {@link Item} from the {@link InventorySystem}
	 */
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
	/**
	 * Ends a completed {@link Sale}
	 * @param sale the current {@link Sale} that is ongoing
	 * @return the completed {@link Sale}
	 */
    public SaleDTO terminateSale()
    {
    	
    	Scanner scanner = new Scanner(System.in);
        while(leftToPay > paidAmount) {
            System.out.println("Left to pay: " + (leftToPay - paidAmount));
            System.out.print("Please enter payment: ");
            
            leftToPay -= scanner.nextDouble();
        }
        System.out.println();

        if(paidAmount > leftToPay)
            currentSale.setChange(paidAmount - leftToPay);

        currentSale.calculateVAT();
        
        accountingSystem.logSale(currentSale);
        
        

        return new SaleDTO(currentSale);
    }
    
    /**
     * Prints a {@link Receipt} based on the completed {@link Sale}
     * @param sale
     * @return the {@link Receipt} thhat has been created summarizing the {@link Sale}
     */
    public Receipt printReceipt(SaleDTO saleDTO) {
        return printer.printReceipt(getSaleDTO());
    }
    
    private void increaseCurrentSaleAmount(double amount) {
		leftToPay += amount;
	}

	public void updateSale(Item lastItem) {
		currentSale.updateSale(lastItem);
		
	}

	public SaleDTO getSaleDTO() {
		// TODO Auto-generated method stub
		return new SaleDTO(currentSale);
	}


}
