package windows;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mainMenus.MarketPlace;

import javax.swing.JButton;

import purchasables.Athlete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * BuyPlayerWindow displays all the available players for purchase from the market
 * and deals with the logic of buying and storing the players correctly.
 * @author Blair Brydon
 * @author Ben Moore
 */
public class BuyPlayerWindow {

	/**
	 * Variable to store the current frame
	 */
	private JFrame frmPlayerTrading;
	/**
	 * Variable to store the current MarketPlace
	 */
	private MarketPlace market;
	/**
	 * Creating variables for the display labels in the window
	 */
	JLabel lblAthleteName,lblAthletePos, lblAthleteAtt, lblAthleteDef, 
	lblAthleteStam, lblPrice,lblTeamSlotsAvailable,lblBenchSlotsAvailable, lblMoney;
	/**
	 * Creating variables for the Buttons that will be displayed in the window
	 */
	JButton btnPurchase, Athlete1, Athlete2, Athlete3, Athlete4, Athlete5, Athlete6;
	/**
	 * Variable to store the index of the current athlete being selected
	 */
	private int athleteSelected;
	/**
	 * Variable to store the previous MarketPlace window
	 */
	private JFrame marketWindow;
	
	/**
	 * Initialize variable to store previous obj instance
	 */
	MarketPlaceWindow prevObj;
	/**
	 * Variable to store the current obj instance
	 */
	private BuyPlayerWindow curObj;
	/**
	 * Variable to store the state of nickname button
	 */
	private JButton btnSetNickname;
	/**
	 * Variable to store the state of nickname input box
	 */
	private JTextField nicknameBox;
	
	/**
	 * Constructor for the BuyPlayer window.
	 * @param curmarket the current marketplace
	 * @param givenWindow current marketplace window
	 * @param prevObject instance of the previous frames object
	 */
	public BuyPlayerWindow(MarketPlace curmarket,
			JFrame givenWindow, MarketPlaceWindow prevObject) {
		marketWindow = givenWindow;
		market = curmarket;
		prevObj = prevObject;
		curObj = this;
		athleteSelected = 1;
		initialize();
		playerStatDisplay(1);
		frmPlayerTrading.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerTrading = new JFrame();
		frmPlayerTrading.setTitle("Player Trading");
		frmPlayerTrading.setBounds(100, 100, 580, 437);

		frmPlayerTrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerTrading.getContentPane().setLayout(null);
		
		lblMoney = new JLabel(String.format("Money: $%s",
				market.getGameStats().getMoney()));
		lblMoney.setBounds(12, 12, 194, 15);
		frmPlayerTrading.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s/%s",
				market.getGameStats().getWeek(),
				market.getGameStats().getDuration()));
		lblWeek.setBounds(12, 28, 172, 15);
		frmPlayerTrading.getContentPane().add(lblWeek);
		
		JButton btnViewMyTeam = new JButton("View my Team");
		btnViewMyTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPlayerTrading.setVisible(false);
				SellPlayerWindow window = new SellPlayerWindow(
						market, frmPlayerTrading, curObj);
			}
		});
		btnViewMyTeam.setBounds(369, 7, 134, 25);
		frmPlayerTrading.getContentPane().add(btnViewMyTeam);
		
		JLabel lblPlayerTrading = new JLabel("Player Trading");
		lblPlayerTrading.setBounds(196, 28, 122, 39);
		frmPlayerTrading.getContentPane().add(lblPlayerTrading);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(375, 140, 70, 15);
		frmPlayerTrading.getContentPane().add(lblPosition);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setBounds(375, 165, 70, 15);
		frmPlayerTrading.getContentPane().add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setBounds(375, 190, 70, 15);
		frmPlayerTrading.getContentPane().add(lblDefense);
		
		JLabel lblStamina = new JLabel("Stamina:");
		lblStamina.setBounds(375, 215, 70, 15);
		frmPlayerTrading.getContentPane().add(lblStamina);
		
		lblAthleteName = new JLabel();
		lblAthleteName.setBounds(450, 115, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel();
		lblAthletePos.setBounds(450, 140, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel();
		lblAthleteAtt.setBounds(450, 165, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel();
		lblAthleteDef.setBounds(450, 190, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel();
		lblAthleteStam.setBounds(450, 215, 108, 15);
		frmPlayerTrading.getContentPane().add(lblAthleteStam);
		
		lblPrice = new JLabel("Price: ");
		lblPrice.setBounds(375, 240, 160, 15);
		frmPlayerTrading.getContentPane().add(lblPrice);
		
		
		JLabel lblPlayerStats = new JLabel("Player Stats");
		lblPlayerStats.setBounds(385, 86, 95, 15);
		frmPlayerTrading.getContentPane().add(lblPlayerStats);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(375, 115, 70, 15);
		frmPlayerTrading.getContentPane().add(lblName);
		
		setAthleteButtons();

		lblTeamSlotsAvailable = new JLabel();
		lblTeamSlotsAvailable.setBounds(12, 313, 227, 15);
		frmPlayerTrading.getContentPane().add(lblTeamSlotsAvailable);
		
		lblBenchSlotsAvailable = new JLabel();
		lblBenchSlotsAvailable.setBounds(12, 337, 227, 15);
		frmPlayerTrading.getContentPane().add(lblBenchSlotsAvailable);
		updateTeamSlots();
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marketWindow.setVisible(true);
				prevObj.lblMoney.setText(String.format(
						"Money: $%s",market.getGameStats().getMoney()));
				frmPlayerTrading.dispose();
			}
		});
		btnDone.setBounds(369, 372, 117, 25);
		frmPlayerTrading.getContentPane().add(btnDone);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(market.getPlayersForSale().get(
						athleteSelected-1).getName().equals("Purchased")) {
					JOptionPane.showConfirmDialog(frmPlayerTrading,
							"Please select a new player to buy",
							"Player not selected",
							JOptionPane.DEFAULT_OPTION);
				}
				else if(market.getGameStats().getTeams().checkIllegalName(
						market.getPlayersForSale().get(
								athleteSelected-1).getName())) {
					JOptionPane.showConfirmDialog(frmPlayerTrading,
							"Please change Athletes name",
							"NAME CLASH",
							JOptionPane.DEFAULT_OPTION);
				}
				else if(market.getGameStats().getMoney() - 
						market.getPlayersForSale().get(
								athleteSelected-1).getBuyPrice() < 0) {
					JOptionPane.showConfirmDialog(frmPlayerTrading,
							"You cant afford this athlete","TOO EXPENSIVE",
							JOptionPane.DEFAULT_OPTION);
				}
				else if(market.getGameStats().getTeams().getFreeSlotsCount() == 0) {
					JOptionPane.showConfirmDialog(frmPlayerTrading,
							"You have no space for more Athletes",
							"NO SPACES",
							JOptionPane.DEFAULT_OPTION);
				}
				else {
					int choice = JOptionPane.showConfirmDialog(frmPlayerTrading, 
							"Do you want to add Athlete straight to active team?"
							+ " (By Default Athlete goes to first empty position)",
							"Bye Warning",JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						market.getGameStats().getTeams().teamAdd(
								market.getPlayersForSale().get(athleteSelected - 1));
					}
					else {
						market.getGameStats().getTeams().addAthlete(
								market.getPlayersForSale().get(athleteSelected - 1));
					}
					market.getGameStats().changeMoney(
							-market.getPlayersForSale().get(
									athleteSelected - 1).getBuyPrice());
					lblMoney.setText(String.format("Money: $%s",
							market.getGameStats().getMoney()));
					updateButton(athleteSelected);
					updateTeamSlots();
					Athlete athlete = new Athlete("Purchased", 1, 1, "A");
					market.getPlayersForSale().set(athleteSelected - 1, athlete);
				}
			}
		});
		btnPurchase.setBounds(369, 332, 134, 25);
		frmPlayerTrading.getContentPane().add(btnPurchase);	
		
		btnSetNickname = new JButton("Set Nickname");
		btnSetNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nicknameBox.getText().equals("Purchased") ||
						market.getGameStats().getTeams().checkIllegalName(
								nicknameBox.getText())) {
					JOptionPane.showConfirmDialog(frmPlayerTrading,
							"That name is taken",
							"INVALID NAME",
							JOptionPane.DEFAULT_OPTION);
				}
				else {
					market.getPlayersForSale().get(
							athleteSelected-1).changeName(nicknameBox.getText());
					playerStatDisplay(athleteSelected);
				}
			}
		});
		btnSetNickname.setBounds(369, 295, 134, 25);
		frmPlayerTrading.getContentPane().add(btnSetNickname);
		
		nicknameBox = new JTextField();
		nicknameBox.setBounds(369, 267, 134, 19);
		frmPlayerTrading.getContentPane().add(nicknameBox);
		nicknameBox.setColumns(10);
	}
	
	/**
	 * Method to update the labels to display the currently selected athletes
	 * stats
	 * @param number index of the athlete selected
	 */
	private void playerStatDisplay(int number) {
		lblAthleteName.setText(market.getPlayersForSale().get(
				number-1).getName());
		if(market.getPlayersForSale().get(number-1).getPosition() == "A") {
			lblAthletePos.setText("Attacker");
		} else {
			lblAthletePos.setText("Defence");
		}
		lblAthleteAtt.setText(Integer.toString(
				market.getPlayersForSale().get(number-1).getAttack()));
		lblAthleteDef.setText(Integer.toString(
				market.getPlayersForSale().get(number-1).getDefence()));
		lblAthleteStam.setText(Integer.toString(
				market.getPlayersForSale().get(number-1).getStamina()));
		lblPrice.setText(String.format("Price: %s",
				market.getPlayersForSale().get(number-1).getBuyPrice()));
		nicknameBox.setText(
				market.getPlayersForSale().get(athleteSelected-1).getName());
	}
	
	/**
	 * Method to update the button selected to purchased when 
	 * appropriate
	 * @param index the index of the athlete purchased
	 */
	private void updateButton(int index) {
		switch (index) {
			case 1:
				Athlete1.setText("Purchased");
				Athlete1.setEnabled(false);
				break;
			case 2:
				Athlete2.setText("Purchased");
				Athlete2.setEnabled(false);
				break;
			case 3:
				Athlete3.setText("Purchased");
				Athlete3.setEnabled(false);
				break;
			case 4:
				Athlete4.setText("Purchased");
				Athlete4.setEnabled(false);
				break;
			case 5:
				Athlete5.setText("Purchased");
				Athlete5.setEnabled(false);
				break;
		}
	}
	
	/**
	 * Set the buttons to display the athlete at the appropriate index
	 * using a helper function setButtonName()
	 */
	private void setAthleteButtons() {
		
		setButtonName(1);
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAthleteSelected(1);
				playerStatDisplay(1);
			}
		});
		Athlete1.setBounds(22, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete1);
		
		setButtonName(2);
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAthleteSelected(2);
				playerStatDisplay(2);
			}
		});
		Athlete2.setBounds(195, 106, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete2);
		
		setButtonName(3);
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAthleteSelected(3);
				playerStatDisplay(3);
			}
		});
		Athlete3.setBounds(22, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete3);
		
		setButtonName(4);
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAthleteSelected(4);
				playerStatDisplay(4);
			}
		});
		Athlete4.setBounds(195, 169, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete4);
		
		setButtonName(5);
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setAthleteSelected(5);
				playerStatDisplay(5);
			}
		});
		Athlete5.setBounds(107, 232, 160, 39);
		frmPlayerTrading.getContentPane().add(Athlete5);

	}
	
	/**
	 * The helper function that creates the button objects for the 
	 * respective athletes and sets their names correctly.
	 * @param index index of the athlete having their button created
	 */
	private void setButtonName(int index) {
		
		switch (index) {
			case 1:
				Athlete1 = new JButton();
				if (market.getPlayersForSale().get(index-1).getName().equals(
						"Purchased")) {
					Athlete1.setText("Purchased");
					Athlete1.setEnabled(false);
				}
				else {
					Athlete1.setText(
							market.getPlayersForSale().get(index-1).getName());
				}
			case 2:
				Athlete2 = new JButton();
				if (market.getPlayersForSale().get(index-1).getName().equals(
						"Purchased")) {
					Athlete2.setText("Purchased");
					Athlete2.setEnabled(false);
				}
				else {
					Athlete2.setText(
							market.getPlayersForSale().get(index-1).getName());
				}
			case 3:
				Athlete3 = new JButton();
				if (market.getPlayersForSale().get(index-1).getName().equals(
						"Purchased")) {
					Athlete3.setText("Purchased");
					Athlete3.setEnabled(false);
				}
				else {
					Athlete3.setText(
							market.getPlayersForSale().get(index-1).getName());
				}
			case 4:
				Athlete4 = new JButton();
				if (market.getPlayersForSale().get(index-1).getName().equals(
						"Purchased")) {
					Athlete4.setText("Purchased");
					Athlete4.setEnabled(false);
				}
				else {
					Athlete4.setText(
							market.getPlayersForSale().get(index-1).getName());
				}
			case 5:
				Athlete5 = new JButton();
				if (market.getPlayersForSale().get(index-1).getName().equals(
						"Purchased")) {
					Athlete5.setText("Purchased");
					Athlete5.setEnabled(false);
				}
				else {
					Athlete5.setText(
							market.getPlayersForSale().get(index-1).getName());
				}
		}
	}
	
	/**
	 * Function to update the Team slots left when a new athlete has been purchased
	 */
	private void updateTeamSlots() {
			lblBenchSlotsAvailable.setText(String.format(
					"Bench Slots available: %s/5",
					5 - market.getGameStats().getTeams().getBench().size()));
			lblTeamSlotsAvailable.setText(String.format(
					"Team Slots Available: %s/6",
					6- market.getGameStats().getTeams().getTeamList().size()));
	}
	
	/**
	 * set the index of the current athlete button selected
	 * @param num index of athlete currently selected
	 */
	private void setAthleteSelected(int num) {
		athleteSelected = num;
	}
}
