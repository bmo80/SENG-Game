package purchasables;

import java.util.ArrayList;
import java.util.Collections;

public class ItemGenerator extends Item{

		/**
		 * MIN and MAX constants for random number generation
		 */
		private static final int MIN=0, MAX = 2;
		/**
		 * ArrayList that will store the potential item names
		 */
		private ArrayList<String> potentialItems = new ArrayList<String>();
		/**
		 * ArrayList that will store the potential types of the item
		 */
		private ArrayList<String> types = new ArrayList<String>();
		/**
		 * Variable to store a random number generated later
		 */
		private int randomNum;
		
		/**
		 * Constructor for Item generator. Handles all the calls to create a random
		 * athlete.
		 */
		public ItemGenerator() {
			super();
			Collections.addAll(potentialItems, "Stamina", "Attack",
					"Defence", "Heal") ;
			Collections.addAll(types, "Small", "Medium", "Large");
			setRandomName();
			setRandomType();
			setRandomEffect();
		}
		
		/**
		 * Randomly sets the name of the item to be 1 of 4 names.
		 */
		private void setRandomName() {
			randomNum = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			randomNum += 1;
			this.setName(potentialItems.get(randomNum));
		}
		
		/**
		 * Randomly sets the type to 1 of 3 types
		 */
		private void setRandomType() {
			int value = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			this.setType(types.get(value));
		}
		
		/**
		 * Gives the Item a random effect value between 1 and 3 based
		 * on its type
		 */
		private void setRandomEffect() {
			if( this.getType().equals("Large")) {
				this.setEffect(3);
				this.setBuyPrice(5000);
			}
			else if( this.getType().equals("Medium")) {
				this.setEffect(2);
				this.setBuyPrice(2500);
			}
			else {
				this.setEffect(1);
				this.setBuyPrice(1000);
			}
		}
}
