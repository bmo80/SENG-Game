package windows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import mainMenus.MainGame;
import mainMenus.MarketPlace;
import mainMenus.Stadium;

/**
 * MainWindow Deals with displaying all the options from the main window.
 * These are stadium, marketplace, club or taking a bye
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class MainWindow {

	/**
	 * Variable to store the current frame
	 */
	private JFrame frmMainGame;
	/**
	 * Variable to store current MainGame object
	 */
	private MainGame game;
	/**
	 * Variable to store the MainWindow object
	 */
	private MainWindow main;
	/**
	 * Variable to store the current marketplace instance
	 */
	private MarketPlace market;
	/**
	 * Variable to store the current stadium instance
	 */
	private Stadium stadium;
	/**
	 * Variables to store Money and record labels
	 */
	JLabel MoneyLbl, lblRecord, totalPointsLbl;

	/**
	 * Constructor for the MainWindow. Sets the initial variables and
	 * initializes the frame
	 * @param getGame current instance of maingame
	 * @param givenMarket current instance of the marketplace
	 * @param givenStadium current instance of the stadium
	 */
	public MainWindow(MainGame getGame,
			MarketPlace givenMarket, Stadium givenStadium) {
		game = getGame;
		market = givenMarket;
		stadium = givenStadium;
		main = this;
		initialize();
		frmMainGame.setVisible(true);
	}
	
	/**
	 * Dispose this window
	 */
	public void closeWindow() {
		frmMainGame.dispose();
	}
	
	/**
	 * Show this window
	 */
	public void showWindow() {
		frmMainGame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainGame = new JFrame();
		frmMainGame.getContentPane().setBackground(new Color(222, 221, 218));
		frmMainGame.getContentPane().setForeground(new Color(246, 211, 45));
		frmMainGame.setTitle("Main Game");
		frmMainGame.setBounds(100, 100, 651, 480);
		frmMainGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainGame.getContentPane().setLayout(null);
		
		MoneyLbl = new JLabel(String.format("Money: $%s", game.getMoney()));
		MoneyLbl.setBounds(12, 8, 426, 15);
		frmMainGame.getContentPane().add(MoneyLbl);
		
		JLabel WeekLbl = new JLabel(String.format("Week: %s/%s",
				game.getWeek(), game.getDuration()));
		WeekLbl.setBounds(12, 25, 91, 15);
		frmMainGame.getContentPane().add(WeekLbl);
		
		
		JButton btnClub = new JButton("Go to Club");
		btnClub.setBackground(Color.red);
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainGame.setVisible(false);
				ClubWindow club = new ClubWindow(game, frmMainGame);
			}
		});
		btnClub.setBounds(12, 64, 148, 77);
		frmMainGame.getContentPane().add(btnClub);
		
		
		
		JButton btnMarket = new JButton("Go to Market");
		btnMarket.setBackground(Color.green);
		btnMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainGame.setVisible(false);
				MarketPlaceWindow window = new MarketPlaceWindow(
						market, frmMainGame, main);
				MoneyLbl.setText(String.format("Money: $%s",
						market.getGameStats().getMoney()));
			}
		});
		btnMarket.setBounds(12, 177, 148, 77);
		frmMainGame.getContentPane().add(btnMarket);
		
		JButton btnStadium = new JButton("Go to Stadium");
		btnStadium.setBackground(Color.cyan);
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainGame.setVisible(false);
				StadiumWindow window = new StadiumWindow(
						stadium, frmMainGame, main);
				MoneyLbl.setText(String.format("Money: $%s", game.getMoney()));
			}
		});
		btnStadium.setBounds(12, 288, 148, 77);
		frmMainGame.getContentPane().add(btnStadium);
		
		
		JButton btnBye = new JButton("Take bye week");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmMainGame, 
						"This will advance to the next week."
						+ "\nDo you want to continue?",
						"Bye Warning",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					frmMainGame.dispose();
					String[] choices = game.getTeams().getTeamsString();
					String selection = (String) JOptionPane.showInputDialog(
							frmMainGame,"Who do you want to train?",
							"Weekly training", JOptionPane.PLAIN_MESSAGE,
							null, choices, null);
					//Run special window (over top) showing what happened
					ByeWindow byeWindow = new ByeWindow(game,selection);
;				}
			}
		});
		btnBye.setBounds(12, 400, 148, 25);
		frmMainGame.getContentPane().add(btnBye);
		
		JLabel lblTeamName = new JLabel(game.getPlayerName()+" FC");
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamName.setFont(new Font("Arial", Font.BOLD, 16));
		lblTeamName.setBounds(161, 20, 334, 20);
		frmMainGame.getContentPane().add(lblTeamName);
		
		lblRecord = new JLabel("Record: W:0 - T:0 - L:0");
		lblRecord.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecord.setBounds(403, 8, 210, 15);
		frmMainGame.getContentPane().add(lblRecord);
		
		JLabel weeksLeftLbl = new JLabel(String.format("%s Weeks left",
				game.getDuration()-game.getWeek()));
		weeksLeftLbl.setHorizontalAlignment(SwingConstants.CENTER);
		weeksLeftLbl.setFont(new Font("Dialog", Font.BOLD, 35));
		weeksLeftLbl.setBounds(204, 288, 378, 57);
		frmMainGame.getContentPane().add(weeksLeftLbl);
		
		totalPointsLbl = new JLabel(String.format("%s Total points",
				game.getPoints()));
		totalPointsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		totalPointsLbl.setFont(new Font("Dialog", Font.BOLD, 35));
		totalPointsLbl.setBounds(204, 137, 378, 57);
		frmMainGame.getContentPane().add(totalPointsLbl);
	}

}
