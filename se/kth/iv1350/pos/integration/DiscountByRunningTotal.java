package se.kth.iv1350.pos.integration;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.model.Discount;

/**
 * Implemented using the strategy pattern and is a dicount algorithm for when 
 * the running total exceeds 200:-
 * @author cantonio
 *
 */
public class DiscountByRunningTotal implements Discount{
	private double discountLimit = 200;
	/**
	 * creates an instance of the Discount by total price.
	 * 
	 * @param totalPrice	the total <code>Amount<code> that is required for the 
	 * 						discount to apply.
	 */
	public DiscountByRunningTotal () {
	}
	
	@Override
	public boolean discountEligible(SaleDTO sale, int customerID) {
		return discountLimit <= sale.getRunningTotal();
	}

	@Override
	public double calculateDiscount(SaleDTO sale) {
		return sale.getRunningTotal() * 0.8;
	}
}
