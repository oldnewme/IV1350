package se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import se.kth.iv1350.pos.DTO.CustomerDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.model.Discount;
/**
 * A class that handles the implementation of discounts
 * @author cantonio
 *
 */
public class DiscountHandler {
	private ArrayList<Discount> discounts = new ArrayList<>();
	
	/**
	 * initiates a discounthandler object and initiates the discounts implemented with the strategy pattern
	 */
	public DiscountHandler(){
		createDiscounts();
	}
	
	private void createDiscounts() {
		discounts.add(new DiscountByRunningTotal());
		
		ArrayList<CustomerDTO> customers = new ArrayList<>();
		customers.add(new CustomerDTO("Christian", 1234));
		discounts.add(new GoldCustomers(customers));
	}
	
	/**
	 * Returns list containing discounts that are applicable
	 * @param sale a SaleDTO with info on current sale
	 * @param customerID the id of the customer
	 * @return list containing applicable discounts
	 */
	public ArrayList<Discount> checkDiscounts(SaleDTO sale, int customerID){
		ArrayList<Discount> applicableDiscounts = new ArrayList<>();
		for(Discount discount : discounts) 
			if(discount.discountEligible(sale, customerID))
				applicableDiscounts.add(discount);
		return applicableDiscounts;
	}
} 
