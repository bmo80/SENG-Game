package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import sengGame.MarketPlace;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyItemWindow {

	private JFrame frame;
	private MarketPlace market;
	private JLabel lblPrice, lblName, lblType, lblEffect;
	/**
	 * Create the application.
	 */
	public BuyItemWindow(MarketPlace currentMarket) {
		market = currentMarket;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMoney = new JLabel(String.format("Money: %s", Integer.toString(market.getGameStats().getMoney())));
		lblMoney.setBounds(12, 12, 128, 15);
		frame.getContentPane().add(lblMoney);


		JLabel lblWeek = new JLabel(String.format("Week: %s", Integer.toString(market.getGameStats().getWeek())));
		lblWeek.setBounds(12, 28, 128, 15);
		frame.getContentPane().add(lblWeek);

		JLabel lblBuyItems = new JLabel("Item Store");
		lblBuyItems.setBounds(164, 28, 88, 15);
		frame.getContentPane().add(lblBuyItems);

		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setBounds(343, 7, 139, 25);
		frame.getContentPane().add(btnViewInventory);


		lblName = new JLabel("Name:");
		lblName.setBounds(295, 100, 133, 15);
		frame.getContentPane().add(lblName);

		lblType = new JLabel("Type:");
		lblType.setBounds(295, 125, 199, 15);
		frame.getContentPane().add(lblType);

		lblEffect = new JLabel("Effect:");
		lblEffect.setBounds(295, 150, 133, 15);
		frame.getContentPane().add(lblEffect);

		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(295, 175, 133, 15);
		frame.getContentPane().add(lblPrice);

		JButton btnItem1 = new JButton(market.getItemsForSale().get(0).getName());
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(1);
			}
		});
		btnItem1.setBounds(12, 97, 117, 43);
		frame.getContentPane().add(btnItem1);

		JButton btnItem2 = new JButton(market.getItemsForSale().get(1).getName());
		btnItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(2);
			}
		});
		btnItem2.setBounds(148, 97, 117, 43);
		frame.getContentPane().add(btnItem2);

		JButton btnItem3 = new JButton(market.getItemsForSale().get(2).getName());
		btnItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(3);
			}
		});
		btnItem3.setBounds(12, 161, 117, 43);
		frame.getContentPane().add(btnItem3);

		JButton btnItem4 = new JButton(market.getItemsForSale().get(3).getName());
		btnItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateLabels(4);
			}
		});
		btnItem4.setBounds(148, 161, 117, 43);
		frame.getContentPane().add(btnItem4);

		JLabel lblinventorySlots = new JLabel(String.format("Inventory Slots "
				+ "Available: %s/5", 5-market.getGameStats().getInventory().size()));
		lblinventorySlots.setBounds(12, 251, 207, 15);
		frame.getContentPane().add(lblinventorySlots);



		JLabel lblItemInformation = new JLabel("Item Information");
		lblItemInformation.setBounds(342, 70, 123, 15);
		frame.getContentPane().add(lblItemInformation);


		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MarketPlaceWindow window = new MarketPlaceWindow(market);
			}
		});
		btnDone.setBounds(365, 275, 117, 25);
		frame.getContentPane().add(btnDone);

		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(365, 231, 117, 25);
		frame.getContentPane().add(btnPurchase);

	}

	private void updateLabels(int index) {
		lblName.setText(String.format("Name: %s", market.getItemsForSale().get(index-1).getName()));
		lblType.setText(String.format("Type: %s", market.getItemsForSale().get(index-1).getType()));
		lblEffect.setText(String.format("Effect: %s", Integer.toString(market.getItemsForSale().get(index-1).getEffect())));
		lblPrice.setText(String.format("Price: %s", Integer.toString(market.getItemsForSale().get(index-1).getBuyPrice())));
	}
}