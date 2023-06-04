package lecture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	public Login() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID: ");
		JLabel labelPW = new JLabel("PW: ");
		JTextField txtId = new JTextField(10);
		JPasswordField txtPW = new JPasswordField(10);
		JButton logBtn = new JButton("로그인");
		
		panel.add(label);
		panel.add(txtId);
		panel.add(labelPW);
		panel.add(txtPW);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = "1234";
				String pw = "1234";
				
				if(id.equals(txtId.getText()) && id.equals(txtPW.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 되셨습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.");
				}
			}
			
		});
		add(panel);
		
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new Login();
	}

}
