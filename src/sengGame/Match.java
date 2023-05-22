package sengGame;

import java.util.ArrayList;
import java.util.Collections;
import purchasables.Athlete;

/**
 * Match class deals with all the logic of playing a match from start to finish
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class Match{
	
	/**
	 * Stores the current instance of maingame
	 */
	private MainGame gameStats;
	/**
	 * ArrayList of enemy Athletes
	 */
	private ArrayList<Athlete> opponents;
	/**
	 * ArrayList of the players Athletes
	 */
	private ArrayList<Athlete> playerTeam;
	/**
	 * Initializes variables for opponent score, player score, current player index
	 * current opponent index
	 */
	private int oppsScore, playerScore, currentPlayerIndex, currentOppIndex = 0;
	/**
	 * ArrayList of the scores for each athlete at the respective index
	 */
	private ArrayList<Integer> athleteScores = new ArrayList<Integer>();
	
	/**
	 * Constructor for the Match class. Sets up the athletescores ArrayList
	 * for this instance of the match and grabs the opposing teams players.
	 * @param currentGame current instance of maingame
	 * @param oppTeam ArrayList containing the opposing team
	 */
	public Match(MainGame currentGame, ArrayList<Athlete> oppTeam){
		gameStats = currentGame;
		opponents = oppTeam;
		Collections.addAll(athleteScores, 0, 0, 0, 0, 0, 0);
		playerTeam = gameStats.getTeams().getTeamList();
	}
	
	/**
	 * Gets the Players Team
	 * @return the players team
	 */
	public ArrayList<Athlete> getPlayerTeam(){
		return playerTeam;
	}
	
	/**
	 * Gets the current player who is playings index
	 * @return the index of the player
	 */
	public int getPlayerIndex() {
		return currentPlayerIndex;
	}
	
	/**
	 * gets the current opponents player who is playings index
	 * @return the index of the player
	 */
	public int getOpponentIndex() {
		return currentOppIndex;
	}
	
	/**
	 * Gets the player teams overall score
	 * @return the player teams score
	 */
	public int getPlayerScore() {
		return playerScore;
	}
	
	/**
	 * Gets the ArrayList of all the athlete scores
	 * @return the ArrayList of all the athlete scores
	 */
	public ArrayList<Integer> getAthleteScores() {
		return athleteScores;
	}
	
	/**
	 * Gets the total score of the opponents team
	 * @return the total score of the opponents team
	 */
	public int getOppsScore() {
		return oppsScore;
	}
	
	/**
	 * Gets the current maingame object
	 * @return the currently running maingame object
	 */
	public MainGame getGameStats() {
		return gameStats;
	}
	
	/**
	 * Checks every player in the team for injuries
	 * @return True or False depending if all players are injured or not
	 */
	public static Boolean checkAllInjured(ArrayList<Athlete> team) {
		for (Athlete athlete: team) {
			if (!athlete.getIsInjured()) {
				return false;
			}
		}return true;
	}
	
	/**
	 * Checks every player in the team for injuries
	 * @return True or False depending if all players are injured or not
	 */
	public boolean verifyAbleToPlay() {
		if (checkAllInjured(playerTeam)) {
			return false;
		}
		else if((currentPlayerIndex >= 6) || (currentOppIndex >= 6)) {
			//All athletes defeated
			return false;
		}
		else if (playerTeam.size() < 6) {
			return false;
		}
		return true;
	}
	
	/**
	 * Method for playing the match. Takes in the specified player for each team
	 * and puts them against each other. When one player wins, which is determined by who
	 * has the higher stat, the other teams player goes to the next one.
	 * @param playerIndex the index of the players Athlete to be played
	 * @param oppIndex index of the Opponents Athlete to be played
	 */
	public void verseAthletes(int playerIndex, int oppIndex) {
		Athlete playerAthlete = playerTeam.get(playerIndex);
		Athlete opponentAthlete = opponents.get(oppIndex);
		if (playerAthlete.getIsInjured()) {
			currentPlayerIndex ++;
		}
		else if (opponentAthlete.getIsInjured()){
			currentOppIndex ++;		
		}
		else if (playerAthlete.getPositionStat() > 
		opponentAthlete.getPositionStat()) {
			playerScore ++;
			playerAthlete.changeStamina((-gameStats.getDifficulty()) - 1);
			int newScore = athleteScores.get(playerIndex) + 1;
			athleteScores.set(playerIndex, newScore);
			opponentAthlete.changeStamina((-gameStats.getDifficulty()) - 3);
			currentOppIndex ++;
		}
		else if (playerAthlete.getPositionStat() < 
				opponentAthlete.getPositionStat()) {
			oppsScore ++;
			opponentAthlete.changeStamina((-gameStats.getDifficulty()) - 1);
			playerAthlete.changeStamina((-gameStats.getDifficulty()) - 3);
			currentPlayerIndex ++;
		}
		else {
			currentOppIndex ++;
			currentPlayerIndex ++;
		}
	}
	
	/**
	 * Logic for determining Who won the game and what stats to update.
	 * All Athletes lose 1 stamina after the game.
	 */
	public String endMatch() {
		for (Athlete athlete: playerTeam) {
			athlete.changeStamina(-1);
		}
		if (checkAllInjured(playerTeam)) {
			//All athletes were injured so default loss
			return "By the end of the match, "
					+ "all athletes were injured so the match was lost";
		}
		else if (oppsScore > playerScore) {
			//Opponents win
			gameStats.addLoss();
			return "The opponents won the match";
		}
		else if (playerScore > oppsScore){
			//Player win
			gameStats.addWin();
			gameStats.changePoints(3 + gameStats.getDifficulty());
			gameStats.changeMoney(10000 * (3 - gameStats.getDifficulty()));
			return String.format("You won the match! You gained %s points and"
					+ " $%s",3 + gameStats.getDifficulty(),
					10000 * (3 - gameStats.getDifficulty()));
		}
		else {
			//Tie condition - Some rewards
			gameStats.addDraw();
			gameStats.changePoints(gameStats.getDifficulty());
			gameStats.changeMoney(1000 * (3 - gameStats.getDifficulty()));
			return String.format("The match was a tie. You gained %s points and"
					+ " $%s",gameStats.getDifficulty(),
					1000 * (3 - gameStats.getDifficulty()));
		}
	}
	
	/**
	 * checks that while all the conditions to play are met
	 * then the game continues.
	 */
	public String playMatch() {
		while (verifyAbleToPlay()) {
			verseAthletes(currentPlayerIndex,currentOppIndex);
		}
		return endMatch();
	}
	
}
