package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong extends JPanel {
	private PLectureSelection pLectureSelection;
	private PLectureBasket pMiridamgiBasket;
	private PLectureBasket pSincheongBaskt;
	
	public PSugangsincheong() {
		this.setBackground(Color.black);
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.pSincheongBaskt = new PLectureBasket();
		
		this.add(this.pLectureSelection);
		this.pLectureSelection.setBackground(Color.RED);
		
		this.add(this.pMiridamgiBasket);
		this.pMiridamgiBasket.setBackground(Color.BLUE);
		
		this.add(this.pSincheongBaskt);
		this.pSincheongBaskt.setBackground(Color.GREEN);
		
		
	}
	
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean bRunning = true;
		while(bRunning) {
			System.out.println("0.강좌 선택 1.미리담기 2.수강신청 9.종료");
			
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			switch (selection) {
			case 0:
				vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
				break;
			case 1:
				pMiridamgiBasket.add(vLecture);
				pMiridamgiBasket.show();
				break;
			case 2:
				pSincheongBaskt.add(vLecture);
				pSincheongBaskt.show();
				break;
			case 9:
				bRunning = false;
				System.out.println("종료되었습니다.");
				break;
			default:
				break;
			}
		}

	}
}


