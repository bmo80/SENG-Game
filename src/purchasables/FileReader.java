package purchasables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *The FileReader Class reads a random last and first name from the given text files
 * to create a random name 
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class FileReader {
	/**
	 * Stores generated name to be set later
	 */
	private String name;
	
	/**
	 * Constructor for fileReader class. Takes in a filename and attempts
	 * to read the file
	 * @param filename name of the file to be read
	 */
	FileReader(String filename) {
		try {
			readFile(filename);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads a file into a scanner and randomly pulls a value from it.
	 * @param filename the file to be read
	 * @throws FileNotFoundException throws and exception if the file cannot be found
	 */
	private void readFile(String filename) throws FileNotFoundException {
		Random rand = new Random();
		int upperBound = 100;
		int index = rand.nextInt(upperBound);
		File file = new File("src/purchasables/"+filename);
		Scanner scanner = new Scanner(file);
		int count = 0;
		while( count < index) {
			scanner.nextLine();
			count ++;
		}
		setName( scanner.nextLine());
		scanner.close();
	}
	
	/**
	 * Sets the name drawn so it can be retrieved
	 * @param givenName name to be set
	 */
	private void setName(String givenName) {
		name = givenName;
	}
	
	/**
	 * Gets generated name
	 * @return name name of athlete
	 */
	public String getName() {
		return name;
	}
}
