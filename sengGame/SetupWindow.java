package sengGame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SetupWindow {

	private JFrame frame;
	private MainGame game;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetupWindow window = new SetupWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SetupWindow(MainGame getGame) {
		game = getGame;
		initialize();
		frame.setVisible(true);		
	}

	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
