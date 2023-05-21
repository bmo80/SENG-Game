package athleteInfo;

import java.io.FileNotFoundException;


public class AthleteGenerator extends Athlete {
	
	/**
	 * Athletes Firstname
	 */
	private String firstname;
	
	/**
	 * Athletes Surname
	 */
	private String lastname;
	
	/**
	 * Athletes fullname
	 */
	private String name;
	private String position;
	private int attack;
	private int defence;
	private int min;
	private int max;
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
		name = firstname +" "+ lastname;
	}
	
	/**
	 * Reads a randomly selected name from the firstnames.txt file
	 */
	private void setFirstName() {
		fileReader file = new fileReader("firstnames.txt");
		firstname = file.name;
	}
	
	/**
	 * Reads a randomly selected name from the lastnames.txt file
	 */
	private void setLastName() {
		fileReader file = new fileReader("lastnames.txt");
		lastname = file.name;
	}
	
	/**
	 * Used to generate an Athletes positional stat
	 * @return value of the Athletes positional stat
	 */
	private int getHigh() {
		min = 2+week;
		max = 5+week;
		int random_high = (int)(Math.random()*(max-min+1)+min); 
		return random_high;
	}
	
	/**
	 * Used to generate an Athletes non positional stat
	 * @return value of the Athletes non positional stat
	 */
	private int getLow() {
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
			changeAttack(getHigh());
		} else {
			changeAttack(getLow());
		}
	}
	
	/**
	 * Checks which position the Athlete plays and Generates the defence 
	 * value based on that
	 */
	private void setDefence() {
		int val;
		if(position == "D") {
			val = getHigh();
		} else {
			val = getLow();
		}
		defence = val;
	}
	
}
