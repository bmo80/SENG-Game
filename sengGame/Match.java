package sengGame;

import java.util.ArrayList;

public class Match{
	
	private ArrayList<Athlete> playerTeam;
	private ArrayList<Athlete> opponents;
	private int difficulty;
	
	Match(ArrayList<Athlete> player, ArrayList<Athlete> opps, int diff){
		playerTeam = player;
		opponents = opps;
		difficulty = diff;
	}
	
	public Boolean checkAllInjured() {
		for(Athlete athlete: playerTeam) {
			if(!athlete.getIsInjured()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean verify() {
		if(playerTeam.size() != 6) {
			//Send - Not enough players error message
			System.out.println("Team not full, need more players");
			return false;
		} else if(checkAllInjured()) {
			//Send - No healthy players error message
			System.out.println("No healthy Athletes in team");
			return false;
		}
		return true;
	}
	
//	Currently Depreciated and leaves Team comp up to the player
//	VERY icky method - basically just a beta/skeleton version
//	public void matchSort(ArrayList<Athlete> teamToSort) {
//		//expects team with 6 members - 3 attack, 3 defense
//		ArrayList<Athlete> atkTeam = new ArrayList<Athlete>();
//		ArrayList<Athlete> defTeam = new ArrayList<Athlete>();
//		for(Athlete athlete: teamToSort) {
//			if(athlete.getPosition().equals("A")) {
//				if((atkTeam.size()>0)&&(athlete.getOffence()>atkTeam.get(atkTeam.size()-1).getOffence())){
//					atkTeam.add(0,athlete);
//				}else {
//					atkTeam.add(athlete);
//				}
//			}else if(athlete.getPosition().equals("D")) {
//				if((defTeam.size()>0)&&(athlete.getDefence()>defTeam.get(defTeam.size()-1).getDefence())){
//					defTeam.add(0,athlete);
//				}else {
//					defTeam.add(athlete);
//				}
//			}
//		}
//		atkTeam.addAll(defTeam);
//		teamToSort= atkTeam;
//	}
	
	

	
	//Changed into Champion system
	public int[] playMatch() {
		//Defines local variables
		int opsScore = 0;
		int playerScore = 0;
		int currentPlayerIndex = 0;
		int currentOppIndex = 0;
		boolean playing = true;
		while(playing) {
			//check if current player can play
			while(playerTeam.get(currentPlayerIndex).getIsInjured()) {
				currentPlayerIndex ++;
				//In case Last athlete is injured
				if(currentPlayerIndex == playerTeam.size()) {
					//End match
					playing = false;
					System.out.println("All players are injured, can't contiue play");
					break;
				}
			}
			//used to break out of Main while loop
			if(!playing) {
				break;
			}
			System.out.println(String.format("%s is versing %s"
					+ "",playerTeam.get(currentPlayerIndex),
					opponents.get(currentOppIndex)));
			if(opponents.get(currentOppIndex).getPositionStat() > playerTeam.get(currentPlayerIndex).getPositionStat()) {
				//If opponent wins, they get a point. Both Athletes lose stamina and the Player athlete changes
				System.out.println("Opponent won a point");
				opsScore ++;
				opponents.get(currentOppIndex).changeStamina(-difficulty-1);
				playerTeam.get(currentPlayerIndex).changeStamina(-3-difficulty);
				currentPlayerIndex ++;
				//If that was the last player then match ends
				if(currentPlayerIndex == playerTeam.size()) {
					//End match
					playing = false;
					System.out.println("All Athletes finished, match over");
					break;
				}
			}else if(opponents.get(currentOppIndex).getPositionStat() == playerTeam.get(currentPlayerIndex).getPositionStat()) {
				//If there is a tie, Easy --> Player win, Regular --> Both lose, Hard --> Opponent win
				System.out.println("Tie");
				if(difficulty == 0) {
					playerScore ++;
					opponents.get(currentOppIndex).changeStamina(-difficulty-1);
					playerTeam.get(currentPlayerIndex).changeStamina(difficulty-3);
					currentOppIndex ++;
					//If that was the last player then match ends
					if(currentOppIndex == opponents.size()) {
						//End match
						playing = false;
						System.out.println("All Opponents finished, match over");
						break;
					}
				}else if(difficulty == 1) {
					opponents.get(currentOppIndex).changeStamina(-difficulty-3);
					playerTeam.get(currentPlayerIndex).changeStamina(-3-difficulty);
					currentPlayerIndex ++;
					currentOppIndex ++;
					//If that was the last player then match ends
					if((currentPlayerIndex == playerTeam.size()) || (currentOppIndex == opponents.size())) {
						//End match
						playing = false;
						System.out.println("All Athletes or Opponents finished, match over");
						break;
					}
				}else {
					opsScore ++;
					opponents.get(currentOppIndex).changeStamina(-difficulty-3);
					playerTeam.get(currentPlayerIndex).changeStamina(-3-difficulty);
					currentPlayerIndex ++;
					//If that was the last player then match ends
					if(currentPlayerIndex == playerTeam.size()) {
						//End match
						playing = false;
						System.out.println("All Athletes finished, match over");
						break;
					}
				}
			}else {
				//If player wins they get a point. Both Athletes lose stamina and the Opponent athlete changes
				System.out.println("You won a point");
				playerScore ++;
				opponents.get(currentOppIndex).changeStamina(-difficulty-3);
				playerTeam.get(currentPlayerIndex).changeStamina(-difficulty-1);
				currentOppIndex ++;
				//If that was the last player then match ends
				if(currentOppIndex == opponents.size()) {
					//End match
					playing = false;
					System.out.println("All Opponents finished, match over");
					break;
				}
			}
			//Check that opponent isn't injured
			while(opponents.get(currentOppIndex).getIsInjured()) {
				currentOppIndex ++;
				//In case Last athlete is injured
				if(currentOppIndex == opponents.size()) {
					//End match
					playing = false;
					System.out.println("All Opponents injured, can't contiue play");
					break;
				}
			}
		}	
		//Implementation of 4a.ii
		System.out.println("Match over, all athletes lose stamina");
		for(Athlete athlete: playerTeam) {
			athlete.changeStamina(-1);
		}
		//This is an implementation of criteria 3b.iv
		if(checkAllInjured()) {
			//Send message - All athletes were injured so default loss
			System.out.println("By the end of the match, all athletes were injured so the match was lost");
			int[] rewards = {0,0};
			return rewards;
		}else if(opsScore>playerScore) {
			//Send message - Opponents win
			System.out.println("The opponents won the match");
			int[] rewards = {0,0};
			return rewards;
		}else if(playerScore>opsScore){
			//Send message - You won!
			System.out.println("You won the match! Here is your reward...");
			//Arbitrary points and money atm
			int[] rewards = {(3+difficulty),(2500*(3-difficulty))};
			return rewards;
		}else {
			//Tie condition - Some rewards
			//Send message 
			System.out.println("The match was a tie. Here is a minor reward...");
			int[] rewards = {(difficulty),(1000*(3-difficulty))};
			return rewards;
		}
		}
}
