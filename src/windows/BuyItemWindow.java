package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import purchasables.Item;
import sengGame.MainGame;
import sengGame.MarketPlace;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyItemWindow {

	private JFrame frmItemTrading;
	private MarketPlace market;
	private JFrame prevWindow;
	private JLabel lblPrice, lblName, lblType, lblEffect, lblWeek,lblBuyItems;
	private JButton btnItem1,btnItem2,btnItem3,btnItem4,btnDone,btnPurchase;
	private int itemSelected;
	public JLabel lblMoney;
	/**
	 * Initialize previous and current obj variables
	 */
	MarketPlaceWindow prevObj;
	BuyItemWindow curObj;
	
	/**
	 * Create the application.
	 */
	public BuyItemWindow(MarketPlace currentMarket, JFrame givenWindow, MarketPlaceWindow prevObject) {
		prevWindow = givenWindow;
		market = currentMarket;
		prevObj = prevObject;
		curObj = this;
		initialize();
		frmItemTrading.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemTrading = new JFrame();
		frmItemTrading.setTitle("Item Trading");
		frmItemTrading.setBounds(100, 100, 504, 342);
		frmItemTrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmItemTrading.getContentPane().setLayout(null);
		
		lblMoney = new JLabel(String.format("Money: $%s",
				Integer.toString(market.getGameStats().getMoney())));
		lblMoney.setBounds(12, 12, 128, 15);
		frmItemTrading.getContentPane().add(lblMoney);
	
		
		lblWeek = new JLabel(String.format("Week: %s",
				Integer.toString(market.getGameStats().getWeek())));
		lblWeek.setBounds(12, 28, 128, 15);
		frmItemTrading.getContentPane().add(lblWeek);
		
		lblBuyItems = new JLabel("Item Store");
		lblBuyItems.setBounds(164, 28, 88, 15);
		frmItemTrading.getContentPane().add(lblBuyItems);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmItemTrading.setVisible(false);
				SellItemWindow window = new SellItemWindow(market, frmItemTrading, curObj);
			}
		});
		btnViewInventory.setBounds(343, 7, 139, 25);
		frmItemTrading.getContentPane().add(btnViewInventory);
		
		
		lblName = new JLabel("Name:");
		lblName.setBounds(295, 100, 133, 15);
		frmItemTrading.getContentPane().add(lblName);
		
		lblType = new JLabel("Type:");
		lblType.setBounds(295, 125, 199, 15);
		frmItemTrading.getContentPane().add(lblType);
		
		lblEffect = new JLabel("Effect:");
		lblEffect.setBounds(295, 150, 133, 15);
		frmItemTrading.getContentPane().add(lblEffect);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(295, 175, 133, 15);
		frmItemTrading.getContentPane().add(lblPrice);

		setItemButtons();
		
		JLabel lblinventorySlots = new JLabel(String.format("Inventory Slots Available:"
				+ " %s/5", 5-market.getGameStats().getInventory().size()));
		lblinventorySlots.setBounds(12, 251, 207, 15);
		frmItemTrading.getContentPane().add(lblinventorySlots);
		
		
		
		JLabel lblItemInformation = new JLabel("Item Information");
		lblItemInformation.setBounds(342, 70, 123, 15);
		frmItemTrading.getContentPane().add(lblItemInformation);

		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevObj.lblMoney.setText(String.format("Money: $%s", 
						Integer.toString(market.getGameStats().getMoney())));
				prevWindow.setVisible(true);
				frmItemTrading.dispose();
			}
		});
		btnDone.setBounds(365, 275, 117, 25);
		frmItemTrading.getContentPane().add(btnDone);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				market.getGameStats().getInventory().add(market.getItemsForSale().get(itemSelected-1));
				market.getGameStats().changeMoney(-market.getItemsForSale().get(itemSelected-1).getBuyPrice());
				lblMoney.setText(String.format("Money: $%s", 
						Integer.toString(market.getGameStats().getMoney())));
				updateButton(itemSelected);
				Item item = new Item("Purchased","A",1,1);
				market.getItemsForSale().set(itemSelected-1, item);
			}
		});
		btnPurchase.setBounds(365, 231, 117, 25);
		frmItemTrading.getContentPane().add(btnPurchase);
	
	}
	
	/**
	 * Updates the labels to display which item you have clicked
	 * @param index position of the item in the itemsForSale list
	 */
	private void updateLabels(int index) {
		lblName.setText(String.format("Name: %s", market.getItemsForSale().get(index-1).getName()));
		lblType.setText(String.format("Type: %s", market.getItemsForSale().get(index-1).getType()));
		lblEffect.setText(String.format("Effect: %s", Integer.toString(market.getItemsForSale().get(index-1).getEffect())));
		lblPrice.setText(String.format("Price: %s", Integer.toString(market.getItemsForSale().get(index-1).getBuyPrice())));
	}
	
	/**
	 * Initializes the buttons using a support function to display the different items
	 * available.
	 */
	private void setItemButtons() {
		
		setButtonName(1);
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(1);
				setItemSelected(1);
			}
		});
		btnItem1.setBounds(12, 97, 117, 43);
		frmItemTrading.getContentPane().add(btnItem1);
		
		setButtonName(2);
		btnItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(2);
				setItemSelected(2);
			}
		});
		btnItem2.setBounds(148, 97, 117, 43);
		frmItemTrading.getContentPane().add(btnItem2);
		
		setButtonName(3);
		btnItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(3);
				setItemSelected(3);
			}
		});
		btnItem3.setBounds(12, 161, 117, 43);
		frmItemTrading.getContentPane().add(btnItem3);
		
		setButtonName(4);
		btnItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(4);
				setItemSelected(4);
			}
		});
		btnItem4.setBounds(148, 161, 117, 43);
		frmItemTrading.getContentPane().add(btnItem4);
	}
	
	/**
	 * Updates a button to be disabled and labeled "Purchased"
	 * @param index the index of the button to be disabled
	 */
	private void updateButton(int index) {
		switch (index) {
			case 1:
				btnItem1.setText("Purchased");
				btnItem1.setEnabled(false);
				break;
			case 2:
				btnItem2.setText("Purchased");
				btnItem2.setEnabled(false);
				break;
			case 3:
				btnItem3.setText("Purchased");
				btnItem3.setEnabled(false);
				break;
			case 4:
				btnItem4.setText("Purchased");
				btnItem4.setEnabled(false);
				break;
		}
	}
	
	/**
	 * The support function which initializes the Buttons and Checks 
	 * if any have been Purchased.
	 * @param index
	 */
	private void setButtonName(int index) {
		
		switch (index) {
			case 1:
				btnItem1 = new JButton();
				if(market.getItemsForSale().get(index-1).getName().equals("Purchased")) {
					btnItem1.setText("Purchased");
					btnItem1.setEnabled(false);
				} else {
					btnItem1.setText(market.getItemsForSale().get(index-1).getName());
				}
			case 2:
				btnItem2 = new JButton();
				if(market.getItemsForSale().get(index-1).getName().equals("Purchased")) {
					btnItem2.setText("Purchased");
					btnItem2.setEnabled(false);
				} else {
					btnItem2.setText(market.getItemsForSale().get(index-1).getName());
				}
			case 3:
				btnItem3 = new JButton();
				if(market.getItemsForSale().get(index-1).getName().equals("Purchased")) {
					btnItem3.setText("Purchased");
					btnItem3.setEnabled(false);
				} else {
					btnItem3.setText(market.getItemsForSale().get(index-1).getName());
				}
			case 4:
				btnItem4 = new JButton();
				if(market.getItemsForSale().get(index-1).getName().equals("Purchased")) {
					btnItem4.setText("Purchased");
					btnItem4.setEnabled(false);
				} else {
					btnItem4.setText(market.getItemsForSale().get(index-1).getName());
				}
			
		}
		
	}
	/**
	 * Used to know the value of which item is currently being selected
	 * @param index the button number that was pressed
	 */
	private void setItemSelected(int index) {
		itemSelected = index;
	}
}