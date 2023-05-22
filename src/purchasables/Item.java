package purchasables;

public class Item extends Purchasable{
	/**
	 * Stores name of the Item
	 */
	private String name;
	/**
	 * Stores the type of the Item
	 */
	private String type;
	/**
	 * Stores the effect of the Item
	 */
	private int effect;
	
	/**
	 * Default Constructor for the Item Class. Calls the parent
	 * Class purchasable and sets the things specific to items
	 */
	public Item() {
		super();
		name = "NULL";
		type = "Stamina";
		effect = 10;
	}
	
	/**
	 * Overloaded Constructor for Item Class. Allows for Creation of a
	 * custom Item. Invokes the parent class purchasable as well.
	 * @param defName name of the item
	 * @param defType the type the item will be
	 * @param defEffect the effect the item will have
	 * @param cost the cost of the item
	 */
	public Item(String defName, String defType, int defEffect, int cost) {
		//For now the sell price is the buy price - 10,000 * difficulty
		super(cost * 10, cost * 8, 
				String.format("%s is for %s", defName, defType));
		name = defName;
		type = defType;
		effect = defEffect;
	}
	
	
	/**
	 * Gets the name of the Item
	 * @return name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets the item type
	 * @return the item type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the items effect
	 * @return the items effect
	 */
	public int getEffect() {
		return effect;
	}
	
	/**
	 * allows to set a custom name for an item.
	 * @param newName the custom name to be set for the item
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Allows you to set a custom type for the item
	 * @param newType the type you wish the item to be
	 */
	public void setType(String newType) {
		type = newType;
	}
	
	/**
	 * Set a custom effect level for the item
	 * @param newEffect the value that the respective stat will be affected
	 */
	public void setEffect(int newEffect) {
		effect = newEffect;
	}
	
}
