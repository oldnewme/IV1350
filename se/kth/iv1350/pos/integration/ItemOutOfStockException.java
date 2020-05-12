package se.kth.iv1350.pos.integration;

public class ItemOutOfStockException extends Exception {
	public ItemOutOfStockException(String message) {
		super(message);
	}
}
