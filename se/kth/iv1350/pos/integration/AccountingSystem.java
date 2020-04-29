package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.Sale;
import java.util.*;

public class AccountingSystem {
	private static ArrayList<Sale> sales;
	
	/**
	 * Creates a new instance representing the accounting system
	 */
    public AccountingSystem(){ 	
        sales = new ArrayList<Sale>();
    }
    
    /**
     * Logs a sale to the {@link AccountingSystem}.
     * 
     * @param sale The sale that was just made at the {@link CashRegister}
     */
    public void logSale(Sale sale) {
    	sales.add(sale);
    }
    
    /**
     * Returns a list that is a copy of all sales recorded in the {@link AccountingSystem}.
     * @return listOfSales
     */
    public ArrayList<Sale> getListOfSales() {
    	ArrayList<Sale> listOfSales = new ArrayList<Sale>();
    	for(Sale sale : sales) {
    		listOfSales.add(sale);
    	}
    	
    	return listOfSales;
    }
}
