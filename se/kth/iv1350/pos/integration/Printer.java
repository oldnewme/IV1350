package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.model.*;

public class Printer {
	private int receiptsLeft = 100;
	
	/**
	 * Creates a new instance of {@link Printer} which represents a printer in a {@link CashRegister}
	 */
	public Printer() {
		
	}
	
	/**
	 * Prints a receipt based on {@link Sale} that has been made at {@link CashRegister}
	 * @param sale
	 * @return receipt
	 */
	public Receipt printReceipt(Sale sale) {
		if(receiptsLeft < 10)
			System.out.println("Please refill printer paper");
		
		return new Receipt(sale);
		
	}
}
