package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SellPlayerWindow {

	private JFrame frmManageTeam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellPlayerWindow window = new SellPlayerWindow();
					window.frmManageTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SellPlayerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageTeam = new JFrame();
		frmManageTeam.setTitle("Manage Team");
		frmManageTeam.setBounds(100, 100, 450, 300);
		frmManageTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageTeam.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(12, 12, 70, 15);
		frmManageTeam.getContentPane().add(lblMoney);
		
		JLabel displayMoney = new JLabel(String.valueOf(money));
		displayMoney.setBounds(72, 12, 70, 15);
		frmManageTeam.getContentPane().add(displayMoney);
		
		
		JLabel lblWeek = new JLabel("Week:");
		lblWeek.setBounds(12, 28, 70, 15);
		frmManageTeam.getContentPane().add(lblWeek);
		
		JLabel weekNum = new JLabel(String.valueOf(week)+"/5");
		weekNum.setBounds(72, 28, 70, 15);
		frmManageTeam.getContentPane().add(weekNum);
	}
}