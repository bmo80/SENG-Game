package sengGame;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import purchasables.Athlete;
import purchasables.AthleteGenerator;
import windows.StadiumWindow;

public class Stadium {

	/**
	 * stores all game variables from MainGame class
	 */
	private MainGame gameStats;
	
	/**
	 * Stores a list of opposing teams 
	 */
	private ArrayList<ArrayList<Athlete>> enemyTeams;
	
	/**
	 * Constructor method, generates enemy teams and runs main method
	 * @param currentStats current instance of maingame
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
	}
	
	/**
	 * method for generating enemy teams for opponents list
	 * @param size size of team generated
	 * @param position Which position each athlete will be
	 * @param players list to be filled with athletes
	 */
	public void generateAthletes(int size, String position,ArrayList<Athlete> players) {
		for(int i=0; i<size; i++) {
			AthleteGenerator athlete = new AthleteGenerator(position,gameStats.getWeek());
			players.add(athlete);
		}
	}
	
	/**
	 * Gets the list of current enemy teams available to play
	 * @return the list of enemy teams available to play
	 */
	public ArrayList<ArrayList<Athlete>> getEnemyTeams() {
		return enemyTeams;
	}
	
	/**
	 * Gets the current main game object
	 * @return the current main game object
	 */
	public MainGame getGameStats() {
		return gameStats;
	}
	
}