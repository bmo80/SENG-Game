package sengGame;

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
	
	AthleteGenerator(String pos) {
		super();
		position = pos;
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
	
	private int getHigh() {
		min = 7;
		max = 10;
		int random_high = (int)(Math.random()*(max-min+1)+min); 
		return random_high;
	}
	
	private int getLow() {
		min = 0;
		max = 4;
		int random_low = (int)(Math.random()*(max-min+1)+min); 
		return random_low;
	}
	
	private void setAttack() {
		int val;
		if(position == "A") {
			val = getHigh();
		} else {
			val = getLow();
		}
		attack = val;
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
