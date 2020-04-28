package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.dbhandler.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.controller.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Controller contr = new Controller();
		View view = new View(contr);
		Sale sale = contr.startNewSale();
		
		
		while(true) {
			
			System.out.println("Enter item identifier: " );
			
			long itemIdentifier = scanner.nextLong();
			
			if(itemIdentifier == 9L)
				break;
			
			Item lastRegisteredItem = contr.registerItem(itemIdentifier);
			
			if(lastRegisteredItem.getItemIdentifier() != 0L) {
				sale.updateSale(lastRegisteredItem);
			}
			
			System.out.println(sale.printItems());
		}
		
	}

}
