package sengGame;

import java.util.Scanner;

public class Club {
	
	private ArrayList<Athlete> benchList;
	private ArrayList<Athlete> teamList;
	private ArrayList<Item> Inventory;
	
	public void gotoClub() {
		String choice = "";
		System.out.println("\n"+getTeamName()+"'s active team:");
		super.printTeam(getTeamList());
		System.out.println("\n"+getTeamName()+"'s Bench team:");
		super.printTeam(getBenchList());
		Scanner input = new Scanner(System.in);
		while(!(choice.toUpperCase() == "E")) {
			
			System.out.print("\nBench/Unbench Athletes? ('B'/'U' or '' for Inventory or 'E' to exit): ");  
			//fixed by not closing in setup
			choice = input.nextLine(); 
			
			if(choice.toUpperCase().equals("B")) {
				System.out.print("\nCurrent Active Team...\n");
				printTeam(teamList);
				System.out.print("\nWho to bench (enter name or 'E' to exit): ");
				// Need to ensure unique names
				String athleteChoice = input.nextLine();
				if(athleteChoice.toUpperCase().equals("E")) {
					choice = "E";
					break;
				}
				benchAthlete(athleteFromString(athleteChoice));
			}
			
			else if(choice.toUpperCase().equals("U")) {
				System.out.print("\nCurrent Bench...\n");
				printTeam(getBenchList());
				System.out.print("\nWho to unbench (enter name or 'E' to exit): ");
				String athleteChoice = input.nextLine();
				if(athleteChoice.toUpperCase().equals("E")) {
					choice = "E";
					break;
				}
				unbenchAthlete(athleteFromString(athleteChoice));
			}
			
			else if(choice.toUpperCase().equals("E")) {
				break;
			}		
			
			System.out.print("\nCurrent Inventory:\n");
			printInventory();
//			for(Item item:inventory) {
//				System.out.println(item);
//			}
			System.out.print("\nWhich item to use (enter name or 'E' to exit): ");
			String itemChoice = input.nextLine();
			if(itemChoice.toUpperCase().equals("E")) {
				break;
			}
			System.out.print("Who to use on (enter name or 'E' to exit): ");
			System.out.println("\n"+getTeamName()+"'s active team:");
			super.printTeam(getTeamList());
			System.out.println("\n"+getTeamName()+"'s Bench team:");
			super.printTeam(getBenchList());
			String athleteChoice = input.nextLine();
			if(athleteChoice.toUpperCase().equals("E")) {
				choice = "E";
				break;
			}
			useItem(itemFromString(itemChoice),athleteFromString(athleteChoice));
		
		}
		input.close();
	}
}
