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
		//test inventory
		inventory = setInventory();
		money = 1000;
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
		if(chosenItem.getType() == "STA") {
			chosenAthlete.changeStamina(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "ATK") {
			chosenAthlete.changeOffence(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "DEF") {
			chosenAthlete.changeDefence(chosenItem.getEffect());
		}
		if(chosenItem.getType() == "HP") {
			chosenAthlete.changeHealth(chosenItem.getEffect());
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
	
	public Boolean allInjured() {
		for(Athlete athlete: teamList) {
			if(!athlete.getIsInjured()) {
				return false;
			}
		}
		return true;
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
		athleteFromString(choice).changeDefence(2);
		athleteFromString(choice).changeOffence(2);
		input.close();
	}
	
	
	
	//VERY icky method - basically just a beta/skeleton version
	public void matchSort(ArrayList<Athlete> teamToSort) {
		//expects team with 6 members - 3 attack, 3 defense
		ArrayList<Athlete> atkTeam = new ArrayList<Athlete>();
		ArrayList<Athlete> defTeam = new ArrayList<Athlete>();
		for(Athlete athlete: teamToSort) {
			if(athlete.getPosition().equals("A")) {
				if((atkTeam.size()>0)&&(athlete.getOffence()>atkTeam.get(atkTeam.size()-1).getOffence())){
					atkTeam.add(0,athlete);
				}else {
					atkTeam.add(athlete);
				}
			}else if(athlete.getPosition().equals("D")) {
				if((defTeam.size()>0)&&(athlete.getDefence()>defTeam.get(defTeam.size()-1).getDefence())){
					defTeam.add(0,athlete);
				}else {
					defTeam.add(athlete);
				}
			}
		}
		atkTeam.addAll(defTeam);
		teamToSort= atkTeam;
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
		//Fill in random generation of teams (6 opponents: 3 def, 3 atk)
		// For testing purposes im assuming they will be in a 2D list.
		//For testing purposes lets say there are 3 teams to choose from
//		Scanner input = new Scanner(System.in);
//		int choice = input.nextInt();
		//selects the opposing team based on user input
		playMatch(makeOpponents());
	}
	
	
	public ArrayList<Athlete> makeOpponents(){
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		team.add(new Athlete("attack1",8,2,"A"));
		team.add(new Athlete("defend1",2,7,"D"));
		team.add(new Athlete("attack2",1,1,"A"));
		team.add(new Athlete("defend2",1,1,"D"));
		team.add(new Athlete("attack3",1,0,"A"));
		team.add(new Athlete("defend3",1,1,"D"));
		return team;
	}
	
	
	
	public void gotoMarket() {
		System.out.println("Welcome to the Market!\n");
		MarketPlace market = new MarketPlace();
		for(Athlete player: market.players) {
			System.out.println(player.shortDescription());
		}
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
	
	
	
	
	//Currently this works by playing each athlete against their corresponding opponent
	//BUT!! this could be changed: the best athlete will continue to compete until 
	//they lose all their stamina!
	public void playMatch(ArrayList<Athlete> opponents) {
		// ensure match can start - might move to Stadium method
		if(teamList.size()<6) {
			//Team too small error
		}else if(allInjured()) {
			//Team all injured error
		}
		// ensure teams are sorted before match begins
		matchSort(opponents);
		matchSort(teamList);
		int opsScore = 0;
		int playerScore = 0;
		for(int i=0;i<6;i++) {
			//if there is a tie the Player gets a point - could change with difficulty
			if(teamList.get(i).getStamina()==0) {
				//Default win as athlete is exhausted
				opsScore ++ ;
			}else if(opponents.get(i).getPositionStat()>teamList.get(i).getPositionStat()){
				opsScore ++ ;
				//Lost face off leads to losing stamina equal to difficulty
				teamList.get(i).changeStamina(-difficulty);			
			}else {
				playerScore ++ ;
			}
			teamList.get(i).changeStamina(-1);
		}
		//if there is a tie the Player still gets money and points  - but less
		//This is an implementation of criteria 3b.iv
		if(allInjured()) {
			//Send message - All athletes were injured so default loss 
		}else if(opsScore>playerScore) {
			//Send message - Opponents win
		}else if(playerScore>opsScore){
			//Send message - You won!
			//Arbitrary points and money atm
			totalPoints = totalPoints + 2;
			money = money + 2500;
		}else {
			//Tie condition - send message
			totalPoints ++;
			money = money + 1000;
		}
		
		
		// change week after match???
//		currentWeek ++;
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
		input.close();
	}
	
	
	
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		//MainGame run = new MainGame("Test Team",5,3);
		
		//run.printInventory();
		
		//while(run.seasonDuration - run.currentWeek >= 0) {
			//System.out.println(run);
			//run.playGame();
		//}
		//System.out.println(String.format("The %s team finished the %s week"
				//+ " season with $%s and %s points"
				//+ "", run.teamName,run.seasonDuration,run.money,run.totalPoints));
		MainGame game = new MainGame();
		game.gotoMarket();

	}
	
}
