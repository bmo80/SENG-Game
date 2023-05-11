package sengGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyPlayerWindow {

	private JFrame frmPlayerTrading;

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
	public BuyPlayerWindow() {
		initialize();
		frmPlayerTrading.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerTrading = new JFrame();
		frmPlayerTrading.setTitle("Player Trading");
		frmPlayerTrading.setBounds(100, 100, 525, 394);
		frmPlayerTrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerTrading.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 12, 70, 15);
		frmPlayerTrading.getContentPane().add(lblMoney);
		
		JLabel displayMoney = new JLabel();
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
		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(385, 86, 95, 15);
		frmPlayerTrading.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
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
				MarketPlaceWindow window = new MarketPlaceWindow(10000, 3);
			}
		});
		btnDone.setBounds(369, 327, 117, 25);
		frmPlayerTrading.getContentPane().add(btnDone);
	}
}
