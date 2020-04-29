package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.integration.*;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Controller contr = new Controller();
		View view = new View(contr);
		Sale sale = contr.startNewSale();
		
		
		while(true) {
			System.out.println("Press 9 and enter to terminate sale");
			System.out.println("Enter item identifier: " );
			
			long itemIdentifier = scanner.nextLong();
			
			if(itemIdentifier == 9L)
				break;
			
			Item lastRegisteredItem = contr.registerItem(itemIdentifier);
			
			if(lastRegisteredItem.getItemIdentifier() != 0L) {
				sale.updateSale(lastRegisteredItem);
				System.out.println("\n=======================================================");
                for (Item item : sale.getItems())
                    System.out.println(item.getName() + " - " + item.getQuantity() + "x - " + item.getPrice() * item.getQuantity() + ":-");
                System.out.println(sale.getRunningTotal() + " SEK");
                System.out.println("=======================================================\n");
			}
			else
	                System.out.println("Invalid item identifier, did you enter wrong identifier?\n");

		}
		
		Receipt receipt = contr.getReceipt(contr.terminateSale(sale));
        System.out.println(receipt.toString());
		
	}

}
