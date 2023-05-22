package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasables.Athlete;
import purchasables.Item;
import purchasables.TeamManager;
import sengGame.MainGame;
import sengGame.MarketPlace;

class MainGameTest {
	private MainGame mainGameTest;
	
	@BeforeEach
	public void init() {
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		team.add(new Athlete("attack1",7,2,"A"));
		team.add(new Athlete("defend1",2,6,"D"));
		team.add(new Athlete("attack2",3,1,"A"));
		team.add(new Athlete("defend2",1,4,"D"));
		team.add(new Athlete("attack3",10,0,"A"));
		team.add(new Athlete("defend3",1,9,"D"));
		ArrayList<Athlete> bench = new ArrayList<Athlete>();
		bench.add(new Athlete("bench", 0,0,"A"));
		mainGameTest = new MainGame("test",5,1,new TeamManager(team,bench));
		mainGameTest.addItem(new Item("Juice","Stamina",5,15));
		mainGameTest.addItem(new Item("Speed","Attack",1,25));
		mainGameTest.addItem(new Item("Grippers","Defence",1,25));
		mainGameTest.addItem(new Item("Bandages","HP",20,20));		
	}

	@Test
	public void getDifficultyTest() {
		assertEquals(1,mainGameTest.getDifficulty());
		}
	
	@Test
	public void getDurationTest() {
		assertEquals(5,mainGameTest.getDuration());
		}
	
	@Test
	public void getInventoryTest() {
		assertEquals("Juice",mainGameTest.getInventory().get(0).getName());
		}
	
	@Test
	public void removeItemTest() {
		mainGameTest.removeItem(mainGameTest.getInventory().get(0));
		assertEquals("Speed",mainGameTest.getInventory().get(0).getName());
		}
	
	@Test
	public void illegalRemoveItemTest() {
		mainGameTest.removeItem(new Item());
		assertEquals("Juice",mainGameTest.getInventory().get(0).getName());
		}
	
	@Test
	public void emptyInventoryTest() {
		mainGameTest.removeItem(mainGameTest.getInventory().get(0));
		mainGameTest.removeItem(mainGameTest.getInventory().get(0));
		mainGameTest.removeItem(mainGameTest.getInventory().get(0));
		mainGameTest.removeItem(mainGameTest.getInventory().get(0));
		assertEquals(new ArrayList<Item>(),mainGameTest.getInventory());
		}
	
	@Test
	public void addItemTest() {
		mainGameTest.addItem(new Item());
		assertEquals("NULL",mainGameTest.getInventory().get(4).getName());
		}
	
	@Test
	public void illegalAddItemTest() {
		for(int i =0; i<11; i++) {
			mainGameTest.addItem(new Item());
		}
		assertEquals("NULL",mainGameTest.getInventory().get(9).getName());
		}
	
	@Test
	public void getMoneyTest() {
		assertEquals(20000,mainGameTest.getMoney());
		}
	
	@Test
	public void changeMoneyTest() {
		mainGameTest.changeMoney(-20000);
		assertEquals(0,mainGameTest.getMoney());
		}
	
	@Test
	public void illegalChangeMoneyTest() {
		mainGameTest.changeMoney(-35000);
		assertEquals(20000,mainGameTest.getMoney());
		}
	
	@Test
	public void getNameTest() {
		assertEquals("test",mainGameTest.getPlayerName());
		}
	
	@Test
	public void getPointsTest() {
		assertEquals(0,mainGameTest.getPoints());
	}
	
	@Test
	public void changePointsTest() {
		mainGameTest.changePoints(3);
		assertEquals(3,mainGameTest.getPoints());
	}
	
	@Test
	public void illegalChangePointsTest() {
		mainGameTest.changePoints(-3);
		assertEquals(0,mainGameTest.getPoints());
	}
	
	@Test
	public void getWeekTest() {
		assertEquals(1,mainGameTest.getWeek());
		}
	
	@Test
	public void changeWeekTest() {
		mainGameTest.takeBye("attack1");
		assertEquals(2,mainGameTest.getWeek());
		}
	
	@Test
	public void trainAttackTest() {
		mainGameTest.trainAthlete("attack1");
		assertEquals(10,mainGameTest.getTeams().getTeamList().get(0).getPositionStat());
		}
	
	@Test
	public void trainDefenceTest() {
		mainGameTest.trainAthlete("defend1");
		assertEquals(9,mainGameTest.getTeams().getTeamList().get(1).getPositionStat());
		}
	
	@Test
	public void endGameFromSeasonTest() {
		mainGameTest.takeBye("attack1");
		mainGameTest.takeBye("attack1");
		mainGameTest.takeBye("attack1");
		mainGameTest.takeBye("attack1");
		mainGameTest.takeBye("attack1");
		assertTrue(mainGameTest.checkGameEnd(new MarketPlace(mainGameTest)));
	}
	
	@Test
	public void playerShortageEndGameTest() {
		mainGameTest.getTeams().removeAthlete(mainGameTest.getTeams().getTeamList().get(0));
		mainGameTest.getTeams().removeAthlete(mainGameTest.getTeams().getTeamList().get(0));
		mainGameTest.getTeams().removeAthlete(mainGameTest.getTeams().getTeamList().get(0));
		mainGameTest.getTeams().removeAthlete(mainGameTest.getTeams().getTeamList().get(0));
		mainGameTest.getTeams().removeAthlete(mainGameTest.getTeams().getTeamList().get(0));
		mainGameTest.getTeams().removeAthlete(mainGameTest.getTeams().getTeamList().get(0));
		MarketPlace market = new MarketPlace(mainGameTest);
		market.getPlayersForSale().get(0).changeName("Purchased");
		market.getPlayersForSale().get(1).changeName("Purchased");
		assertTrue(mainGameTest.checkGameEnd(market));
	}
	
	@Test
	public void advancedTest() {
		mainGameTest.changeMoney(-1000000);
		mainGameTest.changeMoney(1);
		mainGameTest.changePoints(-1000000);
		mainGameTest.changePoints(1);
		for(int i = 0; i<15; i++) {
			mainGameTest.addItem(new Item());
		}
		mainGameTest.removeItem(new Item());
		mainGameTest.removeItem(new Item());
		mainGameTest.removeItem(mainGameTest.getInventory().get(8));
		mainGameTest.changePoints(mainGameTest.getInventory().size());
		mainGameTest.getTeams().getTeamList().get(2).changeStamina(-1000000);
		mainGameTest.takeBye("attack2");
		assertTrue(mainGameTest.getFinalStats().equals("test FC finished up their 5 week season with"
						+ " 10 points and $20001 on the level 1 difficulty."
						+ "\nThanks for playing!"));

	}

}
