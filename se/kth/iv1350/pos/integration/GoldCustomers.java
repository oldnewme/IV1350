package se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import se.kth.iv1350.pos.DTO.CustomerDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.model.Discount;
/**
 * This class contains a list of customerDTOs representing
 * customers that are regarded as special customers
 * @author cantonio
 *
 */
public class GoldCustomers implements Discount {
	private ArrayList<CustomerDTO> customers;
	
	
	/**
	 * Creates an instance of discount for store members.
	 * @param storeMembers		the list of store members.
	 */
	public GoldCustomers(ArrayList<CustomerDTO> customers){
		this.customers = customers;
	}
	/**
	 * Checks if customer is a gold customer
	 * return a boolean stating if it is a gold customer
	 */
	@Override
	public boolean discountEligible(SaleDTO sale, int customerID) {
		for(CustomerDTO customer : customers) {
			if(customer.getID() == customerID)
				return true;
		}
		return false;
	}
	
	/**
	 * calculates discount for goldcustomers with 25% of
	 * return a double with the discounted price
	 */
	@Override
	public double calculateDiscount(SaleDTO sale) {
		return sale.getRunningTotal() * 0.75;
	} 
	
	
	
	
}
