package main;
import java.util.Scanner;
import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;


public class Main {

	private void run() {
		Scanner sc = new Scanner(System.in);
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login(sc);
		
		if(vUserInfo != null) {
			PSugangsincheong pSugangsincheong = new PSugangsincheong();
			pSugangsincheong.run(vUserInfo, sc);
		} else {
			
		}
		sc.close();
		
		
		
	}
	public static void main(String[] args) {
		Main main = new Main(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}


}
