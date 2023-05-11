package athleteInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class fileReader {
	
	public String name;

	fileReader(String filename) {
		try {
			readFile(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readFile(String filename) throws FileNotFoundException {
		Random rand = new Random();
		int upperBound = 100;
		int index = rand.nextInt(upperBound);
		File file = new File("src/sengGame/"+filename);
		Scanner scanner = new Scanner(file);
		int count = 0;
		while(count < index) {
			scanner.nextLine();
			count++;
		}
		setName(scanner.nextLine());
		scanner.close();
	}


	private void setName(String name) {
		this.name = name;
	}
}
