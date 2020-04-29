package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.controller.*;

public class View {
	
	private Controller contr;
	
	/**
     * Creates an instance of {@link View} which represents the GUI
     * @param contr The {@link Controller} that the view interacts with the program through
     */
	public View(Controller contr) {
		
		this.contr = contr;
	}
	
	
}
