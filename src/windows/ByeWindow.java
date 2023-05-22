package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sengGame.MainGame;
import sengGame.MarketPlace;
import sengGame.Stadium;

import javax.swing.SwingConstants;

import purchasables.Athlete;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Bye Window deals with displaying what random events
 * happened during the bye week
 * @author Blair Brydon
 * @author Ben Moore
 */
public class ByeWindow {
	/**
	 * Variable for the current frame
	 */
	private JFrame frmByeWindow;
	/**
	 * Variable to store the current instance of MainGame
	 */
	private MainGame game;
	/**
	 * Variable to store the athlete that was trained
	 */
	private Athlete trainedAthlete;
	/**
	 * String that describes what random event happened
	 */
	private String eventInfo;

	/**
	 * Constructor for the Bye Window. Sets required variables and 
	 * initializes the frame
	 * @param currentGame current maingame instance
	 * @param athleteName name of the athlete having the bye event done on
	 */
	public ByeWindow(MainGame currentGame,String athleteName) {
		game = currentGame;
		trainedAthlete = game.getTeams().getAthleteFromString(athleteName);
		eventInfo = game.takeBye(athleteName);
		//Add random event
		initialize();
		frmByeWindow.setVisible(true);
		
	}
	/**
	 * Method to re launch the main screen after the bye and dispose of the window
	 */
	public void closeWindow() {
		game.launchMainScreen();
		frmByeWindow.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmByeWindow = new JFrame();
		frmByeWindow.setTitle("Bye Window");
		frmByeWindow.setBounds(100, 100, 450, 300);
		frmByeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmByeWindow.getContentPane().setLayout(null);
		
		JLabel lblAfterTakingA = new JLabel("After taking a bye week, the following happened:");
		lblAfterTakingA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfterTakingA.setBounds(12, 23, 416, 15);
		frmByeWindow.getContentPane().add(lblAfterTakingA);
		
		JLabel athleteLabel = new JLabel(String.format("%s gained %s %s",
				trainedAthlete.getName(), Integer.toString(4-game.getDifficulty()),
				trainedAthlete.getPosition()));
		athleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		athleteLabel.setBounds(12, 56, 416, 15);
		frmByeWindow.getContentPane().add(athleteLabel);

		JLabel lblMarketAndStadium = new JLabel("Market and Stadium have been reset");
		lblMarketAndStadium.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarketAndStadium.setBounds(12, 88, 416, 15);
		frmByeWindow.getContentPane().add(lblMarketAndStadium);
		
		JLabel lblAllAthletesHave = new JLabel("All athletes have full stamina");
		lblAllAthletesHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllAthletesHave.setBounds(12, 120, 416, 15);
		frmByeWindow.getContentPane().add(lblAllAthletesHave);
		
		JLabel lblRandomEvent = new JLabel("Special Event:");
		lblRandomEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomEvent.setBounds(12, 149, 416, 15);
		frmByeWindow.getContentPane().add(lblRandomEvent);
		
		//To be added
		JLabel randomEventLabel = new JLabel(eventInfo);
		randomEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		randomEventLabel.setBounds(12, 169, 416, 51);
		frmByeWindow.getContentPane().add(randomEventLabel);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		continueButton.setBounds(165, 232, 117, 25);
		frmByeWindow.getContentPane().add(continueButton);
	}
}
