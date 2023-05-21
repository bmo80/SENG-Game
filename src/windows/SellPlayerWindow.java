package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import athleteInfo.Athlete;
import sengGame.MarketPlace;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class SellPlayerWindow {

	private JFrame frmManageTeam;
	private MarketPlace market;
	private int sold;
	private Athlete athleteSelected;
	JButton Athlete1,Athlete2,Athlete3,Athlete4,Athlete5,Athlete6;
	JButton bench1,bench2,bench3,bench4,bench5;
	JLabel lblName, lblPosition, lblAttack, lblDefense, lblSellPrice;
	private JFrame prevWindow;

	/**
	 * Create the application.
	 */
	public SellPlayerWindow(MarketPlace currentMarket, JFrame givenWindow) {
		prevWindow = givenWindow;
		market = currentMarket;
		initialize();
		frmManageTeam.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageTeam = new JFrame();
		frmManageTeam.setTitle("Manage Team");
		frmManageTeam.setBounds(100, 100, 605, 430);
		frmManageTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageTeam.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel("Money: ");
		lblMoney.setBounds(12, 12, 70, 15);
		frmManageTeam.getContentPane().add(lblMoney);
		
		JLabel displayMoney = new JLabel(String.valueOf(market.getMoney()));
		displayMoney.setBounds(72, 12, 70, 15);
		frmManageTeam.getContentPane().add(displayMoney);
		
		
		JLabel lblWeek = new JLabel("Week:");
		lblWeek.setBounds(12, 28, 70, 15);
		frmManageTeam.getContentPane().add(lblWeek);
		
		JLabel weekNum = new JLabel(String.valueOf(market.getWeek())+"/5");
		weekNum.setBounds(72, 28, 70, 15);
		frmManageTeam.getContentPane().add(weekNum);
		
		JLabel lblActive = new JLabel("Active");
		lblActive.setBounds(174, 54, 70, 14);
		frmManageTeam.getContentPane().add(lblActive);
		
		JLabel lblBench = new JLabel("Bench");
		lblBench.setBounds(174, 210, 46, 14);
		frmManageTeam.getContentPane().add(lblBench);
		
		//Main Team athletes
		Athlete1 = new JButton();
		
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(0);
				updateLabels(athleteSelected);
			}
		});
		Athlete1.setBounds(12, 72, 175, 37);
		frmManageTeam.getContentPane().add(Athlete1);
		
		Athlete2 = new JButton("New button");
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(1);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete2.setBounds(199, 72, 175, 37);
		frmManageTeam.getContentPane().add(Athlete2);
		
		Athlete3 = new JButton("New button");
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(2);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete3.setBounds(12, 120, 175, 37);
		frmManageTeam.getContentPane().add(Athlete3);
		
		Athlete4 = new JButton("New button");
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(3);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete4.setBounds(199, 120, 175, 37);
		frmManageTeam.getContentPane().add(Athlete4);
		
		Athlete5 = new JButton("New button");
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(4);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete5.setBounds(12, 168, 175, 37);
		frmManageTeam.getContentPane().add(Athlete5);
		
		Athlete6 = new JButton("New button");
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getTeamList().get(5);
				updateLabels(athleteSelected);
			}
		});
		
		Athlete6.setBounds(199, 168, 175, 37);
		frmManageTeam.getContentPane().add(Athlete6);
		
		//Bench Athletes
		bench1 = new JButton("New button");
		
		bench1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(0);
				updateLabels(athleteSelected);
			}
		});
		bench1.setBounds(12, 227, 175, 37);
		frmManageTeam.getContentPane().add(bench1);
		
		bench2 = new JButton("New button");
		bench2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(1);
				updateLabels(athleteSelected);
			}
		});
		
		bench2.setBounds(199, 227, 175, 37);
		frmManageTeam.getContentPane().add(bench2);
		
		bench3 = new JButton("New button");
		bench3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(2);
				updateLabels(athleteSelected);
			}
		});
		
		bench3.setBounds(12, 275, 175, 37);
		frmManageTeam.getContentPane().add(bench3);
		
		bench4 = new JButton("New button");
		bench4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(3);
				updateLabels(athleteSelected);
			}
		});
		
		bench4.setBounds(199, 275, 175, 37);
		frmManageTeam.getContentPane().add(bench4);
		
		bench5 = new JButton("New button");
		bench5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				athleteSelected = market.getGameStats().getTeams().getBench().get(4);
				updateLabels(athleteSelected);
			}
		});
		bench5.setBounds(110, 323, 175, 37);
		frmManageTeam.getContentPane().add(bench5);
		
		//Set the Athlete Names to their respective buttons
		setButtons();
		
		JLabel lblStatsTitle = new JLabel("Stats");
		lblStatsTitle.setBounds(471, 72, 46, 14);
		frmManageTeam.getContentPane().add(lblStatsTitle);
		
		lblName = new JLabel("Name: ");
		lblName.setBounds(410, 95, 153, 14);
		frmManageTeam.getContentPane().add(lblName);
		
		lblPosition = new JLabel("Position: ");
		lblPosition.setBounds(410, 120, 153, 14);
		frmManageTeam.getContentPane().add(lblPosition);
		
		lblAttack = new JLabel("Attack: ");
		lblAttack.setBounds(410, 145, 153, 14);
		frmManageTeam.getContentPane().add(lblAttack);
		
		lblDefense = new JLabel("Defense: ");
		lblDefense.setBounds(410, 168, 153, 14);
		frmManageTeam.getContentPane().add(lblDefense);
		
		lblSellPrice = new JLabel("Sell Price: ");
		lblSellPrice.setBounds(410, 193, 153, 14);
		frmManageTeam.getContentPane().add(lblSellPrice);
		
		JButton btnSellPlayer = new JButton("Sell Player");
		btnSellPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frmManageTeam, "Are you sure you want to sell this player?", "Confirm Sale",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					market.getGameStats().changeMoney(athleteSelected.getSellPrice());
					lblMoney.setText(String.format("Money: %s",market.getGameStats().getMoney()));
					market.getGameStats().checkGameEnd(market);
					//Checks if the selected athlete is in Main team or other(bench)
					if(market.getGameStats().getTeams().getTeamList().contains(athleteSelected)) {
						market.getGameStats().getTeams().getTeamList().remove(athleteSelected);
						System.out.println("MAKING IT HERE");
						//checks if there are any players on the bench and moves them up if so.
						if(market.getGameStats().getTeams().getBench().size() > 0) {
							Athlete movingAthlete = market.getGameStats().getTeams().getBench().get(0);
							System.out.println(movingAthlete);
							market.getGameStats().getTeams().getTeamList().add(movingAthlete);
							market.getGameStats().getTeams().getBench().remove(movingAthlete);
						}

//						System.out.println(market.getGameStats().getTeams().getTeamList().get(5));
						setButtons();
					} else {
						market.getGameStats().getTeams().getBench().remove(athleteSelected);
						setButtons();
					}
					setButtons();
				
				}
			}
		});
		btnSellPlayer.setBounds(430, 246, 111, 37);
		frmManageTeam.getContentPane().add(btnSellPlayer);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevWindow.setVisible(true);
				frmManageTeam.dispose();
			}
		});
		btnNewButton.setBounds(474, 357, 89, 23);
		frmManageTeam.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Manage your Team");
		lblNewLabel_2.setBounds(232, 12, 103, 14);
		frmManageTeam.getContentPane().add(lblNewLabel_2);
	}
	
	private void setTeamName(int index, JButton athlete) {
		if(market.getGameStats().getTeams().getTeamList().size() >= index) {
			athlete.setText(market.getGameStats().getTeams().getTeamList().get(index-1).getName());
		} else {
			athlete.setEnabled(false);
			athlete.setText("Empty Slot");
		}
	}
	
	private void setBenchName(int index, JButton athlete) {
		if(market.getGameStats().getTeams().getBench().size() >= index) {
			athlete.setText(market.getGameStats().getTeams().getBench().get(index-1).getName());
		}else {
			athlete.setEnabled(false);
			athlete.setText("Empty Slot");
		}
	}
	
	private void updateLabels(Athlete athlete) {
		lblName.setText(athlete.getName());
		lblPosition.setText(String.format("Position: %s", athlete.getPosition()));
		lblAttack.setText(String.format("Attack: %s", Integer.toString(athlete.getAttack())));
		lblDefense.setText(String.format("Defence: %s", Integer.toString(athlete.getDefence())));
		lblSellPrice.setText(String.format("Sell Price: %s", Integer.toString(athlete.getSellPrice())));
	}
	
	/*
	 * Sets all of the buttons for the team and bench using
	 * support functions setTeamName and setBenchName
	 */
	private void setButtons() {
		ArrayList<JButton> teamList = new ArrayList<JButton>();
		ArrayList<JButton> benchList = new ArrayList<JButton>();
		Collections.addAll(benchList, bench1, bench2, bench3, bench4, bench5);
		Collections.addAll(teamList, Athlete1, Athlete2, Athlete3, Athlete4, Athlete5, Athlete6);
		int index = 1;
		for(JButton button: teamList) {
			setTeamName(index, button);
			index++;
		}
		index = 1;
		for(JButton button: benchList) {
			setBenchName(index, button);
			index++;
		}
	}
}
