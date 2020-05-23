package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.DTO.SaleDTO;

/**
 * class that can be implemented to calculate discounts and return 
 * information with the discounted price
 * @author cantonio
 *
 */
public class DiscountRules {
	
	/**
	 * Static method to calculate discount if implemented
	 * @param customerID The identification number that identifies customer
	 * @param saleDTO The information about the sale needed to calculate discount
	 * @return saleDTO with the discounted price information
	 */
	public static SaleDTO getDiscount(int customerID, SaleDTO saleDTO) {
		return saleDTO;
	}
}
