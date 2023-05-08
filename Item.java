package sengGame;

public class Item extends Purchasable{
	private String name;
	//3 MAIN types: Stamina,Offence,Defence
	//STA,ATK,DEF
	// Special items ATK up but DEF down or other way around.  ALL stats up?
	private String type;
	private int effect;
	
	//Constructors
	public Item() {
		super();
		name = "Default item";
		type = "Stamina";
		effect = 10;
	}
	
	public Item(String defName, String defType, int defEffect, int cost) {
		//For now the sell price is the buy price - 10,000 * difficulty
		super(cost*10,cost*8,String.format("%s is a %s item", defName,defType));
		name = defName;
		type = defType;
		effect = defEffect;
	}
	
	// override toString
	@Override
	public String toString() {
		return String.format("%s changes %s by %s",name,type,effect);
	}
	
	
	//Getters
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getEffect() {
		return effect;
	}
	
	
	//Main method for testing
	public static void main(String[] args) {
		Item ite = new Item();
		System.out.println(ite);
	}
}
