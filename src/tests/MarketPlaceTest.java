package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import athleteInfo.Item;
import sengGame.MainGame;
import sengGame.MarketPlace;

class MarketPlaceTest {
	private MarketPlace market;
	
	@BeforeEach
	public void init() {
		market = new MarketPlace(new MainGame("test",5,1));
		market.getItemsForSale().add(new Item("Stamina", "Stamina Training Kit",
				5-market.getGameStats().getDifficulty(), 1000));
		market.getItemsForSale().add(new Item("Attack", "Attack Training Kit",
				3-market.getGameStats().getDifficulty(), 1000));
		market.getItemsForSale().add(new Item("Defence", "Defence Training Kit",
				3-market.getGameStats().getDifficulty(), 1000));
		market.getItemsForSale().add(new Item("yea", "yea Training Kit",
				4-market.getGameStats().getDifficulty(), 1000));
	}
	
	@Test
	public void getMoneyTest() {
		assertEquals(50000,market.getGameStats().getMoney());
	}
	
	@Test
	public void generateAthleteTest() {
		market.generateAthletes(3,"A");
		assertEquals(9,market.getPlayersForSale().size());
	}
	
	@Test
	public void getPlayerPositionTest() {
		assertEquals("D",market.getPlayersForSale().get(5).getPosition());
	}
	
	@Test
	public void getPlayerPriceTest() {
		assertEquals(1000*market.getPlayersForSale().get(5).getPositionStat(),
				market.getPlayersForSale().get(5).getBuyPrice());
	}
	
	@Test
	public void getPlayerCountTest() {
		assertEquals(6,market.getPlayerCount());
	}
	
	@Test
	public void changePlayerCountTest() {
		market.getPlayersForSale().get(0).changeName("Purchased");
		assertEquals(5,market.getPlayerCount());
	}
	
	@Test
	public void getGameStatsTest() {
		assertEquals(1,market.getGameStats().getDifficulty());
	}
	
//	@Test
//	void test() {
//		public void generateItems() {
//			//Cleaned up generation and removed unnecessary getItem method
//			
//			
//		}	
//	}

}