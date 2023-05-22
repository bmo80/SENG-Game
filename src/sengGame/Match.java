package sengGame;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import purchasables.Athlete;
import purchasables.TeamManager;

public class Match{
	/**
	 * Stores the amount of money the player won for their match.
	 */
	private int moneyWon;
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
	public Boolean checkAllInjured() {
		for(Athlete athlete: playerTeam) {
			if(!athlete.getIsInjured()) {
				return false;
			}
		}return true;
	}
	
	/**
	 * Checks if enough players in the team are eligible to play.
	 * Checks if there are 6 players, if they are all injured
	 * or if one side has ran out of players.
	 * @return True if the team is able to play. False if it fails one of the checks.
	 */
	public boolean verifyAbleToPlay() {
		if(playerTeam.size() != 6) {
			//Send - Not enough players error message
			System.out.println("Team not full, need more players");
			return false;
		}
		else if(checkAllInjured()) {
			//Send - No healthy players error message
			System.out.println("No healthy Athletes in team");
			return false;
		}
		else if((currentPlayerIndex >= 6) || (currentOppIndex >= 6)) {
			endMatch();
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
		if(playerAthlete.getIsInjured()) {
			System.out.println(String.format("%s is injured, going to next player",playerTeam.get(playerIndex)));
			currentPlayerIndex ++;
		}
		else if(opponentAthlete.getIsInjured()){
			currentOppIndex ++;		
		}
		else if(playerAthlete.getPositionStat() > opponentAthlete.getPositionStat()) {
			playerScore ++;
			playerAthlete.changeStamina(-gameStats.getDifficulty()-1);
			int newScore = athleteScores.get(playerIndex) + 1;
			athleteScores.set(playerIndex, newScore);
			opponentAthlete.changeStamina(-gameStats.getDifficulty()-3);
			currentOppIndex ++;
		}
		else if(playerAthlete.getPositionStat() < opponentAthlete.getPositionStat()) {
			oppsScore ++;
			opponentAthlete.changeStamina(-gameStats.getDifficulty()-1);
			playerAthlete.changeStamina(-gameStats.getDifficulty()-3);
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
	public void endMatch() {
		System.out.println("Match over, all athletes lose stamina");
		for(Athlete athlete: playerTeam) {
			athlete.changeStamina(-1);
		}
		//This is an implementation of criteria 3b.iv
		if(checkAllInjured()) {
			//Send message - All athletes were injured so default loss
			System.out.println("By the end of the match, all athletes were injured so the match was lost");
		}
		else if(oppsScore>playerScore) {
			//Send message - Opponents win
			System.out.println(oppsScore);
			System.out.println(playerScore);
			System.out.println("The opponents won the match");
			gameStats.losses += 1;
			gameStats.changeMoney(10000*(3-gameStats.getDifficulty()));
		}
		else if(playerScore>oppsScore){
			//Send message - You won!
			gameStats.wins += 1;
			System.out.println("You won the match! Here is your reward...");
			//Arbitrary points and money atm
			gameStats.changePoints(3+gameStats.getDifficulty());
			gameStats.changeMoney(10000*(3-gameStats.getDifficulty()));
		}
		else {
			//Tie condition - Some rewards
			//Send message 
			gameStats.draws += 1;
			System.out.println("The match was a tie. Here is a minor reward...");
			gameStats.changePoints(gameStats.getDifficulty());
			gameStats.changeMoney(1000*(3-gameStats.getDifficulty()));
		}
		
	}
	
	/**
	 * checks that while all the conditions to play are met
	 * then the game continues.
	 */
	public void playMatch() {
		while(verifyAbleToPlay()) {
			verseAthletes(currentPlayerIndex,currentOppIndex);

		}
	}
	
	/**
	 * Gets the amount of money the player won
	 */
	public void getMoneyWon() {
		return moneyWon;
	}
}
