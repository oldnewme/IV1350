package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.controller.*;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Controller contr = new Controller();
		View view = new View(contr);
		while(true) {
			view.userInteraction();
			System.out.println("Press 1 to exit system or press any other integer to start new sale");
			if(scanner.nextInt() == 1)
				break;
		}
		
	}

}
