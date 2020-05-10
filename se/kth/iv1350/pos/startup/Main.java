package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.integration.*;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Controller contr = new Controller();
		View view = new View(contr);
		view.startNewSale();
		SaleDTO saleDTO;
		long itemIdentifier;
		
		
		while(true) {
			System.out.println("Press 9 and enter to terminate sale");
			System.out.println("Enter item identifier: " );
			
			itemIdentifier = scanner.nextLong();
			
			if(itemIdentifier == 9L)
				break;
			
			Item lastRegisteredItem = contr.registerItem(itemIdentifier);
			
			contr.updateSale(lastRegisteredItem);
			saleDTO = contr.getSaleDTO();
			System.out.println("\n=======================================================");
            for (Item i : saleDTO.getItems())
                System.out.println(i.getName() + " - " + i.getQuantity() + "x - " + i.getPrice() * i.getQuantity() + ":-");
            System.out.println(saleDTO.getRunningTotal() + " SEK");
            System.out.println("=======================================================\n");

		}
		
		Receipt receipt = contr.getReceipt(contr.terminateSale());
        System.out.println(receipt.toString());
		
	}

}
