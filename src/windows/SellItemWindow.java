package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mainMenus.MainGame;
import mainMenus.MarketPlace;
import purchasables.Item;

/**
 * Window Class for Selling items. Deals with displaying the correct items
 * and processing the purchasing
 *@author Blair Brydon
 *@author Ben Moore
 */
public class SellItemWindow {

	/**
	 * Variables for the current and previous frames
	 */
	private JFrame frmSellItems, prevWindow;
	/**
	 * Variables for the necessary display labels
	 */
	private JLabel lblItemName, lblItemType, lblItemEffect;
	/**
	 * Variable Item to keep track of the currently selected item
	 */
	private Item itemSelected;
	/**
	 * Variable to store current MainGame object
	 */
	private MainGame game;
	/**
	 * Variable to store current MarketPlace object
	 */
	private MarketPlace market;
	/**
	 * Variables for the item buttons to display the respective item
	 */
	private JButton Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10;
	/**
	 * Variable to store the previous windows object
	 */
	private BuyItemWindow prevObj;
	
	/**
	 * Constructor for the sell item window. Initializes the frame
	 * @param givenMarket the current market instance
	 * @param givenWindow the previous window
	 * @param prevObject the previous windows object
	 */
	public SellItemWindow(MarketPlace givenMarket,
			JFrame givenWindow, BuyItemWindow prevObject) {
		market = givenMarket;
		game = market.getGameStats();
		prevWindow = givenWindow;
		prevObj = prevObject;
		defaultItem();
		initialize();
		frmSellItems.setVisible(true);
	}
	
	/**
	 * Closes the current window and sets the previous one to be visible
	 */
	public void closeWindow() {
		prevWindow.setVisible(true);
		frmSellItems.dispose();
	}
	
	/**
	 * sets the item selected to be either a default item
	 * or the first item in the players inventory upon initialization
	 */
	public void defaultItem() {
		if(game.getInventory().size() == 0) {
			itemSelected = new Item();
		}else {
			itemSelected = game.getInventory().get(0);
		}
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSellItems = new JFrame();
		frmSellItems.setTitle("Sell items");
		frmSellItems.setBounds(100, 100, 580, 341);
		frmSellItems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSellItems.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: $%s",
				game.getMoney()));
		lblMoney.setBounds(12, 12, 519, 15);
		frmSellItems.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s",
				game.getWeek()));
		lblWeek.setBounds(12, 28, 95, 15);
		frmSellItems.getContentPane().add(lblWeek);
		
		JLabel lblTeam = new JLabel("Inventory");
		lblTeam.setBounds(146, 12, 95, 39);
		frmSellItems.getContentPane().add(lblTeam);
		
		lblItemName = new JLabel(String.format("Changes: %s",
				itemSelected.getName()));
		lblItemName.setBounds(399, 101, 169, 15);
		frmSellItems.getContentPane().add(lblItemName);
		
		
		lblItemType = new JLabel(String.format("Type: %s",
				itemSelected.getType()));
		lblItemType.setBounds(399, 74, 169, 15);
		frmSellItems.getContentPane().add(lblItemType);
		
		lblItemEffect = new JLabel(String.format("By: %s",
				itemSelected.getEffect()));
		lblItemEffect.setBounds(399, 128, 108, 15);
		frmSellItems.getContentPane().add(lblItemEffect);
		
		
		
		Item1 = new JButton("Item 1");
		Item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(0);
			}
		});
		Item1.setBounds(22, 50, 160, 39);
		frmSellItems.getContentPane().add(Item1);
		
		 Item2 = new JButton("Item 2");
		Item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(1);
			}
		});
		Item2.setBounds(195, 50, 160, 39);
		frmSellItems.getContentPane().add(Item2);
		
		Item3 = new JButton("Item 3");
		Item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(2);
			}
		});
		Item3.setBounds(22, 100, 160, 39);
		frmSellItems.getContentPane().add(Item3);
		
		Item4 = new JButton("Item 4");
		Item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(3);
			}
		});
		Item4.setBounds(195, 100, 160, 39);
		frmSellItems.getContentPane().add(Item4);
		
		Item5 = new JButton("Item 5");
		Item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(4);
			}
		});
		Item5.setBounds(22, 150, 160, 39);
		frmSellItems.getContentPane().add(Item5);
		
		Item6 = new JButton("Item 6");
		Item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(5);
			}
		});
		Item6.setBounds(195, 150, 160, 39);
		frmSellItems.getContentPane().add(Item6);
		
		Item7 = new JButton("Item 7");
		Item7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(6);
			}
		});
		Item7.setBounds(23, 200, 160, 39);
		frmSellItems.getContentPane().add(Item7);
		
		Item8 = new JButton("Item 8");
		Item8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(7);
			}
		});
		Item8.setBounds(195, 200, 160, 39);
		frmSellItems.getContentPane().add(Item8);
				
		Item9 = new JButton("Item 9");
		Item9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(8);
			}
		});
		Item9.setBounds(23, 250, 160, 39);
		frmSellItems.getContentPane().add(Item9);
		
		Item10 = new JButton("Item 10");
		Item10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(9);
			}
		});
		Item10.setBounds(195, 250, 160, 39);
		frmSellItems.getContentPane().add(Item10);
		
		setButtonNames();
		
		JButton btnDone = new JButton("Go Back");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevObj.lblMoney.setText(String.format("Money: $%s", 
						Integer.toString(market.getGameStats().getMoney())));
				closeWindow();
			}
		});
		btnDone.setBounds(414, 257, 117, 25);
		frmSellItems.getContentPane().add(btnDone);
		
		JButton btnSellItem = new JButton("Sell");
		btnSellItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemSelected.getName().equals("NULL")) {
					//Not allowed
				}
				else {
					market.getGameStats().removeItem(itemSelected);
					market.getGameStats().changeMoney(
							itemSelected.getBuyPrice());
					lblMoney.setText(String.format("Money: $%s", 
							Integer.toString(
									market.getGameStats().getMoney())));
					defaultItem();
					updateLabels();
					setButtonNames();
				}
			}
		});
		btnSellItem.setBounds(414, 185, 117, 25);
		frmSellItems.getContentPane().add(btnSellItem);
		
	}
	
	/**
	 * Sets the selected button to be the corresponding item
	 * @param btn the button to be set
	 * @param index the index of the corresponding item
	 */
	private void setButton(JButton btn, int index) {
		if (market.getGameStats().getInventory().size() >= index) {
			btn.setText(
					market.getGameStats().getInventory().get(index-1).getName());
		}
		else {
			btn.setText("Empty");
			btn.setEnabled(false);
		}
	}
	
	/**
	 * Sets the currently selected item to the corresponding variable
	 * @param itemIndex the index of the selected item
	 */
	private void setItemSelected(int itemIndex) {
		if (itemIndex < game.getInventory().size()) {
			itemSelected = game.getInventory().get(itemIndex);
		}
		else {
			itemSelected = new Item();
		}
		updateLabels();
	}
	
	/**
	 * Updates the labels to be the current item selected
	 */
	private void updateLabels() {
		lblItemName.setText(String.format("Changes: %s",
				itemSelected.getName()));
		lblItemType.setText(String.format("Type: %s",
				itemSelected.getType()));
		lblItemEffect.setText(String.format("By: %s",
				itemSelected.getEffect()));
	}
	
	/**
	 * Loops through the item buttons and sets the correct button to
	 * the corresponding item in the player inventory. Uses the setButton
	 * helper method 
	 */
	private void setButtonNames() {
		ArrayList<JButton> list = new ArrayList<JButton>();
		int index = 1;
		Collections.addAll(list, Item1, Item2, Item3, Item4,
				Item5, Item6, Item7, Item8, Item9, Item10);
		for(JButton btn: list) {
			setButton(btn, index);
			index++;
		}
	}
}
