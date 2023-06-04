package lecture;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox checkbox = new JCheckBox("Edit");
		checkbox.setBounds(110, 21, 234, 29);
		panel.add(checkbox);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(110, 69, 234, 130);
		panel.add(textField);
		textField.setColumns(10);
		
		checkbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(checkbox.isSelected());
			}
			
		});
		

	}
}
