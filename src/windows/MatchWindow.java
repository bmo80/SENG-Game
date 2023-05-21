package windows;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import sengGame.Match;
import sengGame.Stadium;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatchWindow {

	private JFrame frmPlayMatch, frmStadium;
	private JFrame mainMenu;
	private Stadium stadium;
	private Match match;
	JLabel lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, 
	lblPlayer6, lblScores, lblScore,lblWinLose;

	

	/**
	 * Create the application.
	 */

	public MatchWindow(Match curMatch, JFrame curStadiumWindow) {
		match = curMatch;
		frmStadium = curStadiumWindow;
		frmStadium.setVisible(false);
		match.playMatch();
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
		
		lblScore = new JLabel("Final Score:");
		lblScore.setBounds(167, 22, 95, 15);
		frmPlayMatch.getContentPane().add(lblScore);
		
		lblScores = new JLabel("Player:Enemy");
		lblScores.setBounds(189, 49, 118, 15);
		frmPlayMatch.getContentPane().add(lblScores);
		
		lblPlayer1 = new JLabel("New label");
		lblPlayer1.setBounds(30, 80, 368, 15);
		frmPlayMatch.getContentPane().add(lblPlayer1);
		
		lblPlayer2 = new JLabel("New label");
		lblPlayer2.setBounds(30, 115, 368, 15);
		frmPlayMatch.getContentPane().add(lblPlayer2);
		
		lblPlayer3 = new JLabel("New label");
		lblPlayer3.setBounds(30, 150, 350, 15);
		frmPlayMatch.getContentPane().add(lblPlayer3);
		
		lblPlayer4 = new JLabel("New label");
		lblPlayer4.setBounds(30, 185, 350, 15);
		frmPlayMatch.getContentPane().add(lblPlayer4);
		
		lblPlayer5 = new JLabel("New label");
		lblPlayer5.setBounds(30, 220, 350, 15);
		frmPlayMatch.getContentPane().add(lblPlayer5);
		
		lblPlayer6 = new JLabel("New label");
		lblPlayer6.setBounds(30, 255, 350, 15);
		frmPlayMatch.getContentPane().add(lblPlayer6);
		
		showPlayerScores();
		showGameScore();
		

		lblWinLose = new JLabel("New label");
		if(match.playerScore > match.oppsScore) {
			lblWinLose.setText("Victory!");
		} else {
			lblWinLose.setText("Defeat!");
		}
		lblWinLose.setBounds(167, 287, 70, 15);

		frmPlayMatch.getContentPane().add(lblWinLose);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPlayMatch.setVisible(false);
				frmStadium.setVisible(true);
			}
		});
		btnFinish.setBounds(302, 282, 117, 25);

		frmPlayMatch.getContentPane().add(btnFinish);
	}
	
	private void showPlayerScores() {
		ArrayList<JLabel> list = new ArrayList<JLabel>();
		Collections.addAll(list, lblPlayer1, lblPlayer2, lblPlayer3, lblPlayer4, lblPlayer5, lblPlayer6);
		int index = 1;
		for(JLabel label: list) {
			setLabelScore(label, index);
			index++;
		}
	}
	
	private void setLabelScore(JLabel label, int index) {
		label.setText(String.format("%s scored %s goals this match", 
				match.playerTeam.get(index-1).getName(), match.athleteScores.get(index-1)));
	}
	
	private void showGameScore() {
		lblScores.setText(String.format("%s : %s", match.playerScore, match.oppsScore));
	}
}
