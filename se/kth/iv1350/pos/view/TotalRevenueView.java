package se.kth.iv1350.pos.view;

import java.util.ArrayList;

import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.model.SaleObserver;

/**
 * This class shows the total revenue after each completed sale
 * @author cantonio
 */
public class TotalRevenueView implements SaleObserver {
	
	private double totalRevenue;
	private ArrayList<SaleDTO> sales = new ArrayList<SaleDTO>();
	
	public TotalRevenueView() {
	}
	

	@Override
	public void completedSale(SaleDTO sale) {
		addSaleDTO(sale);
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("The total revenue is: " + totalRevenue);
		System.out.println("////////////////////////////////////////////////////////\n");
		
	}


	private void addSaleDTO(SaleDTO sale) {
		sales.add(sale);		
		totalRevenue = 0;
		for(SaleDTO s : sales) {
			totalRevenue += s.getRunningTotal();
		}
	}
}
