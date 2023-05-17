package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import athleteInfo.Athlete;
import athleteInfo.TeamManager;
import sengGame.Club;
import sengGame.MainGame;
import sengGame.MarketPlace;
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

	/**
	 * Create the application.
	 */
	public MainWindow(MainGame getGame) {
		game = getGame;
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
		frmMainGame.setTitle("Main Game");
		frmMainGame.setBounds(100, 100, 450, 300);
		frmMainGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainGame.getContentPane().setLayout(null);
		
		JLabel MoneyLbl = new JLabel(String.format("Money: $%s", game.getMoney()));
		MoneyLbl.setBounds(12, 8, 426, 15);
		frmMainGame.getContentPane().add(MoneyLbl);
		
		JLabel WeekLbl = new JLabel(String.format("Week: %s", game.getWeek()));
		WeekLbl.setBounds(12, 25, 91, 15);
		frmMainGame.getContentPane().add(WeekLbl);
		
		
		
		JButton btnClub = new JButton("Club");
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMainGame.dispose();
				ClubWindow club = new ClubWindow(game);
			}
		});
		btnClub.setBounds(12, 52, 117, 77);
		frmMainGame.getContentPane().add(btnClub);
		
		
		
		JButton btnMarket = new JButton("Market");
		btnMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarketPlace market = new MarketPlace(game);
			}
		});
		btnMarket.setBounds(162, 52, 117, 77);
		frmMainGame.getContentPane().add(btnMarket);
		
		JButton btnStadium = new JButton("Stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stadium stadium = new Stadium(game);
			}
		});
		btnStadium.setBounds(305, 52, 117, 77);
		frmMainGame.getContentPane().add(btnStadium);
		
		
		
		JButton btnBye = new JButton("Take bye week");
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmMainGame, 
						"This will advance to the next week.\nDo you want to continue?",
						"Bye Warning",JOptionPane.YES_NO_OPTION);
				if(choice == JOptionPane.YES_OPTION) {
					String[] choices = game.getTeamsString();
					String selection = (String) JOptionPane.showInputDialog(
							frmMainGame,"Who do you want to train?",
							"Weekly training", JOptionPane.PLAIN_MESSAGE,
							null, choices, null);
					//Run special window (over top) showing what happened
					//e.g. week advanced, athletes/Market/stadium reset
					//ALSO inform random events
					frmMainGame.dispose();
					ByeWindow byeWindow = new ByeWindow(game,selection);
;				}
			}
		});
		btnBye.setBounds(147, 196, 148, 25);
		frmMainGame.getContentPane().add(btnBye);
	}
}
