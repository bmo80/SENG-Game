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
	private double money;
	private int totalPoints;
	
	// Constructor method, mainly for testing
	public MainGame(String name, int duration, int chosenDifficulty) {
		teamName = name;
		seasonDuration = duration;
		//Testing team
		teamList = setTeam();
		difficulty = chosenDifficulty;
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		inventory = new ArrayList<Item>();
		money = 0.00;
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

		//Breaks Other inputs if closed early
//		input.close();
		
		// Currently TeamList is set as a static team
		teamList = setTeam();
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		inventory = new ArrayList<Item>();
		money = 0.00;
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
		Athlete E = new Athlete("attack3",10,0,"A");
		Athlete F = new Athlete("defend3",1,9,"D");
		team.add(A);
		team.add(B);
		team.add(C);
		team.add(D);
		team.add(E);
		team.add(F);
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
	
	public double getMoney() {
		return money;
	}
	
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	// setter methods - NOT ALL -- Could add text confirmation
	//not necessary??
	public void changeWeek() {
		currentWeek ++;
	}
	
	public void addAthlete(Athlete chosenAthlete) {
		if(teamList.size() >= 6){
			// Call Exception - team full - overflow to bench?
			benchAthlete(chosenAthlete);
		}else {
			teamList.add(chosenAthlete);
		}
	}
	
	public void benchAthlete(Athlete chosenAthlete) {
		if(benchList.size() >= 5){
			// Call exception - bench full
		}
		// not strictly necessary I believe
//		else if(!teamList.contains(chosenAthlete)) {
//			// Call exception - athlete not in team
//		}
		else{
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
	
	public void buyItem(Item item) {
		if(money-item.getBuyPrice()>0) {
			money = money - item.getBuyPrice();
			inventory.add(item);
		}
	}
	
	public void buyAthlete(Athlete athlete) {
		if(money-athlete.getBuyPrice()>0) {
			money = money - athlete.getBuyPrice();
			addAthlete(athlete);
			// check for space before removing money??
		}
	}
	
	
	//Print methods
	//Prints Athletes in collection by name
	public void printTeam(ArrayList<Athlete> collection) {
		for(Athlete athlete:collection) {
			System.out.println(athlete.shortDescription());
		}
	}
	
	//Prints inventory
	public void printInventory() {
		for(Item ite:inventory) {
			System.out.println(ite);
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
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		//If not on team, checks bench too
		for(Athlete athlete:benchList) {
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		//if not found calls exception - Athlete not on team or on bench
		//returns default athlete for now WHICH CAUSES BENCH TO GROW FOREVER
		Athlete ath = new Athlete();
		return ath;
	}
	
	public void resetStamina() {
		for(Athlete athlete:teamList) {
			athlete.changeStamina(10);
		}
		for(Athlete athlete:teamList) {
			athlete.changeStamina(10);
		}
	}
	
	public void trainAthlete() {
		Scanner input = new Scanner(System.in);
		System.out.print("Who will you train?");
		String choice = input.nextLine();
		athleteFromString(choice).changeDefence(1);
		athleteFromString(choice).changeOffence(1);
	}

	//Method to check String input - designed for main game inputs -- IN PROGRESS
//	public void checkInput(String message) {
//		Scanner input = new Scanner(System.in);
//		System.out.print(message);
//		String choice = input.nextLine();
//		while(!(choice in options)) {
//			try again
//		}
//		return choice
//		//input.close();
//	}
	
	
	// could make helper function: returnInput: does all input checks and returns value
	// method for being 'at the club' - can swap out athletes and use items
	public void gotoClub() {
		String choice = "";
		System.out.println(teamName+"'s active team:");
		printTeam(teamList);
		System.out.println("\n"+teamName+"'s Bench team:");
		printTeam(benchList);
		Scanner input = new Scanner(System.in);
		while(!(choice.toUpperCase() == "E")) {
			
			System.out.print("Bench/Unbench Athletes? ('B'/'U' or 'E' to exit): ");  
			//fixed by not closing in setup
			choice = input.nextLine(); 
			
			if(choice.toUpperCase().equals("B")) {
				System.out.print("\nCurrent Active Team...\n");
				printTeam(teamList);
				System.out.print("Who to bench (enter name or 'E' to exit): ");
				// Need to ensure unique names
				String athleteChoice = input.nextLine();
				if(athleteChoice.toUpperCase().equals("E")) {
					choice = "E";
					break;
				}
				benchAthlete(athleteFromString(athleteChoice));
			}
			
			else if(choice.toUpperCase().equals("U")) {
				System.out.print("\nCurrent Bench...\n");
				printTeam(benchList);
				System.out.print("Who to unbench (enter name or 'E' to exit): ");
				String athleteChoice = input.nextLine();
				if(athleteChoice.toUpperCase().equals("E")) {
					choice = "E";
					break;
				}
				unbenchAthlete(athleteFromString(athleteChoice));
			}
			
			else if(choice.toUpperCase().equals("E")) {
				break;
			}		
			
			System.out.print("Current Inventory:");
			printInventory();
			for(Item item:inventory) {
				System.out.println(item);
			}
			System.out.print("Which item to use (enter name or 'E' to exit): ");
			String itemChoice = input.nextLine();
			if(itemChoice.toUpperCase().equals("E")) {
				break;
			}
			System.out.print("Who to use on (enter name or 'E' to exit): ");
			String athleteChoice = input.nextLine();
			if(athleteChoice.toUpperCase().equals("E")) {
				choice = "E";
				break;
			}
			useItem(itemFromString(itemChoice),athleteFromString(athleteChoice));
		
		}
//		input.close();
	}
	
	public void gotoStadium() {
		//Fill in random generation of teams (6 opponents: 3 def, 3 atk)
		// For testing purposes im assuming they will be in a 2D list.
		//For testing purposes lets say there are 3 teams to choose from
//		Scanner input = new Scanner(System.in);
//		int choice = input.nextInt();
		//selects the opposing team based on user input
//		playMatch(opponentsList[choice-1]);
	}
	
	public void gotoMarket() {
		//Fill in randomly generated items and players (Maybe 2 items and 4 players?)
		// For testing purposes im assuming the all items will be in one list
//		Scanner input = new Scanner(System.in);
//		int choice = input.nextInt();
//		//determines whether purchase is item or athlete
//		// for testing purposes im assuming the first 2 are items
//		if(choice>2) {
//			buyAthlete(itemList[choice-1];);
//		}else {
//			buyItem(itemList[choice-1];);
//		}
	}
	
	public void takeBye() {
		currentWeek ++;
		resetStamina();
//		 train athlete - if chosen
		trainAthlete();
		// try for random events
//		runRandomEvents();
		//resetMarket();
		//resetStadium();
	}
	
	public void playMatch() {
		
		
		currentWeek ++;
	}
	//method that runs main game inputs
	public void playGame() {
		System.out.println(String.format("Money: $%s"
				+ "\nWeek: %s", money,currentWeek));
		Scanner input = new Scanner(System.in);
		System.out.print("Where to go? Club('C'), Market('M'), Stadium('S'), Bye('B')");
		String choice = input.nextLine();
		if(choice.toUpperCase().equals("C")) {
			gotoClub();
		}else if(choice.toUpperCase().equals("S")) {
			gotoStadium();
		}else if(choice.toUpperCase().equals("M")) {
			gotoMarket();
		}else if(choice.toUpperCase().equals("B")) {
			takeBye();
		}else {
			System.out.println("Invalid input");
		}
	}
	
	
	
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		MainGame run = new MainGame("Test Team",10,3);
		run.printInventory();
		System.out.println(run.getTeamList().get(0).getName()=="attack1");
//		run.printTeam(run.getTeamList());
//		run.printTeam(run.getBenchList());
		while(run.seasonDuration - run.currentWeek >= 0) {
			System.out.println(run);
			run.playGame();
		}
		System.out.println(String.format("The %s team finished the %s week"
				+ " season with $%s and %s points"
				+ "", run.teamName,run.seasonDuration,run.money,run.totalPoints));

	}
	
}
