package sengGame;

import java.util.ArrayList;
import java.util.Scanner;
import windows.MarketPlaceWindow;
import athleteInfo.Item;
import athleteInfo.Athlete;
import athleteInfo.TeamManager;
import athleteInfo.AthleteGenerator;

public class MarketPlace{
	
	//Number constant to define amount of atk/def players
	private int NUMBER = 3;
	private ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	private MainGame gameStats;
	private ArrayList<Athlete> setupPlayers = new ArrayList<Athlete>();
	//Use to generate new players and refresh items after new week
	public MarketPlace(MainGame game) {
		gameStats = game;
		generateAthletes(NUMBER, "A");
		generateAthletes(NUMBER, "D");
//		generateItems(4);
	}	
	
	

	
	
	
	/**
	 * Generates a given number of athletes in a given position
	 * @param size The number of Athletes to be Generated
	 * @param position
	 */
	public void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			Athlete athlete = new AthleteGenerator(position,gameStats.getWeek());
			athlete.setBuyPrice(1000*athlete.getPositionStat());
			athlete.setSellPrice(500*athlete.getPositionStat());
			playersForSale.add(athlete);
		}
	}
	
	
	
	/**
	 * Gets the current items for sale in the market
	 * @return ArrayList of items for sale
	 */
	public ArrayList<Item> getItemsForSale(){
		return itemsForSale;
	}
	/**
	 * Gets the current players for sale in the market
	 * @return ArrayList of Players for sale
	 */
	public ArrayList<Athlete> getPlayersForSale(){
		return playersForSale;
	}
	
	/**
	 * Gets the number of players still available for sale in the market
	 * @return The number of players
	 */
	public int getPlayerCount() {
		int i = 0;
		for(Athlete athlete: playersForSale) {
			if(!athlete.getName().equals("Purchased")) {
				i ++;
			}
		}
		return i;
	}
	
	/**
	 * Gets the running MainGame instance
	 * @return current instance of MainGame
	 */
	public MainGame getGameStats() {
		return gameStats;
	}
	
	/**
	 * Generates the items for sale in the marketplace
	 */
	
	
	public ArrayList<Athlete> getSetupPlayers() {
		return setupPlayers;
	}
	
	public void createSetUp() {
		for(int i=0; i<5; i++) {
			setupPlayers.add(getAthlete("A"));
		}
		for(int i=0; i<5; i++) {
			setupPlayers.add(getAthlete("D"));
		}
	}

}
