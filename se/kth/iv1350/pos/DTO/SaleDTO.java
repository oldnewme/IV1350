package se.kth.iv1350.pos.DTO;

import java.util.ArrayList;

import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.model.Sale;

/**
 * An data transfer object which is used to pass information about
 * an {@link Sale} across different layers in the architecture
 * @author cantonio
 *
 */
public class SaleDTO {
	
	private double runningTotal = 0;
    private double VAT = 0;
    private double change = 0;
    private ArrayList<Item> itemsInSale;
    
    /**
     * Instantiates an {@link SaleDTO} based on an {@link Sale}
     * @param sale the sale that the DTO will copy information from
     */
    public SaleDTO(Sale sale) {
		this.runningTotal = sale.getRunningTotal();
		this.VAT = sale.getVAT();
		this.change = sale.getChange();
		this.itemsInSale = sale.getItems();
	}
    
    /**
     * Gets the running total of the {@link Sale}
     * @return the runningtotal of the {@link Sale}
     */
	public double getRunningTotal() {
		return runningTotal;
	}
	
	/**
	 * Gets the total VAT of a {@link Sale}
	 * @return the total VAT of the {@link Sale}
	 */
	public double getVAT() {
		return VAT;
	}
	
	/**
	 * Gets the change that {@link Sale} will provide
	 * @return the change that is due after a {@link Sale} has been made
	 */
	public double getChange() {
		return change;
	}
	
	/**
	 * Gets the items that are in a {@link Sale}
	 * @return the items that are in the basket of that {@link Sale}
	 */
	public ArrayList<Item> getItems() {
		return itemsInSale;
	}
    
    
}
