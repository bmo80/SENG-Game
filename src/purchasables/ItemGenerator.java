package purchasables;

import java.util.ArrayList;
import java.util.Collections;

public class ItemGenerator extends Item{

		private String name;
		private static final int MIN=0, MAX = 2;
		private ArrayList<String> potentialItems = new ArrayList<String>();
		private ArrayList<String> types = new ArrayList<String>();;
		Item item;
		private int randomNum;
		
		public ItemGenerator() {
			super();
			Collections.addAll(potentialItems, "Stamina", "Attack", "Defence", "Heal") ;
			Collections.addAll(types, "Small", "Medium", "Large");
			setRandomName();
			setRandomType();
			setRandomEffect();
		}
		
		
		private void setRandomName() {
			randomNum = (int)(Math.random()*(MAX-MIN+1)+MIN);
			randomNum += 1;
			name = potentialItems.get(randomNum);
			this.setName(name);
		}
		
		private void setRandomType() {
			int value = (int)(Math.random()*(MAX-MIN+1)+MIN);
			this.setType(types.get(value));
		}
		
		private void setRandomEffect() {
			if(this.getType().equals("Large")) {
				this.setEffect(3);
				this.setBuyPrice(5000);
			}
			else if(this.getType().equals("Medium")) {
				this.setEffect(2);
				this.setBuyPrice(2500);
			} else {
				this.setEffect(1);
				this.setBuyPrice(1000);
			}
					
		}
		
}
