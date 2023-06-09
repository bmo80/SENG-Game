package windows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import mainMenus.Match;
import mainMenus.Stadium;
import purchasables.Athlete;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

/**
 * Stadium Window class shows the player the available teams to verse
 * and then sets up the match between the player's team and the selected team
 *@author Blair Brydon
 *@author Ben Moore
 *
 */
public class StadiumWindow {

	/**
	 * Variables to store the current frame and the main frame
	 */
	private JFrame frmStadium, mainMenu;
	/**
	 * Button variables to show the team number
	 */
	private JButton btnTeam1, btnTeam2, btnTeam3;
	/**
	 * Labels to show the players from the opposing team
	 */
	private JLabel lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6;
	/**
	 * Variable to store the current team button selected
	 */
	private int buttonSelected;
	/**
	 * Variable to store the current instance of stadium
	 */
	private Stadium stadium;
	/**
	 * Variable to store current MainWindow object
	 */
	private MainWindow main;
	/**
	 * ArrayList that stores the current enemy team chosen
	 */
	private ArrayList<Athlete> teamChosen;
	/**
	 * Labels to display the week and money
	 */
	JLabel lblMoney, lblWeek;

	/**
	 * Constructor method for the Stadium Window. Sets initial variables
	 * and initializes the frame
	 * @param curStadium current stadium object
	 * @param mainGame current main menu frame
	 * @param curMain current main menu object
	 */
	public StadiumWindow(Stadium curStadium, JFrame mainGame, MainWindow curMain) {
		mainMenu = mainGame;
		stadium = curStadium;
		main = curMain;
		buttonSelected = 1;
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
		lblNewLabel.setBounds(192, 11, 232, 14);
		frmStadium.getContentPane().add(lblNewLabel);
		
		lblMoney = new JLabel(String.format("Money: $%s",
				stadium.getGameStats().getMoney()));
		lblMoney.setBounds(10, 11, 113, 14);
		frmStadium.getContentPane().add(lblMoney);
		
		lblWeek = new JLabel(String.format("Week: %s/%s",
				stadium.getGameStats().getWeek(),
				stadium.getGameStats().getDuration()));
		lblWeek.setBounds(10, 28, 96, 14);
		frmStadium.getContentPane().add(lblWeek);
		
		JLabel lblChooseText = new JLabel(
				"Choose Which team you would like to play!");
		lblChooseText.setBounds(136, 37, 327, 14);
		frmStadium.getContentPane().add(lblChooseText);
		
		 btnTeam1 = new JButton("Team1");
		btnTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSelected = 1;
				updateLabels(buttonSelected);
			}
		});
		btnTeam1.setBounds(10, 90, 113, 43);
		frmStadium.getContentPane().add(btnTeam1);
		
		btnTeam2 = new JButton("Team 2");
		btnTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSelected = 2;
				updateLabels(buttonSelected);
			}
		});
		btnTeam2.setBounds(10, 160, 113, 43);
		frmStadium.getContentPane().add(btnTeam2);
		
		 btnTeam3 = new JButton("Team 3");
		btnTeam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSelected = 3;
				updateLabels(buttonSelected);
			}
		});
		
		btnTeam3.setBounds(10, 230, 113, 43);
		frmStadium.getContentPane().add(btnTeam3);
		
		setButtons();
		
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
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stadium.getEnemyTeams().get(buttonSelected-1).size() == 1) {
					JOptionPane.showConfirmDialog(null,String.format(
							"You have already played against Team %s\nPlease "
							+ "choose another team",buttonSelected),
							"Not enough Athletes",
							JOptionPane.DEFAULT_OPTION);
				}
				else {
					int result = JOptionPane.showConfirmDialog(frmStadium,
							"Are you sure you want to play Team "
					+ buttonSelected + "?",
							"Confirm Team Selection",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						//Checks enough players and players healthy
						if (Match.checkAllInjured(
								stadium.getGameStats().getTeams().getTeamList())
								||
								stadium.getGameStats().getTeams().getTeamList().size()
								< 6) {
							JOptionPane.showConfirmDialog(null,
									"Not enough viable athletes"
									+ "\nCheck active team full and has at least"
									+ " one uninjured player.",
									"Not enough Athletes",
									JOptionPane.DEFAULT_OPTION);
						}
						else {
							frmStadium.setVisible(false);
							MatchWindow window = new MatchWindow(
									stadium.getGameStats(),
									stadium.getEnemyTeams().get(buttonSelected-1),
									frmStadium);
							ArrayList<Athlete> blankTeam = new ArrayList<Athlete>();
							Athlete athlete = new Athlete(
									"Match played", 1, 1, "A");
							blankTeam.add(athlete);
							stadium.getEnemyTeams().set(
									buttonSelected - 1, blankTeam);
							setButtons();
							updateMainWindow();						
						}
					}
				}
			}
		});
		btnChoose.setBounds(351, 280, 89, 23);
		frmStadium.getContentPane().add(btnChoose);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStadium.setVisible(false);
				mainMenu.setVisible(true);
				
			}
		});
		btnBack.setBounds(483, 306, 89, 23);
		frmStadium.getContentPane().add(btnBack);
	}
	
	/**
	 * Updates the Labels to display the correct team
	 * @param index position of correct enemy team in ArrayList
	 */
	private void updateLabels(int index) {
		ArrayList<Athlete> team = new ArrayList<Athlete>();
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		Collections.addAll(labels, lblPlayer1, lblPlayer2,
				lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6);
		team = stadium.getEnemyTeams().get(index-1);
		int count = 0;
		for(Athlete athlete: team) {
			labels.get(count).setText(athlete.toString());
			labels.get(count).setEnabled(true);
			count ++;
		}
	}
	/**
	 * Sets all the labels to be invisible
	 */
	private void startLabels() {
		ArrayList<JLabel> labels = new ArrayList<JLabel>();
		Collections.addAll(labels, lblPlayer1, lblPlayer2,
				lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6);
		for(JLabel label: labels) {
			label.setEnabled(false);
		}
	}
	
	/**
	 * Checks if any of the enemy teams have already been played
	 * if so it disables the button
	 */
	private void setButtons() {
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		Collections.addAll(buttons, btnTeam1, btnTeam2, btnTeam3);
		int index = 0;
		for(JButton btn: buttons) {
			if(stadium.getEnemyTeams().get(index).size() == 1) {
				btn.setText("Match Played");
				btn.setEnabled(false);
			} 
			index++;
		}
	}
	
	/**
	 * Update the values displayed in main window
	 */
	private void updateMainWindow() {
		lblMoney.setText(String.format("Money: $%s",
				stadium.getGameStats().getMoney()));
		main.totalPointsLbl.setText(String.format("%s Total points",
				stadium.getGameStats().getPoints()));
		main.MoneyLbl.setText(String.format("Money: $%s",
				stadium.getGameStats().getMoney()));
		main.lblRecord.setText(String.format("Record: W:%s - T:%s - L:%s",
				stadium.getGameStats().getWins(),
				stadium.getGameStats().getLosses(),
				stadium.getGameStats().getDraws()));
	}
}
