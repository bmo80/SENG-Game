package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import athleteInfo.Athlete;
import athleteInfo.Item;
import sengGame.MainGame;

public class InventoryWindow {

	private JFrame frmInventory, mainMenu;
	private JLabel lblItemName, lblItemType, lblItemEffect, lblItemDescription;
	private Item itemSelected;
	private MainGame game;
	
	/**
	 * Create the application.
	 */
	public InventoryWindow(MainGame givenGame, JFrame givenWindow) {
		game = givenGame;
		mainMenu = givenWindow;
		itemSelected = game.getInventory().get(0);
		initialize();
		frmInventory.setVisible(true);
	}
	
	public void closeWindow() {
		ClubWindow clubWindow = new ClubWindow(game, mainMenu);
		frmInventory.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 580, 437);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: %S",game.getMoney()));
		lblMoney.setBounds(12, 12, 519, 15);
		frmInventory.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s",game.getWeek()));
		lblWeek.setBounds(12, 28, 95, 15);
		frmInventory.getContentPane().add(lblWeek);
		
		JLabel lblTeam = new JLabel("Inventory");
		lblTeam.setBounds(142, 26, 95, 39);
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
		
		lblItemDescription = new JLabel("Description: <dynamic>");
		lblItemDescription.setBounds(399, 155, 169, 15);
		frmInventory.getContentPane().add(lblItemDescription);
		
		
		
		JButton Item1 = new JButton("Item 1");
		Item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(0);
			}
		});
		Item1.setBounds(23, 77, 160, 39);
		frmInventory.getContentPane().add(Item1);
		
		JButton Item2 = new JButton("Item 2");
		Item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(1);
			}
		});
		Item2.setBounds(195, 77, 160, 39);
		frmInventory.getContentPane().add(Item2);
		
		JButton Item3 = new JButton("Item 3");
		Item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(2);
			}
		});
		Item3.setBounds(22, 128, 160, 39);
		frmInventory.getContentPane().add(Item3);
		
		JButton Item4 = new JButton("Item 4");
		Item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(3);
			}
		});
		Item4.setBounds(195, 128, 160, 39);
		frmInventory.getContentPane().add(Item4);
		
		JButton Item5 = new JButton("Item 5");
		Item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(4);
			}
		});
		Item5.setBounds(22, 178, 160, 39);
		frmInventory.getContentPane().add(Item5);
		
		JButton Item6 = new JButton("Item 6");
		Item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(5);
			}
		});
		Item6.setBounds(195, 179, 160, 39);
		frmInventory.getContentPane().add(Item6);
		
		
		
		JButton btnDone = new JButton("Go Back");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnDone.setBounds(414, 340, 117, 25);
		frmInventory.getContentPane().add(btnDone);
		
		JButton btnSwap = new JButton("Use");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSwap.setBounds(414, 288, 117, 25);
		frmInventory.getContentPane().add(btnSwap);
		
		
		
	}
	
	private void setTeamAthlete(int itemIndex) {
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
		lblItemDescription.setText(String.format("Description: %s",
				itemSelected.getDescription()));
	}

}
