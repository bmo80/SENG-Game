package athleteInfo;

import java.io.FileNotFoundException;


public class AthleteGenerator extends Athlete {
	
	private String firstname;
	private String lastname;
	private String name;
	private String position;
	private int attack;
	private int defence;
	private int min;
	private int max;
	private int week;
	
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
	
	private void setName() throws FileNotFoundException {
		setFirstName();
		setLastName();
		name = firstname +" "+ lastname;
	}
	
	private void setFirstName() {
		fileReader file = new fileReader("firstnames.txt");
		firstname = file.name;
	}
	private void setLastName() {
		fileReader file = new fileReader("lastnames.txt");
		lastname = file.name;
	}
	
	//Testing more balanced generation
	private int getHigh() {
		min = 2+week;
		max = 5+week;
		int random_high = (int)(Math.random()*(max-min+1)+min); 
		return random_high;
	}
	
	private int getLow() {
		min = 0;
		max = 4;
		int random_low = (int)(Math.random()*(max-min+1)+min); 
		return random_low;
	}
	
	//Testing cleaner version
	private void setAttack() {
		if(position == "A") {
			changeAttack(getHigh());
		} else {
			changeAttack(getLow());
		}
	}
	
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
