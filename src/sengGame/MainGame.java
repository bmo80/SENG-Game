package sengGame;
import java.util.*;

import purchasables.Athlete;
import purchasables.Item;
import purchasables.TeamManager;
import windows.GameOverWindow;
import windows.MainWindow;
import windows.SetupBuyPlayerWindow;
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
	 * Player-chosen difficulty 0/1/2 for easy/medium/hard
	 */
	private int difficulty;
	/*
	 * Current week - starting at 1
	 */
	private int currentWeek;
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
	 * Contains both the active and bench teams
	 */
	private TeamManager teams;
	
	public int wins=0;
	public int losses=0;
	public int draws=0;
	
	/*
	 * Constructs Object with given values - used to speed up testing
	 * @param name		Name of player
	 * @param duration		Length of season in weeks
	 * @param chosenDifficulty		difficulty of game
	 */
	public MainGame(String name, int duration, int chosenDifficulty) {
		playerName = name;
		seasonDuration = duration;
		difficulty = chosenDifficulty;
		currentWeek = 1;
		money = 35000 + (5000*(4-difficulty));
	}
	
	public MainGame(String name, int duration, int chosenDifficulty,
			TeamManager givenTeams) {
		playerName = name;
		seasonDuration = duration;
		difficulty = chosenDifficulty;
		currentWeek = 1;
		teams = givenTeams;
		totalPoints = 0;
		inventory = new ArrayList<Item>();
		money = 10000*(3-difficulty);
	}
	
	/*
	 * Returns an array of athlete objects from active team
	 * @return		active team ArrayList<Athlete>
	 */
 	public TeamManager getTeams() {
 		return teams;
 	}
	
 	/*
 	 * Returns player name
 	 * @return		player name
 	 */
	public String getPlayerName() {
		return playerName;
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
	
	public int getDuration() {
		return seasonDuration;
	}

	public int getPoints() {
		return totalPoints;
	}
	
	public String getFinalStats() {
		return String.format("%s FC finished up their %s week season with"
				+ " %s points and $%s on the level %s difficulty."
				+ "\nThanks for playing!",playerName,seasonDuration,totalPoints,
				money, difficulty);
	}
	
	/*
	 * changes money and ensures it's not negative	
	 * @param amount 	amount to change by
	 */
	public void changeMoney(int amount) {
		if((money + amount)<0) {
			System.out.println("Your balance can't be negative");
		}
		else {
			money += amount;
		}
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
		else{
			totalPoints += amount;
		}
	}

	
	public void addItem(Item item) {
		if(inventory.size()>=10) {
			System.out.println("Inventory Full");
		}
		else {
			inventory.add(item);
		}
	}
	
	public void removeItem(Item item) {
		if(!inventory.contains(item)) {
			System.out.println("Item not in inventory");
		}
		else {
			inventory.remove(item);
		}
	}
	
	
	/*
	 * Bye method takes an athlete to train then changes current week,
	 * Resets the Market, Stadium and athlete stamina. After training
	 * the method then runs the random event generator
	 * @param athleteName 		Athlete to be trained
	 */
	public String takeBye(String athleteName) {
		currentWeek ++;
		teams.resetAthletes();
		trainAthlete(athleteName);
		RandomEvent event = new RandomEvent(this);
		return event.generateEvent();
	}

 	/*
 	 * Takes athlete to train and increases their position stat 
 	 * depending on the difficulty. 
 	 */
	public void trainAthlete(String athleteName) {
		Athlete athlete = teams.getAthleteFromString(athleteName);
		if(athlete.getPosition().equals("A")){
			athlete.changeAttack(4-difficulty);
		} else {
			athlete.changeDefence(4-difficulty);
		}
	}
	
	
	
	public boolean checkGameEnd(MarketPlace market) {
		if(teams.getFreeSlotsCount() - market.getPlayerCount() >= 6) {
			//NOT ENOUGH PLAYERS END GAME
			System.out.println("GAME OVER, NOT ENOUGH PLAYERS");
			return true;
		}else if(currentWeek > seasonDuration) {
			//WEEKS OVER
			System.out.println("GAME OVER, SEASON ENDED");
			return true;
		}
		return false;
	}
	
	//Gui code
	
	
	public void launchMainScreen() {
		MarketPlace market = new MarketPlace(this);
		if(checkGameEnd(market)) {
			finishGame();
		}
		else {
			MainWindow mainWindow = new MainWindow(this,market,
					new Stadium(this));
		}
	}
		
	public void finishGame() {
		//Open final window
		GameOverWindow finalWindow = new GameOverWindow(this);
	}
	
	public void closeSetupScreen(SetupBuyPlayerWindow setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	
	//main method for testing and running game
	public static void main(String[] args) {
		//Implement tests
		SetupWindow setupWindow = new SetupWindow();	
	}
	
}
