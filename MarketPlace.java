package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

public class MarketPlace extends MainGame{
	
	private int number = 2;
	ArrayList<Athlete> players;
	//3 MAIN types: Stamina,Offence,Defence
	ArrayList<Item> items;
	private int difficulty;

	//Use to generate new players and refresh items after new week
	public void generateNewMarket(int diff) {
		difficulty = diff;
		players = new ArrayList<Athlete>();
		generateAthletes(number, "A");
		generateAthletes(number, "D");
		items = new ArrayList<Item>();
		generateItems();
	}
	//Entering the market to buy/sell things.
	public void enterMarket() {
		
		System.out.println("Welcome to the MarketPlace, here you can buy or sell items and players");
		System.out.println("Players and items reset once you have played your weekly game (E to exit)\n");
		Scanner scan = new Scanner(System.in);
		String userInput= "";
		while(!userInput.equals("E")) {
			userInput = scan.nextLine();
			if(userInput.equals("P")) {
				System.out.println("Players available for purchase this week...\n");
				printPlayers();
				String athleteName = scan.nextLine();
				System.out.println("Which player would you like to purchase?");
				for(Athlete athlete: players) {
					if(athlete.getName().equals(athleteName)) {
						addAthlete(athlete);
						break;
					}
				}
				
				
			}
		
			
			userInput = scan.nextLine();	
		}
		scan.close();
	}
	
	
	//Creates "number" amount of players in a given position
	private void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			players.add(getAthlete(position));
		}
	}
	
	//Uses AthleteGenerator Class to generate a randomly made athlete
	private Athlete getAthlete(String position) {
		AthleteGenerator athlete = new AthleteGenerator(position);
		return athlete;
	}
	
	//Generates one of each type of item
	private void generateItems() {
		items.add(getItem("Stamina", "Stamina Training Kit", 5-difficulty, 1000));
		items.add(getItem("Attack", "Attack Training Kit", 3-difficulty, 1000));
		items.add(getItem("Defence", "Defence Training Kit", 3-difficulty, 1000));
		
	}
	
	private Item getItem(String type, String name, int effect, int cost) {
		Item item = new Item(name, type, effect, cost);
		return item;
	}
	
	
	
	private void printPlayers() {
		for(Athlete player: players) {
			System.out.println(player.getShortDescription());
		}
	}
	
	private void printItems() {
		for(Item item: items) {
			System.out.println(item);
		}
	}
	
	public static void main (String[] args) {
		MarketPlace market = new MarketPlace();
		market.generateNewMarket(1);
		market.enterMarket();
		
	}
}
