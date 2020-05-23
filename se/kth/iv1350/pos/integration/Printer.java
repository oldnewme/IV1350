package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.DTO.StoreDTO;
import se.kth.iv1350.pos.model.*;

/**
 * Represents a printer that prints {@link Receipts}
 * @author cantonio
 *
 */
public class Printer {
	private StoreDTO store;
	
	/**
	 * Creates a new instance of {@link Printer} which represents a printer in a {@link CashRegister}
	 */
	public Printer() {
		this.store = new StoreDTO("ICA Maxi", "Storvägen 13, 154 43, Markaryd");
	}
	
	/**
	 * Prints a receipt based on {@link Sale} that has been made at {@link CashRegister}
	 * @param sale
	 * @return receipt
	 */
	
	/**
	 * Prints a receipt with information from a {@link SaleDTO} based 
	 * on a {@link Sale} that has been made at {@link CashRegister}
	 * @param saleDTO contains information about a sale that has just been completed
	 */
	public void printReceipt(SaleDTO saleDTO) {
		System.out.println(new Receipt(saleDTO, store).toString());
		
	}
}
