package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import purchasables.TeamManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sengGame.MainGame;
import sengGame.MarketPlace;



public class MarketPlaceWindow{

	private JFrame frmMarketplace;
	private MarketPlace market;
	private JFrame mainMenu;

	public MarketPlaceWindow(MarketPlace currentMarket, JFrame window) {
		mainMenu = window;
		market = currentMarket;
		initialize();
		frmMarketplace.setVisible(true);
	}
	
	public void closeWindow() {
		mainMenu.setVisible(true);
		frmMarketplace.dispose();
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
		
		JLabel lblMoney = new JLabel(String.format("Money: %s",market.getGameStats().getMoney()));
		lblMoney.setBounds(12, 12, 232, 15);
		frmMarketplace.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s/%s"
				,market.getGameStats().getWeek(), market.getGameStats().getDuration()));
		lblWeek.setBounds(12, 28, 203, 15);
		frmMarketplace.getContentPane().add(lblWeek);
		
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Marketplace!");
		lblWelcomeToThe.setBounds(154, 28, 232, 15);
		frmMarketplace.getContentPane().add(lblWelcomeToThe);
		
		JButton btnBuysellPlayers = new JButton("Buy and Sell Players");
		btnBuysellPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyPlayerWindow window = new BuyPlayerWindow(market, frmMarketplace);
				frmMarketplace.setVisible(false);
			}
		});
		btnBuysellPlayers.setBounds(35, 94, 195, 70);
		frmMarketplace.getContentPane().add(btnBuysellPlayers);
		
		JButton btnBuyAndSell = new JButton("Buy and Sell Items");
		btnBuyAndSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyItemWindow window = new BuyItemWindow(market, frmMarketplace);
				frmMarketplace.setVisible(false);
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
				closeWindow();
			}
		});
		btnMainMenu.setBounds(387, 232, 117, 25);
		frmMarketplace.getContentPane().add(btnMainMenu);
	}
	
}
