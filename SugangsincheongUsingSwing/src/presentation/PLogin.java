package presentation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin extends JPanel{
	
	private CLogin cLogin;
	private PSugangsincheong pSugangsincheon;
	JButton btn1;
	
	public PLogin() {
		pSugangsincheon = new PSugangsincheong();
		
		pSugangsincheon.setVisible(false);
		this.setSize(600, 400);
		this.setBackground(Color.CYAN);
		this.setLayout(new BorderLayout());
		
		
		btn1 = new JButton("다른 창 띄우기");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pSugangsincheon.setVisible(true);
			}
			
		});
		this.add(btn1, BorderLayout.NORTH);
	}
	
	public VUserInfo login(Scanner sc) {
		
		
		
		System.out.println("사용자 아이디를 입력하세요");
		String userId = sc.next();
		System.out.println("사용자 아이디를 입력하세요");
		String password = sc.next();
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		
		cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin);
		if (vUserInfo == null) {
			System.out.println("잘 못 입력하셨습니다.");
		} else {
			System.out.println(vUserInfo.getName() + "님 안녕하세요");
			
		}
		
		return vUserInfo;
	}

}
