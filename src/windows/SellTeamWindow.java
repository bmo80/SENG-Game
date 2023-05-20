package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import athleteInfo.Athlete;
import sengGame.MainGame;
import sengGame.MarketPlace;

public class SellTeamWindow {

	private JFrame frmTeamTrading, mainMenu;
	private JLabel lblAthleteName, lblAthletePos, lblAthleteAtt,
	lblAthleteDef, lblAthleteStam, lblInjured, lblPreviousInjuries;
	private Athlete previousAthlete;
	private Athlete athleteSelected;
	private MarketPlace market;

	/**
	 * Create the application.
	 */
	public SellTeamWindow(MarketPlace givenMarket, JFrame givenWindow) {
		mainMenu = givenWindow;
		market = givenMarket;
		defaultAthlete();
		initialize();
		frmTeamTrading.setVisible(true);
	}
	
	public void closeWindow() {
		BuyPlayerWindow buyPlayerWindow = new BuyPlayerWindow(market, mainMenu);
		frmTeamTrading.dispose();
	}
	
	public void defaultAthlete() {
		if(market.getGameStats().getTeams().getFreeSlots() == 11) {
			athleteSelected = new Athlete();
		}
		else if(market.getGameStats().getTeams().getTeamList().size() == 0) {
			athleteSelected = market.getGameStats().getTeams().getBench().get(0);
		}
		else {
			athleteSelected = market.getGameStats().getTeams().getTeamList().get(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamTrading = new JFrame();
		frmTeamTrading.setTitle("Team trading");
		frmTeamTrading.setBounds(100, 100, 580, 437);
		frmTeamTrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamTrading.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: %S",market.getMoney()));
		lblMoney.setBounds(12, 12, 257, 15);
		frmTeamTrading.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s",market.getWeek()));
		lblWeek.setBounds(12, 28, 95, 15);
		frmTeamTrading.getContentPane().add(lblWeek);
		
		JLabel lblTeam = new JLabel("Active Team");
		lblTeam.setBounds(146, 41, 95, 39);
		frmTeamTrading.getContentPane().add(lblTeam);
		
		lblAthleteName = new JLabel(String.format("Name: %s",
				athleteSelected.getName()));
		lblAthleteName.setBounds(399, 77, 169, 15);
		frmTeamTrading.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel(String.format("Position: %s",
				athleteSelected.getPosition()));
		lblAthletePos.setBounds(399, 101, 169, 15);
		frmTeamTrading.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel(String.format("Attack: %s",
				athleteSelected.getAttack()));
		lblAthleteAtt.setBounds(399, 128, 108, 15);
		frmTeamTrading.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel(String.format("Defence: %s",
				athleteSelected.getDefence()));
		lblAthleteDef.setBounds(399, 152, 108, 15);
		frmTeamTrading.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel(String.format("Stamina: %s",
				athleteSelected.getStamina()));
		lblAthleteStam.setBounds(399, 179, 108, 15);
		frmTeamTrading.getContentPane().add(lblAthleteStam);
		
		lblInjured = new JLabel(String.format((athleteSelected.getIsInjured()?"Injured":"Healthy")));
		lblInjured.setBounds(399, 206, 108, 15);
		frmTeamTrading.getContentPane().add(lblInjured);
		
		lblPreviousInjuries = new JLabel(String.format("Previous Injuries: %s",
				athleteSelected.getPreviousInjuries()));
		lblPreviousInjuries.setBounds(399, 233, 169, 15);
		frmTeamTrading.getContentPane().add(lblPreviousInjuries);
		
		
		
		JButton Athlete1 = new JButton("Athlete 1");
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(0);
			}
		});
		Athlete1.setBounds(23, 77, 160, 39);
		frmTeamTrading.getContentPane().add(Athlete1);
		
		JButton Athlete2 = new JButton("Athlete 2");
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(1);
			}
		});
		Athlete2.setBounds(195, 77, 160, 39);
		frmTeamTrading.getContentPane().add(Athlete2);
		
		JButton Athlete3 = new JButton("Athlete 3");
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(2);
			}
		});
		Athlete3.setBounds(22, 128, 160, 39);
		frmTeamTrading.getContentPane().add(Athlete3);
		
		JButton Athlete4 = new JButton("Athlete 4");
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(3);
			}
		});
		Athlete4.setBounds(195, 128, 160, 39);
		frmTeamTrading.getContentPane().add(Athlete4);
		
		JButton Athlete5 = new JButton("Athlete 5");
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(4);
			}
		});
		Athlete5.setBounds(22, 178, 160, 39);
		frmTeamTrading.getContentPane().add(Athlete5);
		
		JButton Athlete6 = new JButton("Athlete 6");
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTeamAthlete(5);
			}
		});
		Athlete6.setBounds(195, 179, 160, 39);
		frmTeamTrading.getContentPane().add(Athlete6);
		
		
		JLabel lblBench = new JLabel("Bench Team");
		lblBench.setBounds(142, 213, 95, 39);
		frmTeamTrading.getContentPane().add(lblBench);
		
		
		JButton Bench1 = new JButton("Bench 1");
		Bench1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBenchAthlete(0);
			}
		});
		Bench1.setBounds(22, 250, 160, 39);
		frmTeamTrading.getContentPane().add(Bench1);
		
		JButton Bench2 = new JButton("Bench 2");
		Bench2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBenchAthlete(1);
			}
		});
		Bench2.setBounds(195, 250, 160, 39);
		frmTeamTrading.getContentPane().add(Bench2);
		
		JButton Bench3 = new JButton("Bench 3");
		Bench3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBenchAthlete(2);
			}
		});
		Bench3.setBounds(22, 300, 160, 39);
		frmTeamTrading.getContentPane().add(Bench3);
		
		JButton Bench4 = new JButton("Bench 4");
		Bench4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBenchAthlete(3);
			}
		});
		Bench4.setBounds(195, 300, 160, 39);
		frmTeamTrading.getContentPane().add(Bench4);
		
		
		
		JButton btnDone = new JButton("Go Back");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnDone.setBounds(414, 340, 117, 25);
		frmTeamTrading.getContentPane().add(btnDone);
		
		JButton btnSellAthlete = new JButton("Sell");
		btnSellAthlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(athleteSelected.getName().equals("NULL")) {
					//MESSAGE
				}else {
					market.getGameStats().getTeams().removeAthlete(athleteSelected);
					market.getGameStats().changeMoney(athleteSelected.getBuyPrice());
					lblMoney.setText(String.format("Money: %s",market.getGameStats().getMoney()));
//					updateButton(athleteSelected);
//					updateTeamSlots();
					defaultAthlete();
					updateLabels();
				}
			}
		});
		btnSellAthlete.setBounds(414, 288, 117, 25);
		frmTeamTrading.getContentPane().add(btnSellAthlete);
		
		JButton Bench5 = new JButton("Bench 5");
		Bench5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBenchAthlete(3);
			}
		});
		Bench5.setBounds(108, 351, 160, 39);
		frmTeamTrading.getContentPane().add(Bench5);
		
		JLabel lblTeamName = new JLabel(String.format("%s's Team", market.getGameStats().getPlayerName()));
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamName.setBounds(163, 12, 229, 15);
		frmTeamTrading.getContentPane().add(lblTeamName);
		
		
		
	}
	
	private void setTeamAthlete(int athleteIndex) {
		if(athleteIndex < market.getGameStats().getTeams().getTeamList().size()) {
			previousAthlete = athleteSelected;
			athleteSelected = market.getGameStats().getTeams().getTeamList().get(athleteIndex);
		}else {
			athleteSelected = new Athlete();
		}
		updateLabels();
	}
	
	private void setBenchAthlete(int athleteIndex) {
		if(athleteIndex < market.getGameStats().getTeams().getBench().size()) {
			previousAthlete = athleteSelected;
			athleteSelected = market.getGameStats().getTeams().getBench().get(athleteIndex);
		}else {
			athleteSelected = new Athlete();
		}
		updateLabels();
	}
	
	private void updateLabels() {
		lblAthleteName.setText(String.format("Name: %s",
				athleteSelected.getName()));
		lblAthletePos.setText(String.format("Position: %s",
				athleteSelected.getPosition()));
		lblAthleteAtt.setText(String.format("Attack: %s",
				athleteSelected.getAttack()));
		lblAthleteDef.setText(String.format("Defence: %s",
				athleteSelected.getDefence()));
		lblAthleteStam.setText(String.format("Stamina: %s",
				athleteSelected.getStamina()));
		lblInjured.setText(String.format((athleteSelected.getIsInjured()?"Injured":"Healthy")));
		lblPreviousInjuries.setText(String.format("Previous Injures: %s",
				athleteSelected.getPreviousInjuries()));
	}

}
