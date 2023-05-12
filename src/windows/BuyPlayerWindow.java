package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import sengGame.MarketPlace;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BuyPlayerWindow {

	private JFrame frmPlayerTrading;
	private MarketPlace market;
	JLabel lblAthleteName,lblAthletePos, lblAthleteAtt, lblAthleteDef, lblAthleteStam;
	private int athleteSelected;
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
	public BuyPlayerWindow(MarketPlace curmarket) {
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
		
		lblAthleteName = new JLabel("New label");
		lblAthleteName.setBounds(450, 115, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel("New label");
		lblAthletePos.setBounds(450, 140, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel("New label");
		lblAthleteAtt.setBounds(450, 165, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel("New label");
		lblAthleteDef.setBounds(450, 190, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel("New label");
		lblAthleteStam.setBounds(450, 215, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteStam);
		
		JButton Athlete2 = new JButton(market.playersForSale.get(1).getName());
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(2);
				setAthleteSelected(2);
			}
		});
		Athlete2.setBounds(195, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete2);
		
		JButton Athlete3 = new JButton(market.playersForSale.get(2).getName());
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(3);
				setAthleteSelected(3);
			}
		});
		Athlete3.setBounds(22, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete3);
		
		JButton Athlete4 = new JButton(market.playersForSale.get(3).getName());
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(4);
				setAthleteSelected(4);
			}
		});
		Athlete4.setBounds(195, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete4);
		
		JButton Athlete5 = new JButton(market.playersForSale.get(4).getName());
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(5);
				setAthleteSelected(5);
			}
		});
		Athlete5.setBounds(22, 236, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete5);
		
		JButton Athlete6 = new JButton(market.playersForSale.get(5).getName());
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(6);
				setAthleteSelected(6);
			}
		});
		Athlete6.setBounds(195, 236, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete6);

		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(385, 86, 95, 15);
		frmPlayerTrading.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(375, 115, 70, 15);
		frmPlayerTrading.getContentPane().add(lblName);
		
		JButton Athlete1 = new JButton(market.playersForSale.get(0).getName());
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStatDisplay(1);
				setAthleteSelected(1);
			}
		});
		Athlete1.setBounds(22, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete1);


		
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
				MarketPlaceWindow window = new MarketPlaceWindow(market);
			}
		});
		btnDone.setBounds(369, 327, 117, 25);
		frmPlayerTrading.getContentPane().add(btnDone);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Purchased Athlete number "+athleteSelected);
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
	}
	
	private void setAthleteSelected(int num) {
		athleteSelected = num;
	}
}

