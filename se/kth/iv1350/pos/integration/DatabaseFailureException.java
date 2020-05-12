package se.kth.iv1350.pos.integration;

public class DatabaseFailureException extends RuntimeException{
	public DatabaseFailureException(String message) {
		super(message);
	}
}
