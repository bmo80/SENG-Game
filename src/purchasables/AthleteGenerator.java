package purchasables;

import java.io.FileNotFoundException;


public class AthleteGenerator extends Athlete {
	
	/**
	 * Athletes firstName
	 */
	private String firstName;
	
	/**
	 * Athletes Surname
	 */
	private String lastName;
	
	/**
	 * Athletes fullname
	 */
	private String name;
	/**
	 * Stores the value of the athletes position
	 */
	private String position;
	/**
	 * Value of Athletes attack
	 */
	private int attack;
	/**
	 * Value of Athletes defence
	 */
	private int defence;
	/**
	 * min variable for use in a random number generator
	 */
	private int min;
	/**
	 * max variable for use in a random number generator
	 */
	private int max;
	/**
	 * Stores the current week the game is in
	 */
	private int week;
	
	/**
	 * Constructor for AthleteGenerator. Initializes the variables and creates the Athlete.
	 * @param pos Position of the Athlete you would like to create
	 * @param currentWeek current week of the season you are playing
	 */
	public AthleteGenerator(String pos, int currentWeek) {
		super();
		position = pos;
		week = currentWeek;
		try {
			setName();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setAttack();
		setDefence();
		super.changeDefence(defence);
		super.changeAttack(attack);
		super.changeName(name);
		super.changePosition(pos);
	}
	
	/**
	 * Joins the First and Last name for the athlete
	 * @throws FileNotFoundException
	 */
	private void setName() throws FileNotFoundException {
		setFirstName();
		setLastName();
		name = firstName +" "+ lastName;
	}
	
	/**
	 * Reads a randomly selected name from the firstNames.txt file
	 */
	private void setFirstName() {
		FileReader file = new FileReader("firstNames.txt");
		firstName = file.name;
	}
	
	/**
	 * Reads a randomly selected name from the lastNames.txt file
	 */
	private void setLastName() {
		FileReader file = new FileReader("lastNames.txt");
		lastName = file.name;
	}
	
	/**
	 * Used to generate an Athletes positional stat
	 * @return value of the Athletes positional stat
	 */
	private int getHighNumber() {
		min = 2+week;
		max = 5+week;
		int random_high = (int)(Math.random()*(max-min+1)+min); 
		return random_high;
	}
	
	/**
	 * Used to generate an Athletes non positional stat
	 * @return value of the Athletes non positional stat
	 */
	private int getLowNumber() {
		min = 0;
		max = 2;
		int random_low = (int)(Math.random()*(max-min+1)+min); 
		return random_low;
	}
	
	/**
	 * Checks which position the Athlete plays and generates the attack
	 * value based on that
	 */
	private void setAttack() {
		if(position == "A") {
			changeAttack(getHighNumber());
		} else {
			changeAttack(getLowNumber());
		}
	}
	
	/**
	 * Checks which position the Athlete plays and Generates the defence 
	 * value based on that
	 */
	private void setDefence() {
		int val;
		if(position == "D") {
			val = getHighNumber();
		} else {
			val = getLowNumber();
		}
		defence = val;
	}
	
}
