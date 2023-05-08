package sengGame;
import java.util.*;

public class MainGame {
	// Properties
	private String teamName;
	private int seasonDuration;
	private ArrayList<Athlete> teamList;
	//0,1 or 2
	private int difficulty;
	private int currentWeek;
	private ArrayList<Athlete> benchList;
	private ArrayList<Item> inventory;
	private int money;
	private int totalPoints;
	
	// Constructor method, mainly for testing
	public MainGame(String name, int duration, int chosenDifficulty) {
		teamName = name;
		seasonDuration = duration;
		//Testing team
		teamList = setTeam();
		difficulty = chosenDifficulty -1;
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		//test inventory
		inventory = setInventory();
		money = 1000;
	}
	
	// Setup Constructor method
	public MainGame() {
		//Put checks in place for all
		Scanner input = new Scanner(System.in);
		System.out.print("Name your team (3-15 chars): ");  
		// might break?
		teamName = input.nextLine();  
		System.out.print("How long is the season (5-15 weeks): ");  
		seasonDuration = input.nextInt();  
		System.out.print("Set difficulty (1-3): ");
		difficulty = input.nextInt()-1;

		//Breaks Other inputs if closed early
//		input.close();
		
		// Currently TeamList is set as a static team
		teamList = setTeam();
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		inventory = new ArrayList<Item>();
		money = 0;
		input.close();
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
		team.add(new Athlete("attack1",7,2,"A"));
		team.add(new Athlete("defend1",2,6,"D"));
		team.add(new Athlete("attack2",3,1,"A"));
		team.add(new Athlete("defend2",1,4,"D"));
		team.add(new Athlete("attack3",10,0,"A"));
		team.add(new Athlete("defend3",1,9,"D"));
		return team;
	}
	
	public ArrayList<Item> setInventory(){
		ArrayList<Item> inventory = new ArrayList<Item>();
		inventory.add(new Item("Juice","STA",5,15));
		inventory.add(new Item("Speed","ATK",1,25));
		inventory.add(new Item("Grippers","DEF",1,25));
		inventory.add(new Item("Bandages","HP",20,20));
		return inventory;
	}
	
	
	// getter methods - NOT ALL
	public ArrayList<Athlete> getTeamList() {
		return teamList;
	}
	
	public String getTeamName() {
		return teamName;
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
	
	// setter methods - NOT ALL -- Could add text confirmation
	//not necessary??
	public void changeWeek() {
		currentWeek ++;
		//Generate NEW market and stadium
		//Also run the Random event method which calls popup window if event happens
	}
	
	public void changeMoney(int amount) {
		money += amount;
	}
	
	public void changePoints(int amount) {
		totalPoints += amount;
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
		else if(chosenAthlete.getName().equals("Default Athlete")){
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
		if(chosenItem.getType() == "STA") {
			chosenAthlete.changeStamina(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "ATK") {
			chosenAthlete.changeOffence(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "DEF") {
			chosenAthlete.changeDefence(chosenItem.getEffect());
		}
		inventory.remove(chosenItem);
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
			System.out.println(athlete.getShortDescription());
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
			if(item.getName().equals(stringItem)) {
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
		//Choose one OR the other - Hardest diff Currently has no change
		Athlete athlete = athleteFromString(choice);
		if(athlete.getPosition().equals("A")){
			athlete.changeOffence(3-difficulty);
		} else {
			athlete.changeDefence(3-difficulty);
		}
//		never close input --> breaks next input
//		input.close();
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
		System.out.println("\n"+teamName+"'s active team:");
		printTeam(teamList);
		System.out.println("\n"+teamName+"'s Bench team:");
		printTeam(benchList);
		Scanner input = new Scanner(System.in);
		while(!(choice.toUpperCase() == "E")) {
			
			System.out.print("\nBench/Unbench Athletes? ('B'/'U' or '' for Inventory or 'E' to exit): ");  
			//fixed by not closing in setup
			choice = input.nextLine(); 
			
			if(choice.toUpperCase().equals("B")) {
				System.out.print("\nCurrent Active Team...\n");
				printTeam(teamList);
				System.out.print("\nWho to bench (enter name or 'E' to exit): ");
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
				System.out.print("\nWho to unbench (enter name or 'E' to exit): ");
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
			
			System.out.print("\nCurrent Inventory:\n");
			printInventory();
//			for(Item item:inventory) {
//				System.out.println(item);
//			}
			System.out.print("\nWhich item to use (enter name or 'E' to exit): ");
			String itemChoice = input.nextLine();
			if(itemChoice.toUpperCase().equals("E")) {
				break;
			}
			System.out.print("Who to use on (enter name or 'E' to exit): ");
			System.out.println("\n"+teamName+"'s active team:");
			printTeam(teamList);
			System.out.println("\n"+teamName+"'s Bench team:");
			printTeam(benchList);
			String athleteChoice = input.nextLine();
			if(athleteChoice.toUpperCase().equals("E")) {
				choice = "E";
				break;
			}
			useItem(itemFromString(itemChoice),athleteFromString(athleteChoice));
		
		}
		input.close();
	}
	
	public void gotoStadium() {
		//Fill in random generation of teams (6 opponent Athletes per team)
		// They will be in a 2D list.
		
		//Match class should be working 
		Match game = new Match(teamList,makeOpponents(), difficulty);
		if(game.verify()) {
			int[] list;
			list = game.playMatch();
			changeMoney(list[1]);
			changePoints(list[0]);
		}
	}
	
	//JUST FOR TESTING
	public ArrayList<Athlete> makeOpponents(){
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		team.add(new Athlete("OPPattack1",8,2,"A"));
		team.add(new Athlete("OPPdefend1",2,7,"D"));
		team.add(new Athlete("OPPattack2",1,1,"A"));
		team.add(new Athlete("OPPdefend2",1,1,"D"));
		team.add(new Athlete("OPPattack3",1,0,"A"));
		team.add(new Athlete("OPPdefend3",1,1,"D"));
		return team;
	}
	
	
	
	public void gotoMarket() {
		System.out.println("Welcome to the Market!\n");
		MarketPlace market = new MarketPlace();
		for(Athlete player: market.players) {
			System.out.println(player.getShortDescription());
		}
	}
	
	
	public void takeBye() {
		currentWeek ++;
		//does NOT reset injury/ health
		resetStamina();
//		 train athlete - if chosen
		trainAthlete();
		// try for random events
//		runRandomEvents();
		//resetMarket();
		//resetStadium();
	}
	
	
	
	
	//method that runs main game inputs
	public void playGame() {
		System.out.println(String.format("Money: $%s"
				+ "\nWeek: %s", money,currentWeek));
		Scanner input = new Scanner(System.in);
		System.out.print("Where to go? Club('C'), Market('M'), Stadium('S'), Bye('B')");
		String choice = input.nextLine();
		// All should run windows
		if(choice.toUpperCase().equals("C")) {
			gotoClub();
		}else if(choice.toUpperCase().equals("S")) {
			gotoStadium();
		}else if(choice.toUpperCase().equals("M")) {
			gotoMarket();
		}else if(choice.toUpperCase().equals("B")) {
			takeBye();
		}else {
			//Make an error window pop up
			System.out.println("Invalid input");
		}
//		input.close();
	}
	
	
	
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		MainGame run = new MainGame("Test Team",5,3);
		
		run.gotoClub();

	}
	
}