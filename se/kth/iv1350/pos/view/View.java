package se.kth.iv1350.pos.view;

import java.util.Scanner;

import se.kth.iv1350.pos.DTO.ItemDTO;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.integration.DatabaseFailureException;
import se.kth.iv1350.pos.integration.Item;
import se.kth.iv1350.pos.integration.ItemNotFoundException;
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
		SaleDTO saleDTO = null;
		long itemIdentifier;
		
		while(true) {
			System.out.println("Press 9 and enter to terminate sale");
			System.out.println("Enter item identifier: " );
			
			itemIdentifier = scanner.nextLong();
			
			if(itemIdentifier == 9L)
				break;
			
			ItemDTO lastRegisteredItem = null;
			try {
				lastRegisteredItem = contr.registerItem(itemIdentifier);
			} catch (ItemNotFoundException e) {
				System.out.println("=======================================================");
				System.out.println("Item not in inventory, please enter valid identifier.");
				System.out.println("=======================================================\n");

			}
			catch (DatabaseFailureException e) {
				System.out.println("=======================================================");
				System.out.println("Item was not added to sale, please try again");
				System.out.println("=======================================================\n");
			}
			
			if(lastRegisteredItem == null)
					continue;
			
			contr.updateSale(lastRegisteredItem);
			saleDTO = contr.getSaleDTO();
			System.out.println("\n=======================================================");
            for (Item i : saleDTO.getItems())
                System.out.println(i.getName() + " - " + i.getQuantity() + "x - " + i.getPrice() * i.getQuantity() + ":-");
            System.out.println(saleDTO.getRunningTotal() + " SEK");
            System.out.println("=======================================================\n");

		}
		
		contr.terminateSale();
        contr.getReceipt(saleDTO);
	}
	
}
