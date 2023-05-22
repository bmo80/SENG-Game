package windows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import purchasables.Athlete;
import sengGame.MarketPlace;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * SellPlayerWindow class deals with showing the players current team
 * and the logic of if the player is sold
 *@author Blair Brydon
 *@author Ben Moore
 *
 */
public class SellPlayerWindow {

	/**
	 * Variable for storing the current frame
	 */
	private JFrame frmManageTeam;
	/**
	 * Variable for storing the current MarketPlace object
	 */
	private MarketPlace market;
	private int sold;
	/**
	 * Variable for storing the currently selected athlete
	 */
	private Athlete athleteSelected;
	/**
	 * Buttons for the corresponding Athletes in the players team
	 */
	JButton Athlete1,Athlete2,Athlete3,Athlete4,Athlete5,Athlete6;
	/**
	 * Buttons for the corresponding Athletes on the players bench
	 */
	JButton bench1,bench2,bench3,bench4,bench5;
	/**
	 * Labels for the required labels in the frame
	 */
	JLabel lblName, lblPosition, lblAttack, lblDefense, lblSellPrice, lblMoney;
	/**
	 * Variable to store the previous frame
	 */
	private JFrame prevWindow;
	
	/**
	 * Initialize variables for previous obj
	 */
	private BuyPlayerWindow prevObj;
	
	/**
	 * SellPlayerWindow Constructor. Sets the variables and initializes the frame
	 * @param currentMarket current MarketPlace object
	 * @param givenWindow BuyPlayerWindow window frame
	 * @param prevObject BuyPlayerWindow window object
	 */
	public SellPlayerWindow(MarketPlace currentMarket,
			JFrame givenWindow, BuyPlayerWindow prevObject) {
		prevWindow = givenWindow;
		market = currentMarket;
		prevObj = prevObject;
		initialize();
		frmManageTeam.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageTeam = new JFrame();
		frmManageTeam.setTitle("Manage Team");
		frmManageTeam.setBounds(100, 100, 605, 430);
		frmManageTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageTeam.getContentPane().setLayout(null);
		
		lblMoney = new JLabel(String.format("Money: $%s", 
				market.getGameStats().getMoney()));
		lblMoney.setBounds(12, 12, 130, 15);
		frmManageTeam.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s/%s", 
				market.getGameStats().getWeek(),
				market.getGameStats().getDuration()));
		lblWeek.setBounds(12, 28, 130, 15);
		frmManageTeam.getContentPane().add(lblWeek);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setBounds(174, 54, 70, 14);
		frmManageTeam.getContentPane().add(lblActive);
		
		JLabel lblBench = new JLabel("Bench");
		lblBench.setBounds(174, 210, 46, 14);
		frmManageTeam.getContentPane().add(lblBench);
		
		Athlete1 = new JButton();
		
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(0);
				updateLabels(athleteSelected);
			}
		});
		Athlete1.setBounds(12, 72, 175, 37);
		frmManageTeam.getContentPane().add(Athlete1);
		
		Athlete2 = new JButton("New button");
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(1);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete2.setBounds(199, 72, 175, 37);
		frmManageTeam.getContentPane().add(Athlete2);
		
		Athlete3 = new JButton("New button");
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(2);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete3.setBounds(12, 120, 175, 37);
		frmManageTeam.getContentPane().add(Athlete3);
		
		Athlete4 = new JButton("New button");
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(3);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete4.setBounds(199, 120, 175, 37);
		frmManageTeam.getContentPane().add(Athlete4);
		
		Athlete5 = new JButton("New button");
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(4);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete5.setBounds(12, 168, 175, 37);
		frmManageTeam.getContentPane().add(Athlete5);
		
		Athlete6 = new JButton("New button");
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(5);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete6.setBounds(199, 168, 175, 37);
		frmManageTeam.getContentPane().add(Athlete6);
		
		bench1 = new JButton("New button");
		
		bench1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(0);
				updateLabels(athleteSelected);
			}
		});
		bench1.setBounds(12, 227, 175, 37);
		frmManageTeam.getContentPane().add(bench1);
		
		bench2 = new JButton("New button");
		bench2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(1);
				updateLabels(athleteSelected);
			}
		});
		
		bench2.setBounds(199, 227, 175, 37);
		frmManageTeam.getContentPane().add(bench2);
		
		bench3 = new JButton("New button");
		bench3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(2);
				updateLabels(athleteSelected);
			}
		});
		
		bench3.setBounds(12, 275, 175, 37);
		frmManageTeam.getContentPane().add(bench3);
		
		bench4 = new JButton("New button");
		bench4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(3);
				updateLabels(athleteSelected);
			}
		});
		
		bench4.setBounds(199, 275, 175, 37);
		frmManageTeam.getContentPane().add(bench4);
		
		bench5 = new JButton("New button");
		bench5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(4);
				updateLabels(athleteSelected);
			}
		});
		bench5.setBounds(110, 323, 175, 37);
		frmManageTeam.getContentPane().add(bench5);
		
		//Set the Athlete Names to their respective buttons
		setButtons();
		
		JLabel lblStatsTitle = new JLabel("Stats");
		lblStatsTitle.setBounds(471, 72, 46, 14);
		frmManageTeam.getContentPane().add(lblStatsTitle);
		
		lblName = new JLabel("Name: ");
		lblName.setBounds(410, 95, 153, 14);
		frmManageTeam.getContentPane().add(lblName);
		
		lblPosition = new JLabel("Position: ");
		lblPosition.setBounds(410, 120, 153, 14);
		frmManageTeam.getContentPane().add(lblPosition);
		
		lblAttack = new JLabel("Attack: ");
		lblAttack.setBounds(410, 145, 153, 14);
		frmManageTeam.getContentPane().add(lblAttack);
		
		lblDefense = new JLabel("Defense: ");
		lblDefense.setBounds(410, 168, 153, 14);
		frmManageTeam.getContentPane().add(lblDefense);
		
		lblSellPrice = new JLabel("Sell Price: ");
		lblSellPrice.setBounds(410, 193, 153, 14);
		frmManageTeam.getContentPane().add(lblSellPrice);
		
		JButton btnSellPlayer = new JButton("Sell Player");
		btnSellPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frmManageTeam,
						"Are you sure you want to sell this player?",
						"Confirm Sale",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					market.getGameStats().changeMoney(
							athleteSelected.getSellPrice());
					lblMoney.setText(String.format(
							"Money: $%s",market.getGameStats().getMoney()));
					//Checks if the selected athlete is in Main team or other(bench)
					if (market.getGameStats().getTeams().getTeamList().contains(
							athleteSelected)) {
						market.getGameStats().getTeams().getTeamList().remove(
								athleteSelected);
						//checks if there are any players on the bench and moves them up if so.
						if(market.getGameStats().getTeams().getBench().size() > 0) {
							Athlete movingAthlete = 
									market.getGameStats().getTeams().getBench().get(0);
							market.getGameStats().getTeams().getTeamList().add(
									movingAthlete);
							market.getGameStats().getTeams().getBench().remove(
									movingAthlete);
						}
						setButtons();
					}
					else {
						market.getGameStats().getTeams().getBench().remove(
								athleteSelected);
						setButtons();
					}
					setButtons();
					if (market.getGameStats().checkGameEnd(market)) {
						prevWindow.dispose();
						frmManageTeam.dispose();
						market.getGameStats().finishGame();
					}
				}
			}
		});
		btnSellPlayer.setBounds(430, 246, 111, 37);
		frmManageTeam.getContentPane().add(btnSellPlayer);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevObj.lblMoney.setText(String.format("Money: $%s",
						market.getGameStats().getMoney()));
				prevObj.prevObj.lblMoney.setText(String.format("Money: $%s",
						market.getGameStats().getMoney()));
				prevWindow.setVisible(true);
				frmManageTeam.dispose();
			}
		});
		btnNewButton.setBounds(474, 357, 89, 23);
		frmManageTeam.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Manage your Team");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(174, 12, 211, 14);
		frmManageTeam.getContentPane().add(lblNewLabel_2);
	}
	
	private void setTeamName(int index, JButton athlete) {
		if (market.getGameStats().getTeams().getTeamList().size() >= index) {
			athlete.setText(market.getGameStats().getTeams().getTeamList().get(
					index - 1).getName());
		}
		else {
			athlete.setEnabled(false);
			athlete.setText("Empty Slot");
		}
	}
	
	private void setBenchName(int index, JButton athlete) {
		if (market.getGameStats().getTeams().getBench().size() >= index) {
			athlete.setText(market.getGameStats().getTeams().getBench().get(
					index - 1).getName());
		}
		else {
			athlete.setEnabled(false);
			athlete.setText("Empty Slot");
		}
	}
	
	private void updateLabels(Athlete athlete) {
		lblName.setText(athlete.getName());
		lblPosition.setText(String.format(
				"Position: %s", athlete.getPosition()));
		lblAttack.setText(String.format(
				"Attack: %s", Integer.toString(athlete.getAttack())));
		lblDefense.setText(String.format(
				"Defence: %s", Integer.toString(athlete.getDefence())));
		lblSellPrice.setText(String.format(
				"Sell Price: %s", Integer.toString(athlete.getSellPrice())));
	}
	
	/*
	 * Sets all of the buttons for the team and bench using
	 * support functions setTeamName and setBenchName
	 */
	private void setButtons() {
		ArrayList<JButton> teamList = new ArrayList<JButton>();
		ArrayList<JButton> benchList = new ArrayList<JButton>();
		Collections.addAll(benchList, bench1, bench2, bench3, bench4, bench5);
		Collections.addAll(teamList, Athlete1, Athlete2, Athlete3,
				Athlete4, Athlete5, Athlete6);
		int index = 1;
		for(JButton button: teamList) {
			setTeamName(index, button);
			index ++;
		}
		index = 1;
		for(JButton button: benchList) {
			setBenchName(index, button);
			index ++;
		}
	}
}
