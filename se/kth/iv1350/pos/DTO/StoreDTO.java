package se.kth.iv1350.pos.DTO;

public class StoreDTO {
	private String name;
	private String address;
	
	
	public StoreDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
}
