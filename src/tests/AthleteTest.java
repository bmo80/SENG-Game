package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasables.Athlete;
import purchasables.Item;

class AthleteTest {
	
	private Athlete testAthlete;
	
	@BeforeEach
	public void init() {
		testAthlete = new Athlete("test", 3,5,"A");
	}
	
	@Test
	public void useAttackItemTest() {
		testAthlete.useItem(new Item("test","Attack",10,0));
		assertEquals(10,testAthlete.getAttack());
	}
	
	@Test
	public void useHealItemTest() {
		testAthlete.changeIsInjured(true);
		testAthlete.useItem(new Item("test","Attackk",10,0));
		assertEquals(false,testAthlete.getIsInjured());
	}
	
	@Test
	public void addInjuriesTest() {
		testAthlete.changeIsInjured(true);
		testAthlete.changeIsInjured(true);
		testAthlete.changeIsInjured(true);
		assertEquals(1,testAthlete.getPreviousInjuries());
	}
	
	@Test
	public void advancedTest() {
		testAthlete.changeName("A");
		testAthlete.useItem(new Item("test","Attack",1,0));
		testAthlete.useItem(new Item("test","Defence",2,0));
		testAthlete.useItem(new Item("test","Stamina",-30,0));
		testAthlete.changePositionStat(3);
		testAthlete.changePosition("D");
		testAthlete.changePositionStat(3);
		
		System.out.println(testAthlete.toString());
		
		assertTrue(testAthlete.toString().equals(
				"A: ATK(7) DEF(10) POS(D) Injured"));
	}

}
