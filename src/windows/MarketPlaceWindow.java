package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import athleteInfo.TeamManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sengGame.MainGame;
import sengGame.MarketPlace;



public class MarketPlaceWindow{

	private JFrame frmMarketplace;
	private MarketPlace market;
	private MainGame gameStats;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MarketPlaceWindow window = new MarketPlaceWindow();
//
//					window.frmMarketplace.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */



	public MarketPlaceWindow(MarketPlace curMarket, MainGame game) {
		gameStats = game;
		market = curMarket;
		initialize();
		frmMarketplace.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarketplace = new JFrame();
		frmMarketplace.setTitle("MarketPlace");
		frmMarketplace.setBounds(100, 100, 526, 299);
		frmMarketplace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketplace.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 12, 70, 15);
		frmMarketplace.getContentPane().add(lblMoney);
		
		JLabel displayMoney = new JLabel(String.valueOf(market.getMoney()));
		displayMoney.setBounds(72, 12, 70, 15);
		frmMarketplace.getContentPane().add(displayMoney);
		
		
		JLabel lblWeek = new JLabel("Week:");
		lblWeek.setBounds(12, 28, 70, 15);
		frmMarketplace.getContentPane().add(lblWeek);
		
		JLabel weekNum = new JLabel(String.valueOf(market.getWeek())+"/5");

		weekNum.setBounds(72, 28, 70, 15);
		frmMarketplace.getContentPane().add(weekNum);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Marketplace!");
		lblWelcomeToThe.setBounds(154, 28, 232, 15);
		frmMarketplace.getContentPane().add(lblWelcomeToThe);
		
		JButton btnBuysellPlayers = new JButton("Buy and Sell Players");
		btnBuysellPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMarketplace.dispose();
				BuyPlayerWindow window = new BuyPlayerWindow(market, gameStats);

			}
		});
		btnBuysellPlayers.setBounds(35, 94, 195, 70);
		frmMarketplace.getContentPane().add(btnBuysellPlayers);
		
		JButton btnBuyAndSell = new JButton("Buy and Sell Items");
		btnBuyAndSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMarketplace.dispose();
				launchBuyItemWindow();
			}
		});
		btnBuyAndSell.setBounds(265, 94, 195, 70);
		frmMarketplace.getContentPane().add(btnBuyAndSell);
		
		JLabel lblPlayersAndItems = new JLabel("Players and items reset weekly!");
		lblPlayersAndItems.setBounds(12, 205, 352, 15);
		frmMarketplace.getContentPane().add(lblPlayersAndItems);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMarketplace.dispose();
				MainWindow window = new MainWindow(gameStats);
			}
		});
		btnMainMenu.setBounds(387, 232, 117, 25);
		frmMarketplace.getContentPane().add(btnMainMenu);
	}
	
	private void launchBuyItemWindow() {
		BuyItemWindow window = new BuyItemWindow(market, gameStats);
	}
}

