package se.kth.iv1350.pos.view;

import java.util.Scanner;

import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.integration.ItemNotFoundException;
import se.kth.iv1350.pos.integration.OperationFailedException;

/**
 * This class represents the view that the user interacts through.
 * @author cantonio
 *
 */
public class View {
	
	Scanner scanner = new Scanner(System.in);
	private Controller contr;
	
	/**
     * Creates an instance of {@link View} which represents the GUI
     * @param contr The {@link Controller} that the view interacts with the program through
     */
	public View(Controller contr) {
		
		this.contr = contr;
		contr.addSaleObserver(new TotalRevenueView());
	}

	/**
	 * Simulates the user interaction by starting a sale and letting the user
	 * add items to sale and then end.
	 */
	public void userInteraction(){
		contr.startNewSale();
		long itemIdentifier;
		SaleDTO saleDTO = null;
		
		while(true) {
			System.out.println("Press 9 and enter to terminate sale");
			System.out.println("Enter item identifier: " );
			itemIdentifier = scanner.nextLong();
			if(itemIdentifier == 9L) {
				saleDTO = contr.endSale();
				double total = saleDTO.getRunningTotal();
				System.out.println("Total inc. VAT is: " + String.format("%.2f", total));
				break;
			}
				
			try {
				saleDTO = contr.registerItem(itemIdentifier);
				
			}
			catch (OperationFailedException e) {
				
				System.out.println("User log: ");
				System.out.println("=======================================================");
				System.out.println("Item was not added to sale, please try again");
				System.out.println("=======================================================\n");
			}
			catch (ItemNotFoundException e) {
				System.out.println("User log: ");
				System.out.println("=======================================================");
				System.out.println("Item not in inventory, please enter valid identifier.");
				System.out.println("=======================================================\n");
			}
			
			if(saleDTO == null)
				continue;
			
			System.out.println("\n=======================================================");
          for (Item i : saleDTO.getItems())
            System.out.println(i.getName() + " - " + i.getQuantity() + "x - " + (i.getPrice()+i.getVAT()*i.getPrice()) * i.getQuantity() + ":-");
          	System.out.println(String.format("%.2f", saleDTO.getRunningTotal()) + " SEK");
          	String.format("%.2f", 1.9999);
          	System.out.println("=======================================================\n");
		}
		
		
		/*	If discounts are implemented
			
			System.out.println("Did customer say they were eligible for a discount?");
			System.out.println("y/n");
			String eligebleForDiscount = scanner.next();
			
			
			if(eligebleForDiscount.equals("y")) {
				System.out.println("Enter customer ID:");
				int customerID = scanner.nextInt();
				saleDTO = contr.getDiscount(customerID, saleDTO);
				System.out.println("Total inc. VAT after discount is: " + String.format("%.2f", saleDTO.getRunningTotal()) + " SEK");
			}
		
		*/
		
		System.out.println("Enter amount paid");
		double amountPaid = scanner.nextDouble();
		contr.enterPayment(amountPaid, saleDTO);
	
		}
	
}
