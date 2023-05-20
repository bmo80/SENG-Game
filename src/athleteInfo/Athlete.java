package athleteInfo;

public class Athlete extends Purchasable {
	private String name;
	//Stats Capped at 10
	private int stamina;
	private int attack;
	private int defence;
	private String position;
	private boolean isInjured;
	private int previousInjuries;
	
	// Constructors
	public Athlete(){
		super();
		//Reserved name
		name = "NULL";
		stamina = 0; 
		attack = 0;
		defence = 0;
		position = "D";
		isInjured = false;
		previousInjuries = 0;		
	}
	
	public Athlete(String setName, int setAttack, int setDefence, String setPosition) {
		super(150,100,setName);
		name = setName;
		stamina = 10;
		// Put checks in place
		attack = setAttack;
		defence = setDefence;
		// put check in place
		position = setPosition;
		isInjured = false;
		previousInjuries = 0;		
	}
	
	//Over
	@Override
	public String toString() {
		return String.format("%s ATK(%s) DEF(%s) POS(%s) STA(%s)) "+
				(isInjured?"Injured":""),name, attack, defence, position, stamina);
	}
	
//	public String getLongDescription() {
//		return String.format("%s has an attack stat of %s, a Defence stat of %s"
//				+ " and is in position %s.\nThey have %s stamina, %s"
//				+ " previous injuries and are currently" + (isInjured?"":" not") + " injured"
//				+ "",name, attack, defence, position, stamina, previousInjuries);
//	}
	
	// getter methods
	public String getName() {
		return name;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public int getAttack() {
		return attack;
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
			return attack;
		}
		return defence;
	}

	public void changeName(String newName) {
		name = newName;
	}
	
	public void changeStamina(int change) {
		stamina = verifyChange(stamina, change);
		if(stamina == 0) {
			isInjured = true;
			previousInjuries ++;
		}
	}
	
	public void changeAttack(int change) {
		attack = verifyChange(attack, change);	
	}
	
	public void changeDefence(int change) {
		defence = verifyChange(defence, change);
	}
	
	public void changePositionStat(int amount) {
		if(position.equals("A")){
			changeAttack(amount);
		}
		else {
			changeDefence(amount);
		}
	}
	
	public int verifyChange(int stat, int change) {
		if(stat + change >= 10) {
			//Send message?? - 'Stat cannot exceed 10'
			return 10;
		}else if(stat + change <= 0) {
			//Injury state
			//Send message?? - 'Stat cannot be negative'
			return 0;
		}else {
			return stat + change;
		}
	}
	
	public void useItem(Item item) {
		if(item.getType().equals("Stamina")) {
			changeStamina(item.getEffect());
		}else if(item.getType().equals("Attack")) {
			changeAttack(item.getEffect());
		}else if(item.getType().equals("Defence")) {
			changeDefence(item.getEffect());
		}else {
			//HP case
			isInjured = false;
			changeStamina(item.getEffect());			
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
	
	
	
	
}
