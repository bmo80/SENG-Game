package mainMenus;
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
	/**
	 * Name of player/ players team
	 */
	private String playerName;
	/**
	 * Player-chosen length of season in weeks 
	 */
	private int seasonDuration;
	/**
	 * Player-chosen difficulty 0/1/2 for easy/medium/hard
	 */
	private int difficulty;
	/**
	 * Current week - starting at 1
	 */
	private int currentWeek;
	/**
	 * Player's current collection of Item objects
	 */
	private ArrayList<Item> inventory;
	/**
	 * Player's current money balance (for buying Items and Athletes)
	 */
	private int money;
	/**
	 * Player's total points (earned by winning or tying matches)
	 */
	private int totalPoints;
	/**
	 * Contains both the active and bench teams
	 */
	private TeamManager teams;
	

	/**
	 * for keeping track of the player wins
	 */
	private int wins=0;
	/**
	 * for keeping track of the player losses
	 */
	private int losses=0;
	/**
	 * for keeping track of the player draws
	 */
	private int draws = 0;
	
	/**
	 * Constructs Object with given values - used to speed up testing
	 * @param name		Name of player's team
	 * @param duration		Length of season in weeks
	 * @param chosenDifficulty		difficulty of game
	 */
	public MainGame(String name, int duration, int chosenDifficulty) {
		playerName = name;
		seasonDuration = duration;
		difficulty = chosenDifficulty;
		currentWeek = 1;
		money = 35000 + (5000 * (4 - difficulty));
	}
	
	/**
	 * Overloaded Constructor for Main game, takes in extra param TeamManager
	 * @param name Name of the players Team
	 * @param duration Length of Season in Weeks
	 * @param chosenDifficulty difficulty of game (1-3)
	 * @param givenTeams ArrayList of teams to be made into a TeamManager
	 */
	public MainGame(String name, int duration, int chosenDifficulty,
			TeamManager givenTeams) {
		playerName = name;
		seasonDuration = duration;
		difficulty = chosenDifficulty;
		currentWeek = 1;
		teams = givenTeams;
		totalPoints = 0;
		inventory = new ArrayList<Item>();
		money = 10000 * (5 - 2 * difficulty);
	}
	
	/**
	 * Returns TeamManager class containing active team and bench lists
	 * @return	TeamManager class
	 */
 	public TeamManager getTeams() {
 		return teams;
 	}
	
 	/**
 	 * Returns player name
 	 * @return		player name
 	 */
	public String getPlayerName() {
		return playerName;
	}
	
 	/**
 	 * Returns game difficulty
 	 * @return		difficulty
 	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Returns Player money
	 * @return		player money
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * Returns an array of item objects from inventory
	 * @return		inventory ArrayList
	 */
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	
	/**
	 * Returns current week
	 * @return		current week
	 */
	public int getWeek() {
		return currentWeek;
	}
	
	/**
	 * Gets duration of season in weeks
	 * @return duration of season
	 */
	public int getDuration() {
		return seasonDuration;
	}

	/**
	 * Gets the total points the player has earned
	 * @return the total points the player has earned
	 */
	public int getPoints() {
		return totalPoints;
	}
	/**
	 * Gets current wins count
	 * @return current wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * Get current draws
	 * @return current draws
	 */
	public int getDraws() {
		return draws;
	}
	/**
	 * Get current losses
	 * @return current losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * Add 1 to wins
	 */
	public void addWin() {
		wins ++;
	}
	/**
	 * Add 1 to draws
	 */
	public void addDraw() {
		draws ++;
	}
	/**
	 * Add 1 to losses
	 */
	public void addLoss() {
		losses ++;
	}
	
	/**
	 * End game screen message giving the player their points, money
	 * and difficulty played through the season.
	 * @return the String storing that message
	 */
	public String getFinalStats() {
		return String.format("%s FC finished up their %s week season with"
				+ " %s points and $%s on the level %s difficulty."
				+ "\nThanks for playing!",
				playerName, seasonDuration, totalPoints,
				money, difficulty);
	}
	
	/**
	 * changes money and ensures it's not negative	
	 * @param amount 	amount to change by
	 */
	public void changeMoney(int amount) {
		if ((money + amount) >= 0) {
			money += amount;
		}
	}
	
	/**
	 * changes total points and ensures it's not negative	
	 * @param amount 	amount to change by
	 */
	public void changePoints(int amount) {
		if ((totalPoints + amount) >= 0) {
			totalPoints += amount;
		}
	}

	/**
	 * Checks if there is room in the players inventory then adds the item
	 * if there is.
	 * @param item the item potentially being added
	 */
	public void addItem(Item item) {
		if (inventory.size() < 10) {
			inventory.add(item);
		}
	}
	
	/**
	 * Method to attempt to remove and item from the player inventory
	 * @param item the item to be removed
	 */
	public void removeItem(Item item) {
		if (inventory.contains(item)) {
			inventory.remove(item);
		}
	}
	
	
	/**
	 * Bye method takes an athlete to train then changes current week,
	 * Resets the Market, Stadium and athlete stamina. After training
	 * the method then runs the random event generator
	 * @param athleteName 		Athlete to be trained
	 * @return String 		Message about random event
	 */
	public String takeBye(String athleteName) {
		currentWeek ++;
		teams.resetAthletes();
		trainAthlete(athleteName);
		RandomEvent event = new RandomEvent(this);
		return event.generateEvent();
	}

 	/**
 	 * Takes athlete to train and increases their position stat 
 	 * depending on the difficulty. 
 	 * @param athleteName the athlete who is to be trained
 	 */
	public void trainAthlete(String athleteName) {
		Athlete athlete = teams.getAthleteFromString(athleteName);
		if (athlete.getPosition().equals("A")){
			athlete.changeAttack(4 - difficulty);
		}
		else {
			athlete.changeDefence(4 - difficulty);
		}
	}
	
	/**
	 * Checks if the game can be continued to be played. there are 2 situation this fails
	 * Not enough players in the market and the players team to play a game or
	 * this was the last week
	 * @param market the current instance of market
	 * @return True or False if the season has ended
	 */
	public boolean checkGameEnd(MarketPlace market) {
		if (teams.getFreeSlotsCount() > 5) {
			//if there are less than 6 athletes in team.
			int amountNeeded = teams.getFreeSlotsCount() - 5;
			if (market.getPlayerCount() < amountNeeded) {
				return true;
			}
			else {
				int cost = 0;
				for (Athlete athlete: market.getPlayersForSale()) {
					if (!athlete.getName().equals("Purchased")) {
						cost += athlete.getBuyPrice();
						amountNeeded -= 1;
						if (amountNeeded == 0) {
							break;
						}
					}
				}
				if (cost > money) {
					return true;
				}
			}
		}else if (currentWeek > seasonDuration) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Initializes a new market place and launches the main Window
	 * with a new stadium if the game has not ended
	 */
	public void launchMainScreen() {
		MarketPlace market = new MarketPlace(this);
		if (checkGameEnd(market)) {
			finishGame();
		}
		else {
			MainWindow mainWindow = new MainWindow(this,market,
					new Stadium(this));
		}
	}
	
	/**
	 * Method that finishes the game and shows the end game screen
	 */
	public void finishGame() {
		GameOverWindow finalWindow = new GameOverWindow(this);
	}
	
	/**
	 * Closes the setup screen and launches the main screen
	 * @param setupWindow the setup window to be closed
	 */
	public void closeSetupScreen(SetupBuyPlayerWindow setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * Main method from where the program is started
	 * @param args default parameter for main method
	 */
	public static void main(String[] args) {
		SetupWindow setupWindow = new SetupWindow();
	}
	
}
