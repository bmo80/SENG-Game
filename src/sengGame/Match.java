package sengGame;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import athleteInfo.Athlete;
import athleteInfo.TeamManager;

public class Match{
	
	private MainGame gameStats;
	private ArrayList<Athlete> opponents;
	private ArrayList<Athlete> playerTeam;
	private int oppsScore, playerScore, currentPlayerIndex, currentOppIndex = 0;
	private ArrayList<Integer> athleteScores = new ArrayList<Integer>();
	
	public Match(MainGame currentGame, ArrayList<Athlete> opps){
		gameStats = currentGame;
		Collections.addAll(athleteScores, 0, 0, 0, 0, 0, 0);
		playerTeam = gameStats.getTeams().getTeamList();
		opponents = opps;
	}
	
	public ArrayList<Athlete> getPlayerTeam(){
		return playerTeam;
	}
	
	public int getPlayerIndex() {
		return currentPlayerIndex;
	}
	
	public int getOpponentIndex() {
		return currentOppIndex;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public int getOppsScore() {
		return oppsScore;
	}
	
	public MainGame getGameStats() {
		return gameStats;
	}
	
	public Boolean checkAllInjured() {
		for(Athlete athlete: playerTeam) {
			if(!athlete.getIsInjured()) {
				return false;
			}
		}return true;
	}
	
	public boolean verify() {
		if(playerTeam.size() != 6) {
			//Send - Not enough players error message
			System.out.println("Team not full, need more players");
			return false;
		}
		else if(checkAllInjured()) {
			//Send - No healthy players error message
			System.out.println("No healthy Athletes in team");
			endMatch();
			return false;
		}
		else if((currentPlayerIndex >= 6) || (currentOppIndex >= 6)) {
			endMatch();
			return false;
		}
		return true;
	}
	
	
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
		}
		else if(playerScore>oppsScore){
			//Send message - You won!
			System.out.println("You won the match! Here is your reward...");
			//Arbitrary points and money atm
			gameStats.changePoints(3+gameStats.getDifficulty());
			gameStats.changeMoney(2500*(3-gameStats.getDifficulty()));
		}
		else {
			//Tie condition - Some rewards
			//Send message 
			System.out.println("The match was a tie. Here is a minor reward...");
			gameStats.changePoints(gameStats.getDifficulty());
			gameStats.changeMoney(1000*(3-gameStats.getDifficulty()));
		}
		
	}
	
	public void playMatch() {
		while(verify()) {
			verseAthletes(currentPlayerIndex,currentOppIndex);

		}
	}
}
