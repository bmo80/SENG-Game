package purchasables;

public class Athlete extends Purchasable {
	private String name;
	//Stats Capped at 10
	private int stamina;
	private int attack;
	private int defence;
	private String position;
	private boolean isInjured;
	private int previousInjuries;
	
	/**
	 * Default Constructor for the Athlete Class
	 */
	public Athlete(){
		super();
		//Reserved name
		name = "NULL";
		stamina = 10; 
		attack = 0;
		defence = 0;
		position = "D";
		isInjured = false;
		previousInjuries = 0;		
	}
	/**
	 * Overloaded Constructor for Athlete Class, allows for creation of a custom athlete.
	 * @param setName The name of the Athlete
	 * @param setAttack The Attack value of the Athlete
	 * @param setDefence The Defence value of the Athlete
	 * @param setPosition The position the athlete will play in
	 */
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
	
	
	@Override
	/**
	 * Overrides the system.out to print Athletes
	 */
	public String toString() {
		return String.format("%s: ATK(%s) DEF(%s) POS(%s) "+
				(isInjured?"Injured":""),name, attack, defence, position);
	}
	
	/**
	 * Gets the Athletes name
	 * @return the athletes name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the value of the Athletes stamina
	 * @return the Athletes stamina value
	 */
	public int getStamina() {
		return stamina;
	}
	
	/**
	 * Gets the value of the Athletes attack
	 * @return the Athletes attack value
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Gets the value of the Athletes Defence
	 * @return the Athletes defence value
	 */
	public int getDefence() {
		return defence;
	}
	
	/**
	 * Gets the position the Athlete plays
	 * @return the position the Athlete plays
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * Gets the Athletes injured value
	 * @return boolean of if the Athlete is injured
	 */
	public boolean getIsInjured() {
		return isInjured;
	}
	
	/**
	 * Gets the number of previous injuries
	 * @return
	 */
	public int getPreviousInjuries() {
		return previousInjuries;
	}
	
	/**
	 * Gets the Athletes respective position value
	 * @return The Athletes position value
	 */
	public int getPositionStat() {
		if(position.equals("A")){
			return attack;
		}
		return defence;
	}

	/**
	 * Change the Athletes name to a custom one
	 * @param newName The new name for the Athlete
	 */
	public void changeName(String newName) {
		name = newName;
	}
	
	/**
	 * 
	 * @param change
	 */
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
		if(newPosition.toUpperCase() == "D" || newPosition.toUpperCase() == "A") {
			position = newPosition.toUpperCase();
		}
	}
	
	
	public void changeIsInjured(boolean injury) {
		if(injury == true && isInjured != true) {
			previousInjuries ++;
		}
		isInjured = injury;
	}
	
	
	
	
}
