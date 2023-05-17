package athleteInfo;

public class Purchasable {
	private int buyPrice;
	private int sellPrice;
	private String description;
	
	// Constructor methods
	public Purchasable() {
		buyPrice = 100;
		sellPrice = 50;
		description = "Default Item";
	}
	
	public Purchasable(int buy, int sell, String describe) {
		buyPrice = buy;
		sellPrice = sell;
		description = describe;
	}
	
	//  getters
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public int getSellPrice() {
		return sellPrice;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setBuyPrice(int price) {
		buyPrice = price;
	}
}
