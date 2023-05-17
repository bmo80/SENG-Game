package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import athleteInfo.Athlete;
import athleteInfo.TeamManager;
import sengGame.MainGame;
import sengGame.MarketPlace;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BuyPlayerWindow {

	private JFrame frmPlayerTrading;
	private MarketPlace market;
	JLabel lblAthleteName,lblAthletePos, lblAthleteAtt, lblAthleteDef, lblAthleteStam, lblPrice,lblTeamSlotsAvailable,lblBenchSlotsAvailable;
	JButton btnPurchase, Athlete1, Athlete2, Athlete3, Athlete4, Athlete5, Athlete6;
	private int athleteSelected;
	private MainGame gameStats;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuyPlayerWindow window = new BuyPlayerWindow();
//					window.frmPlayerTrading.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public BuyPlayerWindow(MarketPlace curmarket, MainGame game) {
		gameStats = game;
		market = curmarket;
		initialize();
		frmPlayerTrading.setVisible(true);
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerTrading = new JFrame();
		frmPlayerTrading.setTitle("Player Trading");
		frmPlayerTrading.setBounds(100, 100, 580, 437);

		frmPlayerTrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerTrading.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 12, 70, 15);
		frmPlayerTrading.getContentPane().add(lblMoney);
		
		JLabel displayMoney = new JLabel(Integer.toString(market.getMoney()));

		displayMoney.setBounds(72, 12, 70, 15);
		frmPlayerTrading.getContentPane().add(displayMoney);
		
		
		JLabel lblWeek = new JLabel("Week:");
		lblWeek.setBounds(12, 28, 70, 15);
		frmPlayerTrading.getContentPane().add(lblWeek);
		
		JLabel weekNum = new JLabel();
		weekNum.setBounds(72, 28, 70, 15);
		frmPlayerTrading.getContentPane().add(weekNum);
		
		JButton btnViewMyTeam = new JButton("View my Team");
		btnViewMyTeam.setBounds(369, 7, 134, 25);
		frmPlayerTrading.getContentPane().add(btnViewMyTeam);
		
		JLabel lblPlayerTrading = new JLabel("Player Trading");
		lblPlayerTrading.setBounds(196, 28, 122, 39);
		frmPlayerTrading.getContentPane().add(lblPlayerTrading);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(375, 140, 70, 15);
		frmPlayerTrading.getContentPane().add(lblPosition);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(375, 165, 70, 15);
		frmPlayerTrading.getContentPane().add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setBounds(375, 190, 70, 15);
		frmPlayerTrading.getContentPane().add(lblDefense);
		
		JLabel lblStamina = new JLabel("Stamina:");
		lblStamina.setBounds(375, 215, 70, 15);
		frmPlayerTrading.getContentPane().add(lblStamina);
		
		lblAthleteName = new JLabel();
		lblAthleteName.setBounds(450, 115, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel();
		lblAthletePos.setBounds(450, 140, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel();
		lblAthleteAtt.setBounds(450, 165, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel();
		lblAthleteDef.setBounds(450, 190, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel();
		lblAthleteStam.setBounds(450, 215, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteStam);
		
		lblPrice = new JLabel("Price: ");
		lblPrice.setBounds(375, 240, 160, 15);
		frmPlayerTrading.getContentPane().add(lblPrice);
		
		
		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(385, 86, 95, 15);
		frmPlayerTrading.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(375, 115, 70, 15);
		frmPlayerTrading.getContentPane().add(lblName);
		
		setAthleteButtons();
		
		lblTeamSlotsAvailable = new JLabel(String.format("Team Slots Available: %s/5", 5- gameStats.getTeams().getteamList().size()));
		lblTeamSlotsAvailable.setBounds(12, 313, 227, 15);
		frmPlayerTrading.getContentPane().add(lblTeamSlotsAvailable);
		
		lblBenchSlotsAvailable = new JLabel(String.format("Bench Slots available: %s/3", 3 - gameStats.getTeams().getBench().size()));
		lblBenchSlotsAvailable.setBounds(12, 337, 227, 15);
		frmPlayerTrading.getContentPane().add(lblBenchSlotsAvailable);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPlayerTrading.dispose();
				MarketPlaceWindow window = new MarketPlaceWindow(market, gameStats);
			}
		});
		btnDone.setBounds(369, 327, 117, 25);
		frmPlayerTrading.getContentPane().add(btnDone);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				gameStats.getTeams().addAthlete(market.playersForSale.get(athleteSelected-1));
				gameStats.deductMoney(market.playersForSale.get(athleteSelected-1).getBuyPrice());
				displayMoney.setText(Integer.toString(gameStats.getMoney()));
				updateButton(athleteSelected);
				updateTeamSlots();
				Athlete athlete = new Athlete("Purchased",1,1,"A");
				market.playersForSale.set(athleteSelected-1, athlete);
			}
		});
		btnPurchase.setBounds(369, 290, 134, 25);
		frmPlayerTrading.getContentPane().add(btnPurchase);
		
		
		
	}
	
	private void playerStatDisplay(int number) {
		lblAthleteName.setText(market.playersForSale.get(number-1).getName());
		if(market.playersForSale.get(number-1).getPosition() == "A") {
			lblAthletePos.setText("Attacker");
		} else {
			lblAthletePos.setText("Defence");
		}
		lblAthleteAtt.setText(Integer.toString(market.playersForSale.get(number-1).getAttack()));
		lblAthleteDef.setText(Integer.toString(market.playersForSale.get(number-1).getDefence()));
		lblAthleteStam.setText(Integer.toString(market.playersForSale.get(number-1).getStamina()));
		lblPrice.setText(String.format("Price: %s", market.playersForSale.get(number-1).getBuyPrice()));
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
		frmPlayerTrading.getContentPane().add(Athlete1);
		
		setButtonName(2);
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(2);
				setAthleteSelected(2);
			}
		});
		Athlete2.setBounds(195, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete2);
		
		setButtonName(3);
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(3);
				setAthleteSelected(3);
			}
		});
		Athlete3.setBounds(22, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete3);
		
		setButtonName(4);
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(4);
				setAthleteSelected(4);
			}
		});
		Athlete4.setBounds(195, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete4);
		
		setButtonName(5);
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(5);
				setAthleteSelected(5);
			}
		});
		Athlete5.setBounds(22, 236, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete5);
		
		setButtonName(6);
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(6);
				setAthleteSelected(6);
			}
		});
		Athlete6.setBounds(195, 236, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete6);

	}
	
	private void setButtonName(int index) {
		
		switch (index) {
			case 1:
				Athlete1 = new JButton();
				if(market.playersForSale.get(index-1).getName().equals("Purchased")) {
					Athlete1.setText("Purchased");
					Athlete1.setEnabled(false);
				} else {
					Athlete1.setText(market.playersForSale.get(index-1).getName());
				}
			case 2:
				Athlete2 = new JButton();
				if(market.playersForSale.get(index-1).getName().equals("Purchased")) {
					Athlete2.setText("Purchased");
					Athlete2.setEnabled(false);
				} else {
					Athlete2.setText(market.playersForSale.get(index-1).getName());
				}
			case 3:
				Athlete3 = new JButton();
				if(market.playersForSale.get(index-1).getName().equals("Purchased")) {
					Athlete3.setText("Purchased");
					Athlete3.setEnabled(false);
				} else {
					Athlete3.setText(market.playersForSale.get(index-1).getName());
				}
			case 4:
				Athlete4 = new JButton();
				if(market.playersForSale.get(index-1).getName().equals("Purchased")) {
					Athlete4.setText("Purchased");
					Athlete4.setEnabled(false);
				} else {
					Athlete4.setText(market.playersForSale.get(index-1).getName());
				}
			case 5:
				Athlete5 = new JButton();
				if(market.playersForSale.get(index-1).getName().equals("Purchased")) {
					Athlete5.setText("Purchased");
					Athlete5.setEnabled(false);
				} else {
					Athlete5.setText(market.playersForSale.get(index-1).getName());
				}
			case 6:
				Athlete6 = new JButton();
				if(market.playersForSale.get(index-1).getName().equals("Purchased")) {
					Athlete6.setText("Purchased");
					Athlete6.setEnabled(false);
				} else {
					Athlete6.setText(market.playersForSale.get(index-1).getName());
				}
			
		}
		
	}
	
	private void updateTeamSlots() {
		lblTeamSlotsAvailable.setText(String.format("Team Slots Available: %s/5", 5- gameStats.getTeams().getteamList().size()));
		lblBenchSlotsAvailable.setText(String.format("Bench Slots available: %s/3", 3 - gameStats.getTeams().getBench().size()));
	}
	
	private void setAthleteSelected(int num) {
		athleteSelected = num;
	}
}

