package main;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;

import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;


public class PMainFrame extends JFrame{
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong pSugangsincheong;
	
	public PMainFrame() {
		this.setSize(600, 400);
		
		pSugangsincheong = new PSugangsincheong();
		
		this.add(pSugangsincheong);
	}
	
	private void run() {
		Scanner keyboard = new Scanner(System.in);
		VUserInfo vUserInfo = pLogin.login(keyboard);
		
		if(vUserInfo != null) {
			pSugangsincheong = new PSugangsincheong();
			pSugangsincheong.run(vUserInfo, keyboard);
		} else {
			
		}
		keyboard.close();
		
		
		
	}
	public static void main(String[] args) {
//		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
//		main.run();
		PMainFrame MainFrame = new PMainFrame();
		MainFrame.setVisible(true);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
