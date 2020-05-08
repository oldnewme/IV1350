package se.kth.iv1350.pos.DTO;

import java.util.ArrayList;

import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.model.Sale;

public class SaleDTO {
	
	private double runningTotal = 0;
    private double VAT = 0;
    private double change = 0;
    private ArrayList<Item> itemsInSale;
    
    public SaleDTO(Sale sale) {
		this.runningTotal = sale.getRunningTotal();
		this.VAT = sale.getVAT();
		this.change = sale.getChange();
		this.itemsInSale = sale.getItems();
	}

	public double getRunningTotal() {
		return runningTotal;
	}

	public double getVAT() {
		return VAT;
	}

	public double getChange() {
		return change;
	}

	public ArrayList<Item> getItems() {
		return itemsInSale;
	}
    
    
}
