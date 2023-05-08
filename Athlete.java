package sengGame;

public class Athlete extends Purchasable {
	private String name;
	private int stamina;
	private int offence;
	private int defence;
	private String position;
	private boolean isInjured;
	private int previousInjuries;
	
	// Constructors
	public Athlete(){
		super();
		//Reserved name
		name = "Default Athlete";
		stamina = 10; 
		offence = 5;
		defence = 5;
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
		// put check in place
		position = setPosition;
		isInjured = false;
		previousInjuries = 0;		
	}
	
	//Over
	@Override
	public String toString() {
		return String.format("%s has an Offence stat of %s, a Defence stat of %s"
				+ " and is in position %s.\nThey have %s stamina, %s"
				+ " previous injuries and are currently" + (isInjured?"":" not") + " injured"
				+ "",name, offence, defence, position, stamina, previousInjuries);
	}
	
	public String getShortDescription() {
		return String.format("%s: ATK(%s) DEF(%s) POS(%s) STA(%s)) "+
	(isInjured?"Injured":""),name, offence, defence, position, stamina);
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
	
	public String getPosition() {
		return position;
	}
	
	public boolean getIsInjured() {
		return isInjured;
	}
	
	public int getPreviousInjuries() {
		return previousInjuries;
	}
	
	public int getPositionStat() {
		if(position.equals("A")){
			return offence;
		}
		return defence;
	}
	
	//Setters for the athlete generator class.
	public void setName(String newName) {
		name = newName;
	}
	
	public void setOffence(int newOffence) {
		offence = newOffence;
	}
	
	public void setDefence(int newDefence) {
		defence = newDefence;
	}
	
	public void setPosition(String pos) {
		position = pos;
	}
	
	// Setter methods - add changeName/ nickname later
	public void changeStamina(int change) {
		if(stamina + change >= 10) {
			stamina = 10;
			//Send message?? - 'Stamina cannot exceed 10'
		}else if(stamina + change <= 0) {
			//Injury state
			isInjured = true;
			stamina = 0;
			//Send message?? - 'Stamina cannot be negative'
		}else {
			stamina = stamina + change;
		}	
	}
	
	public void changeOffence(int change) {
		offence += change;	
	}
	
	public void changeDefence(int change) {
		defence += change;
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
	
	public void changeName(String newName) {
		name = newName;
	}
	
	
}
