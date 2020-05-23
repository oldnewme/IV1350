package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.model.*;

public class Main {
	
	public static void main(String[] args) {
		
		CashRegister cashRegister = new CashRegister();
		Controller contr = new Controller(cashRegister);
		View view = new View(contr);
		
		view.userInteraction();
	}

}
