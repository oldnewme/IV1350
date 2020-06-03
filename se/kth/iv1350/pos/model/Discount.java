package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.DTO.SaleDTO;
/**
 * The interface used to implement discounts based on different criteria
 * @author cantonio
 *
 */
public interface Discount {
	
	/**
	 * Classes implementing this interface can check if the sale/customer is eligeble for a discount
	 * @param sale a SaleDTO that contains info on the sale
	 * @param customerID the customerID connected to a customer
	 * @return a boolean that shows if sale/customer is eligeble for discount
	 */
	public boolean discountEligible(SaleDTO sale, int customerID);
	
	
	/**
	 * Classes implementing this interface can calculate the 
	 * @param sale a SaleDTO that contains info on the sale
	 * @return double the new price calculated after the discount
	 */
	public double calculateDiscount(SaleDTO sale);
}
