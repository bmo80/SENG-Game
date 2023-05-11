package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
<<<<<<< HEAD

import sengGame.MarketPlace;

=======
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyPlayerWindow {

	private JFrame frmPlayerTrading;
<<<<<<< HEAD
	private MarketPlace market;
=======

>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyPlayerWindow window = new BuyPlayerWindow();
					window.frmPlayerTrading.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
<<<<<<< HEAD
	public BuyPlayerWindow(MarketPlace curmarket) {
		market = curmarket;
=======
	public BuyPlayerWindow() {
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
		initialize();
		frmPlayerTrading.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerTrading = new JFrame();
		frmPlayerTrading.setTitle("Player Trading");
<<<<<<< HEAD
		frmPlayerTrading.setBounds(100, 100, 580, 437);
=======
		frmPlayerTrading.setBounds(100, 100, 525, 394);
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
		frmPlayerTrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerTrading.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 12, 70, 15);
		frmPlayerTrading.getContentPane().add(lblMoney);
		
<<<<<<< HEAD
		JLabel displayMoney = new JLabel(Integer.toString(market.getMoney()));
=======
		JLabel displayMoney = new JLabel();
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
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
		
<<<<<<< HEAD
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
		
		JLabel lblAthleteName = new JLabel("New label");
		lblAthleteName.setBounds(450, 115, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteName);
		
		
		JLabel lblAthletePos = new JLabel("New label");
		lblAthletePos.setBounds(450, 140, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthletePos);
		
		JLabel lblAthleteAtt = new JLabel("New label");
		lblAthleteAtt.setBounds(450, 165, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteAtt);
		
		JLabel lblAthleteDef = new JLabel("New label");
		lblAthleteDef.setBounds(450, 190, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteDef);
		
		JLabel lblAthleteStam = new JLabel("New label");
		lblAthleteStam.setBounds(450, 215, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteStam);
		
		JButton Athlete2 = new JButton(market.playersForSale.get(1).getName());
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAthleteName.setText(market.playersForSale.get(1).getName());
				if(market.playersForSale.get(0).getPosition() == "A") {
					lblAthletePos.setText("Attacker");
				} else {
					lblAthletePos.setText("Defence");
				}
				lblAthleteAtt.setText(Integer.toString(market.playersForSale.get(1).getAttack()));
				lblAthleteDef.setText(Integer.toString(market.playersForSale.get(1).getDefence()));
				lblAthleteStam.setText(Integer.toString(market.playersForSale.get(1).getStamina()));
			}
		});
		Athlete2.setBounds(195, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete2);
		
		JButton Athlete3 = new JButton(market.playersForSale.get(2).getName());
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAthleteName.setText(market.playersForSale.get(2).getName());
				if(market.playersForSale.get(0).getPosition() == "A") {
					lblAthletePos.setText("Attacker");
				} else {
					lblAthletePos.setText("Defence");
				}
				lblAthleteAtt.setText(Integer.toString(market.playersForSale.get(2).getAttack()));
				lblAthleteDef.setText(Integer.toString(market.playersForSale.get(2).getDefence()));
				lblAthleteStam.setText(Integer.toString(market.playersForSale.get(2).getStamina()));
			}
		});
		Athlete3.setBounds(22, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete3);
		
		JButton Athlete4 = new JButton("AthleteName");
		Athlete4.setBounds(195, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete4);
		
		JButton Athlete5 = new JButton("AthleteName");
		Athlete5.setBounds(22, 236, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete5);
		
		JButton Athlete6 = new JButton("AthleteName");
		Athlete6.setBounds(195, 236, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete6);
=======
		JButton btnNewButton = new JButton("AthleteName");
		btnNewButton.setBounds(22, 106, 134, 39);
		frmPlayerTrading.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AthleteName");
		btnNewButton_1.setBounds(184, 106, 134, 39);
		frmPlayerTrading.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("AthleteName");
		btnNewButton_2.setBounds(22, 169, 134, 39);
		frmPlayerTrading.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("AthleteName");
		btnNewButton_3.setBounds(184, 169, 134, 39);
		frmPlayerTrading.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("AthleteName");
		btnNewButton_4.setBounds(22, 236, 134, 39);
		frmPlayerTrading.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("AthleteName");
		btnNewButton_5.setBounds(184, 236, 134, 39);
		frmPlayerTrading.getContentPane().add(btnNewButton_5);
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(385, 86, 95, 15);
		frmPlayerTrading.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
<<<<<<< HEAD
		lblName.setBounds(375, 115, 70, 15);
		frmPlayerTrading.getContentPane().add(lblName);
		
		JButton Athlete1 = new JButton(market.playersForSale.get(0).getName());
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAthleteName.setText(market.playersForSale.get(0).getName());
				if(market.playersForSale.get(0).getPosition() == "A") {
					lblAthletePos.setText("Attacker");
				} else {
					lblAthletePos.setText("Defence");
				}
				lblAthleteAtt.setText(Integer.toString(market.playersForSale.get(0).getAttack()));
				lblAthleteDef.setText(Integer.toString(market.playersForSale.get(0).getAttack()));
				lblAthleteStam.setText(Integer.toString(market.playersForSale.get(0).getStamina()));
			}
		});
		Athlete1.setBounds(22, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete1);
		
=======
		lblName.setBounds(336, 115, 70, 15);
		frmPlayerTrading.getContentPane().add(lblName);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(336, 140, 70, 15);
		frmPlayerTrading.getContentPane().add(lblPosition);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(336, 165, 70, 15);
		frmPlayerTrading.getContentPane().add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setBounds(336, 190, 70, 15);
		frmPlayerTrading.getContentPane().add(lblDefense);
		
		JLabel lblStamina = new JLabel("Stamina:");
		lblStamina.setBounds(336, 215, 70, 15);
		frmPlayerTrading.getContentPane().add(lblStamina);
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
		
		JLabel lblTeamSlotsAvailable = new JLabel("Team Slots Available:");
		lblTeamSlotsAvailable.setBounds(12, 313, 173, 15);
		frmPlayerTrading.getContentPane().add(lblTeamSlotsAvailable);
		
		JLabel lblBenchSlotsAvailable = new JLabel("Bench Slots Available:");
		lblBenchSlotsAvailable.setBounds(12, 337, 173, 15);
		frmPlayerTrading.getContentPane().add(lblBenchSlotsAvailable);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPlayerTrading.dispose();
<<<<<<< HEAD
				MarketPlaceWindow window = new MarketPlaceWindow(market);
=======
				MarketPlaceWindow window = new MarketPlaceWindow(10000, 3);
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
			}
		});
		btnDone.setBounds(369, 327, 117, 25);
		frmPlayerTrading.getContentPane().add(btnDone);
<<<<<<< HEAD

		
		
	}
}
=======
	}
}
>>>>>>> 679adb5dc7dc3bf5b7b14b2d00a2b8c49143e07b
