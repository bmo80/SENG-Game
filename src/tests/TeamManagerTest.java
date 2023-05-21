package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasables.Athlete;
import purchasables.TeamManager;

class TeamManagerTest {

	private TeamManager teams;
	
	@BeforeEach
	public void test() {
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		team.add(new Athlete("attack1",7,2,"A"));
		team.add(new Athlete("defend1",2,6,"D"));
		team.add(new Athlete("attack2",3,1,"A"));
		team.add(new Athlete("defend2",1,4,"D"));
		team.add(new Athlete("attack3",10,0,"A"));
		team.add(new Athlete("defend3",1,9,"D"));
		team.get(5).changeIsInjured(true);
		ArrayList<Athlete> bench = new ArrayList<Athlete>();
		bench.add(new Athlete("bench", 0,0,"A"));
		teams = new TeamManager(team, bench);
	}
	
	
	@Test
	public void addToAthleteTest() {
		Athlete athlete = new Athlete("bob",10,10,"A");
		teams.addAthlete(athlete);
		assertEquals(athlete,teams.getBench().get(1));
	}
	
	@Test
	public void removeAthleteTest() {
		teams.removeAthlete(teams.getAthleteFromString("bench"));
		assertEquals(new ArrayList<Athlete>(),teams.getBench());
	}
	
	@Test
	public void removeThenAddTest() {
		teams.removeAthlete(teams.getAthleteFromString("defend2"));
		Athlete athlete = new Athlete("bob",10,10,"A");
		teams.addAthlete(athlete);
		assertEquals(athlete,teams.getTeamList().get(5));
	}
	
	@Test
	public void cantAddAthleteTest() {
		for(int i = 0; i<4; i++) {
			teams.addAthlete(new Athlete("bob",10,10,"A"));
		}
		Athlete athlete = new Athlete("nobody",10,10,"A");
		teams.addAthlete(athlete);
		assertFalse(teams.getBench().contains(athlete));
	}
	
	@Test
	public void mostInjuredTest() {
		assertEquals(teams.getTeamList().get(5), teams.getMostInjured());
	}
	
	@Test
	public void freeSlotsTest() {
		assertEquals(4,teams.getFreeSlotsCount());
	}
	
	@Test
	public void getAthleteFromStringTest() {
		assertEquals(teams.getBench().get(0), teams.getAthleteFromString("bench"));
	}
	
	@Test
	public void cantGetAthleteFromStringTest() {
		assertEquals("NULL", teams.getAthleteFromString("attahgfck1").getName());
	}
	
	@Test
	public void activeSwapActiveTest() {
		teams.swap(teams.getAthleteFromString("attack1"),
				teams.getAthleteFromString("defend3"));
		assertEquals("defend3", teams.getTeamList().get(0).getName());
	}
	
	@Test
	public void activeSwapBenchTest() {
		teams.swap(teams.getAthleteFromString("attack1"),
				teams.getAthleteFromString("bench"));
		assertEquals("bench", teams.getTeamList().get(0).getName());
	}
	
	@Test
	public void benchSwapActiveTest() {
		teams.swap(teams.getAthleteFromString("bench"),
				teams.getAthleteFromString("defend3"));
		assertEquals("defend3", teams.getBench().get(0).getName());
	}
	
	@Test
	public void benchSwapBenchTest() {
		Athlete athlete = new Athlete("bob",10,10,"A");
		teams.addAthlete(athlete);
		teams.swap(teams.getAthleteFromString("bob"),
				teams.getAthleteFromString("bench"));
		assertEquals(athlete, teams.getBench().get(0));
	}
	
	@Test
	public void resetStaminaTest() {
		teams.getBench().get(0).changeStamina(-100);
		teams.resetAthletes();
		assertEquals(10,teams.getBench().get(0).getStamina());
	}
	
	@Test
	public void dontResetInjuryTest() {
		teams.getBench().get(0).changeStamina(-100);
		teams.resetAthletes();
		assertEquals(true,teams.getBench().get(0).getIsInjured());
	}
	
	@Test
	public void teamStringTest() {
		assertTrue(teams.getTeamsString()[0].equals("attack1"));
	}
	
	

}
