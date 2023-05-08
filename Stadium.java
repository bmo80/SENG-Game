package sengGame;

import java.util.ArrayList;

public class Stadium {

	ArrayList<Athlete> players;
	Stadium() {
		players = new ArrayList<Athlete>();
		generateAthletes(3, "A");
		generateAthletes(3, "D");
		
	}
	
	public void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			players.add(getAthlete(position));
		
		}
	}
	
	private Athlete getAthlete(String position) {
		AthleteGenerator athlete = new AthleteGenerator(position);
		return athlete;
	}
	
	//public static void main(String[] args) {
		//Stadium stadium = new Stadium();
		//for(ArrayList<Athlete> players: stadium.opponents) {
			//for(Athlete player: players) {
			//System.out.println(player.shortDescription());
		//}
		//}
	//}
	
	
}
