package sengGame;

public class Athlete extends Purchasable {
	private String name;
	private int stamina;
	private int offence;
	private int defence;
	private int health;
	// could change to int
	private String position;
	private boolean isInjured;
	private int previousInjuries;
	
	// Constructors
	public Athlete(){
		super();
		name = "Default Athlete";
		stamina = 10; 
		offence = 5;
		defence = 5;
		health = 100;
		position = "D";
		isInjured = false;
		previousInjuries = 0;		
	}
	
	public Athlete(String setName, int setOffence, int setDefence, String setPosition) {
		super(150,100,setName);
		name = setName;
		stamina = 10;
		// Put checks in place
		offence = setOffence;
		defence = setDefence;
		health = 100;
		// put check in place
		position = setPosition;
		isInjured = false;
		previousInjuries = 0;		
	}
	
	//Over
	@Override
	public String toString() {
		return String.format("%s has an Offence stat of %s, a Defence stat of %s"
				+ " and is in position %s.\nThey have %s stamina, %s health, %s"
				+ " previous injuries and are currently" + (isInjured?"":" not") + " injured"
				+ "",name, offence, defence, position, stamina, health, previousInjuries);
	}
	
	// getter methods
	public String getName() {
		return name;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public int getOffence() {
		return offence;
	}
	
	public int getDefence() {
		return defence;
	}
	
	public int getHealth() {
		return health;
	}
	
	public String getPosition() {
		return position;
	}
	
	public boolean getIsInjured() {
		return isInjured;
	}
	
	public int getPreviousInjuries() {
		return previousInjuries;
	}
	
	// Setter methods - add changeName/ nickname later
	public void changeStamina(int change) {
		if(stamina + change > 10) {
			stamina = 10;
			//Send message?? - 'Stamina cannot exceed 10'
		}else if(stamina + change < 0) {
			stamina = 0;
			//Send message?? - 'Stamina cannot be negative'
		}else {
			stamina = stamina + change;
		}	
	}
	
	public void changeOffence(int change) {
		if(offence + change > 10) {
			offence = 10;
			//Send message?? - 'Offence cannot exceed 10'
		}else if(offence + change < 0) {
			offence = 0;
			//Send message?? - 'Offence cannot be negative'
		}else {
			offence = offence + change;
		}	
	}
	
	public void changeDefence(int change) {
		if(defence + change > 10) {
			defence = 10;
			//Send message?? - 'Defence cannot exceed 10'
		}else if(defence + change < 0) {
			defence = 0;
			//Send message?? - 'Defence cannot be negative'
		}else {
			defence = defence + change;
		}	
	}
	
	public void changeHealth(int change) {
		if(health + change > 100) {
			health = 100;
			//Send message?? - 'Health cannot exceed 100'
		}else if(health + change < 0) {
			health = 0;
			//Send message?? - 'Health cannot be negative'
		}else {
			health = health + change;
		}	
	}
	
	public void changePosition(String newPosition) {
		//Could add more dynamic options
		if(newPosition.toUpperCase() == "D" || newPosition.toUpperCase() == "A") {
			position = newPosition.toUpperCase();
		}else {
			//Call exception - Input must be 'A' or 'D'
		}
	}
	
	public void changeIsInjured(boolean injury) {
		if(injury == true) {
			if(isInjured == true) {
				// Call Exception - Athlete is already injured
			}else {
				previousInjuries ++;
				isInjured = injury;
			}
		}
		isInjured = injury;
	}
	
	//Main method for testing
	public static void main(String[] args) {
		Athlete ath = new Athlete();
		System.out.println(ath);
	}
}
