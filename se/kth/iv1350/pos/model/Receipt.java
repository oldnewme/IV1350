package se.kth.iv1350.pos.model;

import java.util.*;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.*;


public class Receipt {
    private double totalPrice;
    private double VAT;
    private double change;
    private ArrayList<Item> purchases;
    
    
    /**
     * Creates an object of {@link Receipt} from a {@link Sale}
     * @param sale The completed {@link Sale}
     */
	public Receipt(SaleDTO saleDTO) {
		this.totalPrice = saleDTO.getRunningTotal();
		this.VAT = saleDTO.getVAT();
		this.change = saleDTO.getChange();
		this.purchases = saleDTO.getItems();
		
	}
	
	/**
     * Custom toString method to display the receipt correctly.
     * @return String of all relevant data in correct structure.
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("-------------------------Receipt-----------------------\n");
        for (Item item : purchases) {
            s.append("- " + item.getName() + " - " + item.getQuantity() + " x - " + item.getPrice() * item.getQuantity() + ":-\n");
        }
        s.append("Total price: " + totalPrice + "\n");
        s.append("VAT: " + VAT + "\n");
        s.append("Change: " + change + "\n");

        return s.toString();
    }
}
