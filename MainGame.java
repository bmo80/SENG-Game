package sengGame;
import java.util.*;

public class MainGame {
	// Properties
	private String teamName;
	private int seasonDuration;
	private ArrayList<Athlete> teamList;
	//Out of 3 for now
	private int difficulty;
	private int currentWeek;
	private ArrayList<Athlete> benchList;
	private ArrayList<Item> inventory;
	private int money;
	
	// Constructor method, mainly for testing
	public MainGame(String name, int duration, ArrayList<Athlete> team, int chosenDifficulty) {
		teamName = name;
		seasonDuration = duration;
		teamList = team;
		difficulty = chosenDifficulty;
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		inventory = new ArrayList<Item>();
		money = 0;
	}
	
	// Setup Constructor method
	public MainGame() {
		Scanner input = new Scanner(System.in);
		System.out.print("Name your team (3-15 chars): ");  
		// might break?
		teamName = input.nextLine();  
		System.out.print("How long is the season (5-15 weeks): ");  
		seasonDuration = input.nextInt();  
		System.out.print("Set difficulty (1-3): ");  
		difficulty = input.nextInt();
		input.close();
		// Currently TeamList is set as a static team
		teamList = setTeam();
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		inventory = new ArrayList<Item>();
		money = 0;
	}
	
	//Override toString method
	@Override
	public String toString() {
		//Note: the BenchList,TeamList and Inventory are printed with DIFFERENT methods - might change
		return String.format("The %s team has a %s week season, they are currently on week"
				+ " %s. The difficulty is %s/3 and they have $%s"
				+ "",teamName,seasonDuration,currentWeek,difficulty,money);
	}
	
	// Method for setting default team - mainly for testing
	public ArrayList<Athlete> setTeam(){
		ArrayList<Athlete> team = new ArrayList<Athlete>();		
		Athlete A = new Athlete("attack1",7,2,"A");
		Athlete B = new Athlete("defend1",2,6,"D");
		Athlete C = new Athlete("attack2",3,1,"A");
		Athlete D = new Athlete("defend2",1,4,"D");
		team.add(A);
		team.add(B);
		team.add(C);
		team.add(D);
		return team;
	}
	
	// getter methods - NOT ALL
	public ArrayList<Athlete> getTeamList() {
		return teamList;
	}
	
	public ArrayList<Athlete> getBenchList() {
		return benchList;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public int getMoney() {
		return money;
	}
	
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	// setter methods - NOT ALL
	public void changeWeek() {
		currentWeek ++;
	}
	
	public void addAthlete(Athlete chosenAthlete) {
		if(teamList.size() >= 8){
			// Call Exception - team full - overflow to bench?
		}else {
			teamList.add(chosenAthlete);
		}
	}
	
	public void benchAthlete(Athlete chosenAthlete) {
		if(benchList.size() >= 4){
			// Call exception - bench full
		}else if(!teamList.contains(chosenAthlete)) {
			// Call exception - athlete not in team
		}else{
			benchList.add(chosenAthlete);
			// removes first instance - ENSURE unique Athletes!
			teamList.remove(chosenAthlete);
		}
	}
	
	public void unbenchAthlete(Athlete chosenAthlete) {
		if(!benchList.contains(chosenAthlete)) {
			// Call exception - Athlete not on bench
		}else {
			// removes first instance - ENSURE unique Athletes!
			benchList.remove(chosenAthlete);
			// Could call team full exception...
			addAthlete(chosenAthlete);
		}
	}
	
	public void useItem(Item chosenItem,Athlete chosenAthlete) {
		if(chosenItem.getType() == "Stamina") {
			chosenAthlete.changeStamina(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "Offence") {
			chosenAthlete.changeOffence(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "Defence") {
			chosenAthlete.changeDefence(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "Health") {
			chosenAthlete.changeHealth(chosenItem.getEffect());
		}
	}
	
	
	// Special methods
	public Item itemFromString(String stringItem) {
		for(Item item:inventory) {
			if(item.getName() == stringItem) {
				return item;
			}
		}
		//If not found call exception - Item not in inventory
		//return default item for now
		Item ite = new Item();
		return ite;
	}
	
	//Returns athlete object from given athlete name
	public Athlete athleteFromString(String stringAthlete) {
		for(Athlete athlete:teamList) {
			//unique names!!! 
			if(athlete.getName() == stringAthlete) {
				return athlete;
			}
		}
		//If not on team, checks bench too
		for(Athlete athlete:benchList) {
			if(athlete.getName() == stringAthlete) {
				return athlete;
			}
		}
		//if not found calls exception - Athlete not on team or on bench
		//returns default athlete for now
		Athlete ath = new Athlete();
		return ath;
	}
	
	//Prints Athletes in collection by name
	public void printTeam(ArrayList<Athlete> collection) {
		for(Athlete athlete:collection) {
			System.out.println(athlete.getName());
		}
	}
	
	//Prints inventory
	public void printInventory() {
		for(Item ite:inventory) {
			System.out.println(ite);
		}
	}
	
	//Broken as of 6:30 12/4 - No line found issue (nextLine isnt working :( )
	// method for being 'at the club' - can swap out athletes and use items
	public void atClub() {
		String choice = "";
		Scanner input = new Scanner(System.in);
		while(!(choice.toUpperCase() == "E")) {
			
			System.out.print("Bench/Unbench Athletes? ('B'/'U' or 'E' to exit): ");  
			//BROKEN UGHHHHH
			choice = input.nextLine();
			
			if(choice.toUpperCase() == "B") {
				System.out.print("\nCurrent Active Team...");
				printTeam(teamList);
				System.out.print("Who to bench (enter name or 'E' to exit): ");
				// Need to ensure unique names
				String athleteChoice = input.nextLine();
				if(athleteChoice.toUpperCase() == "E") {
					choice = "E";
					break;
				}
				unbenchAthlete(athleteFromString(athleteChoice));
			}
			
			else if(choice.toUpperCase() == "U") {
				System.out.print("\nCurrent Bench...");
				printTeam(benchList);
				System.out.print("Who to unbench (enter name or 'E' to exit): ");
				String athleteChoice = input.nextLine();
				if(athleteChoice.toUpperCase() == "E") {
					choice = "E";
					break;
				}
				benchAthlete(athleteFromString(athleteChoice));
			}
			
			else if(choice.toUpperCase() == "E") {
				break;
			}		
			
			System.out.print("Current Inventory...");
			for(Item item:inventory) {
				System.out.println(item);
			}
			System.out.print("Which item to use (enter name or 'E' to exit): ");  
			String itemChoice = input.nextLine();
			System.out.print("Who to use on (enter name or 'E' to exit): ");
			String athleteChoice = input.nextLine();
			if(athleteChoice.toUpperCase() == "E" || itemChoice.toUpperCase() == "E") {
				choice = "E";
				break;
			}
			useItem(itemFromString(itemChoice),athleteFromString(athleteChoice));
		
		}
		input.close();
	}
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		MainGame run = new MainGame();
		System.out.println(run);
		run.printInventory();
		run.printTeam(run.getTeamList());
		run.printTeam(run.getBenchList());
		//Fix next line
		run.atClub();

	}
	
}
