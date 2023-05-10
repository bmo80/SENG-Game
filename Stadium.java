package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Stadium {

	ArrayList<Athlete> players;
	ArrayList<ArrayList<Athlete>>enemyTeams = new ArrayList<ArrayList<Athlete>>();
	
	//Constructor only runs on the first time stadium startup
	//creates 5 teams of 6 players that the player can choose to play against
	Stadium() {
		
		for(int i =0; i<5; i++) {
			players = new ArrayList<Athlete>();
			generateAthletes(3, "A");
			generateAthletes(3, "D");
			enemyTeams.add(players);
		}
		
		
	}
	//Main Stadium method that runs everytime the player visits the stadium
	public void goToStadium() {
		System.out.println("Welcome to the stadium!\n"
				+ "Please select which team you would like to play"
				+ "\nfrom the list");
		Scanner input = new Scanner(System.in);
		String userInput ="";
		
		
		
	}
	
	//Generates 3 random athletes of the given position using AthleteGenerator
	public void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			AthleteGenerator athlete = new AthleteGenerator(position);
			players.add(athlete);
		}
	}
	
	public void printEnemyTeams() {
		int count = 1;
		for(ArrayList<Athlete> team: enemyTeams) {
			System.out.println("Team "+count);
			for(Athlete player: team) {
				System.out.println(player.getShortDescription());
			}
			System.out.println();
			count++;
		}
	}
	
	
	//main method for in class testing
	public static void main(String[] args) {
	
		Stadium stadium = new Stadium();
		stadium.printEnemyTeams();
	}
	
	
}
