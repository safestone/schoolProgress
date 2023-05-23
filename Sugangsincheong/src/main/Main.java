package main;
import java.util.Scanner;
import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;


public class Main {
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong pSugangsincheong;
	
	public Main() {
		
	}
	private void run() {
		Scanner keyboard = new Scanner(System.in);
		pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login(keyboard);
		
		if(vUserInfo != null) {
			pSugangsincheong = new PSugangsincheong();
			pSugangsincheong.run(vUserInfo, keyboard);
		} else {
			
		}
		keyboard.close();
		
		
		
	}
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}


}
