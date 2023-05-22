package windows;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * SetupWindow asks the player for the Team name,
 * difficulty and duration.
 *@author Blair Brydon
 *@author Ben Moore
 *
 */
public class SetupWindow {
	/**
	 * Variable to store the current frame
	 */
	private JFrame frmSetup;
	/**
	 * Varaible to store the players Team name
	 */
	private JTextField txtName;


	/**
	 * Constructor for the setup window, initializes the frame
	 */
	public SetupWindow() {
		initialize();
		frmSetup.setVisible(true);		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setTitle("Setup");
		frmSetup.setBounds(100, 100, 546, 411);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		
		txtName = new JTextField();
		txtName.setBounds(186, 91, 228, 19);
		frmSetup.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Enter Team name:");
		lblName.setBounds(33, 93, 135, 15);
		frmSetup.getContentPane().add(lblName);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(45, 161, 70, 15);
		frmSetup.getContentPane().add(lblDifficulty);
		
		JLabel lblSeasonDuration = new JLabel("Season Duration:");
		lblSeasonDuration.setBounds(37, 256, 131, 15);
		frmSetup.getContentPane().add(lblSeasonDuration);
		
		JSlider durationSlider = new JSlider();
		durationSlider.setMajorTickSpacing(5);
		durationSlider.setMaximum(15);
		durationSlider.setMinorTickSpacing(1);
		durationSlider.setMinimum(5);
		durationSlider.setBounds(186, 240, 228, 16);
		frmSetup.getContentPane().add(durationSlider);
		
		JLabel lnlMinWeeks = new JLabel("5");
		lnlMinWeeks.setBounds(186, 252, 32, 23);
		frmSetup.getContentPane().add(lnlMinWeeks);
		
		JLabel lblMaxWeeks = new JLabel("15");
		lblMaxWeeks.setBounds(412, 256, 24, 15);
		frmSetup.getContentPane().add(lblMaxWeeks);
		
		JSlider difficultySlider = new JSlider();
		difficultySlider.setPaintLabels(true);
		difficultySlider.setMaximum(2);
		difficultySlider.setMinorTickSpacing(1);
		difficultySlider.setBounds(186, 161, 228, 16);
		frmSetup.getContentPane().add(difficultySlider);
		
		JLabel lblMaxDifficulty = new JLabel("2");
		lblMaxDifficulty.setBounds(412, 175, 24, 15);
		frmSetup.getContentPane().add(lblMaxDifficulty);
		
		JLabel lnlMinDifficulty = new JLabel("0");
		lnlMinDifficulty.setBounds(186, 171, 32, 23);
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
		btnConfirm.setBounds(204, 301, 117, 25);
		frmSetup.getContentPane().add(btnConfirm);
		
		JLabel lblWelcomeToSport = new JLabel("Welcome to the Team Manager game");
		lblWelcomeToSport.setBounds(138, 12, 276, 15);
		frmSetup.getContentPane().add(lblWelcomeToSport);
		
		JLabel label = new JLabel("1");
		label.setBounds(297, 175, 24, 15);
		frmSetup.getContentPane().add(label);
		
		
	}
}
