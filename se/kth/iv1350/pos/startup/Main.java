package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.view.*;
import se.kth.iv1350.pos.controller.*;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Controller contr = new Controller();
		View view = new View(contr);
		view.userInteraction();
	}

}
