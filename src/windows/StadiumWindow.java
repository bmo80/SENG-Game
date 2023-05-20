package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import athleteInfo.Athlete;
import sengGame.MainGame;
import sengGame.Stadium;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class StadiumWindow {

	private JFrame frmStadium;
	JButton btnTeam1, btnTeam2, btnTeam3;
	JLabel lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6;
	private int buttonSelected;
	private MainGame mainGame;
	private Stadium stadium;
	private JFrame mainWindow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StadiumWindow window = new StadiumWindow();
					window.frmStadium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StadiumWindow(MainGame currentGame, Stadium curStadium) {
		stadium = curStadium;
		mainGame = currentGame;
		initialize();
		frmStadium.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 598, 379);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStadium.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Stadium!");
		lblNewLabel.setBounds(220, 11, 150, 14);
		frmStadium.getContentPane().add(lblNewLabel);
		
		JLabel lblMoney = new JLabel("New label");
		lblMoney.setBounds(10, 11, 46, 14);
		frmStadium.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel("New label");
		lblWeek.setBounds(10, 28, 46, 14);
		frmStadium.getContentPane().add(lblWeek);
		
		JLabel lblChooseText = new JLabel("Choose Which team you would like to play!");
		lblChooseText.setBounds(180, 36, 216, 14);
		frmStadium.getContentPane().add(lblChooseText);
		
		JButton btnTeam1 = new JButton("Team1");
		btnTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSelected = 1;
				updateLabels(buttonSelected);
			}
		});
		btnTeam1.setBounds(10, 90, 113, 43);
		frmStadium.getContentPane().add(btnTeam1);
		
		JButton btnTeam2 = new JButton("Team 2");
		btnTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSelected = 2;
				updateLabels(buttonSelected);
			}
		});
		btnTeam2.setBounds(10, 160, 113, 43);
		frmStadium.getContentPane().add(btnTeam2);
		
		JButton btnTeam3 = new JButton("Team 3");
		btnTeam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSelected = 3;
				updateLabels(buttonSelected);
			}
		});
		btnTeam3.setBounds(10, 230, 113, 43);
		frmStadium.getContentPane().add(btnTeam3);
		
		JLabel lblActive = new JLabel("Active Players");
		lblActive.setBounds(244, 71, 106, 14);
		frmStadium.getContentPane().add(lblActive);
		
		lblPlayer1 = new JLabel("New label");
		lblPlayer1.setBounds(244, 100, 315, 14);
		frmStadium.getContentPane().add(lblPlayer1);
		
		lblPlayer2 = new JLabel("New label");
		lblPlayer2.setBounds(244, 130, 315, 14);
		frmStadium.getContentPane().add(lblPlayer2);
		
		lblPlayer3 = new JLabel("New label");
		lblPlayer3.setBounds(244, 160, 315, 14);
		frmStadium.getContentPane().add(lblPlayer3);
		
		lblPlayer4 = new JLabel("New label");
		lblPlayer4.setBounds(244, 190, 315, 14);
		frmStadium.getContentPane().add(lblPlayer4);
		
		lblPlayer5 = new JLabel("New label");
		lblPlayer5.setBounds(244, 220, 315, 14);
		frmStadium.getContentPane().add(lblPlayer5);
		
		lblPlayer6 = new JLabel("New label");
		lblPlayer6.setBounds(244, 250, 315, 14);
		frmStadium.getContentPane().add(lblPlayer6);
		
		startLabels();
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.setBounds(351, 280, 89, 23);
		frmStadium.getContentPane().add(btnChoose);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(483, 306, 89, 23);
		frmStadium.getContentPane().add(btnBack);
	}
	
	private void updateLabels(int index) {
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		Collections.addAll(labels, lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6);
		team = stadium.getEnemyTeams().get(index-1);
		int count = 0;
		for(Athlete athlete: team) {
			labels.get(count).setText(athlete.toString());
			labels.get(count).setEnabled(true);
			count++;
		}
	}
	
	private void startLabels() {
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		Collections.addAll(labels, lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6);
		for(JLabel label: labels) {
			label.setEnabled(false);
		}
	}
}
