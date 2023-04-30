package sengGame;

import java.util.ArrayList;

public class MarketPlace {
	
	private int number = 2;
	ArrayList<Athlete> players;
	MarketPlace() {
		players = new ArrayList<Athlete>();
		generateAthletes(number, "A");
		generateAthletes(number, "D");
		
		
	}
	//Generate an arraylist of a certain size, and add that many athletes to it
	private void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			players.add(getAthlete(position));
		}
	}
	
	//Uses AthleteGenerator Class to generate a randomly made athlete
	private Athlete getAthlete(String position) {
		AthleteGenerator athlete = new AthleteGenerator(position);
		return athlete;
	}
	
	//public static void main (String[] args) {
		//MarketPlace market = new MarketPlace();
		//for(Athlete player: market.players) {
			//System.out.println(player.shortDescription());
		//}
	//}
}
