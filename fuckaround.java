package sengGame;

import java.util.Scanner;

public class fuckaround {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string or !! to quit: ");
		String userInput = scan.nextLine();
		
		while(!userInput.equals("!!")) {
			if(userInput.equals("P")) {
				System.out.println("made it here");
			}
			userInput = scan.nextLine();
		}

	}

}
