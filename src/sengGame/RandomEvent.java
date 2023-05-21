package sengGame;

import java.util.Random;

import purchasables.Athlete;
import purchasables.AthleteGenerator;

public class RandomEvent {
	private MainGame gameStats;
	
	/*
	*Generates a random number between 0 and 99
	*/
	public RandomEvent(MainGame givenGame) {
		gameStats = givenGame;
	}
	
	public String generateEvent() {
		int generatedNumber = new Random().nextInt(100);
		generatedNumber += 5*gameStats.getDifficulty();
		return runEvent(generatedNumber);
	}
	
	/*
	 * takes a given random number and
	 * changes it based on difficulty and athlete info
	 * then runs the appropriate method
	 */
	public String runEvent(int generatedNumber) {
		Athlete mostInjured = gameStats.getTeams().getMostInjured();
				
		if(generatedNumber>85) {
			return increaseStat(gameStats);
		}
		else if(generatedNumber>(80-(mostInjured.getPreviousInjuries()*
				(1+gameStats.getDifficulty())))) {
			makeAthleteQuit(mostInjured, gameStats);
			return String.format("%s Was getting too injured and decided to leave"
					, mostInjured.getName());
		}
		else if(generatedNumber>(75-gameStats.getTeams().getFreeSlotsCount())) {
			return makeAthleteJoin(gameStats);
			
		}
		return "Nothing special happened this week";
	}
	
	public String increaseStat(MainGame gameStats) {
		int athIndex = new Random().nextInt(gameStats.getTeams().getTeamList().size());
		gameStats.getTeams().getTeamList().get(athIndex).changePositionStat(1+gameStats.getDifficulty());
		return String.format("%s Trained extra hard and increased their stats",
				gameStats.getTeams().getTeamList().get(athIndex).getName());
	}
	
	public void makeAthleteQuit(Athlete leavingAthlete, MainGame gameStats) {
		gameStats.getTeams().removeAthlete(leavingAthlete);
	}
	
	public String makeAthleteJoin(MainGame gameStats) {
		if(gameStats.getTeams().getFreeSlotsCount()>0) {
			gameStats.getTeams().addAthlete(new AthleteGenerator("A",gameStats.getWeek()));
			return "You had positions open so a new athlete decided to join!";
		}
		return "Nothing special happened this week...";
	}
}
