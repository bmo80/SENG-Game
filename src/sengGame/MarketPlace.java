package sengGame;

import java.util.ArrayList;
import java.util.Scanner;
import windows.MarketPlaceWindow;
import athleteInfo.Item;
import athleteInfo.Athlete;
import athleteInfo.AthleteGenerator;

public class MarketPlace{
	
	//Number constant to define amount of atk/def players
	private int NUMBER = 3;
	public ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	//3 MAIN types: Stamina,Offence,Defence
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	private int difficulty;
	//Added current Team and bench Team as vars
	private ArrayList<Athlete> team;
	private ArrayList<Athlete> bench;
	private ArrayList<Item> inventory;
	public int money;
	private int week;

	MarketPlace(){
		generateAthletes(NUMBER, "A");
		generateAthletes(NUMBER, "D");
		generateItems();
		MarketPlaceWindow window = new MarketPlaceWindow(this);
	}
	
	//Use to generate new players and refresh items after new week
	//Changed from method into constructor
	MarketPlace(int diff,ArrayList<Athlete> currentTeam, ArrayList<Athlete> currentBench,
			ArrayList<Item> currentInventory, int currentMoney, int currentWeek) {
		week = currentWeek;
		difficulty = diff;
		team = currentTeam;
		bench = currentBench;
		inventory = currentInventory;
		money = currentMoney;
		generateAthletes(NUMBER, "A");
		generateAthletes(NUMBER, "D");
		generateItems();
		MarketPlaceWindow window = new MarketPlaceWindow(this);
	}
	//Entering the market to buy/sell things.
	public int enterMarket() {
		
//		System.out.println("Welcome to the MarketPlace, here you can buy or sell items and players");
//		System.out.println("Players and items reset once you have played your weekly game (E to exit)\n");
		Scanner scan = new Scanner(System.in);
		String userInput= "";
		while(!userInput.toUpperCase().equals("E")) {
			//Moved the text here so the user knows when the input resets.
			System.out.println("Welcome to the MarketPlace, here you can buy or sell items and players\n"
					+ "Players and items reset once you have played your weekly game \n"
					+ "To see Players Enter 'P', to see Items Enter 'I' or 'E' to exit");
			userInput = scan.nextLine();
			//Allows for lower case p to be accepted too
			if(userInput.toUpperCase().equals("P")) {
				System.out.println("Players available for purchase this week...\n");
				printPlayers();
				System.out.println("Which player would you like to purchase? (Enter FULL name)");
				String athleteName = scan.nextLine();
				for(Athlete athlete: playersForSale) {
					if(athlete.getName().equals(athleteName)) {
						//Needs to be changed so that athlete can go to bench, 
						//or team (by swapping a team player to bench)
						if((money - athlete.getBuyPrice()) >= 0) {
							team.add(athlete);
							money -= athlete.getBuyPrice();
							System.out.println(money);
						} else {
							System.out.println(money);
							System.out.println(athlete.getBuyPrice());
							System.out.println("Insufficient funds");
						}

						break;
					}
				}
			}else if(userInput.toUpperCase().equals("I")) {
				System.out.println("Items available for purchase this week...\n");
				printItems();
				System.out.println("Which Item would you like to purchase? (Enter FULL name)");
				String itemName = scan.nextLine();
				for(Item item: itemsForSale) {
					if(item.getName().equals(itemName)) {
						//Needs to be changed so that athlete can go to bench, 
						//or team (by swapping a team player to bench)
						inventory.add(item);
						money -= item.getBuyPrice();
						break;
					}
				}
			}else if(userInput.toUpperCase().equals("E")) {
				System.out.println("Leaving Market...");				
			}else {
				System.out.println("\nInvalid input...\n");
			}	
		}
		return money;
	}
	
	
	//Creates "number" amount of players in a given position
	private void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			playersForSale.add(getAthlete(position));
		}
	}
	
	//Uses AthleteGenerator Class to generate a randomly made athlete
	private Athlete getAthlete(String position) {
		return new AthleteGenerator(position,week);
	}
	
	//Generates one of each type of item
	//Currently No randomness
	private void generateItems() {
		//Cleaned up generation and removed unnecessary getItem method
		itemsForSale.add(new Item("Stamina", "Stamina Training Kit", 5-difficulty, 1000));
		itemsForSale.add(new Item("Attack", "Attack Training Kit", 3-difficulty, 1000));
		itemsForSale.add(new Item("Defence", "Defence Training Kit", 3-difficulty, 1000));
		
	}	
	
	private void printPlayers() {
		for(Athlete player: playersForSale) {
			System.out.println(player);
		}
	}
	
	private void printItems() {
		for(Item item: itemsForSale) {
			System.out.println(item);
		}
	}

	public static void main (String[] args) {
		MarketPlace market = new MarketPlace();
		market.enterMarket();
		
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getWeek() {
		return week;
	}
}
