package windows;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import sengGame.MainGame;
import sengGame.Match;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import purchasables.Athlete;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * MatchWindow Class deals with showing the results from the recent match played
 * @author Blair Brydon
 * @author Ben Moore
 */
public class MatchWindow {

	/**
	 * Variables to store the current,stadium and mainmenu frames
	 */
	private JFrame frmPlayMatch, frmStadium;
	/**
	 * Variable to store the current match object
	 */
	private Match match;
	private String message;
	/**
	 * Variables to store the labels to be initialized
	 */
	private JLabel lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, 
	lblPlayer6, lblScores, lblScore,lblWinLose;


	/**
	 * Create the application.
	 * Constructor for the MatchWindow. Checks if the conditions
	 * are met to be able to play then initializes the frame to show
	 * the results
	 * @param currentMatch current match object
	 * @param curStadiumWindow stadium frame
	 */
	public MatchWindow(MainGame givenGame, ArrayList<Athlete> opponents,
			JFrame curStadiumWindow) {
		match = new Match(givenGame, opponents);
		frmStadium = curStadiumWindow;
		message = match.playMatch();
		initialize();
		frmPlayMatch.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayMatch = new JFrame();
		frmPlayMatch.setTitle("Play Match");
		frmPlayMatch.setBounds(100, 100, 441, 344);
		frmPlayMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayMatch.getContentPane().setLayout(null);
		
		JOptionPane.showConfirmDialog(null,String.format(
				"After the match All athletes lost 1 stamina"
				+ "\n%s",message),"MATCH OVER",
				JOptionPane.DEFAULT_OPTION);
		
		lblScore = new JLabel("Final Score:");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(12, 33, 417, 15);
		frmPlayMatch.getContentPane().add(lblScore);
		
		lblScores = new JLabel("Player:Enemy");
		lblScores.setHorizontalAlignment(SwingConstants.CENTER);
		lblScores.setBounds(12, 55, 417, 15);
		frmPlayMatch.getContentPane().add(lblScores);
		
		lblPlayer1 = new JLabel("New label");
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setBounds(12, 80, 417, 15);
		frmPlayMatch.getContentPane().add(lblPlayer1);
		
		lblPlayer2 = new JLabel("New label");
		lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2.setBounds(12, 115, 417, 15);
		frmPlayMatch.getContentPane().add(lblPlayer2);
		
		lblPlayer3 = new JLabel("New label");
		lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer3.setBounds(12, 150, 417, 15);
		frmPlayMatch.getContentPane().add(lblPlayer3);
		
		lblPlayer4 = new JLabel("New label");
		lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer4.setBounds(12, 185, 417, 15);
		frmPlayMatch.getContentPane().add(lblPlayer4);
		
		lblPlayer5 = new JLabel("New label");
		lblPlayer5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer5.setBounds(12, 220, 417, 15);
		frmPlayMatch.getContentPane().add(lblPlayer5);
		
		lblPlayer6 = new JLabel("New label");
		lblPlayer6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer6.setBounds(12, 255, 417, 15);
		frmPlayMatch.getContentPane().add(lblPlayer6);
		
		showPlayerScores();
		showGameScore();
		
		lblWinLose = new JLabel("New label");
		lblWinLose.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWinLose.setHorizontalAlignment(SwingConstants.CENTER);
		if(Match.checkAllInjured(match.getPlayerTeam())) {
			lblWinLose.setText("Defeat via KO");
		}
		else if(match.getPlayerScore() > match.getOppsScore()) {
			lblWinLose.setText("Victory!");
		} else if(match.getPlayerScore() < match.getOppsScore()){
			lblWinLose.setText("Defeat!");
		} else {
			lblWinLose.setText("Draw!");
		}
		lblWinLose.setBounds(12, 10, 417, 20);

		frmPlayMatch.getContentPane().add(lblWinLose);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmPlayMatch.setVisible(false);
			
				frmStadium.setVisible(true);
			}
		});
		btnFinish.setBounds(163, 282, 117, 25);

		frmPlayMatch.getContentPane().add(btnFinish);
	}
	
	/**
	 * Updates the players labels to show how many goals each
	 * player scored
	 */
	private void showPlayerScores() {
		ArrayList<JLabel> list = new ArrayList<JLabel>();
		Collections.addAll(list, lblPlayer1, lblPlayer2,
				lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6);
		int index = 1;
		for(JLabel label: list) {
			setLabelScore(label, index);
			index++;
		}
	}
	
	/**
	 * Support function for showPlayerScores which sets the specified label
	 * and athlete index to show correct score.
	 * @param label the label to be set
	 * @param index the index of the athletes player score
	 */
	private void setLabelScore(JLabel label, int index) {
		label.setText(String.format("%s: %s goals, stamina: %s, "+
				(match.getPlayerTeam().get(index-1).getIsInjured()?
						"Injured":"Healthy"), 
				match.getPlayerTeam().get(index-1).getName(), 
				match.getAthleteScores().get(index-1), 
				match.getPlayerTeam().get(index-1).getStamina()));
	}
	
	/**
	 * Updates the label to show the final match score
	 */
	private void showGameScore() {
		lblScores.setText(String.format("%s : %s",
				match.getPlayerScore(), match.getOppsScore()));
	}
}
