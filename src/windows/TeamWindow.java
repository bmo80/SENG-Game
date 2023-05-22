package windows;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sengGame.MainGame;
import javax.swing.SwingConstants;

import purchasables.Athlete;
import purchasables.Item;

public class TeamWindow {

	private JFrame frmTeam;
	private MainGame game;
	private Athlete previousAthlete;
	private Athlete athleteSelected;
	private JLabel lblAthleteName, lblAthletePos, lblAthleteAtt,
	lblAthleteDef, lblAthleteStam, lblInjured, lblPreviousInjuries;
	private JFrame mainMenu;
	JButton Bench1,Bench2,Bench3,Bench4,Bench5;
	JButton Athlete1,Athlete2,Athlete3,Athlete4,Athlete5,Athlete6;
	/**
	 * Create the application.
	 */
	public TeamWindow(MainGame currentGame, JFrame givenWindow) {
		mainMenu = givenWindow;
		game = currentGame;
		defaultAthlete();
		initialize();
		frmTeam.setVisible(true);
	}
	
	public void closeWindow() {
		ClubWindow clubWindow = new ClubWindow(game, mainMenu);
		frmTeam.dispose();
	}
	
	public void defaultAthlete() {
		if(game.getTeams().getFreeSlotsCount() == 11) {
			athleteSelected = new Athlete();
		}
		else if(game.getTeams().getTeamList().size() == 0) {
			athleteSelected = game.getTeams().getBench().get(0);
		}
		else {
			athleteSelected = game.getTeams().getTeamList().get(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeam = new JFrame();
		frmTeam.setTitle("Team");
		frmTeam.setBounds(100, 100, 580, 437);
		frmTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeam.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: $%s",game.getMoney()));
		lblMoney.setBounds(12, 12, 257, 15);
		frmTeam.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s",game.getWeek()));
		lblWeek.setBounds(12, 28, 95, 15);
		frmTeam.getContentPane().add(lblWeek);
		
		JLabel lblTeam = new JLabel("Active Team");
		lblTeam.setBounds(146, 41, 95, 39);
		frmTeam.getContentPane().add(lblTeam);
		
		lblAthleteName = new JLabel(String.format("Name: %s",
				athleteSelected.getName()));
		lblAthleteName.setBounds(399, 77, 169, 15);
		frmTeam.getContentPane().add(lblAthleteName);
		
		
		lblAthletePos = new JLabel(String.format("Position: %s",
				athleteSelected.getPosition()));
		lblAthletePos.setBounds(399, 101, 169, 15);
		frmTeam.getContentPane().add(lblAthletePos);
		
		lblAthleteAtt = new JLabel(String.format("Attack: %s",
				athleteSelected.getAttack()));
		lblAthleteAtt.setBounds(399, 128, 108, 15);
		frmTeam.getContentPane().add(lblAthleteAtt);
		
		lblAthleteDef = new JLabel(String.format("Defence: %s",
				athleteSelected.getDefence()));
		lblAthleteDef.setBounds(399, 152, 108, 15);
		frmTeam.getContentPane().add(lblAthleteDef);
		
		lblAthleteStam = new JLabel(String.format("Stamina: %s",
				athleteSelected.getStamina()));
		lblAthleteStam.setBounds(399, 179, 108, 15);
		frmTeam.getContentPane().add(lblAthleteStam);
		
		lblInjured = new JLabel(String.format((athleteSelected.getIsInjured()?"Injured":"Healthy")));
		lblInjured.setBounds(399, 206, 108, 15);
		frmTeam.getContentPane().add(lblInjured);
		
		lblPreviousInjuries = new JLabel(String.format("Previous Injuries: %s",
				athleteSelected.getPreviousInjuries()));
		lblPreviousInjuries.setBounds(399, 233, 169, 15);
		frmTeam.getContentPane().add(lblPreviousInjuries);
		
		
		
		 Athlete1 = new JButton("Athlete 1");
		Athlete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getTeamList().get(0);
				updateLabels(athleteSelected);				
			}
		});
		Athlete1.setBounds(23, 77, 160, 39);
		frmTeam.getContentPane().add(Athlete1);
		
		athleteSelected = game.getTeams().getTeamList().get(0);
		
		 Athlete2 = new JButton("Athlete 2");
		Athlete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getTeamList().get(1);
				updateLabels(athleteSelected);	
			}
		});
		Athlete2.setBounds(195, 77, 160, 39);
		frmTeam.getContentPane().add(Athlete2);
		
		 Athlete3 = new JButton("Athlete 3");
		Athlete3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getTeamList().get(2);
				updateLabels(athleteSelected);	
			}
		});
		Athlete3.setBounds(22, 128, 160, 39);
		frmTeam.getContentPane().add(Athlete3);
		
		 Athlete4 = new JButton("Athlete 4");
		Athlete4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getTeamList().get(3);
				updateLabels(athleteSelected);	
			}
		});
		Athlete4.setBounds(195, 128, 160, 39);
		frmTeam.getContentPane().add(Athlete4);
		
		 Athlete5 = new JButton("Athlete 5");
		Athlete5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getTeamList().get(4);
				updateLabels(athleteSelected);	
			}
		});
		Athlete5.setBounds(22, 178, 160, 39);
		frmTeam.getContentPane().add(Athlete5);
		
		 Athlete6 = new JButton("Athlete 6");
		Athlete6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getTeamList().get(5);
				updateLabels(athleteSelected);	
			}
		});
		Athlete6.setBounds(195, 179, 160, 39);
		frmTeam.getContentPane().add(Athlete6);
		
		
		JLabel lblBench = new JLabel("Bench Team");
		lblBench.setBounds(142, 213, 95, 39);
		frmTeam.getContentPane().add(lblBench);
		
		
		 Bench1 = new JButton("Bench 1");
		Bench1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getBench().get(0);
				updateLabels(athleteSelected);
			}
		});
		Bench1.setBounds(22, 250, 160, 39);
		frmTeam.getContentPane().add(Bench1);
		
		 Bench2 = new JButton("Bench 2");
		Bench2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getBench().get(1);
				updateLabels(athleteSelected);
			}
		});
		Bench2.setBounds(195, 250, 160, 39);
		frmTeam.getContentPane().add(Bench2);
		
		 Bench3 = new JButton("Bench 3");
		Bench3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getBench().get(2);
				updateLabels(athleteSelected);
			}
		});
		Bench3.setBounds(22, 300, 160, 39);
		frmTeam.getContentPane().add(Bench3);
		
		 Bench4 = new JButton("Bench 4");
		Bench4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getBench().get(3);
				updateLabels(athleteSelected);
			}
		});
		Bench4.setBounds(195, 300, 160, 39);
		frmTeam.getContentPane().add(Bench4);
		
		
		
		JButton btnDone = new JButton("Go Back");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnDone.setBounds(414, 340, 117, 25);
		frmTeam.getContentPane().add(btnDone);
		


		
		Bench5 = new JButton("Bench 5");
		Bench5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousAthlete = athleteSelected;
				athleteSelected = game.getTeams().getBench().get(4);
				updateLabels(athleteSelected);
			}
		});
		Bench5.setBounds(108, 351, 160, 39);
		frmTeam.getContentPane().add(Bench5);
		
		setButtons();
		
		JButton btnSwap = new JButton("Swap");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(previousAthlete.getName().equals("NULL") || athleteSelected.getName().equals("NULL")) {
					//MESSAGE
				}else {
					game.getTeams().swap(previousAthlete, athleteSelected);
					
				}
				setButtons();
			}
		});
		btnSwap.setBounds(414, 288, 117, 25);
		frmTeam.getContentPane().add(btnSwap);
		
		JLabel lblTeamName = new JLabel(String.format("%s's Team", game.getPlayerName()));
		lblTeamName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamName.setBounds(163, 12, 229, 15);
		frmTeam.getContentPane().add(lblTeamName);
		
		
		
	}
	
	
	private void updateLabels(Athlete athlete) {
		lblAthleteName.setText(athlete.getName());
		lblAthletePos.setText(String.format("Position: %s", athlete.getPosition()));
		lblAthleteAtt.setText(String.format("Attack: %s", Integer.toString(athlete.getAttack())));
		lblAthleteDef.setText(String.format("Defence: %s", Integer.toString(athlete.getDefence())));
		lblAthleteStam.setText(String.format("Stamina: %s",
				athleteSelected.getStamina()));
		lblInjured.setText(String.format((athleteSelected.getIsInjured()?"Injured":"Healthy")));
		lblPreviousInjuries.setText(String.format("Previous Injures: %s",
				athleteSelected.getPreviousInjuries()));
	}
	
	private void setButtons() {
		ArrayList<JButton> teamList = new ArrayList<JButton>();
		ArrayList<JButton> benchList = new ArrayList<JButton>();
		Collections.addAll(benchList, Bench1, Bench2, Bench3, Bench4, Bench5);
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
	
	private void setTeamName(int index, JButton athlete) {
		if(game.getTeams().getTeamList().size() >= index) {
			athlete.setText(game.getTeams().getTeamList().get(index-1).getName());
		} else {
			athlete.setEnabled(false);
			athlete.setText("Empty Slot");
		}
	}
	
	private void setBenchName(int index, JButton athlete) {
		if(game.getTeams().getBench().size() >= index) {
			athlete.setText(game.getTeams().getBench().get(index-1).getName());
		}else {
			athlete.setEnabled(false);
			athlete.setText("Empty Slot");
		}
	}
	
	
}
