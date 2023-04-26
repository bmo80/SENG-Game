package sengGame;

import java.util.ArrayList;

public class TeamManager {
	
	ArrayList<Athlete> Team = new ArrayList<Athlete>();
	
	public ArrayList<Athlete> getTeam() {
		return Team;
	}
	
	public void addPlayer(Athlete player) {
		Team.add(player);
	}
	
	public void removePlayer(Athlete player) {
		if(Team.contains(player)) {
			Team.remove(player);
		} else {
			System.out.println("Athlete not in team");
		}
	}
	
}
