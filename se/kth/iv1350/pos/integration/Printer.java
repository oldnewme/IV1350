package se.kth.iv1350.pos.integration;

import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.DTO.StoreDTO;
import se.kth.iv1350.pos.model.*;

/**
 * Represents a printer that prints {@link Receipt} 
 * The class is a singleton 
 * @author cantonio
 *
 */
public class Printer {
	private static final Printer PRINTER = new Printer();
	
	private Printer() {
		
	}
	
	/**
	 * 
	 * @return PRINTER a printer that is the only instance that is produced
	 */
	public static Printer getPrinter() {
		return PRINTER;
	}
	
	/**
	 * Prints a receipt with information from a {@link SaleDTO} based 
	 * on a {@link Sale} that has been made at {@link CashRegister}
	 * @param saleDTO contains information about a sale that has just been completed
	 */
	public void printReceipt(SaleDTO saleDTO) {
		System.out.println(new Receipt(saleDTO).toString());
		
	}
}
