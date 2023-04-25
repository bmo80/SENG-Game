package sengGame;

public class Item {
	private String name;
	//4 types: Stamina,Offence,Defence,Health - use ENUM???
	private String type;
	private int effect;
	
	//Constructors
	public Item() {
		name = "Default item";
		type = "Stamina";
		effect = 10;
	}
	
	public Item(String defName, String defType, int defEffect) {
		name = defName;
		type = defType;
		effect = defEffect;
	}
	
	// override toString
	@Override
	public String toString() {
		return String.format("The %s changes %s by %s",name,type,effect);
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
