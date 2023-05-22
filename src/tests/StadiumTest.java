package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mainMenus.MainGame;
import mainMenus.Stadium;
import purchasables.Athlete;

class StadiumTest {
	private Stadium stadium;
	
	@BeforeEach
	void test() {
		stadium = new Stadium(new MainGame("test",5,1));
	}
	
	@Test 
	public void generateTeamsTest(){
		assertEquals(3,stadium.getEnemyTeams().size());
	}
	
	@Test
	public void generateAthletesTest(){
		assertEquals(6,stadium.getEnemyTeams().get(0).size());
	}
	
	@Test
	public void generateAttackerTest(){
		ArrayList<Athlete> player = new ArrayList<Athlete>();
		stadium.generateAthletes(1,"A",player);
		assertEquals("A",player.get(0).getPosition());
	}

}
