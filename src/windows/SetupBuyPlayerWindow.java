package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import athleteInfo.Athlete;
import athleteInfo.TeamManager;
import sengGame.MainGame;
import sengGame.MarketPlace;

public class SetupBuyPlayerWindow {

	private JFrame frmMakeTeam;
	private MarketPlace market;
	JLabel lblAthleteName,lblAthletePos, lblAthleteAtt, lblAthleteDef, 
	lblAthleteStam, lblPrice,lblTeamSlotsAvailable,lblBenchSlotsAvailable;
	JButton btnPurchase, Athlete1, Athlete2, Athlete3, Athlete4, Athlete5, Athlete6;
	private int athleteSelected;
	private String playerName;
	private int duration, difficulty, money;
	private TeamManager teams;

	/**
	 * Create the application.
	 */
	public SetupBuyPlayerWindow(String name, int length, int diff) {
		playerName = name;
		duration = length;
		difficulty = diff;
		market = new MarketPlace(new MainGame(playerName,duration, difficulty));
		teams = new TeamManager(new ArrayList<Athlete>(), new ArrayList<Athlete>());
		money = market.getMoney();
		initialize();
		frmMakeTeam.setVisible(true);
	}

	public void closeWindow() {
		frmMakeTeam.dispose();
	}

	public void finishedWindow(MainGame game) {
		game.closeSetupScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMakeTeam = new JFrame();
		frmMakeTeam.setTitle("Make Team");
		frmMakeTeam.setTitle("Player Trading");
		frmMakeTeam.setBounds(100, 100, 580, 580);

		frmMakeTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMakeTeam.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: %s",money));
		lblMoney.setBounds(12, 12, 194, 15);
		frmMakeTeam.getContentPane().add(lblMoney);
		
		JLabel lblPlayerTrading = new JLabel("Player Trading");
		lblPlayerTrading.setBounds(196, 28, 122, 39);
		frmMakeTeam.getContentPane().add(lblPlayerTrading);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(375, 140, 70, 15);
		frmMakeTeam.getContentPane().add(lblPosition);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(375, 165, 70, 15);
		frmMakeTeam.getContentPane().add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setBounds(375, 190, 70, 15);
		frmMakeTeam.getContentPane().add(lblDefense);
		
		JLabel lblStamina = new JLabel("Stamina:");
		lblStamina.setBounds(375, 215, 70, 15);
		frmMakeTeam.getContentPane().add(lblStamina);
		
		lblAthleteName = new JLabel();
		lblAthleteName.setBounds(450, 115, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel();
		lblAthletePos.setBounds(450, 140, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel();
		lblAthleteAtt.setBounds(450, 165, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel();
		lblAthleteDef.setBounds(450, 190, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel();
		lblAthleteStam.setBounds(450, 215, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteStam);
		
		lblPrice = new JLabel("Price: ");
		lblPrice.setBounds(375, 240, 160, 15);
		frmMakeTeam.getContentPane().add(lblPrice);
		
		
		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(385, 86, 95, 15);
		frmMakeTeam.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(375, 115, 70, 15);
		frmMakeTeam.getContentPane().add(lblName);
		
		setAthleteButtons();

		lblTeamSlotsAvailable = new JLabel();
		lblTeamSlotsAvailable.setBounds(12, 498, 227, 15);
		frmMakeTeam.getContentPane().add(lblTeamSlotsAvailable);
		
		lblBenchSlotsAvailable = new JLabel();
		lblBenchSlotsAvailable.setBounds(12, 525, 227, 15);
		frmMakeTeam.getContentPane().add(lblBenchSlotsAvailable);
		updateTeamSlots();
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(teams.getTeamList().size() < 6) {
					JOptionPane.showMessageDialog(frmMakeTeam, String.format(
							"Your team must have at least 6 athletes."
							+ "\nCurrently you only have %s"
							,teams.getTeamList().size()));
				}
				else {
					finishedWindow(new MainGame(playerName, duration, difficulty,
							teams));
				}
			}
		});
		btnDone.setBounds(418, 515, 117, 25);
		frmMakeTeam.getContentPane().add(btnDone);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(money - market.getPlayersForSale().get(athleteSelected-1).getBuyPrice() < 0) {
					//BANNED
				}
				else {
					teams.addAthlete(market.getPlayersForSale().get(athleteSelected-1));
					money -= market.getPlayersForSale().get(athleteSelected-1).getBuyPrice();
					lblMoney.setText(String.format("Money: %s",money));
					updateButton(athleteSelected);
					updateTeamSlots();
					Athlete athlete = new Athlete("Purchased",1,1,"A");
					market.getPlayersForSale().set(athleteSelected-1, athlete);
				}
			}
		});
		btnPurchase.setBounds(385, 281, 134, 25);
		frmMakeTeam.getContentPane().add(btnPurchase);
		
		
		
	}
	
	private void playerStatDisplay(int number) {
		lblAthleteName.setText(market.getPlayersForSale().get(number-1).getName());
		if(market.getPlayersForSale().get(number-1).getPosition() == "A") {
			lblAthletePos.setText("Attacker");
		} else {
			lblAthletePos.setText("Defence");
		}
		lblAthleteAtt.setText(Integer.toString(market.getPlayersForSale().get(number-1).getAttack()));
		lblAthleteDef.setText(Integer.toString(market.getPlayersForSale().get(number-1).getDefence()));
		lblAthleteStam.setText(Integer.toString(market.getPlayersForSale().get(number-1).getStamina()));
		lblPrice.setText(String.format("Price: %s", market.getPlayersForSale().get(number-1).getBuyPrice()));
	}
	
	private void updateButton(int index) {
		switch (index) {
			case 1:
				Athlete1.setText("Purchased");
				Athlete1.setEnabled(false);
				break;
			case 2:
				Athlete2.setText("Purchased");
				Athlete2.setEnabled(false);
				break;
			case 3:
				Athlete3.setText("Purchased");
				Athlete3.setEnabled(false);
				break;
			case 4:
				Athlete4.setText("Purchased");
				Athlete4.setEnabled(false);
				break;
			case 5:
				Athlete5.setText("Purchased");
				Athlete5.setEnabled(false);
				break;
			case 6:
				Athlete6.setText("Purchased");
				Athlete6.setEnabled(false);
				break;
		}
	}
	
	private void setAthleteButtons() {
		
		setButtonName(1);
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(1);
				setAthleteSelected(1);
			}
		});
		Athlete1.setBounds(22, 106, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete1);
		
		setButtonName(2);
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(2);
				setAthleteSelected(2);
			}
		});
		Athlete2.setBounds(195, 106, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete2);
		
		setButtonName(3);
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(3);
				setAthleteSelected(3);
			}
		});
		Athlete3.setBounds(22, 169, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete3);
		
		setButtonName(4);
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(4);
				setAthleteSelected(4);
			}
		});
		Athlete4.setBounds(195, 169, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete4);
		
		setButtonName(5);
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(5);
				setAthleteSelected(5);
			}
		});
		Athlete5.setBounds(22, 236, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete5);
		
		setButtonName(6);
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(6);
				setAthleteSelected(6);
			}
		});
		Athlete6.setBounds(195, 236, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete6);

	}
	
	private void setButtonName(int index) {
		
		switch (index) {
			case 1:
				Athlete1 = new JButton();
				if(market.getPlayersForSale().get(index-1).getName().equals("Purchased")) {
					Athlete1.setText("Purchased");
					Athlete1.setEnabled(false);
				} else {
					Athlete1.setText(market.getPlayersForSale().get(index-1).getName());
				}
			case 2:
				Athlete2 = new JButton();
				if(market.getPlayersForSale().get(index-1).getName().equals("Purchased")) {
					Athlete2.setText("Purchased");
					Athlete2.setEnabled(false);
				} else {
					Athlete2.setText(market.getPlayersForSale().get(index-1).getName());
				}
			case 3:
				Athlete3 = new JButton();
				if(market.getPlayersForSale().get(index-1).getName().equals("Purchased")) {
					Athlete3.setText("Purchased");
					Athlete3.setEnabled(false);
				} else {
					Athlete3.setText(market.getPlayersForSale().get(index-1).getName());
				}
			case 4:
				Athlete4 = new JButton();
				if(market.getPlayersForSale().get(index-1).getName().equals("Purchased")) {
					Athlete4.setText("Purchased");
					Athlete4.setEnabled(false);
				} else {
					Athlete4.setText(market.getPlayersForSale().get(index-1).getName());
				}
			case 5:
				Athlete5 = new JButton();
				if(market.getPlayersForSale().get(index-1).getName().equals("Purchased")) {
					Athlete5.setText("Purchased");
					Athlete5.setEnabled(false);
				} else {
					Athlete5.setText(market.getPlayersForSale().get(index-1).getName());
				}
			case 6:
				Athlete6 = new JButton();
				if(market.getPlayersForSale().get(index-1).getName().equals("Purchased")) {
					Athlete6.setText("Purchased");
					Athlete6.setEnabled(false);
				} else {
					Athlete6.setText(market.getPlayersForSale().get(index-1).getName());
				}
			
		}
		
	}
	
	private void updateTeamSlots() {
			lblBenchSlotsAvailable.setText(String.format("Bench Slots available: %s/5", 5 - teams.getBench().size()));
			lblTeamSlotsAvailable.setText(String.format("Team Slots Available: %s/6", 6- teams.getTeamList().size()));
		
	}
	
	private void setAthleteSelected(int num) {
		athleteSelected = num;
	}

}
