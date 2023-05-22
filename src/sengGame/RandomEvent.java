package sengGame;

import java.util.Random;

import purchasables.Athlete;
import purchasables.AthleteGenerator;

/**
 * The RandomEvent class deals with the logic of generating and then executing
 * the random events for the game
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class RandomEvent {
	
	/**
	 * For storing the current maingame object
	 */
	private MainGame gameStats;
	
	/**
	 * Constructor for the RandomEvent class. 
	 * @param givenGame takes in the current maingame instance
	 */
	public RandomEvent(MainGame givenGame) {
		gameStats = givenGame;
	}
	
	/**
	*Generates a random number between 0 and 99
	*@return returns the generated number and passes it to the runEvent method
	*/
	public String generateEvent() {
		int generatedNumber = new Random().nextInt(100);
		generatedNumber += 5*gameStats.getDifficulty();
		return runEvent(generatedNumber);
	}
	
	/**
	 * takes a given random number and
	 * changes it based on difficulty and athlete info
	 * then runs the appropriate method
	 * @param generatedNumber the random number between 0 and 99
	 * @return returns which random even will occur
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
	
	/**
	 * Method to increase a random athletes stats by a certain amount.
	 * the amount is influence by game difficulty
	 * @param gameStats the current instance of main game
	 * @return returns a string saying which athlete had their stat increased and by how much
	 */
	public String increaseStat(MainGame gameStats) {
		int athIndex = new Random().nextInt(gameStats.getTeams().getTeamList().size());
		gameStats.getTeams().getTeamList().get(athIndex).changePositionStat(1+gameStats.getDifficulty());
		return String.format("%s Trained extra hard and increased their stats",
				gameStats.getTeams().getTeamList().get(athIndex).getName());
	}
	
	/**
	 * Makes a random athlete leave the team
	 * @param leavingAthlete the athlete leaving the team
	 * @param gameStats the current instance of main game
	 */
	public void makeAthleteQuit(Athlete leavingAthlete, MainGame gameStats) {
		gameStats.getTeams().removeAthlete(leavingAthlete);
	}
	
	/**
	 * Makes a random athlete join the team
	 * @param gameStats current instance of main game
	 * @return Whether or not an athlete joined depending on if there was space.
	 */
	public String makeAthleteJoin(MainGame gameStats) {
		if(gameStats.getTeams().getFreeSlotsCount()>0) {
			gameStats.getTeams().addAthlete(new AthleteGenerator("A",gameStats.getWeek()));
			return "You had positions open so a new athlete decided to join!";
		}
		return "Nothing special happened this week...";
	}
}
