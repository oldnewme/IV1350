package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.DTO.SaleDTO;

public class DiscountRules {
	
	public DiscountRules(){
		
	}
	
	public SaleDTO getDiscount(int customerID, SaleDTO saleDTO) {
		return saleDTO;
	}
}
