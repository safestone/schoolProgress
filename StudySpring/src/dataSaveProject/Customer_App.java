package dataSaveProject;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_App {

	private JFrame frame;
	private JTextField txtEnterId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/pc/git/schoolProgress/StudySpring/image/Welcome.jpg").getImage());
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		frame.getContentPane().add(welcomePanel);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel.setBounds(307, 236, 120, 36);
		welcomePanel.add(lblNewLabel);
		
		txtEnterId = new JTextField();
		txtEnterId.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		txtEnterId.setToolTipText("Enter ID");
		txtEnterId.setBounds(307, 280, 283, 36);
		welcomePanel.add(txtEnterId);
		txtEnterId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		passwordField.setBounds(307, 326, 283, 36);
		welcomePanel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("ID :\r\n");
		lblNewLabel_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(251, 279, 53, 36);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PW :");
		lblNewLabel_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(251, 326, 53, 36);
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pc\\git\\schoolProgress\\StudySpring\\image\\pig.jpg"));
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(251, 372, 341, 177);
		welcomePanel.add(btnNewButton);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
}