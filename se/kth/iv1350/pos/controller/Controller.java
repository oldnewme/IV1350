package se.kth.iv1350.pos.controller;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.dbhandler.*;


public class Controller {
	
	private CashRegister cashRegister;
	
	public Controller() {
		this.cashRegister = new CashRegister();
	}
	
	public Sale startNewSale() {
		
		return  cashRegister.newSale();
	}
	
	public Item registerItem(long itemIdentifier) {
		
		return cashRegister.registerItem(itemIdentifier);
	}
	

	
	

}
