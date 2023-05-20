package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import athleteInfo.Athlete;
import athleteInfo.Item;
import sengGame.MainGame;

public class InventoryWindow {

	private JFrame frmInventory, mainMenu;
	private JLabel lblItemName, lblItemType, lblItemEffect;
	private Item itemSelected;
	private MainGame game;
	
	/**
	 * Create the application.
	 */
	public InventoryWindow(MainGame givenGame, JFrame givenWindow) {
		game = givenGame;
		mainMenu = givenWindow;
		defaultItem();
		initialize();
		frmInventory.setVisible(true);
	}
	
	public void closeWindow() {
		ClubWindow clubWindow = new ClubWindow(game, mainMenu);
		frmInventory.dispose();
	}
	
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
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 580, 341);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: %S",game.getMoney()));
		lblMoney.setBounds(12, 12, 519, 15);
		frmInventory.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s",game.getWeek()));
		lblWeek.setBounds(12, 28, 95, 15);
		frmInventory.getContentPane().add(lblWeek);
		
		JLabel lblTeam = new JLabel("Inventory");
		lblTeam.setBounds(146, 12, 95, 39);
		frmInventory.getContentPane().add(lblTeam);
		
		lblItemName = new JLabel(String.format("Name: %s",
				itemSelected.getName()));
		lblItemName.setBounds(399, 77, 169, 15);
		frmInventory.getContentPane().add(lblItemName);
		
		
		lblItemType = new JLabel(String.format("Type: %s",
				itemSelected.getType()));
		lblItemType.setBounds(399, 101, 169, 15);
		frmInventory.getContentPane().add(lblItemType);
		
		lblItemEffect = new JLabel(String.format("Effect: %s",
				itemSelected.getEffect()));
		lblItemEffect.setBounds(399, 128, 108, 15);
		frmInventory.getContentPane().add(lblItemEffect);
		
		
		
		JButton Item1 = new JButton("Item 1");
		Item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(0);
			}
		});
		Item1.setBounds(22, 50, 160, 39);
		frmInventory.getContentPane().add(Item1);
		
		JButton Item2 = new JButton("Item 2");
		Item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(1);
			}
		});
		Item2.setBounds(195, 50, 160, 39);
		frmInventory.getContentPane().add(Item2);
		
		JButton Item3 = new JButton("Item 3");
		Item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(2);
			}
		});
		Item3.setBounds(22, 100, 160, 39);
		frmInventory.getContentPane().add(Item3);
		
		JButton Item4 = new JButton("Item 4");
		Item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(3);
			}
		});
		Item4.setBounds(195, 100, 160, 39);
		frmInventory.getContentPane().add(Item4);
		
		JButton Item5 = new JButton("Item 5");
		Item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(4);
			}
		});
		Item5.setBounds(22, 150, 160, 39);
		frmInventory.getContentPane().add(Item5);
		
		JButton Item6 = new JButton("Item 6");
		Item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(5);
			}
		});
		Item6.setBounds(195, 150, 160, 39);
		frmInventory.getContentPane().add(Item6);
		
		JButton Item7 = new JButton("Item 7");
		Item7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(6);
			}
		});
		Item7.setBounds(23, 200, 160, 39);
		frmInventory.getContentPane().add(Item7);
		
		JButton Item8 = new JButton("Item 8");
		Item8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(7);
			}
		});
		Item8.setBounds(195, 200, 160, 39);
		frmInventory.getContentPane().add(Item8);
				
		JButton Item9 = new JButton("Item 9");
		Item9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(8);
			}
		});
		Item9.setBounds(23, 250, 160, 39);
		frmInventory.getContentPane().add(Item9);
		
		JButton Item10 = new JButton("Item 10");
		Item10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelected(9);
			}
		});
		Item10.setBounds(195, 250, 160, 39);
		frmInventory.getContentPane().add(Item10);
		
		
		
		JButton btnDone = new JButton("Go Back");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnDone.setBounds(414, 257, 117, 25);
		frmInventory.getContentPane().add(btnDone);
		
		JButton btnUseItem = new JButton("Use");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(itemSelected.getName().equals("NULL")) {
					//No!
				}else {
					String[] choices = game.getTeams().getTeamsString();
					String selection = (String) JOptionPane.showInputDialog(
							frmInventory,"Who do you want to use this item on?",
							"Use Item", JOptionPane.PLAIN_MESSAGE,
							null, choices, null);
					if(selection != null) {
						game.getTeams().athleteFromString(selection).useItem(itemSelected);
						game.removeItem(itemSelected);
						defaultItem();
						updateLabels();
					}
				}
			}
		});
		btnUseItem.setBounds(414, 185, 117, 25);
		frmInventory.getContentPane().add(btnUseItem);
		

		
		
		
	}
	
	private void setItemSelected(int itemIndex) {
		if(itemIndex<game.getInventory().size()) {
			itemSelected = game.getInventory().get(itemIndex);
		}else {
			itemSelected = new Item();
		}
		updateLabels();
	}
	
	private void updateLabels() {
		lblItemName.setText(String.format("Name: %s",
				itemSelected.getName()));
		lblItemType.setText(String.format("Type: %s",
				itemSelected.getType()));
		lblItemEffect.setText(String.format("Effect: %s",
				itemSelected.getEffect()));
	}

}