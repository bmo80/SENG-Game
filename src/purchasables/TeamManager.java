package purchasables;

import java.util.ArrayList;

/**
 * The TeamManager class allows for the storing and manipulation of
 * any given team.
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class TeamManager {
	
	/**
	 * initialize the team list ArrayList
	 */
	private ArrayList<Athlete> teamList;
	/**
	 * initialize the bench ArrayList
	 */
	private ArrayList<Athlete> bench;
	
	/**
	 * Constructor for team manager. Takes in two values and stores them in team and bench
	 * @param currentTeam the ArrayList to be stored as current team
	 * @param currentBench the ArrayList to be stored as the bench
	 */
	public TeamManager(ArrayList<Athlete> currentTeam,
			ArrayList<Athlete> currentBench){
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
		for( Athlete athlete: teamList) {
			if( athlete.getPreviousInjuries() > currentHighest) {
				currentHighest = 0;
				currentAthlete = athlete;
			}
		}
		for( Athlete athlete: bench) {
			if( athlete.getPreviousInjuries() > currentHighest) {
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
		return 11 - (teamList.size() + bench.size());
	}
	
	/**
	 * Takes a name as a string and checks if an Athlete with that
	 * name is on the team
	 * @param stringAthlete the name of the potential Athlete
	 * @return athlete if they are on the team or default athlete if not
	 */
	public Athlete getAthleteFromString(String stringAthlete) {
		for( Athlete athlete:teamList) {
			if( athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		for( Athlete athlete:bench) {
			if( athlete.getName().equals(stringAthlete)) {
				return athlete;
			}
		}
		return new Athlete();
	}

	public boolean checkIllegalName(String givenName) {
		for( String name: getTeamsString()) {
			if( name.equals(givenName)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Swaps two athletes positions in the team/bench
	 * @param athlete1 One of the Athletes you wish to swap
	 * @param athlete2 The other Athlete you wish to swap
	 */
	public void swap(Athlete athlete1, Athlete athlete2) {
		//first athlete in team
		if( teamList.contains(athlete1)) {
			if( teamList.contains(athlete2)) {
				//second athlete in team
				int ath2Index = teamList.indexOf(athlete2);
				teamList.set(teamList.indexOf(athlete1), athlete2);
				teamList.set(ath2Index, athlete1);
			}
			else {
				//second athlete on bench
				int ath2Index = bench.indexOf(athlete2);
				teamList.set(teamList.indexOf(athlete1), athlete2);
				bench.set(ath2Index, athlete1);
			}
		}
		else if( teamList.contains(athlete2)) {
			//first athlete on bench and second in team
			int ath2Index = teamList.indexOf(athlete2);
			bench.set(bench.indexOf(athlete1), athlete2);
			teamList.set(ath2Index, athlete1);
		}
		else {
			//both on bench
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
 		for( Athlete athlete:teamList) {
 			athlete.changeStamina(10);
 		}
 		for( Athlete athlete:bench) {
 			athlete.changeStamina(10);
 		}
 	}	
	
	/**
	 * Gets a list of all the team members names. 
	 * @return The list of all the team members names.
	 */
	public String[] getTeamsString() {
		String stringArray[] = new String[teamList.size() + bench.size()];
		for( int i = 0; i < teamList.size(); i ++) {
			stringArray[i] = teamList.get(i).getName();
		}
		for(int i = teamList.size(); i < (teamList.size() + bench.size()); i++){
			stringArray[i] = bench.get(i - teamList.size()).getName();
		}
		return stringArray;
	}
	

	/**
	 * Adds an athlete to the team. Checks if the active team is full and sends 
	 * the athlete to the bench if so.
	 * @param chosenAthlete The Athlete you wish to add to the team.
	 */
	public void addAthlete(Athlete chosenAthlete) {
		if( teamList.size() >= 6){
			benchAthlete(chosenAthlete);
		}
		else {
			teamList.add(chosenAthlete);
		}
	}
	
	/**
	 * Adds an athlete to the team. Checks if the active team is full and 
	 * puts last athlete in team onto bench to make room if so.
	 * @param chosenAthlete The Athlete you wish to add to the team.
	 */
	public void teamAdd(Athlete incomingAthlete) {
		if(teamList.size() >= 6) {
			Athlete gettingBenched = teamList.get(5);
			teamList.set(5, incomingAthlete);
			benchAthlete(gettingBenched);
		}
		else {
			teamList.add(incomingAthlete);
		}
	}
	
	/**
	 * Removes the specified Athlete from the team
	 * @param chosenAthlete the specified Athlete to be removed
	 */
	public void removeAthlete(Athlete chosenAthlete) {
		if( teamList.contains(chosenAthlete)) {
			teamList.remove(chosenAthlete);
		}
		else {
			bench.remove(chosenAthlete);
		}
	}
	
	/**
	 * Moves an active player to the bench.
	 * @param chosenAthlete The Athlete that is being moved to the bench
	 */
	public void benchAthlete(Athlete chosenAthlete) {
		if(bench.size() < 5){
			bench.add(chosenAthlete);
		}
	}
	
}
