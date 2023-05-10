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
		difficulty = chosenDifficulty;
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		benchList.add(new Athlete("bench1",5,5,"A"));
		TeamManager teams = new TeamManager(teamList,benchList);
		//test inventory
		inventory = setInventory();
		money = 100000;
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
		
		// Currently TeamList is set as a static team
		teamList = setTeam();
		currentWeek = 1;
		benchList = new ArrayList<Athlete>();
		TeamManager teams = new TeamManager(teamList,benchList);
		inventory = new ArrayList<Item>();
		money = 0;
	}
	
	//Override toString method
	@Override
	public String toString() {
		//Note: the BenchList,TeamList and Inventory are printed with DIFFERENT methods - might change
		return String.format("The %s team has a %s week season, they are currently on week"
				+ " %s. The difficulty is %s/2 and they have $%s"
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
		inventory.add(new Item("Juice","Stamina",5,15));
		inventory.add(new Item("Speed","Attack",1,25));
		inventory.add(new Item("Grippers","Defence",1,25));
		inventory.add(new Item("Bandages","HP",20,20));
		return inventory;
	}
	
	
	// getter methods - NOT ALL
	
	//Should be in Team manager class
// 	public ArrayList<Athlete> getTeamList() {
// 		return teamList;
// 	}
	
	public String getTeamName() {
		return teamName;
	}
	
	// BenchList is now separte object - print via TeamManager class
// 	public ArrayList<Athlete> getBenchList() {
// 		return benchList;
// 	}
	
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
	
	//Use via TeamManager class
// 	public void addAthlete(Athlete chosenAthlete) {
// 		if(teamList.size() >= 6){
// 			// Call Exception - team full - overflow to bench?
// 			benchAthlete(chosenAthlete);
// 		}else {
// 			teamList.add(chosenAthlete);
// 		}
// 	}
	
	
	//MarketPlace functions
//	public void useItem(Item chosenItem,Athlete chosenAthlete) {
//		if(chosenItem.getType() == "STA") {
//			chosenAthlete.changeStamina(chosenItem.getEffect());
//		}
//		if(chosenItem.getType() == "ATK") {
//			chosenAthlete.changeOffence(chosenItem.getEffect());
//		}
//		if(chosenItem.getType() == "DEF") {
//			chosenAthlete.changeDefence(chosenItem.getEffect());
//		}
//		inventory.remove(chosenItem);
//	}
	
//	public void buyItem(Item item) {
//		if(money-item.getBuyPrice()>0) {
//			money = money - item.getBuyPrice();
//			inventory.add(item);
//		}
//	}
//	
//	public void buyAthlete(Athlete athlete) {
//		if(money-athlete.getBuyPrice()>0) {
//			money = money - athlete.getBuyPrice();
//			addAthlete(athlete);
//			// check for space before removing money??
//		}
//	}
	

	
	
	//Print methods
	//Prints inventory
	public void printInventory() {
		for(Item ite:inventory) {
			System.out.println(ite);
		}
	}
	
	public void printTeam(ArrayList<Athlete> team) {
		for(Athlete athlete: team) {
			System.out.println(athlete);
		}
	}
	
	//Reused from Club class - could move to Team manager instead?
	public Athlete athleteFromInput() {
		while(true){
			System.out.print("\nCurrent Active Team...\n");
			printTeam(teamList);
			System.out.print("\nCurrent Bench Team...\n");
			printTeam(benchList);
			System.out.print("\nEnter the name of an athlete to select them:");
			Scanner input = new Scanner(System.in);
			String athleteChoice = input.nextLine();
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
	
	
	//Bye could be moved to own class (but for now its just a button
	//so shouldn't be necessary)
	public void takeBye() {
		currentWeek ++;
		resetAthletes();
//		 train athlete - if chosen
		trainAthlete();
		// try for random events
//		runRandomEvents();
		//resetMarket();
		//resetStadium();
	}

	
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
	
	public void trainAthlete() {
		Scanner input = new Scanner(System.in);
		System.out.print("Who will you train?");
		Athlete athlete = athleteFromInput();
		if(athlete.getPosition().equals("A")){
			athlete.changeAttack(4-difficulty);
		} else {
			athlete.changeDefence(4-difficulty);
		}
	}
	
	
	// method for being 'at the club' - can swap out athletes and use items
	public void gotoClub() {
		Club club = new Club(teamList,benchList,inventory);		
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
		MarketPlace market = new MarketPlace(difficulty,teamList,benchList, inventory, money);
		market.enterMarket();
		
		
		// Shouldn't be needed??
//		for(Athlete player: market.playersForSale) {
//			System.out.println(player.getShortDescription());
//		}
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
	}
	
	
	
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		MainGame run = new MainGame("Test Team",5,2);
		
		//run.printInventory();
		//Setup market and Stadium
		while(run.seasonDuration - run.currentWeek >= 0) {
			System.out.println(run);
			run.playGame();
		}
		System.out.println(String.format("The %s team finished the %s week"
				+ " season with $%s and %s points"
				+ "", run.teamName,run.seasonDuration,run.money,run.totalPoints));
//		MainGame game = new MainGame();
//		game.gotoMarket();

	}
	
}
