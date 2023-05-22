package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import sengGame.MainGame;
import sengGame.MarketPlace;
import javax.swing.JPanel;

import purchasables.Athlete;
import purchasables.TeamManager;

public class SetupBuyPlayerWindow {

	private JFrame frmMakeTeam;
	private MarketPlace market;
	JLabel lblAthleteName,lblAthletePos, lblAthleteAtt, lblAthleteDef, 
	lblAthleteStam, lblPrice,lblTeamSlotsAvailable,lblBenchSlotsAvailable;
	JButton btnPurchase, Athlete1, Athlete2, Athlete3, Athlete4, Athlete5, Athlete6, Athlete7, Athlete8, Athlete9, Athlete10;
	private int athleteSelected;
	private String playerName;
	private int duration, difficulty, money;
	private TeamManager teams;
	private JLabel lblWelcome;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public SetupBuyPlayerWindow(String name, int length, int diff) {
		playerName = name;
		duration = length;
		difficulty = diff;
		market = new MarketPlace(new MainGame(playerName,duration, difficulty));
		market.createSetUp();
		teams = new TeamManager(new ArrayList<Athlete>(), new ArrayList<Athlete>());
		money = market.getGameStats().getMoney();
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
		frmMakeTeam.setBounds(100, 100, 612, 548);

		frmMakeTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMakeTeam.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: %s",money));
		lblMoney.setBounds(12, 12, 194, 15);
		frmMakeTeam.getContentPane().add(lblMoney);
		
		JLabel lblPlayerTrading = new JLabel("You need to recruit atleast 6 players for your team!");
		lblPlayerTrading.setBounds(94, 51, 394, 39);
		frmMakeTeam.getContentPane().add(lblPlayerTrading);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(375, 179, 70, 15);
		frmMakeTeam.getContentPane().add(lblPosition);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(375, 206, 70, 13);
		frmMakeTeam.getContentPane().add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setBounds(375, 231, 70, 15);
		frmMakeTeam.getContentPane().add(lblDefense);
		
		JLabel lblStamina = new JLabel("Stamina:");
		lblStamina.setBounds(375, 258, 70, 15);
		frmMakeTeam.getContentPane().add(lblStamina);
		
		lblAthleteName = new JLabel();
		lblAthleteName.setBounds(435, 152, 154, 15);
		frmMakeTeam.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel();
		lblAthletePos.setBounds(450, 179, 70, 15);
		frmMakeTeam.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel();
		lblAthleteAtt.setBounds(450, 206, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel();
		lblAthleteDef.setBounds(450, 231, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel();
		lblAthleteStam.setBounds(450, 258, 108, 15);
		frmMakeTeam.getContentPane().add(lblAthleteStam);
		
		lblPrice = new JLabel("Price: ");
		lblPrice.setBounds(375, 285, 160, 15);
		frmMakeTeam.getContentPane().add(lblPrice);
		
		Athlete1 = new JButton();
		Athlete1.setBounds(22, 120, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete1);
		
		Athlete2 = new JButton();
		Athlete2.setBounds(195, 120, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete2);
		
		Athlete3 = new JButton();
		Athlete3.setBounds(22, 185, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete3);

		Athlete4 = new JButton();
		Athlete4.setBounds(195, 185, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete4);
		
		Athlete5 = new JButton();
		Athlete5.setBounds(22, 250, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete5);

		Athlete6 = new JButton();
		Athlete6.setBounds(195, 250, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete6);
		
		Athlete7 = new JButton();
		Athlete7.setBounds(22, 315, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete7);
		
		Athlete8 = new JButton();
		Athlete8.setBounds(195, 315, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete8);
		
		Athlete9 = new JButton();
		Athlete9.setBounds(22, 380, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete9);
		
		Athlete10 = new JButton();
		Athlete10.setBounds(195, 380, 160, 39);
		frmMakeTeam.getContentPane().add(Athlete10);
		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(440, 115, 95, 15);
		frmMakeTeam.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(375, 152, 70, 15);
		frmMakeTeam.getContentPane().add(lblName);
		
		setAthleteButtons();

		lblTeamSlotsAvailable = new JLabel();
		lblTeamSlotsAvailable.setBounds(12, 460, 227, 15);
		frmMakeTeam.getContentPane().add(lblTeamSlotsAvailable);
		
		lblBenchSlotsAvailable = new JLabel();
		lblBenchSlotsAvailable.setBounds(12, 487, 227, 15);
		frmMakeTeam.getContentPane().add(lblBenchSlotsAvailable);
		updateTeamSlots();
		
		JButton btnDone = new JButton("Start Game");
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
		btnDone.setBounds(460, 482, 117, 25);
		frmMakeTeam.getContentPane().add(btnDone);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(market.getSetupPlayers().get(athleteSelected-1).getName() == "Purchased") {
					int confirm = JOptionPane.showConfirmDialog(null,"Please select a new player to buy","Player not selected",
							JOptionPane.DEFAULT_OPTION);
				} else {
					if(money - market.getSetupPlayers().get(athleteSelected-1).getBuyPrice() < 0) {
						//BANNED
					}
					else {
						teams.addAthlete(market.getSetupPlayers().get(athleteSelected-1));
						money -= market.getSetupPlayers().get(athleteSelected-1).getBuyPrice();
						lblMoney.setText(String.format("Money: %s",money));
						updateTeamSlots();
						Athlete athlete = new Athlete("Purchased",1,1,"A");
						market.getSetupPlayers().set(athleteSelected-1, athlete);
						setAthleteButtons();
					}
				}

			}
		});
		btnPurchase.setBounds(415, 325, 134, 25);
		frmMakeTeam.getContentPane().add(btnPurchase);
		
		lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Verdana", Font.BOLD, 20));
		lblWelcome.setBounds(235, 24, 139, 15);
		frmMakeTeam.getContentPane().add(lblWelcome);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(375, 102, 214, 253);
		frmMakeTeam.getContentPane().add(panel);
		
		
		
	}
	
	private void playerStatDisplay(int number) {
		lblAthleteName.setText(market.getSetupPlayers().get(number-1).getName());
		if(market.getSetupPlayers().get(number-1).getPosition() == "A") {
			lblAthletePos.setText("Attacker");
		} else {
			lblAthletePos.setText("Defence");
		}
		lblAthleteAtt.setText(Integer.toString(market.getSetupPlayers().get(number-1).getAttack()));
		lblAthleteDef.setText(Integer.toString(market.getSetupPlayers().get(number-1).getDefence()));
		lblAthleteStam.setText(Integer.toString(market.getSetupPlayers().get(number-1).getStamina()));
		lblPrice.setText(String.format("Price: %s", market.getSetupPlayers().get(number-1).getBuyPrice()));
	}
	

	
	private void setAthleteButtons() {
		ArrayList<JButton> list = new ArrayList<JButton>();
		Collections.addAll(list, Athlete1, Athlete2, Athlete3, Athlete4, 
				Athlete5, Athlete6, Athlete7, Athlete8, Athlete9, Athlete10);
		
		int index = 1;
		for(JButton button: list) {
			setButtonName(index, button);
			index++;
		}
		

	}
	
	private void setButtonName(int index, JButton button) {
		if(market.getSetupPlayers().get(index-1).getName().equals("Purchased")) {
			button.setText("Purchased");
			button.setEnabled(false);
		} else {
			button.setText(market.getSetupPlayers().get(index-1).getName());
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(index);
				setAthleteSelected(index);
			}
		});
		
	}
	
	
	private void updateTeamSlots() {
			lblBenchSlotsAvailable.setText(String.format("Bench Slots available: %s/5", 5 - teams.getBench().size()));
			lblTeamSlotsAvailable.setText(String.format("Team Slots Available: %s/6", 6- teams.getTeamList().size()));
		
	}
	
	private void setAthleteSelected(int num) {
		athleteSelected = num;
	}
}
