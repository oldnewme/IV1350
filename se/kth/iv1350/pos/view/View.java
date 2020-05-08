package se.kth.iv1350.pos.view;

import java.util.Scanner;

import se.kth.iv1350.pos.controller.*;

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
	
	public void startNewSale() {
		contr.startNewSale();
	}
	
	public void registerItem(long itemIdentifier) {
		contr.registerItem(itemIdentifier);
	}
	
}
