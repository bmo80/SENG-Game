package sengGame;
import java.util.*;

import athleteInfo.Athlete;
import athleteInfo.Item;
import athleteInfo.TeamManager;
import windows.MainWindow;
import windows.SetupWindow;


/**
 * Class that contains the game information and calls
 * other game classes
 * 
 * @author Ben Moore + Blair Brydon
 * @version 1.0 13/5/23
 */
public class MainGame {
	/*
	 * Name of player/ players team
	 */
	private String playerName;
	/*
	 * Player-chosen length of season in weeks 
	 */
	private int seasonDuration;
	/*
	 * Player's current active team (collection of Athlete objects)
	 */
	private ArrayList<Athlete> teamList;
	/*
	 * Player-chosen difficulty 0/1/2 for easy/medium/hard
	 */
	private int difficulty;
	/*
	 * Current week - starting at 1
	 */
	private int currentWeek;
	/*
	 * Player's current bench team (collection of Athlete objects)
	 */
	private ArrayList<Athlete> benchList;
	/*
	 * Player's current collection of Item objects
	 */
	private ArrayList<Item> inventory;
	/*
	 * Player's current money balance (for buying Items and Athletes)
	 */
	private int money;
	/*
	 * Player's total points (earned by winning or tying matches)
	 */
	private int totalPoints;
	
	
	
	/*
	 * Constructs Object with given values - used to speed up testing
	 * @param name		Name of player
	 * @param duration		Length of season in weeks
	 * @param chosenDifficulty		difficulty of game
	 */
	public MainGame(String name, int duration, int chosenDifficulty) {
		playerName = name;
		seasonDuration = duration;
		//Testing team
		teamList = setTeam();
		difficulty = chosenDifficulty;
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		benchList.add(new Athlete("bench1",5,5,"A"));
		TeamManager teams = new TeamManager(teamList,benchList);
		//test inventory
		inventory = setInventory();
		money = 100000;
	}
	
	/**
	 * Constructs Object - gets input from user
	 * 
	 */
	public MainGame() {
		//Put checks in place for all
		Scanner input = new Scanner(System.in);
		System.out.print("Name your team (3-15 chars): ");  
		// might break?
		playerName = input.nextLine();  
		System.out.print("How long is the season (5-15 weeks): ");  
		seasonDuration = input.nextInt();  
		System.out.print("Set difficulty (1-3): ");
		difficulty = input.nextInt()-1;
		
		// Currently TeamList is set as a static team
		teamList = setTeam();
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		TeamManager teams = new TeamManager(teamList,benchList);
		inventory = new ArrayList<Item>();
		money = 0;
	}
	
	/*
	 * Overrides toString method to display all Game stats/ info
	 * @return		String with game info
	 */
	@Override
	public String toString() {
		//Note: the BenchList,TeamList and Inventory are printed with DIFFERENT methods - might change
		return String.format("The %s team has a %s week season, they are currently on week"
				+ " %s. The difficulty is %s/2 and they have $%s"
				+ "",playerName,seasonDuration,currentWeek,difficulty,money);
	}
	
	/*
	 *  Method for setting default team - mainly for testing
	 *  @return 	Default team
	 */
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
	
	/*
	 *  Method for setting default inventory - mainly for testing
	 *  @return		Default inventory
	 */
	public ArrayList<Item> setInventory(){
		ArrayList<Item> inventory = new ArrayList<Item>();
		inventory.add(new Item("Juice","Stamina",5,15));
		inventory.add(new Item("Speed","Attack",1,25));
		inventory.add(new Item("Grippers","Defence",1,25));
		inventory.add(new Item("Bandages","HP",20,20));
		return inventory;
	}
	
	
	
	
// 		getter methods
	
	
	/*
	 *  Special method that turns the active and bench teams into a string list
	 *  @return 	String[] list of Athlete names
	 */
	public String[] getTeamsString() {
		String stringArray[] = new String[teamList.size()+benchList.size()];
		for(int i=0;i<teamList.size();i++) {
			stringArray[i] = teamList.get(i).getName();
		}
		for(int i=teamList.size();i<(teamList.size()+benchList.size());i++) {
			stringArray[i] = benchList.get(i-teamList.size()).getName();
		}
		return stringArray;
	}
	
	/*
	 * Returns an array of athlete objects from active team
	 * @return		active team ArrayList<Athlete>
	 */
 	public ArrayList<Athlete> getTeamList() {
 		return teamList;
 	}
	
 	/*
 	 * Returns player name
 	 * @return		player name
 	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/*
	 * Returns an array of athlete objects from bench team
	 * @return		bench team ArrayList<Athlete>
	 */
 	public ArrayList<Athlete> getBenchList() {
 		return benchList;
 	}
	
 	/*
 	 * Returns game difficulty
 	 * @return		difficulty
 	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/*
	 * Returns Player money
	 * @return		player money
	 */
	public int getMoney() {
		return money;
	}
	
	/*
	 * Returns an array of item objects from inventory
	 * @return		inventory ArrayList<Item>
	 */
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	/*
	 * Returns current week
	 * @return		current week
	 */
	public int getWeek() {
		return currentWeek;
	}
	
	
	
// 		setter methods
	
	
	/*
	 * changes money and ensures it's not negative	
	 * @param amount 	amount to change by
	 */
	public void changeMoney(int amount) {
		if((money + amount)<0) {
			System.out.println("Your balance can't be negative");
			money = 0;
		}
		money += amount;
	}
	
	/*
	 * changes total points and ensures it's not negative	
	 * @param amount 	amount to change by
	 */
	public void changePoints(int amount) {
		if((totalPoints + amount) < 0) {
			System.out.println("You can't have negative points");
			totalPoints = 0;
		}
		totalPoints += amount;
	}
	
	
	
	
// 		Print methods
	
	
	/*
	 * Prints the toString() for every Item in inventory
	 */
	public void printInventory() {
		for(Item ite:inventory) {
			System.out.println(ite);
		}
	}
	
	/*
	 * Prints the toString() for every Athlete in given team
	 * @param team 		The team to be printed
	 */
	public void printTeam(ArrayList<Athlete> team) {
		for(Athlete athlete: team) {
			System.out.println(athlete);
		}
	}
	
	
	
	//JUST used for Bye method - Train Athlete
	public Athlete athleteFromInput(String athleteChoice) {
		while(true){
//			System.out.print("\nCurrent Active Team...\n");
//			printTeam(teamList);
//			System.out.print("\nCurrent Bench Team...\n");
//			printTeam(benchList);
//			System.out.print("\nEnter the name of an athlete to select them:");
//			Scanner input = new Scanner(System.in);
//			String athleteChoice = input.nextLine();
			for(Athlete athlete: teamList) {
				if(athlete.getName().equals(athleteChoice)) {
					return athlete;
				}
			}
			for(Athlete athlete: benchList) {
				if(athlete.getName().equals(athleteChoice)) {
					return athlete;
				}
			}
			System.out.println(String.format("%s is not an athlete", athleteChoice));
		}
	}
	
	
	/*
	 * Bye method takes an athlete to train then changes current week,
	 * Resets the Market, Stadium and athlete stamina. After training
	 * the method then runs the random event generator
	 * @param athleteName 		Athlete to be trained
	 */
	public void takeBye(String athleteName) {
		currentWeek ++;
		resetAthletes();
		trainAthlete(athleteName);
		// try for random events
//		runRandomEvents();
		//resetMarket();
		//resetStadium();
	}

	/*
	 * Resets the stamina of all player athletes to 10.
	 */
 	public void resetAthletes() {
 		for(Athlete athlete:teamList) {
 			athlete.changeStamina(10);
 			athlete.changeIsInjured(false);
 		}
 		for(Athlete athlete:teamList) {
 			athlete.changeStamina(10);
 			athlete.changeIsInjured(false);
 		}
 	}
	
 	/*
 	 * Takes athlete to train and increases their position stat 
 	 * depending on the difficulty. 
 	 */
	public void trainAthlete(String athleteName) {
//		Scanner input = new Scanner(System.in);
//		System.out.print("Who will you train?");
		Athlete athlete = athleteFromInput(athleteName);
		if(athlete.getPosition().equals("A")){
			athlete.changeAttack(4-difficulty);
		} else {
			athlete.changeDefence(4-difficulty);
		}
	}
	
	
	/*
	 *  Method for setting default opponents - mainly for testing
	 *  @return 	Default opponent Team
	 */
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
	
	
	
	/*
	 * main menu method - takes inputs and runs game classes
	 */
	public void playGame() {
		System.out.println(String.format("Money: $%s"
				+ "\nWeek: %s", money,currentWeek));
		Scanner input = new Scanner(System.in);
		System.out.print("Where to go? Club('C'), Market('M'), Stadium('S'), Bye('B')");
		String choice = input.nextLine();
		
		if(choice.toUpperCase().equals("C")) {
			Club club = new Club(this);
		}else if(choice.toUpperCase().equals("S")) {
			Stadium stadium = new Stadium(this);
		}else if(choice.toUpperCase().equals("M")) {
			MarketPlace market = new MarketPlace(this);
		}else if(choice.toUpperCase().equals("B")) {
//			takeBye();
		}else {
			System.out.println("Invalid input");
		}
	}
	
	
	//Gui code
	
	
	public void launchMainScreen() {
		MainWindow mainWindow = new MainWindow(this);
	}
	
	public void closeMainScreen(MainWindow mainWindow) {
		mainWindow.closeWindow();
	}
	
	
	public void launchSetupScreen() {
		SetupWindow setupWindow = new SetupWindow(this);
	}
	
	public void closeSetupScreen(SetupWindow setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		MainGame run = new MainGame("Test Team",5,2);
//		System.out.println(run.getTeamsString());
//		run.launchMainScreen();
		//Setup market and Stadium
		while(run.seasonDuration - run.currentWeek >= 0) {
			System.out.println(run);
			run.playGame();
		}
		System.out.println(String.format("The %s team finished the %s week"
				+ " season with $%s and %s points"
				+ "", run.playerName,run.seasonDuration,run.money,run.totalPoints));
//		MainGame game = new MainGame();
//		game.gotoMarket();

	}
	
}
