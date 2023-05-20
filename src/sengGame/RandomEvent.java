package sengGame;

import java.util.Random;

import athleteInfo.Athlete;
import athleteInfo.AthleteGenerator;

public class RandomEvent {
	
	/*
	 * Generates a random number between 0 and 99
	 * then changes it based on difficulty and athlete info
	 * then runs the appropriate method
	 */
	public static String runEvent(MainGame gameInfo) {
		MainGame game = gameInfo;
		int generatedNumber = new Random().nextInt(100);
		generatedNumber += 5*game.getDifficulty();
		Athlete mostInjured = game.getTeams().getMostInjured();
		
		generatedNumber = 81;
		
		if(generatedNumber>85) {
			return statIncrease(game);
		}
		else if(generatedNumber>(80-(mostInjured.getPreviousInjuries()*
				(1+game.getDifficulty())))) {
			athleteQuits(mostInjured, game);
			return String.format("%s Was getting too injured and decided to leave"
					, mostInjured.getName());
		}
		else if(generatedNumber>(75-game.getTeams().getFreeSlots())) {
			return athleteJoins(game);
			
		}
		return "Nothing special happened this week";
	}
	
	public static String statIncrease(MainGame game) {
		int athIndex = new Random().nextInt(game.getTeams().getTeamList().size());
		game.getTeams().getTeamList().get(athIndex).changePositionStat(1+game.getDifficulty());
		return String.format("%s Trained extra hard and increased their stats",
				game.getTeams().getTeamList().get(athIndex).getName());
	}
	
	public static void athleteQuits(Athlete leavingAthlete, MainGame game) {
		game.getTeams().removeAthlete(leavingAthlete);
	}
	
	public static String athleteJoins(MainGame game) {
		if(game.getTeams().getFreeSlots()>0) {
			game.getTeams().addAthlete(new AthleteGenerator("A",game.getWeek()));
			return "You had positions open so a new athlete decided to join!";
		}
		return "Nothing special happened this week...";
	}
}