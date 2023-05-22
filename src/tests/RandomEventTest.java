package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mainMenus.MainGame;
import mainMenus.RandomEvent;
import purchasables.Athlete;
import purchasables.TeamManager;

class RandomEventTest {
	RandomEvent event;
	
	@BeforeEach
	public void init() {
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		team.add(new Athlete("OPPattack1",8,2,"A"));
		event = new RandomEvent(new MainGame("test",5,1,new TeamManager(team,
				new ArrayList<Athlete>())));
	}
	
	@Test
	public void statIncreaseTest() {
		assertEquals("OPPattack1 increased their stats",
				event.runEvent(90));
	}
	
	@Test
	public void athleteQuitsTest() {
		assertEquals("OPPattack1 decided to leave",
				event.runEvent(81));
	}
	
	@Test
	public void athleteJoinsTest() {
		assertEquals("New athlete decided to join!",
				event.runEvent(76));
	}
	
	@Test
	public void athleteCantJoinTest() {
		for(int i = 0; i < 10; i++) {
			event.runEvent(76);
		}
		assertEquals("Nothing special happened this week...",
				event.runEvent(76));
	}
	
	@Test
	public void noEventTest() {
		assertEquals("Nothing special happened this week",
				event.runEvent(0));
	}
	
	
}
