package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

import athleteInfo.Athlete;
import athleteInfo.Item;

public class Club {
	
	private ArrayList<Athlete> benchList;
	private ArrayList<Athlete> teamList;
	private ArrayList<Item> inventory;
	
	//Constructor sets values and starts logic
	Club(ArrayList<Athlete> Team,ArrayList<Athlete> Bench,ArrayList<Item> Inventory){
		benchList = Bench;
		teamList = Team;
		inventory = Inventory;
		gotoClub();
	}
	
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
	
	public Item itemFromString(String itemName) {
		for(Item item: inventory) {
			if(item.getName().equals(itemName)) {
				return item;
			}
		}
		//Should never be needed
		return new Item();
	}
	
	public Athlete athleteFromString(String athleteName) {
		for(Athlete athlete: teamList) {
			if(athlete.getName().equals(athleteName)) {
				return athlete;
			}
		}
		for(Athlete athlete: benchList) {
			if(athlete.getName().equals(athleteName)) {
				return athlete;
			}
		}
		//Should never be needed
		return new Athlete();
	}
	
	
	
	
	
	public void printTeam(ArrayList<Athlete> team) {
		for(Athlete athlete: team) {
			System.out.println(athlete);
		}
	}
	
	public String teamInput() {
		System.out.print("\nEnter the name of an athlete to select them or 'E' to return:");
		Scanner input = new Scanner(System.in);
		String athleteChoice = input.nextLine();
		if(athleteChoice.toUpperCase().equals("E")) {
			return "E";
		}
		for(Athlete athlete: teamList) {
			if(athlete.getName().equals(athleteChoice)) {
				return athlete.getName();
			}
		}
		for(Athlete athlete: benchList) {
			if(athlete.getName().equals(athleteChoice)) {
				return athlete.getName();
			}
		}
		return "ERROR";
	}
		
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
	
	public void viewTeam() {
		String athleteChoice = "";
		while(!(athleteChoice.toUpperCase().equals("E"))) {
			System.out.print("\nCurrent Active Team...\n");
			printTeam(teamList);
			System.out.print("\nCurrent Bench Team...\n");
			printTeam(benchList);
			athleteChoice = teamInput();
			if(athleteChoice.equals("ERROR")) {
				System.out.println("input was not an athlete or 'E'");
			}else if(!athleteChoice.equals("E")){
				swapAthlete(athleteChoice);								
			}
		}
	}
	
	
	
	public void Swap(Athlete athleteOne, Athlete athleteTwo) {
		//Currently does NOT take index into account
		if(teamList.contains(athleteOne) && benchList.contains(athleteTwo)) {
			teamList.remove(athleteOne);
			teamList.add(athleteTwo);
			benchList.remove(athleteTwo);
			benchList.add(athleteOne);
		}else if(benchList.contains(athleteOne) && teamList.contains(athleteTwo)){
			teamList.remove(athleteTwo);
			teamList.add(athleteOne);
			benchList.remove(athleteOne);
			benchList.add(athleteTwo);
		}else {
			//Must be in same section so Index swap would go here
		}
	}
	
	
	public void printInventory() {
		for(Item item: inventory) {
			System.out.println(item);
		}
	}
	
	public String inventoryInput() {
		System.out.print("\nEnter the name of an item to select it or 'E' to return to the Club:");
		Scanner input = new Scanner(System.in);
		String itemChoice = input.nextLine();
		if(itemChoice.toUpperCase().equals("E")) {
			return "E";
		}
		for(Item item: inventory) {
			if(item.getName().equals(itemChoice)) {
				return item.getName();
			}
		}
		return "ERROR";
	}
	
	public void useItem(String itemChoice) {
		System.out.print(String.format("\nEnter the name of an athlete to use %s"
				+ " on them or 'E' to return",itemChoice));
		System.out.print("\nCurrent Active Team...\n");
		printTeam(teamList);
		System.out.print("\nCurrent Bench Team...\n");
		printTeam(benchList);
		String athleteChoice = "";
		while(!(athleteChoice.toUpperCase().equals("E"))) {
			athleteChoice = teamInput();
			if(athleteChoice.equals("ERROR")) {
				System.out.println("input was not an athlete or 'E'");
			}else if(!athleteChoice.equals("E")){
				System.out.println(String.format("Using %s on %s",itemChoice,athleteChoice));
				athleteFromString(athleteChoice).useItem(itemFromString(itemChoice));
				inventory.remove(itemFromString(itemChoice));
				System.out.print("Returning to Inventory...");
				athleteChoice = "E";
			}
		}	
	}
	
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
	
	
	
	
	
	
	public void gotoClub() {
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
