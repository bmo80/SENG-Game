package sengGame;

import java.util.ArrayList;

import purchasables.Athlete;
import purchasables.AthleteGenerator;
import purchasables.Item;
import purchasables.ItemGenerator;

/**
 * MarketPlace class deals with creating and storing everything displayed on the market.
 * This involves a maximum of 6 players or 4 items at any given time.
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class MarketPlace{
	
	/**
	 * Initializes an Array to hold all current players for sale
	 */
	private ArrayList<Athlete> playersForSale = new ArrayList<Athlete>();
	/**
	 * Initializes an Array to hold all current Items for sale
	 */
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	/**
	 * MainGame instance to hold the current MainGame object
	 */
	private MainGame gameStats;
	/**
	 * Initializes an Array to hold all the players available for purchase on the setup screen.
	 */
	private ArrayList<Athlete> setupPlayers = new ArrayList<Athlete>();

	/**
	 * Constructor for market place. Generates 6 Athletes, 3 of each type
	 * and 4 random items.
	 * @param game current MainGame object
	 */
	public MarketPlace(MainGame game) {
		gameStats = game;
		generateAthletes(3, "A");
		generateAthletes(2, "D");
		generateItems();
	}
	
	/**
	 * Generates a given number of athletes in a given position and sets
	 * their buy and sell price based on their positional stat.
	 * @param size The number of Athletes to be Generated
	 * @param position
	 */
	public void generateAthletes(int size, String position) {
		for (int i=0; i < size; i ++) {
			Athlete athlete = new AthleteGenerator(position,
					gameStats.getWeek());
			athlete.setBuyPrice(1000 * athlete.getPositionStat());
			athlete.setSellPrice(500 * athlete.getPositionStat());
			playersForSale.add(athlete);
		}
	}
	
	/**
	 * Generates 4 random items for the item store
	 */
	public void generateItems() {
		for (int i = 0; i < 4; i ++) {
			ItemGenerator item = new ItemGenerator();
			itemsForSale.add(item);
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
		for (Athlete athlete: playersForSale) {
			if (!athlete.getName().equals("Purchased")) {
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
	 * Gets all the players for sale on the setup screen
	 * @return the ArrayList containing all the setup screen players for sale
	 */
	public ArrayList<Athlete> getSetupPlayers() {
		return setupPlayers;
	}
	
	/**
	 * Generates the 10 players shown on the setup screen
	 * only even used on game initialization
	 */
	public void createSetUp() {
		for(int i = 0; i < 5; i ++) {
			setupPlayers.add(new AthleteGenerator("A", gameStats.getWeek()));
		}
		for(int i = 0; i < 5; i ++) {
			setupPlayers.add(new AthleteGenerator("D", gameStats.getWeek()));
		}
	}
}
