package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

import athleteInfo.Athlete;
import athleteInfo.AthleteGenerator;

public class Stadium {

	/*
	 * stores all game variables from MainGame class
	 */
	private MainGame gameStats;
	/*
	 * Stores a list of opposing teams 
	 */
	private ArrayList<ArrayList<Athlete>> enemyTeams;
	
	/*
	 * Constructor method, generates enemy teams and runs main method
	 * @param currentStats 		GameInfo
	 */
	public Stadium(MainGame currentStats) {
		gameStats = currentStats;
		enemyTeams = new ArrayList<ArrayList<Athlete>>();
		for(int i =0; i<3; i++) {
			ArrayList<Athlete> players = new ArrayList<Athlete>();
			generateAthletes(3, "A", players);
			generateAthletes(3, "D", players);
			enemyTeams.add(players);
		}
//		goToStadium();
	}
	
	
	/*
	 * Main menu for Stadium class, awaits input from user
	 */
	public void goToStadium() {
		System.out.println("Welcome to the stadium!\n"
				+ "Please select which team you would like to play"
				+ "\nfrom the list below\n");
		Scanner input = new Scanner(System.in);
		String userInput ="";
		printEnemyTeams();
		while(!(userInput.toUpperCase().equals("E"))) {
			System.out.println("Please select a number between 1 and 3 or 'E' to exit");
			userInput = input.nextLine();
			if(userInput.equals("1")) {
				Match game = new Match(gameStats, enemyTeams.get(0));
			} else if(userInput.equals("2")) {
				Match game = new Match(gameStats, enemyTeams.get(1));
			} else if(userInput.equals("3")) {
				Match game = new Match(gameStats, enemyTeams.get(2));
			} else if(!userInput.toUpperCase().equals("E")) {
				System.out.println("Invalid input.\n");
			}
		}
	}
	
	/*
	 * method for generating enemy teams for opponents list
	 * @param size 		size of team generated
	 * @param position 		Which position each athlete will be
	 * @param players 		list to be filled with athletes
	 */
	public void generateAthletes(int size, String position,ArrayList<Athlete> players) {
		for(int i=0; i<size; i++) {
			AthleteGenerator athlete = new AthleteGenerator(position,gameStats.getWeek());
			players.add(athlete);
		}
	}
	
	/*
	 * represents each athlete in each enemy team
	 */
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