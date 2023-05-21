package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;

import sengGame.MainGame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupWindow {

	private JFrame frmSetup;
//	private MainGame game;
	private JTextField txtName;
	private int difficulty;


	/**
	 * Create the application.
	 */
	public SetupWindow() {
//		game = getGame;
		initialize();
		frmSetup.setVisible(true);		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setTitle("Setup");
		frmSetup.setBounds(100, 100, 450, 300);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(186, 48, 228, 19);
		frmSetup.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(33, 50, 70, 15);
		frmSetup.getContentPane().add(lblName);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(33, 99, 70, 15);
		frmSetup.getContentPane().add(lblDifficulty);
		
		JLabel lblSeasonDuration = new JLabel("Season Duration:");
		lblSeasonDuration.setBounds(33, 147, 131, 15);
		frmSetup.getContentPane().add(lblSeasonDuration);
		
		JSlider durationSlider = new JSlider();
		durationSlider.setMajorTickSpacing(5);
		durationSlider.setMaximum(15);
		durationSlider.setMinorTickSpacing(1);
		durationSlider.setMinimum(5);
		durationSlider.setBounds(186, 146, 228, 16);
		frmSetup.getContentPane().add(durationSlider);
		
		JLabel lnlMinWeeks = new JLabel("5");
		lnlMinWeeks.setBounds(186, 159, 32, 23);
		frmSetup.getContentPane().add(lnlMinWeeks);
		
		JLabel lblMaxWeeks = new JLabel("15");
		lblMaxWeeks.setBounds(390, 163, 24, 15);
		frmSetup.getContentPane().add(lblMaxWeeks);
		
		JSlider difficultySlider = new JSlider();
		difficultySlider.setMaximum(2);
		difficultySlider.setMinorTickSpacing(1);
		difficultySlider.setBounds(186, 99, 228, 16);
		frmSetup.getContentPane().add(difficultySlider);
		
		JLabel lblMaxDifficulty = new JLabel("2");
		lblMaxDifficulty.setBounds(402, 115, 24, 15);
		frmSetup.getContentPane().add(lblMaxDifficulty);
		
		JLabel lnlMinDifficulty = new JLabel("0");
		lnlMinDifficulty.setBounds(186, 111, 32, 23);
		frmSetup.getContentPane().add(lnlMinDifficulty);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().length() > 15 || txtName.getText().length() < 3) {
					JOptionPane.showMessageDialog(frmSetup, String.format("Your name must be "
							+ "between 5 and 15 characters\n%s is %s characters"
							+ " long",txtName.getText(), txtName.getText().length()));
				}else {
					SetupBuyPlayerWindow nextSetupWindow = new SetupBuyPlayerWindow(
							txtName.getText(), 
							durationSlider.getValue(), difficultySlider.getValue());
					frmSetup.setVisible(false);
				}
			}
		});
		btnConfirm.setBounds(161, 205, 117, 25);
		frmSetup.getContentPane().add(btnConfirm);
		
		
	}
}
