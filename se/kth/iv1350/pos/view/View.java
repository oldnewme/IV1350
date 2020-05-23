package se.kth.iv1350.pos.view;

import java.util.Scanner;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.model.Receipt;

public class View {
	
	Scanner scanner = new Scanner(System.in);
	private Controller contr;
	
	/**
     * Creates an instance of {@link View} which represents the GUI
     * @param contr The {@link Controller} that the view interacts with the program through
     */
	public View(Controller contr) {
		
		this.contr = contr;
	}

	
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
				
			
			saleDTO = contr.registerItem(itemIdentifier);
			System.out.println("\n=======================================================");
          for (Item i : saleDTO.getItems())
            System.out.println(i.getName() + " - " + i.getQuantity() + "x - " + (i.getPrice()+i.getVAT()*i.getPrice()) * i.getQuantity() + ":-");
          	System.out.println(String.format("%.2f", saleDTO.getRunningTotal()) + " SEK");
          	String.format("%.2f", 1.9999);
          	System.out.println("=======================================================\n");
		}
		
		System.out.println("Did customer say they were eligible for a discount?");
		System.out.println("y/n");
		String eligebleForDiscount = scanner.next();
		
		
		if(eligebleForDiscount.equals("y")) {
			System.out.println("Enter customer ID:");
			int customerID = scanner.nextInt();
			saleDTO = contr.getDiscount(customerID, saleDTO);
			System.out.println("Total inc. VAT after discount is: " + String.format("%.2f", saleDTO.getRunningTotal()) + " SEK");
		}
		
		System.out.println("Enter amount paid");
		double amountPaid = scanner.nextDouble();
		contr.enterPayment(amountPaid, saleDTO);
		
		
	}
//		contr.startNewSale();
//		SaleDTO saleDTO = null;
//		long itemIdentifier;
//		
//		while(true) {
//			System.out.println("Press 9 and enter to terminate sale");
//			System.out.println("Enter item identifier: " );
//			
//			itemIdentifier = scanner.nextLong();
//			
//			if(itemIdentifier == 9L)
//				break;
//			
//			ItemDTO lastRegisteredItem = contr.registerItem(itemIdentifier);
//			
//			contr.updateSale(lastRegisteredItem);
//			saleDTO = contr.getSaleDTO();
//			System.out.println("\n=======================================================");
//            for (Item i : saleDTO.getItems())
//                System.out.println(i.getName() + " - " + i.getQuantity() + "x - " + i.getPrice() * i.getQuantity() + ":-");
//            System.out.println(saleDTO.getRunningTotal() + " SEK");
//            System.out.println("=======================================================\n");
//
//		}
//		
//		contr.terminateSale();
//        contr.getReceipt(saleDTO);
//	}
	
}
