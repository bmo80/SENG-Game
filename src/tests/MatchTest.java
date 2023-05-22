package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasables.Athlete;
import purchasables.TeamManager;
import sengGame.MainGame;
import sengGame.Match;

class MatchTest {
	private Match match;
	
	@BeforeEach
	public void test() {
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		team.add(new Athlete("OPPattack1",8,2,"A"));
		team.add(new Athlete("OPPdefend1",2,7,"D"));
		team.add(new Athlete("OPPattack2",1,1,"A"));
		team.add(new Athlete("OPPdefend2",1,1,"D"));
		team.add(new Athlete("OPPattack3",1,0,"A"));
		team.add(new Athlete("OPPdefend3",1,1,"D"));
		match = new Match(new MainGame("test",5,1,new TeamManager(team,new ArrayList<Athlete>())), team);
	}
		
	@Test
	public void noInjuredTest() {
		assertFalse(Match.checkAllInjured(match.getPlayerTeam()));
	}
	
	@Test
	public void allInjuredTest() {
		for(Athlete athlete: match.getPlayerTeam()) {
			athlete.changeIsInjured(true);
		}
		assertTrue(Match.checkAllInjured(match.getPlayerTeam()));
	}
	
	@Test
	public void smallTeamTest() {
		match.getPlayerTeam().remove(0);
		assertFalse(match.verifyAbleToPlay());
	}
	
	@Test
	public void indexOutOfBoundsTest() {
		match.verseAthletes(0, 0);
		match.verseAthletes(0, 0);
		match.verseAthletes(0, 0);
		match.verseAthletes(0, 0);
		match.verseAthletes(0, 0);
		match.verseAthletes(0, 0);
		assertFalse(match.verifyAbleToPlay());
	}
	
	@Test
	public void tieTest() {
		match.verseAthletes(0, 0);
		assertEquals(2,match.getPlayerIndex() + match.getOpponentIndex());
	}
	
	@Test
	public void playerIndexAfterLossTest() {
		match.verseAthletes(1, 0);
		assertEquals(1,match.getPlayerIndex());
	}
	
	@Test
	public void opponentScoreAfterLossTest() {
		match.verseAthletes(1, 0);
		assertEquals(1,match.getOppsScore());
	}
	
	@Test
	public void opponentIndexAfterWinTest() {
		match.verseAthletes(0, 1);
		assertEquals(1,match.getOpponentIndex());
	}
	
	@Test
	public void playerScoreAfterWinTest() {
		match.verseAthletes(0, 1);
		assertEquals(1,match.getPlayerScore());
	}
	
	@Test
	public void injuryTest() {
		match.verseAthletes(0, 1);
		match.verseAthletes(0, 1);
		match.verseAthletes(0, 2);
		match.verseAthletes(0, 2);
		match.verseAthletes(0, 3);
		match.verseAthletes(0, 3);
		assertEquals(1,match.getPlayerIndex());
	}
	
	@Test
	public void changeStaminaTest() {
		match.verseAthletes(0, 1);
		assertEquals(8,match.getPlayerTeam().get(0).getStamina());
	}
	@Test
	public void matchEndStaminaDrainTest() {
		match.endMatch();
		assertEquals(9, match.getPlayerTeam().get(0).getStamina());
	}
	@Test
	public void matchEndAllInjuredTest() {
		for(Athlete athlete: match.getPlayerTeam()) {
			athlete.changeIsInjured(true);
		}
		match.endMatch();
		assertEquals(0, match.getGameStats().getPoints());
	}
	
	@Test
	public void matchEndOppsWinTest() {
		match.verseAthletes(1, 0);
		match.endMatch();
		assertEquals(0, match.getGameStats().getPoints());
	}
	
	@Test
	public void matchEndPlayerWinTest() {
		match.verseAthletes(0, 1);
		match.endMatch();
		assertEquals(4, match.getGameStats().getPoints());
	}
	
	@Test
	public void matchEndTieTest() {
		match.playMatch();
		assertEquals(1, match.getGameStats().getPoints());
	}
	

	
}
