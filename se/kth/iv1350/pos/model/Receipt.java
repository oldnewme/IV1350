package se.kth.iv1350.pos.model;

import java.util.*;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.DTO.StoreDTO;
import se.kth.iv1350.pos.integration.*;
import java.sql.Timestamp;

/**
 * A class that represents the receipt that summarizes a sale that has been made
 * @author cantonio
 *
 */
public class Receipt {
    private double totalPrice;
    private double VAT;
    private double change;
    private StoreDTO store;
    private ArrayList<Item> purchases;
    
    

    /**
     * Creates an object of {@link Receipt} from a {@link SaleDTO}
     * @param saleDTO Data transfer object containing information on the completed {@link Sale}
     * @param store The store in which the {@link Sale} has been completed
     */
	public Receipt(SaleDTO saleDTO) {
		this.totalPrice = saleDTO.getRunningTotal();
		this.VAT = saleDTO.getVAT();
		this.change = saleDTO.getChange();
		this.purchases = saleDTO.getItems();
		this.store = new StoreDTO("ICA Maxi", "Storvägen 13, 154 43, Markaryd");
		
	}
	
	/**
     * Custom toString method to display the receipt correctly.
     * @return String of all relevant data in correct structure.
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("-------------------------Receipt-----------------------\n");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        s.append(timestamp.toString() + "\n");
        s.append(store.getName() + "\n");
        s.append(store.getAddress() + "\n");
        for (Item item : purchases) {
            s.append("- " + item.getName() + " - " + item.getQuantity() + " x - " + (item.getPrice()+item.getPrice()*item.getVAT()) * item.getQuantity() + ":-\n");
        }
        s.append("Total price: " + String.format("%.2f", totalPrice) + "\n");
        s.append("VAT: " + String.format("%.2f", VAT) + "\n");
        s.append("Change: " + String.format("%.2f", change) + "\n");

        return s.toString();
    }
}
