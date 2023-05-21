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

	//Use to generate new players and refresh items after new week
	public MarketPlace(MainGame game) {
		gameStats = game;
		generateAthletes(NUMBER, "A");
		generateAthletes(NUMBER, "D");
//		generateItems(4);
	}	
	
	public void generateItems(int size) {
		for(int i=0; i<size; i++) {
			//Generate item
			//itemsForSale.add(item);
		}
	}
	
	//Creates "number" amount of players in a given position
	public void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			Athlete athlete = new AthleteGenerator(position,gameStats.getWeek());
			athlete.setBuyPrice(1000*athlete.getPositionStat());
			athlete.setSellPrice(500*athlete.getPositionStat());
			playersForSale.add(athlete);
		}
	}
	
	public ArrayList<Item> getItemsForSale(){
		return itemsForSale;
	}
	
	public ArrayList<Athlete> getPlayersForSale(){
		return playersForSale;
	}
	
	public int getPlayerCount() {
		int i = 0;
		for(Athlete athlete: playersForSale) {
			if(!athlete.getName().equals("Purchased")) {
				i ++;
			}
		}
		return i;
	}
	
	public MainGame getGameStats() {
		return gameStats;
	}

	

}
