package purchasables;

import java.util.ArrayList;
import java.util.Arrays;

public class TeamManager {
	
	private ArrayList<Athlete> teamList;
	private ArrayList<Athlete> bench;
	
	public TeamManager(ArrayList<Athlete> currentTeam, ArrayList<Athlete> currentBench){
		teamList = currentTeam;
		bench = currentBench;
	}
	
	/**
	 * Gets the current active players on your team
	 * @return ArrayList of active players on your team
	 */
	public ArrayList<Athlete> getTeamList() {
		return teamList;
	}
	
	/**
	 * Gets the current bench players on your team
	 * @return ArrayList of bench players on your team
	 */
	public ArrayList<Athlete> getBench(){
		return bench;
	}
	
	/**
	 * Gets the athlete who has had the most injuries on the team
	 * @return the Athlete who has had the most injuries
	 */
	public Athlete getMostInjured() {
		int currentHighest = 0;
		Athlete currentAthlete = teamList.get(0);
		for(Athlete athlete: teamList) {
			if(athlete.getPreviousInjuries()>currentHighest) {
				currentHighest = 0;
				currentAthlete = athlete;
			}
		}
		for(Athlete athlete: bench) {
			if(athlete.getPreviousInjuries()>currentHighest) {
				currentHighest = 0;
				currentAthlete = athlete;
			}
		}
		return currentAthlete;
	}
	
	/**
	 * Gets the total number of slots still available on the team
	 * @return the number of slots free
	 */
	public int getFreeSlotsCount() {
		return 11-(teamList.size()+bench.size());		
	}
	
	/**
	 * Takes a name as a string and checks if an Athlete with that
	 * name is on the team
	 * @param stringAthlete the name of the potential Athlete
	 * @return athlete if they are on the team or default athlete if they are not
	 */
	public Athlete getAthleteFromString(String stringAthlete) {
		for(Athlete athlete:teamList) {
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		for(Athlete athlete:bench) {
			if(athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		return new Athlete();
	}

	
	public void swap(Athlete athlete1, Athlete athlete2) {
		if(teamList.contains(athlete1)) {
			if(teamList.contains(athlete2)) {
//				both top
				int ath2Index = teamList.indexOf(athlete2);
				teamList.set(teamList.indexOf(athlete1), athlete2);
				teamList.set(ath2Index, athlete1);
			}
			else {
				int ath2Index = bench.indexOf(athlete2);
				teamList.set(teamList.indexOf(athlete1), athlete2);
				bench.set(ath2Index, athlete1);
			}
		}
		else if(teamList.contains(athlete2)) {
			int ath2Index = teamList.indexOf(athlete2);
			bench.set(bench.indexOf(athlete1), athlete2);
			teamList.set(ath2Index, athlete2);
		}
		else {
			int ath2Index = bench.indexOf(athlete2);
			bench.set(bench.indexOf(athlete1), athlete2);
			bench.set(ath2Index, athlete1);
		}
	}
	
	/**
	 * Resets the stamina of all athletes back to 10.
	 * Only used after a bye has been taken
	 */
	public void resetAthletes() {
 		for(Athlete athlete:teamList) {
 			athlete.changeStamina(10);
 		}
 		for(Athlete athlete:bench) {
 			athlete.changeStamina(10);
 		}
 	}	
	
	/**
	 * 
	 * @return
	 */
	public String[] getTeamsString() {
		String stringArray[] = new String[teamList.size()+bench.size()];
		for(int i=0;i<teamList.size();i++) {
			stringArray[i] = teamList.get(i).getName();
		}
		for(int i=teamList.size();i<(teamList.size()+bench.size());i++) {
			stringArray[i] = bench.get(i-teamList.size()).getName();
		}
		return stringArray;
	}
	
		
	
	public void addAthlete(Athlete chosenAthlete) {
		if(teamList.size() >= 6){
			// Call Exception - teamList full - overflow to bench?
			benchAthlete(chosenAthlete);
		}else {
			teamList.add(chosenAthlete);
		}
	}
	
	public void removeAthlete(Athlete chosenAthlete) {
		if(teamList.contains(chosenAthlete)) {
			teamList.remove(chosenAthlete);
		}
		else {
			bench.remove(chosenAthlete);
		}
	}
	
	public void benchAthlete(Athlete chosenAthlete) {
		if(bench.size() >= 5){
			// Call exception - bench full
		}
		else {
			bench.add(chosenAthlete);
		}
	}	
	
}
