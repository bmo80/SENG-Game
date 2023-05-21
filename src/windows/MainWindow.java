package windows;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

import athleteInfo.Athlete;
import athleteInfo.TeamManager;
import sengGame.MainGame;
import sengGame.MarketPlace;
import sengGame.Match;
import sengGame.Stadium;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frmMainGame;
	private MainGame game;
	private MarketPlace market;
	private Stadium stadium;
	private Match match;
	JLabel lblRecord;

	/**
	 * Create the application.
	 */
	public MainWindow(MainGame getGame) {
		game = getGame;
		market = new MarketPlace(game);
		stadium = new Stadium(game);
		initialize();
		frmMainGame.setVisible(true);		
	}

	public void closeWindow() {
		frmMainGame.dispose();
	}
	
	public void finishedWindow() {
		game.closeMainScreen(this);
	}
	
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
		
		JLabel MoneyLbl = new JLabel(String.format("Money: $%s", game.getMoney()));
		MoneyLbl.setBounds(12, 8, 426, 15);
		frmMainGame.getContentPane().add(MoneyLbl);
		
		JLabel WeekLbl = new JLabel(String.format("Week: %s", game.getWeek()));
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
				MarketPlaceWindow window = new MarketPlaceWindow(market, frmMainGame);
			}
		});
		btnMarket.setBounds(12, 177, 148, 77);
		frmMainGame.getContentPane().add(btnMarket);
		
		JButton btnStadium = new JButton("Go to Stadium");
		btnStadium.setBackground(Color.cyan);
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainGame.setVisible(false);
				StadiumWindow window = new StadiumWindow(stadium, frmMainGame, game);
			}
		});
		btnStadium.setBounds(12, 288, 148, 77);
		frmMainGame.getContentPane().add(btnStadium);
		
		
		
		JButton btnBye = new JButton("Take bye week");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmMainGame, 
						"This will advance to the next week.\nDo you want to continue?",
						"Bye Warning",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					frmMainGame.dispose();
					String[] choices = game.getTeams().getTeamsString();
					String selection = (String) JOptionPane.showInputDialog(
							frmMainGame,"Who do you want to train?",
							"Weekly training", JOptionPane.PLAIN_MESSAGE,
							null, choices, null);
					//Run special window (over top) showing what happened
					//e.g. week advanced, athletes/Market/stadium reset
					//ALSO inform random events
					ByeWindow byeWindow = new ByeWindow(game,selection);
;				}
			}
		});
		btnBye.setBounds(12, 400, 148, 25);
		frmMainGame.getContentPane().add(btnBye);
		
		JLabel lblTeamName = new JLabel(game.getPlayerName()+" FC");
		lblTeamName.setFont(new Font("Arial", Font.BOLD, 16));
		lblTeamName.setBounds(259, 24, 172, 15);
		frmMainGame.getContentPane().add(lblTeamName);
		
		lblRecord = new JLabel();
		lblRecord.setBounds(494, 25, 110, 15);
		frmMainGame.getContentPane().add(lblRecord);
	}

}
