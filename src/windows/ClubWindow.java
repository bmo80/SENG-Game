package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mainMenus.MainGame;

/**
 * Deals with displaying the options for the players club
 * @author Blair Brydon
 * @author Ben Moore
 *
 */
public class ClubWindow {

	/**
	 * Varaible to store the current frame
	 */
	private JFrame frmClub;
	/**
	 * Variable to store the current maingame object
	 */
	private MainGame game;
	/**
	 * Variable to store the main menu window
	 */
	private JFrame mainMenu;

	/**
	 * Constructor for the ClubWindow. Inits required variables and frame
	 * @param currentGame current instance of maingame
	 * @param window the MainWindow 
	 */
	public ClubWindow(MainGame currentGame, JFrame window) {
		mainMenu = window;
		game = currentGame;
		initialize();
		frmClub.setVisible(true);
	}
	
	/**
	 * Closes the current window and opens the main screen
	 */
	public void closeWindow() {
		mainMenu.setVisible(true);
		frmClub.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClub = new JFrame();
		frmClub.setTitle("Club");
		frmClub.setBounds(100, 100, 526, 299);
		frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClub.getContentPane().setLayout(null);
		
		JLabel lblMoney = new JLabel(String.format("Money: $%s",
				game.getMoney()));
		lblMoney.setBounds(12, 12, 502, 15);
		frmClub.getContentPane().add(lblMoney);
		
		JLabel lblWeek = new JLabel(String.format("Week: %s",
				game.getWeek()));
		lblWeek.setBounds(12, 28, 83, 15);
		frmClub.getContentPane().add(lblWeek);
		
		
		JLabel lblWelcome = new JLabel("Welcome to the Club!");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(12, 28, 502, 15);
		frmClub.getContentPane().add(lblWelcome);
		
		
		JButton btnViewTeam = new JButton("View Team");
		btnViewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClub.dispose();
				TeamWindow window = new TeamWindow(game, mainMenu);
			}
		});
		btnViewTeam.setBounds(35, 94, 195, 70);
		frmClub.getContentPane().add(btnViewTeam);
		
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClub.dispose();
				InventoryWindow window = new InventoryWindow(game,
						mainMenu);
			}
		});
		btnViewInventory.setBounds(265, 94, 195, 70);
		frmClub.getContentPane().add(btnViewInventory);
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnGoBack.setBounds(193, 204, 117, 25);
		frmClub.getContentPane().add(btnGoBack);
	}

}
