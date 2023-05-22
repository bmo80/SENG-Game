package windows;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import mainMenus.MainGame;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Deals with displaying the end game screen
 * @author Blair Brydon
 * @author Ben Moore
 */
public class GameOverWindow {

	/**
	 * Variable to store the current frame
	 */
	private JFrame frmGameOver;
	/**
	 * Variable to store the current main game object
	 */
	private MainGame game;
	
	/**
	 * Constructor for GameOverWindow. Initializes the frame
	 * @param givenStats current maingame object
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
