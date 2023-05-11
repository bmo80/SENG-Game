package athleteInfo;

import java.util.ArrayList;

public class TeamManager {
	
	private ArrayList<Athlete> teamList;
	private ArrayList<Athlete> bench;
	
	public TeamManager(ArrayList<Athlete> currentTeam, ArrayList<Athlete> currentBench){
		teamList = currentTeam;
		bench = currentBench;
	}
	
	//Getters
	public ArrayList<Athlete> getteamList() {
		return teamList;
	}
	
	public ArrayList<Athlete> getBench(){
		return bench;
	}
	
	
	public Athlete athleteFromString(String stringAthlete) {
		for(Athlete athlete:teamList) {
			//unique names!!! 
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		//If not on teamList, checks bench too
		for(Athlete athlete:bench) {
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		//if not found calls exception - Athlete not on teamList or on bench
		//returns default athlete for now WHICH CAUSES BENCH TO GROW FOREVER
		Athlete ath = new Athlete();
		return ath;
	}
	
	
	//Override ToString??
	//Prints Athletes in collection by name
	public void printteamList(ArrayList<Athlete> collection) {
		for(Athlete athlete:collection) {
			System.out.println(athlete);
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
			// Call Exception - teamList full - overflow to bench?
			benchAthlete(chosenAthlete);
		}else {
			teamList.add(chosenAthlete);
		}
	}
	
	public void benchAthlete(Athlete chosenAthlete) {
		if(bench.size() >= 5){
			// Call exception - bench full
		}
		// not strictly necessary I believe
//		else if(!teamList.contains(chosenAthlete)) {
//			// Call exception - athlete not in teamList
//		}
		else if(chosenAthlete.getName().equals("Default Athlete")){
			bench.add(chosenAthlete);
			// removes first instance - ENSURE unique Athletes!
			teamList.remove(chosenAthlete);
		}
	}
	
	public void unbenchAthlete(Athlete chosenAthlete) {
		if(!bench.contains(chosenAthlete)) {
			// Call exception - Athlete not on bench
		}else {
			// removes first instance - ENSURE unique Athletes!
			bench.remove(chosenAthlete);
			// Could call teamList full exception...
			addAthlete(chosenAthlete);
		}
	}
	
	//Old methods
	
// 	public void addPlayer(Athlete player) {
// 		teamList.add(player);
// 	}
	
// 	public void removePlayer(Athlete player) {
// 		if(teamList.contains(player)) {
// 			teamList.remove(player);
// 		} else {
// 			System.out.println("Athlete not in team");
// 		}
// 	}
	
	
}
