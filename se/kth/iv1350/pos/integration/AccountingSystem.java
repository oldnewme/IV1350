package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.DTO.SaleDTO;
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
     * @param saleDTO The {@link Sale} that was just completed
     */
    
	public void logSale(SaleDTO saleDTO) {
		sales.add(new Sale(saleDTO));
		
	}
}
