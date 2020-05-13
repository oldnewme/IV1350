package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.DTO.SaleDTO;

/**
 * Listener interface with the purpose of receiving notifications
 * whenever a sale has been completed. Whenever a class implements
 * this interface it and an object of that class is registered it
 * will receive a notification upon completion of a sale
 * @author cantonio
 *
 */
public interface SaleObserver {
	
	/**
	 * Invoked when a sale is completed and payment has been received
	 * @param sale The completed sale
	 */
	
	void completedSale(SaleDTO sale);
	
	
}
