package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import sengGame.MainGame;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverWindow {

	private JFrame frmGameOver;
	private MainGame game;
	
	/**
	 * Create the application.
	 */
	public GameOverWindow(MainGame givenStats) {
		game = givenStats;
		initialize();
		frmGameOver.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("GAME OVER");
		frmGameOver.setBounds(100, 100, 450, 300);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameOver.getContentPane().setLayout(null);
		
		JTextPane gameOverInfo = new JTextPane();
		gameOverInfo.setEditable(false);
		gameOverInfo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		gameOverInfo.setText(game.getFinalStats());
		gameOverInfo.setBounds(12, 12, 416, 133);
		frmGameOver.getContentPane().add(gameOverInfo);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetupWindow setupWindow = new SetupWindow();
				frmGameOver.dispose();
			}
		});
		btnPlayAgain.setBackground(new Color(38, 162, 105));
		btnPlayAgain.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPlayAgain.setBounds(96, 160, 228, 71);
		frmGameOver.getContentPane().add(btnPlayAgain);
	}
}
