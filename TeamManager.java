package sengGame;

import java.util.ArrayList;

public class TeamManager {
	
	ArrayList<Athlete> teamList = new ArrayList<Athlete>();
	ArrayList<Athlete> benchList = new ArrayList<Athlete>();
	
	//Getters
	public ArrayList<Athlete> getTeam() {
		return teamList;
	}
	
	
	public Athlete athleteFromString(String stringAthlete) {
		for(Athlete athlete:teamList) {
			//unique names!!! 
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		//If not on team, checks bench too
		for(Athlete athlete:benchList) {
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		//if not found calls exception - Athlete not on team or on bench
		//returns default athlete for now WHICH CAUSES BENCH TO GROW FOREVER
		Athlete ath = new Athlete();
		return ath;
	}
	
	
	//Override ToString??
	//Prints Athletes in collection by name
	public void printTeam(ArrayList<Athlete> collection) {
		for(Athlete athlete:collection) {
			System.out.println(athlete.getShortDescription());
		}
	}
	
	public void resetStamina() {
		for(Athlete athlete:teamList) {
			athlete.changeStamina(10);
		}
		for(Athlete athlete:teamList) {
			athlete.changeStamina(10);
		}
	}
	
	
	public void addAthlete(Athlete chosenAthlete) {
		if(teamList.size() >= 6){
			// Call Exception - team full - overflow to bench?
			benchAthlete(chosenAthlete);
		}else {
			teamList.add(chosenAthlete);
		}
	}
	
	public void benchAthlete(Athlete chosenAthlete) {
		if(benchList.size() >= 5){
			// Call exception - bench full
		}
		// not strictly necessary I believe
//		else if(!teamList.contains(chosenAthlete)) {
//			// Call exception - athlete not in team
//		}
		else if(chosenAthlete.getName().equals("Default Athlete")){
			benchList.add(chosenAthlete);
			// removes first instance - ENSURE unique Athletes!
			teamList.remove(chosenAthlete);
		}
	}
	
	public void unbenchAthlete(Athlete chosenAthlete) {
		if(!benchList.contains(chosenAthlete)) {
			// Call exception - Athlete not on bench
		}else {
			// removes first instance - ENSURE unique Athletes!
			benchList.remove(chosenAthlete);
			// Could call team full exception...
			addAthlete(chosenAthlete);
		}
	}
	
	//Old methods
	
// 	public void addPlayer(Athlete player) {
// 		Team.add(player);
// 	}
	
// 	public void removePlayer(Athlete player) {
// 		if(Team.contains(player)) {
// 			Team.remove(player);
// 		} else {
// 			System.out.println("Athlete not in team");
// 		}
// 	}
	
	
}