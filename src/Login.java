import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		frame = new JFrame();
		frame.setBounds(0, 0, screenWidth, screenHeight);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, screenWidth, screenHeight);
		panel.setBackground(Color.black);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		int fieldWidth = screenWidth/5;
		int fieldHeight = screenHeight/10;
		textField.setBounds(screenWidth/2 - fieldWidth/2, screenHeight*2/5, fieldWidth, fieldHeight);
		panel.add(textField);
		textField.setColumns(10);
		
		int buttonWidth = fieldWidth/2;
		int buttonHeight = fieldHeight;
		int buttonX = textField.getX();
		int buttonY = textField.getY() + fieldHeight;
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		btnPlay.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		panel.add(btnPlay);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Start.main(null);
			}
		});
		btnNewButton_1.setBounds(buttonX + buttonWidth, buttonY, buttonWidth, buttonHeight);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(220, 122, 46, 14);
		panel.add(lblNewLabel);
	}
}
