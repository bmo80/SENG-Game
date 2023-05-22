package purchasables;

/**
 * Class Athlete contains all the information pertaining to an Athlete object.
 * @author Blair Brydon
 * @author Ben Moore
 */
public class Athlete extends Purchasable {
	/**
	 * Variable to store the name of the Athlete
	 */
	private String name;
	/**
	 * Stores the Athletes stamina value
	 */
	private int stamina;
	/**
	 * Stores the Athletes attack value
	 */
	private int attack;
	/**
	 * Stores the Athletes defense value
	 */
	private int defence;
	/**
	 * String that stores the athletes position
	 */
	private String position;
	/**
	 * boolean that stores whether the athlete is injured or not
	 */
	private boolean isInjured;
	/**
	 * Stores the number of times the athlete has been injured.
	 */
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
	 * Overloaded Constructor for Athlete Class, 
	 * allows for creation of a custom athlete.
	 * @param setName The name of the Athlete
	 * @param setAttack The Attack value of the Athlete
	 * @param setDefence The Defence value of the Athlete
	 * @param setPosition The position the athlete will play in
	 */
	public Athlete(String setName, int setAttack, int setDefence, 
			String setPosition) {
		super(150, 100, setName);
		name = setName;
		stamina = 10;
		attack = setAttack;
		defence = setDefence;
		position = setPosition;
		isInjured = false;
		previousInjuries = 0;
	}
	
	
	@Override
	/**
	 * Overrides the toString to print Athletes
	 */
	public String toString() {
		return String.format("%s: ATK(%s) DEF(%s) POS(%s) " +
				(isInjured? "Injured":""),name, attack, defence, position);
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
	 * Gets the value of the Athletes defence
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
	 * Gets the Athletes injury status
	 * @return boolean of if the Athlete is injured
	 */
	public boolean getIsInjured() {
		return isInjured;
	}
	
	/**
	 * Gets the number of previous injuries
	 * @return int number of previous injuries
	 */
	public int getPreviousInjuries() {
		return previousInjuries;
	}
	
	/**
	 * Gets the Athletes respective position value
	 * @return The Athletes position value
	 */
	public int getPositionStat() {
		if( position.equals("A")){
			return attack;
		}
		else {
			return defence;
		}
	}

	/**
	 * Change the Athletes name to a custom one
	 * @param newName The new name for the Athlete
	 */
	public void changeName(String newName) {
		name = newName;
	}
	
	/**
	 * Changes the Athletes stamina by the specified amount
	 * @param change the amount stamina will be changed by
	 */
	public void changeStamina(int change) {
		stamina = verifyChange(stamina, change);
		if( stamina == 0 && isInjured == false) {
			isInjured = true;
			previousInjuries ++;
		}
	}
	
	/**
	 * Changes the Attack of the Athlete by a specified amount
	 * @param change the amount the attack will be changed by
	 */
	public void changeAttack(int change) {
		attack = verifyChange(attack, change);
	}
	
	/**
	 * Changes the defence of Athlete by a specified amount
	 * @param change the amount the defence will be changed by
	 */
	public void changeDefence(int change) {
		defence = verifyChange(defence, change);
	}
	
	/**
	 * Checks which position stat you wish to change and sends it to the support functions
	 * @param amount the amount the stat will be changed by
	 */
	public void changePositionStat(int amount) {
		if( position.equals("A")){
			changeAttack(amount);
		}
		else {
			changeDefence(amount);
		}
	}
	
	/**
	 * Checks if the stat change doesnt overflow above 10 or go below 0
	 * @param stat The Athlete statistic to be change
	 * @param change The amount the statistic will be change by
	 * @return The new value for the statistic.
	 */
	public int verifyChange(int stat, int change) {
		if( stat + change >= 10) {
			return 10;
		}
		else if( stat + change <= 0) {
			return 0;
		}
		else {
			return stat + change;
		}
	}
	
	/**
	 * Checks which item is being used and then applies it to the correct stat
	 * @param item The Item to be used
	 */
	public void useItem(Item item) {
		if( item.getName().equals("Stamina")) {
			changeStamina(item.getEffect());
		}
		else if( item.getName().equals("Attack")) {
			changeAttack(item.getEffect());
		}
		else if( item.getName().equals("Defence")) {
			changeDefence(item.getEffect());
		}
		else {
			isInjured = false;
			changeStamina(item.getEffect());
		}
	}
	
	/**
	 * Changes the postion of the Athlete
	 * @param newPosition the position the Athlete is Changing to.
	 */
	public void changePosition(String newPosition) {
		if( newPosition.toUpperCase() == "D" || 
				newPosition.toUpperCase() == "A") {
			position = newPosition.toUpperCase();
		}
	}
	
	/**
	 * Changes the athlete to be injured or not
	 * @param injury boolean for if the athlete is injured.
	 */
	public void changeIsInjured(boolean injury) {
		if( injury == true && isInjured != true) {
			previousInjuries ++;
			isInjured = injury;
		}
		else {
			isInjured = injury;
		}
	}
}
