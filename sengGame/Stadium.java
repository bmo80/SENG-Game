package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Stadium {

	private ArrayList<Athlete> players;
	private ArrayList<Athlete> team, bench = new ArrayList<Athlete>();
	private ArrayList<ArrayList<Athlete>>enemyTeams;
	private int week;
	
	//Constructor only runs on the first time stadium startup
	//creates 3 teams of 6 players that the player can choose to play against
	Stadium(ArrayList<Athlete> setTeam, ArrayList<Athlete> setBench, int currentWeek) {
		team = setTeam;
		bench = setBench;
		week = currentWeek;
		enemyTeams = new ArrayList<ArrayList<Athlete>>();
		for(int i =0; i<3; i++) {
			players = new ArrayList<Athlete>();
			generateAthletes(3, "A");
			generateAthletes(3, "D");
			enemyTeams.add(players);
		}
		
		
	}
	//Main Stadium method that runs everytime the player visits the stadium
	public ArrayList<Athlete> goToStadium() {
		System.out.println("Welcome to the stadium!\n"
				+ "Please select which team you would like to play"
				+ "\nfrom the list below\n");
		Scanner input = new Scanner(System.in);
		String userInput ="";
		printEnemyTeams();
		while(!(userInput.toUpperCase().equals("E"))) {
			userInput = input.nextLine();
			if(userInput.equals("1")) {
				//TODO play match with team 1
				return enemyTeams.get(0);
			} else if(userInput.equals("2")) {
				//TODO play match with team 2
				return enemyTeams.get(0);
			} else if(userInput.equals("3")) {
				//TODO play match with team 3
				return enemyTeams.get(0);
			} else {
				System.out.println("Invalid input. Please select a number between 1 and 3");
			}
		}
		//Just here for testing
		return players;
	}
	
	//Generates 3 random athletes of the given position using AthleteGenerator
	public void generateAthletes(int size, String position) {
		for(int i=0; i<size; i++) {
			AthleteGenerator athlete = new AthleteGenerator(position,week);
			players.add(athlete);
		}
	}
	
	public void printEnemyTeams() {
		int count = 1;
		for(ArrayList<Athlete> team: enemyTeams) {
			System.out.println("Team "+count);
			for(Athlete player: team) {
				System.out.println(player);
			}
			System.out.println();
			count++;
		}
	}
	
	
	//main method for in class testing
//	public static void main(String[] args) {
//	
//		Stadium stadium = new Stadium();
//		stadium.goToStadium();
//	}
	
	
}