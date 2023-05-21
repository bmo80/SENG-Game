package athleteInfo;

public class Purchasable {
	private int buyPrice;
	private int sellPrice;
	private String description;
	
	/**
	 * Default Constructor for Purchasable.
	 * Sets a default buy and sell price aswell as a description
	 */
	public Purchasable() {
		buyPrice = 100;
		sellPrice = 50;
		description = "Default Item";
	}
	
	/**
	 * Overloaded Constructor for Purchasable.
	 * Allows for Custom prices and description to be set
	 * @param buy Buy price to be set
	 * @param sell Sell price to be set
	 * @param describe description to be set
	 */
	public Purchasable(int buy, int sell, String describe) {
		buyPrice = buy;
		sellPrice = sell;
		description = describe;
	}
	
	/**
	 * Gets the Buy price of the product
	 * @return the buy price
	 */
	public int getBuyPrice() {
		return buyPrice;
	}
	
	/**
	 * Gets the Sell price of the product
	 * @return the sell price
	 */
	public int getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Gets the description of the product
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * used to change the buy price after product creation
	 * @param price the buy price to be set
	 */
	public void setBuyPrice(int price) {
		buyPrice = price;
	}
	
	/**
	 * used to change the sell price after product creation
	 * @param price the sell price to be set
	 */
	public void setSellPrice(int price) {
		sellPrice = price;
	}
}
