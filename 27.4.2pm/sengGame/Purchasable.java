package sengGame;

public class Purchasable {
	private double buyPrice;
	private double sellPrice;
	private String description;
	
	// Constructor methods
	public Purchasable() {
		buyPrice = 100;
		sellPrice = 50;
		description = "Default Item";
	}
	
	public Purchasable(double buy, double sell, String describe) {
		buyPrice = buy;
		sellPrice = sell;
		description = describe;
	}
	
	//  getters
	public double getBuyPrice() {
		return buyPrice;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public String getDescription() {
		return description;
	}
}
