package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mainMenus.MainGame;
import mainMenus.MarketPlace;
import purchasables.Item;

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
		assertEquals(8,market.getPlayersForSale().size());
	}
	
	@Test
	public void getPlayerPositionTest() {
		assertEquals("D",market.getPlayersForSale().get(4).getPosition());
	}
	
	@Test
	public void getPlayerPriceTest() {
		assertEquals(1000*market.getPlayersForSale().get(4).getPositionStat(),
				market.getPlayersForSale().get(4).getBuyPrice());
	}
	
	@Test
	public void getPlayerCountTest() {
		assertEquals(5,market.getPlayerCount());
	}
	
	@Test
	public void changePlayerCountTest() {
		market.getPlayersForSale().get(0).changeName("Purchased");
		assertEquals(4,market.getPlayerCount());
	}
	
	@Test
	public void getGameStatsTest() {
		assertEquals(1,market.getGameStats().getDifficulty());
	}
	
//	@Test
//	public void advancedTest() {
//		
//	}

}
