package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

import athleteInfo.Athlete;
import athleteInfo.Item;

public class Club {
	
	/*
	 * stores all game variables from MainGame class
	 */
	private MainGame gameStats;
	
	/*
	 * Initializes object and runs logic
	 * @param currentStats		GameInfo
	 */
	public Club(MainGame currentStats) {
		gameStats = currentStats;
		goToClub();
	}
	
	/*
	 * checks input and returns string accordingly
	 */
	public String getInput() {
		System.out.print("\nEnter 'T' to view Team, 'I' to view Inventory or 'E' to Exit:"); 
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		if((!choice.toUpperCase().equals("T")&&!choice.toUpperCase().equals("I")&&!choice.toUpperCase().equals("E"))) {
			System.out.println(String.format("Invalid input %s is not 'E','T' or 'I'",choice));
		}else {
			return choice.toUpperCase();
		}
		return "";
	}
	
	/*
	 * returns Item object from String item name
	 * @param itemName 		name of item
	 * @return 		First Item in inventory that matches given name
	 */
	public Item itemFromString(String itemName) {
		for(Item item: gameStats.getInventory()) {
			if(item.getName().equals(itemName)) {
				return item;
			}
		}
		//If item not in list 
		//wrong inputs should be caught earlier
		return new Item();
	}
	
	/*
	 * returns Item object from String item name
	 * @param itemName 		name of item
	 * @return 		First Item in inventory that matches given name
	 */
	public Athlete athleteFromString(String athleteName) {
		for(Athlete athlete: gameStats.getTeams().getTeamList()) {
			if(athlete.getName().equals(athleteName)) {
				return athlete;
			}
		}
		for(Athlete athlete: gameStats.getBenchList()) {
			if(athlete.getName().equals(athleteName)) {
				return athlete;
			}
		}
		//if not in lists
		//wrong inputs should be caught earlier
		return new Athlete();
	}
	
	
	/*
	 * Represents each athlete with their ToString
	 * @param team		Team to print out
	 */
	public void printTeam(ArrayList<Athlete> team) {
		for(Athlete athlete: team) {
			System.out.println(athlete);
		}
	}
	
	/*
	 * Used to ensure that athleteFromString never gets an invalid input
	 * @return 		the name of an athlete or ERROR if invalid
	 */
	public String teamInput() {
		System.out.print("\nEnter the name of an athlete to select them or 'E' to return:");
		Scanner input = new Scanner(System.in);
		String athleteChoice = input.nextLine();
		if(athleteChoice.toUpperCase().equals("E")) {
			return "E";
		}
		for(Athlete athlete: gameStats.getTeams().getTeamList()) {
			if(athlete.getName().equals(athleteChoice)) {
				return athlete.getName();
			}
		}
		for(Athlete athlete: gameStats.getBenchList()) {
			if(athlete.getName().equals(athleteChoice)) {
				return athlete.getName();
			}
		}
		return "ERROR";
	}
	
	
	/*
	 * Awaits input to potentially swap athletes
	 * @param firstAthleteChocie	name of first Athlete to swap
	 *  
	 */
	public void swapAthlete(String firstAthleteChoice) {
		System.out.print("\nSelect another athlete to swap"
				+ " their positions or 'E' to return");
		String secondAthleteChoice = "";
		while(!(secondAthleteChoice.toUpperCase().equals("E"))) {
			secondAthleteChoice = teamInput();
			if(secondAthleteChoice.equals("ERROR")) {
				System.out.println("input was not an athlete or 'E'");
			}else if(!secondAthleteChoice.equals("E")){
				System.out.println(String.format("Swapping %s and %s",firstAthleteChoice,secondAthleteChoice));
				Swap(athleteFromString(firstAthleteChoice),athleteFromString(secondAthleteChoice));
				System.out.print("Returning to Team view...");
				secondAthleteChoice = "E";
			}
		}	
	}	
	
	/*
	 * Sub menu for Club class - represents both teams and awaits input
	 */
	public void viewTeam() {
		String athleteChoice = "";
		while(!(athleteChoice.toUpperCase().equals("E"))) {
			System.out.print("\nCurrent Active Team...\n");
			printTeam(gameStats.getTeams().getTeamList());
			System.out.print("\nCurrent Bench Team...\n");
			printTeam(gameStats.getBenchList());
			athleteChoice = teamInput();
			if(athleteChoice.equals("ERROR")) {
				System.out.println("input was not an athlete or 'E'");
			}else if(!athleteChoice.equals("E")){
				swapAthlete(athleteChoice);								
			}
		}
	}
	
	/*
	 * method to swap two athletes
	 * moves them between lists
	 * @param athleteOne	first athlete to swap
	 * @param athleteTwo 	second athlete to swap
	 */
	public void Swap(Athlete athleteOne, Athlete athleteTwo) {
		//Currently does NOT take index into account
		if(gameStats.getTeams().getTeamList().contains(athleteOne) && gameStats.getBenchList().contains(athleteTwo)) {
			gameStats.getTeams().getTeamList().remove(athleteOne);
			gameStats.getTeams().getTeamList().add(athleteTwo);
			gameStats.getBenchList().remove(athleteTwo);
			gameStats.getBenchList().add(athleteOne);
		}else if(gameStats.getBenchList().contains(athleteOne) && gameStats.getTeams().getTeamList().contains(athleteTwo)){
			gameStats.getTeams().getTeamList().remove(athleteTwo);
			gameStats.getTeams().getTeamList().add(athleteOne);
			gameStats.getBenchList().remove(athleteOne);
			gameStats.getBenchList().add(athleteTwo);
		}else {
			//Must be in same section so Index swap would go here
		}
	}
	
	/*
	 * Represents each item in inventory with its ToString
	 */
	public void printInventory() {
		for(Item item: gameStats.getInventory()) {
			System.out.println(item);
		}
	}
	
	/*
	 * gets input for name of item to use, ensures no invalid
	 * input for itemFromString method
	 * @return 		Name of item, E or ERROR if invalid
	 */
	public String inventoryInput() {
		System.out.print("\nEnter the name of an item to select it or 'E' to return to the Club:");
		Scanner input = new Scanner(System.in);
		String itemChoice = input.nextLine();
		if(itemChoice.toUpperCase().equals("E")) {
			return "E";
		}
		for(Item item: gameStats.getInventory()) {
			if(item.getName().equals(itemChoice)) {
				return item.getName();
			}
		}
		return "ERROR";
	}
	
	/*
	 * Awaits input to potentially use an item
	 * @param itemChoice 	name of item to use 
	 */
	public void useItem(String itemChoice) {
		System.out.print(String.format("\nEnter the name of an athlete to use %s"
				+ " on them or 'E' to return",itemChoice));
		System.out.print("\nCurrent Active Team...\n");
		printTeam(gameStats.getTeams().getTeamList());
		System.out.print("\nCurrent Bench Team...\n");
		printTeam(gameStats.getBenchList());
		String athleteChoice = "";
		while(!(athleteChoice.toUpperCase().equals("E"))) {
			athleteChoice = teamInput();
			if(athleteChoice.equals("ERROR")) {
				System.out.println("input was not an athlete or 'E'");
			}else if(!athleteChoice.equals("E")){
				System.out.println(String.format("Using %s on %s",itemChoice,athleteChoice));
				athleteFromString(athleteChoice).useItem(itemFromString(itemChoice));
				gameStats.getInventory().remove(itemFromString(itemChoice));
				System.out.print("Returning to Inventory...");
				athleteChoice = "E";
			}
		}	
	}
	
	/*
	 * Sub menu for Club class - represents inventory and awaits input
	 */
	public void viewInventory() {
		String itemChoice = "";
		while(!(itemChoice.toUpperCase().equals("E"))) {
			System.out.print("\nCurrent Inventory:\n");
			printInventory();
			itemChoice = inventoryInput();
			if(itemChoice.equals("ERROR")) {
				System.out.println("input was not an item or 'E'");
			}else if(!itemChoice.equals("E")){
				useItem(itemChoice);								
			}
		}		
	}
	
	
	/*
	 * Main menu method for Club class, awaits input
	 */
	public void goToClub() {
		System.out.println("\nWelcome to the Club! Here you can view your Team, swap players, view your Inventory and use items");
		String choice = "";
		while(!(choice.toUpperCase().equals("E"))) {
			choice = getInput(); 
			
			if(choice.equals("T")) {
				viewTeam();
			}else if(choice.equals("I")) {
				viewInventory();
			}		
		}
	}

}
